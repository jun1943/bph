package com.tianyi.bph.service.basicdata;

import java.util.List; 
import java.util.Map;

import com.tianyi.bph.common.Pager; 
import com.tianyi.bph.domain.basicdata.Weapon;
import com.tianyi.bph.domain.basicdata.WeaponType;
import com.tianyi.bph.query.basicdata.ExtItem;
import com.tianyi.bph.query.basicdata.WeaponItemVM;
import com.tianyi.bph.query.basicdata.WeaponVM;
  
 
/**
 * 武器后台逻辑服务层
 * @author lq
 *
 */
public interface WeaponService {
	/**
	 * 删除武器对象
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);
	/**
	 * 
	 * @param record
	 * @return
	 */
	Weapon insert(Weapon record);
    /**
     * 插入查询记录集
     * @param record
     * @return
     */
    int insertSelective(Weapon record);
    /**
     * 根据id查询武器对象
     * @param id
     * @return
     */
    Weapon selectByPrimaryKey(Integer id);
    /**
     * 更新对象
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Weapon record);
    /**
     * 更新对象
     * @param record
     * @return
     */
    Weapon updateByPrimaryKey(Weapon record);
    /**
     * 查询记录列表
     * @return
     */
    List<Weapon> selectAll();
    /**
     * 查询记录总数
     * @param query
     * @return
     */
	int findCount(Weapon query);
	/**
	 * 查询记录分页对象列表
	 * @param query
	 * @param page
	 * @return
	 */
	List<Weapon> findPageList(Weapon query, Pager page);
	/**
	 * 查询分页记录总数
	 * @param map
	 * @return
	 */
	int loadVMCount(Map<String, Object> map);
	/**
	 * 查询分页记录列表
	 * @param map
	 * @return
	 */
	List<WeaponVM> loadVMList(Map<String, Object> map);
	/**
	 * 查询武器类型列表
	 * @return
	 */
	List<WeaponType> selectWeaponType();
	/**
	 * 查询武器分组对象列表
	 * @param map
	 * @return
	 */
	List<WeaponVM> loadVMListWithGroup(Map<String, Object> map);
	/**
	 * 批量删除武器对象
	 * @param map
	 */
	void deleteByIds(Map<String, Object> map);
	
	/**
	 * 根据武器编号，查询武器是否存在
	 * @param param
	 * @return
	 */
	List<WeaponVM> findByNumber(String param);
	/**
	 * 判断是否有武器关联数据
	 * @param string
	 * @return
	 */
	List<Weapon> findByIdAndDtyId(String param); 
	
	/**
	 * 根据组织机构id，获取所有成员列表
	 * @param orgId
	 * @return
	 */
	List<WeaponItemVM> getWeaponInfo(Integer orgId,Integer isSubOrg);
	
	
	/**
	 * 读取武器备勤信息及基础信息
	 * @param orgId
	 * @param ymd
	 * @return
	 */
	List<ExtItem<Weapon>> getWeaponDutyInfo(Integer orgId, Integer ymd,Integer isSubOrg);
	List<WeaponVM> findByNumberAndId(Map<String, Object> map);
	
}
