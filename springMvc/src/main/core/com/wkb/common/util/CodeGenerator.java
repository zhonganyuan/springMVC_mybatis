package com.wkb.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.wkb.core.common.Snowflake;

public class CodeGenerator {
	
	private String machineCode;
	private final String prefix="P";
	private final String servicePrefix = "S";
	private  Snowflake flake ;
	private Object lock = new Object();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	
	private CodeGenerator(){
		//获取机器的编码
		machineCode = ConfigProperties.getInstance().getProperty("machine_code");
		machineCode = "01";
		
		flake = new Snowflake(Integer.valueOf(machineCode));
	}
	
	public static CodeGenerator instance(){
		
		return OrderHandler.instance;
	}
	
	/**
	 * 产生订单编号
	 * 规则：日期yyMMdd+机器码＋顺序编号
	 * 2016-03－04 规则修改 
	 * 参考Twitter的分布式自增ID算法Snowflake 19位纯数字
	 * @return
	 */
	public String generateOrderCode(){
		return String.valueOf(flake.next());
	}
	
	/**
	 * 产生保单编号
	 * 规则：日期yyMMdd+机器码＋保单数量序号＋顺序编号
	 * @param orderCode   订单编号
	 * @param insuracedType 被保险人类型
	 * @param num   保单数量
	 * @return
	 */
	public String generateOrderpolicyCode(String orderCode,String insuracedType,int num){
		String codeSt = prefix+insuracedType+String.format("%02d", num)+orderCode;
		return codeSt;
	}
	
	/**
	 * 产生流水编号
	 * @return
	 */
	public Long generateFlowCode(){
		return flake.next();
	}
	
	/**
	 * 产生code
	 * @return
	 */
	public Long generateCode(){
		return flake.next();
	}
	
	/**
	 * 产生服务单号
	 * @return
	 */
	public String generateServiceNo(String orderCode){
		return servicePrefix+orderCode+1;
	}
	
	/**
	 * 产生服务单号
	 * @param orderCode
	 * @param num 生成的第几个保单
	 * @return
	 */
	public String generateServiceNo(String orderCode, int num){
		return servicePrefix+orderCode+num;
	}

	/**
	 * 产生卡券号
	 * @return
	 */
	public String CardVouchersNo(){
		return "W"+flake.next();
	}
	/**
	 * 生产卡券的批次号
	 * @return
	 */
	public  synchronized  String cardVouchersBatchNo(){
		return "FWPC"+dateFormat.format(new Date());
	}

	
	private static class OrderHandler{
		private static CodeGenerator instance = new CodeGenerator();
	}
	
	/**
	 * 产生对账单的序列号
	 * @return
	 */
	public String accountCheckNo(){
		synchronized (lock) {
			return "zd"+machineCode+dateFormat.format(new Date());
		}
	}
	
	public static void main(String[] args) {
		System.out.println(CodeGenerator.instance().cardVouchersBatchNo());
	}
}
