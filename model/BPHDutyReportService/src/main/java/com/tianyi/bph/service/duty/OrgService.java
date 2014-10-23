package com.tianyi.bph.service.duty;

import java.util.List;

import com.tianyi.bph.domain.duty.Org;
import com.tianyi.bph.query.duty.OrgWithGpsVM;
import com.tianyi.bph.query.duty.OrgWithPoliceVM;
import com.tianyi.bph.query.duty.OrgWithVehicleVM;
import com.tianyi.bph.query.duty.OrgWithWeaponVM;
 

/**
 * 组织机构逻辑接口层
 * @author lq
 *
 */
public interface OrgService {

	/**
	 * 根据编码，路径，获取组织机构数据信息
	 * @param code
	 * @param path
	 * @return
	 */
	List<Org> loadSubOrgList(String code,String path);
	
	/**
	 * 根据组织机构id，或组织机构树  + 警员列表，构建树形列表
	 * @param id
	 * @return
	 */
	List<OrgWithPoliceVM> loadOrgWithPoliceVMList(Integer id);
	
	
	/**
	 * 根据组织机构id，或组织机构树  + 车辆列表，构建树形列表
	 * @param id
	 * @return
	 */
	List<OrgWithVehicleVM> loadOrgWithVehicleVMList(Integer id);
	
	/**
	 * 根据组织机构id，或组织机构树  + 武器列表，构建树形列表
	 * @param id
	 * @return
	 */
	List<OrgWithWeaponVM> loadOrgWithWeaponVMList(Integer id);
	
	/**
	 * 根据组织机构id，或组织机构树  + 定位设备列表，构建树形列表
	 * @param id
	 * @return
	 */
	List<OrgWithGpsVM> loadOrgWithGpsVMList(Integer id);

	Org selectByPrimaryKey(Integer qid);
}
