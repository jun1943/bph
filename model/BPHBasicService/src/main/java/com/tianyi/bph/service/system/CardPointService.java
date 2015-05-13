package com.tianyi.bph.service.system;

import java.util.List;

import com.tianyi.bph.common.Pager;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.domain.system.CardPoint;
import com.tianyi.bph.domain.system.CardPointCamera;
import com.tianyi.bph.domain.system.CardPointHead;
import com.tianyi.bph.domain.system.CircleLayer;
import com.tianyi.bph.domain.system.TCardPoint;
import com.tianyi.bph.query.system.CardPointQuery;
import com.tianyi.bph.query.system.TCardPointExample;

/**
 * 卡点
 * 
 * @author Administrator
 * 
 */
public interface CardPointService {

	// 增
	public CardPoint addCardPoint(CardPoint cardPoint);

	// 删
	public int deleteCardPoint(Integer id);

	// 改
	public CardPoint updateCardPoint(CardPoint cardPoint);

	// 查
	public CardPoint getCardPointById(Integer id);

	// 是否重复
	public ReturnResult isUnique(CardPointQuery cardPointQuery);

	// 分页查询
	public Pager<CardPoint> getPageList(CardPointQuery query);

	// 查询总的记录数
	public int getCount(CardPointQuery query);

	// 条件查询
	public List<CardPoint> getQueryList(CardPointQuery query);

	// 客户端查询接口
	public List<CardPoint> queryCardPointList(int organId);

	public int queryCardPointTotal();

	// 增加卡点负责人
	public void addCardPointHead(CardPointHead cardPointHead);

	// 清除卡点负责人
	public void deleteCardPointHead(int cardPointHead);

	// 清除卡点天网
	public void deleteCardPointCamera(int cardPointHead);

	// 查询卡点负责人
	public List<CardPointHead> getCardPointHead(int cardPointId);

	// 查询卡点天网
	public List<CardPointCamera> getCardPointCamera(int cardPointId);

	// 增加卡点天网
	// public void addCardPointCamera(CardPointCamera camera);

	// 圈层查询
	public List<CircleLayer> getCircleLayerList();

	// 修改卡点坐标
	public int modifyCardPointCoordinate(CardPoint cardPoint);

	// =================================by chen==========================

	/**
	 * 
	 * @param cardPoint
	 * @return TCardPoint
	 * @author chen
	 */
	public TCardPoint insertCardPoint(TCardPoint cardPoint);

	/**
	 * 
	 * @param query
	 * @return
	 * @author chen
	 */
	public List<TCardPoint> getCardPointList(TCardPointExample example);

	/**
	 * 获取记录数量
	 * 
	 * @param example
	 * @return
	 */
	public int getCardPointListCount(TCardPointExample example);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public int deleteCardPointById(Integer id);

	/**
	 * 查
	 * 
	 * @param id
	 * @return
	 */
	public TCardPoint getCardPointByparamKey(Integer id);

	/**
	 * 
	 * @param cardPoint
	 * @return
	 */
	public TCardPoint updateCardPoint(TCardPoint cardPoint);

	public TCardPoint updateCardPointKeySelective(TCardPoint cardPoint);

	List<Integer> getCardPointUser(Integer cardPointId);

	List<Integer> getCardPointCamera(Integer cardPointId);

}
