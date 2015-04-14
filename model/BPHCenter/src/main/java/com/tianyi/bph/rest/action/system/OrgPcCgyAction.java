package com.tianyi.bph.rest.action.system;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.domain.system.OrgPcCgy;
import com.tianyi.bph.service.system.OrgPcCgyService;
import com.tianyi.bph.common.ReturnResult;

@Controller
@RequestMapping("/orgPcCgy")
public class OrgPcCgyAction {

	static final Logger log = LoggerFactory.getLogger(OrgPcCgyAction.class);

	@Autowired OrgPcCgyService orgPcCgyService;
	
	/**
	 * 根据条件查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryOrgPcCgyList.do")
	@ResponseBody
	public ReturnResult queryOrgPcCgyList() {
		
		List<OrgPcCgy> orgPcCgys = orgPcCgyService.getQueryList();
		return ReturnResult.SUCCESS(orgPcCgys);
	}

}
