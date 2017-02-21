package com.wkb.core.util;

import java.io.Serializable;
import java.util.List;

/**
 * 解决dubbo客户端访问，返回页码信息，和数据
 * @author luo
 *
 */
public class RemoteDataAndPage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<?> dataList;
	Page page;
	public List<?> getDataList() {
		return dataList;
	}
	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	
}
