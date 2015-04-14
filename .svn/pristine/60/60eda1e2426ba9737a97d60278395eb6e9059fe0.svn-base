package com.tianyi.bph.service.system;

import java.util.List;

import com.tianyi.bph.common.Pager;
import com.tianyi.bph.common.ReturnResult;

import com.tianyi.bph.domain.system.PatrolPoint;
import com.tianyi.bph.query.system.PatrolPointQuery;

/**
 * 必达点位
 * 
 * @author Administrator
 *
 */

public interface PatrolPointService {

	
	//增
	public int addPatrolPoint(PatrolPoint patrolPoint);
	
	//删
	public int deletePatrolPoint(Integer id);
	//改
	public int updatePatrolPoint(PatrolPoint patrolPoint);
	
	//查
	public PatrolPoint getPatrolPointById(Integer id);
	
	//是否重复
	public ReturnResult isUnique(PatrolPointQuery PatrolPointQuery);
	
	//是否有子机构
	public ReturnResult hasChild(Integer parentId);
	
	//分页查询
	public Pager<PatrolPoint> getPageList(PatrolPointQuery query);
	
	//条件查询
	public List<PatrolPoint> getQueryList(PatrolPointQuery query);

}
