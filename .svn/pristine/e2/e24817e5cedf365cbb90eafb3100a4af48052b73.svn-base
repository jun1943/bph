package com.tianyi.bph.dao.system;


import java.util.List;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.autoUpdate.UpdateConfig;
import com.tianyi.bph.domain.system.autoUpdate.VersionFile;

/**
 * 自动升级
 * 
 * @author Administrator
 *
 */

@MyBatisRepository
public interface AutoUpdateDAO {
	
	public int getCount(String version);
	
	public List<VersionFile> queryVersion(String version);
	
	public List<UpdateConfig> queryUpdateConfig(String version);

}
