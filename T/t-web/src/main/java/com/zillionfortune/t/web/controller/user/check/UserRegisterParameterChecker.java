/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.web.controller.user.check;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.zillionfortune.t.common.enums.EnterpriseCertType;
import com.zillionfortune.t.common.enums.PersonCertType;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.common.util.CommonUtil;
import com.zillionfortune.t.web.controller.user.vo.UserCheckRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserRegisterRequestVo;


/**
 * ClassName: EnterpriseServiceParameterChecker <br/>
 * Function: 企业注册参数校验. <br/>
 * Date: 2016年11月11日 下午2:08:57 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class UserRegisterParameterChecker {

	/**
	 * 企业注册请求参数校验
	 * @param
	 * @return
	 */
	public void checkUserRegisterRequest(UserRegisterRequestVo req) throws Exception {
    
        if (req == null) {
            throw new BusinessException("请求对象UserRegisterRequestVo不能为空");
        }
        
        if (StringUtils.isBlank(req.getMobile())) {
        	throw new BusinessException("手机号不能为空");
        }
     
        if (StringUtils.isBlank(req.getVerificationCode())){
        	throw new BusinessException("验证吗不能为空");
        }
 
        if(StringUtils.isBlank(req.getPassword())){
        	throw new BusinessException("登录密码不能为空");
        }
        
        if(StringUtils.isBlank(req.getRepeatPwd())) {
        	throw new BusinessException("确认登录密码不能为空");
        }
        
        if (!req.getPassword().equals(req.getRepeatPwd())){
        	throw new BusinessException("登录密码和确认登录密码不相同");
        }
        
        if (StringUtils.isBlank(req.getEnterpriseName())){
        	throw new BusinessException("企业名称不能为空");
        }
        
        if (StringUtils.isBlank(req.getCertificateType())) {
            throw new BusinessException("企业证件类型不能为空");
        }
        
        if (!CommonUtil.isNumeric(req.getCertificateType())) {
        	throw new BusinessException("企业证件类型的值必须是整数");
        }
        
        if (EnterpriseCertType.getEnumItem(Integer.parseInt(req.getCertificateType())) == null){
        	throw new BusinessException("企业证件类型的值不在约定的范围");
        }
        
        if (StringUtils.isBlank(req.getCertificateNo())) {
            throw new BusinessException("企业证件号码不能为空");
        }
        
        if (StringUtils.isBlank(req.getCertExpDate())){
        	throw new BusinessException("企业证件有效期不能为空");
        }
        
        if (!CommonUtil.isDate(req.getCertExpDate())){
        	throw new BusinessException("企业证件有效期的值不是日期类型");
        }
    
        if (StringUtils.isBlank(req.getLegalPersonName())){
        	throw new BusinessException("法人姓名不能为空");
        }
        
        if (StringUtils.isBlank(req.getLegalPersonCertificateType())){
        	throw new BusinessException("法人证件类型不能为空");
        }
        
        if (!CommonUtil.isNumeric(req.getLegalPersonCertificateType())) {
        	throw new BusinessException("法人证件类型的值必须是整数");
        }
        
        if (PersonCertType.getEnumItem(Integer.parseInt(req.getLegalPersonCertificateType())) == null){
        	throw new BusinessException("法人证件类型的值不在约定的范围");
        }
        
        if (StringUtils.isBlank(req.getLegalPersonCertificateNo())){
        	throw new BusinessException("法人证件号码不能为空");
        }
       
        if (StringUtils.isBlank(req.getLegalPersonCertExpDate())){
        	throw new BusinessException("法人证件有效期不能为空");
        }
       
        if (!CommonUtil.isDate(req.getLegalPersonCertExpDate())){
        	throw new BusinessException("法人证件有效期的值不是日期类型");
        }

        if (StringUtils.isBlank(req.getRegisterAddress())){
        	throw new BusinessException("企业营业地址不能为空");
        }
        
        if (StringUtils.isBlank(req.getPostCode())){
        	throw new BusinessException("企业营业地址邮政编码不能为空");
        }
        
        if (StringUtils.isBlank(req.getPhone())){
        	throw new BusinessException("企业联系电话不能为空");
        }
 
    }
	
	/**
	 * 企业注册根据证件类型证件号码校验企业是否存在请求参数校验
	 * @param
	 * @return
	 */
	public void checkEnterpriseExistsRequest(UserCheckRequestVo req) throws Exception {
    
        if (req == null) {
            throw new BusinessException("请求对象UserCheckRequestVo不能为空");
        }
        
        if (StringUtils.isBlank(req.getCertificateNo())) {
        	throw new BusinessException("企业证件号码不能为空");
        }
        
        if (StringUtils.isBlank(req.getCertificateType())) {
            throw new BusinessException("企业证件类型不能为空");
        }
        
        if (!CommonUtil.isNumeric(req.getCertificateType())) {
        	throw new BusinessException("企业证件类型的值必须是整数");
        }
        
        if (EnterpriseCertType.getEnumItem(Integer.parseInt(req.getCertificateType())) == null){
        	throw new BusinessException("企业证件类型的值不在约定的范围");
        }
        
	}
}
