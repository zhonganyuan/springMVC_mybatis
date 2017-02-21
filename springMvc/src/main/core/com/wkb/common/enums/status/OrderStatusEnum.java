package com.wkb.common.enums.status;

/**
 * 订单状态Enum
 * @author liuqihe
 *
 */
public enum OrderStatusEnum {

	DEDUCTING(1, "待扣款"),
	NEEDRECHARGE(2, "待充值"),
	INSURING(3, "投保中"),
	INSURESUCCESS(4, "投保完成"),
	INSUREFAILURE(5, "投保失败"),
	;
	

	private int type;
	
	private String desc;
	
	private OrderStatusEnum(int type, String desc) {
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
    
    public static OrderStatusEnum getStatusByType(int type){
        for(OrderStatusEnum k:OrderStatusEnum.values()){
            if(k.getType()==type){
                return k;
            }
        }
        return null;
    }
}
