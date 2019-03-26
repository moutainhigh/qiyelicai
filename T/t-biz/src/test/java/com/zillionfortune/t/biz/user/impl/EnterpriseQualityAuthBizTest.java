/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.zillionfortune.t.biz.user.EnterpriseQualityAuthBiz;
import com.zillionfortune.t.biz.user.dto.UserImproveInfoRequest;

/**
 * ClassName: EnterpriseQualityAuthBizTest <br/>
 * Function: 完善资料测试. <br/>
 * Date: 2016年12月19日 下午1:28:56 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-basic.xml")
@ActiveProfiles("dev")
public class EnterpriseQualityAuthBizTest {
	
	@Autowired
	private EnterpriseQualityAuthBiz biz;
	
	@Test
	public void addUserImproveInfoTest() {
		try {
			UserImproveInfoRequest req = new UserImproveInfoRequest();
			req.setTradePassword("0CA175B9C0F726A831D895E269332461");
			req.setMemberId("E201611301548161482076426");
			
			req.setBankAccountName("资邦金服网络科技服务有限公司");
			req.setBankAccountNo("62232212345454545");
			req.setBankAccount("招商银行塘桥支行");
			req.setBankAccountRegion("上海");
			
			req.setIndustry(1);
			req.setEnterpriseType(1);
			
			req.setAuthorizedPersonCertExpDate("2018-10-10");
			req.setAuthorizedPersonCertificateNo("4302811990012297");
			req.setAuthorizedPersonCertificateType(1);
			req.setAuthorizedPersonName("彭婷");
			req.setAuthorizedPersonMobile("18621197591");
			
			System.out.println(JSONObject.toJSONString(biz.enterpriseinfoupdate(req)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
