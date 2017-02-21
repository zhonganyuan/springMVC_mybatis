package com.wkb.core.interfaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.util.ResourceUtils;

import com.wkb.common.util.Constant;
import com.wkb.common.util.SecurityProperties;
import com.wkb.core.redis.BaseRedisOperate;
import com.wkb.core.redis.RedisOperateFactory;

/**
 * 配置文件解析
 * @author huanglt
 *
 */
public abstract class PropertiesAnaly {

	//配置文件属性
	protected Properties properties;
	
	//配置文件
	protected InputStream configFile;
	
	
	private static Map<String,String> envMap;  //环境map
	
	private Map<String,String> memMap;  //要贮存的map
	
	private Map<String,String> loadMap;  //当使用cache时，备份的数据
	
	protected boolean saveToMemery;  //是否贮存在内存中
	
	protected boolean saveToCache;  //是否贮存在cache中
	
	protected String loadKey;  //判断该系统是否要加载该配置文件
	
	protected boolean isload;  //本工程中是否加载配置文件
	
	
	protected PropertiesAnaly(boolean saveToMemery){
		this.saveToMemery=false;
		loadProperties();
	}
	
	protected PropertiesAnaly(boolean saveToCache,String loadKey){
		
	}
	
	//设置配置文件
	protected abstract void setConfigFile();
	
	//加载配置文件
	@SuppressWarnings("unchecked")
	private void loadProperties(){
		if(configFile == null){
			setConfigFile();
		}
		
		Map<String,String> enumMap=null;
		if(configFile != null){
			properties=new Properties();
			try {
				properties.load(configFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			enumMap=new HashMap<String,String>();
			for(Object propKey : properties.keySet()){
				if(propKey == null){
					continue;
				}
				String key=propKey.toString();
				enumMap.put(propKey.toString(), properties.getProperty(key));
			}
		}
		
		if(!saveToMemery && !saveToCache){
			return;
		}
		
		if(saveToMemery){
			memMap=enumMap;
		}else if(saveToCache){}
	}
	
	/**
	 * 重新加载缓存
	 */
	private void reloadCache(){}
	
	//根据key值获取配置文件中的值
	@SuppressWarnings("unchecked")
	public String getProperty(String key){
		if(saveToCache){}else if(saveToMemery && !memMap.isEmpty()){
			return memMap.get(key);
		}
		if(key.equals("machine_code")){
			return "01";
		}
		return properties.getProperty(key);
	}
	
	//根据key值获取配置文件中的值，并参数化
	@SuppressWarnings("unchecked")
	public String getProperty(String key,Object... args){
		String msg=null;
		if(saveToCache){}else if(saveToMemery && !memMap.isEmpty()){
			msg=memMap.get(key);
		}else{
			msg=properties.getProperty(key);
		}
		return MessageFormat.format(msg, args);
	}
	
	/**
	 * 获取系统环境配置
	 * @param key
	 * @return
	 */
	public static String getEnvProperty(String key){
		if(envMap == null){
			initEnvProperty();
		}
		return envMap.get(key);
	}
	
	//初始化环境配置
	private static void initEnvProperty(){
		Properties envprop=null;
		try {
			File envfile=ResourceUtils.getFile("classpath:environment.properties");
			envprop=new Properties();
			envprop.load(new FileInputStream(envfile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		envMap=new HashMap<String,String>();
		for(Object propKey : envprop.keySet()){
			if(propKey == null){
				continue;
			}
			String key=propKey.toString();
			envMap.put(propKey.toString(), envprop.getProperty(key));
		}
	}
}
