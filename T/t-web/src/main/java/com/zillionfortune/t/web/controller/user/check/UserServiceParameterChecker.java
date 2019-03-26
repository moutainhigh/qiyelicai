/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.user.check;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.web.controller.user.vo.UserAuthRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserQueryRiskGradeRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserRiskAsessmentRequestVo;

/**
 * ClassName: UserServiceParameterChecker <br/>
 * Function: 企业会员服务 请求参数校验. <br/>
 * Date: 2016年12月20日 上午10:51:26 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class UserServiceParameterChecker {

	/**
	 * checkAuthRequestVo:企业会员身份验证业务 请求参数校验. <br/>
	 *
	 * @param vo
	 * @throws Exception
	 */
	public void checkUserAuthRequestVo(UserAuthRequestVo vo)
			throws Exception {
		// 校验请求参数
		if (vo == null) {
			throw new BusinessException("请求对象不能为空");
		}

		if (StringUtils.isBlank(vo.getMemberId())
			|| StringUtils.isBlank(vo.getCertificateNo())
			|| StringUtils.isBlank(vo.getLegalPersonCertificateNo())) {
			throw new BusinessException("memberId,certificateNo,legalPersonCertificateNo皆不能为空");
		}
	}
	
	/**
	 * checkUserRiskAsessmentRequestVo:企业会员风险测评业务 请求参数校验. <br/>
	 *
	 * @param vo
	 * @throws Exception
	 */
	public void checkUserRiskAsessmentRequestVo(UserRiskAsessmentRequestVo vo)
			throws Exception {
		// 校验请求参数
		if (vo == null) {
			throw new BusinessException("请求对象不能为空");
		}

		if (StringUtils.isBlank(vo.getMemberId())
			|| vo.getAnswers() == null) {
			throw new BusinessException("memberId,answers皆不能为空");
		}
	}
	
	/**
	 * checkUserQueryRiskGradeRequestVo:企业会员查询风险等级业务 请求参数校验. <br/>
	 *
	 * @param vo
	 * @throws Exception
	 */
	public void checkUserQueryRiskGradeRequestVo(UserQueryRiskGradeRequestVo vo)
			throws Exception {
		// 校验请求参数
		if (vo == null) {
			throw new BusinessException("请求对象不能为空");
		}
		
		if (StringUtils.isBlank(vo.getMemberId())) {
			throw new BusinessException("memberId不能为空");
		}

	}

}
