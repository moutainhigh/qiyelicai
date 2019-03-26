package com.zillionfortune.t.biz.account.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.account.AssetBiz;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.integeration.account.dto.AssetQueryRequest;

/**
 * ClassName: AssetBizImplTest <br/>
 * Function: 企业资产服务接口单元测试. <br/>
 * Date: 2016年12月21日 下午5:36:37 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-basic.xml")
@ActiveProfiles("dev")
public class AssetBizImplTest {
	
	@Autowired
	AssetBiz AssetBiz;
	
	
	/**
	 * 企业资产查询. <br/>
	 *
	 */
	@Test
	public void assetsQuery(){
		AssetQueryRequest req = new AssetQueryRequest();
		req.setMemberId("EM201612221551183627645252");
		BaseWebResponse base = AssetBiz.assetsQuery(req);
		System.out.println(JsonUtils.object2Json(base));
	}

}
