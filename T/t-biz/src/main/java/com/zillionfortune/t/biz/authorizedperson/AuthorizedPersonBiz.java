/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.biz.authorizedperson;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonAuditRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonPageQueryRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonQueryRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonStatusQueryRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonUpdateRequest;

/**
 * ClassName: AuthorizedPersonBiz <br/>
 * Function: 被授权服务biz层接口定义. <br/>
 * Date: 2016年12月22日 下午12:35:49 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface AuthorizedPersonBiz {
	
	/**
	 * authorizedPersonUpdate:新增被授权人方法. <br/>
	 *
	 * @param req
	 * @return
	 */
	public BaseWebResponse authorizedPersonUpdate(AuthorizedPersonUpdateRequest req);
	
	/**
	 * authorizedPersonUpdateAudit:更新被授权人审核状态. <br/>
	 *
	 * @param req
	 * @return
	 */
	public BaseWebResponse authorizedPersonUpdateAudit(AuthorizedPersonAuditRequest req);
	
	/**
	 * authorizedPersonQuery:查询被授权人信息. <br/>
	 *
	 * @param req
	 * @return
	 */
	public BaseWebResponse authorizedPersonQuery(AuthorizedPersonQueryRequest req);
	
	/**
	 * authorizedPersonQuery:查询被授权人信息（审核状态）. <br/>
	 *
	 * @param req
	 * @return
	 */
	public BaseWebResponse authorizedPersonStatusQuery(AuthorizedPersonStatusQueryRequest req);
	
	/**
	 * authorizedPersonPageQuery:查询被授权人信息(分页). <br/>
	 *
	 * @param req
	 * @return
	 */
	public BaseWebResponse authorizedPersonPageQuery(AuthorizedPersonPageQueryRequest req);
	
	/**
	 * verifyAuthorizePersonMobile:校验被授权人手机号码. <br/>
	 *
	 * @param memberId
	 * @param mobile
	 * @return
	 */
	public boolean verifyAuthorizePersonMobile(String memberId, String mobile);
	
}
