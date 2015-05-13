package com.tianyi.bph.rest.action.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.BaseLogController;
import com.tianyi.bph.common.JsonUtils;
import com.tianyi.bph.common.Pager;
import com.tianyi.bph.domain.system.PatrolArea;
import com.tianyi.bph.query.system.PatrolAreaQuery;
import com.tianyi.bph.service.system.PatrolAreaService;
import com.tianyi.bph.web.controller.BaseController;
import com.tianyi.bph.common.ReturnResult;

/**
 * 巡逻区域
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/patrolArea")
public class PatrolAreaAction extends BaseLogController{

	static final Logger log = LoggerFactory.getLogger(PatrolAreaAction.class);

	@Autowired PatrolAreaService patrolAreaService;

	/**
	 * 添加巡逻区域
	 * @param patrolArea
	 * @return
	 */
	@RequestMapping(value = "/addPatrolArea.do")
	@ResponseBody
	public ReturnResult addPatrolArea(PatrolArea patrolArea,HttpServletRequest request) {
		patrolArea.setBackColor("backColor");
		patrolArea.setBackTransparence("backTransparence");
		patrolArea.setCoordinates("coordinates");
		patrolArea.setLineColor("lineColor");
		patrolArea.setLineTransparence("lineTransparence");
		patrolArea.setName("测试");
		patrolArea.setNote("note");
		patrolArea.setOrganId(10);
		int i = patrolAreaService.addPatrolArea(patrolArea);
		if(i < 0){
			return ReturnResult.FAILUER("巡逻区域名称重复");
		}
		addLog(request, "添加巡逻区域成功", 2);
		return ReturnResult.SUCCESS();
	}
	
	/**
	 * 删除巡逻区域
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deletePatrolArea.do")
	@ResponseBody
	public ReturnResult deletePatrolArea(@RequestParam(value = "id", required =true) Integer id,
			HttpServletRequest request) {
		int i = patrolAreaService.deletePatrolArea(id);
		if(i == 0){
			return ReturnResult.FAILUER("删除数据不存在");
		}
		addLog(request, "删除巡逻区域成功", 2);
		return ReturnResult.SUCCESS("成功", i);
	}
	
	/**
	 * 修改巡逻区域信息
	 * @param PatrolArea
	 * @return
	 */
	@RequestMapping(value = "/modifyPatrolArea.do")
	@ResponseBody
	public ReturnResult modifyPatrolArea(PatrolArea patrolArea,HttpServletRequest request) {
		int i = patrolAreaService.updatePatrolArea(patrolArea);
		addLog(request, "修改巡逻区域成功", 2);
		return ReturnResult.SUCCESS("", i);
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryPatrolAreaDetail.do")
	@ResponseBody
	public ReturnResult queryPatrolAreaDetail(@RequestParam(value = "id", required =true) Integer id) {
		PatrolArea patrolArea = patrolAreaService.getPatrolAreaById(id);
		return ReturnResult.SUCCESS("", patrolArea);
	}
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/queryPatrolAreaPageList.do")
	@ResponseBody
	public ReturnResult queryPatrolAreaPageList(PatrolAreaQuery query) {
		Pager<PatrolArea> page = patrolAreaService.getPageList(query);
		return ReturnResult.SUCCESS("", page);
	}
	
	/**
	 * 条件查询
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/queryPatrolAreaList.do")
	@ResponseBody
	public ReturnResult queryPatrolAreaList(PatrolAreaQuery query) {
		List<PatrolArea> patrolAreas = patrolAreaService.getQueryList(query);
		return ReturnResult.SUCCESS("", patrolAreas);
	}

}
