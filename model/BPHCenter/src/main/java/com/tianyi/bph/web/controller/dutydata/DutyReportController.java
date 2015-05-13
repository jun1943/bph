package com.tianyi.bph.web.controller.dutydata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.PageReturn;
import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.query.duty.DutyReportCriteria;
import com.tianyi.bph.query.duty.DutyReportVM;
import com.tianyi.bph.service.duty.DutyReportService;
import com.tianyi.bph.service.duty.DutyService;
import com.tianyi.bph.service.system.OrganService;


@Controller
@RequestMapping("/dutyReportWeb")
public class DutyReportController {

	
	@Autowired
	private DutyReportService dutyReportService;
	
	@Autowired
	private OrganService organService;
	
	
	
	
	
	@RequestMapping({ "/gotoDutyReport.do", "/gotoDutyReport.action" })
	@ResponseBody
	public ModelAndView gotoDutyReport(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId
			){
		
		ModelAndView mv = new ModelAndView("/dutydata/dutyreport/dutyReport.jsp");
		
		Organ organ = new Organ();
		if (organId != null) {
			organ = organService.getOrganByPrimaryKey(organId);
		}
		
		mv.addObject("num","300");
		mv.addObject("organ", organ);
		return mv;
	}
	
	@RequestMapping(value = "/loadDutyReport.do")
	@ResponseBody
	public 	PageReturn loadDutyReport(
			@RequestParam(value = "criteria", required = false) String criteriaJson,
			HttpServletRequest request) {
		try {
			JSONObject jobj = JSONObject.fromObject(criteriaJson);

			JSONUtils.getMorpherRegistry().registerMorpher(
					new DateMorpher(new String[] { "yyyy-MM-dd HH:mm" }));

			Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();

			classMap.put("orgIds", Integer.class);
			classMap.put("taskPropertyIds", Integer.class);
			classMap.put("attireTypeIds", Integer.class);
			classMap.put("policeTypeIds", Integer.class);
			classMap.put("armamentTypeIds", Integer.class);
			classMap.put("dutyTypeIds", Integer.class);

			DutyReportCriteria drc = (DutyReportCriteria) JSONObject.toBean(
					jobj, DutyReportCriteria.class, classMap);

			List<DutyReportVM> ls = dutyReportService.loadDutyReport(drc);

			return PageReturn.MESSAGE(MessageCode.STATUS_SUCESS,
					MessageCode.SELECT_SUCCESS, ls.size(), ls);
			
		} catch (Exception ex) {
			return PageReturn.MESSAGE(MessageCode.STATUS_FAIL,
					MessageCode.SELECT_ORGAN_FAIL, 0, null);
		}
	}
}
