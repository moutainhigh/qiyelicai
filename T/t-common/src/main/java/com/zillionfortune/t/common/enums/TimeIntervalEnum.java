/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.common.enums;

/**
 * ClassName: TimeIntervalEnum <br/>
 * Function: 对账管理_时间区间. <br/>
 * Date: 2016年12月16日 下午3:54:05 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public enum TimeIntervalEnum {
	
	/**
	 * CURRENT_DAY:当天[1]
	 */
	CURRENT_DAY("1","当天"),
	
	/**
	 * RECENT_ONE_WEEK:最近一周[2]
	 */
	RECENT_ONE_WEEK("2","最近一周"),
	
	/**
	 * RECENT_ONE_MONTH:最近一个月[3]
	 */
	RECENT_ONE_MONTH("3","最近一个月"),
	
	/**
	 * RECENT_THREE_MONTH:最近三个月[4]
	 */
	RECENT_THREE_MONTH("4","最近三个月"),
	
	/**
	 * RECENT_HALF_YEAR:最近半年[5]
	 */
	RECENT_HALF_YEAR("5","最近半年"),
	
	/**
	 * RECENT_ONE_YEAR:最近一年[6]
	 */
	RECENT_ONE_YEAR("6","最近一年");
	
	
	private String code;
	private String desc;
	
	private TimeIntervalEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String code() {
		return code;
	}
	
	public String desc() {
		return desc;
	}
	
	 public static String getDesc(String code){
    	for(TimeIntervalEnum item : TimeIntervalEnum.values()){
    		if(item.code == code){
    			return item.desc();
    		}
    	}
    	
    	return null;
    }
	 
	public static TimeIntervalEnum getEnumItem(String code) {
		for (TimeIntervalEnum item : TimeIntervalEnum.values()) {
			if (item.code() == code) {
				return item;
			}
		}
		return null;
	}
}
