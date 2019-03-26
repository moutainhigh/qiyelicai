/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.user.EnterpriseInfoBiz;
import com.zillionfortune.t.biz.user.EnterpriseQualityAuthBiz;
import com.zillionfortune.t.biz.user.dto.QualificationUploadRequest;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.web.controller.user.check.EnterpriseQualityAuthParameterChecker;

/**
 * ClassName: UserInfoAuthController <br/>
 * Function: 企业资质审核. <br/>
 * Date: 2016年12月16日 上午9:47:18 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping(value = "/enterpriseservice")
public class EnterpriseQualityAuthController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EnterpriseQualityAuthParameterChecker parameterChecker;
	
	@Autowired
	private EnterpriseQualityAuthBiz enterpriseQualityAuthBiz;
	@Autowired
	private EnterpriseInfoBiz enterpriseInfoBiz;
	
	/**
	 * addImproveInfo:完善资料,上传企业资质（已登录） <br/>
	 *
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/enterpriseinfoupdate",method=RequestMethod.POST)
	public BaseWebResponse enterpriseinfoupdate(@RequestBody QualificationUploadRequest vo) {
		log.info("uloadQualifications.req=" + JSONObject.toJSONString(vo));
		
		BaseWebResponse resp = null;
		
		try {
			//1.===参数校验
			parameterChecker.checkUloadQualificationsParam(vo);
			//2.银行账号检查
			boolean exist = enterpriseInfoBiz.findBankAccountNo(vo.getBankAccountNo());
			if (exist) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.BANK_NO_EXIST.code(), 
						ResultCode.BANK_NO_EXIST.desc());
				return resp;
			}
			//3.===调用服务
			resp = enterpriseQualityAuthBiz.updateQualifications(vo);
		}catch (BusinessException e){
			log.error(e.getMessage(), e);
            resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
		} finally {
			log.info("uloadQualifications.resp:" + JSON.toJSONString(resp));
		}
		return resp;
	}
	
	/**
	 * addImproveInfo:完善资料,上传企业资质（未登录） <br/>
	 *
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/enterpriseinfoupdatenologin",method=RequestMethod.POST)
	public BaseWebResponse enterpriseinfoupdateNoLogin(@RequestBody QualificationUploadRequest vo) {
		return enterpriseinfoupdate(vo);
	}
	
	/**
	 * checkBankAccountNo:校验银行账号是否已存在. <br/>
	 *
	 * @param bankAccountNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/checkbankaccountno",method=RequestMethod.POST)
	public BaseWebResponse checkBankAccountNo(@RequestBody JSONObject jsonObject) {
		log.info("checkBankAccountNo.req= " + JSON.toJSONString(jsonObject));
		BaseWebResponse resp = null;
		
		try {
			String bankAccountNo = jsonObject.getString("bankAccountNo");
			//1.===参数校验
			if (StringUtils.isBlank(bankAccountNo)) {
				throw new BusinessException("bankAccountNo 不能为空");
			}
			//2.获取银行账号检查结果
			boolean exist = enterpriseInfoBiz.findBankAccountNo(bankAccountNo);

			//3.===封装反馈
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("existFlag", exist);
			resp.setData(dataMap);
		}catch (BusinessException e){
			log.error(e.getMessage(), e);
            resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
		} finally {
			log.info("checkBankAccountNo.resp:" + JSON.toJSONString(resp));
		}
		
		return resp;
	}
	
}
