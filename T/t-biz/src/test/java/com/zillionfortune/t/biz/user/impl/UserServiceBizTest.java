package com.zillionfortune.t.biz.user.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.zillionfortune.t.biz.user.UserServiceBiz;
import com.zillionfortune.t.biz.user.dto.UserAuthRequest;
import com.zillionfortune.t.biz.user.dto.UserRiskAsessmentRequest;
import com.zillionfortune.t.common.enums.GradeType;
import com.zillionfortune.t.dal.domain.Answers;
import com.zillionfortune.t.integeration.cif.dto.UserGradeRequest;

/**
 * ClassName: UserServiceBizTest <br/>
 * Function: 企业会员相关服务测试类. <br/>
 * Date: 2016年12月20日 下午1:53:18 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-basic.xml")
@ActiveProfiles("dev")
public class UserServiceBizTest {
	
	@Autowired
	private UserServiceBiz userServiceBiz;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * authTest:企业会员身份验证. <br/>
	 *
	 */
	@Test
	public void authTest(){ 

		UserAuthRequest req = new UserAuthRequest();
		req.setMemberId("EM201612200206502375010386");
		req.setCertificateNo("111000001");
		req.setLegalPersonCertificateNo("111000001");
		
		BaseWebResponse resp = userServiceBiz.auth(req);

		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
	}
	
	/**
	 * queryRiskGradeTest:企业会员风险等级查询. <br/>
	 *
	 */
	@Test
	public void queryRiskGradeTest(){ 

		UserGradeRequest req = new UserGradeRequest();
		req.setMemberId("EM201612200206502375010386");
		req.setGradeType(String.valueOf(GradeType.RISK.code()));
		
		BaseWebResponse resp = userServiceBiz.queryRiskGrade(req);

		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
	}
	
	/**
	 * riskAsessmentTest:企业会员风险测评. <br/>
	 *
	 */
	@Test
	public void riskAsessmentTest(){ 

		UserRiskAsessmentRequest req = new UserRiskAsessmentRequest();
		req.setMemberId("EM201612200206502375010386");
		List<Answers> answers = new ArrayList<Answers>();
		answers.add(new Answers(1,"C"));
		answers.add(new Answers(2,"C"));
		answers.add(new Answers(3,"C"));
		answers.add(new Answers(4,"C"));
		answers.add(new Answers(5,"C"));
		answers.add(new Answers(6,"C"));
		answers.add(new Answers(7,"C"));
		answers.add(new Answers(8,"C"));
		answers.add(new Answers(9,"C"));
		answers.add(new Answers(10,"C"));
		answers.add(new Answers(11,"C"));
		answers.add(new Answers(12,"C"));
		answers.add(new Answers(13,"C"));
		answers.add(new Answers(14,"C"));
		answers.add(new Answers(15,"C"));
		answers.add(new Answers(16,"C"));
		answers.add(new Answers(17,"C"));
		answers.add(new Answers(18,"C"));
		answers.add(new Answers(19,"C"));
		req.setAnswers(answers);
		
		BaseWebResponse resp = userServiceBiz.riskAsessment(req);

		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
	}
}
