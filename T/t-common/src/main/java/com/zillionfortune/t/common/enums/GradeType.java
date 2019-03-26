/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.common.enums;

/**
 * ClassName: PersonCertType <br/>
 * Function: 等级类型. <br/>
 * Date: 2016年12月15日 下午2:53:50 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public enum GradeType {
	
	AUTH(1, "认证"),
	RISK(2, "风险"),TYPE3(3, ""),TYPE4(4, ""),TYPE5(5, ""),TYPE6(6, ""),TYPE7(7, ""),TYPE8(8, "");
	
	private int code;
	private String desc;
	
	private GradeType(int code, String desc) {
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
    	for(GradeType item : GradeType.values()){
    		if(item.code == code){
    			return item.desc();
    		}
    	}
    	
    	return null;
    }
	 
	public static GradeType getEnumItem(int code) {
		for (GradeType item : GradeType.values()) {
			if (item.code() == code) {
				return item;
			}
		}
		return null;
	}
	 
}
