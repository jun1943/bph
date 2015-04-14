package com.tianyi.bph.rest.action.basicdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.query.basicdata.WeaponItemVM;
import com.tianyi.bph.service.basicdata.WeaponService;


@Controller
@RequestMapping("/weapon")
public class WeaponAction {
	
	@Autowired WeaponService weaponService;
	
	/**
	 * 获取武器信息
	 * @param request
	 * @param userId 用户Id
	 * @param organId 机构Id
	 * @return
	 */
	@RequestMapping(value = "/getWeaponInfo.do")
	@ResponseBody
	public ReturnResult getWeaponInfo(
			@RequestParam(value = "userId", required =false) Integer userId,
			@RequestParam(value = "isSubOrg", required =false) Integer isSubOrg,
			@RequestParam(value = "organId", required = false) Integer organId) {
		List<WeaponItemVM> weaponList = weaponService.getWeaponInfo(organId, isSubOrg);
		return ReturnResult.SUCCESS("武器信息", weaponList);
	}

}
