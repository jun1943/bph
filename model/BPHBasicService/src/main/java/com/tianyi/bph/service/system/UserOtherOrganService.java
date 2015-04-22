package com.tianyi.bph.service.system;

import java.util.List;

public interface UserOtherOrganService {
	//用户跨机构分配
		public void allotUserOtherOrgans(Long userId, Integer[] organIds);
		
		/**
		 * 通过用户id获取跨机构Id列表
		 * @param userId
		 * @return
		 */
		public List<String> getOrganIdByUserId(Long userId);
		
		/**
		 * 通过用户id获取跨机构Id列表
		 * @param userId
		 * @return
		 */
		public String getOrganIdsByUserId(Long userId);
}
