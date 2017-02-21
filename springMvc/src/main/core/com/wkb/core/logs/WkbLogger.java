package com.wkb.core.logs;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.Priority;

import com.wkb.common.util.SecurityProperties;
import com.wkb.core.util.ApplicationHelper;
import com.wkb.core.util.Tools;
import com.wkb.system.admin.bean.SysUser;


/**
 * 操作日志记录
 * @author huanglt
 *
 */
public class WkbLogger extends Logger {

	private Logger log4j;
	
	private static final String FQCN = WkbLogger.class.getName();
	
	private WkbLogger(String name) {
		super(name);
		log4j=LogManager.getLogger(name);
	}

	private static final String system_source=SecurityProperties.getEnvProperty("system.project_code");
	
	private void init(){
		SysUser sysUser=ApplicationHelper.getLoginUser();
		if(sysUser != null){
			MDC.put("userId", sysUser.getUserId());
			MDC.put("userType", sysUser.getUserType());
			MDC.put("userName", sysUser.getUserName());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static WkbLogger getLogger(Class clazz){
		return new WkbLogger(clazz.getName());
	}
	
	/**
	 * 根据级别记录日志
	 */
	public void log(Priority priority,Object msg){
		init();
		StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
		MDC.put("execute_class", stacks[2].getClassName());
		MDC.put("execute_method", stacks[2].getMethodName());
		String clientIp=ApplicationHelper.getClientIp();
		if(Tools.notEmpty(clientIp)){
			MDC.put("userIp", ApplicationHelper.getClientIp());
		}
		MDC.put("userSource", system_source);
		log4j.log(priority,msg);
	}
	
	/**
	 * 默认error级别记录自定义异常日志
	 * @param ex 异常信息
	 * @param msg 自定义信息
	 */
	public void customerError(Throwable ex,Object msg){
		customerError(Level.ERROR,ex,msg);
	}
	
	/**
	 * 记录自定义异常日志
	 * @param priority 级别
	 * @param ex 异常信息
	 * @param msg 自定义信息
	 */
	public void customerError(Priority priority,Throwable ex,Object msg){
		StringBuilder sb=new StringBuilder();
		sb.append(ex.getMessage()+":\n");
		StackTraceElement[] stacks=ex.getStackTrace();
		for(StackTraceElement ste : stacks){
			sb.append("		"+ste.toString()+"\n");
		}
		sb.append("Cause:"+ex.getCause()+"\n");
		sb.append("Customer Notes:"+msg+"\n");
		log(priority,sb.toString());
	}
	
	public void info(Object msg){
		log4j.info(msg);
	}
	
	public void info(Object msg,Throwable t){
		log4j.info(msg, t);
	}
	
	public void debug(Object msg){
		log4j.debug(msg);
	}
	
	public void debug(Object msg,Throwable t){
		log4j.debug(msg, t);
	}
	
	public void error(Object msg){
		log4j.error(msg);
	}
	
	public void error(Object msg,Throwable t){
		log4j.error(msg,t);
	}
	
	public void fatal(Object msg){
		log4j.fatal(msg);
	}
	
	public void fatal(Object msg,Throwable t){
		log4j.fatal(msg,t);
	}
	
	public void warn(Object msg){
		log4j.warn(msg);
	}
	
	public void warn(Object msg,Throwable t){
		log4j.warn(msg,t);
	}
	
	public void trace(Object msg){
		log4j.trace(msg);
	}
	
	public void trace(Object msg,Throwable t){
		log4j.trace(msg,t);
	}
	
	public void operate(Object msg){
		log(Operate.OPERATE,msg);
	}
}
