package com.wkb.common.util;

public class ProjectEnvironment {

	//运行环境
	public String environment;

	public String getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		System.out.println("set environment : " + environment);
		this.environment = environment;
	}
	
}
