package com.tianyi.bph.service.basicdata;

import java.util.List;
import java.util.Map;

import com.tianyi.bph.common.Pager;
import com.tianyi.bph.domain.basicdata.Gps;
import com.tianyi.bph.domain.basicdata.GpsType;
import com.tianyi.bph.domain.basicdata.Icons;
import com.tianyi.bph.query.basicdata.ExtItem;
import com.tianyi.bph.query.basicdata.GpsVM;
 
/**
 * 定位设备后台逻辑服务层
 * auther：李强
 */
public interface GpsService {

	/**
	 * 查询记录数
	 * @param gps
	 * @return
	 */
	public int findCount(Gps gps);
	/**
	 * 查询分页
	 * @param query
	 * @param page
	 * @return
	 */
	public List<Gps> findPageList(Gps query, Pager page);
	/**
	 * 查询记录总数
	 * @param map
	 * @return
	 */
	public int loadVMCount(Map<String, Object> map);
	/**
	 * 查询记录并分页
	 * @param map
	 * @return
	 */
	public List<GpsVM> loadVMList(Map<String, Object> map);
	/**
	 * 更新对象
	 * @param gps
	 * @return
	 */
	public Gps updateByPrimaryKey(Gps gps);
	/**
	 * 插入新纪录
	 * @param gps
	 * @return
	 */
	public Gps insert(Gps gps);
	/**
	 * 删除对象
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(int id);
	/**
	 * 查询对象集
	 * @return
	 */
	public List<GpsType> selectGpsType();
	/**
	 * 查询分页记录
	 * @param map
	 * @return
	 */
	public List<GpsVM> loadVMListWithGroup(Map<String, Object> map);
	/**
	 * 批量删除对象
	 * @param map
	 */
	public void deleteByIds(Map<String, Object> map);
	
	/**
	 * 判断是否存在编号的定位设备
	 * @param param
	 * @return
	 */
	public List<Gps> findByNumber(String param);
	/**
	 * 判断是否存在定位设备关联数据
	 * @param param
	 * @return
	 */
	
	public List<Gps> findByIdAndDtyId(String param);
	
	/**
	 * 根据组织机构id，获取所有有成员列表
	 * @param orgId
	 * @return
	 */
	List<Gps> getGPSInfo(Integer orgId,Integer isSubOrg);
	

	/**
	 * 读取定位设备备勤信息及基础信息
	 * @param orgId
	 * @param ymd
	 * @return
	 */
	List<ExtItem<Gps>> getGpsDutyInfo(Integer orgId, Integer ymd,Integer isSubOrg);
	public Gps selectByPrimaryKey(Integer gpsId);
	public List<Icons> selectIconsList();
	public List<Gps> findByNumberAndId(Map<String, Object> map);
}
