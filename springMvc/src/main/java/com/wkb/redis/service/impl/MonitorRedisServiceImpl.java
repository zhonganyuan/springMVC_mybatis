package com.wkb.redis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wkb.core.util.RemoteDataAndPage;
import com.wkb.redis.bean.MonitorRedis;
import com.wkb.redis.dao.MonitorRedisMapper;
import com.wkb.redis.service.MonitorRedisService;

@Service("monitorRedisService")
public class MonitorRedisServiceImpl implements MonitorRedisService{
	@Resource(name="monitorRedisMapper")
	private MonitorRedisMapper monitorRedisMapper;
	@Override
	public MonitorRedis selectById(Integer id) {
		return monitorRedisMapper.selectByPrimaryKey(id);
	}
	/**
	 *分页获取reids
	 */
	@Override
	public RemoteDataAndPage listRedis(MonitorRedis monitorRedis) {
		RemoteDataAndPage remoteDataAndPage = new RemoteDataAndPage();
		List<MonitorRedis> list = monitorRedisMapper.listPAGERedis(monitorRedis);
		remoteDataAndPage.setDataList(list);
		remoteDataAndPage.setPage(monitorRedis.getPage());
		return remoteDataAndPage;
	}
	
}
