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
import com.zillionfortune.t.biz.common.ShortMessageBiz;

/**
 * ClassName: ShortMessageBizTest <br/>
 * Function: 短信服务测试. <br/>
 * Date: 2016年12月15日 下午4:43:41 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-basic.xml")
@ActiveProfiles("dev")
public class ShortMessageBizTest {
	
	@Autowired
	private ShortMessageBiz shortMessageBiz;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * testSend:发送短信验证. <br/>
	 *
	 */
	@Test
	public void testSend(){

		BaseWebResponse resp = shortMessageBiz.sendVerificationCode("13764752550", "10000_REGp");
		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
	}
	
	/**
	 * testVerify:验证码验证. <br/>
	 *
	 */
	@Test
	public void testVerify(){
		
		BaseWebResponse resp = shortMessageBiz.verifyVerificationCode("13764752550", "936957", "10000_REG");
		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
	}
	
	/**
	 * testVerify:验证码验证. <br/>
	 *
	 */
	@Test
	public void testSendCommonMessage(){
		
		BaseWebResponse resp = shortMessageBiz.sendCommonMessage("13764752550", "10000_AUTH_SUCC");
		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
	}
	
	/**
	 * testCheckUserNameRegister:发送短信之前校验手机号码是否注册过. <br/>
	 *
	 */
	@Test
	public void testCheckUserNameRegister(){
		
		BaseWebResponse resp = shortMessageBiz.checkUserNameRegister("13764752550");
		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
	}
	
}
