package com.tianyi.bph.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tianyi.bph.bean.GpsOrganBean;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.constants.Constants;
import com.tianyi.bph.domain.GPSInfor;
import com.tianyi.bph.query.GpsInfoQuery;
import com.tianyi.bph.service.GpsService;
import com.tianyi.bph.util.GpsOrganUtil;

/**
 * GPS实时位置信息	处理接口
 * 
 * @author Administrator
 *
 */
@Service
public class GpsService {

	public static final Logger logger = LoggerFactory.getLogger(GpsService.class);
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public static Date stringToDate(String date) {
		Date result = null;
		try {
			dateFormat.setLenient(true);
			if(!"".equals(date)){
				result = dateFormat.parse(date);
			}
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	public void createCollection() {
		if (!this.mongoTemplate.collectionExists(GPSInfor.class)) {
			this.mongoTemplate.createCollection(GPSInfor.class);
		}
	}
	
	public List<GPSInfor> findList(int skip, int limit) {
		Query query = new Query();
		query.skip(skip).limit(limit);
		List<GPSInfor> list = this.mongoTemplate.find(query, GPSInfor.class);
		return list;
	}
	
	public List<GPSInfor> findAll(){
		List<GPSInfor> list = this.mongoTemplate.findAll(GPSInfor.class);
		return list;
	}

	public GPSInfor findById(int id) {
		Query query = new Query();
		query.addCriteria(new Criteria("_id").is(id));
		GPSInfor gps = this.mongoTemplate.findOne(query, GPSInfor.class);
		return gps;
	}

	public GPSInfor findByGpsId(String gpsId) {
		Query query = new Query();
		query.addCriteria(new Criteria("gpsId").is(gpsId));
		GPSInfor gps = this.mongoTemplate.findOne(query, GPSInfor.class);
		return gps;
	}

	public String insert(GPSInfor gps) {
		String result = "";
		try{
			this.mongoTemplate.insert(gps);
			result = Constants.SUCCESS;
		}catch(Exception e){
			result = Constants.ERROR;
			e.printStackTrace();
		}
		return result;
	}
	
	public String insert(List<GPSInfor> list) {
		String result = "";
		try{
			if(list != null && list.size() > 0){
				for(GPSInfor gps : list){
					this.mongoTemplate.insert(gps);
				}
			}
			result = Constants.SUCCESS;
		}catch(Exception e){
			result = Constants.ERROR;
			e.printStackTrace();
		}
		return result;
	}

	public String update(GPSInfor gps) {
		String result = "";
		try{
			Query query = new Query();
			query.addCriteria(new Criteria("_id").is(gps.getId()));
			Update update = new Update();
			update.set("gpsId", gps.getGpsId());
			update.set("addressTime", gps.getAddressTime());
			update.set("speed", gps.getSpeed());
			update.set("postion", gps.getPosition());
			update.set("gpsX", gps.getGpsX());
			update.set("gpsY", gps.getGpsY());
			update.set("high", gps.getHigh());
			update.set("direction", gps.getDirection());
			update.set("name", gps.getName());
			update.set("address", gps.getAddress());
			this.mongoTemplate.updateFirst(query, update, GPSInfor.class);
			result = Constants.SUCCESS;
		}catch(Exception e){
			result = Constants.ERROR;
			e.printStackTrace();
		}
		return result;
	}
	
	public String delete(int id){
		String result = "";
		try{
			GPSInfor gps = findById(id);
			if(gps != null){
				this.mongoTemplate.remove(gps);
			}
			result = Constants.SUCCESS;
		}catch(Exception e){
			result = Constants.ERROR;
			e.printStackTrace();
		}
		return result;
	}
	
	/*gps查询*/
	public ReturnResult queryGpsInfo(String gpsId, String startTime, String endTime){
		
		Date st = null;
		Date et = null;
		try {
			if(StringUtils.hasText(startTime)){
				st = dateFormat.parse(startTime);
			}
			if(StringUtils.hasText(startTime)){
				et = dateFormat.parse(endTime);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Query query = new Query();
		if(StringUtils.hasText(gpsId)){
			query.addCriteria(new Criteria("gpsId").is(gpsId));
		}
		if(StringUtils.hasText(startTime)){
			query.addCriteria(new Criteria("addressTime").gte(st).lte(et));
		}
		List<GPSInfor> list = this.mongoTemplate.find(query, GPSInfor.class);
		
		return ReturnResult.SUCCESS(list);
	}

	public ReturnResult findGps(String gpsId, String gpsName, Date startTime, Date endTime, int gpsUnit) {
		Query query = new Query();
		if(StringUtils.hasText(gpsId)){
			query.addCriteria(new Criteria("gpsId").is(gpsId));
		}
		if(StringUtils.hasText(gpsName)){
			query.addCriteria(new Criteria("name").is(gpsName));
		}
		if(startTime != null){
			query.addCriteria(new Criteria("addressTime").gte(startTime));
		}
		if(endTime != null){
			query.addCriteria(new Criteria("endTime").gte(endTime));
		}
//		query.addCriteria(new Criteria("gpsUnit").gte(gpsUnit));
		List<GPSInfor> list = this.mongoTemplate.find(query, GPSInfor.class);
//		List<GPSInfor> list = this.mongoTemplate.findAll(GPSInfor.class);
		
		ReturnResult result = ReturnResult.SUCCESS(list);
		return result;
	}

	public ReturnResult findGps(GpsInfoQuery iQuery){
		ReturnResult result = null;
		if(iQuery != null){
			Query query = new Query();
			if(StringUtils.hasText(iQuery.getGpsId())){
				query.addCriteria(new Criteria("gpsId").is(iQuery.getGpsId()));
			}
			if(StringUtils.hasText(iQuery.getGpsName())){
				query.addCriteria(new Criteria("name").is(iQuery.getGpsName()));
			}
			if(iQuery.getStartTime() != null){
				query.addCriteria(new Criteria("addressTime").gte(iQuery.getStartTime()));
			}
			if(iQuery.getEndTime() != null){
				query.addCriteria(new Criteria("endTime").gte(iQuery.getEndTime()));
			}
			List<GPSInfor> list = this.mongoTemplate.find(query, GPSInfor.class);
			result = ReturnResult.SUCCESS(list);
		}
		return result;
	}

	public void processGPSData(String msg){
		if (StringUtils.hasLength(msg)) {
			
			Map<String, GpsOrganBean> map = GpsOrganUtil.getInstance().getOrganPathMap();
			if(map != null && !"".equals(msg.trim())){
				String str = msg.substring(1);
				String tmp = str.substring(0,str.length()-1);
				String[] array = tmp.split("\\|");
				String gpsName  	= array[0];
				String gpsId		= array[1];
				String addressTime 	= array[2];
				String speed		= array[3];
				String position		= array[4];
				String gpsX			= array[5];
				String gpsY			= array[6];
				String direction	= array[7];
				String address		= array[8];
				Double high         = 0.0;
				int gpsType			= 1;	//GPS类型（车:1、人:2、飞行器:3等）
				int gpsUnit         = 1;    //GPS来源单位（1市局7770,2市局9989，3德阳）
				
				// gps信息——>写入MQ
				GpsOrganBean bean = map.get(gpsId);
				if(bean != null){
					String organPath = bean.getOrganPath();
					if(StringUtils.hasText(organPath)){
//						organPath = organPath.replace("/", ".");
						StringBuffer sb = new StringBuffer();
						sb.append("@"+gpsName+"|"+bean.getGpsId()+"|"+addressTime+"|"+speed+"|"+position+"|"+gpsX+"|"+gpsY+"|"+direction+"|"+address+"#");
						rabbitTemplate.convertAndSend(organPath, sb.toString());
					}
				}
				
				// gps信息——>存入Mongodb
				GPSInfor gps = new GPSInfor();
				gps.setName(gpsName);
				gps.setGpsId(gpsId);
				if(StringUtils.hasText(addressTime)){
					gps.setAddressTime(stringToDate(addressTime));
				}
				if(StringUtils.hasText(speed)){
					gps.setSpeed(Double.parseDouble(speed));
				}
				if(StringUtils.hasText(position)){
					gps.setPosition(Integer.parseInt(position));
				}
				if(StringUtils.hasText(gpsX)){
					gps.setGpsX(Double.parseDouble(gpsX));
				}
				if(StringUtils.hasText(gpsY)){
					gps.setGpsY(Double.parseDouble(gpsY));
				}
				if(StringUtils.hasText(direction)){
					gps.setDirection(Double.parseDouble(direction));
				}
				gps.setAddress(address);
				gps.setHigh(high);
				gps.setGpsType(gpsType);
				gps.setGpsUnit(gpsUnit);
				
				this.insert(gps);
			}
		}
	}
}
