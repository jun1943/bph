package com.tianyi.bph.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.dao.system.CircleLayerDao;
import com.tianyi.bph.dao.system.TCardPointMapper;
import com.tianyi.bph.domain.system.CircleLayer;
import com.tianyi.bph.exception.RestException;
import com.tianyi.bph.service.system.CircleLayerService;

/**
 * 圈层 
 * 
 * @author Administrator
 *
 */
@Service
@Transactional
public class CircleLayerServiceImpl implements CircleLayerService {

	@Autowired CircleLayerDao circleLayerDao;
	@Autowired private TCardPointMapper cardPointDao;
	
	@Override
	public int addCircleLayer(CircleLayer circleLayer) {
		return circleLayerDao.insert(circleLayer);
	}

	@Override
	public int deleteCircleLayer(Integer id) {
		
		int i=cardPointDao.countCardPointByCircleLayerId(id);
		if(i>0){
			throw new RestException("该圈层下存在卡点,删除失败！");
		}
		return circleLayerDao.deleteByPrimaryKey(id);
	}

	//改
	@Override
	public CircleLayer updateCircleLayer(CircleLayer circleLayer) {
		try{
			int count = circleLayerDao.getUniqueCountByQuery(circleLayer);
			if(count != 0){
				return null;
			}
			circleLayerDao.updateByPrimaryKeySelective(circleLayer);
			return circleLayer;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public CircleLayer getCircleLayerById(int id) {
		return circleLayerDao.getCircleLayerById(id);
	}

	@Override
	public List<CircleLayer> getCircleLayerList(){
		return circleLayerDao.getCircleLayerList();
	}

	@Override
	public ReturnResult isUnique(String name) {
		return null;
	}

}
