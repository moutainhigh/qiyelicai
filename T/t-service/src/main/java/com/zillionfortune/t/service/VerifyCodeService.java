/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.service;

import java.io.IOException;
import java.io.OutputStream;

import com.zillionfortune.t.dto.CheckVerifyCodeRequest;
import com.zillionfortune.t.dto.GenerateVerifyCodeRequest;


/**
 * ClassName: VerifyCodeService <br/>
 * Function: 图片验证码对外接口. <br/>
 * Date: 2016年12月13日 下午5:42:21 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface VerifyCodeService {
	
	/**
	 * getLoginCodeImage:获取图片验证码图片. <br/>
	 *
	 * @param req GenerateVerifyCodeRequest
	 * @param os OutputStream
	 * @return 
	 * @throws IOException 
	 */
	public void getLoginCodeImage(GenerateVerifyCodeRequest req, OutputStream os) throws IOException;
	
	/**
	 * checkCode:校验图片验证码. <br/>
	 *
	 * @param req CheckVerifyCodeRequest
	 * @return boolean
	 */
	public boolean checkCode(CheckVerifyCodeRequest req);
	
}
