/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillionfortune.t.dal.dao.ScoreDao;
import com.zillionfortune.t.dal.entity.Score;
import com.zillionfortune.t.service.ScoreService;

/**
 * ClassName: ScoreServiceImpl <br/>
 * Function: 分数信息操作Service 实现. <br/>
 * Date: 2016年12月20日 下午5:44:18 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Service
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private ScoreDao scoreDao;
	
	/**
	 * 新增分数信息.
	 * @see com.zillionfortune.t.service.ScoreService#insertSelective(com.zillionfortune.t.dal.entity.Score)
	 */
	@Override
	public void insertSelective(Score score) {
		scoreDao.insertSelective(score);
	}

	/**
	 * 根据memberId查询分数信息.
	 * @see com.zillionfortune.t.service.ScoreService#queryByMemberId(com.zillionfortune.t.dal.entity.Score)
	 */
	@Override
	public Score queryByMemberId(String memberId) {
		if (StringUtils.isEmpty(memberId)) {
			return null;
		}
		Score score = new Score();
		score.setMemberId(memberId);
		List<Score> list = scoreDao.selectByCriteria(score);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据memberId选择性更新分数信息.
	 * @see com.zillionfortune.t.service.ScoreService#updateByMemberIdSelective(com.zillionfortune.t.dal.entity.Score)
	 */
	@Override
	public int updateByMemberIdSelective(Score score) {
		return scoreDao.updateByMemberIdSelective(score);
	}
	
}
