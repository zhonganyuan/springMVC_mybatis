package com.wkb.user.dao;

import com.wkb.core.dao.interfaces.BaseMapper;
import com.wkb.user.bean.MonitorUser;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 由数据库表 monitor_user 生成
 * 
 */
@Repository(value="monitorUserMapper")
public interface MonitorUserMapper extends BaseMapper {
    /**
     * 本方法的操作由数据库表  monitor_user 生成
     * 根据主键删除表 monitor_user 中的信息
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  monitor_user 生成
     * 向表 monitor_user 中插入一条数据
     */
    int insert(MonitorUser record);

    /**
     * 本方法的操作由数据库表  monitor_user 生成
     * 向表 monitor_user 中有选择的插入一条数据
     */
    int insertSelective(MonitorUser record);

    /**
     * 本方法的操作由数据库表  monitor_user 生成
     * 根据主键获取表 monitor_user 中信息
     */
    MonitorUser selectByPrimaryKey(Integer id);

    /**
     * 本方法的操作由数据库表  monitor_user 生成
     * 根据主键有选择性的更新表 monitor_user 数据
     */
    int updateByPrimaryKeySelective(MonitorUser record);

    /**
     * 本方法的操作由数据库表  monitor_user 生成
     * 更新表 monitor_user 中数据
     */
    int updateByPrimaryKey(MonitorUser record);
    /**
     * 根据userId 查询用户
     * @param userId 用户名
     * @return
     */
	MonitorUser getUserByUserId(String userId);
	/**
	 * 分页查询用户
	 * @param monitorUser
	 * @return
	 */
	List<MonitorUser> listPAGEUser(MonitorUser monitorUser);
	/**
	 * 查询全部用户
	 * @param monitorUser
	 * @return
	 */
	List<MonitorUser> listAllUser(MonitorUser monitorUser);
}