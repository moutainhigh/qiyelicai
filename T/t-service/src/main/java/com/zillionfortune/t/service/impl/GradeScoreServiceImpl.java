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

import com.zillionfortune.t.dal.dao.GradeScoreDao;
import com.zillionfortune.t.dal.entity.GradeScore;
import com.zillionfortune.t.service.GradeScoreService;

/**
 * ClassName: GradeScoreServiceImpl <br/>
 * Function: 风险等级操作Service. <br/>
 * Date: 2017年1月9日 下午1:43:27 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Service
public class GradeScoreServiceImpl implements GradeScoreService {
	@Autowired
	private GradeScoreDao gradeScoreDao;

	/**
	 * 根据风险等级编码查询.
	 * @see com.zillionfortune.t.service.GradeScoreService#queryByGradeValue(java.lang.Integer)
	 */
	@Override
	public GradeScore queryByGradeValue(Integer gradeValue) {
		GradeScore gradeScore = new GradeScore();
		gradeScore.setGradeValue(gradeValue);
		List<GradeScore> list = gradeScoreDao.selectByCriteria(gradeScore);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
}
