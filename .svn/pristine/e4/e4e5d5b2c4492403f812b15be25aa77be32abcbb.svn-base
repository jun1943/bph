package com.tianyi.bph.rest.action.basicdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.domain.basicdata.Gps;
import com.tianyi.bph.service.basicdata.GpsService;

@Controller
@RequestMapping("/gps")
public class GpsAction {
	
	@Autowired GpsService gpsService;
	
	/**
	 * 获取GPS设备信息
	 * @param request
	 * @param userId 用户Id
	 * @param organId 机构Id
	 * @return
	 */
	@RequestMapping(value = "/getGpsInfo.do")
	@ResponseBody
	public ReturnResult getGpsInfo(
			@RequestParam(value = "userId", required =false) Integer userId,
			@RequestParam(value = "isSubOrg", required =false) Integer isSubOrg,
			@RequestParam(value = "organId", required = false) Integer organId) {
		List<Gps> gpsList = gpsService.getGPSInfo(organId, isSubOrg);
		return ReturnResult.SUCCESS("GPS设备信息", gpsList);
	}

}
