package com.wondersgroup.scxj.portal.modules.sys.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.wondersgroup.scxj.portal.common.config.Global;

// http://efreedom.com/Question/1-3545992/Password-Based-Encryption-Using-AES-Java-JCE
// http://www.coderanch.com/t/417428/java/java/Enryption-Java#1840043
public class SecurityUtils {


	private static final String MESSAGE_DIGEST_ALGORITHM = "MD5";

	private static final String CHARACTER_ENCODING = "UTF-8";

	private static final String ENCRYPTION_ALGORITHM = "AES";

	private static final String STRING_DELIMITER = ",";

	private static final String SYS_PASSWORD = "sys.password";

	private static final byte[] PBE_SALT = getFixedPbeSalt();

	public static final String USER_KEY = "userkey";

	private static byte[] getRandomPbeSalt() {
		SecureRandom rand = null;
		try {
			rand = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
		}
		byte[] salt = new byte[16];
		rand.nextBytes(salt);
		return salt;
	}

	private static byte[] getFixedPbeSalt() {
		return new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
				0x08, 0x09, 0x0a, 0x0b, 0x0e, 0x0f };
	}


	/**
	 * userkey = {username,timestamp,hash}aes_key
	 */
	public static String generateUserKey(String userName) {
		String tempUserName = (userName == null ? "" : userName);
		byte[] bytes = null;
		try {
			bytes = getPlain(tempUserName).getBytes(CHARACTER_ENCODING);
		} catch (UnsupportedEncodingException e) {
//			logger.debug(e);
		}
		return getText(doEncryption(bytes));
	}

	private static String getPlain(String userName) {
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
		String hash = getText(computeHash(userName, timestamp));
		String plain = new StringBuilder().append(userName).append(
				STRING_DELIMITER).append(timestamp).append(STRING_DELIMITER)
				.append(hash).toString();
//		logger.debug("username,timestamp,hash = " + plain);
		return plain;
	}

	private static byte[] doEncryption(byte[] plain) {
		try {
			Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, getKey());
			InputStream in = new ByteArrayInputStream(plain);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			crypt(in, out, cipher);
			return out.toByteArray();
		} catch (NoSuchAlgorithmException e) {
//			logger.debug(e);
		} catch (NoSuchPaddingException e) {
//			logger.debug(e);
		} catch (InvalidKeyException e) {
//			logger.debug(e);
		} catch (IllegalBlockSizeException e) {
//			logger.debug(e);
		} catch (BadPaddingException e) {
//			logger.debug(e);
		} catch (IOException e) {
//			logger.debug(e);
		} catch (GeneralSecurityException e) {
//			logger.debug(e);
		}
		return null;
	}

	public static String decryptUserKey(String userKey) {
		String plain = new String(doDecryption(getBytes(userKey)));
//		logger.debug("username,timestamp,hash = " + plain);
		return getUserName(plain);
	}

	private static byte[] doDecryption(byte[] encrypted) {
		try {
			Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, getKey());
			InputStream in = new ByteArrayInputStream(encrypted);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			crypt(in, out, cipher);
			return out.toByteArray();
		} catch (NoSuchAlgorithmException e) {
//			logger.debug(e);
		} catch (NoSuchPaddingException e) {
//			logger.debug(e);
		} catch (InvalidKeyException e) {
//			logger.debug(e);
		} catch (IllegalBlockSizeException e) {
//			logger.debug(e);
		} catch (BadPaddingException e) {
//			logger.debug(e);
		} catch (IOException e) {
//			logger.debug(e);
		} catch (GeneralSecurityException e) {
//			logger.debug(e);
		}
		return null;
	}

	private static String getUserName(String plain) {
		// get components in the plain
		String[] components = plain.split(STRING_DELIMITER);
		String userName = components[0];
		String timestamp = components[1];
		String hash = components[2];
		String computedHash = null;
		computedHash = getText(computeHash(userName, timestamp));
//		logger.debug("computedHash = " + computedHash);

		// check hash
		if (!hash.equals(computedHash)) {
			return null;
		}

		// check timestamp
		long currentTimestamp = System.currentTimeMillis() / 1000;
		long requestTimestamp = Long.valueOf(timestamp);
//		logger.debug("(requestTimestamp, currentTimestamp) = ("
//				+ requestTimestamp + "," + currentTimestamp + ")");
		if (Math.abs(currentTimestamp - requestTimestamp) > 60 * 30) {
			return null;
		}

		return userName;
	}

	private static void crypt(InputStream in, OutputStream out, Cipher cipher)
			throws IOException, GeneralSecurityException {
		int blockSize = cipher.getBlockSize();
		int outputSize = cipher.getOutputSize(blockSize);
		byte[] inBytes = new byte[blockSize];
		byte[] outBytes = new byte[outputSize];

		int inLength = 0;
		boolean more = true;
		while (more) {
			inLength = in.read(inBytes);
			if (inLength == blockSize) {
				int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
				out.write(outBytes, 0, outLength);
			} else
				more = false;
		}
		if (inLength > 0)
			outBytes = cipher.doFinal(inBytes, 0, inLength);
		else
			outBytes = cipher.doFinal();
		out.write(outBytes);
	}

	public static Key getKey() {
		Key secret = null;
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-1");
			byte[] hash = md.digest(getPassword().getBytes("UTF-8"));
			int AES_KEY_LENGTH = 16;
			byte[] aesKey = new byte[AES_KEY_LENGTH];
			for (int i = 0; i < hash.length && i < aesKey.length; i++) {
				aesKey[i] = hash[i];
			}
			secret = new SecretKeySpec(aesKey, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// this will never happy
		}
		return secret;
	}
	
	public static Key getKeyWithHmacSHA1() {
		try {
			PBEKeySpec password = new PBEKeySpec(getPassword().toCharArray(),
					PBE_SALT, 1000, 128);
			SecretKeyFactory factory = SecretKeyFactory
					.getInstance("PBKDF2WithHmacSHA1");
			PBEKey key = (PBEKey) factory.generateSecret(password);
			SecretKey encKey = new SecretKeySpec(key.getEncoded(),
					ENCRYPTION_ALGORITHM);
			return encKey;
		} catch (NoSuchAlgorithmException e) {
//			logger.debug(e);
		} catch (InvalidKeySpecException e) {
//			logger.debug(e);
		}
		return null;
	}

	private static String getPassword() {
		return Global.getConfig(SYS_PASSWORD);
	}

	private static byte[] computeHash(String userName, String timestamp) {
		try {
			MessageDigest digest = MessageDigest
					.getInstance(MESSAGE_DIGEST_ALGORITHM);
			digest.update(userName.getBytes(CHARACTER_ENCODING));
			digest.update(String.valueOf(timestamp)
					.getBytes(CHARACTER_ENCODING));
			return digest.digest();
		} catch (NoSuchAlgorithmException e) {
//			logger.debug(e);
		} catch (UnsupportedEncodingException e) {
//			logger.debug(e);
		}
		return null;
	}

	private static String getText(byte[] hash) {
		String d = "";
		for (int i = 0; i < hash.length; i++) {
			int v = hash[i] & 0xFF;
			if (v < 16)
				d += "0";
			d += Integer.toString(v, 16).toUpperCase();
		}
		return d;
	}

	private static byte[] getBytes(String text) {
		int length = text.length() / 2;
		byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			bytes[i] = (byte) Integer.valueOf(
					text.substring(2 * i, 2 * (i + 1)), 16).shortValue();
		}
		return bytes;
	}
	
	private static byte[] getHashStr(String userName) {
		try {
			MessageDigest digest = MessageDigest
					.getInstance(MESSAGE_DIGEST_ALGORITHM);
			digest.update(userName.getBytes(CHARACTER_ENCODING));
			return digest.digest();
		} catch (NoSuchAlgorithmException e) {
//			logger.debug(e);
		} catch (UnsupportedEncodingException e) {
//			logger.debug(e);
		}
		return null;
	}
	
	/**
	 * 字符串通过MD5加密后
	 * 
	 * @param str
	 * @return
	 */
	public static String getMD5Str(String str) {
		if (str != null) {
			MessageDigest msgDigest = null;
			try {
				msgDigest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		    msgDigest.update(str.getBytes());
			byte []bytes = msgDigest.digest();
			StringBuffer strBuf = new StringBuffer();
			for (int i = 0; i < bytes.length; i++) { // 字节数组转换成十六进制字符串，形成最终的密文
				int val = bytes[i] & 0xff;
				if (val < 16) {
					strBuf.append(0);
				}
				strBuf.append(Integer.toHexString(val));
			}
			return strBuf.toString();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		String encrypted = generateUserKey("useradmin");
		System.out.println(encrypted);
		System.out.println(decryptUserKey(encrypted));
	}
}
