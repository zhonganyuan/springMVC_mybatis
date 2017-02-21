package com.wkb.common.enums.status;

import java.util.HashMap;
import java.util.Map;

/**
 * 商户动态文件类型
 * @author liuqihe
 *
 */
public enum TrendsFileTypeEnum {

	CONTRACT((byte)1,"合同"),
	PRODUCTAGREEMENT((byte)2,"产品协议"),
	;
	
	//文件类型type
	private byte type;
	//文件类型描述
	private String desc;

	private TrendsFileTypeEnum(byte type, String desc) {
        this.type = type;
        this.desc = desc;
    }
	
	public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public static TrendsFileTypeEnum getByType(int type){
        for(TrendsFileTypeEnum k:TrendsFileTypeEnum.values()){
            if(k.getType()==type){
                return k;
            }
        }
        return null;
    }
    
    public static String getDescByType(int type){
        for(TrendsFileTypeEnum k:TrendsFileTypeEnum.values()){
            if(k.getType()==type){
                return k.getDesc();
            }
        }
        return "";
    }
    
    public static Map<String, String> getMap() {
    	Map<String, String> map = new HashMap<String, String>();
    	for(TrendsFileTypeEnum k:TrendsFileTypeEnum.values()){
    		map.put(""+k.getType(), k.getDesc());
        }
        return map;
    }
}
