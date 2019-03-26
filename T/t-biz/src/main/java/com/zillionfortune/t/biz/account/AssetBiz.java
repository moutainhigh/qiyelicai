/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.account;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.integeration.account.dto.AssetQueryRequest;

/**
 * ClassName: assetBiz <br/>
 * Function: 企业资产服务接口. <br/>
 * Date: 2016年12月19日 下午8:08:33 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface AssetBiz {
	
	/**
	 * assetsQuery:企业资产查询. <br/>
	 *
	 * @param req AssetQueryRequest
	 * @return BaseWebResponse
	 */
	public BaseWebResponse assetsQuery(AssetQueryRequest req);

}
