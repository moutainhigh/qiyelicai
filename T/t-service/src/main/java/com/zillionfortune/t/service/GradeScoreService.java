/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.service;

import com.zillionfortune.t.dal.entity.GradeScore;

/**
 * ClassName: GradeScoreService <br/>
 * Function: 风险等级操作Service. <br/>
 * Date: 2017年1月9日 下午1:36:04 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface GradeScoreService {

	/**
	 * queryByGradeValue:根据风险等级编码查询. <br/>
	 *
	 * @param gradeValue
	 * @return
	 */
	public GradeScore queryByGradeValue(Integer gradeValue);
	
}
