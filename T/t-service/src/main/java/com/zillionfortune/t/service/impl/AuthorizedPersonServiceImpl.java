/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zillionfortune.t.dal.dao.AuthorizedPersonDao;
import com.zillionfortune.t.dal.entity.AuthorizedPerson;
import com.zillionfortune.t.service.AuthorizedPersonService;

/**
 * ClassName: AuthorizedPersonServiceImpl <br/>
 * Function: AuthorizedPersonService 实现. <br/>
 * Date: 2016年12月16日 下午4:02:38 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
@Service
public class AuthorizedPersonServiceImpl implements AuthorizedPersonService {
	@Autowired
	private AuthorizedPersonDao authorizedPersonDao;
	
	/**
	 * @see com.zillionfortune.t.service.AuthorizedPersonService#insertAuthorizedPerson(com.zillionfortune.t.dal.entity.AuthorizedPerson)
	 */
	@Override
	public void insertAuthorizedPerson(AuthorizedPerson authorizedPerson) {
		authorizedPersonDao.insertSelective(authorizedPerson);
	}
	
	/**
	 * @see com.zillionfortune.t.service.AuthorizedPersonService#updateByMemberIdSelective(com.zillionfortune.t.dal.entity.AuthorizedPerson)
	 */
	@Override
	public void updateByMemberIdSelective(AuthorizedPerson authorizedPerson) {
		authorizedPersonDao.updateByMemberIdSelective(authorizedPerson);
	}

	/**
	 * 被授权人审核状态修改.
	 * @see com.zillionfortune.t.service.AuthorizedPersonService#approveAuthorizedPerson(com.zillionfortune.t.dal.entity.AuthorizedPerson)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void approveAuthorizedPerson(AuthorizedPerson currentPerson,AuthorizedPerson oldPerson) {
		
		//1.===更新当前授权人的状态
		authorizedPersonDao.updateByPrimaryKeySelective(currentPerson);
		
		//2.===废弃其他所有被授权人
		authorizedPersonDao.discardOtherAuthorizedPerson(oldPerson);
		
	}
	
	/**
	 * @see com.zillionfortune.t.service.AuthorizedPersonService#updateByPrimaryKeySelective(com.zillionfortune.t.dal.entity.AuthorizedPerson)
	 */
	@Override
	public void updateByPrimaryKeySelective(AuthorizedPerson authorizedPerson) {
		authorizedPersonDao.updateByPrimaryKeySelective(authorizedPerson);
	}

	/**
	 * 根据主键查询.
	 * @see com.zillionfortune.t.service.AuthorizedPersonService#selectByPrimaryKey(java.lang.Long)
	 */
	@Override
	public AuthorizedPerson selectByPrimaryKey(Long id) {
		
		return authorizedPersonDao.selectByPrimaryKey(id);
	}

	/**
	 * 根据传入参数选择性查询数据.
	 * @see com.zillionfortune.t.service.AuthorizedPersonService#selectByCriteria(com.zillionfortune.t.dal.entity.AuthorizedPerson)
	 */
	@Override
	public List<AuthorizedPerson> selectByCriteria(AuthorizedPerson authorizedPerson) {
		
		return authorizedPersonDao.selectByCriteria(authorizedPerson);
		
	}
	
	/**
	 * @see com.zillionfortune.t.service.AuthorizedPersonService#selectByMemberIdAndStatus(java.lang.String, int)
	 */
	@Override
	public AuthorizedPerson selectByMemberIdAndStatus(String memberId, int status) {
		AuthorizedPerson authorizedPerson = new AuthorizedPerson();
		authorizedPerson.setMemberId(memberId);
		authorizedPerson.setStatus(status);
		List<AuthorizedPerson> rsList = selectByCriteria(authorizedPerson);
		if (rsList != null && !rsList.isEmpty()) {
			return rsList.get(0);
		}
		return null;
	}

	/**
	 * 根据传入参数统计总条数.
	 * @see com.zillionfortune.t.service.AuthorizedPersonService#selectCountByCriteria(com.zillionfortune.t.dal.entity.AuthorizedPerson)
	 */
	@Override
	public int selectCountByCriteria(AuthorizedPerson authorizedPerson) {
		
		return authorizedPersonDao.selectCountByCriteria(authorizedPerson);
	}

}
