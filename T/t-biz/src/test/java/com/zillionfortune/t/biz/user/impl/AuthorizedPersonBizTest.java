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
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonAuditRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonPageQueryRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonQueryRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonStatusQueryRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonUpdateRequest;
import com.zillionfortune.t.common.enums.CheckStatus;
import com.zillionfortune.t.common.util.PageBean;

/**
 * ClassName: AuthorizedPersonBizTest <br/>
 * Function: 被授权人测试. <br/>
 * Date: 2016年12月15日 下午4:43:41 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-basic.xml")
@ActiveProfiles("dev")
public class AuthorizedPersonBizTest {
	
	@Autowired
	private AuthorizedPersonBiz authorizedPersonBiz;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * authorizedPersonUpdate:新增被授权人方法. <br/>
	 */
	@Test
	public void testAuthorizedPersonUpdate(){
		
		AuthorizedPersonUpdateRequest req = new AuthorizedPersonUpdateRequest();
		req.setAuthorizationUrl("d:\\author");
		req.setCertExpDate("2017-01-01");
		req.setCertificateBackUrl("d:\\backurl");
		req.setCertificateFrontUrl("d:\\fronturl");
		req.setCertificateNo("被授权人证件no");
		req.setCertificateType("2");
		req.setMemberId("EM201612200048241323176703");
		req.setMobile("13764752550");
		req.setName("猪八戒888-孙悟空");
		req.setAuthorizedPersonId(270l);
		
		BaseWebResponse resp = authorizedPersonBiz.authorizedPersonUpdate(req);
		
		System.out.println(JSON.toJSONString(resp));
		
		log.info(JSON.toJSONString(resp));
		
	}
	
	/**
	 * testAuthorizedPersonUpdateAudit:更新被授权人审核状态. <br/>
	 *
	 */
	@Test
	public void testAuthorizedPersonUpdateAudit(){
		
		AuthorizedPersonAuditRequest req = new AuthorizedPersonAuditRequest();
		//req.setAuthorizedPersonId(27l);
		req.setMemberId("EM201701071806315963962697");
		req.setStatus(CheckStatus.CHECK_PASS_REVIEW_PASS.code());
		
		BaseWebResponse resp = authorizedPersonBiz.authorizedPersonUpdateAudit(req);
		
		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
		
	}
	
	/**
	 * testAuthorizedPersonQuery:查询被授权人信息. <br/>
	 */
	@Test
	public void testAuthorizedPersonQuery(){
		
		AuthorizedPersonQueryRequest req = new AuthorizedPersonQueryRequest();
		req.setAuthorizedPersonId(27L);
		req.setMemberId("EM201612200048241323176703");
		
		BaseWebResponse resp = authorizedPersonBiz.authorizedPersonQuery(req);

		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
		
	}
	
	/**
	 * testAuthorizedPersonStatusQuery:查询被授权人信息(审核状态). <br/>
	 */
	@Test
	public void testAuthorizedPersonStatusQuery(){
		
		AuthorizedPersonStatusQueryRequest req = new AuthorizedPersonStatusQueryRequest();
		req.setMemberId("EM201612231252445849901413"); 
		
		BaseWebResponse resp = authorizedPersonBiz.authorizedPersonStatusQuery(req);

		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
		
	}
	
	/**
	 * testAuthorizedPersonPageQuery:查询被授权人信息(分页). <br/>
	 */
	@Test
	public void testAuthorizedPersonPageQuery(){
		
		PageBean pageBean = new PageBean(2, 5);
    	
		AuthorizedPersonPageQueryRequest req = new AuthorizedPersonPageQueryRequest();
		req.setCurrentPage(2);
		req.setPageStart(pageBean.getPageStart());
		req.setPageSize(pageBean.getPageSize());
		req.setStatus(CheckStatus.CHECK_WAIT.code()); 
		
		BaseWebResponse resp = authorizedPersonBiz.authorizedPersonPageQuery(req);

		System.out.println(JSON.toJSONString(resp));
		log.info(JSON.toJSONString(resp));
		
	}
	
	public static void main(String[] args) {
		System.out.println(test());
	}

	public  static int test(){
		int result = 1;
		try{
			result = 2;
			throw new RuntimeException();
		}catch(Exception e){
			result = 3;
			return result;
		} finally{
			result = 4;
		}
	}
	
}