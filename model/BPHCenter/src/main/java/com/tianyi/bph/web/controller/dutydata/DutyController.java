package com.tianyi.bph.web.controller.dutydata;
 
 
import java.util.HashMap;
import java.util.List;
import java.util.Map; 
import javax.servlet.http.HttpServletRequest; 
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils; 
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody; 
 
import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.ReturnResult; 
import com.tianyi.bph.domain.duty.Duty;
import com.tianyi.bph.domain.duty.Org;
import com.tianyi.bph.domain.duty.PoliceTarget;
import com.tianyi.bph.query.duty.DutyItemVM;
import com.tianyi.bph.query.duty.DutyVM; 
import com.tianyi.bph.query.duty.TaskTargetVM;
import com.tianyi.bph.service.duty.DutyService;
import com.tianyi.bph.service.duty.DutyTaskService; 
import com.tianyi.bph.domain.duty.DutyProperty;
import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.query.system.UserQuery;
import com.tianyi.bph.service.duty.DutyService; 
import com.tianyi.bph.service.system.OrganService;

@Controller
@RequestMapping("/dutyWeb")
public class DutyController {

	@Autowired
	private OrganService organService;

	@Autowired
	private DutyService dutyService; 

	@Autowired
	private DutyTaskService dutyTaskService; 
	/**
	 * 鎶ュ妯℃澘鐨勫姞杞借幏鍙栬祴鍊兼姤澶囨暟鎹俊鎭�
	 * 
	 * @param orgId
	 *            缁勭粐鏈烘瀯id
	 * @param ymd
	 *            鏃ユ湡
	 * @param id
	 *            浼犲叆鐨刬d鍊硷紝鑻d涓嶇瓑浜庣┖锛屽垯鏄�杩囨ā鏉块�鎷╂潵鍔犺浇鎶ュ鏁版嵁锛岃嫢id涓虹┖锛屽垯閫氳繃鎶ュ澶嶅埗鍔犺浇鎶ュ鏁版嵁
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "loadDutyByOrgIdAndYMD.do")
	public @ResponseBody
	ReturnResult loadDutyByOrgIdAndYMD(
			@RequestParam(value = "orgId", required = false) Integer orgId,
			@RequestParam(value = "ymd", required = false) Integer ymd,
			@RequestParam(value = "id", required = false) Integer id,
			HttpServletRequest request) {
		try {
			DutyVM dvm = null;
			if (id == null) {
				dvm = dutyService.loadVMByOrgIdAndYmd(orgId, ymd);
			} else {
				dvm = dutyService.loadById(id);
			} 
			return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,
					MessageCode.SELECT_SUCCESS, 0, dvm);

		} catch (Exception ex) {
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,
					MessageCode.SELECT_ORGAN_FAIL, 0, null);
		}
	}
	

	/**
	 * 鍔犺浇褰撳墠缁勭粐鏈烘瀯涓嬪凡淇濆瓨鐨勬ā鏉�
	 * 
	 * @param orgId
	 *            缁勭粐鏈烘瀯id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "loadTemplateByOrgId.do")
	public @ResponseBody
	ReturnResult loadTemplateByOrgId(
			@RequestParam(value = "orgId", required = false) Integer orgId,
			HttpServletRequest request) {
		try{
		List<Duty> dvms = dutyService.loadTemplatesWithOutItem(orgId);
		int total = dvms.size();
		return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,
				MessageCode.SELECT_SUCCESS, total, dvms);
		}
		catch(Exception ex){
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,
					MessageCode.SELECT_ORGAN_FAIL, 0, null);
		}
	}
 
	/**
	 * 淇濆瓨鎶ュ鏄庣粏鏁版嵁
	 * 
	 * @param dvm
	 *            鍓嶅彴鏋勫缓瀵硅薄
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "save.do")
	public @ResponseBody
	ReturnResult save(@RequestParam(value = "duty", required = false) String dvm,
			HttpServletRequest request) {

		try{
			JSONObject jobj = JSONObject.fromObject(dvm);
	
			// jobj.remove("beginTime");
			// jobj.remove("endTime2");
	
			JSONUtils.getMorpherRegistry().registerMorpher(
					new DateMorpher(new String[] { "yyyy-MM-dd HH:mm" }));
	
			Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();
	
			classMap.put("items", DutyItemVM.class);
			classMap.put("children", DutyItemVM.class);
			classMap.put("targets", PoliceTarget.class);
	
			DutyVM d = (DutyVM) JSONObject.toBean(jobj, DutyVM.class, classMap);
	
			dutyService.save(d);
			return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,
					MessageCode.SELECT_SUCCESS, 0, d.getId());
		}
		catch(Exception ex){
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,
					MessageCode.SELECT_ORGAN_FAIL, 0, null);
		} 
	}

	@RequestMapping(value = "deleteDutyTemplateAction.do")
	public @ResponseBody
	ReturnResult deleteDutyTemplateAction(
			@RequestParam(value = "temId", required = false) Integer param,
			HttpServletRequest request) {
		try {
			Duty duty = new Duty();
			duty = dutyService.loadTempById(param);
			if (duty != null) {
				int dutyId = duty.getId();
				dutyService.deleteByDutyId(dutyId);
				dutyService.deleteTempById(param);
			}
			return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,
					MessageCode.SELECT_SUCCESS, 0, null);
		} catch (Exception ex) {
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,
					MessageCode.SELECT_ORGAN_FAIL, 0, null);
		}

	}
	

	/**
	 * 鍔犺浇褰撳墠鍕ゅ姟绫诲瀷鐨勫叧鑱斾换鍔″睘鎬�
	 * 
	 * @param orgId
	 * @param orgCode
	 * @param taskType
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "loadTaskTargetByOrg.do")
	public @ResponseBody
	ReturnResult loadTaskTargetByOrg(
			@RequestParam(value = "orgId", required = false) Integer orgId,
			@RequestParam(value = "orgCode", required = false) String orgCode,
			@RequestParam(value = "taskType", required = false) Integer taskType,
			HttpServletRequest request) { 
		try{
			Org org = new Org(); 
			org.setId(orgId);
			org.setCode(orgCode); 
			List<TaskTargetVM> ls = dutyTaskService.loadTaskTargetVMList(taskType,
					org); 
			return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,
					MessageCode.SELECT_SUCCESS, ls.size(), ls);
		}catch(Exception ex){
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,
					MessageCode.SELECT_ORGAN_FAIL, 0, null);
		}
	} 
	
	@RequestMapping(value = "/getdutyProperty.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String getdutyProperty() throws Exception {
		try {
			List<DutyProperty> list = dutyService.selectdutyProperty();
			JSONArray result = JSONArray.fromObject(list);
			return result.toString();
		} catch (Exception ex) {
			return "";
		}
	}
	 
}
