/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.user.check;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.zillionfortune.t.biz.user.dto.QualificationUploadRequest;
import com.zillionfortune.t.common.enums.EnterpriseType;
import com.zillionfortune.t.common.enums.IndustryEnum;
import com.zillionfortune.t.common.enums.PersonCertType;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.common.util.CommonUtil;
import com.zillionfortune.t.web.controller.user.vo.UserImproveInfoRequestVo;

/**
 * ClassName: EnterpriseQualityAuthParameterChecker <br/>
 * Function: 企业资质审核模块参数校验. <br/>
 * Date: 2016年12月16日 下午2:59:51 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
@Component
public class EnterpriseQualityAuthParameterChecker {

	/**
	 * checkaddImproveInfo:完善资料参数校验. <br/>
	 *
	 * @param vo
	 * @throws BusinessException
	 */
	public void checkaddImproveInfo(UserImproveInfoRequestVo vo) throws BusinessException {
		// 校验请求参数
		if (vo == null) {
			throw new BusinessException("请求对象不能为空");
		}
		if (StringUtils.isBlank(vo.getTradePassword())) {
			throw new BusinessException("交易密码不能为空");
		}
		if (StringUtils.isBlank(vo.getRepeatPwd())) {
			throw new BusinessException("确认交易密码不能为空");
		}
		if (!vo.getTradePassword().equals(vo.getRepeatPwd())) {
			throw new BusinessException("交易密码前后输入不一致");
		}
		if (StringUtils.isBlank(vo.getBankAccountName())) {
			throw new BusinessException("企业银行账户名称不能为空");
		}
		if (StringUtils.isBlank(vo.getBankAccountNo())) {
			throw new BusinessException("企业银行账号不能为空");
		}
		if (StringUtils.isBlank(vo.getRepeatBankAccountNo())) {
			throw new BusinessException("确认企业银行账号不能为空");
		}
		if (!vo.getBankAccountNo().equals(vo.getRepeatBankAccountNo())) {
			throw new BusinessException("银行账号前后输入不一致");
		}
		if (StringUtils.isBlank(vo.getBankAccount())) {
			throw new BusinessException("开户行 不能为空");
		}
		if (StringUtils.isBlank(vo.getBankAccountRegion())) {
			throw new BusinessException("开户行所在地区不能为空");
		}
		if (vo.getEnterpriseType() == null) {
			throw new BusinessException("企业类型 不能为空");
		}
		if (EnterpriseType.getEnumItem(vo.getEnterpriseType()) == null) {
			throw new BusinessException("企业类型 值不在约定的范围");
		}
		if (vo.getIndustry() == null) {
			throw new BusinessException("所属行业不能为空");
		}
		if (IndustryEnum.getEnumItem(vo.getIndustry()) == null) {
			throw new BusinessException("所属行业值不在约定的范围");
		}
		if (StringUtils.isBlank(vo.getAuthorizedPersonName())) {
			throw new BusinessException("被授权人姓名不能为空");
		}
		if (StringUtils.isBlank(vo.getAuthorizedPersonCertificateNo())) {
			throw new BusinessException("被授权人证件号码 不能为空");
		}
		if (null == vo.getAuthorizedPersonCertificateType()) {
			throw new BusinessException("被授权人证件类型 不能为空");
		}
        if (PersonCertType.getEnumItem(vo.getAuthorizedPersonCertificateType()) == null){
        	throw new BusinessException("被授权人证件类型值不在约定的范围");
        }
		if (StringUtils.isBlank(vo.getAuthorizedPersonCertExpDate())) {
			throw new BusinessException("被授权人证件有效期 不能为空");
		}
		if (!CommonUtil.isDate(vo.getAuthorizedPersonCertExpDate())){
        	throw new BusinessException("被授权人证件有效期格式不正确(yyyy-MM-dd)");
        }
		if (StringUtils.isBlank(vo.getAuthorizedPersonMobile())) {
			throw new BusinessException("被授权人联系电话不能为空");
		}
	}
	
	/**
	 * checkUloadQualificationsParam:企业会员上传资质 参数校验. <br/>
	 *
	 * @param vo
	 */
	public void checkUloadQualificationsParam(QualificationUploadRequest vo) throws BusinessException {
		if (vo == null) {
			throw new BusinessException("请求对象不能为空");
		}
		if (StringUtils.isBlank(vo.getMemberId())) {
			throw new BusinessException("memberId 不能为空");
		}
		if (StringUtils.isNotBlank(vo.getTradePassword()) && !vo.getTradePassword().equals(vo.getRepeatPwd())) {
			throw new BusinessException("交易密码前后输入不一致");
		}
		if (StringUtils.isBlank(vo.getBankAccountName())) {
			throw new BusinessException("企业银行账户名称不能为空");
		}
		if (StringUtils.isBlank(vo.getBankAccountNo())) {
			throw new BusinessException("企业银行账号不能为空");
		}
		if (StringUtils.isBlank(vo.getRepeatBankAccountNo())) {
			throw new BusinessException("确认企业银行账号不能为空");
		}
		if (!vo.getBankAccountNo().equals(vo.getRepeatBankAccountNo())) {
			throw new BusinessException("银行账号前后输入不一致");
		}
		if (StringUtils.isBlank(vo.getBankAccount())) {
			throw new BusinessException("开户行 不能为空");
		}
		if (StringUtils.isBlank(vo.getBankAccountRegion())) {
			throw new BusinessException("开户行所在地区不能为空");
		}
		if (vo.getEnterpriseType() == null) {
			throw new BusinessException("企业类型 不能为空");
		}
		if (EnterpriseType.getEnumItem(vo.getEnterpriseType()) == null) {
			throw new BusinessException("企业类型 值不在约定的范围");
		}
		if (vo.getIndustry() == null) {
			throw new BusinessException("所属行业不能为空");
		}
		if (IndustryEnum.getEnumItem(vo.getIndustry()) == null) {
			throw new BusinessException("所属行业值不在约定的范围");
		}
		if (StringUtils.isBlank(vo.getAuthorizedPersonName())) {
			throw new BusinessException("被授权人姓名不能为空");
		}
		if (StringUtils.isBlank(vo.getAuthorizedPersonCertificateNo())) {
			throw new BusinessException("被授权人证件号码 不能为空");
		}
		if (null == vo.getAuthorizedPersonCertificateType()) {
			throw new BusinessException("被授权人证件类型 不能为空");
		}
        if (PersonCertType.getEnumItem(vo.getAuthorizedPersonCertificateType()) == null){
        	throw new BusinessException("被授权人证件类型值不在约定的范围");
        }
		if (StringUtils.isBlank(vo.getAuthorizedPersonCertExpDate())) {
			throw new BusinessException("被授权人证件有效期 不能为空");
		}
		if (!CommonUtil.isDate(vo.getAuthorizedPersonCertExpDate())){
        	throw new BusinessException("被授权人证件有效期格式不正确(yyyy-MM-dd)");
        }
		if (StringUtils.isBlank(vo.getAuthorizedPersonMobile())) {
			throw new BusinessException("被授权人联系电话不能为空");
		}
		if (StringUtils.isBlank(vo.getBusinessLicenceUrl())) {
			throw new BusinessException("businessLicenceUrl 不能为空");
		}
		// 三证 合一 暂不做空check
		/*if (StringUtils.isBlank(vo.getOrganizationCodeCertificateUrl())) {
			throw new BusinessException("organizationCodeCertificateUrl 不能为空");
		}
		if (StringUtils.isBlank(vo.getTaxRegistrationCertificateUrl())) {
			throw new BusinessException("taxRegistrationCertificateUrl 不能为空");
		}
		if (StringUtils.isBlank(vo.getTaxRegistrationCertificateLocalUrl())) {
			throw new BusinessException("taxRegistrationCertificateLocalUrl 不能为空");
		}*/
		if (StringUtils.isBlank(vo.getLegalPersonCertificateFrontUrl())) {
			throw new BusinessException("legalPersonCertificateFrontUrl 不能为空");
		}
		if (StringUtils.isBlank(vo.getLegalPersonCertificateBackUrl())) {
			throw new BusinessException("legalPersonCertificateBackUrl 不能为空");
		}
		if (StringUtils.isBlank(vo.getAccountOpeningLicenseUrl())) {
			throw new BusinessException("accountOpeningLicenseUrl 不能为空");
		}
		if (StringUtils.isBlank(vo.getPowerOfAttorneyUrl())) {
			throw new BusinessException("powerOfAttorneyUrl 不能为空");
		}
		if (StringUtils.isBlank(vo.getServiceApplicationUrl())) {
			throw new BusinessException("serviceApplicationUrl 不能为空");
		}
		if (StringUtils.isBlank(vo.getAuthorizedPersonCertificateFrontUrl())) {
			throw new BusinessException("authorizedPersonCertificateFrontUrl 不能为空");
		}
		if (StringUtils.isBlank(vo.getAuthorizedPersonCertificateBackUrl())) {
			throw new BusinessException("authorizedPersonCertificateBackUrl 不能为空");
		}
	}
}
