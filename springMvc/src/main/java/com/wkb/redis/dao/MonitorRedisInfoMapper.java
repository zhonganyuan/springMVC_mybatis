package com.wkb.redis.dao;

import com.wkb.core.dao.interfaces.BaseMapper;
import com.wkb.redis.bean.MonitorRedisInfo;
import org.springframework.stereotype.Repository;

/**
 * 由数据库表 monitor_redis_info 生成
 * 
 */
@Repository(value="monitorRedisInfoMapper")
public interface MonitorRedisInfoMapper extends BaseMapper {
    /**
     * 本方法的操作由数据库表  monitor_redis_info 生成
     * 根据主键删除表 monitor_redis_info 中的信息
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  monitor_redis_info 生成
     * 向表 monitor_redis_info 中插入一条数据
     */
    int insert(MonitorRedisInfo record);

    /**
     * 本方法的操作由数据库表  monitor_redis_info 生成
     * 向表 monitor_redis_info 中有选择的插入一条数据
     */
    int insertSelective(MonitorRedisInfo record);

    /**
     * 本方法的操作由数据库表  monitor_redis_info 生成
     * 根据主键获取表 monitor_redis_info 中信息
     */
    MonitorRedisInfo selectByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  monitor_redis_info 生成
     * 根据主键有选择性的更新表 monitor_redis_info 数据
     */
    int updateByPrimaryKeySelective(MonitorRedisInfo record);

    /**
     * 本方法的操作由数据库表  monitor_redis_info 生成
     * 更新表 monitor_redis_info 中数据
     */
    int updateByPrimaryKey(MonitorRedisInfo record);
}