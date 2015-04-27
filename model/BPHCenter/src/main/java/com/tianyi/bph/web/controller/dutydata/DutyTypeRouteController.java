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
@RequestMapping("/dutyTypeRouteWeb")
public class DutyTypeRouteController {


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
	@RequestMapping({ "/gotoPoliceGroup.do", "/gotoPoliceGroup.action" })
	@ResponseBody
	public ModelAndView gotoPoliceGroup(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/policegroup/policegroupList.jsp");
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
	
	@RequestMapping({ "/gotoPoliceGroupAdd.do", "/gotoPoliceGroupAdd.action" })
	@ResponseBody
	public ModelAndView gotoPoliceGroupAdd(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/policegroup/policegroupAddGroup.jsp");
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

	
	@RequestMapping({ "/gotoPoliceGroupEdit.do", "/gotoPoliceGroupEdit.action" })
	@ResponseBody
	public ModelAndView gotoPoliceGroupEdit(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			@RequestParam(value = "groupId", required = true, defaultValue = "1") Integer groupId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/policegroup/policegroupEditGroup.jsp");
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
	

	@RequestMapping({ "/gotoPoliceGroupAddMember.do", "/gotoPoliceGroupAddMember.action" })
	@ResponseBody
	public ModelAndView gotoPoliceGroupAddMember(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			@RequestParam(value = "groupId", required = true, defaultValue = "1") Integer groupId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/policegroup/policegroupAddMember.jsp");
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
	@RequestMapping({ "/gotoVehicleGroup.do", "/gotoVehicleGroup.action" })
	@ResponseBody
	public ModelAndView gotoVehicleGroup(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/vehiclegroup/vehclegroupList.jsp");
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
	

	@RequestMapping({ "/gotoVehicleGroupAdd.do", "/gotoVehicleGroupAdd.action" })
	@ResponseBody
	public ModelAndView gotoVehicleGroupAdd(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/policegroup/policegroupAddGroup.jsp");
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

	
	@RequestMapping({ "/gotoVehicleGroupEdit.do", "/gotoVehicleGroupEdit.action" })
	@ResponseBody
	public ModelAndView gotoVehicleGroupEdit(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			@RequestParam(value = "groupId", required = true, defaultValue = "1") Integer groupId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/vehiclegroup/vehiclegroupEditGroup.jsp");
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
	

	@RequestMapping({ "/gotoVehicleGroupAddMember.do", "/gotoVehicleGroupAddMember.action" })
	@ResponseBody
	public ModelAndView gotoVehicleGroupAddMember(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			@RequestParam(value = "groupId", required = true, defaultValue = "1") Integer groupId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/vehiclegroup/vehiclegroupAddMember.jsp");
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
	@RequestMapping({ "/gotoWeaponGroup.do", "/gotoWeaponGroup.action" })
	@ResponseBody
	public ModelAndView gotoWeaponGroup(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/weapongroup/weapongroupList.jsp");
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
	

	@RequestMapping({ "/gotoWeaponGroupAdd.do", "/gotoWeaponGroupAdd.action" })
	@ResponseBody
	public ModelAndView gotoWeaponGroupAdd(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/weapongroup/weapongroupAddGroup.jsp");
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

	
	@RequestMapping({ "/gotoWeaponGroupEdit.do", "/gotoWeaponGroupEdit.action" })
	@ResponseBody
	public ModelAndView gotoWeaponGroupEdit(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			@RequestParam(value = "groupId", required = true, defaultValue = "1") Integer groupId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/weapongroup/weapongroupEditGroup.jsp");
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
	

	@RequestMapping({ "/gotoWeaponGroupAddMember.do", "/gotoWeaponGroupAddMember.action" })
	@ResponseBody
	public ModelAndView gotoWeaponGroupAddMember(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			@RequestParam(value = "groupId", required = true, defaultValue = "1") Integer groupId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/weapongroup/weapongroupAddMember.jsp");
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
	@RequestMapping({ "/gotoGpsGroup.do", "/gotoGpsGroup.action" })
	@ResponseBody
	public ModelAndView gotoGpsGroup(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/gpsgroup/gpsgroupList.jsp");
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
	

	@RequestMapping({ "/gotoGpsGroupAdd.do", "/gotoGpsGroupAdd.action" })
	@ResponseBody
	public ModelAndView gotoGpsGroupAdd(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/gpsgroup/gpsgroupAddGroup.jsp");
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

	
	@RequestMapping({ "/gotoGpsGroupEdit.do", "/gotoGpsGroupEdit.action" })
	@ResponseBody
	public ModelAndView gotoGpsGroupEdit(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			@RequestParam(value = "groupId", required = true, defaultValue = "1") Integer groupId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/gpsgroup/gpsgroupEditGroup.jsp");
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
	

	@RequestMapping({ "/gotoGpsGroupAddMember.do", "/gotoGpsGroupAddMember.action" })
	@ResponseBody
	public ModelAndView gotoGpsGroupAddMember(
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			@RequestParam(value = "groupId", required = true, defaultValue = "1") Integer groupId,
			HttpServletRequest request) {
		UserQuery query = new UserQuery();
		ModelAndView mv = new ModelAndView(
				"/dutydata/dutygroup/gpsgroup/gpsgroupAddMember.jsp");
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
