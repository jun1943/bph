package com.tianyi.bph.service.impl.system;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianyi.bph.common.Constants;
import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.Pager;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.common.annotation.MQDataInterceptor;
import com.tianyi.bph.dao.system.CardPointDAO;
import com.tianyi.bph.domain.system.CardPoint;
import com.tianyi.bph.domain.system.CardPointCamera;
import com.tianyi.bph.domain.system.CardPointHead;
import com.tianyi.bph.domain.system.CircleLayer;
import com.tianyi.bph.query.system.CardPointQuery;
import com.tianyi.bph.service.system.CardPointService;

/**
 * 卡点
 * 
 * @author Administrator
 *
 */
@Service
public class CardPointServiceImpl implements CardPointService{

@Autowired CardPointDAO cardPointDao;
	
	//增
	@Override
	@MQDataInterceptor(type = Constants.MQ_TYPE_CARDPOINT, operate = Constants.MQ_OPERATE_ADD)
	@Transactional(readOnly = false)
	public CardPoint addCardPoint(CardPoint cardPoint){
		CardPointQuery cardPointQuery = new CardPointQuery();
		cardPointQuery.setName(cardPoint.getName());
		int count = cardPointDao.getUniqueCountByQuery(cardPointQuery);
		if (count > 0) {
			return null;
		}
		cardPoint.setCreateTime(new Date());
		cardPointDao.insert(cardPoint);
		return cardPoint;
	}
	
	//删
	@Override
	@MQDataInterceptor(type = Constants.MQ_TYPE_CARDPOINT, operate = Constants.MQ_OPERATE_DELETE)
	@Transactional(readOnly = false)
	public int deleteCardPoint(Integer id){
		cardPointDao.deleteCardPointHead(id);
		cardPointDao.deleteCardPointCamera(id);
		cardPointDao.deleteByPrimaryKey(id);
		return id;
	}
	//改
	@Override
	@MQDataInterceptor(type = Constants.MQ_TYPE_CARDPOINT, operate = Constants.MQ_OPERATE_UPDATE)
	@Transactional(readOnly = false)
	public CardPoint updateCardPoint(CardPoint cardPoint){
		CardPointQuery cardPointQuery = new CardPointQuery();
		cardPointQuery.setId(cardPoint.getCardPointId());
		cardPointQuery.setName(cardPoint.getName());
		int count = cardPointDao.getUniqueCountByQuery(cardPointQuery);
		if(count != 0){
			return null;
		}
		cardPoint.setUpdateTime(new Date());
		cardPointDao.updateByPrimaryKeySelective(cardPoint);
		return cardPoint;
	}
	
	//查
	public CardPoint getCardPointById(Integer id){
		return cardPointDao.selectById(id);
	}
	
	//是否重复
	public ReturnResult isUnique(CardPointQuery cardPointQuery){
		
		int count = cardPointDao.getUniqueCountByQuery(cardPointQuery);
		if (count > 0) {
			return ReturnResult.MESSAGE(MessageCode.STATUS_NOTUNIQUE, "卡点名称重复");
		}
		return ReturnResult.SUCCESS(MessageCode.STATUS_SUCESS);
	}
	
	//分页查询
	public Pager<CardPoint> getPageList(CardPointQuery query){
		Pager<CardPoint> page = new Pager<CardPoint>(query.getPageSize(), query.getPageNo());
		page.setTotalRows(cardPointDao.findCount(query));	// 总条数
		page.setData(cardPointDao.findByPage(query));		// 数据
		page.setPageNo(query.getPageNo());
		return page;
	}
	
	//条件查询
	public List<CardPoint> getQueryList(CardPointQuery query){
		return cardPointDao.findByQuery(query);
	}
	
	//查询总条数
	public int queryCardPointTotal(){
		return cardPointDao.queryCardPointTotal();
	}
	
	//客户端查询接口
	public List<CardPoint> queryCardPointList(int organId){
		return cardPointDao.queryCardPointList(organId);
	}

	@Override
	public void addCardPointHead(CardPointHead cardPointHead) {
		cardPointDao.addCardPointHead(cardPointHead);
	}
	@Override
	public void deleteCardPointHead(int cardPointHead){
		cardPointDao.deleteCardPointHead(cardPointHead);
	}
	
	@Override
	public void deleteCardPointCamera(int cardPoint){
		cardPointDao.deleteCardPointCamera(cardPoint);
	}
	
	//查询卡点负责人
	@Override
	public List<CardPointHead> getCardPointHead(int cardPointId){
		return cardPointDao.getCardPointHead(cardPointId);
	}
	
	public List<CardPointCamera> getCardPointCamera(int cardPointId){
		return cardPointDao.getCardPointCamera(cardPointId);
	}
	
	public void addCardPointCamera(CardPointCamera camera){
		cardPointDao.addCardPointCamera(camera);
	}
	
	public List<CircleLayer> getCircleLayerList(){
		return cardPointDao.getCircleLayerList();
	}
	
	public int modifyCardPointCoordinate(CardPoint cardPoint){
		return cardPointDao.modifyCardPointCoordinate(cardPoint);
	}

	@Override
	public int getCount(CardPointQuery query) {
		// TODO Auto-generated method stub
		return cardPointDao.findCount(query);
	}
}
