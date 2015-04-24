package com.tianyi.bph.web.controller.dutydata;
 

import java.util.HashMap;
import java.util.List;
import java.util.Map; 
import javax.servlet.http.HttpServletRequest; 
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

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
	 * 报备模板的加载获取赋值报备数据信息
	 * 
	 * @param orgId
	 *            组织机构id
	 * @param ymd
	 *            日期
	 * @param id
	 *            传入的id值，若id不等于空，则是通过模板选择来加载报备数据，若id为空，则通过报备复制加载报备数据
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
	 * 加载当前组织机构下已保存的模板
	 * 
	 * @param orgId
	 *            组织机构id
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
	 * 保存报备明细数据
	 * 
	 * @param dvm
	 *            前台构建对象
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
	 * 加载当前勤务类型的关联任务属性
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
}
