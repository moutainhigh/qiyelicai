/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.web.controller.common.check;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.web.controller.common.vo.ShortMessageSendRequestVo;
import com.zillionfortune.t.web.controller.common.vo.ShortMessageVerifyRequestVo;

/**
 * ClassName: ShortMessageParameterChecker <br/>
 * Function: 短信服务参数校验. <br/>
 * Date: 2016年12月19日 下午4:57:15 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class ShortMessageParameterChecker {

	/**
	 * checkSendRequest:短信发送请求参数校验. <br/>
	 *
	 * @param req
	 * @throws Exception
	 */
	public void checkSendRequest(ShortMessageSendRequestVo req) throws Exception {
    
        if (req == null) {
            throw new BusinessException("请求对象ShortMessageSendRequestVo不能为空");
        }
        
        if (StringUtils.isBlank(req.getBusinessType())) {
        	throw new BusinessException("业务类型不能为空");
        }
        
        if (StringUtils.isBlank(req.getMobile())) {
        	throw new BusinessException("接收手机号码不能为空");
        }
     
    }
	
	/**
	 * checkVerifyRequest:短信验证码请求参数校验. <br/>
	 *
	 * @param req
	 * @throws Exception
	 */
	public void checkVerifyRequest(ShortMessageVerifyRequestVo req) throws Exception {
    
        if (req == null) {
            throw new BusinessException("请求对象ShortMessageVerifyRequestVo不能为空");
        }
        
        if (StringUtils.isBlank(req.getMobile())) {
        	throw new BusinessException("接收手机号码不能为空");
        }
     
        if (StringUtils.isBlank(req.getVerificationCode())){
        	throw new BusinessException("验证码不能为空");
        }
        
        if (StringUtils.isBlank(req.getBusinessType())) {
        	throw new BusinessException("业务类型不能为空");
        }
        
    }
	
}
