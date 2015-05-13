package com.tianyi.bph.web.controller.dutydata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.PageReturn;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.query.basicdata.VehicleVM;
import com.tianyi.bph.query.duty.OrgWithPoliceVM;
import com.tianyi.bph.query.system.UserQuery;
import com.tianyi.bph.service.basicdata.VehicleService;
import com.tianyi.bph.service.duty.OrgService;
import com.tianyi.bph.service.system.OrganService;

@Controller
@RequestMapping("/testWeb")
public class TestController {
	
	@Autowired 
	private OrgService orgService;
	@Autowired
	private OrganService organService;
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping({ "/gotoTest.do", "/gotoTest.action" })
	@ResponseBody
	public ModelAndView gotoTest(
			HttpServletRequest request,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "organId", required = true, defaultValue = "1") Integer organId
			) {
		UserQuery query = new UserQuery();
		if (!StringUtils.isEmpty(userName)) {
			query.setUserName(userName);
		}
		query.setOrganId(organId);

		ModelAndView mv = new ModelAndView("/basicdata/test/test.jsp");
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
	
	@RequestMapping(value = "/listWithPolice.do",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public  String listWithPolice(
			@RequestParam(value = "rootId", required = false) Integer rootId,
			@RequestParam(value = "id", required = false) String hybrid_id,
			HttpServletRequest request
			){

		Integer qid=null;
		
		if(hybrid_id!=null && hybrid_id!=""){
			if(hybrid_id.indexOf("org")>=0){
				qid=new Integer(hybrid_id.split("_")[1]);
			}
		}else{
			qid=rootId;
		}
		
		List<OrgWithPoliceVM> ls=null;
		
		if(qid!=null){
			ls=orgService.loadOrgWithPoliceVMList(qid); 
			JSONArray rs=JSONArray.fromObject(ls); 
			String s=rs.toString(); 
			return s; 
		}else{
			
			return null; 
		}	
		
	}
	
	@RequestMapping(value = "/getVehicleList.do")
	@ResponseBody
	public PageReturn getVehicleList(
			@RequestParam(value = "vehicle_Query", required = false) String vehicle_Query,
			@RequestParam(value = "page", required = false) Integer xpage,
			@RequestParam(value = "pageSize", required = false) Integer xpageSize,
			HttpServletRequest request) throws Exception {
		try {
			
			Object xx=request.getParameter("page");
			Object xxx=request.getParameter("vehicle_Query");
			

			
			JSONObject joQuery = JSONObject.fromObject(vehicle_Query);
			int orgId = Integer.parseInt(joQuery.getString("orgId"));
			int isSubOrg = Integer.parseInt(joQuery.getString("isSubOrg"));
			String number = joQuery.getString("number");
			String orgPath = joQuery.getString("orgPath");
			int pageStart = Integer.parseInt(joQuery.getString("pageStart"));
			int pageSize = Integer.parseInt(joQuery.getString("pageSize"));
			Map<String, Object> map = new HashMap<String, Object>();

			int pageBegin = xpageSize * (xpage > 0 ? (xpage - 1) : 0);
			//int pageEnd = pageSize + pageBegin;
			map.put("isSubOrg", isSubOrg);
			map.put("number", number);
			map.put("sort", "v.id");
			map.put("order", "desc");
			map.put("orgId", orgId);
			map.put("orgPath", orgPath);
			map.put("pageStart", pageBegin);
			map.put("pageSize", pageSize);

			List<VehicleVM> list = new ArrayList<VehicleVM>();

			int total = vehicleService.loadVMCount(map);

			list = vehicleService.loadVMList(map);

			return PageReturn.MESSAGE(MessageCode.STATUS_SUCESS,
					MessageCode.SELECT_SUCCESS, total, list);
		} catch (Exception ex) {
			return PageReturn.MESSAGE(MessageCode.STATUS_FAIL,
					MessageCode.SELECT_ORGAN_FAIL, 0, null);
		}
	}
	
}
