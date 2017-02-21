package com.wkb.core.redis;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * 对于redis的template的选择
 * @author huanglt
 *
 */
public abstract class AbstractRedisTemplate<K extends Serializable,V extends Serializable> {

	@Autowired
	protected RedisTemplate<K,V> redisTemplate;

	public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	protected RedisSerializer<String> getRedisSerializer() {  
	    return redisTemplate.getStringSerializer();  
	}
}
