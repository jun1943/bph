package com.tianyi.bph.dao.basicdata;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.basicdata.VehicleType;
 
/*
 * 车辆类型映射文件类
 */
@MyBatisRepository
public interface VehicleTypeMapper {
	/*
	 * 根据主键删除车辆类型对象
	 */
	int deleteByPrimaryKey(Integer id);
	/*
	 * 插入新的 车辆对象
	 */
    int insert(VehicleType record);
	/*
	 * 插入新的查询对象集
	 */
    int insertSelective(VehicleType record);
	/*
	 * 根据主键获取车辆类型对象
	 */
    VehicleType selectByPrimaryKey(Integer id);
	/*
	 * 根据主键更新车辆类型对象
	 */
    int updateByPrimaryKeySelective(VehicleType record);
	/*
	 * 根据主键更新车辆类型对象
	 */
    int updateByPrimaryKey(VehicleType record);
}