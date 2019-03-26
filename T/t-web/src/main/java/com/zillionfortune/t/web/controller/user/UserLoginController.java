/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.user;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
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
import com.zillionfortune.t.common.constants.Constants;
import com.zillionfortune.t.dto.CheckVerifyCodeRequest;
import com.zillionfortune.t.dto.GenerateVerifyCodeRequest;
import com.zillionfortune.t.dto.LoginCodeRequest;
import com.zillionfortune.t.integeration.cif.dto.LoginOutRequest;
import com.zillionfortune.t.integeration.cif.dto.LoginRequest;
import com.zillionfortune.t.service.VerifyCodeService;
import com.zillionfortune.t.web.controller.user.vo.CheckVerifyCodeRequestVo;
import com.zillionfortune.t.web.controller.user.vo.LoginOutRequestVo;
import com.zillionfortune.t.web.controller.user.vo.LoginRequestVo;

/**
 * ClassName: EnterpriseUserLoginController <br/>
 * Function: 企业理财_登入_contorller. <br/>
 * Date: 2016年12月13日 下午6:42:07 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping(value = "/enterpriseuserloginservice")
public class UserLoginController {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserLoginBiz userLoginBiz;
	
	@Autowired
	VerifyCodeService verifyCodeService;
	
	
	
	/**
	 * login:登入. <br/>
	 * http://localhost:8080/cif/enterpriseuserloginservice/login.json?customerNo=100002&loginName=kaiyun&password=123456&loginSource=1
	 *
	 * @param vo LoginRequestVo
	 * @return LoginResponse
	 */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public BaseWebResponse login(@RequestBody LoginRequestVo vo) {
    	log.info("UserLoginController.login.req:" + JSON.toJSONString(vo));
    	
    	BaseWebResponse  resp = null;
    	try {
    		//赋值前台参数
    		LoginRequest req = new LoginRequest();
			PropertyUtils.copyProperties(req, vo);
			//执行登入
			resp = userLoginBiz.login(req);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
    	
    	log.info("UserLoginController.login.resp:" + JSON.toJSONString(resp));
    	
    	return resp;
    }
    
    /**
     * loginout:登出. <br/>
     * http://localhost:8080/t-web/enterpriseuserloginservice/loginout.json?memberId=100001100002&operatorId=2
     *
     * @param request HttpServletRequest
     * @param vo LoginOutRequestVo
     * @return LoginOutResponse
     */
    @RequestMapping(value = "/loginout", method = RequestMethod.POST)
    @ResponseBody
    public BaseWebResponse loginout(HttpServletRequest request, @RequestBody LoginOutRequestVo vo) {
    	log.info("UserLoginController.loginout.req:" + JSON.toJSONString(vo));
    	
    	BaseWebResponse  resp = null;
    	try {
    		//赋值前台参数
    		LoginOutRequest req = new LoginOutRequest();
			PropertyUtils.copyProperties(req, vo);
			//获取header中的AccessToken值
			String accessToken = request.getHeader(Constants.AUTHORIZATION);
			req.setAccessToken(accessToken);
			//执行登出
			resp = userLoginBiz.loginout(req);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
    	
    	log.info("UserLoginController.loginout.resp:" + JSON.toJSONString(resp));
    	
    	return resp;
    }
    
    /**
     * createVerifyCode:获取图片验证码Token. <br/>loginCode createverifycode
     * http://localhost:8080/t-web/enterpriseuserloginservice/loginCode.json?verifySize=4
     *
     * @param response HttpServletResponse
     * @param req GenerateVerifyCodeRequest
     * @return
     */
    @RequestMapping(value = "/loginCode", method = RequestMethod.POST)
    @ResponseBody
    public BaseWebResponse getLoginCode(@RequestBody LoginCodeRequest req) {
    	log.info("UserLoginController.getLoginCode.req:" + JSON.toJSONString(req));
    	
    	BaseWebResponse resp = null;
    	
    	try {
    		resp = userLoginBiz.getLoginCode(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	log.info("UserLoginController.getLoginCode.req:" + JSON.toJSONString(resp));
    	
    	return resp;
    }
    
    /**
     * createVerifyCode:生成图片验证码. <br/>loginCodeImage createverifycode
     * http://localhost:8080/t-web/enterpriseuserloginservice/loginCodeImage.json?codeAuth=sdsd&width=100&height=80
     *
     * @param response HttpServletResponse
     * @param req GenerateVerifyCodeRequest
     * @return
     */
    @RequestMapping(value = "/loginCodeImage", method = RequestMethod.GET)
    @ResponseBody
    public void getLoginCodeImage(HttpServletResponse response, GenerateVerifyCodeRequest req) {
    	log.info("UserLoginController.createVerifyCode.req:" + JSON.toJSONString(req));
    	
    	try {
    		// 禁止图像缓存
    		response.setHeader("Pragma", "No-cache");  
    		response.setHeader("Cache-Control", "no-cache");  
    		response.setDateHeader("Expires", 0);  
    		// 设置响应的类型格式为图片格式  
    		response.setContentType("image/jpeg"); 
    		
            // 生成图片验证码
    		userLoginBiz.getLoginCodeImage(req, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	log.info("UserLoginController.createVerifyCode.req:" + true);
    }
    
    /**
     * checkVerifyCode:校验图片验证码. <br/>
     * http://localhost:8080/t-web/enterpriseuserloginservice/checkLoginCode.json?codeAuth=sdsd&verifyCode=1111
     *
     * @param vo CheckVerifyCodeRequestVo
     * @return CheckVerifyCodeResponse
     */
    @RequestMapping(value = "/checkLoginCode", method = RequestMethod.POST)
    @ResponseBody
    public BaseWebResponse checkLoginCode(@RequestBody CheckVerifyCodeRequestVo vo) {
    	BaseWebResponse resp = null;
    	
		try {
			//赋值前台参数
	    	CheckVerifyCodeRequest req = new CheckVerifyCodeRequest();
			PropertyUtils.copyProperties(req, vo);
			//执行验证码校验
			resp = userLoginBiz.checkLoginCode(req);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
    	
    	return resp;
    }
    
}
