package com.zillionfortune.t.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.user.UserLoginBiz;
import com.zillionfortune.t.biz.user.impl.UserLoginBizImpl;
import com.zillionfortune.t.common.constants.Constants;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.integeration.cif.dto.LoginAuthRequest;

/**
 * 登录授权过滤器
 * 
 * @author Administrator
 * 
 */
public class AuthFilter implements Filter {

	public FilterConfig config;

	private Logger LOG = org.slf4j.LoggerFactory.getLogger(AuthFilter.class);

	@Override
	public void destroy() {
		this.config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String excludeStrings = config.getInitParameter("excludeStrings");

		String[] excludeList = excludeStrings.split(";");

		if (this.isContains(req.getRequestURI(), excludeList)) {
			chain.doFilter(request, response);
			return;
		}
		
		if(req.getMethod().equalsIgnoreCase("options")){
			chain.doFilter(request, response);
			return;
		}
		
//		System.out.println("/////////////////////////////////////////////////////////////////////"+req.getMethod() );
//	    Enumeration headerNames = req.getHeaderNames();
//	    while (headerNames.hasMoreElements()) {
//	        String key = (String) headerNames.nextElement();
//	        String value = req.getHeader(key);
//	        System.out.println("===="+key+"==="+value);
//	    }

		BaseWebResponse authResponse = null;
		String accessToken = req.getHeader(Constants.AUTHORIZATION);
		StringBuffer errorMsg = new StringBuffer();
		if (StringUtils.isBlank(accessToken)) {
			accessToken = req.getParameter(Constants.AUTHORIZATION);
			if (StringUtils.isBlank(accessToken)) {
				errorMsg.append(Constants.AUTHORIZATION + "无效").append(" ");
			}
		}

		String operatorId = req.getHeader(Constants.OPERATORID);
		if (StringUtils.isBlank(operatorId)) {
			operatorId = req.getParameter(Constants.OPERATORID);
			if (StringUtils.isBlank(operatorId)) {
				errorMsg.append(Constants.OPERATORID + "无效").append(" ");
			}

		}
		String memberId = req.getHeader(Constants.MEMBERID);
		if (StringUtils.isBlank(memberId)) {
			memberId = req.getParameter(Constants.MEMBERID);
			if (StringUtils.isBlank(memberId)) {
				errorMsg.append(Constants.MEMBERID + "无效").append(" ");
			}
		}
		String msg = null;

		if (!StringUtils.isBlank(errorMsg.toString())) {
			msg = errorMsg.append("请重新登录").toString();
			authResponse = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.AUTH_FAIL.code(), msg);
			resp.getWriter().print(JsonUtils.object2Json(authResponse));
			return;
		}

		LoginAuthRequest loginAuthRequest = new LoginAuthRequest();
		loginAuthRequest.setMemberId(memberId);
		loginAuthRequest.setOperatorId(operatorId);
		loginAuthRequest.setAccessToken(accessToken);
		UserLoginBiz userLoginBiz = null;
		// 获取 ServletContext
		ServletContext sc = req.getSession().getServletContext();
		// 获取上下文
        XmlWebApplicationContext cxt = (XmlWebApplicationContext)WebApplicationContextUtils.getWebApplicationContext(sc);
        
		if (cxt != null && cxt.getBean(UserLoginBizImpl.class) != null) {
			userLoginBiz = (UserLoginBiz) cxt.getBean(UserLoginBizImpl.class);
		}
		if (userLoginBiz == null) {
			authResponse = new BaseWebResponse(RespCode.FAIL.code(), ResultCode.FAIL.code(), ResultCode.FAIL.desc());
			msg = JsonUtils.object2Json(authResponse);
			LOG.warn(JsonUtils.object2Json(authResponse));
			resp.getWriter().print(msg);
			return;
		}
		BaseWebResponse res = userLoginBiz.auth(loginAuthRequest);
		//请求成功
		if (res != null && RespCode.SUCCESS.code().equals(res.getRespCode())) {
			authResponse = new BaseWebResponse(RespCode.SUCCESS.code(), res.getResultCode(), res.getResultMsg());
			//鉴权成功
			if (ResultCode.SUCCESS.code().equals(res.getResultCode())) {
				chain.doFilter(request, response);
				return;
			}
			
		} else{
			authResponse = new BaseWebResponse(RespCode.FAIL.code(), ResultCode.FAIL.code(), ResultCode.FAIL.desc());
		}

		if (authResponse != null) {
			msg = JsonUtils.object2Json(authResponse);
			LOG.warn(JsonUtils.object2Json(authResponse));
			resp.getWriter().print(msg);
			return;
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	private boolean isContains(String container, String[] regx) {
		boolean result = false;

		for (int i = 0; i < regx.length; i++) {
			if (container.indexOf(regx[i]) != -1) {
				return true;
			}
		}
		return result;
	}
}
