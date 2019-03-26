package com.zillionfortune.t.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author zhengrunlong
 * @date 2016/11/10
 */
public enum ResultCode {
	
	/** 0000: 业务处理成功 **/
	SUCCESS("0000","业务处理成功"),
	
	/** 9999: 业务处理失败 **/
	FAIL("9999","业务处理失败"),
	
	SMS_9000("SMS9000","请求报文为空"),
	SMS_9001("SMS9001","请求报文解析错误"),
	SMS_9002("SMS9002","接入系统编码错误"),
	SMS_9003("SMS9003","短信编码错误"),
	SMS_9004("SMS9004","短信接收方手机号错误"),
	SMS_9005("SMS9005","短信内容错误"),
	SMS_9007("SMS9007","短信接收方手机号数量超出最大设置"),
	SMS_9008("SMS9008","本地短信模板配置错误"),
	SMS_9009("SMS9009","远程短信模板配置错误"),
	SMS_9010("SMS9010","目标短信渠道配置错误"),
	SMS_9011("SMS9011","组装模板报文错误"),
	SMS_9012("SMS9012","保存短信消息体异常"),
	SMS_9013("SMS9013","目标渠道队列生产者配置错误"),
	SMS_9014("SMS9014","空流水号错误"),
	SMS_9015("SMS9015","验证码码长度错误"),
	SMS_9016("SMS9016","生成动态码错误"),
	SMS_9017("SMS9017","验证码错误"),
	
	/** VERIFICATION_CODE_TIMEOUT: 验证码已过期 **/
	VERIFICATION_CODE_TIMEOUT("5001","验证码已过期"),
	
	/** VERIFICATION_CODE_ERROR: 您输入的验证码不正确 **/
	VERIFICATION_CODE_ERROR("5002","您输入的验证码不正确"),
	
	/** AUTHORIZED_PERSON_ID_ERROR: 被授权人编号不正确 **/
	AUTHORIZED_PERSON_ID_ERROR("5003","被授权人编号不正确"),
	
	/** AUTHORIZED_PERSON_ID_NOT_EQUALS_MEMBER_ID: 被授权人编号和会员编号不匹配 **/
	AUTHORIZED_PERSON_ID_NOT_EQUALS_MEMBER_ID("5004","被授权人编号和会员编号不匹配"),
	
	/** AUTHORIZED_PERSON_CHECK_NOT_PASS: 被授权人尚未审核通过不能进行复核通过 **/
	AUTHORIZED_PERSON_CHECK_NOT_PASS("5005","被授权人尚未审核通过不能进行复核通过"),
	
	/** SMS_VERIFY_MOBILE_ERROR: 被授权人尚未审核通过不能进行复核通过 **/
	SMS_VERIFY_MOBILE_ERROR("5006","您的手机号未注册"),
	
	/** EXISTS_CERTTYPE_AND_CERTNO: 企业证件类型和证件号码已经被注册 **/
	EXISTS_CERTTYPE_AND_CERTNO("5007","该企业已注册"),
	
	/** AUTHORIZED_PERSON_APPROVING: 没有待审批的被授权人 **/
	AUTHORIZED_PERSON_APPROVING("5008","没有待审批的被授权人"),
	
	AUTH_FAIL("2000","鉴权失败，请重新登录"),

	/** NEWPASSWORD_REPEATPWD_DIFFERENT_ERROR: 新密码和确认新密码必须一致**/
	NEWPASSWORD_REPEATPWD_DIFFERENT_ERROR("2001","新密码和确认新密码必须一致"),
	
	/** NEWPASSWORD_ORGIPASSWORD_REPETITION_ERROR: 新密码和原密码不能重复**/
	NEWPASSWORD_ORGIPASSWORD_REPETITION_ERROR("2002","新密码和原密码不能重复"),
	
	/** USER_NOT_LOGIN: 用户未登录 **/
    USER_NOT_LOGIN("2003", "用户未登录"),
	
    /** CUSTOMER_NOT_FOUND: 客户信息不存在 **/
	CUSTOMER_NOT_FOUND("2004","客户信息不存在"),
	
	/** RISK_ASESSMENT_NOT_COMPLETE: 风险测评答题未完成 **/
	RISK_ASESSMENT_NOT_COMPLETE("2005","风险测评答题未完成"),
	
	/**  AUTHORIZE_PERSON_MOBILE_ERROR:被授权人手机号码不正确  */
	AUTHORIZE_PERSON_MOBILE_ERROR("2006","被授权人手机号码不正确"),
	/**  BANK_NO_EXIST:企业银行账号已被其他客户绑定  */
	BANK_NO_EXIST("2007","企业银行账号已被其他客户绑定"),
	
	/**  PIC_VERIFY_CODE_NULL:图片验证码不能为空[4001]  */
	PIC_VERIFY_CODE_NULL("4001","图片验证码不能为空"),
	
	/**  PIC_VERIFY_CODE_ERROR:图片验证码错误[4002]  */
	PIC_VERIFY_CODE_ERROR("4002","图片验证码错误"),
	
	/**  PIC_VERIFY_CODE_TOKEN_NULL:图片验证码token为空或过期[4003]  */
	PIC_VERIFY_CODE_TOKEN_NULL("4003","图片验证码token为空或过期");
	
	private String code;
	private String desc;

    ResultCode(String code,String desc){
        this.code=code;
        this.desc=desc;
    }

    public String code(){
        return code;
    }

    public String desc(){
        return desc;
    }
    
    public static String getDesc(String code){
    	for(ResultCode item : ResultCode.values()){
    		if(StringUtils.equals(item.code, code)){
    			return item.desc();
    		}
    	}
    	
    	return null;
    }
    
}

