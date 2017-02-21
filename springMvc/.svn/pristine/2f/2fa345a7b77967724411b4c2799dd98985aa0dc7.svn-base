package com.wkb.core.data;

/**
 * 动态数据源控制
 * @author huanglt
 *
 */
public class DynamicDataSourceHolder {

	public static final ThreadLocal<String> holder = new ThreadLocal<String>();
	
	/**
	 * 设置数据源名称
	 * @param name
	 */
	public static void putDataSource(String name){
		holder.set(name);
	}
	
	/**
	 * 获取数据源名称
	 */
	public static String getDataSource(){
		return holder.get();
	}
	
	//清除数据源
    public static void clearDataSource() {
    	holder.remove();
    }
}
