package com.wkb.core.http;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.List;

import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientTread {
	
	private static Logger logger=LoggerFactory.getLogger(HttpClientTread.class);
	/**
	 * 
	 * @param reqList
	 * 		请求参数列表
	 * @param retryCount
	 * 		请求次数
	 * @param postThread
	 * 		使用的请求方法
	 * @param isSyn
	 * 		是否同步
	 * @return
	 */
	
	public static String[] synThreadPost(List<HttpClientParam> reqList,final int retryCount, Class<? extends PostThread> postThread){
		return threadPost(reqList, retryCount, postThread, true);
	}
	
	public static void asynThreadPost(List<HttpClientParam> reqList,final int retryCount, Class<? extends PostThread> postThread){
		 threadPost(reqList, retryCount, postThread, false);
	}
	
    private static String[] threadPost(List<HttpClientParam> reqList,final int retryCount, Class<? extends PostThread> postThread,boolean isSyn){
    	if (reqList == null || retryCount < 0 || postThread == null) {
			return null;
		}
        String[] results=new String[reqList.size()];
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
			@Override
			public boolean retryRequest(IOException exception, int executionCount,
					HttpContext context) {
				if (executionCount > retryCount) {
					return false;
				}
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				}
				return true;
			}
		};
        //设置线程数最大100,如果超过100为请求个数
        cm.setMaxTotal(reqList.size()>100?reqList.size():100);
        CloseableHttpClient httpclient = HttpClients.custom().setRetryHandler(httpRequestRetryHandler)
                .setConnectionManager(cm)
                .build();
        try{
            PostThread[] postThreads=new PostThread[reqList.size()];
            for (int i = 0; i < reqList.size(); i++) {
                HttpClientParam req=reqList.get(i);
                HttpPost post=new HttpPost(req.getUrl());
                Constructor<?>[] consts = postThread.getDeclaredConstructors();
                for (Constructor<?> constructor : consts) {
                	if (constructor.getParameterTypes().length == 8){
                		 postThreads[i] = (PostThread) constructor.newInstance(httpclient,post,req.getParam(), req.getEncode(),
                				 req.getRequestTimeout(),req.getConnectTimeout(),req.getSocketTimeout(),req.getOtherParam());
                	} 
				}
            }
            //执行线程
            for(PostThread pt:postThreads){
                pt.start();
            }
            if (isSyn) {
            	for (PostThread pt : postThreads) {
                    pt.join();
                }
            	 for (int i = 0; i < reqList.size(); i++) {
                     results[i]=postThreads[i].call();
                 }
			}
           
        }catch (Exception e){
        	logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                httpclient.close();
            } catch (IOException e) {
            	logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return results;
    }

}
