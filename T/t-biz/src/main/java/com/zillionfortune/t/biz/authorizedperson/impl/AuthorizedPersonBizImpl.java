/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.biz.authorizedperson.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebPageResponse;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.authorizedperson.AuthorizedPersonBiz;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonAuditRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonPageQueryRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonQueryRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonStatusQueryRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonUpdateRequest;
import com.zillionfortune.t.common.enums.CheckStatus;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.common.util.DateUtil;
import com.zillionfortune.t.common.util.PageBean;
import com.zillionfortune.t.dal.entity.AuthorizedPerson;
import com.zillionfortune.t.service.AuthorizedPersonService;

/**
 * ClassName: AuthorizedPersonBizImpl <br/>
 * Function: 被授权服务biz层接口实现. <br/>
 * Date: 2016年12月22日 下午12:39:09 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class AuthorizedPersonBizImpl implements AuthorizedPersonBiz {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthorizedPersonService authorizedPersonService;
	
	/**
	 * 新增被授权人方法.
	 * @see com.zillionfortune.t.biz.authorizedperson.AuthorizedPersonBiz#authorizedPersonUpdate(com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonUpdateRequest)
	 */
	@Override
	public BaseWebResponse authorizedPersonUpdate(AuthorizedPersonUpdateRequest req) {
		
		log.info("AuthorizedPersonBizImpl.authorizedPersonUpdate.req:" + JSON.toJSONString(req));
		
		BaseWebResponse resp;
		
		try {
			
			//1.===新增被授权人信息
			AuthorizedPerson authorizedPerson = new AuthorizedPerson();
			authorizedPerson.setId(req.getAuthorizedPersonId());
			authorizedPerson.setMemberId(req.getMemberId());
			authorizedPerson.setName(req.getName());
			authorizedPerson.setCertificateType(Integer.parseInt(req.getCertificateType()));
			authorizedPerson.setCertificateNo(req.getCertificateNo());
			authorizedPerson.setCertificateExpireDate(DateUtil.strToDate(req.getCertExpDate(), DateUtil.DATAFORMAT_STR));
			authorizedPerson.setMobile(req.getMobile());
			authorizedPerson.setStatus(CheckStatus.CHECK_WAIT.code());
			authorizedPerson.setAuthorizationUrl(req.getAuthorizationUrl());
			authorizedPerson.setCertificateFrontUrl(req.getCertificateFrontUrl());
			authorizedPerson.setCertificateBackUrl(req.getCertificateBackUrl());
			
			if( req.getAuthorizedPersonId() == null ){//没有就插入，有着更新
				authorizedPersonService.insertAuthorizedPerson(authorizedPerson);
			}
			
			authorizedPersonService.updateByPrimaryKeySelective(authorizedPerson);
			
			//2.===处理反馈结果
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			
			Map<String,String> respMap = new HashMap<String,String>();
			respMap.put("memberId", req.getMemberId());
			resp.setData(respMap);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		}
		
		log.info("AuthorizedPersonBizImpl.authorizedPersonUpdate.resp:" + JSON.toJSONString(resp));
		
		return resp;
	}

	/**
	 * 更新被授权人审核状态.
	 * @see com.zillionfortune.t.biz.authorizedperson.AuthorizedPersonBiz#authorizedPersonUpdate(java.lang.String, java.lang.Integer)
	 */
	@Override
	public BaseWebResponse authorizedPersonUpdateAudit(AuthorizedPersonAuditRequest req) {

		log.info("AuthorizedPersonBizImpl.authorizedPersonUpdateAudit.req:" + JSON.toJSONString(req));
		
		BaseWebResponse resp = null;
		Long authorizedPersonId = null;
		try {
			
			//1.===参数绑定
			/*AuthorizedPerson currentPerson = new AuthorizedPerson();
			currentPerson.setId(req.getAuthorizedPersonId());
			currentPerson.setStatus(req.getStatus());*/
			
			AuthorizedPerson authorizedPerson = new AuthorizedPerson();
			authorizedPerson.setMemberId(req.getMemberId());
			
			//2.===执行查询操作
			List<AuthorizedPerson> listAuthorizedPerson = authorizedPersonService.selectByCriteria(authorizedPerson);
			
			if(CollectionUtils.isNotEmpty(listAuthorizedPerson) && listAuthorizedPerson.size()>0){
				
				for(AuthorizedPerson person : listAuthorizedPerson){
					if(CheckStatus.CHECK_WAIT.code() == person.getStatus()){
						authorizedPersonId = person.getId();
						break;
					}
				}
			}
			
			if(authorizedPersonId == null){
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.AUTHORIZED_PERSON_APPROVING.code(),
						ResultCode.AUTHORIZED_PERSON_APPROVING.desc());
				return resp;
			}
			
			/*//2.===当传递过来的是复核通过的时候检查被授权人是否审核通过
			AuthorizedPerson authorizedPerson = authorizedPersonService.selectByPrimaryKey(req.getAuthorizedPersonId());
			if(authorizedPerson == null ){
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.AUTHORIZED_PERSON_ID_ERROR.code(),
						ResultCode.AUTHORIZED_PERSON_ID_ERROR.desc());
				return resp;
			}
			
			if (!req.getMemberId().equals(authorizedPerson.getMemberId())){
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.AUTHORIZED_PERSON_ID_NOT_EQUALS_MEMBER_ID.code(),
						ResultCode.AUTHORIZED_PERSON_ID_NOT_EQUALS_MEMBER_ID.desc());
				return resp;
			}
			
			if(CheckStatus.CHECK_PASS_REVIEW_PASS.code() == req.getStatus().intValue() 
					&& CheckStatus.CHECK_PASS_REVIEWING.code() != authorizedPerson.getStatus()){
				
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.AUTHORIZED_PERSON_CHECK_NOT_PASS.code(),
						ResultCode.AUTHORIZED_PERSON_CHECK_NOT_PASS.desc());
				return resp;
			}*/
			
			//3.===更新被授权人审核状态
			AuthorizedPerson currentPerson = new AuthorizedPerson();
			currentPerson.setId(authorizedPersonId);
			currentPerson.setStatus(req.getStatus());
			
			if(CheckStatus.CHECK_PASS_REVIEW_PASS.code() == req.getStatus().intValue()){//只有当前被复核人复核通过，才能废弃其他所有被授权人
			
				AuthorizedPerson oldPerson = new AuthorizedPerson();
				oldPerson.setMemberId(req.getMemberId());
				oldPerson.setId(authorizedPersonId);
				oldPerson.setStatus(CheckStatus.CHECK_DISCARD.code());
				
				authorizedPersonService.approveAuthorizedPerson(currentPerson, oldPerson);
				
			}else{//只更新当前审核人的状态
				
				authorizedPersonService.updateByPrimaryKeySelective(currentPerson);
			}
			
			//4.===处理反馈结果
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			
			Map<String,String> respMap = new HashMap<String,String>();
			respMap.put("memberId", req.getMemberId());
			//respMap.put("authorizedPersonId", String.valueOf(req.getAuthorizedPersonId()));
			resp.setData(respMap);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} finally {
			log.info("AuthorizedPersonBizImpl.authorizedPersonUpdateAudit.resp:" + JSON.toJSONString(resp));
		}
	
		return resp;
	}

	/**
	 * 查询被授权人信息.
	 * @see com.zillionfortune.t.biz.authorizedperson.AuthorizedPersonBiz#authorizedPersonQuery(com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonQueryRequest)
	 */
	@Override
	public BaseWebResponse authorizedPersonQuery(AuthorizedPersonQueryRequest req) {


		log.info("AuthorizedPersonBizImpl.authorizedPersonQuery.req:" + JSON.toJSONString(req));
		
		BaseWebResponse resp;
		
		try {
			
			//1.===参数绑定
			AuthorizedPerson authorizedPerson = new AuthorizedPerson();
			authorizedPerson.setMemberId(req.getMemberId());
			authorizedPerson.setId(req.getAuthorizedPersonId());
			
			//2.===执行查询操作
			List<AuthorizedPerson> listAuthorizedPerson = authorizedPersonService.selectByCriteria(authorizedPerson);
			
			//3.===处理反馈结果
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			
			if(CollectionUtils.isNotEmpty(listAuthorizedPerson) && listAuthorizedPerson.size()>0){
				
				resp.setData(listAuthorizedPerson.get(0)); 
			}
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		}
		
		log.info("AuthorizedPersonBizImpl.authorizedPersonQuery.resp:" + JSON.toJSONString(resp));
		
		return resp;
	
	}
	
	/**
	 * 查询被授权人信息(审核状态).
	 * @see com.zillionfortune.t.biz.authorizedperson.AuthorizedPersonBiz#authorizedPersonStatusQuery(com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonStatusQueryRequest)
	 */
	@Override
	public BaseWebResponse authorizedPersonStatusQuery(AuthorizedPersonStatusQueryRequest req) {


		log.info("AuthorizedPersonBizImpl.authorizedPersonStatusQuery.req:" + JSON.toJSONString(req));
		
		BaseWebResponse resp;
		
		try {
			
			//1.===参数绑定
			AuthorizedPerson authorizedPerson = new AuthorizedPerson();
			authorizedPerson.setMemberId(req.getMemberId());
			
			//2.===执行查询操作
			List<AuthorizedPerson> listAuthorizedPerson = authorizedPersonService.selectByCriteria(authorizedPerson);
			
			//3.===处理反馈结果
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			
			Map<String,Boolean> dataMap = new HashMap<String,Boolean>();
			dataMap.put("status", false);
			
			if(CollectionUtils.isNotEmpty(listAuthorizedPerson) && listAuthorizedPerson.size()>0){
				
				for(AuthorizedPerson person : listAuthorizedPerson){
					if(CheckStatus.CHECK_WAIT.code() == person.getStatus() 
							|| CheckStatus.CHECK_PASS_REVIEWING.code() == person.getStatus()){
						dataMap.put("status", true);
						break;
					}
				}
			}
			
			resp.setData(dataMap);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		}
		
		log.info("AuthorizedPersonBizImpl.authorizedPersonStatusQuery.resp:" + JSON.toJSONString(resp));
		
		return resp;
	
	}
	
	/**
	 * 查询被授权人信息(分页).
	 * @see com.zillionfortune.t.biz.authorizedperson.AuthorizedPersonBiz#authorizedPersonQuery(com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonQueryRequest)
	 */
	@Override
	public BaseWebResponse authorizedPersonPageQuery(AuthorizedPersonPageQueryRequest req) {


		log.info("AuthorizedPersonBizImpl.authorizedPersonPageQuery.req:" + JSON.toJSONString(req));
		
		BaseWebPageResponse resp = null;
		
		try {
			
			//1.===参数绑定
			AuthorizedPerson authorizedPerson = new AuthorizedPerson();
			authorizedPerson.setStatus(req.getStatus());
			authorizedPerson.setPageStart(req.getPageStart());
			authorizedPerson.setPageSize(req.getPageSize());
			
			//2.===执行查询操作
			
			int count = authorizedPersonService.selectCountByCriteria(authorizedPerson);
			
			List<AuthorizedPerson> listAuthorizedPerson = authorizedPersonService.selectByCriteria(authorizedPerson);
			
			//3.===处理反馈结果
			resp = new BaseWebPageResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			resp.setPageSize(req.getPageSize());
			resp.setCurrentPage(req.getCurrentPage());
			resp.setTotal(count);
			
			if(count > 0 && req.getPageSize() !=null ){
				resp.setTotalPage(new PageBean().countPageCount(count, req.getPageSize()));
			}
			
			if(count >0 && CollectionUtils.isNotEmpty(listAuthorizedPerson)){
				
				resp.setData(listAuthorizedPerson); 
			}
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			if (e instanceof BusinessException) {
				
                resp = new BaseWebPageResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebPageResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		}
		
		log.info("AuthorizedPersonBizImpl.authorizedPersonPageQuery.resp:" + JSON.toJSONString(resp));
		
		return resp;
	
	}
	
	/**
	 * @see com.zillionfortune.t.biz.authorizedperson.AuthorizedPersonBiz#verifyAuthorizePersonMobile(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean verifyAuthorizePersonMobile(String memberId, String mobile) {
		log.info("verifyAuthorizePersonMobile.req: memberId=" + memberId + ",mobile=" + mobile);
		
		boolean rsFlg = true;
		
		try {
			
			//1.===参数绑定
			AuthorizedPerson authorizedPerson = new AuthorizedPerson();
			authorizedPerson.setMobile(mobile);
			authorizedPerson.setMemberId(memberId);
			authorizedPerson.setStatus(CheckStatus.CHECK_PASS_REVIEW_PASS.code());
			
			//2.===执行查询操作
			List<AuthorizedPerson> listAuthorizedPerson = authorizedPersonService.selectByCriteria(authorizedPerson);
			
			if(CollectionUtils.isEmpty(listAuthorizedPerson)){
				rsFlg = false;
			}
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			rsFlg = false;
		}
		
		log.info("verifyAuthorizePersonMobile.rsFlg:" + rsFlg);
		
		return rsFlg;
	}

}
