package com.wkb.common.enums.status;

public enum MerchantInnerStatus {

	build("1", "项目立项", new String []{"1","2"}),
	talk("2", "商务洽谈", new String []{"2","3","7"}),
	develop("3", "产品研发", new String []{"3","4","7"}),
	connect("4", "技术对接", new String []{"4","5","7"}),
	online("5", "上线运营", new String []{"5","6"}),
	suspend("6", "暂停合作", new String []{"5","6"}),
	stop("7", "项目终止", new String []{"7","1"});
	
	private String type;
	
	private String desc;
	
	private String[] next;
	
	private MerchantInnerStatus(String type, String desc, String[] next) {
		
		this.type = type;
		this.desc = desc;
		this.next = next;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String[] getNext() {
		return next;
	}

	public void setNext(String[] next) {
		this.next = next;
	}

	/**
	 * 根据type获得
	 */
	public static MerchantInnerStatus getStatusByType(String type){
        for(MerchantInnerStatus k:MerchantInnerStatus.values()){
            if(k.getType().equals(type)){
                return k;
            }
        }
        return null;
    }
	
	/**
	 * 根据type获得desc
	 */
	public static String getDescByType(String type) {
		
		return getStatusByType(type).getDesc();
	}
	
	/**
	 * 根据type获得下一状态的type列表
	 */
	public static String[] getNextByType(String type) {
		
		return getStatusByType(type).getNext();
	}
	
	/**
	 * 根据desc获得type
	 */
	public static MerchantInnerStatus getTypeByStatus(String desc){
        for(MerchantInnerStatus k:MerchantInnerStatus.values()){
            if(k.getDesc().equals(desc)){
                return k;
            }
        }
        return null;
    }

}
