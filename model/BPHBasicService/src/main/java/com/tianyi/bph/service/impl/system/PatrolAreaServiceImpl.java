package com.tianyi.bph.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.common.Pager;
import com.tianyi.bph.dao.system.PatrolAreaDAO;
import com.tianyi.bph.domain.system.PatrolArea;
import com.tianyi.bph.query.system.PatrolAreaQuery;
import com.tianyi.bph.service.system.PatrolAreaService;

/**
 * 巡逻区域
 * 
 * @author Administrator
 *
 */
@Service
public class PatrolAreaServiceImpl implements PatrolAreaService{

	@Autowired PatrolAreaDAO patrolAreaDao;
	
	//增
	public int addPatrolArea(PatrolArea patrolArea){
		PatrolAreaQuery patrolAreaQuery = new PatrolAreaQuery();
		patrolAreaQuery.setName(patrolArea.getName());
		int count = patrolAreaDao.getUniqueCountByQuery(patrolAreaQuery);
		if (count > 0) {
			return -1;
		}
		patrolAreaDao.insert(patrolArea);
		int id = patrolArea.getId();
		return id;
	}
	
	//删
	public int deletePatrolArea(Integer id){
		int i = patrolAreaDao.deleteByPrimaryKey(id);
		return i;
	}
	//改
	public int updatePatrolArea(PatrolArea patrolArea){
		PatrolAreaQuery patrolAreaQuery = new PatrolAreaQuery();
		patrolAreaQuery.setName(patrolArea.getName());
		int count = patrolAreaDao.getUniqueCountByQuery(patrolAreaQuery);
		if(count==0){
			return 0;
		}
		int id = patrolAreaDao.updateByPrimaryKeySelective(patrolArea);
		return id;
	}
	
	//查
	public PatrolArea getPatrolAreaById(Integer id){
		return patrolAreaDao.selectById(id);
	}
	
	//分页查询
	public Pager<PatrolArea> getPageList(PatrolAreaQuery query){
		Pager<PatrolArea> page = new Pager<PatrolArea>(query.getPageSize(),	query.getPageNo());
		page.setTotalRows(patrolAreaDao.findCount(query));	// 总条数
		page.setData(patrolAreaDao.findByPage(query));		// 数据
		page.setPageNo(query.getPageNo());
		return page;
	}
	
	//条件查询
	public List<PatrolArea> getQueryList(PatrolAreaQuery query){
		return patrolAreaDao.findByQuery(query);
	}
	
}
