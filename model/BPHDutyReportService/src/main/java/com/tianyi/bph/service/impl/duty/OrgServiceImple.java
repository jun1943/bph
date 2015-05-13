package com.tianyi.bph.service.impl.duty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tianyi.bph.dao.duty.OrgMapper;
import com.tianyi.bph.domain.duty.Org;
import com.tianyi.bph.query.duty.OrgWithGpsVM;
import com.tianyi.bph.query.duty.OrgWithPoliceVM;
import com.tianyi.bph.query.duty.OrgWithVehicleVM;
import com.tianyi.bph.query.duty.OrgWithWeaponVM;
import com.tianyi.bph.query.duty.OrganGroupVM;
import com.tianyi.bph.service.duty.OrgService;
 
/**
 * 组织机构逻辑接口实现
 * @author lq
 *
 */
@Service("orgService")
public class OrgServiceImple implements OrgService {

	@Resource(name = "orgMapper")
	private OrgMapper orgMapper;

	/**
	 * 根据编码、路径获取组织机构列表
	 */
	public List<Org> loadSubOrgList(String code, String path) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("orgCode", code);
		map.put("orgPath", path);

		List<Org> ls = orgMapper.loadSubOrgList(map);

		return ls;
	}

	/**
	 * 根据id，获取组织机构，以及警员成员，构建树状结构列表
	 */
	public List<OrgWithPoliceVM> loadOrgWithPoliceVMList(Integer id) {
		List<OrgWithPoliceVM> ls = orgMapper.loadOrgWithPoliceVMList(id);
		return ls;
	}

	/**
	 * 根据id，获取组织机构，以及车辆成员，构建树状结构列表
	 */
	public List<OrgWithVehicleVM> loadOrgWithVehicleVMList(Integer id) {
		List<OrgWithVehicleVM> ls = orgMapper.loadOrgWithVehicleVMList(id);
		return ls;
	}

	/**
	 * 根据id，获取组织机构，以及武器成员，构建树状结构列表
	 */
	public List<OrgWithWeaponVM> loadOrgWithWeaponVMList(Integer id) {
		List<OrgWithWeaponVM> ls = orgMapper.loadOrgWithWeaponVMList(id);
		return ls;
	}

	/**
	 * 根据id，获取组织机构，以及定位设备成员，构建树状结构列表
	 */
	public List<OrgWithGpsVM> loadOrgWithGpsVMList(Integer id) {
		List<OrgWithGpsVM> ls = orgMapper.loadOrgWithGpsVMList(id);
		return ls;
	}

	public Org selectByPrimaryKey(Integer qid) {
		// TODO Auto-generated method stub
		return orgMapper.selectByPrimaryKey(qid);
	}
 
	public List<OrganGroupVM> loadOrgVehicleGroupVMList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orgMapper.loadOrgVehicleGroupVMList(map);
	}
	 
		public List<OrganGroupVM> loadOrgPoliceGroupVMList(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return orgMapper.loadOrgPoliceGroupVMList(map);
		}
		 
		public List<OrganGroupVM> loadOrgWeaponGroupVMList(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return orgMapper.loadOrgWeaponGroupVMList(map);
		}

		public List<OrganGroupVM> loadOrgGpsGroupVMList(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return orgMapper.loadOrgGpsGroupVMList(map);
		}



}
