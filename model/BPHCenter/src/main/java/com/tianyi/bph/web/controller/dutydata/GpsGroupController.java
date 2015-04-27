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
import com.tianyi.bph.domain.duty.GpsGroup;
import com.tianyi.bph.domain.duty.GpsGroupMember;
import com.tianyi.bph.domain.duty.GpsGroupOrg;
import com.tianyi.bph.query.duty.GpsGroupMemberVM;
import com.tianyi.bph.query.duty.GpsGroupVM;
import com.tianyi.bph.service.duty.GpsGroupService;
import com.tianyi.bph.service.system.OrganService;

@Controller
@RequestMapping("/gpsGroupWeb")
public class GpsGroupController {

	@Autowired
	protected GpsGroupService gpsGroupService;
	@Autowired
	private OrganService organService;

	/**
	 * 获取左右翼分组列表
	 * 
	 * @param query
	 *            组织结构信息
	 * @param page
	 *            当前页
	 * @param rows
	 *            每页条数
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "list.do")
	public @ResponseBody
	ReturnResult List(
			@RequestParam(value = "gpsGroup_Query", required = false) String query,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) {
		try {
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

			int total = gpsGroupService.loadVMCountByOrgId(map);

			List<GpsGroupVM> pgvms = gpsGroupService.loadVMListByOrgId(map);

			return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,
					MessageCode.SELECT_SUCCESS, total, pgvms);
		} catch (Exception ex) {
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL, "", 0, null);
		}
	}

	/**
	 * 获取当前组织结构以及下级机构
	 * 
	 * @param gpsGroupId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getShareOrgs.do")
	public @ResponseBody
	String getShareOrgs(
			@RequestParam(value = "gpsGroupId", required = false) Integer gpsGroupId,
			HttpServletRequest request) {

		List<GpsGroupOrg> ls = gpsGroupService.loadShareOrgList(gpsGroupId);

		String rs = JSONArray.fromObject(ls).toString();

		return rs;

	}

	/**
	 * 根据分组id获取组成员
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
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pageStart", 0);
			map.put("pageSize", 10);
			map.put("groupId", groupId);

			int total = gpsGroupService.countMemberByGroupId(groupId);

			List<GpsGroupMemberVM> ms = gpsGroupService
					.loadMemberByGroupId(map);

			return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS, "", total,
					ms);
		} catch (Exception ex) {
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL, "", 0,
					null);
		}
	}

	/**
	 * 添加组成员
	 * @param members 组成员列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "appendMember.do")
	public @ResponseBody
	String appendMember(
			@RequestParam(value = "members", required = false) String members,
			HttpServletRequest request) {
		try{
			JSONArray jaMembers = JSONArray.fromObject(members);
	
			List<?> list2 = JSONArray.toList(jaMembers, new GpsGroupMember(),
					new JsonConfig());// 参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
	
			List<GpsGroupMember> ls = new ArrayList<GpsGroupMember>();
	
			for (Object o : list2) {
				GpsGroupMember pgm = (GpsGroupMember) o;
				ls.add(pgm);
			}
	
			gpsGroupService.appendMemeber(ls);
	
			JSONObject rs = new JSONObject();
			rs.accumulate("isSuccess", true);
	
			return rs.toString();
		}catch(Exception ex){
			return "";
		}
	}

	/**
	 * 保存定位设备分组
	 * @param gpsGroup
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "saveGpsGroup.do")
	public @ResponseBody
	String saveGpsGroup(
			@RequestParam(value = "gpsGroup", required = false) String gpsGroup,
			HttpServletRequest request) {

		JSONObject joPG = JSONObject.fromObject(gpsGroup);

		GpsGroup pg = new GpsGroup();
		pg.setId(joPG.getInt("id"));
		pg.setName(joPG.getString("name"));
		pg.setShareType(joPG.getInt("shareType"));
		pg.setOrgId(joPG.getInt("orgId"));

		JSONArray jaOrgIds = joPG.getJSONArray("shareOrgIds");

		Object[] orgIds = jaOrgIds.toArray();

		gpsGroupService.saveGpsGroup(pg, orgIds);

		JSONObject rs = new JSONObject();
		rs.accumulate("isSuccess", true);
		rs.accumulate("msg", "");
		rs.accumulate("id", pg.getId());
		return rs.toString();
	}

	/**
	 * 删除定位设备分组
	 * 
	 * @param GpsGroupId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "deleteGpsGroup.do")
	public @ResponseBody
	String deleteGpsGroup(
			@RequestParam(value = "gpsGroupId", required = false) Integer gpsGroupId,
			HttpServletRequest request) {

		gpsGroupService.deleteById(gpsGroupId);

		JSONObject rs = new JSONObject();
		rs.accumulate("isSuccess", true);
		rs.accumulate("msg", "");

		return rs.toString();
	}
}
