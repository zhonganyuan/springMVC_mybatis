package com.wkb.core.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.wkb.common.util.SecurityProperties;

/**
 * 系统异常公共处理
 * @author huanglt
 *
 */
public class WkbExceptionResolver implements HandlerExceptionResolver {

	private static Logger logger = Logger.getLogger(WkbExceptionResolver.class);
	
	
	private static final boolean savedb=Boolean.parseBoolean(SecurityProperties.getInstance().getProperty("log.exmsgtodb"));
	
	private static final boolean debug=Boolean.parseBoolean(SecurityProperties.getInstance().getProperty("system.debug"));
	
	private static final String system_source=SecurityProperties.getEnvProperty("system.project_code");
	
	/* 
	 * 异常处理
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse response, Object handler, Exception ex) {
		//add by zhangjm 处理内容
		return new ModelAndView();
		
	}

}
