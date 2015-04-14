package com.tianyi.bph.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.dao.system.UserOtherOrganDAO;
import com.tianyi.bph.domain.system.UserOtherOrgan;
import com.tianyi.bph.service.system.UserOtherOrganService;

@Service
public class UserOtherOrganServiceImpl implements UserOtherOrganService{
	
	@Autowired UserOtherOrganDAO userOtherOrganDao;

	public void allotUserOtherOrgans(Long userId, Integer[] organIds) {
		// TODO Auto-generated method stub
		
		userOtherOrganDao.deleteByUserKey(userId);
		if (null != organIds) {
			UserOtherOrgan userOtherOgan = new UserOtherOrgan();
			for (Integer organId : organIds) {
				userOtherOgan.setUserId(userId);
				userOtherOgan.setOrganId(organId);
				userOtherOrganDao.insert(userOtherOgan);
			}
		}
		
	}

	@Override
	public List<String> getOrganIdByUserId(Long userId) {
		// TODO Auto-generated method stub
		return userOtherOrganDao.getOrganIdByUserId(userId);
	}

	@Override
	public String getOrganIdsByUserId(Long userId) {
		// TODO Auto-generated method stub
		return userOtherOrganDao.getOrganIdsByUserId(userId);
	}

}
