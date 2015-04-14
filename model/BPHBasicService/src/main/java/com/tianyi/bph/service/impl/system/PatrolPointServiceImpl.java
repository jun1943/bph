package com.tianyi.bph.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.Pager;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.dao.system.PatrolPointDAO;
import com.tianyi.bph.domain.system.PatrolPoint;
import com.tianyi.bph.query.system.PatrolPointQuery;
import com.tianyi.bph.service.system.PatrolPointService;

/**
 * 必达点位
 * 
 * @author Administrator
 *
 */
@Service
public class PatrolPointServiceImpl implements PatrolPointService{

	@Autowired PatrolPointDAO patrolPointDao;
	
	//增
	public int addPatrolPoint(PatrolPoint patrolPoint){
		PatrolPointQuery patrolPointQuery = new PatrolPointQuery();
		patrolPointQuery.setName(patrolPoint.getName());
		int count = patrolPointDao.getUniqueCountByQuery(patrolPointQuery);
		if (count > 0) {
			return -1;
		}
		patrolPointDao.insert(patrolPoint);
		int id = patrolPoint.getId();
		return id;
	}
	
	//删
	public int deletePatrolPoint(Integer id){
		int i = patrolPointDao.deleteByPrimaryKey(id);
		return i;
	}
	//改
	public int updatePatrolPoint(PatrolPoint patrolPoint){
		PatrolPointQuery patrolPointQuery = new PatrolPointQuery();
		patrolPointQuery.setName(patrolPoint.getName());
		int count=patrolPointDao.getUniqueCountByQuery(patrolPointQuery);
		if(count==0){
			return 0;
		}
		int id = patrolPointDao.updateByPrimaryKeySelective(patrolPoint);
		return id;
	}
	
	//查
	public PatrolPoint getPatrolPointById(Integer id){
		return patrolPointDao.selectById(id);
	}
	
	//是否重复
	public ReturnResult isUnique(PatrolPointQuery PatrolPointQuery){
		
		int count = patrolPointDao.getUniqueCountByQuery(PatrolPointQuery);
		if (count > 0) {
			return ReturnResult.MESSAGE(MessageCode.STATUS_NOTUNIQUE, "机构名或机构代码重复");
		}
		return ReturnResult.SUCCESS(MessageCode.STATUS_SUCESS);
	}
	
	//是否有子机构
	public ReturnResult hasChild(Integer parentId){
		
		int count = patrolPointDao.getChildCount(parentId);
		if (count > 0) {
			return ReturnResult.MESSAGE(MessageCode.STATUS_HASCHILD, "该机构有子节点不能删除");
		}else{
			return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS);
		}
	}
	
	//分页查询
	public Pager<PatrolPoint> getPageList(PatrolPointQuery query){
		Pager<PatrolPoint> page = new Pager<PatrolPoint>(query.getPageSize(), query.getPageNo());
		page.setTotalRows(patrolPointDao.findCount(query));	// 总条数
		page.setData(patrolPointDao.findByPage(query));		// 数据
		page.setPageNo(query.getPageNo());
		return page;
	}
	
	//条件查询
	public List<PatrolPoint> getQueryList(PatrolPointQuery query){
		return patrolPointDao.findByQuery(query);
	}

}
