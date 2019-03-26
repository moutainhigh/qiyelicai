package com.zillionfortune.t.biz.user.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.user.EnterpriseInfoBiz;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoQueryRequest;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoUpdateRequest;

/**
 * ClassName: EnterpriseInfoQueryBizTest <br/>
 * Function: 企业信息单元测试. <br/>
 * Date: 2016年12月21日 上午10:56:46 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-basic.xml")
@ActiveProfiles("dev")
public class EnterpriseInfoBizTest {
	
	@Autowired
	private EnterpriseInfoBiz enterpriseInfoBiz;
	
	/**
	 * 企业会员信息查询. <br/>
	 *
	 */
	@Test
	public void enterpriseInfoQuery(){
		
		String memberId = "EM201612200048241323176703";
		BaseWebResponse baseResp = null;
		
		EnterpriseExtInfoQueryRequest req = new EnterpriseExtInfoQueryRequest (memberId);
		
		baseResp = enterpriseInfoBiz.enterpriseInfoQuery(req);
		
		System.out.println(JSON.toJSONString(baseResp));
	}
	
	/**
	 * 企业会员联系信息更新. <br/>
	 *
	 */
	@Test
	public void enterpriseInfoUpdate(){
		
		BaseWebResponse baseResp = null;
		String memberId = "EM201612200048241323176703";//会员ID
		String certificateType = "1";//营业执照类型,必输
		String certificateNo = "E90u123456";//营业执照号,必输
		String certExpDate = "2016-12-14 00:00:00";//营业执照有效期
		String legalPersonName = "kaiyun2";//法定代表人姓名
		String legalPersonCertificateType = "1";//法定代表人证件类型
		String legalPersonCertificateNo = "T13816947328";//法定代表人证件号码
		String legalPersonCertExpDate = "2016-10-14 00:00:00";//法定代表人证件有效期
		String registerAddress = "上海联";//企业通讯地址
		String postCode = "333333";//邮政编码
		String phone = "13816947328";//联系电话
		
		EnterpriseExtInfoUpdateRequest req = new EnterpriseExtInfoUpdateRequest ();
		req.setMemberId(memberId);
		req.setCertificateType(certificateType);
		req.setCertificateNo(certificateNo);
		req.setCertExpDate(certExpDate);
		req.setLegalPersonName(legalPersonName);
		req.setLegalPersonCertificateType(legalPersonCertificateType);
		req.setLegalPersonCertificateNo(legalPersonCertificateNo);
		req.setLegalPersonCertExpDate(legalPersonCertExpDate);
		req.setPhone(phone);
		req.setRegisterAddress(registerAddress);
		req.setPostCode(postCode);
		
		baseResp = enterpriseInfoBiz.enterpriseInfoUpdate(req);
		
		System.out.println(JSON.toJSONString(baseResp));
	}

}
