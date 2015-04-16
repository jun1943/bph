package com.tianyi.bph.web.controller.dutydata;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

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
import com.tianyi.bph.query.duty.OrgWithPoliceVM;
import com.tianyi.bph.query.system.UserQuery;
import com.tianyi.bph.service.duty.OrgService;
import com.tianyi.bph.service.system.OrganService;

@Controller
@RequestMapping("/testWeb")
public class TestController {
	
	@Autowired 
	private OrgService orgService;
	@Autowired
	private OrganService organService;
	
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
			
//			return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,
//					MessageCode.SELECT_ORGAN_FAIL, 0, ls);
			
		}else{
			
			return null;
			
//			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,
//					MessageCode.SELECT_ORGAN_FAIL, 0, null);
		}	
		
	}
	
}
