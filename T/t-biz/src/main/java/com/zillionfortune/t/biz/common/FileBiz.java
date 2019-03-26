/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.common;

import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.zillionfortune.common.dto.BaseWebResponse;

/**
 * ClassName: FileBiz <br/>
 * Function: 文件处理服务. <br/>
 * Date: 2016年12月20日 下午7:37:29 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public interface FileBiz {

	/**
	 * upload:上传文件. <br/>
	 *
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public BaseWebResponse upload(MultipartFile file);
	
	/**
	 * getOssInputStream:获取阿里云文件流. <br/>
	 *
	 * @param objectKey
	 * @return
	 */
	public InputStream getOssInputStream(String objectKey);
}
