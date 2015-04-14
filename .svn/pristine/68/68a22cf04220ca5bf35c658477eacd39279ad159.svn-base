package com.tianyi.bph.rest.action.basicdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.query.basicdata.VehicleExtItem;
import com.tianyi.bph.service.basicdata.VehicleService;

@Controller
@RequestMapping("/vehicle")
public class VehicleAction {
	
	@Autowired VehicleService vehicleService;
	
	/**
	 * 获取车辆信息
	 * @param request
	 * @param userId 用户Id
	 * @param organId 机构Id
	 * @return
	 */
	@RequestMapping(value = "/getVehicleDutyInfo.do")
	@ResponseBody
	public ReturnResult getVehicleDutyInfo(
			@RequestParam(value = "userId", required =false) Integer userId,
			@RequestParam(value = "organId", required = false) Integer organId,
			@RequestParam(value = "isSubOrg", required =false) Integer isSubOrg,
			@RequestParam(value = "ymd", required =false) Integer ymd) {
		List<VehicleExtItem> vehhicleList = vehicleService.getVehicleDutyInfo(organId, ymd, isSubOrg);
		return ReturnResult.SUCCESS("车辆信息", vehhicleList);
	}

}
