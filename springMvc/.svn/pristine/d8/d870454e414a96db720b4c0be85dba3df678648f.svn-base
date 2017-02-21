package com.wkb.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class WkbDateUtil {
	

	public static final String DATE_FORMAT = "yyyyMMddHHmmss";
	
	public static final String DATE_FORMAT_TODAY = "yyyyMMdd";
	
	public static final String DATE_FORMAT_DAY_END = "yyyyMMdd235959";
	
	public static final String DATE_FORMAT_STANDARD = "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATE_FORMAT_YEAR_MONTH_DAY = "yyyy年MM月dd日";
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	
	/**
	 * 判断日期是否是今天
	 * @param date ： yyyyMMddHHmmss
	 * @return
	 */
	public static boolean isToday(String date) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_FORMAT);
		if(formatter.parseDateTime(date).toString(DATE_FORMAT_TODAY).equals(new DateTime().toString(DATE_FORMAT_TODAY))) {
			return true;
		}
		return false;
		
	}
	
	/**
	 * 获得今天的23时59分59秒
	 * @param args
	 */
	public static String getTodayEnd() {
		return new DateTime().toString(DATE_FORMAT_DAY_END);
	}
	
	/**
	 * 把时间格式转换为标准格式
	 * @param date
	 * @return
	 */
	public static String toStandardFormatByDate(Date date) {
		return new DateTime(date).toString(DATE_FORMAT_STANDARD);
	}
	
	/**
	 * 把时间格式转换获得年月日--yyyy年MM月dd日
	 * @param date
	 * @return
	 */
	public static String getYearMonthDayByDate(Date date) {
		return new DateTime(date).toString(DATE_FORMAT_YEAR_MONTH_DAY);
	}
	
	public static void main(String[] args) {
		System.out.println(getTodayEnd());
	}
}
