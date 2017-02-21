package com.wkb.core.redis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.wkb.core.util.SerializeUtil;
import com.wkb.core.util.Tools;

/**
 * 对于redis操作的默认类
 * @author huanglt
 *
 */
public class DefaultRedisOperate extends AbstractRedisTemplate<String,RedisStruct> implements BaseRedisOperate{

	/**
	 * 添加单个对象
	 * @param struct 对象数据结构
	 * @param expirtime 过期时间
	 * @return
	 */
	@Override
	public boolean add(final RedisStruct struct,final long expirtime) {
		if(struct == null){
			return false;
		}
		boolean result=redisTemplate.execute(new RedisCallback<Boolean>(){
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();  
		        byte[] key  = serializer.serialize(struct.getKey());  
		        byte[] value = serializer.serialize(struct.getValue());
				connection.set(key, value);
				if(expirtime > 0){
		        	connection.expire(key, expirtime);
		        }
				return true;
			}
		});
		return result;
	}
	
	/**
	 * 添加单个对象
	 * @param struct 对象数据结构
	 * @return
	 */
	@Override
	public boolean add(final RedisStruct struct){
		return add(struct,0L);
	}
	
	/**
	 * 批量添加对象
	 * @param structs 对象数据结构
	 * @return
	 */
	@Override
	public boolean add(final List<RedisStruct> structs,final long expirtime){
		if(structs == null || structs.size() == 0){
			return false;
		}
		boolean result=redisTemplate.execute(new RedisCallback<Boolean>(){
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				for(RedisStruct struct : structs){
					if(struct == null){
						continue;
					}
					byte[] key  = serializer.serialize(struct.getKey());  
			        byte[] value = serializer.serialize(struct.getValue());
			        connection.set(key, value);
			        if(expirtime > 0){
						connection.expire(key, expirtime);
					}
				}
				return true;
			}
			
		},false,true);
		return result;
	}
	
	/**
	 * 批量添加对象
	 * @param structs 对象数据结构
	 * @return
	 */
	public boolean add(final List<RedisStruct> structs){
		return add(structs,0L);
	}
	
	/**
	 * 添加新的键值对
	 * @param key
	 * @param value
	 * @param expirtime
	 */
	@Override
	public boolean set(final String key,final String value,final long expirtime){
		if(Tools.isEmpty(key) || Tools.isEmpty(value)){
			return false;
		}
		boolean result=redisTemplate.execute(new RedisCallback<Boolean>(){
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keyb=serializer.serialize(key);
				connection.set(keyb, SerializeUtil.serialize(value));
				if(expirtime > 0){
					connection.expire(keyb, expirtime);
				}
				return true;
			}
		});
		return result;
	}
	
	/**
	 * 添加新的键值对
	 * @param key 键值
	 * @param value 值
	 */
	public boolean set(final String key,final String value){
		return set(key,value,0L);
	}
	
	/**
	 * 添加新键值对（值为对象）
	 * @param key 键值对
	 * @param obj 值对象
	 * @param expirtime 过期时间
	 * @return
	 */
	public boolean set(final String key,final Object obj,final long expirtime){
		if(Tools.isEmpty(key) || obj == null){
			return false;
		}
		boolean result=redisTemplate.execute(new RedisCallback<Boolean>(){
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keyb=serializer.serialize(key);
				connection.set(keyb, SerializeUtil.serialize(obj));
				if(expirtime > 0){
					connection.expire(keyb, expirtime);
				}
				return true;
			}
		});
		return result;
	}
	
	/**
	 * 添加新键值对（值为对象）
	 * @param key 键值对
	 * @param obj 值对象
	 * @return
	 */
	public boolean set(final String key,final Object obj){
		return set(key,obj,0L);
	}
	
	/**
	 * 当键值所对应的值不存在时添加对象并返回true
	 * @param key 键值
	 * @param obj 值对象
	 * @return
	 */
	public boolean setNx(final String key,final Object obj){
		return setNx(key,obj,0L);
	}
	
	/**
	 * 当键值所对应的值不存在时添加对象并返回true，并设置过期时间
	 * @param key 键值
	 * @param obj 值对象
	 * @param expirtime 过期时间
	 * @return
	 */
	public boolean setNx(final String key,final Object obj,final long expirtime){
		boolean result=redisTemplate.execute(new RedisCallback<Boolean>(){
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keyb=serializer.serialize(key);
				boolean issuc=connection.setNX(keyb, SerializeUtil.serialize(obj));
				if(issuc && expirtime > 0){
					connection.expire(keyb, expirtime);
				}
				return issuc;
			}
		});
		return result;
	}
	
	/**
	 * 根据键值删除对象
	 * @param key 键值
	 */
	public void delete(String key){
		if(Tools.isEmpty(key)){
			return;
		}
		redisTemplate.delete(key);
	}
	
	/**
	 * 根据键值删除多个对象
	 * @param keys 键值
	 */
	public void delete(List<String> keys){
		if(keys == null || keys.size() == 0){
			return;
		}
		redisTemplate.delete(keys);
	}
	
	/**
	 * 根据键值获取对象
	 * @param key 键值
	 * @return
	 */
	public RedisStruct get(final String key){
		if(Tools.isEmpty(key)){
			return null;
		}
		RedisStruct struct=redisTemplate.execute(new RedisCallback<RedisStruct>(){
			@Override
			public RedisStruct doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keyId=serializer.serialize(key);
				byte[] value=connection.get(keyId);
				if(value == null){
					return null;
				}
				return new RedisStruct(key,serializer.deserialize(value));
			}
			
		});
		return struct;
	}
	
	/**
	 * 根据key值获取对象
	 * @param key 键值
	 * @return
	 */
	public Object getObject(final String key){
		if(Tools.isEmpty(key)){
			return null;
		}
		Object obj=redisTemplate.execute(new RedisCallback<Object>(){
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keyId=serializer.serialize(key);
				byte[] value=connection.get(keyId);
				if(value == null){
					return null;
				}
				return SerializeUtil.unserialize(value);
			}
			
		});
		return obj;
	}
	
	/**
	 * 根据key值更新redis值
	 * @param struct 存储对象
	 * @return
	 */
	public boolean update(final RedisStruct struct){
		if(struct == null || struct.getKey() == null){
			return false;
		}
		final String key=struct.getKey();
		if(get(key) == null){
			throw new NullPointerException("数据不存在, key = " + key);
		}
		boolean result=redisTemplate.execute(new RedisCallback<Boolean>(){
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				connection.set(serializer.serialize(key), serializer.serialize(struct.getValue()));
				return true;
			}
		});
		return result;
	}
	
	/**
	 * 根据key值更新redis值
	 * @param key 键值
	 * @param obj 要更新的值
	 * @return
	 */
	public boolean update(final String key,final Object obj){
		if(Tools.isEmpty(key)){
			return false;
		}
		if(get(key) == null){
			throw new NullPointerException("数据不存在, key = " + key);
		}
		boolean result=redisTemplate.execute(new RedisCallback<Boolean>(){
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				connection.set(serializer.serialize(key), SerializeUtil.serialize(obj));
				return true;
			}
		});
		return result;
	}
	
	/**
	 * 清除所有值
	 */
	public boolean flushdb(){
		boolean result=redisTemplate.execute(new RedisCallback<Boolean>(){
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.flushDb();
				return true;
			}
			
		});
		return result;
	}
	
	/**
	 * 是否存在该键值
	 * @param key 键值
	 * @return
	 */
	public boolean exists(final String key){
		if(Tools.isEmpty(key)){
			return false;
		}
		boolean result=redisTemplate.execute(new RedisCallback<Boolean>(){
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.exists(key.getBytes());
			}
			
		});
		return result;
	}

}
