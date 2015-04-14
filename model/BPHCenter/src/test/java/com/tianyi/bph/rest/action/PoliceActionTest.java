package com.tianyi.bph.rest.action;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tianyi.bph.BaseTest;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.query.basicdata.PoliceInfo;
import com.tianyi.bph.rest.action.basicdata.PoliceAction;
import com.tianyi.bph.service.basicdata.PoliceService;

public class PoliceActionTest extends BaseTest {
	
	@Autowired PoliceAction policeAction;
	@Autowired PoliceService policeService;
	
	@Test
	public void testGetPoliceDutyInfo(){
		
		ReturnResult result = new ReturnResult();
		result = policeAction.getPoliceDutyInfo(null, 15, 0, 0);
		System.out.println("************code="+result.getCode());
		List<PoliceInfo> policeList = (List)result.getData();
		for(PoliceInfo police : policeList){
			System.out.println("************policeName="+police.getData().getName());
		}
	}

}
