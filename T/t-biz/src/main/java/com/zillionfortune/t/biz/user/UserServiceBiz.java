/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.user.dto.UserAuthRequest;
import com.zillionfortune.t.biz.user.dto.UserRiskAsessmentRequest;
import com.zillionfortune.t.integeration.cif.dto.UserGradeRequest;

/**
 * ClassName: UserServiceBiz <br/>
 * Function: 企业会员相关服务接口. <br/>
 * Date: 2016年12月20日 下午12:41:39 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface UserServiceBiz {
	
	/**
	 * UserAuthRequest:企业会员身份验证. <br/>
	 *
	 * @param req
	 * @return
	 */
	public BaseWebResponse auth(UserAuthRequest req); 
	
	/**
	 * queryRiskGrade:企业会员风险等级查询. <br/>
	 *
	 * @param req
	 * @return
	 */
	public BaseWebResponse queryRiskGrade(UserGradeRequest req);
	
	/**
	 * riskAsessment:企业会员风险测评. <br/>
	 *
	 * @param req
	 * @return
	 */
	public BaseWebResponse riskAsessment(UserRiskAsessmentRequest req);
	
}
