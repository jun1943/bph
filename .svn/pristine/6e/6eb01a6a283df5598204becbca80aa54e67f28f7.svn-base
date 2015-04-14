package com.tianyi.bph.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.dao.system.AutoUpdateDAO;
import com.tianyi.bph.domain.system.autoUpdate.UpdateConfig;
import com.tianyi.bph.domain.system.autoUpdate.VersionFile;
import com.tianyi.bph.service.system.AutoUpdateService;

@Service
public class AutoUpdateServiceImpl implements AutoUpdateService {
	
	@Autowired AutoUpdateDAO autoUpdateDAO;
	
	@Override
	public List<VersionFile> queryVersion(String version) {
//		int n = autoUpdateDAO.getCount(version);
//		if(n == 0){
//		}
		List<VersionFile> list = autoUpdateDAO.queryVersion(version);
		return list;
	}

	@Override
	public List<UpdateConfig> queryUpdateConfig(String version) {
		
		return autoUpdateDAO.queryUpdateConfig(version);
	}

}
