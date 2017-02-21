package com.wkb.core.listener;

import java.io.FileNotFoundException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.ContextLoaderListener;
import com.wkb.common.util.Constant;

/**
 * 容器监听
 * @author huanglt
 *
 */
public class WebContextListener extends ContextLoaderListener {

	private static Logger logger=LoggerFactory.getLogger(WebContextListener.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent sce){
		super.contextDestroyed(sce);
	}

	/* (non-Javadoc)
	 * 容器初始化监听
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc=sce.getServletContext();
		Constant.System.SERVLET_CONTEXT=sc;
		Constant.System.ENVIRONMENT=sc.getInitParameter("spring.profiles.default");
		logger.info("启动环境："+Constant.System.ENVIRONMENT);
		super.contextInitialized(sce);
		
		//根据环境不同加载不同的log4j配置文件
		String log4jPath=null;
		try {
			log4jPath = ResourceUtils.getFile("classpath:common/"+Constant.System.ENVIRONMENT+"/log4j.properties").getPath();
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		if(log4jPath != null){
			PropertyConfigurator.configure(log4jPath);
		}
	}

}
