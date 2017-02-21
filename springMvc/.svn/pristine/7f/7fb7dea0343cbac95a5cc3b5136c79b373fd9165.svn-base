package com.wkb.core.security;

import java.security.MessageDigest;

import com.wkb.common.util.SecurityProperties;
import com.wkb.core.util.GenerateUniqueCode;
import com.wkb.core.util.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 加密解密
 * @author huanglt
 *
 */
public class WkbCryption {

	private final static String defaultSalt="ffwier@jl$(flHjlfH";
	private static Logger logger=LoggerFactory.getLogger(WkbCryption.class);
	/**
	 * 使用MD5加密
	 * @param s 要加密的字符串
	 * @return
	 */
	public static String Md5Encryption(String s){
		if(s == null){
			return null;
		}
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}
		char[] charArray = s.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		for (int i = 0; i < charArray.length; i++){
			byteArray[i] = (byte) charArray[i];
		}
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16){
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	
	/**
	 * 本平台下的加盐加密
	 * @param s 要加密的字符串
	 * @param salt 盐值
	 * @return
	 */
	public static String md5EncryptionWithSalt(String s,String salt){
		if(s == null){
			return null;
		}
		String baseSalt=SecurityProperties.getInstance().getProperty("user.salt");
		if(Tools.isEmpty(baseSalt)){
			baseSalt=defaultSalt;
		}
		if(Tools.isEmpty(salt)){
			salt=defaultSalt;
		}
		s=Md5Encryption(Md5Encryption(baseSalt+s)+salt);
		return s;
	}
	
	public static void main(String[] args){
		String uuid=GenerateUniqueCode.getUUID();
		System.out.println("UUID为："+uuid);
		System.out.println("admin@123加密后为："+md5EncryptionWithSalt("admin@123",uuid));
	}
}
