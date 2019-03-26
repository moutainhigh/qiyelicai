/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.common.enums;

/**
 * ClassName: EnterpriseType <br/>
 * Function: 企业类型枚举. <br/>
 * Date: 2016年12月19日 下午2:22:35 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public enum EnterpriseType {
	
	/** STATE_OWNED : 国有企业. */
	STATE_OWNED(1,"国有企业"),
	/** COLLECTIVE  集体所有制 */
	COLLECTIVE(2,"集体所有制"),
	/** PRIVATE  私营企业 */
	PRIVATE(3,"私营企业"),
	/** JOINT_STOCK  股份制企业 */
	JOINT_STOCK(4,"股份制企业"),
	/** ASSOCIATED  联营企业 */
	ASSOCIATED(5,"联营企业"),
	/** FOREIGN_INVERSTED  外商投资企业*/
	FOREIGN_INVERSTED(6,"外商投资企业"),
	/** GANG_AO_TAI  港、澳、台  */
	GANG_AO_TAI(7,"港、澳、台"),
	/** JOINT_EQUITY  股份合作企业  */
	JOINT_EQUITY(8,"股份合作企业");

	
	private int code;
	private String desc;
	
	private EnterpriseType(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int code() {
		return code;
	}
	
	public String desc() {
		return desc;
	}
	
	 public static String getDesc(int code){
    	for(EnterpriseType item : EnterpriseType.values()){
    		if(item.code == code){
    			return item.desc();
    		}
    	}
    	
    	return null;
    }
	 
	public static EnterpriseType getEnumItem(int code) {
		for (EnterpriseType item : EnterpriseType.values()) {
			if (item.code() == code) {
				return item;
			}
		}
		return null;
	}
	 
}
