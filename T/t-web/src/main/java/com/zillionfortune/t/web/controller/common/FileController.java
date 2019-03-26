/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.OSSException;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.common.FileBiz;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.exception.BusinessException;

/**
 * ClassName: FileController <br/>
 * Function: 文件上传下载处理. <br/>
 * Date: 2016年12月20日 下午6:44:51 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping("/fileservice")
public class FileController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FileBiz fileBiz;
	
	private static int BUFFER_SIZE = 8096;// 缓冲大小
	
	/**
	 * uloadQualifications:文件上传. <br/>
	 *
	 * @param memberId
	 * @param file
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public BaseWebResponse upload(MultipartFile file, String fileCode) {
		log.info("upload.req:");
		
		BaseWebResponse resp = null;
		
		try {
			if (null == file) {
				throw new BusinessException("上传文件对象 不能为空");
			}

			//2.===上传文件
			resp = fileBiz.upload(file);
			Map<String, Object> rsData =(Map<String, Object>) resp.getData();
			if (rsData != null) {
				rsData.put("fileCode", fileCode);
			}
		}catch (BusinessException e){
			log.error(e.getMessage(), e);
            resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
		}
		
		log.info("upload.resp:" + JSON.toJSONString(resp));
		return resp;
	}
	
	/**
	 * download:文件下载. <br/>
	 *
	 * @param fileId
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/download")
	public String download(String fileId, HttpServletResponse response) {
		log.info("download.req: fileId="+fileId);
		OutputStream out = null;
		InputStream inputStream = null;
		try {
			if (null == fileId) {
				return "fileId 不能为空";
			}
			fileId = new String(fileId.getBytes("iso-8859-1"),"utf-8");
			//获取文件流
			inputStream = fileBiz.getOssInputStream(fileId);
			response.setContentType("application/octet-stream;charset=UTF-8");//流的形式
			response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileId, "UTF-8"));
			out = response.getOutputStream();
			byte[] buf = new byte[BUFFER_SIZE];   
			int size = 0;  
			while ((size=inputStream.read(buf)) != -1) {
				out.write(buf, 0, size);
			}
		} catch (OSSException e) {
			log.error(e.getMessage(), e);
			return "OSS exception: " + e.getErrorMessage();
		}catch (Exception e) {
			log.error("文件下载发生错误");
			log.error(e.getMessage(), e);
			return "文件下载发生错误";
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				log.error("文件下载发生错误");
				log.error(e.getMessage(), e);
				return "文件下载发生错误";
			}
		}
		
		return null;
	}
	
	 
}
