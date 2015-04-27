package com.tianyi.bph.web.controller.dutydata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.domain.duty.VehicleGroup;
import com.tianyi.bph.domain.duty.VehicleGroupMember;
import com.tianyi.bph.domain.duty.VehicleGroupOrg;
import com.tianyi.bph.query.duty.VehicleGroupMemberVM;
import com.tianyi.bph.query.duty.VehicleGroupVM;
import com.tianyi.bph.service.duty.VehicleGroupService;
import com.tianyi.bph.service.system.OrganService;

@Controller
@RequestMapping("/vehicleGroupWeb")
public class VehicleGroupController {

	@Autowired
	protected VehicleGroupService vehicleGroupService;
	@Autowired
	private OrganService organService;
	

	/**
	 * 查询车辆分组列表
	 * @param query
	 * @param page
	 * @param rows
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "list.do")
	public @ResponseBody ReturnResult List(
			@RequestParam(value = "vehicleGroup_Query", required = false) String query,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) {
	
		JSONObject joQuery =JSONObject.fromObject(query);

		int orgId=joQuery.getInt("orgId");
		String orgCode=joQuery.getString("orgCode");
		
		Map<String, Object> map = new HashMap<String, Object>();
		page = page == 0 ? 1 : page;
		map.put("pageStart", (page-1) * rows);
		map.put("pageSize", rows);
		map.put("orgCode", orgCode);
		map.put("orgId", orgId);
		
		map.put("inSubOrg", 0);
		
		int total=vehicleGroupService.loadVMCountByOrgId(map);

		List<VehicleGroupVM> pgvms=vehicleGroupService.loadVMListByOrgId(map);
		
		
		return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS, "", total, pgvms);
		
	}
	
	/**
	 * 获取当前组织机构及下级机构
	 * @param vehicleGroupId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getShareOrgs.do")
	public @ResponseBody String getShareOrgs(
			@RequestParam(value = "vehicleGroupId", required = false) Integer vehicleGroupId,
			HttpServletRequest request
			){
		
		
		List<VehicleGroupOrg> ls = vehicleGroupService.loadShareOrgList(vehicleGroupId);
		
		String rs=JSONArray.fromObject(ls).toString();
		
		return rs;
		
	}
	
	/**
	 * 根据分组id，获取组成员列表
	 * @param query
	 * @param page
	 * @param rows
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "loadMemberByGroupId.do")
	public @ResponseBody ReturnResult loadMemberByGroupId(
			@RequestParam(value = "groupId", required = false) Integer groupId,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageStart", 0);
		map.put("pageSize", 10);
		map.put("groupId", groupId);
		
		int total=vehicleGroupService.countMemberByGroupId(groupId);

		List<VehicleGroupMemberVM> ms=vehicleGroupService.loadMemberByGroupId(map);
	
		
		return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS, "", total, ms);
	}

	/**
	 * 增加组成员
	 * @param members
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "appendMember.do")
	public @ResponseBody String appendMember(
			@RequestParam(value = "members", required = false) String members,
			HttpServletRequest request
			){
		
		JSONArray jaMembers=JSONArray.fromObject(members);
				
		//Collection<PoliceGroupMember> collection=JSONArray.toCollection(jaMembers, PoliceGroupMember.class);

		List<?> list2 = JSONArray.toList(jaMembers, new VehicleGroupMember(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
		
		List<VehicleGroupMember> ls=new ArrayList<VehicleGroupMember>();
		
		for(Object o:list2){
			VehicleGroupMember pgm=(VehicleGroupMember)o;
			ls.add(pgm);
		}
		
		vehicleGroupService.appendMemeber(ls);

		JSONObject rs=new JSONObject();
		rs.accumulate("isSuccess", true);
		
		return rs.toString();
	}
	
	/**
	 * 保存车辆分组信息
	 * @param vehicleGroup
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "saveVehicleGroup.do")
	public @ResponseBody String saveVehicleGroup(
			@RequestParam(value = "vehicleGroup", required = false) String vehicleGroup,
			HttpServletRequest request
			){
		
		JSONObject joPG =JSONObject.fromObject(vehicleGroup);
		
		VehicleGroup pg=new VehicleGroup();
		pg.setId(joPG.getInt("id"));
		pg.setName(joPG.getString("name"));
		pg.setShareType(joPG.getInt("shareType"));
		pg.setOrgId(joPG.getInt("orgId"));
		
		JSONArray jaOrgIds=joPG.getJSONArray("shareOrgIds");
		
		Object[] orgIds=jaOrgIds.toArray();
		
		vehicleGroupService.saveVehicleGroup(pg, orgIds);
		
		JSONObject rs=new JSONObject();
		rs.accumulate("isSuccess", true);
		rs.accumulate("msg", "");
		rs.accumulate("id", pg.getId());
		return rs.toString();
	}
	/**
	 * 删除车辆组
	 * @param vehicleGroupId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "deleteVehicleGroup.do")
	 public @ResponseBody String deleteVehicleGroup(
			 @RequestParam(value="vehicleGroupId",required=false) Integer vehicleGroupId,
				HttpServletRequest request
				){
		 
		 vehicleGroupService.deleteById(vehicleGroupId);
		 
		JSONObject rs=new JSONObject();
		rs.accumulate("isSuccess", true);
		rs.accumulate("msg", "");
		 	
		return rs.toString();
	 }
}
