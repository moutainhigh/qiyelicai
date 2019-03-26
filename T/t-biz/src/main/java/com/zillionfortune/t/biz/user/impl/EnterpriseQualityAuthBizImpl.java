/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseResponse;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.user.EnterpriseQualityAuthBiz;
import com.zillionfortune.t.biz.user.dto.QualificationUploadRequest;
import com.zillionfortune.t.biz.user.dto.UserImproveInfoRequest;
import com.zillionfortune.t.common.enums.CheckStatus;
import com.zillionfortune.t.common.enums.EnterpriseAuditStatusEnum;
import com.zillionfortune.t.common.enums.LegalPersonAuditStatusEnum;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.util.DateUtil;
import com.zillionfortune.t.dal.entity.AuthorizedPerson;
import com.zillionfortune.t.integeration.cif.UserAuditIntegration;
import com.zillionfortune.t.integeration.cif.UserBindCardIntegration;
import com.zillionfortune.t.integeration.cif.UserPasswordIntegration;
import com.zillionfortune.t.integeration.cif.UserQualificationIntegration;
import com.zillionfortune.t.integeration.cif.UserRegisterIntegration;
import com.zillionfortune.t.integeration.cif.dto.BindCardRequest;
import com.zillionfortune.t.integeration.cif.dto.UserAuditRequest;
import com.zillionfortune.t.integeration.cif.dto.UserInfoUpdateCifRequest;
import com.zillionfortune.t.integeration.cif.dto.UserQualificationUpdateRequest;
import com.zillionfortune.t.service.AuthorizedPersonService;

/**
 * ClassName: EnterpriseQualityAuthBizImpl <br/>
 * Function: 用户资质审核实现. <br/>
 * Date: 2016年12月16日 上午11:04:28 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
@Component
public class EnterpriseQualityAuthBizImpl implements EnterpriseQualityAuthBiz {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserPasswordIntegration userPasswordIntegration;
	@Autowired
	private UserBindCardIntegration userBindCardIntegration;
	@Autowired
	private AuthorizedPersonService authorizedPersonService;
	@Autowired
	private UserRegisterIntegration userRegisterIntegration;
	@Autowired
	private UserQualificationIntegration userQualificationIntegration;
	@Autowired
	private UserAuditIntegration userAuditIntegration;
	
	/**
	 * @see com.zillionfortune.t.biz.user.EnterpriseQualityAuthBiz#enterpriseinfoupdate(com.zillionfortune.t.biz.user.dto.UserImproveInfoRequest)
	 */
	@Override
	public BaseWebResponse enterpriseinfoupdate(UserImproveInfoRequest req) {
		log.info("enterpriseinfoupdate.req:" + JSON.toJSONString(req));
		
		BaseWebResponse resp = null;
		
		try {
			// 设置交易密码
			BaseResponse result = userPasswordIntegration.setTradePassword(req.getMemberId(), req.getTradePassword());
			
			if(!RespCode.SUCCESS.code().equals(result.getRespCode()) 
					|| !ResultCode.SUCCESS.code().equals(result.getResultCode()) ) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), result.getResultCode(), result.getResultMsg());
				return resp;
			}
			
			// 绑定银行账户
			BindCardRequest bindCardRequest = new BindCardRequest();
			bindCardRequest.setMemberId(req.getMemberId());
			bindCardRequest.setBankAccountName(req.getBankAccountName());
			bindCardRequest.setBranchBankName(req.getBankAccount());
			bindCardRequest.setBankAccountNo(req.getBankAccountNo());
			bindCardRequest.setBankAccountRegion(req.getBankAccountRegion());
			
			result = userBindCardIntegration.bindCard(bindCardRequest);
			if(!RespCode.SUCCESS.code().equals(result.getRespCode()) 
					|| !ResultCode.SUCCESS.code().equals(result.getResultCode()) ) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), result.getResultCode(), result.getResultMsg());
				return resp;
			}
			
			// 更新企业扩展信息
			UserInfoUpdateCifRequest userInfoReq = new UserInfoUpdateCifRequest();
			userInfoReq.setEnterpriseType(req.getEnterpriseType());
			userInfoReq.setIndustry(req.getIndustry());
			userInfoReq.setMemberId(req.getMemberId());
			
			result = userRegisterIntegration.enterpriseInfoUpdate(userInfoReq);
			if(!RespCode.SUCCESS.code().equals(result.getRespCode()) 
					|| !ResultCode.SUCCESS.code().equals(result.getResultCode()) ) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), result.getResultCode(), result.getResultMsg());
				return resp;
			}
			
			// 保存被授权人信息
			AuthorizedPerson newRecode = new AuthorizedPerson();
			newRecode.setMemberId(req.getMemberId());
			newRecode.setName(req.getAuthorizedPersonName());
			newRecode.setCertificateNo(req.getAuthorizedPersonCertificateNo());
			newRecode.setCertificateType(req.getAuthorizedPersonCertificateType());
			newRecode.setMobile(req.getAuthorizedPersonMobile());
			newRecode.setCertificateExpireDate(DateUtil.strToDate(req.getAuthorizedPersonCertExpDate(), DateUtil.DATAFORMAT_STR));
			newRecode.setStatus(CheckStatus.CHECK_WAIT.code()); 
			authorizedPersonService.insertAuthorizedPerson(newRecode);
			
            resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
            Map<String, Object> rsData = new HashMap<String, Object>();
            rsData.put("memberId", req.getMemberId());
            rsData.put("authorizedPersonId", newRecode.getId());
            resp.setData(rsData);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
		} finally {
			log.info("enterpriseinfoupdate.resp:" + JSON.toJSONString(resp));
		}
		
		return resp;
	}
	
	/**
	 * @see com.zillionfortune.t.biz.user.EnterpriseQualityAuthBiz#updateQualifications(com.zillionfortune.t.biz.user.dto.QualificationUploadRequest)
	 */
	@Override
	public BaseWebResponse updateQualifications(QualificationUploadRequest req) {
		log.info("enterpriseinfoupdate.req:" + JSON.toJSONString(req));
		
		BaseWebResponse resp = null;
		try {
			BaseResponse result = null;
			// 密码不为空，则设置交易密码
			if (StringUtils.isNotBlank(req.getTradePassword())) {
				result = userPasswordIntegration.setTradePassword(req.getMemberId(), req.getTradePassword());
				
				if(!RespCode.SUCCESS.code().equals(result.getRespCode()) 
						|| !ResultCode.SUCCESS.code().equals(result.getResultCode()) ) {
					resp = new BaseWebResponse(RespCode.SUCCESS.code(), result.getResultCode(), result.getResultMsg());
					return resp;
				}
			}
			
			// 绑定银行账户
			BindCardRequest bindCardRequest = new BindCardRequest();
			bindCardRequest.setMemberId(req.getMemberId());
			bindCardRequest.setBankAccountName(req.getBankAccountName());
			bindCardRequest.setBranchBankName(req.getBankAccount());
			bindCardRequest.setBankAccountNo(req.getBankAccountNo());
			bindCardRequest.setBankAccountRegion(req.getBankAccountRegion());
			
			result = userBindCardIntegration.bindCard(bindCardRequest);
			if(!RespCode.SUCCESS.code().equals(result.getRespCode()) 
					|| !ResultCode.SUCCESS.code().equals(result.getResultCode()) ) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), result.getResultCode(), result.getResultMsg());
				return resp;
			}
			
			// 更新企业扩展信息
			UserInfoUpdateCifRequest userInfoReq = new UserInfoUpdateCifRequest();
			userInfoReq.setEnterpriseType(req.getEnterpriseType());
			userInfoReq.setIndustry(req.getIndustry());
			userInfoReq.setMemberId(req.getMemberId());
			
			result = userRegisterIntegration.enterpriseInfoUpdate(userInfoReq);
			if(!RespCode.SUCCESS.code().equals(result.getRespCode()) 
					|| !ResultCode.SUCCESS.code().equals(result.getResultCode()) ) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), result.getResultCode(), result.getResultMsg());
				return resp;
			}
			
			UserQualificationUpdateRequest httpRequest = new UserQualificationUpdateRequest();
			PropertyUtils.copyProperties(httpRequest, req);
			// 更新企业资质信息
			result = userQualificationIntegration.qualificationUpdate(httpRequest);
			
			if(!RespCode.SUCCESS.code().equals(result.getRespCode()) 
					|| !ResultCode.SUCCESS.code().equals(result.getResultCode()) ) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), result.getResultCode(), result.getResultMsg());
				return resp;
			}
			
			// 更新企业认证信息审核状态(待审核),更新会员认证等级 (认证中)
			UserAuditRequest userAuditRequest = new UserAuditRequest();
			userAuditRequest.setMemberId(req.getMemberId());
			userAuditRequest.setEnterpriseAuditStatus(EnterpriseAuditStatusEnum.CHECK_WAIT.code());
			userAuditRequest.setLegalPersonAuditStatus(LegalPersonAuditStatusEnum.CHECK_WAIT.code());
			result = userAuditIntegration.audit(userAuditRequest);
			if(!RespCode.SUCCESS.code().equals(result.getRespCode()) 
					|| !ResultCode.SUCCESS.code().equals(result.getResultCode()) ) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), result.getResultCode(), result.getResultMsg());
				return resp;
			}
			
			// 保存被授权人信息
			AuthorizedPerson newRecode = new AuthorizedPerson();
			newRecode.setMemberId(req.getMemberId());
			newRecode.setName(req.getAuthorizedPersonName());
			newRecode.setCertificateNo(req.getAuthorizedPersonCertificateNo());
			newRecode.setCertificateType(req.getAuthorizedPersonCertificateType());
			newRecode.setMobile(req.getAuthorizedPersonMobile());
			newRecode.setCertificateExpireDate(DateUtil.strToDate(req.getAuthorizedPersonCertExpDate(), DateUtil.DATAFORMAT_STR));
			newRecode.setStatus(CheckStatus.CHECK_WAIT.code()); 
			newRecode.setCertificateFrontUrl(req.getAuthorizedPersonCertificateFrontUrl());
			newRecode.setCertificateBackUrl(req.getAuthorizedPersonCertificateBackUrl());
			newRecode.setAuthorizationUrl(req.getPowerOfAttorneyUrl());
			authorizedPersonService.insertAuthorizedPerson(newRecode);
			
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			Map<String, Object> rsData = new HashMap<String, Object>();
            rsData.put("memberId", req.getMemberId());
            resp.setData(rsData);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
		} finally {
			log.info("enterpriseinfoupdate.resp:" + JSON.toJSONString(resp));
		}
		
		return resp;
	}

}
