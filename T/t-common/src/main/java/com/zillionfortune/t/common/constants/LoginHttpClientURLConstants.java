package com.zillionfortune.t.common.constants;
/**
 * ClassName: LoginHttpClientURLConstants <br/>
 * Function: HttpClient调用远程的ReqURL. <br/>
 * Date: 2016年12月13日 下午2:55:55 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class LoginHttpClientURLConstants {
	/**
	 * 企业登入（获取AccessToken）
	 */
	public final static String CIF_LOGIN_URL= "http://192.168.0.41:8080/cif/enterpriseuserloginservice/login.html";
	
	/**
	 * 企业登入鉴权（校验AccessToken）
	 */
	public final static String CIF_AUTH_URL= "http://192.168.0.41:8080/cif/enterpriseuserloginservice/auth.html";
	
	/**
	 * 企业登出
	 */
	public final static String CIF_LOGINOUT_URL= "http://192.168.0.41:8080/cif/enterpriseuserloginservice/loginout.html";

}
