package com.tianyi.bph.service.impl.basicdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.common.Constants;
import com.tianyi.bph.common.Pager;
import com.tianyi.bph.common.annotation.MQDataInterceptor;
import com.tianyi.bph.dao.basicdata.ExportMapper;
import com.tianyi.bph.dao.basicdata.WeaponMapper;
import com.tianyi.bph.dao.system.OrganDAO;
import com.tianyi.bph.domain.basicdata.Weapon;
import com.tianyi.bph.domain.basicdata.WeaponType;
import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.query.basicdata.ExtDbResult;
import com.tianyi.bph.query.basicdata.ExtItem;
import com.tianyi.bph.query.basicdata.ExtShiftInfo;
import com.tianyi.bph.query.basicdata.WeaponItemVM;
import com.tianyi.bph.query.basicdata.WeaponVM;
import com.tianyi.bph.service.basicdata.WeaponService;
  
/**
 * 武器接口实现
 * @author lq
 *
 */
@Service
public class WeaponServiceImpl implements WeaponService {

	@Autowired WeaponMapper weaponMapper;

	@Autowired ExportMapper exportMapper;

	@Autowired OrganDAO organMapper;
	
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#deleteByPrimaryKey(Integer)
	 */
	@MQDataInterceptor(type = Constants.MQ_TYPE_WEAPON, operate = Constants.MQ_OPERATE_DELETE)
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		weaponMapper.deleteByPrimaryKey(id);
		return id;
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#insert(Weapon)
	 */

	@MQDataInterceptor(type = Constants.MQ_TYPE_WEAPON, operate = Constants.MQ_OPERATE_ADD)
	public Weapon insert(Weapon record) {
		// TODO Auto-generated method stub
		weaponMapper.insert(record);
		return record;
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#insertSelective(Weapon)
	 */
	public int insertSelective(Weapon record) {
		// TODO Auto-generated method stub
		return weaponMapper.insertSelective(record);
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#selectByPrimaryKey(Integer)
	 */
	public Weapon selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return weaponMapper.selectByPrimaryKey(id);
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#updateByPrimaryKeySelective(Weapon)
	 */
	public int updateByPrimaryKeySelective(Weapon record) {
		// TODO Auto-generated method stub
		return weaponMapper.updateByPrimaryKeySelective(record);
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#updateByPrimaryKey(Weapon)
	 */
	@MQDataInterceptor(type = Constants.MQ_TYPE_WEAPON, operate = Constants.MQ_OPERATE_UPDATE)
	public Weapon updateByPrimaryKey(Weapon record) {
		// TODO Auto-generated method stub
		weaponMapper.updateByPrimaryKey(record);
		return record;
	} 
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#selectAll()
	 */
	public List<Weapon> selectAll() {
		// TODO Auto-generated method stub
		return weaponMapper.selectAll();
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#findCount(Weapon)
	 */
	public int findCount(Weapon weapon) {
		int count = weaponMapper.countByExample(weapon);
		return count;
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#findPageList(Weapon, PaginationData)
	 */
	public List<Weapon> findPageList(Weapon query, Pager page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(!(query.getNumber() == null || query.getNumber().length() ==0) )
			map.put("number", query.getNumber());
		
		map.put("pageStart", page.getCurrentPage());
		map.put("pageSize", page.getPageSize());
		List<Weapon> list = weaponMapper.selectByExample(map);
		
		return list;
	}
 
	  
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#loadVMCount(Map)
	 */
	public int loadVMCount(Map<String, Object> map) {
		int count= weaponMapper.loadVMCount(map);
		return count;
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#loadVMList(Map<String, Object> map)
	 */
	public List<WeaponVM> loadVMList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<WeaponVM> list = weaponMapper.loadVMList(map);
		
		return list;
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#selectWeaponType()
	 */
	public List<WeaponType> selectWeaponType() {
		// TODO Auto-generated method stub
		return weaponMapper.selectWeaponType();
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#loadVMListWithGroup(Map<String, Object> map)
	 */
	public List<WeaponVM> loadVMListWithGroup(Map<String, Object> map) {
		List<WeaponVM> list = weaponMapper.loadVMListWithGroup(map);
		return list;
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#deleteByIds(Map<String, Object> map)
	 */
	public void deleteByIds(Map<String, Object> map) {
		// TODO Auto-generated method stub
		weaponMapper.deleteByIds(map);
	}
	public List<Weapon> findByNumber(String param) {
		// TODO Auto-generated method stub
		return weaponMapper.findByNumber(param);
	}
	/** (non-Javadoc)
	 * @see com.tianyi.drs.basedata.service.WeaponService#findByIdAndDtyId(String)
	 */
	public List<Weapon> findByIdAndDtyId(String param) {
		// TODO Auto-generated method stub
		return weaponMapper.findByIdAndDtyId(param);
	}
	public List<WeaponItemVM> getWeaponInfo(Integer orgId,Integer isSubOrg) {
		// TODO Auto-generated method stub	Organ org = new Organ();

		Organ org = new Organ();
		String orgPath = "";

		Map<String, Object> map =  new HashMap<String, Object>();
		if(isSubOrg==Constants.SEARCH_TYPE_CHILD){
			org = organMapper.selectByPrimaryKey(orgId);
			orgPath = org.getPath();
			map.put("orgPath", orgPath);
		}
		map.put("orgId",orgId);
		return weaponMapper.getWeaponInfo(map);
	} 

	public List<ExtItem<Weapon>> getWeaponDutyInfo(Integer orgId, Integer ymd,Integer isSubOrg) {
		Map<Integer, ExtItem<?>> cache = new HashMap<Integer, ExtItem<?>>();// dutyItemId局部缓存，避免大量低效率的循环。
		Map<Integer, Object> cache2 = new HashMap<Integer, Object>();// ItemId
																		// 局部缓存，避免大量低效率的循环。Object无意义，都为null

		List<ExtItem<Weapon>> eps = new ArrayList<ExtItem<Weapon>>();

		Organ org = new Organ();
		String orgPath = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", orgId);
		if(isSubOrg==Constants.SEARCH_TYPE_CHILD){
			org = organMapper.selectByPrimaryKey(orgId);
			orgPath = org.getPath();
			map.put("orgPath", orgPath);
		}
		if (ymd == null || ymd == 0) {
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			String date = dateFormat.format(now);
			ymd = Integer.parseInt(date);

		}
		map.put("ymd", ymd);

		List<ExtDbResult> rs = exportMapper.loadDutyItemInfo(map);

		for (ExtDbResult r : rs) {
			if (r.getItemTypeId() == 3) {
				@SuppressWarnings("unchecked")
				ExtItem<Weapon> ep = (ExtItem<Weapon>) this.createItemInfo(r);
				ep.setShiftInfo(this.createShiftInfo(r)); // 只有第一层需要写班次信息

				cache.put(ep.getDutyItemId(), ep);// 添加到缓存
				cache2.put(ep.getData().getId(), null);
				eps.add(ep);// 添加到list

			} else {
				if (cache.containsKey(r.getParentId())) {
					@SuppressWarnings("unchecked")
					ExtItem<Weapon> pp = (ExtItem<Weapon>) cache.get(r
							.getParentId());
					if (pp.getItems() == null) {
						pp.setItems(new ArrayList<ExtItem<?>>());
					}
					ExtItem<?> cp = (ExtItem<?>) createItemInfo(r);
					pp.getItems().add(cp);
					cache.put(r.getDutyItemId(), cp);

				}
			}
		}

		List<WeaponItemVM> mps = weaponMapper.getWeaponInfo(map);

		for (Weapon mp : mps) {
			if (!cache2.containsKey(mp.getId())) {
				ExtItem<Weapon> ep2 = new ExtItem<Weapon>();
				ep2.setData(mp);
				eps.add(ep2);
			}
		}

		return eps;
	}
	


	private Object createItemInfo(ExtDbResult result) {
		ExtItem<Object> item = new ExtItem<Object>();
		Object data = null;

		data = this.createWeapon(result);

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
 


	private Weapon createWeapon(ExtDbResult result) {
		Weapon w = new Weapon();
		w.setId(result.getWeaponId());
		w.setNumber(result.getWeaponNumber());
		w.setOrgId(result.getWeaponOrgId());
		w.setStandard(result.getWeaponStandard());
		w.setTypeId(result.getWeaponTypeId());
		return w;
	}
	@Override
	public List<Weapon> findByNumberAndId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return weaponMapper.findByNumberAndId(map);
	} 
 
}
