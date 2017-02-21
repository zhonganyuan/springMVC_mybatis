package com.wkb.common.enums.status;

import java.util.HashMap;
import java.util.Map;

/**
 * 协议对象
 * @author liuqihe
 *
 */
public enum AgreementObjectEnum {

	MERCHANT(1,"商户"),
	INSURANCECOMPANY(2,"保险公司"),
	SERVICEPROVIDER(3,"服务商"),
	;
	
	//文件类型type
	private int type;
	//文件类型描述
	private String desc;

	private AgreementObjectEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
	
	public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public static AgreementObjectEnum getByType(int type){
        for(AgreementObjectEnum k:AgreementObjectEnum.values()){
            if(k.getType()==type){
                return k;
            }
        }
        return null;
    }
    
    public static String getDescByType(int type){
        for(AgreementObjectEnum k:AgreementObjectEnum.values()){
            if(k.getType()==type){
                return k.getDesc();
            }
        }
        return "";
    }
    
    public static Map<String, String> getMap() {
    	Map<String, String> map = new HashMap<String, String>();
    	for(AgreementObjectEnum k:AgreementObjectEnum.values()){
    		map.put(""+k.getType(), k.getDesc());
        }
        return map;
    }
    
}
