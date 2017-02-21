package com.wkb.core.util;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 * 调用接口工具类
 * @author huanglt
 *
 */
public class HttpClientHelper {

	/**
	 * get方式请求并返回json数据
	 * @param url 要请求的链接
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject getAndReturnJson(String url) throws ClientProtocolException, IOException{
        String  str=get(url);
        JSONObject responseJson = JSONObject.fromObject(str);
        return responseJson;
	}
	
	/**
	 * get请求返回数据
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String get(String url) throws ClientProtocolException, IOException{
		HttpGet hget=new HttpGet(url);
		HttpClient client = HttpClients.createDefault();
		//使用http调用请求
        HttpResponse response = client.execute(hget);
        HttpEntity responseEntity = response.getEntity();
        //获取返回json字符串
        String  str=EntityUtils.toString(responseEntity);
        hget.abort();
        return str;
	}
	
	/**
	 * post 请求并返回json格式数据
	 * @param url
	 * @param params
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject postAndReturnJson(String url,String params) throws ClientProtocolException, IOException{
        String  str=post(url,params);
        JSONObject responseJson = JSONObject.fromObject(str);
        return responseJson;
	}
	
	/**
	 * post 请求返回数据
	 * @param url 请求url
	 * @param params 参数
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static String post(String url,String params) throws ParseException, IOException{
		HttpPost hpost=new HttpPost(url);
		hpost.setEntity(new StringEntity(params,"UTF-8"));
		HttpClient client = HttpClients.createDefault();
		//使用http调用请求
        HttpResponse response = client.execute(hpost);
        HttpEntity responseEntity = response.getEntity();
        //获取返回json字符串
        String  str=EntityUtils.toString(responseEntity);
        hpost.abort();
        return str;
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "http://www.baidu.com";
		String string = HttpClientHelper.get(url);
		System.out.println(string);
	}
}
