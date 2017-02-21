package com.wkb.core.redis;

import java.util.List;

/**
 * 对于redis的基础操作
 * @author huanglt
 *
 */
public interface BaseRedisOperate {

	/**
	 * 添加单个对象
	 * @param struct 对象数据结构
	 * @param expirtime 过期时间
	 * @return
	 */
	@Deprecated
	public boolean add(final RedisStruct struct,final long expirtime);
	
	/**
	 * 添加单个对象
	 * @param struct 对象数据结构
	 * @return
	 */
	@Deprecated
	public boolean add(final RedisStruct struct);
	
	/**
	 * 批量添加对象
	 * @param structs 对象数据结构
	 * @param expirtime 过期时间
	 * @return
	 */
	@Deprecated
	public boolean add(final List<RedisStruct> structs,final long expirtime);
	
	/**
	 * 批量添加对象
	 * @param structs 对象数据结构
	 * @return
	 */
	@Deprecated
	public boolean add(final List<RedisStruct> structs);
	
	/**
	 * 添加新的键值对
	 * @param key 键值
	 * @param value 值
	 * @param expirtime 过期时间
	 */
	public boolean set(final String key,final String value,final long expirtime);
	
	/**
	 * 添加新的键值对
	 * @param key 键值
	 * @param value 值
	 */
	public boolean set(final String key,final String value);
	
	/**
	 * 添加新键值对（值为对象）
	 * @param key 键值对
	 * @param obj 值对象
	 * @param expirtime 过期时间
	 * @return
	 */
	public boolean set(final String key,final Object obj,final long expirtime);
	
	/**
	 * 添加新键值对（值为对象）
	 * @param key 键值对
	 * @param obj 值对象
	 * @return
	 */
	public boolean set(final String key,final Object obj);
	
	/**
	 * 当键值所对应的值不存在时添加对象并返回true
	 * @param key 键值
	 * @param obj 值对象
	 * @return
	 */
	public boolean setNx(final String key,final Object obj);
	
	/**
	 * 当键值所对应的值不存在时添加对象并返回true，并设置过期时间
	 * @param key 键值
	 * @param obj 值对象
	 * @param expiretime 过期时间
	 * @return
	 */
	public boolean setNx(final String key,final Object obj,final long expirtime);
	
	/**
	 * 根据键值删除对象
	 * @param key 键值
	 */
	public void delete(String key);
	
	/**
	 * 根据键值删除多个对象
	 * @param keys 键值
	 */
	public void delete(List<String> keys);
	
	/**
	 * 根据键值获取对象
	 * @param key 键值
	 * @return
	 */
	@Deprecated
	public RedisStruct get(final String key);
	
	/**
	 * 根据key值获取对象
	 * @param key 键值
	 * @return
	 */
	public Object getObject(final String key);
	
	/**
	 * 根据key值更新redis值
	 * @param struct 存储对象
	 * @return
	 */
	@Deprecated
	public boolean update(final RedisStruct struct);
	
	/**
	 * 根据key值更新redis值
	 * @param key 键值
	 * @param obj 要更新的值
	 * @return
	 */
	public boolean update(final String key,final Object obj); 
	
	/**
	 * 清除所有值
	 */
	public boolean flushdb();
	
	/**
	 * 是否存在该键值
	 * @param key 键值
	 * @return
	 */
	public boolean exists(String key);
}
