package com.wkb.tomcat.service;

import com.wkb.core.util.RemoteDataAndPage;
import com.wkb.tomcat.bean.MonitorTomcat;

public interface MonitorTomcatService {
	/**
	 * 分页查询tomcat
	 * @param monitorTomcat
	 * @return
	 */
	RemoteDataAndPage listTomcat(MonitorTomcat monitorTomcat);
	/**
	 * 生成保存tomcat信息
	 * @param monitorTomcat
	 * @return
	 */
	int inertTomcat(MonitorTomcat monitorTomcat);
}
