package com.tianyi.bph.service.impl.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.dao.system.UserRoleDAO;
import com.tianyi.bph.domain.system.UserRoleKey;
import com.tianyi.bph.exception.RestException;
import com.tianyi.bph.service.system.UserRoleService;


@Service
public class UserRoleServiceImpl implements UserRoleService{

	private static final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);
	
	@Autowired UserRoleDAO userRoleDao;
	
	//增
	public void addUserRole(UserRoleKey userRoleKey){
		userRoleDao.insert(userRoleKey);
	}
	
	//删
	public void deleteUserRole(UserRoleKey userRoleKey){
		userRoleDao.deleteByPrimaryKey(userRoleKey);
	}
	
	//根据人员删除
	public void deleteByUserKey(Long userId){
		userRoleDao.deleteByUserKey(userId);
	}
	
	
	
	//分配用户角色
	public void allotUserRoles(Long userId, Integer[] rolesId){
		userRoleDao.deleteByUserKey(userId);
		
		if (null != rolesId) {
			UserRoleKey userRoleKey = new UserRoleKey();
			
			for (Integer roleId : rolesId) {
				userRoleKey.setUserId(userId);
				userRoleKey.setRoleId(roleId);
				userRoleDao.insert(userRoleKey);
			}
		}
	}

	@Override
	public List<String> getFunctionsByUserId(Long userId) {
		// TODO Auto-generated method stub
		if(userId==null){
			logger.debug("userId 不能为空");
			throw new RestException(RestException.ERROR_FIELD_FORMAT);
		}
		return userRoleDao.getFunctionsByUserId(userId);
	}

}
