/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.service;

import java.util.List;

import com.zillionfortune.t.dal.entity.AuthorizedPerson;

/**
 * ClassName: AuthorizedPerson <br/>
 * Function: 被授权人信息操作Service. <br/>
 * Date: 2016年12月16日 下午4:01:18 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public interface AuthorizedPersonService {

	/**
	 * insertAuthorizedPerson:新增被授权人信息. <br/>
	 *
	 * @param authorizedPerson
	 */
	public void insertAuthorizedPerson(AuthorizedPerson authorizedPerson);
	
	/**
	 * updateByMemberIdSelective:根据memberId更新. <br/>
	 *
	 * @param authorizedPerson
	 */
	public void updateByMemberIdSelective(AuthorizedPerson authorizedPerson);
	
	/**
	 * approveAuthorizedPerson:被授权人审核状态修改. <br/>
	 *
	 * @param authorizedPerson
	 */
	public void approveAuthorizedPerson(AuthorizedPerson currentPerson,AuthorizedPerson oldPerson);
	
	/**
	 * updateByPrimaryKeySelective:根据Id更新. <br/>
	 *
	 * @param authorizedPerson
	 */
	public void updateByPrimaryKeySelective(AuthorizedPerson authorizedPerson);

	/**
	 * selectByPrimaryKey:根据主键查询被授权人的信息 <br/>
	 *
	 * @param id
	 */
	public AuthorizedPerson selectByPrimaryKey(Long id);
	
	/**
	 * selectCountByCriteria:根据传入参数统计总条数. <br/>
	 *
	 * @param authorizedPerson
	 */
	public int selectCountByCriteria(AuthorizedPerson authorizedPerson);
	
	
	/**
	 * selectByCriteria:根据传入参数选择性查询数据. <br/>
	 *
	 * @param authorizedPerson
	 */
	public List<AuthorizedPerson> selectByCriteria(AuthorizedPerson authorizedPerson);
	
	/**
	 * selectByMemberIdAndStatus:根据memberId和Status查询. <br/>
	 *
	 * @param memberId
	 * @param status
	 * @return
	 */
	public AuthorizedPerson selectByMemberIdAndStatus(String memberId, int status);
	
}
