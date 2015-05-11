package com.tianyi.bph.web.controller.basicdata;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile; 
import org.springframework.web.servlet.ModelAndView;
 
import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.PageReturn;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.domain.basicdata.Icons; 
import com.tianyi.bph.domain.basicdata.IconsType;  
import com.tianyi.bph.query.basicdata.IconsVM;
import com.tianyi.bph.query.system.UserQuery;
import com.tianyi.bph.service.basicdata.IconsService; 
 

/*
 * 
 * 武器管理逻辑控制器；
 */

@Controller
@RequestMapping("/iconsWeb")
public class IconController {


	@Autowired IconsService iconsService;

	/**
	 * web跳转到警员列表
	 * 
	 * @param request
	 * @param username
	 *            用户名
	 * @return
	 */
	@RequestMapping({ "/gotoIconsList.do", "/gotoIconsList.action" })
	@ResponseBody
	public ModelAndView gotoIconsList(
			HttpServletRequest request,  
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo) {
		UserQuery query = new UserQuery(); 
		query.setPageNo(pageNo);
		query.setPageSize(pageSize);
		ModelAndView mv = new ModelAndView("/basicdata/icons/iconsList.jsp");
		  
		mv.addObject("query", query); 
		mv.addObject("num","200");
		return mv;
	}

	@RequestMapping({ "gotoIconAdd.do", "/gotoIconAdd.action" })
	@ResponseBody
	public ModelAndView gotoIconAdd( 
			HttpServletRequest request) throws Exception {
		try { 
			ModelAndView mv = new ModelAndView(
					"/basicdata/icons/iconsAdd.jsp"); 
			return mv;
		} catch (Exception ex) {
			return new ModelAndView("/basicdata/icons/iconsList.jsp");
		}
	} 
	/*
	 * 获取图标列表信息
	 * 
	 * param：query查询条件包
	 * 
	 * page：当前页 rows：每页条数
	 */
	@RequestMapping(value = "getIconsList.do")
	 @ResponseBody
	public
	PageReturn getIconsList(
			@RequestParam(value = "icons_Query", required = false) String query, 
			HttpServletRequest request) throws Exception {
		try { 
			JSONObject joQuery = JSONObject.fromObject(query);
			String name = joQuery.getString("name");

			int typeId = Integer.parseInt(joQuery.getString("typeId"));
			int pageStart = Integer.parseInt(joQuery.getString("pageStart"));
			int pageSize = Integer.parseInt(joQuery.getString("pageSize"));

			List<IconsVM> list = new ArrayList<IconsVM>();
			Map<String, Object> map = new HashMap<String, Object>();

			int pageBegin = pageSize * (pageStart > 0 ? (pageStart - 1) : 0);
			//int pageEnd = pageSize + pageBegin;
			
			map.put("pageStart", pageBegin);
			map.put("pageSize", pageSize);
			map.put("name", name);
			map.put("typeid", typeId);

			int total = iconsService.loadCount(map);
			list = iconsService.loadList(map); 

			if(list.size()==0){
				if(pageStart>1){
					pageBegin = pageSize * ((pageStart-1) > 0 ? (pageStart - 2) : 0);
					map.put("pageStart", pageBegin);
					list = iconsService.loadList(map); 
				}
			}
			return PageReturn.MESSAGE(MessageCode.STATUS_SUCESS,
					MessageCode.SELECT_SUCCESS, total, list);
		} catch (Exception ex) {
			return PageReturn.MESSAGE(MessageCode.STATUS_FAIL,
					"获取图标列表失败", 0, null);
		}
	}
	/*
	 * 
	 * 获取车辆类型列表，以下拉框的形式展现；
	 */
	@RequestMapping(value = "getIconType.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getIconType() throws Exception {
		try {
			List<IconsType> list = iconsService.selectIconType();
			JSONArray result = JSONArray.fromObject(list);
			return result.toString();
		} catch (Exception ex) {
			return "";
		}
	}
 

	/*
	 * 保存警员信息逻辑
	 */
	@RequestMapping(value = "deleteIconsById.do")
	@ResponseBody
	public ReturnResult deleteIconsById(
			@RequestParam(value = "iconId", required = true) String iconId,
			HttpServletRequest request)
			throws Exception {
		try {

			List<Icons> list = iconsService.findByIdAndGpsId(iconId);
			if (list.size() > 0) {
				return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,
						"该图标已关联Gps设备，不能删除", 0, null);
			} else {
				Icons icons = new Icons();
				icons = iconsService.selectByPrimaryKey(Integer.parseInt(iconId));
				if(icons==null){
					return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,
							"获取图标对象失败，删除失败", 0, null);
				}
				String iconUrl = icons.getIconUrl();
				iconUrl = iconUrl.substring(10,iconUrl.length());
				String uploadPath = request.getRealPath("uploadIcon")+iconUrl;
				File ficon = new File(uploadPath);
				if(ficon.exists()){
					ficon.delete();
				}
				iconsService.updateIconsInfoById(Integer.parseInt(iconId));

				return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,
						MessageCode.SELECT_SUCCESS, 0, null);
			}
		} catch (Exception ex) {
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL, "删除武器数据出错", 0,
					null);
		}
	}

}
