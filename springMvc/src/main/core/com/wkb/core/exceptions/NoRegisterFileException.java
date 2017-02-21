package com.wkb.core.exceptions;

/**
 * 没有在本系统中找到该注册文件
 * @author huanglt
 *
 */
public class NoRegisterFileException extends Throwable {

	private static final long serialVersionUID = 1L;
	
	public NoRegisterFileException(){
		super();
	}
	
	public NoRegisterFileException(String msg){
		super(msg);
	}
	
	public NoRegisterFileException(Throwable cause){
		super(cause);
	}
	
	public NoRegisterFileException(String msg,Throwable cause){
		super(msg,cause);
	}

}
