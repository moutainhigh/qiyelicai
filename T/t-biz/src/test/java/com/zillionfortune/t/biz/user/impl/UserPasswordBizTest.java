package com.zillionfortune.t.biz.user.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.user.UserPasswordBiz;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordModifyRequest;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordRetrieveRequest;

/**
 * ClassName: UserPasswordBizTest <br/>
 * Function: 企业会员登录密码、交易密码相关测试. <br/>
 * Date: 2016年12月16日 下午5:52:41 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-basic.xml")
@ActiveProfiles("dev")
public class UserPasswordBizTest {
	
	@Autowired
	private UserPasswordBiz userPasswordBiz;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * retrieveLoginPasswordTest:企业会员重置登录密码. <br/>
	 *
	 */
	@Test
	public void retrieveLoginPasswordTest(){ 

		UserLoginPasswordRetrieveRequest req = new UserLoginPasswordRetrieveRequest();
		req.setCustomerNo("100004");
		req.setUserName("wzn");
		req.setNewPassword("aaBB22w");
		
		BaseWebResponse resp = userPasswordBiz.retrieveLoginPassword(req);

		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
	}
	
	/**
	 * modifyLoginPasswordTest:企业会员更新登录密码. <br/>
	 *
	 */
	@Test
	public void modifyLoginPasswordTest(){ 

		UserLoginPasswordModifyRequest req = new UserLoginPasswordModifyRequest();
		req.setMemberId("100001100004");
		req.setOperatorId("5");
		req.setOrgiPassword("WWWWWW3");
		req.setNewPassword("aaBB22w");
		
		BaseWebResponse resp = userPasswordBiz.modifyLoginPassword(req);

		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
	}
	
	/**
	 * retrieveTradePasswordTest:企业会员重置交易密码. <br/>
	 *
	 */
	@Test
	public void retrieveTradePasswordTest(){ 

		String memberId = "100001100004";
		String newPassword = "aaa2Eww";
		BaseWebResponse resp = userPasswordBiz.retrieveTradePassword(memberId, newPassword);

		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
	}
	
	/**
	 * modifyTradePasswordTest:企业会员更新交易密码. <br/>
	 *
	 */
	@Test
	public void modifyTradePasswordTest(){ 

		String memberId = "100001100004";
		String newPassword = "aaa2Eww";
		String orgiPassword = "TTTWWW2";
		BaseWebResponse resp = userPasswordBiz.modifyTradePassword(memberId, newPassword, orgiPassword);
		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
	}
	
	/**
	 * verifyTradePasswordTest:企业会员验证交易密码. <br/>
	 *
	 */
	@Test
	public void verifyTradePasswordTest(){ 

		String memberId = "100001100004";
		String password = "aaa2Eww";
		BaseWebResponse resp = userPasswordBiz.verifyTradePassword(memberId, password);
		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
	}
	
	/**
	 * setTradePasswordTest:企业会员设置交易密码. <br/>
	 *
	 */
	@Test
	public void setTradePasswordTest(){ 

		String memberId = "100001100004";
		String password = "aaa2Eww";
		BaseWebResponse resp = userPasswordBiz.setTradePassword(memberId, password);
		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
	}

}
