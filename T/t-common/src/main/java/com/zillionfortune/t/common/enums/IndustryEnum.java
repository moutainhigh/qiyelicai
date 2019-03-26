/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.common.enums;

/**
 * ClassName: EnterpriseType <br/>
 * Function: 企业所属行业枚举. <br/>
 * Date: 2016年12月19日 下午2:22:35 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public enum IndustryEnum {
	
	/** AGRICULTURE : 农、林、牧、渔业. */
	AGRICULTURE(1,"农、林、牧、渔业"),
	/** MINING  采矿业 */
	MINING(2,"采矿业"),
	/** MANUFACTURING  制造业 */
	MANUFACTURING(3,"制造业"),
	/** PRODUCTION_SUPPLY  电力、热力、燃气及水的生产和供应业 */
	PRODUCTION_SUPPLY(4,"电力、热力、燃气及水的生产和供应业"),
	/** PUBLIC_FACILITIES_MANAGEMENT  环境和公共设施管理业 */
	PUBLIC_FACILITIES_MANAGEMENT(5,"环境和公共设施管理业"),
	/** CONSTRUCTION  建筑业*/
	CONSTRUCTION(6,"建筑业"),
	/** TRANSPORTATION  交通运输、仓储业和邮政业  */
	TRANSPORTATION(7,"交通运输、仓储业和邮政业"),
	/** INFORMATION_TRANS  信息传输、计算机服务和软件业  */
	INFORMATION_TRANS(8,"信息传输、计算机服务和软件业"),
	/** RETAIL_SALES  批发和零售业  */
	RETAIL_SALES(9,"批发和零售业"),
	/** ACCOMMODATION_CATERING  住宿、餐饮业  */
	ACCOMMODATION_CATERING (10,"住宿、餐饮业"),
	/** FINANCE_INSURANCE  金融、保险业  */
	FINANCE_INSURANCE(11,"金融、保险业"),
	/** REALESTATE  房地产业  */
	REALESTATE(12,"房地产业"),
	/** LEASING_BUSINESS  租赁和商务服务业  */
	LEASING_BUSINESS(13,"租赁和商务服务业"),
	/** GEOLOGICAL_PROSPECTING  科学研究、技术服务和地质勘查业*/
    GEOLOGICAL_PROSPECTING(14,"科学研究、技术服务和地质勘查业"),
	/** WATER_CONSERVANCY  水利、环境和公共设施管理业  */
    WATER_CONSERVANCY(15,"水利、环境和公共设施管理业"),
	/** COMMUNITY_SERVICE  居民服务和其他服务业 */
    COMMUNITY_SERVICE(16,"居民服务和其他服务业"),
	/** EDUCATION  教育  */
    EDUCATION(17,"教育"),
    /** HEALTH_SECURITY 卫生、社会保障和社会服务业 */
    HEALTH_SECURITY(18,"卫生、社会保障和社会服务业"),
	/** CULTURAL_ENTERTAINMENT  文化、体育、娱乐业 */
    CULTURAL_ENTERTAINMENT(19,"文化、体育、娱乐业"),
	/** COMPREHENSIVE  综合（含投资类、主业不明显）  */
    COMPREHENSIVE(20,"综合（含投资类、主业不明显）"),
    /** EDUCATION  其它  */
    OTHER(21,"其它");

	
	private int code;
	private String desc;
	
	private IndustryEnum(int code, String desc) {
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
    	for(IndustryEnum item : IndustryEnum.values()){
    		if(item.code == code){
    			return item.desc();
    		}
    	}
    	
    	return null;
    }
	 
	public static IndustryEnum getEnumItem(int code) {
		for (IndustryEnum item : IndustryEnum.values()) {
			if (item.code() == code) {
				return item;
			}
		}
		return null;
	}
	 
}
