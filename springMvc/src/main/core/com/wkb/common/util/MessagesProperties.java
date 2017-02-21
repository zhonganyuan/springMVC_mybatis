package com.wkb.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.wkb.core.interfaces.PropertiesAnaly;

public class MessagesProperties extends PropertiesAnaly {

	// 配置文件
	private static File cfile;

	private static Logger logger = LoggerFactory
			.getLogger(MessagesProperties.class);

	private MessagesProperties(boolean saveToMemery) {
		super(saveToMemery);
	}

	// 获取对象实例
	public static MessagesProperties getInstance() {
		return Single.instance;
	}

	/*
	 * 设置配置文件
	 */
	@Override
	protected void setConfigFile() {
		try {
			// 初始化配置文件
			cfile = ResourceUtils.getFile("classpath:common/message.properties");
			configFile = new FileInputStream(cfile);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	private static class Single{
		private static MessagesProperties instance=new MessagesProperties(false);
	}
}
