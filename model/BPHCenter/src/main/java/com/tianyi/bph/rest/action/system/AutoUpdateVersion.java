package com.tianyi.bph.rest.action.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.domain.system.autoUpdate.UpdateConfig;
import com.tianyi.bph.domain.system.autoUpdate.VersionFile;
import com.tianyi.bph.service.system.AutoUpdateService;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/version")
public class AutoUpdateVersion {
	
	static final Logger log = LoggerFactory.getLogger(AutoUpdateVersion.class);
	
	@Autowired
	private AutoUpdateService service;

	@RequestMapping(value = "/autoUpdate.do")
	@ResponseBody
	public ReturnResult addArea(@RequestParam(value="version", required=true) String version) {
		List<UpdateConfig> severinfo = service.queryUpdateConfig(version);
		if(severinfo != null && severinfo.size() > 0){
			String currentVersion = severinfo.get(0).getCurrentVersion();
			
			version = version.replace(" ", "");
			currentVersion = currentVersion.replace(" ", "");
			
			if(!(version.compareTo(currentVersion) < 0)){
				severinfo = null;
			}
		}
		
		List<VersionFile> files = service.queryVersion(version);
		List<VersionFile> remove = new ArrayList<VersionFile>();
		if(files != null && files.size() > 0){
			for(VersionFile v : files){
				String versionCode = v.getVersionCode();
				if(version.compareTo(versionCode) > 0){
					remove.add(v);
				}
			}
			files.removeAll(remove);
		}
		
		if(severinfo != null){
			@SuppressWarnings("rawtypes")
			Map<String, List> map = new HashMap<String, List>();
			map.put("severinfo", severinfo);
			map.put("files", files);
			return ReturnResult.SUCCESS(map);
		}else {
			return ReturnResult.SUCCESS("");
		}
	}
	
	public static void main(String args[]){
		String version = "v 4.2.6";
		String versionCode = "v 3.2.5.3";
		
		System.out.print(version.compareTo(versionCode));
	}
}
