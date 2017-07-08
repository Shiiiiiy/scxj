package com.wondersgroup.scxj.portal.modules.sys.security;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.openid4java.message.ParameterList;
import org.springframework.stereotype.Service;

@Service
public class OpenIdFilter implements Filter {


    OpenIdAuthenticatorRealm openidAuthenticator = new OpenIdAuthenticatorRealm();
    Pattern stripOpenIdParameters = Pattern.compile("&{0,1}openid\\.[^&]+&{0,1}");
    private String providerUrl = "http://passport3.lawyers.org.cn/openid/";
   
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void setOpenIdProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpResp = (HttpServletResponse) response;
                
        boolean shouldAuthenticate = !SecurityUtils.getSubject().isAuthenticated() || SecurityUtils.getSubject().getPrincipals().oneByType(Principal.class) != null;

        
        if (shouldAuthenticate) {
            if (request.getParameter("openid.ns") == null) {
                String returnToUrl = getFullQueryUrl(httpReq).toString();

                SecurityUtils.getSubject().login(new OpenIdRequestAuthenticationToken(providerUrl, returnToUrl));
                Principal login = SecurityUtils.getSubject().getPrincipals().oneByType(Principal.class);
                httpResp.sendRedirect(login.getAddress());

            } else {
                ParameterList openidresponse =
                        new ParameterList(httpReq.getParameterMap());
                StringBuffer receivingURL = getFullQueryUrl(httpReq);

                SecurityUtils.getSubject().login(new OpenIdVerifyAuthenticationToken(receivingURL.toString(), openidresponse));
                // Authenticated

                Matcher matcher = stripOpenIdParameters.matcher(receivingURL);
                matcher.matches();
                String url = matcher.replaceAll("");
                httpResp.sendRedirect(url);

            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

    private StringBuffer getFullQueryUrl(HttpServletRequest httpReq) {
        // extract the receiving URL from the HTTP request
        StringBuffer receivingURL = httpReq.getRequestURL();
        String queryString = httpReq.getQueryString();
        if (queryString != null && queryString.length() > 0) {
            receivingURL.append("?").append(httpReq.getQueryString());
        }
        return receivingURL;
    }
   
}
