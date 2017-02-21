package com.wkb.core.listeners;

import javax.servlet.ServletContextEvent;

import com.wkb.common.util.EnumsProperties;
import com.wkb.core.listener.WebContextListener;

/**
 * 基础工程容器启动初始化
 * @author huanglt
 *
 */
public class BaseDataContextListener extends WebContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce){
		super.contextInitialized(sce);
		//初始化enum配置文件，不要注释掉
		EnumsProperties.getInstance();
	}
}
