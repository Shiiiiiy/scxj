package com.wondersgroup.scxj.portal.modules.sys.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.openid4java.consumer.ConsumerException;
import org.openid4java.consumer.ConsumerManager;
import org.openid4java.consumer.VerificationResult;
import org.openid4java.discovery.DiscoveryException;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.discovery.Identifier;
import org.openid4java.message.AuthRequest;
import org.openid4java.message.AuthSuccess;
import org.openid4java.message.MessageException;
import org.openid4java.message.MessageExtension;
import org.openid4java.message.ax.AxMessage;
import org.openid4java.message.ax.FetchRequest;
import org.openid4java.message.ax.FetchResponse;
import org.openid4java.message.sreg.SRegMessage;
import org.openid4java.message.sreg.SRegResponse;
import org.openid4java.util.HttpClientFactory;
import org.openid4java.util.ProxyProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wondersgroup.scxj.portal.modules.sys.entity.User;

/**
 * This is OpenID authenticator for Shiro which uses OpenId4j.
 * <p>
 * Because OpenId need browser redirection authentication starts with trying to
 * authenticate with {@code OpenIdRequestAuthenticationToken}. This will always
 * throw exception. If everything goes well the exception is
 * {@code OpenIdRequiresRedirectToken}. It contains URL-where user should be
 * redirected.
 * <p>
 * After redirection user returns to the url set to the first token
 * {@code OpenIdRequestAuthenticationToken}. The response given back from OpenID
 * provider is verified using {@code OpenIdVerifyAuthenticationToken}.
 * <p>
 * Override
 * {@link #createSuccessfulAuthenticationInfo(DiscoveryInformation, AuthSuccess)}
 * to handle special authentication needs of you application (loading user from
 * the database etc.).
 * 
 * @author Panu Wetterstrand <panu.wetterstrand@iki.fi>
 */
@Service
public class OpenIdAuthenticatorRealm implements Authenticator, Realm {

	private static final Logger log = LoggerFactory
			.getLogger(OpenIdAuthenticatorRealm.class);

	private ConsumerManager manager;
	private Collection<AxAttribute> requestedAxAttributes = Collections
			.synchronizedList(new ArrayList<AxAttribute>());

	public OpenIdAuthenticatorRealm() {
		try {
			manager = new ConsumerManager();
		} catch (ConsumerException ex) {
			log.error("OpenID Authentication failed", ex);
			throw new AuthenticationException("OpenID Authentication failed",
					ex);
		}
	}

	@Override
	public final AuthenticationInfo authenticate(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {
		if (authenticationToken instanceof OpenIdRequestAuthenticationToken) {
			try {

				// --- Forward proxy setup (only if needed) ---
//				ProxyProperties proxyProps = new ProxyProperties();
//				proxyProps.setProxyHostName("10.1.2.188");
//				proxyProps.setProxyPort(80);
//				HttpClientFactory.setProxyProperties(proxyProps);
				
				OpenIdRequestAuthenticationToken token = (OpenIdRequestAuthenticationToken) authenticationToken;
				// perform discovery on the user-supplied identifier
				final String userSupliedOpenId = token.getUserSupliedOpenId();
				final String returnToUrl = token.getReturnToUrl();
				List discoveries = manager.discover(userSupliedOpenId);
				// attempt to associate with the OpenID provider
				// and retrieve one service endpoint for authentication
				final DiscoveryInformation discovered = manager
						.associate(discoveries);

				// store the discovery information in the user's session
				SecurityUtils.getSubject().getSession()
						.setAttribute("openid-disc", discovered);

				// obtain a AuthRequest message to be sent to the OpenID
				// provider
				AuthRequest authReq = manager.authenticate(discovered,
						returnToUrl);

				// Attribute Exchange example: fetching the 'email' attribute
				FetchRequest fetch = FetchRequest.createFetchRequest();

				for (AxAttribute attribute : requestedAxAttributes) {
					fetch.addAttribute(attribute.getName(),
							attribute.getAttributeIdentifier(), true);
				}
				fetch.addAttribute("userId",
						"http://schema.openid.net/homolo/user/user-id", true, 1);
				fetch.addAttribute("personId",
						"http://schema.openid.net/homolo/user/person-id", true,
						1);
				fetch.addAttribute("nickName",
						"http://schema.openid.net/homolo/user/nick-name", true,
						1);
				fetch.addAttribute("userName",
						"http://schema.openid.net/homolo/user/user-name", true,
						1);

				// attach the extension to the authentication request
				authReq.addExtension(fetch);

				final SimplePrincipalCollection principals = new SimplePrincipalCollection();
				principals.add(new Principal(authReq.getDestinationUrl(true)),
						getName());
				return new AuthenticationInfo() {
					@Override
					public PrincipalCollection getPrincipals() {
						return principals;
					}

					@Override
					public Object getCredentials() {
						return "Openid login from "
								+ discovered.getOPEndpoint();
					}
				}; // Authenticated

			} catch (MessageException ex) {
				log.error("OpenID Authentication failed", ex);
				throw new AuthenticationException(
						"OpenID Authentication failed", ex);
			} catch (ConsumerException ex) {
				log.error("OpenID Authentication failed", ex);
				throw new AuthenticationException(
						"OpenID Authentication failed", ex);
			} catch (DiscoveryException ex) {
				log.error("OpenID Authentication failed", ex);
				throw new AuthenticationException(
						"OpenID Authentication failed", ex);
			}
		}

		if (authenticationToken instanceof OpenIdVerifyAuthenticationToken) {
			try {
				final OpenIdVerifyAuthenticationToken token = (OpenIdVerifyAuthenticationToken) authenticationToken;
				final DiscoveryInformation discovered = (DiscoveryInformation) SecurityUtils
						.getSubject().getSession().getAttribute("openid-disc");

				// verify the response; ConsumerManager needs to be the same
				// (static) instance used to place the authentication request
				VerificationResult verification = manager.verify(
						token.getReceivingUrl(), token.getResponse(),
						discovered);

				// examine the verification result and extract the verified
				// identifier
				final Identifier verified = verification.getVerifiedId();
				if (verified != null) {
					final AuthSuccess authSuccess = (AuthSuccess) verification
							.getAuthResponse();
					String userId = null;
					String personId = null;
					String nickName = null;
					String userName = null;
					if (authSuccess.hasExtension(SRegMessage.OPENID_NS_SREG)) {
						MessageExtension ext = authSuccess
								.getExtension(SRegMessage.OPENID_NS_SREG);
						if (ext instanceof SRegResponse) {
							SRegResponse regResp = (SRegResponse) ext;
							userId = regResp.getAttributeValue("userId");
							personId = regResp.getAttributeValue("personId");
							nickName = regResp.getAttributeValue("nickName");
							userName = regResp.getAttributeValue("userName");
						}
					} else if (authSuccess.hasExtension(AxMessage.OPENID_NS_AX)) {
						MessageExtension ext = authSuccess
								.getExtension(AxMessage.OPENID_NS_AX);
						if (ext instanceof FetchResponse) {
							FetchResponse fetchResp = (FetchResponse) ext;
							userId = ((List<String>) fetchResp
									.getAttributeValues("userId")).get(0);
							personId = ((List<String>) fetchResp
									.getAttributeValues("personId")).get(0);
							nickName = ((List<String>) fetchResp
									.getAttributeValues("nickName")).get(0);
							userName = ((List<String>) fetchResp
									.getAttributeValues("userName")).get(0);

							// 取到用户信息，注册并确认用户登录成功
						}
					}
					log.debug("OpenID Authentication success " + userId);
					log.debug("OpenID Authentication success " + personId);
					log.debug("OpenID Authentication success " + nickName);
					log.debug("OpenID Authentication success " + userName);
					if (StringUtils.isBlank(userId))
						;// OpenID中没有提供Email信息
					// 后续的处理

					return createSuccessfulAuthenticationInfo(discovered,
							authSuccess, personId);

				}
			} catch (Exception ex) {
				log.error("OpenID Authentication failed", ex);
				throw new AuthenticationException(
						"OpenID Authentication failed", ex);
			}
		}
		throw new AuthenticationException("OpenID Authentication failed");
	}

	protected AuthenticationInfo createSuccessfulAuthenticationInfo(
			final DiscoveryInformation discovered,
			final AuthSuccess authSuccess, final String personId)
			throws AuthenticationException {

		OpenIdAuthentication openIdAuthentication = new OpenIdAuthentication(
				authSuccess.getClaimed(), personId);
		User user = new User();
		user.setLoginName(personId);
		Principal principal = new Principal(user);
		final SimplePrincipalCollection principals = new SimplePrincipalCollection();
		principals.add(openIdAuthentication, getName());
		return new AuthenticationInfo() {
			@Override
			public PrincipalCollection getPrincipals() {
				return principals;
			}

			@Override
			public Object getCredentials() {
				return "Openid login from " + discovered.getOPEndpoint();
			}
		};
	}

	@Override
	public String getName() {
		return "openid";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return (token instanceof OpenIdVerifyAuthenticationToken)
				|| (token instanceof OpenIdRequestAuthenticationToken);
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		return authenticate(token);
	}

	public Collection<AxAttribute> getRequestedAxAttributes() {
		return this.requestedAxAttributes;
	}

	/**
	 * Add AX extension attribute that is requested from the OpenId-provider
	 * when authenticating user.
	 * <p>
	 * For example
	 * 
	 * <pre>
	 * requestAttribute(new AxAttribute(&quot;lastname&quot;,
	 * 		&quot;http://axschema.org/namePerson/last&quot;));
	 * </pre>
	 * 
	 * @param axAttribute
	 */
	public void requestAttribute(AxAttribute axAttribute) {
		this.requestedAxAttributes.add(axAttribute);
	}

}