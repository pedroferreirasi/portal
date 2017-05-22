package br.com.informa.libraries.common;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonMethods {
	
	@SuppressWarnings("rawtypes")
	private static final Class FACTORY_CLASS = CommonMethods.class;
	
	private CommonMethods()	{ }
	
	
	public static CommonMethods getInstance()
	{
		try {
			return (CommonMethods) FACTORY_CLASS.newInstance();
		} catch (InstantiationException e) {
			Logger.getGlobal().log(Level.SEVERE,"",e);
			throw new RuntimeException();
		} catch (IllegalAccessException e) {
			Logger.getGlobal().log(Level.SEVERE,"",e);
			throw new RuntimeException();
		}
	}

	public String SHA256(String password, String LoginName)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update((LoginName.trim() + password.trim()).getBytes("ASCII"), 0,
				(LoginName.trim() + password.trim()).getBytes("ASCII").length);
		return bytesToHex(md.digest());
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuffer result = new StringBuffer();
		for (byte byt : bytes)
			result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(
					1));
		return result.toString();
	}

	public ByteBuffer StringToByteBuffer(String value, String charsetName) {
		ByteBuffer bb = ByteBuffer.allocate(value.length());
		if (charsetName != null && charsetName.length() > 0) {
			bb = ByteBuffer.wrap(value.getBytes(Charset.forName(charsetName)));
		} else {
			bb = ByteBuffer.wrap(value.getBytes(Charset.forName("UTF-8")));
		}
		return bb;
	}

	public String ByteBufferToString(ByteBuffer value, String charsetName) {
		String st = "";
		if (charsetName != null && charsetName.length() > 0) {
			st = new String(value.array(), Charset.forName(charsetName));
		} else {
			st = new String(value.array(), Charset.forName("UTF-8"));
		}
		return st;
	}
}
