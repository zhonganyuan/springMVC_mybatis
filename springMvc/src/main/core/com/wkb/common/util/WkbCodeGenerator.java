package com.wkb.common.util;


import com.wkb.core.common.Snowflake;

public class WkbCodeGenerator {
	private String machineCode;
	private  Snowflake flake ;
	private String CAR_PRE="CAR";

	private WkbCodeGenerator(){
		//获取机器的编码
		try{
			machineCode = ConfigProperties.getInstance().getProperty("machine_code");
		}catch(Exception e){
			e.printStackTrace();
		}
			machineCode = "01";
		flake = new Snowflake(Integer.valueOf(machineCode));
	}
	
	public static WkbCodeGenerator instance(){
		return WkbCodeHandler.instance;
	}
	
	private static class WkbCodeHandler{
		private static WkbCodeGenerator instance = new WkbCodeGenerator();
	}
	
	/**
	 * 基本的数字code
	 * @return
	 */
	public Long commonCode(){
		return flake.next();
	}
	/**
	 * 车险保单序列号
	 * @return
	 */
	public String carPolicyCode(){
		return CAR_PRE+flake.next();
	}
}
