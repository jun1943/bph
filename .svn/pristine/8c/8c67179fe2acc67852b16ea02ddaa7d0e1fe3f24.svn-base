package com.tianyi.bph.service.impl.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.dao.system.UserAddModuleDAO;
import com.tianyi.bph.domain.system.UserAddModuleKey;
import com.tianyi.bph.service.system.UserAddModuleService;



@Service
public class UserAddModuleServiceImpl implements UserAddModuleService{

	@Autowired UserAddModuleDAO userAddModuleDao;
	
	
	//分配用户权限
	public void allotUserModules(Long userId, Integer[] modulesId){
		
		userAddModuleDao.deleteByUserKey(userId);
		if (null != modulesId) {
			UserAddModuleKey userAddModuleKey = new UserAddModuleKey();
			for (Integer moduleId : modulesId) {
				userAddModuleKey.setUserId(userId);
				userAddModuleKey.setModFunId(moduleId);
				userAddModuleDao.insert(userAddModuleKey);
			}
		}
		
	}
	
	//根据人员删除
	public void deleteByUserKey(Long userId){
		userAddModuleDao.deleteByUserKey(userId);
	}
	

}
