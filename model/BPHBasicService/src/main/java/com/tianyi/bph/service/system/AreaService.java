package com.tianyi.bph.service.system;

import java.util.List;

import com.tianyi.bph.domain.system.Area;
import com.tianyi.bph.domain.system.AreaPoint;
import com.tianyi.bph.query.system.AreaExample;

/**
 * 巡区 社区 辖区 service
 * 
 * @author Administrator
 * 
 */
public interface AreaService {

	/**
	 * 添加 区域
	 * 
	 * @param area
	 * @return
	 */
	public Area addArea(Area area);

	/**
	 * 查询区域信息
	 * 
	 * @param example
	 * @return
	 */
	public List<Area> selectByExample(AreaExample example);

	/**
	 * 查询区域 详细信息
	 * 
	 * @param id
	 * @return
	 */
	public Area queryByPrimaryKey(Integer id);

	/**
	 * 更新区域
	 * 
	 * @param record
	 * @return
	 */
	public Area updateByPrimaryKey(Area record);

	/**
	 * 删除区域
	 * 
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id);

	/**
	 * 获取巡区By 机构id
	 * 
	 * @param organId
	 * @return
	 */
	public List<Area> selectByOrganId(Integer organId);

	/**
	 * 创建必达点
	 * 
	 * @param areaPoint
	 * @return
	 */
	public AreaPoint addAreaPoint(AreaPoint areaPoint);

	/**
	 * 创建必达点
	 * 
	 * @param areaPoint
	 * @return
	 */
	public List<AreaPoint> queryAreaPointList(Integer areaId);

	/**
	 * 修改必达点
	 * 
	 * @param point
	 * @return
	 */
	public AreaPoint updateAreaPoint(AreaPoint point);

	public int deleteAreaPoint(Integer areaPointId);

}
