package com.wkb.common.enums.status;

/**
 * 保单状态Enum
 * @author liuqihe
 *
 */
public enum InsuranceStatusEnum {

	AUDITING(1, "审核中"),
	AUDITFAILURE(2, "审核失败"),
	AUDITINSURE(3, "核保中"),
	AUDITINSUREFAILURE(4, "核保失败"),
	UNDERWRITE(5, "承保成功"),
	EFFECTIVE(7, "已生效"),
	EXPIRY(8, "已失效"),
	TERMINATION(9, "终止"),
	SETTLEMENTOFCLAIMS(10, "理赔中"),
	REVOKE(20, "撤单"),
	;
	
private int type;
	
	private String desc;
	
	private InsuranceStatusEnum(int type, String desc) {
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
    
    public static InsuranceStatusEnum getStatusByType(int type){
        for(InsuranceStatusEnum k:InsuranceStatusEnum.values()){
            if(k.getType()==type){
                return k;
            }
        }
        return null;
    }
}
