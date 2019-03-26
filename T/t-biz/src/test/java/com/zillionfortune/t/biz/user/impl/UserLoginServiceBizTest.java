/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user.impl;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.user.UserLoginBiz;
import com.zillionfortune.t.dto.CheckVerifyCodeRequest;
import com.zillionfortune.t.dto.LoginCodeRequest;
import com.zillionfortune.t.integeration.cif.dto.LoginOutRequest;
import com.zillionfortune.t.integeration.cif.dto.LoginRequest;

/**
 * ClassName: EnterpriseUserLoginServiceFacadeTest <br/>
 * Function: 企业_用户登入_单元测试类. <br/>
 * Date: 2016年11月23日 上午10:16:37 <br/>
 *
 * @author kaiyun
 * @version 
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-basic.xml")
@ActiveProfiles("dev")
public class UserLoginServiceBizTest {
	
	@Autowired
	UserLoginBiz userLoginBiz;
	
	// 模拟request,response  
    private MockHttpServletRequest request;  
    private MockHttpServletResponse response; 
    
    // 执行测试方法之前初始化模拟request,response  
    @Before    
    public void setUp(){    
        request = new MockHttpServletRequest();      
        request.setCharacterEncoding("UTF-8");      
        response = new MockHttpServletResponse();      
    }  
    
	
	/**
	 * 
	 * 企业理财登入. <br/>
	 *
	 */
	@Test
	public void test_login(){
		
		String customerNo = "100005";
		String loginName = "13816947328";
		String password = "zb123456aa"; // E10ADC3949BA59ABBE56E057F20F883E
		String loginSource = "1";
		
		//封装请求参数
		LoginRequest req = new LoginRequest();
		req.setCustomerNo(customerNo);
		req.setLoginName(loginName);
		req.setPassword(password);
		req.setLoginSource(loginSource);
		//执行
		BaseWebResponse  resp = userLoginBiz.login(req);
		//输出
		System.out.println(JSON.toJSONString(resp));
	}
	
	/**
	 * 
	 * 企业理财登出. <br/>
	 *
	 */
	@Test
	public void test_loginout(){
		
		String memberId = "EM201612200048241323176703";
		String operatorId = "22";
		String accessToken = "5789d3e82ded4e40b2701a9a778bbf53";
		
		//封装请求参数
		LoginOutRequest req = new LoginOutRequest();
		req.setMemberId(memberId);
		req.setOperatorId(operatorId);
		req.setAccessToken(accessToken);
		//执行
		BaseWebResponse  resp = userLoginBiz.loginout(req);
		//输出
		System.out.println(JSON.toJSONString(resp));
	}
	
	/**
	 * 获取图片验证码Token. <br/>
	 *
	 */
	@Test
	public void getLoginCode(){
		int verifySize = 4;
		LoginCodeRequest req = new LoginCodeRequest();
		req.setVerifySize(verifySize);
		BaseWebResponse  resp = userLoginBiz.getLoginCode(req);
		System.out.println(JSON.toJSONString(resp));
	}
	
	/**
	 * 获取图片验证码图片. <br/>
	 *
	 */
	@Test
	public void getLoginCodeImage(){
//		userLoginBiz.getLoginCodeImage(req, os);
	}
	
	
	/**
	 * test_checkCode:测试验证码. <br/>
	 *
	 */
	@Test
	public void checkLoginCode(){
		String verifyCode = "SD29";
		String codeAuth = "SD29_1482488454502";
		CheckVerifyCodeRequest req = new CheckVerifyCodeRequest(verifyCode,codeAuth);
		BaseWebResponse resp = userLoginBiz.checkLoginCode(req);
		System.out.println(JSON.toJSONString(resp));
		
		
	}
	
}
