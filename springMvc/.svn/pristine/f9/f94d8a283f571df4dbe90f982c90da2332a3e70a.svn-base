package com.wkb.common.enums.status;

/**
 * 理赔状态集
 * @author liuqihe
 *
 */
public enum ClaimsStatusEnum {

	PENDING(0,"待处理","理赔申请"),
	REJECTREQUEST(1,"驳回","驳回"),
	ACCEPTED(2,"已受理","受理"),
	CHECKING(3,"核赔中","核赔"),
	CHECKINGALL(4,"核赔中(含保单)","核赔(含保单)"),
	REJECTCLAIMS(5,"拒绝理赔","拒赔"),
	COMPENSATING(6,"待赔偿","通过核赔"),
	FINISH(7,"理赔结束","结束理赔"),
	FINISHALL(8,"理赔结束(含保单)","结束理赔(含保单)"),
	REVOCAT(9, "用户撤销","用户撤销"),
	;
	//状态
	private int type;
	//状态描述
	private String desc;
	//状态操作
	private String operation;

	private ClaimsStatusEnum(int type, String desc, String operation) {
        this.type = type;
        this.desc = desc;
    }
	
	public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
    
    public static ClaimsStatusEnum getStatusByType(int type){
        for(ClaimsStatusEnum k:ClaimsStatusEnum.values()){
            if(k.getType()==type){
                return k;
            }
        }
        return null;
    }
}
