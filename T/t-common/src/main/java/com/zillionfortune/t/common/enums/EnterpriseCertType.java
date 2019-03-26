/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.common.enums;

/**
 * ClassName: EnterpriseCertType <br/>
 * Function: 企业证件类型枚举. <br/>
 * Date: 2016年12月15日 下午2:55:07 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public enum EnterpriseCertType {
	
	BUSINESS_LICENSE(1,"普通营业执照（非三证合一）"),
	
	SOCIAL_CREDIT_CERTIFICATE(2,"社会信用代码证（三证合一）"),
	
	OTHER_CERTIFICATE(3,"其他");
	
	private int code;
	private String desc;
	
	private EnterpriseCertType(int code, String desc) {
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
    	for(EnterpriseCertType item : EnterpriseCertType.values()){
    		if(item.code == code){
    			return item.desc();
    		}
    	}
    	
    	return null;
    }
	 
	public static EnterpriseCertType getEnumItem(int code) {
		for (EnterpriseCertType item : EnterpriseCertType.values()) {
			if (item.code() == code) {
				return item;
			}
		}
		return null;
	}
	 
}
