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
import com.tianyi.bph.domain.basicdata.Gps;
import com.tianyi.bph.domain.basicdata.GpsType;
import com.tianyi.bph.domain.basicdata.Icons;
import com.tianyi.bph.domain.basicdata.Weapon;
import com.tianyi.bph.domain.basicdata.WeaponType;
import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.domain.system.User;
import com.tianyi.bph.query.basicdata.GpsVM;
import com.tianyi.bph.query.basicdata.WeaponVM;
import com.tianyi.bph.query.system.UserQuery;
import com.tianyi.bph.service.basicdata.GpsService;
import com.tianyi.bph.service.system.OrganService;

/*
 * 定位设备控制器，mark by liqinag
 */

@Controller
@RequestMapping("/gpsWeb")
public class GpsController {

	@Autowired GpsService gpsService;

	@Autowired OrganService organService;

	/**
	 * web跳转到警员列表
	 * 
	 * @param request
	 * @param username
	 *            用户名
	 * @return
	 */
	@RequestMapping({ "/gotoGpsList.do", "/gotoGpsList.action" })
	@ResponseBody
	public ModelAndView gotoGpsList(
			HttpServletRequest request,
			@RequestParam(value = "gpsNumber", required = false) String number,
			@RequestParam(value = "organId", required = false) Integer organId,
			@RequestParam(value = "searchType", required = true, defaultValue = "1") Integer searchType,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo) {
		UserQuery query = new UserQuery();
		User user = (User) request.getAttribute("User");
		if (organId == null) {
			organId = user.getOrgId();
		}
		if (!StringUtils.isEmpty(number)) {
			query.setUserName(number);
		}
		query.setOrganId(organId);
		query.setPageNo(pageNo);
		query.setPageSize(pageSize);
		ModelAndView mv = new ModelAndView("/basicdata/gps/gpsList.jsp");
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

	@RequestMapping({ "gotoGpsAdd.do", "/gotoGpsAdd.action" })
	@ResponseBody
	public ModelAndView gotoGpsAdd(
			@RequestParam(value = "organId", required = false) Integer organId,
			HttpServletRequest request) throws Exception {
		try {
			Organ organ = new Organ();

			if (organId != null) {
				organ = organService.getOrganByPrimaryKey(organId);
			}
			ModelAndView mv = new ModelAndView("/basicdata/gps/gpsAdd.jsp");

			mv.addObject("organId", organId);
			mv.addObject("organ", organ);

			return mv;
		} catch (Exception ex) {
			return new ModelAndView("/basicdata/gps/gpsList.jsp");
		}
	}

	@RequestMapping({ "gotoGpsEdit.do", "/gotoGpsEdit.action" })
	@ResponseBody
	public ModelAndView gotoGpsEdit(
			@RequestParam(value = "organId", required = false) Integer organId,
			@RequestParam(value = "gpsId", required = false) Integer gpsId,
			HttpServletRequest request) throws Exception {
		try {
			Organ organ = new Organ();
			Gps gps = new Gps();
			if (gpsId != null) {
				gps = gpsService.selectByPrimaryKey(gpsId);
			}
			if (organId != null) {
				organ = organService.getOrganByPrimaryKey(organId);
			}
			ModelAndView mv = new ModelAndView("/basicdata/gps/gpsEdit.jsp");

			mv.addObject("gps", gps);
			mv.addObject("organId", organId);
			mv.addObject("organ", organ);

			return mv;
		} catch (Exception ex) {
			return new ModelAndView("/basicdata/gps/gpsList.jsp");
		}
	}

	@RequestMapping({ "gotoGpsImport.do", "/gotoGpsImport.action" })
	@ResponseBody
	public ModelAndView gotoGpsImport(
			@RequestParam(value = "organId", required = false) Integer organId,
			HttpServletRequest request) throws Exception {
		try {
			Organ organ = new Organ();

			if (organId != null) {
				organ = organService.getOrganByPrimaryKey(organId);
			}
			ModelAndView mv = new ModelAndView(
					"/basicdata/gps/gpsExport.jsp");

			mv.addObject("organId", organId);
			mv.addObject("organ", organ);

			return mv;
		} catch (Exception ex) {
			return new ModelAndView("/basicdata/gps/gpsExport.jsp");
		}
	}

	/*
	 * 获取警员列表信息
	 * 
	 * police_Query：查询条件包 sort：排序列 order：排序方式 page：当前页 rows：每页条数
	 */
	@RequestMapping(value = "/getGpsList.do")
	@ResponseBody
	public PageReturn getGpsList(
			@RequestParam(value = "gps_Query", required = false) String gps_Query,
			HttpServletRequest request) throws Exception {
		try {
			JSONObject joQuery = JSONObject.fromObject(gps_Query);
			int orgId = Integer.parseInt(joQuery.getString("orgId"));
			int isSubOrg = Integer.parseInt(joQuery.getString("isSubOrg"));
			String name = joQuery.getString("name");
			String number = joQuery.getString("number");
			String orgPath = joQuery.getString("orgPath");
			int pageStart = Integer.parseInt(joQuery.getString("pageStart"));
			int pageSize = Integer.parseInt(joQuery.getString("pageSize"));
			Map<String, Object> map = new HashMap<String, Object>();

			int pageBegin = pageSize * (pageStart > 0 ? (pageStart - 1) : 0);
			//int pageEnd = pageSize + pageBegin;
			map.put("isSubOrg", isSubOrg);
			map.put("number", number);
			map.put("name", name);
			map.put("orgId", orgId);
			map.put("orgPath", orgPath);
			map.put("pageStart", pageBegin);
			map.put("pageSize", pageSize);

			List<GpsVM> list = new ArrayList<GpsVM>();

			int total = gpsService.loadVMCount(map);

			list = gpsService.loadVMList(map);

			if(list.size()==0){
				if(pageStart>1){
					pageBegin = pageSize * ((pageStart-1) > 0 ? (pageStart - 2) : 0);
					map.put("pageStart", pageBegin);
					list = gpsService.loadVMList(map);
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
	@RequestMapping(value = "getGpsType.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getGpsType() throws Exception {
		try {
			List<GpsType> list = gpsService.selectGpsType();
			JSONArray result = JSONArray.fromObject(list);
			return result.toString();
		} catch (Exception ex) {
			return "";
		}
	}

	/*
	 * 
	 * 获取车辆类型列表，以下拉框的形式展现；
	 */
	@RequestMapping(value = "getIconsList.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	private String getIconsList() throws Exception {
		List<Icons> list = new ArrayList<Icons>();
		try {
			list = gpsService.selectIconsList();
			if (list.size() > 0) {
				for (Icons ico : list) {
					int typeId = ico.getTypeId();
					String Iname = "";
					switch (typeId) {
					case 1:
						Iname = "警员图标：" + ico.getName();
						ico.setName(Iname);
						break;
					case 2:
						Iname = "车辆图标：" + ico.getName();
						ico.setName(Iname);
						break;
					case 3:
						Iname = "武器图标：" + ico.getName();
						ico.setName(Iname);
						break;
					case 4:
						Iname = "定位设备图标：" + ico.getName();
						ico.setName(Iname);
						break;
					}
				}
			}
			JSONArray result = JSONArray.fromObject(list);
			return result.toString();
		} catch (Exception ex) {
			return "";
		}
	}

	/*
	 * 保存警员信息逻辑
	 */
	@RequestMapping(value = "saveGps.do")
	@ResponseBody
	public ReturnResult saveGps(Gps gps) throws Exception {
		try {
			gps.setPlatformId(1);
			gps.setSyncState(true);
			if (gps.getId() > 0) {
				Gps g = gpsService.selectByPrimaryKey(gps.getId());
				int vid = gps.getId();

				gps.setId(vid);
				if (gps.getIconId() == null) {
					gps.setIconId(g.getIconId());
					gps.setIconUrl(g.getIconUrl());
				}
				gpsService.updateByPrimaryKey(gps);
			} else {
				gpsService.insert(gps);

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
	@RequestMapping(value = "deleteGpsById.do")
	@ResponseBody
	public ReturnResult deleteGpsById(
			@RequestParam(value = "gpsId", required = true) String gpsId)
			throws Exception {
		try {

			List<Gps> list = gpsService.findByIdAndDtyId(gpsId);
			if (list.size() > 0) {
				return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,
						"该定位設備存在关联报备数据，不能删除", 0, null);
			} else {
				gpsService.deleteByPrimaryKey(Integer.parseInt(gpsId));

				return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,
						MessageCode.SELECT_SUCCESS, 0, null);
			}
		} catch (Exception ex) {
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL, "删除定位设备数据出错",
					0, null);
		}
	}

	/**
	 * 判断是否有有车辆存在
	 * 
	 * 判断是否车牌号码重复；
	 */
	@RequestMapping(value = "isExistGps.do")
	@ResponseBody
	public ReturnResult isExistGps(
			@RequestParam(value = "param", required = false) String param,
			@RequestParam(value = "type", required = false) Integer type,
			@RequestParam(value = "id", required = false) Integer id)
			throws Exception {
		try {
			List<GpsVM> gps = new ArrayList<GpsVM>();

			if (type > 0) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("number", param);
				map.put("id", id);
				gps = gpsService.findByNumberAndId(map);
			} else {
				gps = gpsService.findByNumber(param);
			}
			if (gps.size() > 0) {
				return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,gps.get(0).getOrgName(),
						0, null);
			} else {
				return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,
						"UnExits", 0, null);
			}

		} catch (Exception ex) {
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL, " ", 0,
					null);
		}
	}
}
