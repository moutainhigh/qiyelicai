/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.web.controller.authorizedperson.check;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.zillionfortune.t.common.enums.CheckStatus;
import com.zillionfortune.t.common.enums.PersonCertType;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.common.util.CommonUtil;
import com.zillionfortune.t.web.controller.authorizedperson.vo.AuthorizedPersonAuditRequestVo;
import com.zillionfortune.t.web.controller.authorizedperson.vo.AuthorizedPersonPageQueryRequestVo;
import com.zillionfortune.t.web.controller.authorizedperson.vo.AuthorizedPersonQueryRequestVo;
import com.zillionfortune.t.web.controller.authorizedperson.vo.AuthorizedPersonStatusQueryRequestVo;
import com.zillionfortune.t.web.controller.authorizedperson.vo.AuthorizedPersonUpdateRequestVo;

/**
 * ClassName: AuthorizedPersonRequestParameterChecker <br/>
 * Function: 被授权人服务参数校验. <br/>
 * Date: 2016年12月19日 下午4:57:15 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class AuthorizedPersonRequestParameterChecker {

	/**
	 * checkAuthorizedPersonRequest:新增被授权人请求参数校验. <br/>
	 *
	 * @param req
	 * @throws Exception
	 */
	public void checkAuthorizedPersonRequest(AuthorizedPersonUpdateRequestVo req) throws Exception {
    
        if (req == null) {
            throw new BusinessException("请求对象AuthorizedPersonRequestVo不能为空");
        }
        
        if (StringUtils.isBlank(req.getMemberId())){
        	throw new BusinessException("memberId字段不能为空");
        }
        
        if (StringUtils.isBlank(req.getAuthorizationUrl())){
        	throw new BusinessException("授权委托书不能为空");
        }
        
        if (StringUtils.isBlank(req.getCertificateFrontUrl())){
        	throw new BusinessException("被授权人证件正面不能为空");
        }
        
        if (StringUtils.isBlank(req.getCertificateBackUrl())){
        	throw new BusinessException("被授权人证件反面不能为空");
        }
        
        if(StringUtils.isBlank(req.getName())){
        	throw new BusinessException("被授权人姓名不能为空");
        }
        
        if (StringUtils.isBlank(req.getCertificateType())) {
            throw new BusinessException("被授权人证件类型不能为空");
        }
        
        if (!CommonUtil.isNumeric(req.getCertificateType())) {
        	throw new BusinessException("被授权人证件类型的值必须是整数");
        }
        
        if (PersonCertType.getEnumItem(Integer.parseInt(req.getCertificateType())) == null){
        	throw new BusinessException("被授权人证件类型的值不在约定的范围");
        }
        
        if (StringUtils.isBlank(req.getCertificateNo())) {
            throw new BusinessException("被授权人证件号码不能为空");
        }
        
        if (StringUtils.isBlank(req.getCertExpDate())){
        	throw new BusinessException("被授权人证件有效期不能为空");
        }
        
        if (!CommonUtil.isDate(req.getCertExpDate())){
        	throw new BusinessException("被授权人证件有效期格式不正确");
        }
        
        if (StringUtils.isBlank(req.getMobile())) {
        	throw new BusinessException("被授权人手机号码不能为空");
        }
        
        if (StringUtils.isBlank(req.getVerificationCode())) {
        	throw new BusinessException("验证码不能为空");
        }
        
    }
	
	/**
	 * checkAuthorizedPersonAuditRequest:更新被授权人审核状态请求参数校验. <br/>
	 *
	 * @param req
	 * @throws Exception
	 */
	public void checkAuthorizedPersonAuditRequest(AuthorizedPersonAuditRequestVo req) throws Exception {
    
        if (req == null) {
            throw new BusinessException("请求对象AuthorizedPersonAuditRequestVo不能为空");
        }
        
        if (StringUtils.isBlank(req.getMemberId())){
        	throw new BusinessException("memberId字段不能为空");
        }
        
      /*  if (req.getAuthorizedPersonId() == null){
        	throw new BusinessException("authorizedPersonId字段不能为空");
        }*/
        
        if (req.getStatus() == null){
        	throw new BusinessException("status字段不能为空");
        }
        
        if (CheckStatus.getEnumItem(req.getStatus()) == null){
        	throw new BusinessException("status字段的参数值不在约定的范围");
        }
        
	}
	
	/**
	 * checkAuthorizedPersonAuditRequest:查询被授权人请求参数校验. <br/>
	 *
	 * @param req
	 * @throws Exception
	 */
	public void checkAuthorizedPersonQueryRequest(AuthorizedPersonQueryRequestVo req) throws Exception {
    
        if (req == null) {
            throw new BusinessException("请求对象AuthorizedPersonQueryRequestVo不能为空");
        }
        
        if (StringUtils.isBlank(req.getMemberId())) {
        	throw new BusinessException("memberId字段不能为空");
        }
        
        if (req.getAuthorizedPersonId() == null) {
        	throw new BusinessException("authorizedPersonId字段不能为空");
        }
	}
	
	/**
	 * checkAuthorizedPersonStatusQueryRequest:查询被授权人审核状态请求参数校验. <br/>
	 *
	 * @param req
	 * @throws Exception
	 */
	public void checkAuthorizedPersonStatusQueryRequest(AuthorizedPersonStatusQueryRequestVo req) throws Exception {
    
        if (req == null) {
            throw new BusinessException("请求对象AuthorizedPersonStatusQueryRequestVo不能为空");
        }
        
        if (StringUtils.isBlank(req.getMemberId())) {
        	throw new BusinessException("memberId字段不能为空");
        }
       
	}
	
	/**
	 * checkAuthorizedPersonPageQueryRequest:查询被授权人请求参数校验（分页）. <br/>
	 *
	 * @param req
	 * @throws Exception
	 */
	public void checkAuthorizedPersonPageQueryRequest(AuthorizedPersonPageQueryRequestVo req) throws Exception {
    
	}
}
