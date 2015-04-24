package com.tianyi.bph.web.controller.dutydata;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.query.system.UserQuery;
import com.tianyi.bph.service.system.OrganService;

@Controller
@RequestMapping("/dutyRouteWeb")
public class DutyRouteController {



	@Autowired
	private OrganService organService;
	/**
	 * web跳转到勤务类型列表
	 * 
	 * @param request
	 * @param
	 * 
	 * @return
	 */
	@RequestMapping({ "/gotoDutyCalendar.do", "/gotoDutyCalendar.action" })
	@ResponseBody
	public ModelAndView gotoDutyTypeList(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutyprepare/dutyCalendar.jsp");
		Organ organ = new Organ();
		if (organId != null) {
			organ = organService.getOrganByPrimaryKey(organId);
		}

		Calendar c = Calendar.getInstance();
		int years = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		query.setOrganId(organId);
		query.setPageNo(years);
		query.setPageSize(month);
		mv.addObject("organ", organ);
		mv.addObject("query", query);
		mv.addObject("num", "200");
		return mv;
	}

	/**
	 * web跳转到勤务类型列表
	 * 
	 * @param request
	 * @param
	 * 
	 * @return
	 */
	@RequestMapping({ "/gotoDutyItem.do", "/gotoDutyItem.action" })
	@ResponseBody
	public ModelAndView gotoDutyItem(
			@RequestParam(value = "organId", required = true) Integer organId,
			@RequestParam(value = "ymd", required = true) Integer ymd,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutyprepare/dutyPrepare.jsp");
		Organ organ = new Organ();
		if (organId != null) {
			organ = organService.getOrganByPrimaryKey(organId);
		}

		Calendar c = Calendar.getInstance();
		int years = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		query.setOrganId(organId);
		query.setPageNo(years);
		query.setPageSize(month);
		mv.addObject("organ", organ);
		mv.addObject("query", query);
		mv.addObject("num", "200");
		return mv;
	}

}
