package com.tianyi.bph.web.controller.basicdata;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.PageReturn;
import com.tianyi.bph.common.ReturnResult; 
import com.tianyi.bph.domain.basicdata.Weapon;
import com.tianyi.bph.domain.basicdata.WeaponType;
import com.tianyi.bph.domain.system.Organ; 
import com.tianyi.bph.query.basicdata.WeaponVM;
import com.tianyi.bph.query.system.UserQuery;
import com.tianyi.bph.service.basicdata.WeaponService;
import com.tianyi.bph.service.system.OrganService;
 

/*
 * 
 * 武器管理逻辑控制器；
 */

@Controller
@RequestMapping("/weaponWeb")
public class WeaponController {


	@Autowired WeaponService weaponService;

	@Autowired OrganService organService;
	
	/**
	 * web跳转到警员列表
	 * 
	 * @param request
	 * @param username
	 *            用户名
	 * @return
	 */
	@RequestMapping({ "/gotoWeaponList.do", "/gotoWeaponList.action" })
	@ResponseBody
	public ModelAndView gotoWeaponList(
			HttpServletRequest request,
			@RequestParam(value = "weaponNumber", required = false) String number,
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId,
			@RequestParam(value = "searchType", required = true, defaultValue = "1") Integer searchType,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo) {
		UserQuery query = new UserQuery();
		if (!StringUtils.isEmpty(number)) {
			query.setUserName(number);
		}
		query.setOrganId(organId);
		query.setPageNo(pageNo);
		query.setPageSize(pageSize);
		ModelAndView mv = new ModelAndView("/basicdata/weapon/weaponList.jsp");
		Organ organ = new Organ();
		if (organId != null) {
			organ = organService.getOrganByPrimaryKey(organId);
		}
		query.setOrganId(organId);
		mv.addObject("query", query);
		mv.addObject("organ", organ);
		mv.addObject("num","200");
		return mv;
	}

	@RequestMapping({ "gotoWeaponAdd.do", "/gotoWeaponAdd.action" })
	@ResponseBody
	public ModelAndView gotoWeaponAdd(
			@RequestParam(value = "organId", required = false) Integer organId,
			HttpServletRequest request) throws Exception {
		try {
			Organ organ = new Organ();

			if (organId != null) {
				organ = organService.getOrganByPrimaryKey(organId);
			}
			ModelAndView mv = new ModelAndView(
					"/basicdata/weapon/weaponAdd.jsp");

			mv.addObject("organId", organId);
			mv.addObject("organ", organ);

			return mv;
		} catch (Exception ex) {
			return new ModelAndView("/basicdata/weapon/weaponList.jsp");
		}
	}

	@RequestMapping({ "gotoWeaponEdit.do", "/gotoWeaponEdit.action" })
	@ResponseBody
	public ModelAndView gotoWeaponEdit(
			@RequestParam(value = "organId", required = false) Integer organId,
			@RequestParam(value = "weaponId", required = false) Integer weaponId,
			HttpServletRequest request) throws Exception {
		try {
			Organ organ = new Organ();
			Weapon weapon = new Weapon();
			if (weaponId != null) {
				weapon = weaponService.selectByPrimaryKey(weaponId);
			}
			if (organId != null) {
				organ = organService.getOrganByPrimaryKey(organId);
			}
			ModelAndView mv = new ModelAndView(
					"/basicdata/weapon/weaponEdit.jsp");
			mv.addObject("weapon", weapon);
			mv.addObject("organId", organId);
			mv.addObject("organ", organ);

			return mv;
		} catch (Exception ex) {
			return new ModelAndView("/basicdata/weapon/weaponList.jsp");
		}
	}

	@RequestMapping({ "gotoWeaponImport.do", "/gotoWeaponImport.action" })
	@ResponseBody
	public ModelAndView gotoWeaponImport(
			@RequestParam(value = "organId", required = false) Integer organId,
			HttpServletRequest request) throws Exception {
		try {
			Organ organ = new Organ();

			if (organId != null) {
				organ = organService.getOrganByPrimaryKey(organId);
			}
			ModelAndView mv = new ModelAndView(
					"/basicdata/weapon/weaponExport.jsp");

			mv.addObject("organId", organId);
			mv.addObject("organ", organ);

			return mv;
		} catch (Exception ex) {
			return new ModelAndView("/basicdata/weapon/weaponExport.jsp");
		}
	}

	/*
	 * 获取警员列表信息
	 * 
	 * police_Query：查询条件包 sort：排序列 order：排序方式 page：当前页 rows：每页条数
	 */
	@RequestMapping(value = "/getWeaponList.do")
	@ResponseBody
	public PageReturn getWeaponList(
			@RequestParam(value = "weapon_Query", required = false) String weapon_Query,
			HttpServletRequest request) throws Exception {
		try {
			JSONObject joQuery = JSONObject.fromObject(weapon_Query);
			int orgId = Integer.parseInt(joQuery.getString("orgId"));
			int isSubOrg = Integer.parseInt(joQuery.getString("isSubOrg"));
			String number = joQuery.getString("number");
			String orgPath = joQuery.getString("orgPath");
			int pageStart = Integer.parseInt(joQuery.getString("pageStart"));
			int pageSize = Integer.parseInt(joQuery.getString("pageSize"));
			Map<String, Object> map = new HashMap<String, Object>();

			int pageBegin = pageSize * (pageStart > 0 ? (pageStart - 1) : 0);
			//int pageEnd = pageSize + pageBegin;
			map.put("isSubOrg", isSubOrg);
			map.put("number", number); 
			map.put("orgId", orgId);
			map.put("orgPath", orgPath);
			map.put("pageStart", pageBegin);
			map.put("pageSize", pageSize);

			List<WeaponVM> list = new ArrayList<WeaponVM>();

			int total = weaponService.loadVMCount(map);

			list = weaponService.loadVMList(map);

			if(list.size()==0){
				if(pageStart>1){
					pageBegin = pageSize * ((pageStart-1) > 0 ? (pageStart - 2) : 0);
					map.put("pageStart", pageBegin);
					list = weaponService.loadVMList(map);
				}
			}
			return PageReturn.MESSAGE(MessageCode.STATUS_SUCESS,
					MessageCode.SELECT_SUCCESS, total, list);
		} catch (Exception ex) {
			return PageReturn.MESSAGE(MessageCode.STATUS_FAIL,
					MessageCode.SELECT_ORGAN_FAIL, 0, null);
		}
	}

	/*
	 * 
	 * 获取车辆类型列表，以下拉框的形式展现；
	 */
	@RequestMapping(value = "getWeaponType.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getWeaponType() throws Exception {
		try {
			List<WeaponType> list = weaponService.selectWeaponType();
			JSONArray result = JSONArray.fromObject(list);
			return result.toString();
		} catch (Exception ex) {
			return "";
		}
	}
 
	/*
	 * 保存警员信息逻辑
	 */
	@RequestMapping(value = "saveWeapon.do")
	@ResponseBody
	public ReturnResult saveWeapon(Weapon weapon) throws Exception {
		try {
			weapon.setPlatformId(1);
			weapon.setSyncState(true);
			if (weapon.getId() > 0) {
				int vid = weapon.getId();

				weapon.setId(vid);
				weaponService.updateByPrimaryKey(weapon);
			} else {
				weaponService.insert(weapon);

			}
			return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,
					MessageCode.SELECT_SUCCESS, 0, null);
		} catch (Exception ex) {
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,
					MessageCode.SELECT_ORGAN_FAIL, 0, null);
		}
	}

	/*
	 * 保存警员信息逻辑
	 */
	@RequestMapping(value = "deleteWeaponById.do")
	@ResponseBody
	public ReturnResult deleteWeaponById(
			@RequestParam(value = "weaponId", required = true) String weaponId)
			throws Exception {
		try {

			List<Weapon> list = weaponService.findByIdAndDtyId(weaponId);
			if (list.size() > 0) {
				return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,
						"该武器存在关联报备数据，不能删除", 0, null);
			} else {
				weaponService.deleteByPrimaryKey(Integer.parseInt(weaponId));

				return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,
						MessageCode.SELECT_SUCCESS, 0, null);
			}
		} catch (Exception ex) {
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL, "删除武器数据出错", 0,
					null);
		}
	}

	/**
	 * 判断是否有有车辆存在
	 * 
	 * 判断是否车牌号码重复；
	 */
	@RequestMapping(value = "isExistWeapon.do")
	@ResponseBody
	public ReturnResult isExistWeapon(
			@RequestParam(value = "param", required = false) String param,
			@RequestParam(value = "type", required = false) Integer type,
			@RequestParam(value = "id", required = false) Integer id)
			throws Exception {
		try {
			List<WeaponVM> weapon = new ArrayList<WeaponVM>();
			if(type>0){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("number",param);
				map.put("id", id);
				weapon = weaponService.findByNumberAndId(map);
			}else{
				weapon = weaponService.findByNumber(param);
			}
			if (weapon.size() > 0) {
				return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL, weapon.get(0).getOrgName(),
						0, null);
			} else {
				return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS, "UnExits",
						0, null);
			}

		} catch (Exception ex) {
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL, " ", 0,
					null);
		}
	}
}
