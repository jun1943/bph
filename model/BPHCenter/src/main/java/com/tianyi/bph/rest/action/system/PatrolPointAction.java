package com.tianyi.bph.rest.action.system;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.common.JsonUtils;
import com.tianyi.bph.common.Pager;
import com.tianyi.bph.domain.system.PatrolPoint;
import com.tianyi.bph.query.system.PatrolPointQuery;
import com.tianyi.bph.service.system.PatrolPointService;
import com.tianyi.bph.common.ReturnResult;

/**
 * 必达点位
 *
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/patrolPoint")
public class PatrolPointAction {

	static final Logger log = LoggerFactory.getLogger(PatrolPointAction.class);

	@Autowired PatrolPointService patrolPointService;

	/**
	 * 添加必达点位
	 * @param PatrolPoint @
	 * @
	 * @return
	 */
	@RequestMapping(value = "/addPatrolPoint.do")
	@ResponseBody
	public ReturnResult addPatrolPoint(PatrolPoint patrolPoint) {
		patrolPoint.setCoordinate("coordinate");
		patrolPoint.setName("测试");
		patrolPoint.setNote("note");
		patrolPoint.setPatrolAreaId(10);
		patrolPoint.setRadius("radius");
		int i = patrolPointService.addPatrolPoint(patrolPoint);
		if(i < 0){
			return ReturnResult.FAILUER("必达点位名称重复");
		}
		return ReturnResult.SUCCESS();
	}
	
	/**
	 * 删除必达点位
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deletePatrolPoint.do")
	@ResponseBody
	public ReturnResult deletePatrolPoint(
			@RequestParam(value = "id", required =true) Integer id) {
		patrolPointService.deletePatrolPoint(id);
		return ReturnResult.SUCCESS();
	}
	
	/**
	 * 修改必达点位信息
	 * @param PatrolPoint
	 * @return
	 */
	@RequestMapping(value = "/modifyPatrolPoint.do")
	@ResponseBody
	public ReturnResult modifyPatrolPoint(PatrolPoint patrolPoint) {
		int i = patrolPointService.updatePatrolPoint(patrolPoint);
		return ReturnResult.SUCCESS("", i);
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryPatrolPointDetail.do")
	@ResponseBody
	public ReturnResult queryPatrolPointDetail(@RequestParam(value = "id", required =true) Integer id) {
		PatrolPoint patrolPoint = patrolPointService.getPatrolPointById(id);
		return ReturnResult.SUCCESS("", patrolPoint);
	}
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/queryPatrolPointPageList.do")
	@ResponseBody
	public ReturnResult queryPatrolPointPageList(PatrolPointQuery query) {
		Pager<PatrolPoint> page = patrolPointService.getPageList(query);
		return ReturnResult.SUCCESS("", page);
	}
	
	/**
	 * 条件查询
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/queryPatrolPointList.do")
	@ResponseBody
	public ReturnResult queryPatrolPointList(PatrolPointQuery query) {
		List<PatrolPoint> patrolPoints = patrolPointService.getQueryList(query);
		return ReturnResult.SUCCESS("", patrolPoints);
	}

}
