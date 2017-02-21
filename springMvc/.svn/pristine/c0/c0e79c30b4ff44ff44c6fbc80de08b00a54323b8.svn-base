package com.wkb.core.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import com.wkb.core.exceptions.NoUniqueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 生成唯一编码
 * @author huanglt
 * 
 */
public class GenerateUniqueCode {

	private static char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f',
			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
			't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z' };
	
	private static String INSURANCE_CLAUSE_PRE = "CLAS";
	private static String INSURANCE_LIABLILITY_PRE_="LIABL";
	private static String INSURANCE_RATE_PRE_="RATE";
	private static String FINACNE_BILL_PRE="BILL";
	private static String nums="0123456789";
	
	private static Map<Long,Set<String>> millisMap;
	
	private static Set<String> millisSet;
	
	private static Logger logger=LoggerFactory.getLogger(GenerateUniqueCode.class);

	/**
	 * 生成8位短编码，有可能会重复
	 * @return
	 */
	public static String shortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();

	}
	
	/**
	 * 时间戳加随机8位短编码，几乎无重复可能性
	 * @return
	 */
	public static String uniqueShortUuid(){
		String shortId=shortUuid();
		return System.currentTimeMillis()+shortId;
	}
	
	/**
	 * 获取纯数字的唯一编码
	 * @param len 在13位时间戳后面再加多少位
	 * @return
	 * @throws NoUniqueException 
	 */
	public static synchronized String uniqueNumId(int len) throws NoUniqueException{
		long millis=System.currentTimeMillis();
		if(millisMap == null || millisMap.isEmpty()){
			millisMap=new HashMap<Long,Set<String>>();
			millisSet=new HashSet<String>();
			millisMap.put(millis, millisSet);
		}else if(!millisMap.containsKey(millis)){
			millisMap.clear();
			millisSet.clear();
			millisMap.put(millis, millisSet);
		}
		StringBuffer sb=new StringBuffer(String.valueOf(millis));
		Random r = new Random();
		int nlen=nums.length();
		boolean iscircle=false;
		StringBuffer randomstr=new StringBuffer("");
		int count=0;
		do{
			randomstr.delete(0, randomstr.length());
			for(int i=0;i<len;i++){
				randomstr.append(nums.charAt(r.nextInt(nlen)));
			}
			String rstr=randomstr.toString();
			if(!millisSet.isEmpty() && millisSet.contains(rstr)){
				iscircle=true;
				if(count>99){
					throw new NoUniqueException("没有唯一性编码了！");
				}
				count++;
			}else{
				millisSet.add(rstr);
				iscircle=false;
			}
		}while(iscircle);
		sb.append(randomstr);
		return sb.toString();
	}
	
	/**
	 * 获取纯数字随机码
	 * @param count
	 * @return
	 */
	public static String getRandomNumStr(int count){
		if(count < 1){
			return null;
		}
		Random r = new Random();
		StringBuffer sb=new StringBuffer("");
		for(int i=0;i<count;i++){
			sb.append(nums.charAt(r.nextInt(count)));
		}
		return sb.toString();
	}
	
	/**
	 * 获取18位的纯数字编码
	 * @return
	 */
	public static long unique18NumId(){
		String ucode=null;
		try {
			ucode=uniqueNumId(5);
		} catch (NoUniqueException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			ucode="0";
		}
		return Long.parseLong(ucode);
	}
	
	/**
	 * 获取UUID
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	public static void main(String[] args) {
		System.out.println(getUUID().length());
	}
	/**
	 * 获的保险条款唯一CODE
	 * @return
	 */
	public static String getInsuranceClauseCode() {
		String str = null;
		try {
			str =  INSURANCE_CLAUSE_PRE+uniqueNumId(3);
		} catch (NoUniqueException e) {
			logger.error(e.getMessage());
		}
		return str;
	}
	
	public static String getInsuranceLiabilityInfoCode() {
		String str = null;
		try {
			str =  INSURANCE_LIABLILITY_PRE_+uniqueNumId(3);
		} catch (NoUniqueException e) {
			logger.error(e.getMessage());
		}
		return str;
	}
	/**
	 * 获得保险费率code
	 * @return
	 */
	public static String getInsuranceRateCode() {
		String str = null;
		try {
			str =  INSURANCE_RATE_PRE_+uniqueNumId(3);
		} catch (NoUniqueException e) {
			logger.error(e.getMessage());
		}
		return str;
	}
	
	/*
	 * 获得发票序号
	 */
	public static String getFinanceBillInfoCode(){
		String str = null;
		try {
			str = FINACNE_BILL_PRE+uniqueNumId(3);
		} catch (NoUniqueException e) {
			logger.error(e.getMessage());
		}
		return str;
	}
}
