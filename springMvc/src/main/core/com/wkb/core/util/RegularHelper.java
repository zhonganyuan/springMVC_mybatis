package com.wkb.core.util;

import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 * @author huanglt
 *
 */
public class RegularHelper {

	public static final String TELEPHONE="^((\\(\\d{3}\\))|(\\d{3}\\-))?13[0-9]\\d{8}?$|15[0-9]\\d{8}?$|17[0-9]\\d{8}?$|14[0-9]\\d{8}?$|18[0-9]\\d{8}?$";
	
	/**
	 * 是否是手机号
	 * @param phoneNum 手机号码
	 * @return
	 */
	public static boolean isTelephone(String phoneNum){
		return Pattern.matches(TELEPHONE,phoneNum);
	}
	
	public static boolean isMatch(String regex,String target){
		return Pattern.matches(regex, target);
	}
	
	public static void main(String[] args){
		System.out.println("18763975021是手机号吗："+isTelephone("18763975021"));
	}
}
