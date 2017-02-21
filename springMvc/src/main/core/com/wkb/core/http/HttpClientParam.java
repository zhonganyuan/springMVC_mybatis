package com.wkb.core.http;

import java.util.HashMap;
import java.util.Map;

public class HttpClientParam {

	//访问链接地址
	private String url ;
	//编码格式
	private String encode = "UTF-8";
	//参数
	private Map<String,String> param = new HashMap<String, String>();
	//添加其他参数
	private Map<String,Object> otherParam = new HashMap<String, Object>();
	//请求过期时间
	private int requestTimeout = 0;
	//链接过期时间
	private int connectTimeout = 0;
	//套接字过期时间
	private int socketTimeout = 0;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEncode() {
		return encode;
	}
	public void setEncode(String encode) {
		this.encode = encode;
	}
	public void setValue(String key,String obj){
		param.put(key, obj);
	}
	public Object getValue(String key) {
		return param.get(key);
	}
	public int getRequestTimeout() {
		return requestTimeout;
	}
	public void setRequestTimeout(int requestTimeout) {
		this.requestTimeout = requestTimeout;
	}
	public int getConnectTimeout() {
		return connectTimeout;
	}
	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}
	public int getSocketTimeout() {
		return socketTimeout;
	}
	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}
	public Map<String, String> getParam() {
		return param;
	}
	public void setParam(Map<String, String> param) {
		this.param = param;
	}
	public Map<String, Object> getOtherParam() {
		return otherParam;
	}
	public void setOtherParam(String key,Object obj) {
		otherParam.put(key, obj);
	}
	
}
