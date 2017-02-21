package com.wkb.core.state.common;

import com.wkb.core.exceptions.InvalidRequestException;
import com.wkb.core.state.PolicyManager;
import com.wkb.core.state.PolicyState;

/**
 * 默认状态流入口处理实现
 * @author huanglt
 *
 */
public class CommonPolicyManager extends PolicyManager {

	public CommonPolicyManager(PolicyState defaultState){
		if(defaultState != null){
			pstate=defaultState;
		}
	}
	
	/**
	 * 初始化状态
	 */
	@Override
	public void initState(String state) {
		changeState(state);
	}

	@Override
	public String queryState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean surrender() throws InvalidRequestException {
		String state=pstate.surrender(policyId);
		changeState(state);
		return true;
	}

	@Override
	public boolean applyPay() throws InvalidRequestException {
		String state=pstate.applyPayment(policyId);
		changeState(state);
		return false;
	}

	@Override
	public boolean merchantSurrender() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String audit() throws InvalidRequestException {
		String state=pstate.audit(policyId);
		changeState(state);
		return null;
	}

}
