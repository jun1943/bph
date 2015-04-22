package com.tianyi.bph.rest.action;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tianyi.bph.BaseTest;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.query.basicdata.VehicleExtItem;
import com.tianyi.bph.rest.action.basicdata.VehicleAction;
import com.tianyi.bph.service.basicdata.VehicleService;
public class VehicleActionTest extends BaseTest{
	
	@Autowired VehicleAction vehicleAction;
	@Autowired VehicleService vehicleService;
	
	@Test
	public void testGetPoliceDutyInfo(){
		
		ReturnResult result = new ReturnResult();
		result = vehicleAction.getVehicleDutyInfo(null, 1, 1, null);
		System.out.println("************code="+result.getCode());
		System.out.println("************data="+result.getData());
		List<VehicleExtItem> vehicleList = (List)result.getData();
		for(VehicleExtItem vehicleExtItem : vehicleList){
			System.out.println("************PoliceItems="+vehicleExtItem.getPoliceItems());
		}
	}

}
