/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.biz.common;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zillionfortune.common.redis.StringRedisUtil;

/**
 * ClassName: ShortMessageRedisUtils <br/>
 * Function: 短信redis处理工具. <br/>
 * Date: 2016年12月20日 下午2:15:51 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */

@Component
public class ShortMessageRedisUtils {

	@Resource
	private StringRedisUtil stringRedisUtil;
	
	@Value("${redis.sms.verifycode.timeout}")
	private int verifyCodeTimeout;
  
	public void setCodeIntoRedis(String key,String value){
		
		stringRedisUtil.saveOrUpdate(key, value, verifyCodeTimeout);
	}
    
	public String getCodeFromRedis(String key){
		
		return stringRedisUtil.get(key);
		
	}
  
    
}
