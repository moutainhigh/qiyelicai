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
import com.zillionfortune.t.biz.authorizedperson.AuthorizedPersonBiz;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonQueryRequest;
import com.zillionfortune.t.biz.user.UserRegisterBiz;
import com.zillionfortune.t.integeration.cif.dto.UserCheckRequest;
import com.zillionfortune.t.integeration.cif.dto.UserRegisterRequest;

/**
 * ClassName: UserRegisterBizTest <br/>
 * Function: 用户注册测试. <br/>
 * Date: 2016年12月15日 下午4:43:41 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-basic.xml")
@ActiveProfiles("dev")
public class UserRegisterBizTest {
	
	@Autowired
	private UserRegisterBiz userRegisterBiz;
	
	@Autowired
	private AuthorizedPersonBiz authorizedPersonBiz;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
    /**
     * testRegister:企业注册修改. <br/>
     *
     * @param 
     * @return 
     * @throws
     */
	@Test
	public void testRegister(){

		UserRegisterRequest req = new UserRegisterRequest();
		req.setMobile("13816947328123");
		req.setPassword("123456OOOXXX");
		req.setCertificateType("2");
		req.setLegalPersonCertificateType("1");
		req.setLegalPersonCertificateNo("T13816947328123");
		req.setLegalPersonName("kaiyun123");
		req.setCertExpDate("2016-12-10");
		req.setEnterpriseName("唐小僧企业理财-test");
		req.setRegisterAddress("上海市杨高南路");
		req.setMobile("19764752550");
		req.setCertificateNo("ZBE90u1381694732");
		req.setLegalPersonCertExpDate("2016-10-12");
		req.setPhone("13816947328123");
		
		BaseWebResponse resp = userRegisterBiz.register(req);

		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
	}
	
	/**
	 * testAuthorizedPersonQuery:查询被授权人信息. <br/>
	 */
	@Test
	public void testAuthorizedPersonQuery(){
		
		AuthorizedPersonQueryRequest req = new AuthorizedPersonQueryRequest();
		req.setAuthorizedPersonId(3L);
		req.setMemberId("123456");
		
		BaseWebResponse resp = authorizedPersonBiz.authorizedPersonQuery(req);
		System.out.println("------------");

		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
		
	}
	
	/**
	 * testCheckEnterpriseExists企业注册根据证件类型证件号码校验企业是否存在. <br/>
	 */
	@Test
	public void testCheckEnterpriseExists(){
		
		UserCheckRequest req = new UserCheckRequest();
		req.setCertificateType("1");
		req.setCertificateNo("111111");
		
		BaseWebResponse resp = userRegisterBiz.checkEnterpriseExists(req);

		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
		
	}

}
