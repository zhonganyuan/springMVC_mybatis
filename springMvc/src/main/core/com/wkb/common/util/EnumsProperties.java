package com.wkb.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

import com.wkb.core.interfaces.PropertiesAnaly;

/**
 * 常量配置
 * @author huanglt
 *
 */
public final class EnumsProperties extends PropertiesAnaly {

	//配置文件
	private static File cfile;
	
	
	private EnumsProperties(boolean saveToCache,String loadKey){
		super(saveToCache,loadKey);
	}
	
	//获取对象实例
	public static EnumsProperties getInstance(){
		return Single.instance;
	}
	
	/* 
	 * 设置配置文件
	 */
	@Override
	protected void setConfigFile() {
		if(!isload){
			return;
		}
		try {
			//初始化配置文件
			cfile=ResourceUtils.getFile("classpath:common/enums.properties");
			configFile=new FileInputStream(cfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static class Single {
		private static final EnumsProperties instance=new EnumsProperties(true,"enums.load");
	}

}
