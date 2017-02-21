package com.wkb.core.redis;

import com.wkb.core.util.SpringContextHelper;
import com.wkb.core.util.Tools;

/**
 * 获取redis操作的工厂类
 * @author huanglt
 *
 */
public class RedisOperateFactory {

	private static final String defaultRedisOperate="defaultRedisOperate";
	
	private static BaseRedisOperate ro_instance;
	
	/**
	 * 获取默认的redis操作类
	 * @return
	 */
	public static BaseRedisOperate getRedisOperate(){
		if(ro_instance == null){
			ro_instance=(BaseRedisOperate)SpringContextHelper.getBean(defaultRedisOperate);
		}
		return ro_instance;
	}
	
	/**
	 * 根据beanName获取redis操作类
	 * @param beanName
	 * @return
	 */
	public static BaseRedisOperate getRedisOperate(String beanName){
		if(Tools.isEmpty(beanName)){
			return null;
		}
		return (BaseRedisOperate)SpringContextHelper.getBean(beanName);
	}
}
