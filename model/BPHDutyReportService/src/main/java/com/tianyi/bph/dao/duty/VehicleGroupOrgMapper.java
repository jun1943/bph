package com.tianyi.bph.dao.duty;

import java.util.List;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.duty.VehicleGroupOrg;
 
/**
 * 车辆分组对应组织映射类
 * @author lq
 *
 */
@MyBatisRepository
public interface VehicleGroupOrgMapper {
    
	/**
	 * 根据id，删除对象
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 插入新的关系对象
	 * @param record
	 * @return
	 */
    int insert(VehicleGroupOrg record);

    /**
     * 插入新的关系对象
     * @param record
     * @return
     */
    int insertSelective(VehicleGroupOrg record);

    /**
     * 根据id，获取分组对应组织信息
     * @param id
     * @return
     */
    VehicleGroupOrg selectByPrimaryKey(Integer id);

    /**
     * 更新对象
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(VehicleGroupOrg record);

    /**
     * 更新对象
     * @param record
     * @return
     */
    int updateByPrimaryKey(VehicleGroupOrg record);
 

    /**
     * 根据分组id，删除对应关系
     * 
     * @param id
     */
	void deleteByPGId(Integer id);

	/**
	 * 根据组织机构，获取车辆分组列表
	 * @param pgid
	 * @return
	 */
	List<VehicleGroupOrg> loadVehicleGroupOrgByPGId(int pgid); 
}