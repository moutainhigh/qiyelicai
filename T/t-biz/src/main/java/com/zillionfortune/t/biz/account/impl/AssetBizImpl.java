/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.account.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.account.AssetBiz;
import com.zillionfortune.t.biz.account.check.AccountParameterChecker;
import com.zillionfortune.t.biz.user.impl.UserLoginBizImpl;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.integeration.account.AssetIntegeration;
import com.zillionfortune.t.integeration.account.dto.AssetQueryRequest;
import com.zillionfortune.t.integeration.account.dto.AssetQueryResponse;

/**
 * ClassName: assetBizImpl <br/>
 * Function: 企业资产服务接口实现. <br/>
 * Date: 2016年12月19日 下午8:10:02 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Service
public class AssetBizImpl implements AssetBiz {
	
	private static Logger log = LoggerFactory.getLogger(UserLoginBizImpl.class);
	
	@Autowired
	AssetIntegeration assetintegeration;
	
	@Autowired
	AccountParameterChecker tradingParameterChecker;

	@Override
	public BaseWebResponse assetsQuery(AssetQueryRequest req) {
		log.info("AssetBizImpl.assetsQuery.req:" + JsonUtils.object2Json(req));
		
		BaseWebResponse resp = null;
		AssetQueryResponse assetResp = null;
		
		try {
			//校验请求参数
			tradingParameterChecker.checkAssetsQuery(req);
			
			// 执行企业信息查询
			assetResp = assetintegeration.assetsQuery(req);
			
			// 组装响应对象
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			resp.setData(assetResp);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),be.getMessage());
            } else {
            	resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
		}
		log.info("AssetBizImpl.assetsQuery.req:" + JsonUtils.object2Json(resp));
		return resp;
	}

}
