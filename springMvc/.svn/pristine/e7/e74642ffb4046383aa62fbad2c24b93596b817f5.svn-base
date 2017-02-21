package com.wkb.redis.dao;

import org.springframework.stereotype.Repository;

import com.wkb.core.dao.interfaces.BaseMapper;
import com.wkb.redis.bean.WkbRedisInfo;

/**
 * 由数据库表 wkb_redis_info 生成
 * redis服务器信息表
 */
@Repository(value="wkbRedisInfoMapper")
public interface WkbRedisInfoMapper extends BaseMapper {
    /**
     * 本方法的操作由数据库表  wkb_redis_info 生成
     * 根据主键删除表 wkb_redis_info 中的信息
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  wkb_redis_info 生成
     * 向表 wkb_redis_info 中插入一条数据
     */
    int insert(WkbRedisInfo record);

    /**
     * 本方法的操作由数据库表  wkb_redis_info 生成
     * 向表 wkb_redis_info 中有选择的插入一条数据
     */
    int insertSelective(WkbRedisInfo record);

    /**
     * 本方法的操作由数据库表  wkb_redis_info 生成
     * 根据主键获取表 wkb_redis_info 中信息
     */
    WkbRedisInfo selectByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  wkb_redis_info 生成
     * 根据主键有选择性的更新表 wkb_redis_info 数据
     */
    int updateByPrimaryKeySelective(WkbRedisInfo record);

    /**
     * 本方法的操作由数据库表  wkb_redis_info 生成
     * 更新表 wkb_redis_info 中数据
     */
    int updateByPrimaryKey(WkbRedisInfo record);
}