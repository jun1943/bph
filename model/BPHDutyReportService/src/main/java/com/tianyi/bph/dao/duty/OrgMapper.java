package com.tianyi.bph.dao.duty;

import java.util.List;
import java.util.Map;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.duty.Org;
import com.tianyi.bph.query.duty.OrgWithGpsVM;
import com.tianyi.bph.query.duty.OrgWithPoliceVM;
import com.tianyi.bph.query.duty.OrgWithVehicleVM;
import com.tianyi.bph.query.duty.OrgWithWeaponVM;
import com.tianyi.bph.query.duty.OrganGroupVM;
 
/**
 * 组织机构映射类
 * @author lq
 *
 */
@MyBatisRepository
public interface OrgMapper {

	/**
	 * 获取当期组织机构下级单位
	 * @param map
	 * @return
	 */
	List<Org> loadSubOrgList(Map<String,Object> map);
	
	/**
	 * 根据id获取组织机构下面的警员
	 * @param id
	 * @return
	 */
	List<OrgWithPoliceVM> loadOrgWithPoliceVMList(Integer id);


	/**
	 * 根据id获取组织机构下面的车辆
	 * @param id
	 * @return
	 */
	List<OrgWithVehicleVM> loadOrgWithVehicleVMList(Integer id);

	/**
	 * 根据id获取组织机构下面的武器
	 * @param id
	 * @return
	 */
	List<OrgWithWeaponVM> loadOrgWithWeaponVMList(Integer id);

	/**
	 * 根据id获取组织机构下面的定位设备
	 * @param id
	 * @return
	 */
	List<OrgWithGpsVM> loadOrgWithGpsVMList(Integer id);

	Org selectByPrimaryKey(Integer qid);

	List<OrganGroupVM> loadOrgVehicleGroupVMList(Map<String, Object> map);

	List<OrganGroupVM> loadOrgPoliceGroupVMList(Map<String, Object> map);

	List<OrganGroupVM> loadOrgWeaponGroupVMList(Map<String, Object> map);

	List<OrganGroupVM> loadOrgGpsGroupVMList(Map<String, Object> map);
}
