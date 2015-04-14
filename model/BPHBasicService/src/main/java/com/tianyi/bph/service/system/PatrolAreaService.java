package com.tianyi.bph.service.system;

import java.util.List;

import com.tianyi.bph.common.Pager;
import com.tianyi.bph.domain.system.PatrolArea;
import com.tianyi.bph.query.system.PatrolAreaQuery;

/**
 * 巡逻区域
 * 
 * @author Administrator
 *
 */
public interface PatrolAreaService {

	//增
	public int addPatrolArea(PatrolArea patrolArea);
	
	//删
	public int deletePatrolArea(Integer id);
	//改
	public int updatePatrolArea(PatrolArea patrolArea);
	
	//查
	public PatrolArea getPatrolAreaById(Integer id);
	
	//分页查询
	public Pager<PatrolArea> getPageList(PatrolAreaQuery query);
	
	//条件查询
	public List<PatrolArea> getQueryList(PatrolAreaQuery query);
	
}
