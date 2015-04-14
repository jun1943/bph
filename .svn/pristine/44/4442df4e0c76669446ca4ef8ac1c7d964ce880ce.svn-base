package com.tianyi.bph.service.impl.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.dao.system.RoleModuleFuctionDAO;
import com.tianyi.bph.domain.system.RoleModuleFuctionKey;
import com.tianyi.bph.exception.RestException;
import com.tianyi.bph.service.system.RoleModuleFuctionService;



@Service
public class RoleModuleFuctionServiceImpl implements RoleModuleFuctionService{

	private static final Logger logger =LoggerFactory.getLogger(RoleModuleFuctionServiceImpl.class);
	
	@Autowired RoleModuleFuctionDAO roleModuleFuctionDao;
	
	//增
	public void addRoleModuleFuctionKey(RoleModuleFuctionKey roleModuleFuctionKey){
		roleModuleFuctionDao.insert(roleModuleFuctionKey);
	}
	//删
	public void deleteRoleModuleFuctionKey(RoleModuleFuctionKey roleModuleFuctionKey){
		roleModuleFuctionDao.deleteByPrimaryKey(roleModuleFuctionKey);
	}
	
	//分配角色权限
	public void allotRoleModules(Integer roleId, List<Integer> modulesId){
		
		roleModuleFuctionDao.deleteByRoleKey(roleId);
		RoleModuleFuctionKey roleModuleFuctionKey = new RoleModuleFuctionKey();
		for (Integer moduleId : modulesId) {
			roleModuleFuctionKey.setRoleid(roleId);
			roleModuleFuctionKey.setModFunId(moduleId);
			roleModuleFuctionDao.insert(roleModuleFuctionKey);
		}
		
	}
	/**
	 * 通过角色id获取功能模块
	 * @param roleId
	 * @return
	 */
	public List<RoleModuleFuctionKey> getModuleFunListByRoleId(Integer roleId){
		if(roleId ==null){
			logger.debug("roleId 不能为空");
			throw new RestException(RestException.ERROR_FIELD_FORMAT);
		}
		return roleModuleFuctionDao.getModuleFunListByRoleId(roleId);
	}

}
