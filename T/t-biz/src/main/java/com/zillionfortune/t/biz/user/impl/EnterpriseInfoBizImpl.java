/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.user.EnterpriseInfoBiz;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.common.util.DateUtil;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.integeration.cif.UserBindCardIntegration;
import com.zillionfortune.t.integeration.cif.UserInfoIntegration;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoQueryCifResponse;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoQueryRequest;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoUpdateCifResponse;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoUpdateRequest;
import com.zillionfortune.t.integeration.cif.dto.FindBankAccountNoResponse;

/**
 * ClassName: EnterpriseServiceFacadeImpl <br/>
 * Function: 企业会员信息查询接口实现. <br/>
 * Date: 2016年12月19日 下午5:15:50 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Service
public class EnterpriseInfoBizImpl implements EnterpriseInfoBiz {
	
	private static Logger log = LoggerFactory.getLogger(UserLoginBizImpl.class);
	
	@Autowired
	UserInfoIntegration userInfoIntegration;
	@Autowired
	private UserBindCardIntegration userBindCardIntegration;

	@Override
	public BaseWebResponse enterpriseInfoQuery(EnterpriseExtInfoQueryRequest req) {
		log.info("EnterpriseInfoQueryBizImpl.enterpriseInfoQuery.req:" + JsonUtils.object2Json(req));
		
		BaseWebResponse resp = null;
		EnterpriseExtInfoQueryCifResponse extResp = null;
		
		try {
			//校验请求参数
			if(StringUtils.isBlank(req.getMemberId())){
				throw new BusinessException("会员ID[memberId]为空！" );
			}
			// 执行企业信息查询
			extResp = userInfoIntegration.enterpriseQueryInfo(req);
			// 判断是否调用成功
			if (!(RespCode.SUCCESS.code()).equals(extResp.getRespCode())
					|| !(ResultCode.SUCCESS.code()).equals(extResp.getResultCode())) {
				throw new BusinessException(extResp.getResultMsg() );
			}
			// 组装响应对象
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			Map<String,String> respMap = new HashMap<String,String>();
			respMap.put("memberId", extResp.getMemberId());//会员ID
			respMap.put("customerNo", extResp.getCustomerNo());//企业商户号
			respMap.put("enterpriseName", extResp.getEnterpriseName());//企业名称
			respMap.put("certificateType", extResp.getCertificateType());//营业执照类型
			respMap.put("certificateNo", extResp.getCertificateNo());//营业执照号 
			respMap.put("certExpDate",  new SimpleDateFormat("yyyy-MM-dd hh:ss:mm").format(new Date(extResp.getCertificateExpireDate())));//营业执照有效期
			respMap.put("legalPersonName", extResp.getLegalPersonName());//法定代表人姓名
			respMap.put("legalPersonCertificateType", extResp.getLegalPersonCertificateType());//法定代表人证件类型
			respMap.put("legalPersonCertificateNo", extResp.getLegalPersonCertificateNo());//法定代表人证件号码
			respMap.put("legalPersonCertExpDate", new SimpleDateFormat("yyyy-MM-dd hh:ss:mm").format(new Date(extResp.getLegalPersonCertificateExpireDate())));//法定代表人证件有效期
			respMap.put("phone", extResp.getPhoneNo());//企业电话
			respMap.put("registerAddress", extResp.getEnterpriseRegisterAddr());//企业通讯地址 
			respMap.put("postCode", extResp.getPostCode());//邮编
			resp.setData(respMap);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),be.getMessage());
            } else {
            	resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
		}
		log.info("EnterpriseInfoQueryBizImpl.enterpriseInfoQuery.req:" + JsonUtils.object2Json(resp));
		return resp;
	}

	@Override
	public BaseWebResponse enterpriseInfoUpdate(EnterpriseExtInfoUpdateRequest req) {
		log.info("EnterpriseInfoQueryBizImpl.enterpriseInfoUpdate.req:" + JsonUtils.object2Json(req));
		
		BaseWebResponse resp = null;
		EnterpriseExtInfoUpdateCifResponse extResp = null;
		
		try {
			//校验请求参数
			if(StringUtils.isBlank(req.getMemberId())){
				throw new BusinessException("会员ID[memberId]为空！" );
			}
			if(
					(StringUtils.isBlank(req.getCertificateType()) && StringUtils.isNotBlank(req.getCertificateNo()) ) 
					||
					(StringUtils.isNotBlank(req.getCertificateType()) && StringUtils.isBlank(req.getCertificateNo()) )
			  ){
				throw new BusinessException("企业证件类型与企业证件号要么必输，要么不输！" );
			}
			
			// 执行企业信息查询
			extResp = userInfoIntegration.enterpriseInfoUpdate(req);
			
			// 判断是否调用成功
			if (!(RespCode.SUCCESS.code()).equals(extResp.getRespCode())
					|| !(ResultCode.SUCCESS.code()).equals(extResp.getResultCode())) {
				resp = new BaseWebResponse(extResp.getRespCode(),extResp.getResultCode(),extResp.getResultMsg());
				log.info("UserLoginBizImpl.login.resp:" + JsonUtils.object2Json(resp));
				return resp;
			}
			
			// 组装响应对象
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			Map<String,String> respMap = new HashMap<String,String>();
			respMap.put("memberId", extResp.getMemberId());//会员ID
			resp.setData(extResp);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),be.getMessage());
            } else {
            	resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
		}
		log.info("EnterpriseInfoQueryBizImpl.enterpriseInfoUpdate.req:" + JsonUtils.object2Json(resp));
		return resp;
	}
	
	@Override
	public boolean findBankAccountNo(String bankAccountNo) throws Exception {
		log.info("EnterpriseInfoQueryBizImpl.findBankAccountNo.req:bankAccountNo=" + bankAccountNo);
		FindBankAccountNoResponse result = null;
		// 执行银行账号查询
		result = userBindCardIntegration.findBankAccountNo(bankAccountNo);
		// 判断是否调用成功
		if (!RespCode.SUCCESS.code().equals(result.getRespCode())
				|| !ResultCode.SUCCESS.code().equals(result.getResultCode())) {
			throw new BusinessException(result.getResultMsg() );
		}
		log.info("EnterpriseInfoQueryBizImpl.findBankAccountNo.req:result=" + result.isExistFlg());
		return result.isExistFlg();
	}
	
}
