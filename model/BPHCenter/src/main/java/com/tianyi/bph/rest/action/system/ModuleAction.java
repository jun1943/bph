package com.tianyi.bph.rest.action.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.domain.system.Module;
import com.tianyi.bph.query.system.ModuleQuery;
import com.tianyi.bph.service.system.ModuleService;
import com.tianyi.bph.common.ReturnResult;

@Controller
@RequestMapping("/module")
public class ModuleAction {

	static final Logger log = LoggerFactory.getLogger(ModuleAction.class);

	@Autowired ModuleService moduleService;

	/**
	 * @param request
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/getModulesByUserId.do")
	@ResponseBody
	public ReturnResult getModulesByUserId(
			@RequestParam(value = "userId", required =true) Integer userId) {
		
		List<Module> modules = moduleService.getModulesByUserId(userId);
		return ReturnResult.SUCCESS(modules);
	}

	/**
	 * 条件查询
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/queryModuleList.do")
	@ResponseBody
	public ReturnResult queryModuleList(ModuleQuery query) {
		
		List<Module> modules = moduleService.getQueryList(query);
		return ReturnResult.SUCCESS(modules);
	}

}
