package com.tianyi.bph.rest.action.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.domain.system.GBDevice;
import com.tianyi.bph.domain.system.OrganGBOrganBean;
import com.tianyi.bph.domain.system.OrganGBOrganKey;
import com.tianyi.bph.service.system.GBPlatFormService;

/**
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/client/GBPlatForm")
public class GBPlatFormAction {

	@Resource
	private GBPlatFormService platFormService;

	/**
	 * 获取机构授权的国标设备
	 * 
	 * @param organId
	 * @return
	 */
	@RequestMapping(value = "/getGBDeviceListByOrganId.do")
	@ResponseBody
	public ReturnResult getGBDeviceListByOrganId(
			@RequestParam(value = "organId", required = false) Integer organId) {
		try {
			List<GBDevice> list = null;
			if (organId != null) {
				list = platFormService.getGBDeviceListByOrganId(organId);
			} else {
				list = platFormService.queryAllGbDevice();
			}
			return ReturnResult.SUCCESS(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnResult.FAILUER(e.getMessage());
		}
	}

	/**
	 * 获取机构授权的国标设备
	 * 
	 * @param organId
	 * @return
	 */
	@RequestMapping(value = "/getOrganRelationGBOrgan.do")
	@ResponseBody
	public ReturnResult getOrganRelationGBOrgan(
			@RequestParam(value = "organId", required = true) Integer organId) {
		try {
			Map<Integer, List<Integer>> map = null;
			List<OrganGBOrganKey> list = null;
			if (organId != null) {
				list = platFormService.queryOrganGBOrganKey(organId);
				map = new HashMap<Integer, List<Integer>>(list.size());
				for (OrganGBOrganKey key : list) {
					if (map.get(key.getOrganId()) == null) {
						List<Integer> ids = new ArrayList<Integer>();
						ids.add(key.getGbOrganId());
						map.put(key.getOrganId(), ids);
					} else {
						map.get(key.getOrganId()).add(key.getGbOrganId());
					}
				}
			}
			List<OrganGBOrganBean> result = null;
			if (!map.isEmpty()) {
				result = new ArrayList<OrganGBOrganBean>(map.size());
				for (Integer id : map.keySet()) {
					OrganGBOrganBean bean = new OrganGBOrganBean();
					bean.setOrganId(id);
					bean.setGbOrganIds(map.get(id));
					result.add(bean);
				}
			}
			return ReturnResult.SUCCESS(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnResult.FAILUER(e.getMessage());
		}
	}
}
