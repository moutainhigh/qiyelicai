/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * ClassName: SmsCode <br/>
 * Function: 短信平台分配的短信编码. <br/>
 * Date: 2016年12月21日 上午9:16:59 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public enum SmsCode {
	
	REG("10000_REG","手机号码注册"),
	
	PUSH_EP_NO("10000_PUSH_EP_NO","注册成功推送企业号"),
	
	AUTH_SUCC("10000_AUTH_SUCC","认证审核通过"),
	
	AUTH_FAIL("10000_AUTH_FAIL","认证审核未通过"),
	
	CHG_AUTH("10000_CHG_AUTH","修改被授权人安全验证"),
	
	NEW_AUTH("10000_NEW_AUTH","新被授权人手机验证"),
	
	CHG_AUTH_SUCC("10000_CHG_AUTH_SUCC","修改被授权人审核通过"),
	
	CHG_AUTH_FAIL("10000_CHG_AUTH_FAIL","修改被授权人审核未通过"),
	
	APP_FPP("10000_APP_FPP","定期理财产品预约申请"),
	
	SEND_APP_FPP_CODE("10000_SEND_APP_FPP_CODE","定期理财产品预约码发送"),
	
	APP_FPP_SUCC("10000_APP_FPP_SUCC","定期理财产品预约成功"),
	
	APP_FPP_FAIL("10000_APP_FPP_FAIL","定期理财产品预约未成功"),
	
	FIND_EP_NO("10000_FIND_EP_NO","找回企业号"),
	
	SEND_EP_NO("10000_SEND_EP_NO","发送企业号"),
	
	RESET_LOGIN_PWD("10000_RESET_LOGIN_PWD","重置登录密码"),
	
	RESET_TRADE_PWD("10000_RESET_TRADE_PWD","重置交易密码"),
	
	CHG_LOGIN_PWD("10000_CHG_LOGIN_PWD","修改登录密码");
	
	private String code;
	private String desc;

    SmsCode(String code,String desc){
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
    	for(SmsCode item : SmsCode.values()){
    		if(StringUtils.equals(item.code, code)){
    			return item.desc();
    		}
    	}
    	
    	return null;
    }
    
}

