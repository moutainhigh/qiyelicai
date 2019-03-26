/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.user.dto.QualificationUploadRequest;
import com.zillionfortune.t.biz.user.dto.UserImproveInfoRequest;

/**
 * ClassName: EnterpriseQualityAuth <br/>
 * Function: 用户资质审核. <br/>
 * Date: 2016年12月15日 下午2:36:27 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public interface EnterpriseQualityAuthBiz {

	/**
	 * enterpriseinfoupdate:完善资料. <br/>
	 *
	 * @param req
	 * @return
	 */
	public BaseWebResponse enterpriseinfoupdate(UserImproveInfoRequest req);
	
	/**
	 * uploadQualifications:更新保存企业资质信息. <br/>
	 *
	 * @param req
	 * @return
	 */
	public BaseWebResponse updateQualifications(QualificationUploadRequest req);
	
}
