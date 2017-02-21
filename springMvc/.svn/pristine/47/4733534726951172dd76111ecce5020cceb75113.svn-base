package com.wkb.core.util;

import java.util.Date;

import com.wkb.common.util.Constant;
import com.wkb.core.util.Tools;

public class InsuranceUtil {
	private static InsuranceUtil  insuranceUtil= new InsuranceUtil();
	private InsuranceUtil() {}
	
	public static InsuranceUtil getInstance(){
		return insuranceUtil;
	}
	
	/**
	 * 根据单位计算推后多少时间
	 * @return
	 * @param date  日期
	 * @param timeUnit  单位
	 * @param num  推迟多少时间
	 * @throws Exception 
	 * getDate(new Date(), startInsTerminationType,startInsDay)
	 */
	public Date getDate (Date date,Integer timeUnit,Integer num) throws Exception {
		return getDate(date, timeUnit, num, 1);
	}
	/**
	 * 根据单位计算推后多少时间
	 * @return
	 * @param date  日期
	 * @param timeUnit  单位
	 * @param num  推迟多少时间
	 * @param flag 计算规则标识0：起期；1：止期
	 * @throws Exception 
	 */
	public Date getDate (Date date,Integer timeUnit,Integer num, int flag) throws Exception {
		//如果日期为空，则直接返回null
		if (date == null) return null;
		Date dateResult = new Date();
		if (timeUnit == Constant.INSURANCE_TERMINATION_TYPE.HOUR) {
			//单位为小时
			dateResult = Tools.datePlusHour(date, num);
		} else if (timeUnit == Constant.INSURANCE_TERMINATION_TYPE.DAY) {//单位为天
			//flag为0:计算起期；1:计算止期
			if (flag == 1) {
				dateResult = Tools.getNextDay23Hour(date, num - 1);
			} else {
				dateResult = Tools.getNextDay0Hour(date, num);
			}
		} else if (timeUnit == Constant.INSURANCE_TERMINATION_TYPE.MONTH) {//单位为月
			if (flag == 1) {
				Date temp = Tools.getNextOrLastMonth(date, num, "end");
				dateResult = Tools.getNextDay23Hour(temp, -1);
			} else {
				dateResult = Tools.getNextOrLastMonth(date, num, "start");
			}
		} else if (timeUnit == Constant.INSURANCE_TERMINATION_TYPE.YEAR) {//单位为年
			if (flag == 1) {
				Date temp = Tools.getNextOrLastYear(date, num, "end");
				dateResult = Tools.getNextDay23Hour(temp, -1);
			} else {
				dateResult = Tools.getNextOrLastYear(date, num, "start");
			}
		} else {
			//次日生效
			dateResult = Tools.getNextDay0Hour(date, 1);
		}
		return dateResult;
	}
}
