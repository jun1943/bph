package com.tianyi.bph.web.controller.dutydata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.domain.duty.Org;
import com.tianyi.bph.query.duty.OrgTreeVM;
import com.tianyi.bph.query.duty.OrgWithGpsVM;
import com.tianyi.bph.query.duty.OrgWithPoliceVM;
import com.tianyi.bph.query.duty.OrgWithVehicleVM;
import com.tianyi.bph.query.duty.OrgWithWeaponVM;
import com.tianyi.bph.query.duty.OrganGroupVM;
import com.tianyi.bph.service.duty.OrgService;
import com.tianyi.bph.web.controller.ListResult;

@Controller
@RequestMapping("/organWeb")
public class OrganResourceController {

	@Autowired
	protected OrgService orgService;

	/**
	 * 根据传入的组织结构信息，获取所有组织结构信息
	 * 
	 * @param orgCode
	 * @param orgPath
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "list.do")
	public @ResponseBody
	String List(
			@RequestParam(value = "orgCode", required = false) String orgCode,
			@RequestParam(value = "orgPath", required = false) String orgPath,
			HttpServletRequest request) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("orgCode", orgCode);
		map.put("orgPath", orgPath);

		List<Org> ls = orgService.loadSubOrgList(orgCode, orgPath);
		ListResult<Org> orgs = new ListResult<Org>(ls.size(), ls, true);
		String rs = orgs.toJson();
		return rs;

	}

	/**
	 * 根据传入的组织结构信息，获取所有组织结构信息
	 * 
	 * @param orgCode
	 * @param orgPath
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "treelist.do")
	public @ResponseBody
	ReturnResult treelist(
			@RequestParam(value = "orgCode", required = false) String orgCode,
			@RequestParam(value = "orgPath", required = false) String orgPath,
			@RequestParam(value = "groupId", required = false) Integer groupId,
			@RequestParam(value = "sourceType", required = false) String  sourceType,
			HttpServletRequest request) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("orgCode", orgCode);
			map.put("orgPath", orgPath);

			List<Org> ls = orgService.loadSubOrgList(orgCode, orgPath);

			OrgTreeVM ot = getTreeData(ls, orgPath, groupId, sourceType);
			return ReturnResult.MESSAGE(200, "", 0, ot);
		} catch (Exception ex) {
			return ReturnResult.MESSAGE(300, "", 0, null);
		}
	}

	private OrgTreeVM getTreeData(List<Org> ls, String orgPath, Integer groupId,String sourceType) {
		// TODO Auto-generated method stub
		OrgTreeVM ot = new OrgTreeVM();

		if (ls.size() > 0) {
			for (Org o : ls) {
				if (o.getPath().equals(orgPath)) {
					ot.setCode(o.getCode());
					ot.setId(o.getId());
					ot.setName(o.getName());
					ot.setParentId(o.getParentId());
					ot.setPath(o.getPath());
					ot.setShortName(o.getShortName());
					ot.setChecked(true);
					List<OrgTreeVM> ots = new ArrayList<OrgTreeVM>();
					ots = getItems(o.getId(), ls, groupId,sourceType);
					if (ots != null) {
						if (ots.size() > 0) {
							ot.setItems(ots);
							ot.setExpanded(true);
							ot.setState(true);
						} else {
							ot.setItems(null);
							ot.setExpanded(false);
							ot.setState(false);
						}
					} else {
						ot.setItems(null);
						ot.setExpanded(true);
						ot.setState(true);
					}
				}
			}
		}

		return ot;
	}

	private java.util.List<OrgTreeVM> getItems(int id, List<Org> ls,
			Integer groupId,String sourceType) {
		// TODO Auto-generated method stub
		List<OrgTreeVM> list = new ArrayList<OrgTreeVM>();
		for (Org o : ls) {
			if (o.getParentId() == id) {
				OrgTreeVM ot = new OrgTreeVM();
				ot.setCode(o.getCode());
				ot.setId(o.getId());
				ot.setName(o.getName());
				ot.setParentId(o.getParentId());
				ot.setPath(o.getPath());
				ot.setShortName(o.getShortName());
				List<OrgTreeVM> ots = new ArrayList<OrgTreeVM>();
				ots = getItems(o.getId(), ls, groupId,sourceType);
				if (ots != null) {

					boolean ischeck = getCheckType(o.getId(), groupId,sourceType);
					if (ots.size() > 0) {
						ot.setItems(ots);
						ot.setChecked(ischeck);
						ot.setExpanded(true);
						ot.setState(true);
					} else {
						ot.setChecked(ischeck);
						ot.setExpanded(false);
						ot.setState(false);
					}
				} else {
					ot.setItems(null);
					ot.setExpanded(true);
					ot.setState(true);
				}
				list.add(ot);
			}
		}
		return list;
	}

	private boolean getCheckType(int id, Integer groupId,String sourceType) {
		// TODO Auto-generated method stub
		List<OrganGroupVM> list = new ArrayList<OrganGroupVM>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", id);
		map.put("groupId", groupId);
		if(sourceType.equals("Police")){
			list = orgService.loadOrgPoliceGroupVMList(map);
		}else if(sourceType.equals("Vehicle")){
			list = orgService.loadOrgVehicleGroupVMList(map);
		}else if(sourceType.equals("Weapon")){
			list = orgService.loadOrgWeaponGroupVMList(map);
		}else if(sourceType.equals("Gps")){
			list = orgService.loadOrgGpsGroupVMList(map);
		}
		if (list.size() == 1) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 根据名称获取列表对象
	 * 
	 * @param name
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "loadListByName.do")
	public @ResponseBody
	String loadListByName(
			@RequestParam(value = "name", required = false) String name,
			HttpServletRequest request) {

		return null;
	}

	/**
	 * 返回组织机构和下属警员信息
	 * 
	 * @param orgCode
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/listWithPolice.do",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public  String listWithPolice(
			@RequestParam(value = "rootId", required = false) Integer rootId,
			@RequestParam(value = "id", required = false) String hybrid_id,
			HttpServletRequest request
			){

		Integer qid=null;
		
		if(hybrid_id!=null && !hybrid_id.equals("")){
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

	/**
	 * 返回组织机构和下属车辆信息
	 * 
	 * @param orgCode
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/listWithVehicle.do",produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String listWithVehicle(
			@RequestParam(value = "rootId", required = false) Integer rootId,
			@RequestParam(value = "id", required = false) String hybrid_id,
			HttpServletRequest request) {

		Integer qid = null;
 
		
		if(hybrid_id!=null && !hybrid_id.equals("")){
			if(hybrid_id.indexOf("org")>=0){
				qid=new Integer(hybrid_id.split("_")[1]);
			}
		}else{
			qid=rootId;
		}
		
		List<OrgWithVehicleVM> ls=null;
		
		if(qid!=null){
			ls=orgService.loadOrgWithVehicleVMList(qid); 
			JSONArray rs=JSONArray.fromObject(ls); 
			String s=rs.toString(); 
			return s; 
		}else{
			
			return null; 
		}	
	}

	/**
	 * 返回组织机构和下属武器信息
	 * 
	 * @param orgCode
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/listWithWeapon.do",produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String listWithWeapon(
			@RequestParam(value = "rootId", required = false) Integer rootId,
			@RequestParam(value = "id", required = false) String hybrid_id,
			HttpServletRequest request) {

		Integer qid = null;
 
		
		if(hybrid_id!=null && !hybrid_id.equals("")){
			if(hybrid_id.indexOf("org")>=0){
				qid=new Integer(hybrid_id.split("_")[1]);
			}
		}else{
			qid=rootId;
		}
		
		List<OrgWithWeaponVM> ls=null;
		
		if(qid!=null){
			ls=orgService.loadOrgWithWeaponVMList(qid); 
			JSONArray rs=JSONArray.fromObject(ls); 
			String s=rs.toString(); 
			return s; 
		}else{
			
			return null; 
		}	
	}

	/**
	 * 返回组织机构和下属武器信息
	 * 
	 * @param orgCode
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/listWithGps.do",produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String listWithGps(
			@RequestParam(value = "rootId", required = false) Integer rootId,
			@RequestParam(value = "id", required = false) String hybrid_id,
			HttpServletRequest request) {

		Integer qid = null;
 
		
		if(hybrid_id!=null && !hybrid_id.equals("")){
			if(hybrid_id.indexOf("org")>=0){
				qid=new Integer(hybrid_id.split("_")[1]);
			}
		}else{
			qid=rootId;
		}
		
		List<OrgWithGpsVM> ls=null;
		
		if(qid!=null){
			ls=orgService.loadOrgWithGpsVMList(qid); 
			JSONArray rs=JSONArray.fromObject(ls); 
			String s=rs.toString(); 
			return s; 
		}else{
			
			return null; 
		}	
	}
}
