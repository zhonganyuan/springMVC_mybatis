package com.wkb.user.service;

import com.wkb.core.util.RemoteDataAndPage;
import com.wkb.redis.bean.MonitorRedis;
import com.wkb.user.bean.MonitorUser;

public interface MonitorUserService {
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	MonitorUser findUserById(Integer id);
	/**
	 * 根据id 查询redis
	 * @param id
	 * @return
	 */
	MonitorRedis findRedis(Integer id);
	/**
	 * 根据userId查询
	 * @param userId 用户名
	 * @return
	 */
	MonitorUser getUserByUserId(String userId);
	/**
	 * 注册用户
	 * @param monitorUser
	 * @return
	 */
	int insertUser(MonitorUser monitorUser);
	/**
	 * 分页查询用户
	 * @param monitorUser
	 * @return
	 */
	RemoteDataAndPage listUser(MonitorUser monitorUser);
}
