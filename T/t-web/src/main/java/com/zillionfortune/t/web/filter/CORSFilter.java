package com.zillionfortune.t.web.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.zillionfortune.t.common.util.ReadProperties;

/**
 * ClassName: CORSFilter <br/>
 * Function: tomcat服务器提供的接口，不能在其他域中访问的时候，需要增 Access-Control-Allow-Origin:* . <br/>
 * Date: 2017年1月9日 下午2:48:31 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class CORSFilter implements Filter {
	
	ReadProperties readProperties = null;
	Map<String,Object> map = null;
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	readProperties = new ReadProperties();
    	map = readProperties.loadToMap("configurations.properties");
    }
 
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        
        if ("true".equals(map.get("app.debug")) ) {
        	// 允许跨域访问
        	httpResponse.addHeader("Access-Control-Allow-Origin", map.get("app.allowOrigin").toString() );
            httpResponse.setHeader("Access-Control-Allow-Headers", map.get("app.allowHeaders").toString() );
            httpResponse.setHeader("Access-Control-Allow-Methods", map.get("app.allowMethods").toString() );
        }
        
        filterChain.doFilter(servletRequest, servletResponse);
    }
 
    @Override
    public void destroy() {
 
    }
}
