/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.web.controller.user;


import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.user.EnterpriseInfoBiz;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoQueryRequest;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoUpdateRequest;

/**
 * ClassName: UserRegisterController <br/>
 * Function: 企业扩展信息 <br/>
 * Date: 2016年12月13日 下午5:31:26 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping("/enterpriseservice ")
public class UserInfoController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private EnterpriseInfoBiz enterpriseInfoBiz; 
	
	
	/**
	 * enterpriseInfoQuery:企业会员信息查询. <br/>
	 * http://localhost:8080/t-web/enterpriseservice/query.json
	 *
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public BaseWebResponse enterpriseInfoQuery(@RequestBody EnterpriseExtInfoQueryRequest req){
		log.info("UserInfoController.enterpriseInfoQuery.req:" + JSON.toJSONString(req));
		
		BaseWebResponse resp = null; 
		
		try {
			resp = enterpriseInfoBiz.enterpriseInfoQuery(req);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
		
		log.info("UserInfoController.enterpriseInfoQuery.resp:" + JSON.toJSONString(resp));
		
		return resp;
	}
	
	
	/**
	 * enterpriseInfoUpdate:企业会员联系信息更新. <br/>
	 * http://localhost:8080/t-web/enterpriseservice/enterprisecontactinfoupdate.json
	 *
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/enterprisecontactinfoupdate",method=RequestMethod.POST)
	public BaseWebResponse enterpriseInfoUpdate(@RequestBody EnterpriseExtInfoUpdateRequest req){
		log.info("UserInfoController.enterpriseInfoUpdate.req:" + JSON.toJSONString(req));
		
		BaseWebResponse resp = null; 
		
		try {
			resp = enterpriseInfoBiz.enterpriseInfoUpdate(req);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
		
		log.info("UserInfoController.enterpriseInfoUpdate.resp:" + JSON.toJSONString(resp));
		
		return resp;
	}
	
	
	
}
