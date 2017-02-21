package com.wkb.core.state;

import com.wkb.common.util.PolicyStateProperties;
import com.wkb.core.exceptions.InvalidRequestException;
import com.wkb.core.util.SpringContextHelper;
import com.wkb.core.util.Tools;

/**
 * 保单状态流入口接口
 * @author huanglt
 *
 */
public abstract class PolicyManager {

	protected PolicyState pstate;
	
	protected String policyId;  //保单Id
	
	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	
	/**
	 * 根据flag更改状态
	 * @param flag beanName配置或beanName
	 */
	protected void changeState(String flag){
		String beanName=PolicyStateProperties.getInstance().getProperty(flag);
		if(Tools.notEmpty(beanName)){
			pstate=(PolicyState)SpringContextHelper.getBean(beanName);
			
		}else{
			pstate=(PolicyState)SpringContextHelper.getBean(flag);
		}
		if(pstate == null){
			throw new NullPointerException("保单状态没有注册！");
		}
	}

	/**
	 * 初始化对象保单状态
	 * @param state
	 */
	public abstract void initState(String state);
	
	/**
	 * 审核保单
	 * @return
	 * @throws InvalidRequestException 
	 */
	public abstract String audit() throws InvalidRequestException;
	
	/**
	 * 查询保单状态
	 * @param policyId
	 * @return
	 */
	public abstract String queryState();
	
	/**
	 * 撤单
	 * @param policyId
	 * @return
	 * @throws InvalidRequestException 
	 */
	public abstract boolean surrender() throws InvalidRequestException;
	
	/**
	 * 申请理赔
	 * @param policyId
	 * @return
	 * @throws InvalidRequestException 
	 */
	public abstract boolean applyPay() throws InvalidRequestException;
	
	/**
	 * 商家退保
	 * @param policyId
	 * @return
	 */
	public abstract boolean merchantSurrender();
}
