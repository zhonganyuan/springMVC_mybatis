package com.wkb.core.util;

import java.awt.Color;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloopen.rest.sdk.utils.encoder.BASE64Encoder;
import com.wkb.common.util.Constant;
import com.wkb.common.util.EnumsProperties;
import com.wkb.common.util.SecurityProperties;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author Administrator
 * 
 */
public class Tools {

	public static final String FORMAT_L6 = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_L5 = "yyyy-MM-dd HH:mm";
	public static final String FORMAT_L4 = "yyyy-MM-dd HH";
	public static final String FORMAT_L3 = "yyyy-MM-dd";
	public static final String FORMAT_L7 = "yyyyMMddHHmmss";
	public static final String FORMAT_L8 = "yyyy年MM月dd日";
	private static Logger logger=LoggerFactory.getLogger(Tools.class);
	private static final String DEFAULT_UPDIR="/upload";

	/**
	 * 检测字符串是否不为空(null,"","null")
	 * 
	 * @param s
	 * @return 不为空则返回true，否则返回false
	 */
	public static boolean notEmpty(String s) {
		return s != null && !"".equals(s.trim()) && !"null".equals(s.trim());
	}

	/**
	 * 检测字符串是否为空(null,"","null")
	 * 
	 * @param s
	 * @return 为空则返回true，不否则返回false
	 */
	public static boolean isEmpty(String s) {
		return s == null || "".equals(s.trim()) || "null".equals(s.trim());
	}

	/**
	 * 检测Integer是否为空(null,"","null",0)
	 * 
	 * @param s
	 * @return 为空则返回true，不否则返回false
	 */
	public static boolean isEmpty(Integer v) {
		return v == null || "".equals(v) || "null".equals(v) || 0 == v;
	}
	/**
	 * 检测Long是否为空(null,"","null",0)
	 * 
	 * @param s
	 * @return 为空则返回true，不否则返回false
	 */
	public static boolean isEmpty(Long v) {
		return v == null || "".equals(v) || "null".equals(v) || 0 == v;
	}

	/**
	 * 字符数组转字符串(以，分割)
	 * @param array
	 * @return 
	 */
	public static String strArr2String(String[] array){
		if (array == null || array.length == 0) {
			return "";
		}
		StringBuffer strArray = new StringBuffer();
		for(String data : array){
			if (isEmpty(data)) {
				continue;
			}
			strArray.append(data + ",");
		}
		if (strArray.length() > 0) {
			strArray.deleteCharAt(strArray.length() - 1);
		}
		return strArray.toString();
	}
	/**
	 * 字符串转换为字符串数组
	 * 
	 * @param str
	 *            字符串
	 * @param splitRegex
	 *            分隔符
	 * @return
	 */
	public static String[] str2StrArray(String str, String splitRegex) {
		if (isEmpty(str)) {
			return null;
		}
		return str.split(splitRegex);
	}

	/**
	 * 将字符串以分隔符分隔后放入集合中
	 * 
	 * @param str
	 *            要分隔的字符串
	 * @param format
	 *            分隔符
	 * @return
	 */
	public static Set<String> str2Set(String str, String format) {
		if (isEmpty(str)) {
			return null;
		}
		if (isEmpty(format)) {
			format = ",";
		}
		Set<String> set = new HashSet<String>();
		for (String item : str.split(format)) {
			set.add(item);
		}
		return set;
	}

	/**
	 * 用默认的分隔符(,)将字符串转换为字符串数组
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static String[] str2StrArray(String str) {
		return str2StrArray(str, ",\\s*");
	}

	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
	 * 
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String date2Str(Date date) {
		return date2Str(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date str2Date(String date) {
		if (notEmpty(date)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
			return new Date();
		} else {
			return null;
		}
	}

	/**
	 * 字符串转换为日期
	 * 
	 * @param date
	 *            要转换成日期的字符串
	 * @param flag
	 *            要转换的格式
	 * @return
	 */
	public static Date str2Date(String date, String flag) {
		if (notEmpty(date)) {
			SimpleDateFormat sdf = new SimpleDateFormat(flag);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		return null;
	}

	public static boolean isValidDate(String str, String flag) {
		 boolean convertSuccess=true;
		  // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		 SimpleDateFormat format = new SimpleDateFormat(flag);
		 try {
		 // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
		    format.setLenient(false);
		    format.parse(str);
		 } catch (ParseException e) {
		   // e.printStackTrace();
		 // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
		    convertSuccess=false;
		} 
		return convertSuccess;
	}
	
	/**
	 * 获取客户端真实IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if(ip != null){
			String[] ips=ip.split(",");
			ip=ips[0];
		}
		return ip;
	}
	
	/**
     * 将字节数组转换为十六进制字符串
     * @param digest
     * @return
     */
    public static String byteToStr(byte[] digest) {
        // TODO Auto-generated method stub
        String strDigest = "";
        for(int i = 0; i < digest.length; i++){
            strDigest += byteToHexStr(digest[i]);
        }
        return strDigest;
    }
     
    /**
     * 将字节转换为十六进制字符串
     * @param b
     * @return
     */
    private static String byteToHexStr(byte b) {
        // TODO Auto-generated method stub
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(b >>> 4) & 0X0F];
        tempArr[1] = Digit[b & 0X0F];
         
        String s = new String(tempArr);
        return s;
    }

	/**
	 * 按照参数format的格式，日期转字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date, String format) {
		if (date == null) {
			return "";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}
	}
	
	
	public static Integer[] strArr2IntArr(String[] strArr) {
		Integer[] intArr = new Integer[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			intArr[i] = Integer.valueOf(strArr[i]);
		}
		return intArr;
	}

	public static byte[] int2Bytes(int num) {
		byte[] byteNum = new byte[4];
		for (int ix = 0; ix < 4; ++ix) {
			int offset = 32 - (ix + 1) * 8;
			byteNum[ix] = (byte) ((num >> offset) & 0xff);
		}
		return byteNum;
	}

	public static byte int2OneByte(int num) {
		return (byte) (num & 0x000000ff);
	}

	/*
	 * 获取不同的颜色
	 */
	public static Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255)
			s = 255;
		if (e > 255)
			e = 255;
		int r = s + random.nextInt(e - s);
		int g = s + random.nextInt(e - s);
		int b = s + random.nextInt(e - s);
		return new Color(r, g, b);
	}

	/** Prevent instantiation */
	private Tools() {
	}

	/**
	 * 数组转换获取对象List
	 * 
	 * @param obj
	 * @return
	 */
	public static List<?> getList(Object obj) {
		Class<?> clasz = obj.getClass();
		// Object temp = new Object();
		List<Object> list = new ArrayList<Object>();
		try {
			// temp = clasz.newInstance();
			Method[] methodArr = clasz.getDeclaredMethods(); // 获取类方法 数组
			List<Method> methodList = new ArrayList<Method>();
			List<Object[]> objArrList = new ArrayList<Object[]>();
			// List<String> method2List = new ArrayList<String>();
			int count = 0;
			for (int i = 0; i < methodArr.length; i++) { // 获取循环需要list
				String name = methodArr[i].getName();
				if (methodArr[i].getReturnType().isArray()) {

					if (name.indexOf("get") == 0) {
						// methodList.add(methodArr[i]);

						Object[] objArr = (Object[]) methodArr[i].invoke(obj);
						objArrList.add(objArr);
						if (objArr != null) {
							count = objArr.length;
						}
						String str = name.substring(3, name.length() - 3);
						str = "set" + str.substring(0, 1).toUpperCase()
								+ str.substring(1);

						// System.out.println(methodArr[i].getParameterTypes().length);
						// Method t =
						// clasz.getDeclaredMethod(str,methodArr[i].getParameterTypes());
						for (int j = 0; j < methodArr.length; j++) {
							while (str.equals(methodArr[j].getName())) {
								methodList.add(methodArr[j]);
								break;
							}
						}
						// method2List.add(str);
						// System.out.println(str);
					}
				}
			}
			// System.out.println("---methodlist:"+methodList.size()+"---method2list:"+method2List.size()+"---arrlist:"+objArrList.size());

			int size = methodList.size();

			for (int i = 0; i < count; i++) {
				Object tempObj = clasz.newInstance();
				int num = 0;
				while (num < size) {
					Method m = methodList.get(num);
					if (objArrList.get(num) != null) {
						m.invoke(tempObj, objArrList.get(num)[i]);
						// System.out.println(objArrList.get(num));
					}
					num++;
				}

				list.add(tempObj);
			}

			if (list.size() > 0) {
				list.remove(list.size() - 1);
			}
		} catch (InstantiationException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 判断是否为中文汉字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isChinese(String str) {
		char[] chars = str.toCharArray();
		boolean isGB2312 = false;
		for (int i = 0; i < chars.length; i++) {
			byte[] bytes = ("" + chars[i]).getBytes();
			if (bytes.length == 2) {
				int[] ints = new int[2];
				ints[0] = bytes[0] & 0xff;
				ints[1] = bytes[1] & 0xff;
				if (ints[0] >= 0x81 && ints[0] <= 0xFE && ints[1] >= 0x40
						&& ints[1] <= 0xFE) {
					isGB2312 = true;
					break;
				}
			}
		}
		return isGB2312;
	}

	/*
	 * 将一个实体类里的数组转移到另一个实体类里并封装成list obj:带有数组的原实体类 target:要被list封装的目标实体类
	 * mustp:必须的属性，用来确定个数 objCommon：直接从原实体类中取出的公共属性，不是数组
	 * singleCommon:直接设置到目标实体类中的
	 */
	public static List<?> ObjArrayToListObj(Object obj, Object target,
			String mustp, String[] objCommon, String[] singleCommon)
			throws Exception {
		if (obj == null || target == null
				|| (mustp == null || "".equals(mustp.trim()))) {
			throw new Exception("原实体类、目标实体类、必须属性都不能为空或null");
		}
		List<Object> targetList = null;
		Field[] fields = obj.getClass().getDeclaredFields();
		String[] methodNames = new String[fields.length];
		Object[] methodValues = new Object[fields.length];
		int count = 0;
		for (int i = 0; i < fields.length; i++) {
			Object objValue = ReflectHelper.getValueByFieldName(obj,
					fields[i].getName());
			if (objValue != null && objValue.getClass().isArray()) {
				methodNames[count] = fields[i].getName();
				methodValues[count] = objValue;
				count++;
			}
		}
		Object mustpValue = ReflectHelper.getValueByFieldName(obj, mustp);
		if (mustpValue != null && mustpValue.getClass().isArray()) {
			int mustpLen = Array.getLength(mustpValue);
			int methodsLen = methodNames.length;
			targetList = new ArrayList<Object>();
			for (int j = 0; j < mustpLen; j++) {
				if (Array.get(mustpValue, j) == null
						|| "".equals(Array.get(mustpValue, j).toString())) {
					continue;
				}
				Object targetObj = null;
				targetObj = Class.forName(target.getClass().getName())
						.newInstance();
				for (int k = 0; k < methodsLen; k++) {
					String methodName = methodNames[k];
					if (methodName == null || "".equals(methodName.trim())) {
						break;
					}
					if (ReflectHelper.isHasField(targetObj, methodName)) {
						ReflectHelper.setValueByFieldName(targetObj,
								methodName, Array.get(methodValues[k], j));
					}
				}
				if (targetObj != null) {
					if (objCommon != null && objCommon.length > 0) {
						for (String commonMethod : objCommon) {
							ReflectHelper.setValueByFieldName(targetObj,
									commonMethod, ReflectHelper
											.getValueByFieldName(obj,
													commonMethod));
						}
					}

					if (singleCommon != null && singleCommon.length > 0) {
						for (String single : singleCommon) {
							String[] commonMethod = single.split(":");
							ReflectHelper.setValueByFieldName(targetObj,
									commonMethod[0], commonMethod[1]);
						}
					}
					targetList.add(targetObj);
				}
			}
		}
		return targetList;
	}

	/*
	 * 将javabean实体类转为map类型，然后返回一个map类型的值 obj:原实体类
	 */
	public static Map<String, Object> beanToMap(Object obj) {
		Map<String, Object> params = new HashMap<String, Object>(0);
		try {
			PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
			PropertyDescriptor[] descriptors = propertyUtilsBean
					.getPropertyDescriptors(obj);
			for (int i = 0; i < descriptors.length; i++) {
				String name = descriptors[i].getName();
				if (!"class".equals(name)) {
					params.put(name,
							propertyUtilsBean.getNestedProperty(obj, name));
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return params;
	}
	
	
	/*
	 * 将javabean实体类转为json，并将时间转为字符串
	 */
	public static String beanToJsonObject(Object obj,String... format) {
		
		String formatTemp = format.length == 0?"":format[0];
		JsonConfig jsonConfig = new JsonConfig();
		JsonDateValueProcessor processor = StringUtils.isBlank(formatTemp)?new JsonDateValueProcessor():new JsonDateValueProcessor(formatTemp);
		jsonConfig.registerJsonValueProcessor(Date.class,processor);

		JSONObject jo = JSONObject.fromObject(obj, jsonConfig);
		return jo.toString();
	}
	
	/*
	 * 将列表转为json，并将时间转为字符串
	 */
	public static String beanToJsonArray(Object obj,String... format) {
		
		String formatTemp = format.length == 0?"":format[0];
		JsonConfig jsonConfig = new JsonConfig();
		JsonDateValueProcessor processor = StringUtils.isBlank(formatTemp)?new JsonDateValueProcessor():new JsonDateValueProcessor(formatTemp);
		jsonConfig.registerJsonValueProcessor(Date.class,processor);

		JSONArray ja = JSONArray.fromObject(obj,jsonConfig);
		return ja.toString();
	}

	/**
	 * 对日期加几个小时，其中日期的格式需要“yyyyMMddHHmmss”
	 * 
	 * @param localDate
	 *            格式化日期：yyyyMMddHHmmss
	 * @param num
	 *            需要添加的小时数
	 * @return
	 * @throws Exception
	 */
	public static Date datePlusHour(String localDate, int num) throws Exception {
		if (num < 0) {
			return null;
		}
		SimpleDateFormat formate = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = formate.parse(localDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY)
				+ num);
		return calendar.getTime();
	}
	
	/**
	 * 日期相加（分钟）
	 * @param localDate
	 * @param num
	 * @return
	 * @throws Exception
	 */
	public static Date datePlusMinutes(Date date, int num) {
		if (num < 0) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE)
				+ num);
		return calendar.getTime();
	}

	/**
	 * 对日期减几个小时，其中日期的格式需要“yyyyMMddHHmmss”
	 * 
	 * @param localDate
	 *            格式化日期：yyyyMMddHHmmss
	 * @param num
	 *            需要添加的小时数
	 * @return
	 * @throws Exception
	 */
	public static Date dateSubHour(String localDate, int num) throws Exception {
		if (num < 0) {
			return null;
		}
		SimpleDateFormat formate = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = formate.parse(localDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY)
				- num);
		return calendar.getTime();
	}
	
	/**
	 * 获取当前日期的前几小时或后几小时
	 * 
	 * @param date
	 *            当前时间
	 * @param operation
	 *            运算
	 * @return
	 */
	public static Date datePlusHour(Date date, int num) throws Exception {
		if (num < 0) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY)
				+ num);
		return calendar.getTime();
	}

	/**
	 * 获取当前日期的前几天或后几天
	 * 
	 * @param date
	 *            当前时间
	 * @param operation
	 *            运算
	 * @return
	 */
	public static Date getNextOrLastDay(Date date, int operation) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, operation);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 获取当前日期的前几个月或后几个月
	 * 
	 * @param date
	 *            当前时间
	 * @param operation
	 *            运算
	 * @return
	 */
	public static Date getNextOrLastMonth(Date date, int operation) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, operation);
		date = calendar.getTime();
		return date;
	}
	/**
	 * 获取当前日期的前几个月或后几个月
	 * 
	 * @param date
	 *            当前时间
	 * @param operation
	 *            运算
	 * @param flag
	 *            辨别是start(凌晨)还是end(23：59：59)
	 * @return
	 */
	public static Date getNextOrLastMonth(Date date, int operation, String flag) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, operation);
		if ("start".equals(flag)) {
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
		} else if ("end".equals(flag)) {
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
		}
		date = calendar.getTime();
		return date;
	}
	/**
	 * 获取当前日期的前几个年或后几个年
	 * 
	 * @param date
	 *            当前时间
	 * @param operation
	 *            运算
	 * @return
	 */
	public static Date getNextOrLastYear(Date date, int operation) {
		return getNextOrLastYear(date, operation, "");
	}
	/**
	 * 获取当前日期的前几年或后几年
	 * 
	 * @param date
	 *            当前时间
	 * @param operation
	 *            运算
	 * @param flag
	 *            辨别是start(凌晨)还是end(23：59：59)
	 * @return
	 */
	public static Date getNextOrLastYear(Date date, int operation, String flag) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, operation);
		if ("start".equals(flag)) {
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
		} else if ("end".equals(flag)) {
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
		}
		date = calendar.getTime();
		return date;
	}
	/**
	 * 获取第二天凌晨时间
	 * 
	 * @param date
	 *            当前时间
	 * @param operation
	 *            运算
	 * @return
	 */
	public static Date getNextDay0Hour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * 获取第num天23:59:59
	 * 
	 * @param date
	 *            当前时间
	 * @param operation
	 *            运算
	 * @return
	 */
	public static Date getNextDay23Hour(Date date, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, num);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * 获取第num天凌晨时间
	 * 
	 * @param date
	 *            当前时间
	 * @param operation
	 *            运算
	 * @return
	 */
	public static Date getNextDay0Hour(Date date, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, num);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 获取第二天凌晨时间
	 * 
	 * @param date
	 *            当前时间
	 * @param operation
	 *            运算
	 * @return
	 */
	public static Date getYestDay0Hour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * 获取当前日期的前几周或后几周
	 * 
	 * @param date
	 *            当前时间
	 * @param operation
	 *            运算
	 * @return
	 */
	public static Date getNextOrLastWeek(Date date, int operation) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.WEEK_OF_MONTH, operation);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 判断字符串是否为纯数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 获取完整的请求路径
	 * @param request
	 * @return
	 */
	public static String getFullRequestUrl(HttpServletRequest request){
		String queryStr=request.getQueryString();
		String furl=getFullProjectUrl()+request.getRequestURI();
		if(Tools.notEmpty(queryStr)){
			furl+="?"+queryStr;
		}
		return furl;
	}
	
	/**
	 * 获取完整的工程路径
	 * @param request
	 * @return
	 */
	public static String getFullProjectUrl(){
		String basePath=SecurityProperties.getInstance().getProperty("domain.wechat");
		if(Tools.notEmpty(basePath)){
			basePath=basePath.trim();
			if(basePath.endsWith("/")){
				basePath=basePath.substring(0,basePath.length()-1);
			}
		}
		return basePath;
	}
	
	/**
	 * 将网址处理为标准的url地址
	 * @param url 要做处理的url地址
	 * @return
	 */
	public static String processStandardUrl(String url){
		if(isEmpty(url)){
			return null;
		}
		url=url.trim();
		if(url.startsWith("http://") || url.startsWith("https://")){
			return url;
		}else if(!url.startsWith("/")){
			url="/"+url;
		}
		if(url.endsWith("/")){
			url=url.substring(0,url.length()-1);
		}
		return url;
	}
	
	/**
	 * 将list转换为以指定字段值为键值的map（不进行排序）
	 * @param list 要转换的list
	 * @param fieldName 指定字段 
	 * @return
	 */
	public static Map<?,?> listConvertToMap(List<?> list,String fieldName){
		return listConvertToMap(list,fieldName,false);
	}
	
	/**
	 * 将list转换为以指定字段值为键值的map
	 * @param list 要转换的list
	 * @param fieldName 指定字段 
	 * @param isSort 是否按先进先出的顺序排序
	 * @return
	 */
	public static Map<?,?> listConvertToMap(List<?> list,String fieldName,boolean isSort){
		if(list == null || list.size()==0){
			return null;
		}
		Map<Object,Object> rmap=null;
		if(isSort){
			rmap=new LinkedHashMap<Object, Object>();
		}else{
			rmap=new HashMap<Object,Object>();
		}
		try {
			for(Object vobj : list){
				rmap.put(ReflectHelper.getValueByFieldName(vobj, String.valueOf(fieldName)),vobj);
			}
		} catch (SecurityException | NoSuchFieldException
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return rmap;
	}
	
	/**
	 * 是否是微信访问
	 * @param request
	 * @return
	 */
	public static boolean isWechatRequest(HttpServletRequest request){
		String ua=request.getHeader("user-agent");
		if(Tools.isEmpty(ua)){
			return false;
		}
	    if(ua.toLowerCase().indexOf("micromessenger") > 0) {// 是微信浏览器
	       return true;
	    }
		return false;
	}
	
	/**
	 * 将object对象转换为string类型
	 * @param obj
	 * @return
	 */
	public static String objectToStr(Object obj){
		if(obj == null){
			return null;
		}
		return obj.toString();
	}
	
	public static int daysBetween(Date smdate,Date bdate) { 
		  return (int)((smdate.getTime() / 86400000L) - (bdate.getTime() / 86400000L)); 
	}
	
	/**
	 * 根据编码，返回值
	 * @param str
	 * @return
	 */
	public static String getCdictValueByCode(String dicCode,String code){
		//获取字典项
		String dictStr=EnumsProperties.getInstance().getProperty(dicCode);
		if(Tools.isEmpty(dictStr)){
			return null;
		}
		if(Tools.isEmpty(code)){
			return null;
		}
		code=code.trim();
		StringBuffer sb=new StringBuffer();
		for(String dict : dictStr.split(";")){
			if(dict == null || "".equals(dict.trim()) || dict.indexOf(":")<=0){
				continue;
			}
			dict=dict.trim();
			String[] item=dict.split(":");
			if(item[0].equals(code)){
				sb.append(item[1]+",");
			}
		}
		int slen=sb.length();
		if(slen>0){
			sb.delete(slen-1, slen);
		}
		return sb.toString();
	}
	
	/**
	 * 根据enum字典编码，返回map
	 * @param str
	 * @return
	 */
	public static Map<String,String> getCdictItems(String dicCode){
		//获取字典项
		String dictStr=EnumsProperties.getInstance().getProperty(dicCode);
		if(Tools.isEmpty(dictStr)){
			return null;
		}
		//字典项
		Map<String,String> dictMap=new HashMap<String,String>();
		for(String dict : dictStr.split(";")){
			if(dict == null || "".equals(dict.trim()) || dict.indexOf(":")<=0){
				continue;
			}
			dict=dict.trim();
			String[] item=dict.split(":");
			dictMap.put(item[0], item[1]);
		}
		if(dictMap.isEmpty()){
			return null;
		}
		return dictMap;
	}
	
	/**
	 * 根据字符串，返回map
	 * @param str
	 * @return
	 */
	public static Map<String,String> getStringMap(String dicCode){
		//获取字典项
		String dictStr=dicCode;
		//字典项
		Map<String,String> dictMap=new HashMap<String,String>();
		for(String dict : dictStr.split(";")){
			if(dict == null || "".equals(dict.trim()) || dict.indexOf(":")<=0){
				continue;
			}
			dict=dict.trim();
			String[] item=dict.split(":");
			dictMap.put(item[0], item[1]);
		}
		if(dictMap.isEmpty()){
			return null;
		}
		return dictMap;
	}
	
	/**
	 * 获取当前月的第一天
	 * @return
	 */
	public static String getfirstDateForthisMonth(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		return first;
	}
	
	/**
	 * 获取当前月的最后一天
	 * @return
	 */
	public static String getlastDateForthisMonth(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		return last;
	}
	
	/**
	 * 获取当月天数
	 * @return
	 */
	public static int getdaysCountForthisMonth(){
		Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
		int day = aCalendar.getActualMaximum(Calendar.DATE);
		return day;
	}
	
	  /** 
     * 获取某年第一天日期 
     * @param year 年份 
     * @return Date 
     */  
    public static String getYearFirst(int year){  
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        Date currYearLast = calendar.getTime();  
        return format.format(currYearLast);
    }  
      
    /** 
     * 获取某年最后一天日期 
     * @param year 年份 
     * @return Date 
     */  
    public static String getYearLast(int year){  
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
        Date currYearLast = calendar.getTime();  
        return format.format(currYearLast);
    }  
    
    /** 
     * 得到几天前或几天后的时间 
     * @param d 
     * @param day 为正整数时为后几天，为负数时为后几天
     * @return 
     */  
    public static String getDateString(int day,Date date){  
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
     Calendar now =Calendar.getInstance();
     now.setTime(date);
     now.set(Calendar.DATE,now.get(Calendar.DATE)+day);  
     return format.format(now.getTime());  
    }  
    
    /**
     * 得到今天前或几天后的时间
     * @param day
     * @param date
     * @return
     */
    public static Date getDate(int day,Date date){  
     Calendar now =Calendar.getInstance();
     now.setTime(date);
     now.set(Calendar.DATE,now.get(Calendar.DATE)+day);  
     return now.getTime();
    }  
    /**
	 * bean转bean  第一个是要转换的bean 第二个是被转换的bean
	 * @param convertedClass
	 * @param toConvertedClass
	 * @return
	 */
	public Object getBeanToBean(Object convertedClass,Object toConvertedClass){
		JSONObject json = JSONObject.fromObject(toConvertedClass);
		convertedClass = JSONObject.toBean(json, convertedClass.getClass());
		return convertedClass;
	}
    /**
     * 获取本周的日期
     * @return
     */
    public static String getNowWeek(Date date,int args) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();    
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, args);    
        return format.format(cal.getTime());   
    }
    
    
    /**
     * 获取本周的日期
     * @param 当前日期 date
     * @param Calendar.MONDAY
     * eg:Calendar.SUNDAY
     * @return
     */
    public static Date getNowWeekDate(Date date,int monday) {
        Calendar cal = Calendar.getInstance();    
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, monday);    
        return cal.getTime();   
    }
    
    /**
     * 获取某月的最后一天
     * @return
     */
    public static String getEndMonth(Date date) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();    
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format.format(cal.getTime());   
    }
    
    /**
     * 获取某月的第一天
     * @return
     */
    public static String getStartMonth(Date date) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();    
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return format.format(cal.getTime());   
    }
    
    /**
     * 改变月份
     * @param date
     * @param num
     * @return
     */
    public static Date getChangeMonth(Date date,int num){
        Calendar cal = Calendar.getInstance();    
        cal.setTime(date);
        cal.add(Calendar.MONTH,num);
        return cal.getTime();   
    	
    }
    
    /**
     * 以以map的第一个值为key 第二个值为value
     * 因为类型不一样所以不设定map的类型
     * @param list
     * @param keyclass 
     * @return
     */
    public static Map ListToMap(List list,Class keyclass,String keyFirst,String keySecond,Object defaultVal){
    	Map map = new HashMap();
    	for (Object object : list) {
			Map maptemp = (Map) object; 
			Set keySet = maptemp.keySet();
			if(keySet.size()<2){
				return map;
			}
			if(maptemp.get(keyFirst)==null){
				logger.error("Tools|ListToMap|NullPointerException|keyFirst["+keyFirst+"]");
			}
			Object val = maptemp.get(keySecond);
			if(val==null){
				val = defaultVal;
			}
			
			if(keyclass==null){
				map.put(maptemp.get(keyFirst),val);
			}else if(keyclass==Integer.class){
				map.put(Integer.parseInt(maptemp.get(keyFirst).toString()),val);
			}else if(keyclass==Double.class){
				map.put(Double.parseDouble(maptemp.get(keyFirst).toString()),val);
			}else if(keyclass==Long.class){
				map.put(Long.parseLong(maptemp.get(keyFirst).toString()),val);
			}else{
				map.put(maptemp.get(keyFirst),val);
			}
		}
    	return map;
    }
    
    /**
     * 汉字转拼音(不区分多音字)
     * @param chinese
     * @return
     */
    public static String chinese2pinyin(String chinese) {   
        StringBuffer pybf = new StringBuffer();   
        char[] arr = chinese.toCharArray();   
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();   
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);   
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);   
        for (int i = 0; i < arr.length; i++) {   
                if (arr[i] > 128) {   
                        try {   
                                pybf.append(PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat)[0]);   
                        } catch (BadHanyuPinyinOutputFormatCombination e) {   
                                e.printStackTrace();   
                        }   
                } else {   
                        pybf.append(arr[i]);   
                }   
        }   
        return pybf.toString();   
}  
    
    /**
     * 根据日期获取今天是星期几
     * @param date
     * @return
     */
	public static String getWeekOfDate(Date date) {
		String[] weekOfDays = { "7", "1", "2", "3", "4", "5", "6" };
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		return weekOfDays[w];
    }
    
    public static void main(String[] args) {
    	/*Map<Integer,Integer> one = new HashMap<>();
    	
    	Map map = new HashMap<>();
    	map.put("01", "01");
    	map.put("02", "02");
    	
    	
    	one = map;*/
    	//System.out.println("TOMCAT路径为："+(System.getenv("JAVA_HOME")));
    	
    	//getNextOrLastDay(getNowWeekDate(new Date(), 2), 0);
//    	System.out.println(getWeekOfDate(new Date()));
    	System.out.println(getUpdir("policy" + Tools.date2Str(new Date(),"yyyy_MM_dd_HH_mm_ss") + ".xls"));
    }
    
    /**
     * 获取文件上传路径
     * @return
     */
	public static String getUpdir(String fileName) {
			// 获得唯一文件名的hashcode
			int hashcode = fileName.hashCode();
			// 获得一级目录
			int d1 = hashcode & 0xf;       
			// 获得二级目录
			int d2 = (hashcode >>> 4) & 0xf;

			return DEFAULT_UPDIR+File.separator + d2 + File.separator + d1;// 共有256目录
	} 
	
	/**
     * 校验bean的注解信息
     * @return
     */
	public static String checkDataReturnMsg(Object data) {
		
		String resultMsg = Constant.COMMON.SUCCESS;
		if (data == null) {
			return "校验数据不能为空！";
		}
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(data);
		if (!constraintViolations.isEmpty()) {
			StringBuffer sb = new StringBuffer("【"+Constant.COMMON.ERROR+"】");
			for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
				sb.append("属性：").append(constraintViolation.getPropertyPath()).append(";限制条件：")
				.append(constraintViolation.getMessage()).append(";");
			}
			resultMsg = sb.toString();
			logger.info(resultMsg);
		}
		return resultMsg;
	}
	
	public static boolean isValidLong(String str){
		   try{
		       long _v = Long.parseLong(str);
		       return true;
		   }catch(NumberFormatException e){
		     return false;
		   }
	}
	
	public static boolean isValidInteger(String str){
		   try{
		       int _v = Integer.parseInt(str);
		       return true;
		   }catch(NumberFormatException e){
		     return false;
		   }
	}
	
	/**
	 * 计算扣税
	 * @param money 当前可提
	 * @return
	 */
	public static double  getTaxRevenue(double money){
		double taxRevenue = 0;
		//获取第一个值
		DecimalFormat df = new DecimalFormat("#.00"); 
    	if(money>800 && money <=4000){
    		taxRevenue = (double) ((money-800)*0.2);
    	}else if(money>4000 && money<=25000){
    		taxRevenue = (double) (money*0.16);
    	}else if(money>25000 && money<=62500){
    		taxRevenue = (double) ((money*0.24)-2000);
    	}else if(money>62500){
    		taxRevenue = (double) ((money*0.32)-7000);
    	}
    	
    	return Double.parseDouble(df.format(taxRevenue));
    }
	/**
	 * map 转 bean
	 * @param map
	 * @param obj
	 */
	public static Object transMap2Bean(Map<String, Object> map, Object obj) {  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                if (map.containsKey(key)) {  
                    Object value = map.get(key);  
                    // 得到property对应的setter方法  
                    Method setter = property.getWriteMethod();  
                    setter.invoke(obj, value);  
                }  
            }  
        } catch (Exception e) {
        	e.printStackTrace();;
        }  
        return obj;
    } 
    public static String ioToBase64(InputStream in) throws IOException {
        String strBase64 = null;
        try {
            // in.available()返回文件的字节长度
            byte[] bytes = new byte[in.available()];
            // 将文件中的内容读入到数组中
            in.read(bytes);
            strBase64 = new BASE64Encoder().encode(bytes);      //将字节流数组转换为字符串
            in.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return strBase64;
    } 
}
