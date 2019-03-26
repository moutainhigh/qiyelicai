package com.zillionfortune.t.biz.trade.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.trade.TradeBiz;
import com.zillionfortune.t.common.enums.TimeIntervalEnum;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryRequest;

/**
 * ClassName: TradeBizImplTest <br/>
 * Function: 交易服务接口单元测试. <br/>
 * Date: 2016年12月21日 下午5:36:37 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-basic.xml")
@ActiveProfiles("dev")
public class TradeBizImplTest {
	
	@Autowired
	TradeBiz tradeBiz;
	
	
	/**
	 * 对账管理查询. <br/>
	 */
	@Test
	public void reconListQuery(){
		ReconQueryRequest req = new ReconQueryRequest();
		req.setMemberId("EM201612301356053651554320");//EM201612301356053651554320
		req.setTimeInterval(TimeIntervalEnum.CURRENT_DAY.code());//1：当天；2：最近一周；3：最近一个月；4：最近三个月；5：最近半年；6：最近一年
		BaseWebResponse base = null;
		try {
			base = tradeBiz.reconListByPage(req);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(JsonUtils.object2Json(base));
	}

}
