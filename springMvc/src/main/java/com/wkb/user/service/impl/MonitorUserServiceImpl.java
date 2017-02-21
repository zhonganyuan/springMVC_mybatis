package com.wkb.user.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wkb.core.security.WkbCryption;
import com.wkb.core.util.GenerateUniqueCode;
import com.wkb.core.util.RemoteDataAndPage;
import com.wkb.redis.bean.MonitorRedis;
import com.wkb.redis.service.MonitorRedisService;
import com.wkb.user.bean.MonitorUser;
import com.wkb.user.dao.MonitorUserMapper;
import com.wkb.user.service.MonitorUserService;
@Service("monitorUserService")
public class MonitorUserServiceImpl implements MonitorUserService {
	@Resource(name="monitorUserMapper")
	private MonitorUserMapper monitorUserMapper;
	@Resource(name="monitorRedisService")
	private MonitorRedisService monitorRedisService;
	/**
	 * 根据id 查询用户
	 */
	@Override
	public MonitorUser findUserById(Integer id) {
		return monitorUserMapper.selectByPrimaryKey(id);
	}
	
	public MonitorRedis findRedis(Integer id){
		return monitorRedisService.selectById(id);
	}
	/**
	 * 根据userId 查询用户
	 */
	@Override
	public MonitorUser getUserByUserId(String userId) {
		MonitorUser monitorUser = monitorUserMapper.getUserByUserId(userId);
		return monitorUser;
	}
	/**
	 * 注册用户
	 */
	@Override
	public int insertUser(MonitorUser monitorUser) {
		monitorUser.setUserSalt(GenerateUniqueCode.getUUID());//设置盐值
		monitorUser.setUserPassword(WkbCryption.md5EncryptionWithSalt(monitorUser.getUserPassword(), monitorUser.getUserSalt()));//设置加密后的密码
		monitorUser.setCreateTime(new Date());
		int count = monitorUserMapper.insertSelective(monitorUser);
		return count;
	}
	/**
	 * 分页查询用户
	 */
	@Override
	public RemoteDataAndPage listUser(MonitorUser monitorUser) {
		RemoteDataAndPage remoteDateAndpage = new RemoteDataAndPage();
		List<MonitorUser> list = monitorUserMapper.listPAGEUser(monitorUser);
		remoteDateAndpage.setDataList(list);
		remoteDateAndpage.setPage(monitorUser.getPage());
		return remoteDateAndpage;
	}
}
