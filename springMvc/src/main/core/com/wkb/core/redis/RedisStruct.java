package com.wkb.core.redis;

import java.io.Serializable;

/**
 * 存储redis数据结构
 * @author asus
 *
 */
public class RedisStruct implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String key;
	
	private String value;
	
	public RedisStruct(){}
	
	public RedisStruct(String key,String value){
		this.key=key;
		this.value=value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
