/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.service;

import com.zillionfortune.t.dal.entity.Score;

/**
 * ClassName: ScoreService <br/>
 * Function: 分数信息操作Service. <br/>
 * Date: 2016年12月20日 下午5:37:18 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface ScoreService {

	/**
	 * insertSelective:新增分数信息. <br/>
	 *
	 * @param score
	 */
	public void insertSelective(Score score);
	
	/**
	 * queryByMemberId:根据memberId查询分数信息. <br/>
	 *
	 * @param memberId
	 * @return
	 */
	public Score queryByMemberId(String memberId);
	
	/**
	 * updateByMemberIdSelective:根据memberId选择性更新分数信息. <br/>
	 *
	 * @param record
	 * @return
	 */
	public int updateByMemberIdSelective(Score score);
}
