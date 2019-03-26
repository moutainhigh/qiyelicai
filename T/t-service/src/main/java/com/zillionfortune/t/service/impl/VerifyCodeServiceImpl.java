/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.service.impl;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zillionfortune.t.common.util.VerifyCodeUtils;
import com.zillionfortune.t.dto.CheckVerifyCodeRequest;
import com.zillionfortune.t.dto.GenerateVerifyCodeRequest;
import com.zillionfortune.t.service.VerifyCodeService;

/**
 * ClassName: UserLoginServiceFacadeImpl <br/>
 * Function: 企业_会员登录接口_实现. <br/>
 * Date: 2016年11月15日 下午5:01:18 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version
 * @since JDK 1.7
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {
	
	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@Override
	public void getLoginCodeImage(GenerateVerifyCodeRequest req, OutputStream os) throws IOException {
		//生成指定长度的验证码
//		String verifyCode = VerifyCodeUtils.generateVerifyCode(req.getVerifySize());
		String verifyCode = redisTemplate.opsForValue().get(req.getCodeAuth());
		//生成验证码图片
		VerifyCodeUtils.outputImage(req.getWidth(), req.getHeight(), os, verifyCode);
	}

	@Override
	public boolean checkCode(CheckVerifyCodeRequest req) {
		boolean result = false;
		//获取会话session信息
		String verifyCodeN = redisTemplate.opsForValue().get(req.getCodeAuth());
		//校验验证码(忽略大小写)
		if(!req.getVerifyCode().equalsIgnoreCase(verifyCodeN)){
			return false;
		}
		result=true;
		
		return result;
	}


}
