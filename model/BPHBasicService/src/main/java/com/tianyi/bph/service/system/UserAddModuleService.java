package com.tianyi.bph.service.system;


public interface UserAddModuleService {

	//分配用户权限
	public void allotUserModules(Long userId, Integer[] modulesId);
	
	//根据人员删除
	public void deleteByUserKey(Long userId);
	

}
