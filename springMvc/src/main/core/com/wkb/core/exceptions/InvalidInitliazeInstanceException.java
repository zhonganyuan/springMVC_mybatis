package com.wkb.core.exceptions;

/**
 * 没有被正确初始化异常
 * @author huanglt
 *
 */
public class InvalidInitliazeInstanceException extends Throwable {

	private static final long serialVersionUID = 1L;

	public InvalidInitliazeInstanceException(){
		super();
	}
	
	public InvalidInitliazeInstanceException(String mes){
		super(mes);
	}
	
	public InvalidInitliazeInstanceException(Throwable cause){
		super(cause);
	}
	
	public InvalidInitliazeInstanceException(String mes,Throwable cause){
		super(mes,cause);
	}
}
