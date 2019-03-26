/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.biz.common;

import com.zillionfortune.common.dto.BaseWebResponse;

/**
 * ClassName: ShortMessageBiz <br/>
 * Function: 短信服务Biz. <br/>
 * Date: 2016年12月16日 上午11:07:31 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface ShortMessageBiz {
	
	/**
	 * sendVerificationCode:发送验证码方法. <br/>
	 *
	 * @param mobile
	 * @param smsCode业务类型(短信平台分配)
	 * @return
	 * @throws
	 */
	public BaseWebResponse sendVerificationCode(String mobile,String smsCode);
	
	/**
	 * sendCommonCode:发送公共码值方法. <br/>
	 *
	 * @param mobile
	 * @param smsCode 业务类型(短信平台分配)
	 * @param code 码值(比如：商户号、预约码无需验证的)
	 * @return
	 */
	public BaseWebResponse sendCommonCode(String mobile,String smsCode,String code);
	
	/**
	 * sendCommonMessage:发送短信内容方法. <br/>
	 *
	 * @param mobile
	 * @param smsCode 业务类型(短信平台分配)
	 * @return
	 */
	public BaseWebResponse sendCommonMessage(String mobile,String smsCode);
	
	/**
	 * verify:短信码验证方法. <br/>
	 *
	 * @param mobile
	 * @param code 验证码
	 * @param smsCode 业务类型(短信平台分配)
	 * @return
	 * @throws
	 */
	public BaseWebResponse verifyVerificationCode(String mobile,String code,String smsCode);
	
	/**
	 * verifyRegisterMobile:发送短信之前校验手机号码是否注册过. <br/>
	 *
	 * @param mobile
	 * @return
	 * @throws
	 */
	public BaseWebResponse checkUserNameRegister(String mobile);
	
}
