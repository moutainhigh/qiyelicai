package com.zillionfortune.t.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author zhengrunlong
 * @date 2016/11/10
 */
public enum RespCode {
	
	/** 000000: 处理成功 **/
	SUCCESS("000000","响应成功"),
	
	/** 999999: 系统异常 **/
	FAIL("999999","系统异常"),
	
	/** 0000: 短信系统响应成功 **/
	SUCCESS_SMS("0000","响应成功"),
	
	/** 9999: 短信系统响应失败 **/
	FAIL_SMS("9999","响应失败");
	
	private String code;
	private String desc;

    RespCode(String code,String desc){
        this.code=code;
        this.desc=desc;
    }

    public String code(){
        return code;
    }

    public String desc(){
        return desc;
    }
    
    public static String getDesc(String code){
    	for(RespCode item : RespCode.values()){
    		if(StringUtils.equals(item.code, code)){
    			return item.desc();
    		}
    	}
    	
    	return null;
    }
    
}
