package com.wkb.redis.dao;

import com.wkb.core.dao.interfaces.BaseMapper;
import com.wkb.redis.bean.MonitorRedis;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 由数据库表 monitor_redis 生成
 * 
 */
@Repository(value="monitorRedisMapper")
public interface MonitorRedisMapper extends BaseMapper {
    /**
     * 本方法的操作由数据库表  monitor_redis 生成
     * 根据主键删除表 monitor_redis 中的信息
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  monitor_redis 生成
     * 向表 monitor_redis 中插入一条数据
     */
    int insert(MonitorRedis record);

    /**
     * 本方法的操作由数据库表  monitor_redis 生成
     * 向表 monitor_redis 中有选择的插入一条数据
     */
    int insertSelective(MonitorRedis record);

    /**
     * 本方法的操作由数据库表  monitor_redis 生成
     * 根据主键获取表 monitor_redis 中信息
     */
    MonitorRedis selectByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  monitor_redis 生成
     * 根据主键有选择性的更新表 monitor_redis 数据
     */
    int updateByPrimaryKeySelective(MonitorRedis record);

    /**
     * 本方法的操作由数据库表  monitor_redis 生成
     * 更新表 monitor_redis 中数据
     */
    int updateByPrimaryKey(MonitorRedis record);
    /**
     * 分页获取redis信息
     * @param monitorRedis
     * @return
     */
	List<MonitorRedis> listPAGERedis(MonitorRedis monitorRedis);
}