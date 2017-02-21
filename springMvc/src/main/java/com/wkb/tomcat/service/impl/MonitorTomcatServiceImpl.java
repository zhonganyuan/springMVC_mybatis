package com.wkb.tomcat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wkb.core.util.RemoteDataAndPage;
import com.wkb.tomcat.bean.MonitorTomcat;
import com.wkb.tomcat.dao.MonitorTomcatMapper;
import com.wkb.tomcat.service.MonitorTomcatService;
@Service("monitorTomcatService")
public class MonitorTomcatServiceImpl implements MonitorTomcatService{
	@Resource(name="monitorTomcatMapper")
	private MonitorTomcatMapper monitorTomcatMapper;
	/**
	 * 分页查询tomcat
	 */
	@Override
	public RemoteDataAndPage listTomcat(MonitorTomcat monitorTomcat) {
		RemoteDataAndPage remoteDataAndPage = new RemoteDataAndPage();
		List<MonitorTomcat> list = monitorTomcatMapper.listPAGETomcat(monitorTomcat);
		remoteDataAndPage.setDataList(list);
		remoteDataAndPage.setPage(monitorTomcat.getPage());
		return remoteDataAndPage;
	}
	/**
	 * 生成保存tomcat信息
	 */
	@Override
	public int inertTomcat(MonitorTomcat monitorTomcat) {
		int count = monitorTomcatMapper.insertSelective(monitorTomcat);
		return count;
	}
}
