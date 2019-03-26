/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif;

import com.zillionfortune.t.integeration.cif.dto.UserGradeQueryCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserGradeRequest;
import com.zillionfortune.t.integeration.cif.dto.UserGradeUpdateCifResponse;

/**
 * ClassName: UserGradeIntegration <br/>
 * Function: 企业会员等级相关服务. <br/>
 * Date: 2016年12月15日 下午3:43:22 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface UserGradeIntegration {
	
	/**
	 * updateGrade:企业会员等级更新. <br/>
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public UserGradeUpdateCifResponse updateGrade(UserGradeRequest req) throws Exception;
	
	/**
	 * queryGrade:企业会员等级查询. <br/>
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public UserGradeQueryCifResponse queryGrade(UserGradeRequest req) throws Exception;
	
}
