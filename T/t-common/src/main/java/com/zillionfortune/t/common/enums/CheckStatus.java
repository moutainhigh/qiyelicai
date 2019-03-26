/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.common.enums;

/**
 * ClassName: CheckStatus <br/>
 * Function: 被授权人_授权审核状态. <br/>
 * Date: 2016年12月16日 下午3:54:05 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public enum CheckStatus {
	
	/**
	 * CHECK_WAIT:待审核
	 */
	CHECK_WAIT(0,"待审核"),
	
	/**
	 * CHECK_PASS_REVIEWING:审核通过待复核
	 */
	CHECK_PASS_REVIEWING(1,"审核通过待复核"),
	
	/**
	 * CHECK_NOT_PASS:审核不通过
	 */
	CHECK_NOT_PASS(2,"审核不通过"),
	
	/**
	 * CHECK_PASS_REVIEW_PASS:审核通过复核通过
	 */
	CHECK_PASS_REVIEW_PASS(3,"审核通过复核通过"),
	
	/**
	 * CHECK_PASS_REVIEW_NOT_PASS:审核通过复核不通过
	 */
	CHECK_PASS_REVIEW_NOT_PASS(4,"审核通过复核不通过"),
	
	/**
	 * CHECK_DISCARD:废弃
	 */
	CHECK_DISCARD(9,"废弃");
	
	private int code;
	private String desc;
	
	private CheckStatus(int code, String desc) {
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
    	for(CheckStatus item : CheckStatus.values()){
    		if(item.code == code){
    			return item.desc();
    		}
    	}
    	
    	return null;
    }
	 
	public static CheckStatus getEnumItem(int code) {
		for (CheckStatus item : CheckStatus.values()) {
			if (item.code() == code) {
				return item;
			}
		}
		return null;
	}
}
