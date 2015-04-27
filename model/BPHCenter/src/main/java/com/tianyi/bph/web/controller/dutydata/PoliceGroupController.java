package com.tianyi.bph.web.controller.dutydata;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.query.duty.PoliceGroupMemberVM;
import com.tianyi.bph.query.duty.PoliceGroupVM;
import com.tianyi.bph.service.duty.PoliceGroupService;
import com.tianyi.bph.service.system.OrganService;

@Controller
@RequestMapping("/policeGroupWeb")
public class PoliceGroupController {

	@Autowired
	protected PoliceGroupService policeGroupService;
	@Autowired
	private OrganService organService;
	

	/**
	 * 获取警员分组列表
	 * 
	 * @param query
	 * @param page
	 * @param rows
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "list.do")
	public @ResponseBody
	ReturnResult List(
			@RequestParam(value = "policeGroup_Query", required = false) String query,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) {

		JSONObject joQuery = JSONObject.fromObject(query);

		int orgId = joQuery.getInt("orgId");
		String orgCode = joQuery.getString("orgCode");

		Map<String, Object> map = new HashMap<String, Object>();
		page = page == 0 ? 1 : page;
		map.put("pageStart", (page - 1) * rows);
		map.put("pageSize", rows);
		map.put("orgCode", orgCode);
		map.put("orgId", orgId);

		map.put("inSubOrg", 0);

		int total = policeGroupService.loadVMCountByOrgId(map);

		List<PoliceGroupVM> pgvms = policeGroupService.loadVMListByOrgId(map);


		return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,"", total, pgvms);

	}

	/**
	 * 根据分组id，加载组成员
	 * 
	 * @param query
	 * @param page
	 * @param rows
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "loadMemberByGroupId.do")
	public @ResponseBody
	ReturnResult loadMemberByGroupId(
			@RequestParam(value = "groupId", required = false) Integer groupId,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) {
   
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageStart", 0);
		map.put("pageSize", 10);
		map.put("groupId", groupId);

		int total = policeGroupService.countMemberByGroupId(groupId);

		List<PoliceGroupMemberVM> ms = policeGroupService
				.loadMemberByGroupId(map);
  

		return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS, "", total, ms);
	}
	
	/**
	 * 删除组成员
	 * 
	 * @param memberId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "delMemberById.do")
	public @ResponseBody
	String delMemberById(
			@RequestParam(value = "memberId", required = false) Integer memberId,
			HttpServletRequest request) {

		policeGroupService.delMemberById(memberId);

		JSONObject rs = new JSONObject();
		rs.accumulate("isSuccess", true);

		return rs.toString();
	}

	/**
	 * 清除组成员
	 * 
	 * @param policeGroupId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "cleanMemberByGroupId.do")
	public @ResponseBody
	String cleanMemberByGroupId(
			@RequestParam(value = "policeGroupId", required = false) Integer policeGroupId,
			HttpServletRequest request) {

		policeGroupService.cleanMember(policeGroupId);

		return "";
	}
	
	/**
	 * 删除警员组
	 * 
	 * @param policeGroupId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "deletePoliceGroup.do")
	public @ResponseBody
	String deletePoliceGroup(
			@RequestParam(value = "policeGroupId", required = false) Integer policeGroupId,
			HttpServletRequest request) {

		policeGroupService.deleteById(policeGroupId);

		JSONObject rs = new JSONObject();
		rs.accumulate("isSuccess", true);
		rs.accumulate("msg", "");

		return rs.toString();
	}


}
