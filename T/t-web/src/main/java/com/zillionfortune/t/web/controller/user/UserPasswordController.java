/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.user;

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
import com.zillionfortune.t.biz.user.UserLoginBiz;
import com.zillionfortune.t.biz.user.UserPasswordBiz;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordModifyRequest;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordRetrieveRequest;
import com.zillionfortune.t.web.controller.user.check.UserPasswordParameterChecker;
import com.zillionfortune.t.web.controller.user.vo.UserLoginPasswordModifyRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserLoginPasswordRetrieveRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserTradePasswordModifyRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserTradePasswordRetrieveRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserTradePasswordSetRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserTradePasswordVerifyRequestVo;

/**
 * ClassName: UserPasswordController <br/>
 * Function: 企业会员登录密码、交易密码服务Controller. <br/>
 * Date: 2016年12月14日 上午10:55:13 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping(value = "/enterprisepasswordservice")
public class UserPasswordController {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserPasswordBiz userPasswordBiz;
    
    @Autowired
    UserLoginBiz userLoginBiz;
    
    @Autowired
	private UserPasswordParameterChecker parameterChecker;
    
    /**
     * retrieveLoginPassword:企业会员重置登录密码. <br/>
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/retrieveloginpassword", method = RequestMethod.POST)
    @ResponseBody
    public BaseWebResponse retrieveLoginPassword(@RequestBody UserLoginPasswordRetrieveRequestVo vo) {
    	
    	log.info("UserPasswordController.retrieveLoginPassword.req:" + vo);
    	
    	BaseWebResponse resp = null;
    	try {
    		// step1: 参数校验
			parameterChecker.checkUserLoginPasswordRetrieveRequestVo(vo);
			
			// step2: 验证新密码和确认新密码是否一致
			if (!vo.getNewPassword().equals(vo.getRepeatPwd())) {
				// 如果不一致，返回新密码和确认新密码必须一致
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.NEWPASSWORD_REPEATPWD_DIFFERENT_ERROR.code(),
						ResultCode.NEWPASSWORD_REPEATPWD_DIFFERENT_ERROR.desc());

				return resp;
			}
			
			// step3: 参数对象封装
	    	UserLoginPasswordRetrieveRequest req = new UserLoginPasswordRetrieveRequest();
	    	req.setCustomerNo(vo.getCustomerNo()); // 商户号
	    	req.setUserName(vo.getUserName()); // 用户名
	    	req.setNewPassword(vo.getNewPassword()); // 新密码
	    	
	    	// step4： 企业会员重置登录密码处理
	    	resp = userPasswordBiz.retrieveLoginPassword(req);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.FAIL.code(), e.getMessage());
			} else {
				resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
			}
		} finally {
			log.info("UserPasswordController.retrieveLoginPassword.resp:" + JSON.toJSONString(resp));
		}
    	
    	return resp;
    }
    
    /**
     * modifyLoginPassword:企业会员更新登录密码. <br/>
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/modifyloginpassword", method = RequestMethod.POST)
    @ResponseBody
    public BaseWebResponse modifyLoginPassword(@RequestBody UserLoginPasswordModifyRequestVo vo) {
		log.info("UserPasswordController.modifyLoginPassword.req:" + vo);

		BaseWebResponse resp = null;
		try {
			// step1: 参数校验
			parameterChecker.checkUserLoginPasswordModifyRequest(vo);
			
			// step2: 验证新密码和确认新密码是否一致
			if (!vo.getNewPassword().equals(vo.getRepeatPwd())) {
				// 如果不一致，返回新密码和确认新密码必须一致
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.NEWPASSWORD_REPEATPWD_DIFFERENT_ERROR.code(),
						ResultCode.NEWPASSWORD_REPEATPWD_DIFFERENT_ERROR.desc());

				return resp;
			}

			// step3: 验证新密码和原密码是否重复
			if (vo.getNewPassword().equals(vo.getOrgiPassword())) {
				// 如果一致，返回新密码和原密码不能重复
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),
						ResultCode.NEWPASSWORD_ORGIPASSWORD_REPETITION_ERROR.code(),
						ResultCode.NEWPASSWORD_ORGIPASSWORD_REPETITION_ERROR.desc());

				return resp;
			}

			// step4: 企业会员更新登录密码用参数对象封装
			UserLoginPasswordModifyRequest req = new UserLoginPasswordModifyRequest();
			req.setMemberId(vo.getMemberId()); // 会员Id
			req.setNewPassword(vo.getNewPassword()); // 新密码
			req.setOrgiPassword(vo.getOrgiPassword()); // 原密码
			req.setOperatorId(vo.getOperatorId()); // 操作员Id

			// step5: 企业会员更新登录密码
			resp = userPasswordBiz.modifyLoginPassword(req);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.FAIL.code(), e.getMessage());
			} else {
				resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
			}
		} finally {
			log.info("UserPasswordController.modifyLoginPassword.resp:" + JSON.toJSONString(resp));
		}
		
		return resp;
    }
    
    /**
     * retrieveTradePassword:企业会员重置交易密码. <br/>
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/retrievetradepassword", method = RequestMethod.POST)
    @ResponseBody
	public BaseWebResponse retrieveTradePassword(@RequestBody UserTradePasswordRetrieveRequestVo vo) {
    	log.info("UserPasswordController.retrieveTradePassword.req:" + vo);

    	BaseWebResponse resp = null;
		try {
			// step1: 参数校验
			parameterChecker.checkUserTradePasswordRetrieveRequest(vo);
			
			// step2: 验证新密码和确认新密码是否一致
			if (!vo.getNewPassword().equals(vo.getRepeatPwd())) {
				// 如果不一致，返回新密码和确认新密码必须一致
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.NEWPASSWORD_REPEATPWD_DIFFERENT_ERROR.code(),
						ResultCode.NEWPASSWORD_REPEATPWD_DIFFERENT_ERROR.desc());

				return resp;
			}
			
			// step3: 企业会员重置交易密码
			resp = userPasswordBiz.retrieveTradePassword(vo.getMemberId(), vo.getNewPassword());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.FAIL.code(), e.getMessage());
			} else {
				resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
			}
		} finally {
			log.info("UserPasswordController.retrieveTradePassword.resp:" + JSON.toJSONString(resp));
		}
		
		return resp;
	}

    /**
     * modifyTradePassword:企业会员更新交易密码. <br/>
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/modifytradepassword", method = RequestMethod.POST)
    @ResponseBody
	public BaseWebResponse modifyTradePassword(@RequestBody UserTradePasswordModifyRequestVo vo) {
    	log.info("UserPasswordController.modifyTradePassword.req:" + vo);

    	BaseWebResponse resp = null;
		try {
			// step1: 参数校验
			parameterChecker.checkUserTradePasswordModifyRequest(vo);
			
			// step2: 验证新密码和确认新密码是否一致
			if (!vo.getNewPassword().equals(vo.getRepeatPwd())) {
				// 如果不一致，返回新密码和确认新密码必须一致
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.NEWPASSWORD_REPEATPWD_DIFFERENT_ERROR.code(),
						ResultCode.NEWPASSWORD_REPEATPWD_DIFFERENT_ERROR.desc());
	
				return resp;
			}
			
			// step3: 企业会员更新交易密码
			resp = userPasswordBiz.modifyTradePassword(vo.getMemberId(), vo.getNewPassword(),vo.getOrgiPassword());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.FAIL.code(),
						e.getMessage());
			} else {
				resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
			}
		} finally {
			log.info("UserPasswordController.modifyTradePassword.resp:" + JSON.toJSONString(resp));
		}

		return resp;
	}

    /**
     * verifyTradePassword:企业会员验证交易密码. <br/>
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/verifytradepassword", method = RequestMethod.POST)
    @ResponseBody
	public BaseWebResponse verifyTradePassword(@RequestBody UserTradePasswordVerifyRequestVo vo) {
    	log.info("UserPasswordController.verifyTradePassword.req:" + vo);

    	BaseWebResponse resp = null;
		try {
			// step1: 参数校验
			parameterChecker.checkUserTradePasswordVerifyRequest(vo);
			
			// step2: 企业会员验证交易密码
			resp = userPasswordBiz.verifyTradePassword(vo.getMemberId(), vo.getPassword());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.FAIL.code(), e.getMessage());
			} else {
				resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
			}
		} finally {
			log.info("UserPasswordController.verifyTradePassword.resp:" + JSON.toJSONString(resp));
		}
		
		return resp;
	}
    
    /**
     * setTradePassword:企业会员设置交易密码. <br/>
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/settradepassword", method = RequestMethod.POST)
    @ResponseBody
	public BaseWebResponse setTradePassword(@RequestBody UserTradePasswordSetRequestVo vo) {
    	log.info("UserPasswordController.setTradePassword.req:" + vo);

    	BaseWebResponse resp = null;
		try {
			// step1: 参数校验
			parameterChecker.checkUserTradePasswordSetRequest(vo);
			
			// step2: 企业会员设置交易密码
			resp = userPasswordBiz.setTradePassword(vo.getMemberId(), vo.getPassword());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.FAIL.code(), e.getMessage());
			} else {
				resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
			}
		} finally {
			log.info("UserPasswordController.setTradePassword.resp:" + JSON.toJSONString(resp));
		}

		return resp;
	}
    
}
