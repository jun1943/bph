package com.tianyi.bph.rest.action.system;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.domain.system.OrganType;
import com.tianyi.bph.service.system.OrganTypeService;
import com.tianyi.bph.common.ReturnResult;

@Controller
@RequestMapping("/organType")
public class OrganTypeAction {

	static final Logger log = LoggerFactory.getLogger(OrganTypeAction.class);

	@Autowired OrganTypeService organTypeService;

	/**
	 * 添加机构类型
	 * @param organ @
	 * @
	 * @return
	 */
	@RequestMapping(value = "/addOrganType.do")
	@ResponseBody
	public ReturnResult addOrganType(
			@RequestParam(value = "organType", required =true) OrganType organType) {
		
		organTypeService.addOrganType(organType);

		return ReturnResult.SUCCESS("成功");
	}
	
	/**
	 * 删除机构类型
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteOrganType.do")
	@ResponseBody
	public ReturnResult deleteOrganType(
			@RequestParam(value = "code", required =true) String code) {
		
		organTypeService.deleteOrganType(code);

		return ReturnResult.SUCCESS();
	}
	
	/**
	 * 修改机构类型
	 * @param organ
	 * @return
	 */
	@RequestMapping(value = "/modifyOrganType.do")
	@ResponseBody
	public ReturnResult modifyOrganType(
			@RequestParam(value = "organType", required =true) OrganType organType) {
		
		organTypeService.updateOrganType(organType);

		return ReturnResult.SUCCESS();
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryOrganTypeDetail.do")
	@ResponseBody
	public ReturnResult queryOrganTypeDetail(
			@RequestParam(value = "code", required =true) String code) {
		
		OrganType organType = organTypeService.getOrganTypeById(code);
		return ReturnResult.SUCCESS(organType);
	}
	
	/**
	 * 根据条件查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryOrganTypeList.do")
	@ResponseBody
	public ReturnResult queryOrganTypeList() {
		
		List<OrganType> organTypes = organTypeService.getQueryList();
		return ReturnResult.SUCCESS(organTypes);
	}

}
