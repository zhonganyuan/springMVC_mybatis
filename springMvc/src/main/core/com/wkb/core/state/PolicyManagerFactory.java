package com.wkb.core.state;

import com.wkb.core.util.SpringContextHelper;

/**
 * 保单状态工厂类
 * @author huanglt
 *
 */
public class PolicyManagerFactory {

	private static PolicyManagerFactory _instance;
	
	private static final String PM_BEAN_NAME="policyManager";
	
	private PolicyManagerFactory(){}
	
	/**
	 * 获取该类实例对象
	 * @return
	 */
	public static PolicyManagerFactory getInstance(){
		if(_instance == null){
			_instance=new PolicyManagerFactory();
		}
		return _instance;
	}
	
	/**
	 * 获取无参保单状态对象实例对象
	 * @return
	 */
	public PolicyManager newPolicyManager(String policyId){
		PolicyManager pmanager=(PolicyManager)SpringContextHelper.getBean(PM_BEAN_NAME);
		pmanager.setPolicyId(policyId);
		return pmanager;
	}
	
	/**
	 * 根据订单状态获取保单状态入口实例对象
	 * @param state 保单状态
	 * @return
	 */
	public PolicyManager newPolicyManager(String policyId,String state){
		PolicyManager pmanager=(PolicyManager)SpringContextHelper.getBean(PM_BEAN_NAME);
		pmanager.setPolicyId(policyId);
		pmanager.initState(state);
		return pmanager;
	}
}
