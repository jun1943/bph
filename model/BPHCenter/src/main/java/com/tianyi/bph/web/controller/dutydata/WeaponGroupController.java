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

import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.domain.duty.WeaponGroup;
import com.tianyi.bph.domain.duty.WeaponGroupMember;
import com.tianyi.bph.domain.duty.WeaponGroupOrg;
import com.tianyi.bph.query.duty.WeaponGroupMemberVM;
import com.tianyi.bph.query.duty.WeaponGroupVM;
import com.tianyi.bph.service.duty.WeaponGroupService;
import com.tianyi.bph.service.system.OrganService;


@Controller
@RequestMapping("/weaponGroupWeb")
public class WeaponGroupController {

	@Autowired
	protected WeaponGroupService weaponGroupService;
	@Autowired
	private OrganService organService;
	

	/**
	 * 获取武器分组列表
	 * @param query
	 * @param page
	 * @param rows
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "list.do")
	public @ResponseBody ReturnResult List(
			@RequestParam(value = "weaponGroup_Query", required = false) String query,
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
		
		int total=weaponGroupService.loadVMCountByOrgId(map);

		List<WeaponGroupVM> pgvms=weaponGroupService.loadVMListByOrgId(map);
		
		//ListResult<WeaponGroupVM> rs=new ListResult<WeaponGroupVM>(total,pgvms);
		
		//String ss=JSONObject.fromObject(rs).toString();
		
		return ReturnResult.MESSAGE(200, "", total, pgvms);
		
	}
	
	/**
	 * 获取当前组织机构及下级机构
	 * @param weaponGroupId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getShareOrgs.do")
	public @ResponseBody String getShareOrgs(
			@RequestParam(value = "weaponGroupId", required = false) Integer weaponGroupId,
			HttpServletRequest request
			){
		
		
		List<WeaponGroupOrg> ls = weaponGroupService.loadShareOrgList(weaponGroupId);
		
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
		
//		JSONObject joQuery =JSONObject.fromObject(query);

//		int groupId=joQuery.getInt("groupId");
//		page=page==0?1:page;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageStart", 0);
		map.put("pageSize", 10);
		map.put("groupId", groupId);
		
		int total=weaponGroupService.countMemberByGroupId(groupId);

		List<WeaponGroupMemberVM> ms=weaponGroupService.loadMemberByGroupId(map);
	
//		ListResult<WeaponGroupMemberVM> rs=new ListResult<WeaponGroupMemberVM>(total,ms);
		
//		String ss=JSONObject.fromObject(rs).toString();
		
		return ReturnResult.MESSAGE(200, "", total, ms);
	}
	/**
	 * 添加组成员
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

		List<?> list2 = JSONArray.toList(jaMembers, new WeaponGroupMember(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
		
		List<WeaponGroupMember> ls=new ArrayList<WeaponGroupMember>();
		
		for(Object o:list2){
			WeaponGroupMember pgm=(WeaponGroupMember)o;
			ls.add(pgm);
		}
		
		weaponGroupService.appendMemeber(ls);

		JSONObject rs=new JSONObject();
		rs.accumulate("isSuccess", true);
		
		return rs.toString();
	}
	
	/**
	 * 保存武器分组信息
	 * @param weaponGroup
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "saveWeaponGroup.do")
	public @ResponseBody String saveWeaponGroup(
			@RequestParam(value = "weaponGroup", required = false) String weaponGroup,
			HttpServletRequest request
			){
		
		JSONObject joPG =JSONObject.fromObject(weaponGroup);
		
		WeaponGroup pg=new WeaponGroup();
		pg.setId(joPG.getInt("id"));
		pg.setName(joPG.getString("name"));
		pg.setShareType(joPG.getInt("shareType"));
		pg.setOrgId(joPG.getInt("orgId"));
		
		JSONArray jaOrgIds=joPG.getJSONArray("shareOrgIds");
		
		Object[] orgIds=jaOrgIds.toArray();
		
		weaponGroupService.saveWeaponGroup(pg, orgIds);
		
		JSONObject rs=new JSONObject();
		rs.accumulate("isSuccess", true);
		rs.accumulate("msg", "");
		rs.accumulate("id", pg.getId());
		return rs.toString();
	}
	/**
	 * 删除武器分组
	 * @param weaponGroupId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "deleteWeaponGroup.do")
	 public @ResponseBody String deleteWeaponGroup(
			 @RequestParam(value="weaponGroupId",required=false) Integer weaponGroupId,
				HttpServletRequest request
				){
		 
		weaponGroupService.deleteById(weaponGroupId);
		 
		JSONObject rs=new JSONObject();
		rs.accumulate("isSuccess", true);
		rs.accumulate("msg", "");
		 	
		return rs.toString();
	 }
}
