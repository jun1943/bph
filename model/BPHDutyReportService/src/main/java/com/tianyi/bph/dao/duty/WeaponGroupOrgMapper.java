package com.tianyi.bph.dao.duty;

import java.util.List;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.duty.WeaponGroupOrg;
 

/**
 * 武器分组对应组织映射类
 * @author lq
 *
 */
@MyBatisRepository
public interface WeaponGroupOrgMapper {
	/**
	 * 根据id删除对象
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入新的武器分组关系对象
     * @param record
     * @return
     */
    int insert(WeaponGroupOrg record);

    /**
     * 插入新的武器分组关系对象
     * @param record
     * @return
     */
    int insertSelective(WeaponGroupOrg record);

    /**
     * 根据id查询分组对应组织详细信息
     * @param id
     * @return
     */
    WeaponGroupOrg selectByPrimaryKey(Integer id);

    /**
     * 更新对象
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(WeaponGroupOrg record);

    /**
     * 更新对象
     * @param record
     * @return
     */
    int updateByPrimaryKey(WeaponGroupOrg record);

    /**
     * 根据id，获取武器分组对应组织
     * @param pgid
     * @return
     */
	List<WeaponGroupOrg> loadWeaponGroupOrgByPGId(int pgid);

	/**
	 * 根据分组id，删除对象
	 * @param id
	 */
	void deleteByPGId(Integer id);
}