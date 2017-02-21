package com.wkb.core.http;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PostThread extends Thread  {

	private final CloseableHttpClient httpClient;
    private final HttpContext context;
    private final HttpPost httppost;
    @SuppressWarnings("unused")
    private final int requestTimeout;
    @SuppressWarnings("unused")
	private final int connectTimeout;
    @SuppressWarnings("unused")
    private final int socketTimeout;
    private static int MAX_REQUEST_TIMEOUT = 6000;
    private static int MAX_CONNECT_TIMEOUT = 6000;
    private static int MAX_SOCKET_TIMEOUT = 6000;
    private String result = null;
    private Map<String, Object> otherParams = null;
    private static Logger logger=LoggerFactory.getLogger(PostThread.class);
    
    public Map<String, Object> getOtherParams() {
		return otherParams;
	}

	public PostThread(CloseableHttpClient httpClient, HttpPost httppost, Map<String, String> params,String encode,int requestTimeout,
    		int connectTimeout,int socketTimeout,Map<String, Object> otherParams) throws UnsupportedEncodingException {
    	this.requestTimeout = requestTimeout == 0 ? MAX_REQUEST_TIMEOUT : requestTimeout;
    	this.connectTimeout = connectTimeout == 0 ? MAX_CONNECT_TIMEOUT : connectTimeout;
    	this.socketTimeout = socketTimeout	== 0 ? MAX_SOCKET_TIMEOUT : socketTimeout;
    	this.httpClient = httpClient;
        this.context = new BasicHttpContext();
        this.httppost = httppost;
        this.otherParams = otherParams;
        //设置超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(requestTimeout)
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeout)
                .build();
        httppost.setConfig(requestConfig);
        List<NameValuePair> pairs = null;
        if (params != null && !params.isEmpty()) {
            pairs = new ArrayList<NameValuePair>(params.size());
            for (Map.Entry<String, String> entry : params.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    pairs.add(new BasicNameValuePair(entry.getKey(), value
                            .toString()));
                }
            }
        }
        if (pairs != null && pairs.size() > 0) {
            encode = encode == null ? "UTF-8" : encode;
            httppost.setEntity(new UrlEncodedFormEntity(pairs, encode));
        }
        
    }

    @Override
    public void run() {
        try {
			 CloseableHttpResponse response = httpClient.execute(httppost, context);
            try {
                HttpEntity entity = response.getEntity();
                if (200 == response.getStatusLine().getStatusCode()) {
                	result = EntityUtils.toString(entity);
					this.success(entity);
				}else {
					this.fail(entity);
				}
            } finally {
                response.close();
            }
        } catch (Exception e) {
        	logger.error(e.getMessage());
           this.result = Thread.currentThread().getName()+"异常";
        }
    }

    public String call() throws Exception {
        return result;
    }
    
    public abstract void success(HttpEntity responseResult);
    
    public abstract void fail(HttpEntity responseResult);

}
