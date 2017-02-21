package com.wkb.core.state;

import com.wkb.core.exceptions.InvalidRequestException;

/**
 * 保单状态抽象类
 * @author huanglt
 *
 */
public abstract class PolicyState {
	
	/**
	 * 核保
	 * @param policyId 保单ID
	 * @return
	 * @throws InvalidRequestException 
	 */
	public String audit(String policyId) throws InvalidRequestException{
		throw new InvalidRequestException("非法的请求");
	}
	
	/**
	 * 退保
	 * @param policyId
	 * @return
	 * @throws InvalidRequestException
	 */
	public String surrender(String policyId)throws InvalidRequestException{
		throw new InvalidRequestException("非法的请求");
	}
	
	/**
	 * 商户退保
	 * @param policyId 保单号
	 * @return
	 * @throws InvalidRequestException 
	 */
	public String merchantSurrender(String policyId) throws InvalidRequestException{
		throw new InvalidRequestException("非法的请求");
	}
	
	/**
	 * 违约终止
	 * @param policyId 保单号
	 * @return
	 * @throws InvalidRequestException 
	 */
	public String breakSurrender(String policyId) throws InvalidRequestException{
		throw new InvalidRequestException("非法的请求");
	}
	
	/**
	 * 商户解除
	 * @param policyId 保单号
	 * @return
	 * @throws InvalidRequestException 
	 */
	public String merchantRelieve(String policyId) throws InvalidRequestException{
		throw new InvalidRequestException("非法的请求");
	}
	
	/**
	 * 供应商解除
	 * @param policyId 保单号
	 * @return
	 * @throws InvalidRequestException 
	 */
	public String suppliersRelieve(String policyId) throws InvalidRequestException{
		throw new InvalidRequestException("非法的请求");
	}
	
	/**
	 * 申请理赔
	 * @throws InvalidRequestException 
	 */
	public String applyPayment(String policyId) throws InvalidRequestException{
		throw new InvalidRequestException("非法的请求");
	}
}
