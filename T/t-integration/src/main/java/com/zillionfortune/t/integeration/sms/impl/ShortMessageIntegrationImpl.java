/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.integeration.sms.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.common.util.HttpClientUtil;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.integeration.sms.ShortMessageIntegration;
import com.zillionfortune.t.integeration.sms.dto.ShortMessageServiceRequest;
import com.zillionfortune.t.integeration.sms.dto.ShortMessageServiceResponse;

/**
 * ClassName: ShortMessageIntegrationImpl <br/>
 * Function: 短信服务IntegrationImpl. <br/>
 * Date: 2016年12月16日 下午2:03:42 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */

@Component
public class ShortMessageIntegrationImpl implements ShortMessageIntegration {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${sms.send.url}")
	private String sendUrl;
	
	/**
	 * 短信发送.
	 * @see com.zillionfortune.t.integeration.sms.ShortMessageIntegration#send(java.lang.String, java.lang.Integer)
	 */
	@Override
	public ShortMessageServiceResponse send(ShortMessageServiceRequest req) throws Exception {
		
		log.info("ShortMessageIntegrationImpl.send.req:" + JSON.toJSONString(req) );
		
		//1.===参数校验
		if(req == null) {
			throw new BusinessException("请求对象req不能为空");
		}

		//2.===发送请求
		String sendResponseContent = HttpClientUtil.doJsonPost(sendUrl, JSON.toJSONString(req));
		
		if(StringUtils.isBlank(sendResponseContent) || sendResponseContent.length()<=1){
			throw new BusinessException("短信平台反馈内容为空");
		}
		
		sendResponseContent = sendResponseContent.replaceAll("\\\\", "");
		sendResponseContent = sendResponseContent.substring(1, sendResponseContent.length()-1);
		log.info("短信平台反馈结果"+sendResponseContent);
		//3.===处理反馈结果
		
		ShortMessageServiceResponse resp = JsonUtils.json2Object(sendResponseContent, ShortMessageServiceResponse.class);

		log.info("ShortMessageIntegrationImpl.send.resp:" + sendResponseContent);
		
		return resp;
				
	
	}

	public static void main(String[] args) {
		String s =  "{\\\"respCode\":0,\\\"resultCode\\\":0,\\\"resultDesc\\\":\\\"处理成功\\\"}";
		System.out.println(s);
		System.out.println(s.replaceAll("\\\\", ""));
		
	}

}
