package com.tianyi.bph.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.tianyi.bph.bean.GpsOrganBean;
import com.tianyi.bph.service.GpsOrganRelationService;

/**
 * 机构初始化bean
 * 
 * @author Administrator
 *
 */
public class GpsOrganUtil implements InitializingBean {

	@Autowired GpsOrganRelationService service;
	
	private GpsOrganUtil() {}

	private static GpsOrganUtil util = null;
	public static GpsOrganUtil getInstance() {
		if (util == null){
			util = new GpsOrganUtil();
		}
		return util;
	}
	
	// gpsId, gps+organ
	private Map<String, GpsOrganBean> organPathMap = new ConcurrentHashMap<String, GpsOrganBean>();
	
	public Map<String, GpsOrganBean> getOrganPathMap(){
		return organPathMap;
	}
	public synchronized void addOrganPathMap(String key, GpsOrganBean value) {
		this.organPathMap.put(key, value);
	}
	
	public void init() {  
        List<GpsOrganBean> list = service.findGpsMessageList();
        if(list != null && list.size() > 0){
        	for(GpsOrganBean gps:list){
        		String gpsCode = gps.getGpsCode();
        		if(StringUtils.hasText(gpsCode)){
        			GpsOrganUtil.getInstance().addOrganPathMap(gpsCode, gps);
        		}
        	}
        }
    }  
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

}
