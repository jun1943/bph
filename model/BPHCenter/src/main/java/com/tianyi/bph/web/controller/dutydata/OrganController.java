package com.tianyi.bph.web.controller.dutydata;

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

import com.tianyi.bph.domain.duty.Org;
import com.tianyi.bph.query.duty.OrgWithGpsVM;
import com.tianyi.bph.query.duty.OrgWithPoliceVM;
import com.tianyi.bph.query.duty.OrgWithVehicleVM;
import com.tianyi.bph.query.duty.OrgWithWeaponVM;
import com.tianyi.bph.service.duty.OrgService;
import com.tianyi.bph.web.controller.ListResult;

@Controller
@RequestMapping("/organWeb")
public class OrganController {

	@Autowired
	protected OrgService orgService;
	

	/**
	 * 根据传入的组织结构信息，获取所有组织结构信息
	 * @param orgCode
	 * @param orgPath
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "list.do")
	public @ResponseBody String  List(
			@RequestParam(value = "orgCode", required = false) String orgCode,
			@RequestParam(value = "orgPath", required = false) String orgPath,
			HttpServletRequest request
			){
		
			Map<String,Object> map=new HashMap<String,Object>();
			
			map.put("orgCode", orgCode);
			map.put("orgPath", orgPath);
			
			List<Org> ls=orgService.loadSubOrgList(orgCode, orgPath);
			ListResult<Org> orgs=new ListResult<Org>(ls.size(),ls,true);
			String rs=orgs.toJson();
			return rs;
		
	}
	
	/**
	 * 根据名称获取列表对象
	 * @param name
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "loadListByName.do")
	public @ResponseBody String  loadListByName(
			@RequestParam(value = "name", required = false) String name,
			HttpServletRequest request
			){
	
		return null;
	}
	/**
	 * 返回组织机构和下属警员信息
	 * @param orgCode
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "listWithPolice.do")
	public @ResponseBody String listWithPolice(
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
		
		if(qid!=null){
			List<OrgWithPoliceVM> ls=orgService.loadOrgWithPoliceVMList(qid);
			if(ls.size()>0){
				for(OrgWithPoliceVM op :ls){
					op.setReportsTo(qid);
				}
			}
			JSONArray rs=JSONArray.fromObject(ls);
			 
			String s=rs.toString(); 
			return s;
		}else{
			return null;
		}		
	}
	/**
	 * 返回组织机构和下属车辆信息
	 * @param orgCode
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "listWithVehicle.do")
	public @ResponseBody String listWithVehicle(
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
		
		if(qid!=null){ 
			List<OrgWithVehicleVM> ls=orgService.loadOrgWithVehicleVMList(qid);
			JSONArray rs=JSONArray.fromObject(ls); 
			
			String result = rs.toString();
			
		 
			return result;
		}else{
			return null;
		}		
	}
	/**
	 * 返回组织机构和下属武器信息
	 * @param orgCode
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "listWithWeapon.do")
	public @ResponseBody String listWithWeapon(
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
		
		if(qid!=null){
			List<OrgWithWeaponVM> ls=orgService.loadOrgWithWeaponVMList(qid);
			JSONArray rs=JSONArray.fromObject(ls);
			
			return rs.toString();
		}else{
			return null;
		}		
	}
	/**
	 * 返回组织机构和下属武器信息
	 * @param orgCode
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "listWithGps.do")
	public @ResponseBody String listWithGps(
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
		
		if(qid!=null){
			List<OrgWithGpsVM> ls=orgService.loadOrgWithGpsVMList(qid);
			JSONArray rs=JSONArray.fromObject(ls);
			
			return rs.toString();
		}else{
			return null;
		}		
	}
}
