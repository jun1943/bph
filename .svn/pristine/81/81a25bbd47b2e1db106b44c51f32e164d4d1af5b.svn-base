package com.tianyi.bph.web.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.query.GpsInfoQuery;
import com.tianyi.bph.service.GpsService;

/**
 * GPS历史数据 查询接口
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/GpsHistory")
public class GpsHistory {

	@Autowired
	private GpsService service;
	
	@RequestMapping(value = "/queryGps.do")
	@ResponseBody
	public ReturnResult queryGps(
			@RequestParam(value = "gpsId", required = true) String gpsId,
			@RequestParam(value = "startTime", required = false) String startTime,
			@RequestParam(value = "endTime", required = false) String endTime) {

		ReturnResult result = service.queryGpsInfo(gpsId, startTime, endTime);
		return result;
	}

	@RequestMapping(value = "/queryGps1.do")
	@ResponseBody
	public ReturnResult queryGps(
			@RequestParam(value = "gpsId", required = false) String gpsId,
			@RequestParam(value = "gpsName", required = false) String gpsName,
			@RequestParam(value = "startTime", required = false) Date startTime,
			@RequestParam(value = "endTime", required = false) Date endTime,
			@RequestParam(value = "gpsUnit", required = false) Integer gpsUnit) {

		ReturnResult result = service.findGps("", "川A3642警", null, null, 1);
		return result;
	}

	/*@RequestMapping(value = "/queryGps.do")
	@ResponseBody
	public ReturnResult queryGps(GpsInfoQuery query){
		ReturnResult result = service.findGps(query);
		return result;
	}*/
	
	@RequestMapping(value = "/test.do")
	@ResponseBody
	public ReturnResult test(GpsInfoQuery query){
		GpsInfoQuery g = new GpsInfoQuery();
		g.setGpsName("川A3642警");
		ReturnResult result = service.findGps(g);
		return result;
	}
}
