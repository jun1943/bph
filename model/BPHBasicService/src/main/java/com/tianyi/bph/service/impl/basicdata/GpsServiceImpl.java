package com.tianyi.bph.service.impl.basicdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.common.Constants;
import com.tianyi.bph.common.Pager;
import com.tianyi.bph.common.annotation.MQDataInterceptor;
import com.tianyi.bph.dao.basicdata.ExportMapper;
import com.tianyi.bph.dao.basicdata.GpsMapper;
import com.tianyi.bph.dao.system.OrganDAO;
import com.tianyi.bph.domain.basicdata.Gps;
import com.tianyi.bph.domain.basicdata.GpsType;
import com.tianyi.bph.domain.basicdata.Icons;
import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.query.basicdata.ExtDbResult;
import com.tianyi.bph.query.basicdata.ExtItem;
import com.tianyi.bph.query.basicdata.ExtShiftInfo;
import com.tianyi.bph.query.basicdata.GpsVM;
import com.tianyi.bph.service.basicdata.GpsService;
 
/**
 * 定位设备接口实现
 * @author lq
 *
 */
@Service
public class GpsServiceImpl implements GpsService{

	@Autowired GpsMapper gpsMapper;

	@Autowired ExportMapper exportMapper;

	@Autowired OrganDAO organMapper;
	
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.GpsService#findCount(Gps gps)
	 */
	public int findCount(Gps gps) {
		
		return gpsMapper.findCount(gps);
	}
	/** (non-Javadoc)
	 *  @see com.tianyi.drs.basedata.service.GpsService#findPageList(Gps query, PaginationData page)
	 */
	public List<Gps> findPageList(Gps query, Pager page) {
		// TODO Auto-generated method stub
		return gpsMapper.findPageList(query,page);
	}
	/** (non-Javadoc)
	 *  @see com.tianyi.drs.basedata.service.GpsService#loadVMCount(Map<String, Object> map)
	 */
	public int loadVMCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gpsMapper.loadVMCount(map);
	}
	/** (non-Javadoc)
	 *  @see com.tianyi.drs.basedata.service.GpsService#loadVMList(Map<String, Object> map)
	 */
	public List<GpsVM> loadVMList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gpsMapper.loadVMList(map);
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.GpsService#updateByPrimaryKey(Gps gps)
	 */
	@MQDataInterceptor(type = Constants.MQ_TYPE_GPS, operate = Constants.MQ_OPERATE_UPDATE)
	public Gps updateByPrimaryKey(Gps gps) {
		// TODO Auto-generated method stub
		gpsMapper.updateByPrimaryKey(gps);
		return gps;
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.GpsService#insert(Gps gps)
	 */
	@MQDataInterceptor(type = Constants.MQ_TYPE_GPS, operate = Constants.MQ_OPERATE_ADD)
	public Gps insert(Gps gps) {
		// TODO Auto-generated method stub
		gpsMapper.insert(gps);
		return gps;
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.GpsService#deleteByPrimaryKey(id)
	 */
	public int deleteByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		gpsMapper.deleteByPrimaryKey(id);
		return id;
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.GpsService#selectGpsType()
	 */
	public List<GpsType> selectGpsType() {
		// TODO Auto-generated method stub
		return gpsMapper.selectGpsType();
	}
	/** (non-Javadoc)
	 *  @see com.tianyi.drs.basedata.service.GpsService#loadVMListWithGroup(Map<String, Object> map)
	 */
	public List<GpsVM> loadVMListWithGroup(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gpsMapper.loadVMListWithGroup(map);
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.GpsService#deleteByIds(Map<String, Object> map)
	 */
	public void deleteByIds(Map<String, Object> map) {
		// TODO Auto-generated method stub
		gpsMapper.deleteByIds(map);
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.GpsService#findByNumber(String)
	 */
	public List<Gps> findByNumber(String param) {
		// TODO Auto-generated method stub
		return gpsMapper.findByNumber(param);
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.GpsService#findByIdAndDtyId(String)
	 */
	public List<Gps> findByIdAndDtyId(String param) {
		// TODO Auto-generated method stub
		return gpsMapper.findByIdAndDtyId(param);
	}
	public List<Gps> getGPSInfo(Integer orgId,Integer isSubOrg) {
		// TODO Auto-generated method stub
		Organ org = new Organ();
		String orgPath = "";

		Map<String, Object> map =  new HashMap<String, Object>();
		if(isSubOrg==Constants.SEARCH_TYPE_CHILD){
			org = organMapper.selectByPrimaryKey(orgId);
			orgPath = org.getPath();
			map.put("orgPath", orgPath);
		}
		map.put("orgId",orgId);
		return gpsMapper.getGPSInfo(map);
	}
	
	
	

	public List<ExtItem<Gps>> getGpsDutyInfo(Integer orgId, Integer ymd,Integer isSubOrg) {
		Map<Integer, ExtItem<?>> cache = new HashMap<Integer, ExtItem<?>>();// dutyItemId局部缓存，避免大量低效率的循环。
		Map<Integer, Object> cache2 = new HashMap<Integer, Object>();// ItemId
																		// 局部缓存，避免大量低效率的循环。Object无意义，都为null

		List<ExtItem<Gps>> eps = new ArrayList<ExtItem<Gps>>();

		Organ org = new Organ();
		String orgPath = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", orgId);
		map.put("ymd", ymd);
		if(isSubOrg==Constants.SEARCH_TYPE_CHILD){
			org = organMapper.selectByPrimaryKey(orgId);
			orgPath = org.getPath();
			map.put("orgPath", orgPath);
		}
		List<ExtDbResult> rs = exportMapper.loadDutyItemInfo(map);

		for (ExtDbResult r : rs) {
			if (r.getItemTypeId() == 4) {
				@SuppressWarnings("unchecked")
				ExtItem<Gps> ep = (ExtItem<Gps>) this.createItemInfo(r);
				ep.setShiftInfo(this.createShiftInfo(r)); // 只有第一层需要写班次信息

				cache.put(ep.getDutyItemId(), ep);// 添加到缓存
				cache2.put(ep.getData().getId(), null);
				eps.add(ep);// 添加到list

			} else {
				if (cache.containsKey(r.getParentId())) {
					@SuppressWarnings("unchecked")
					ExtItem<Gps> pp = (ExtItem<Gps>) cache.get(r.getParentId());
					if (pp.getItems() == null) {
						pp.setItems(new ArrayList<ExtItem<?>>());
					}
					ExtItem<?> cp = (ExtItem<?>) createItemInfo(r);
					pp.getItems().add(cp);
					cache.put(r.getDutyItemId(), cp);

				}
			}
		}

		List<Gps> mps = gpsMapper.getGPSInfo(map);

		for (Gps mp : mps) {
			if (!cache2.containsKey(mp.getId())) {
				ExtItem<Gps> ep2 = new ExtItem<Gps>();
				ep2.setData(mp);
				eps.add(ep2);
			}
		}

		return eps;
	}

	private Object createItemInfo(ExtDbResult result) {
		ExtItem<Object> item = new ExtItem<Object>();
		Object data = null;

		data = this.createGsp(result);

		item.setDutyItemId(result.getDutyItemId());
		item.setData(data);
		item.setItemTypeId(result.getItemTypeId());
		item.setLevel(result.getLevel());

		return item;
	}

	private ExtShiftInfo createShiftInfo(ExtDbResult result) {
		ExtShiftInfo info = new ExtShiftInfo();
		info.setBeginTime(result.getBeginTime());
		info.setDutyTypeId(result.getDutyTypeId());
		info.setDutyTypeName(result.getDutyTypeName());
		info.setEndTime(result.getEndTime());
		info.setShiftId(result.getDutyItemId());
		info.setShiftName(result.getName());

		return info;
	}
 

	private Gps createGsp(ExtDbResult result) {
		Gps g = new Gps();
		g.setGpsName(result.getGpsName());
		g.setIconUrl(result.getGpsIconUrl());
		g.setId(result.getGpsId());
		g.setNumber(result.getGpsNumber());
		g.setOrgId(result.getGpsOrgId());
		g.setTypeId(result.getGpsTypeId());
		return g;
	}
	@Override
	public Gps selectByPrimaryKey(Integer gpsId) {
		// TODO Auto-generated method stub
		return gpsMapper.selectByPrimaryKey(gpsId);
	}
	
	public List<Icons> selectIconsList(){
		return gpsMapper.selectIconsList();
	}
	@Override
	public List<Gps> findByNumberAndId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gpsMapper.findByNumberAndId(map);
	}
}
