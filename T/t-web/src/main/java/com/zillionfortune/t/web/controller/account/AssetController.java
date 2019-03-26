/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.account.AssetBiz;
import com.zillionfortune.t.integeration.account.dto.AssetQueryRequest;

/**
 * ClassName: EnterpriseUserLoginController <br/>
 * Function: 企业理财_企业资产_contorller. <br/>
 * Date: 2016年12月13日 下午6:42:07 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping(value = "/asetsservice")
public class AssetController {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AssetBiz assetBiz;
	
	
	
	
	/**
	 * login:登入. <br/>
	 * http://localhost:8080/t-web/asetsservice/query.json?memberId=100002
	 *
	 * @param vo LoginRequestVo
	 * @return LoginResponse
	 */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public BaseWebResponse query(@RequestBody AssetQueryRequest assetRequest) {
    	log.info("AssetController.query.req:" + JSON.toJSONString(assetRequest));
    	
    	BaseWebResponse  resp = null;
    	try {
    		resp = assetBiz.assetsQuery(assetRequest);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
    	
    	log.info("AssetController.query.resp:" + JSON.toJSONString(resp));
    	
    	return resp;
    }
    
}
