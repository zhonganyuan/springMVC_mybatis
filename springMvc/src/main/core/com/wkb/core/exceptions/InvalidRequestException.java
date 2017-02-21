package com.wkb.core.exceptions;

/**
 * 非法的请求
 * @author huanglt
 *
 */
public class InvalidRequestException extends Throwable {

	private static final long serialVersionUID = 1L;
	
	public InvalidRequestException(){
		super();
	}
	
	public InvalidRequestException(String mes){
		super(mes);
	}
	
	public InvalidRequestException(Throwable cause){
		super(cause);
	}
	
	public InvalidRequestException(String mes,Throwable cause){
		super(mes,cause);
	}

}
