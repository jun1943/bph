package com.tianyi.bph.rest.action.basicdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.query.basicdata.PoliceExtItem;
import com.tianyi.bph.service.basicdata.PoliceService;

@Controller
@RequestMapping("/police")
public class PoliceAction {
	
	@Autowired PoliceService policeService;
	
	/**
	 * 获取警员信息
	 * @param request
	 * @param userId 用户Id
	 * @param organId 机构Id
	 * @return
	 */
	@RequestMapping(value = "/getPoliceDutyInfo.do")
	@ResponseBody
	public ReturnResult getPoliceDutyInfo(
			@RequestParam(value = "userId", required =false) Integer userId,
			@RequestParam(value = "organId", required = false) Integer organId,
			@RequestParam(value = "isSubOrg", required =false) Integer isSubOrg,
			@RequestParam(value = "ymd", required =false) Integer ymd) {
		List<PoliceExtItem> policeList = policeService.getPoliceDutyInfo(organId, ymd, isSubOrg);
		return ReturnResult.SUCCESS("警员列表信息", policeList);
	}
	

}
