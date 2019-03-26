/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.common.constants;

/**
 * ClassName: CommonConstants <br/>
 * Function: 公用常量. <br/>
 * Date: 2016年11月9日 下午2:12:05 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class CommonConstants {

	/** 企业理财系统发送短息系统编码 */
	public static final String SMS_SYS_CODE = "10000";

	/** 企业理财系统发送短息验证码长度  默认6位 */
	public static final int SMS_CODE_LENGTH = 6;
	
	/** 企业理财系统发送短息验证码长度  默认不包含字符 */
	public static final boolean SMS_CONTAINS_CHAR = false;
	
	/** 发送短信反馈respCode成功默认是 */
	public static final int SMS_SUCCESS_RESP_CODE = 0;
	
	/** 发送短信反馈resultCode成功默认是 */
	public static final int SMS_SUCCESS_RESULT_CODE = 0;
	
}
