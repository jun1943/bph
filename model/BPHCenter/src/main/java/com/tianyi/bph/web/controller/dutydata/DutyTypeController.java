package com.tianyi.bph.web.controller.dutydata;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianyi.bph.common.MessageCode; 
import com.tianyi.bph.common.ReturnResult; 
import com.tianyi.bph.query.duty.DutyTypePropertyVM;
import com.tianyi.bph.query.duty.DutyTypeVM; 
import com.tianyi.bph.service.duty.DutyTypeService;
import com.tianyi.bph.web.controller.ListResult;

/*
 * 警员管理逻辑控制器
 * 
 */

@Controller
@RequestMapping("/dutyTypeWeb")
public class DutyTypeController {
	
	@Autowired DutyTypeService dutyTypeService;// =


	/**
	 * web跳转到勤务类型列表
	 * 
	 * @param request
	 * @param 
	 *           
	 * @return
	 */
	@RequestMapping({ "/gotoDutyTypeList.do", "/gotoDutyTypeList.action" })
	@ResponseBody
	public ModelAndView gotoDutyTypeList(
			HttpServletRequest request) {
		  
		ModelAndView mv = new ModelAndView("/dutydata/dutytype/dutyTypeList.jsp"); 
		mv.addObject("num","200");
		return mv;
	}

	@RequestMapping({ "gotoDutyTypeAdd.do", "/gotoDutyTypeAdd.action" })
	@ResponseBody
	public ModelAndView gotoPoliceAdd(
			@RequestParam(value = "organId", required = false) Integer organId,
			HttpServletRequest request) throws Exception {
		try { 
			ModelAndView mv = new ModelAndView(
					"/dutydata/dutytype/dutyTypeAdd.jsp"); 
			return mv;
		} catch (Exception ex) {
			return new ModelAndView("/dutydata/dutytype/dutyTypeAdd.jsp");
		}
	}
  
	@RequestMapping({ "gotoDutyTypeEdit.do", "/gotoDutyTypeEdit.action" })
	@ResponseBody
	public ModelAndView gotoPoliceEdit( 
			HttpServletRequest request) throws Exception {
		try {
			ModelAndView mv = new ModelAndView(
					"/dutydata/dutytype/dutyTypeEdit.jsp"); 
			return mv;
		} catch (Exception ex) {
			return new ModelAndView("/dutydata/dutytype/dutyTypeEdit.jsp");
		}
	}

	/**
	 * 获取勤务类型列表，非模板，并且是启用状态的模板
	 * 
	 * @param isUsed
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getDutyTypelist.do")
	@ResponseBody
	public ReturnResult getDutyTypelist(
			@RequestParam(value = "isUsed", required = false) Boolean isUsed,
			HttpServletRequest request) throws Exception {
		try {
			List<DutyTypeVM> list = dutyTypeService.loadDutyTypeVM(isUsed);
			return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,
					MessageCode.SELECT_SUCCESS, 0, list);
		} catch (Exception ex) {
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,
					MessageCode.SELECT_SUCCESS, 0, null);
		}
	}
	

	@RequestMapping(value = "loadProperties.do")
	public @ResponseBody
	String loadProperties(HttpServletRequest request) {

		List<DutyTypePropertyVM> ls = dutyTypeService.loadProperties();

		ListResult<DutyTypePropertyVM> rs = new ListResult<DutyTypePropertyVM>(
				ls.size(), ls);

		String result = rs.toJson();
		return result;
	}

}
