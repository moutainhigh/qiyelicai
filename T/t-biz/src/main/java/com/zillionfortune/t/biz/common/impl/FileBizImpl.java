/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.common.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.common.FileBiz;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.util.OssFileUtil;

/**
 * ClassName: FileBizImpl <br/>
 * Function: 文件处理实现. <br/>
 * Date: 2016年12月20日 下午7:39:02 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
@Component
public class FileBizImpl implements FileBiz {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Value("${oss.bucket.name}")
	private String bucketName;
	/**
	 * ossEndpoint:阿里云文件地址
	 */
	@Value("${oss.endpoint}")
	private String ossEndpoint;
	@Value("${access.id}")
	private String accessId;
	@Value("${access.key}")
	private String accessKey;
	
	/**
	 * @see com.zillionfortune.t.biz.common.FileBiz#upload(org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public BaseWebResponse upload(MultipartFile file){
		log.info("upload.req: ");
		BaseWebResponse resp = null;
		try {
			String objectKey = UUID.randomUUID().toString().trim().replaceAll("-", "") + 
					file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			// 上传
			OssFileUtil fileUtil = new OssFileUtil(ossEndpoint, accessId, accessKey);
			fileUtil.uploadFile(bucketName, file.getInputStream(), objectKey);
			
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			Map<String, Object> rsMap = new HashMap<String, Object>();
			rsMap.put("fileName", objectKey);
			resp.setData(rsMap);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			resp = new BaseWebResponse(RespCode.FAIL.code(),"上传文件处理异常");
		}
		
		log.info("upload.resp:" +JSONObject.toJSONString(resp) );
		return resp;
	}
	
	/**
	 * @see com.zillionfortune.t.biz.common.FileBiz#getOssInputStream(java.lang.String)
	 */
	@Override
	public InputStream getOssInputStream(String objectKey) {
		OssFileUtil fileUtil = new OssFileUtil(ossEndpoint, accessId, accessKey);
		OSSClient client = fileUtil.getClient();
		// 获取Object，返回结果为OSSObject对象
		OSSObject object = client.getObject(bucketName, objectKey);

		// 获取Object的输入流
		InputStream objectContent = object.getObjectContent();
		return objectContent;
	}
}
