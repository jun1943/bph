package com.tianyi.bph.dao.duty;

import java.util.List;
import java.util.Map;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.duty.DutyItems;


/**
 * 报备明细映射文件类
 * @author lq
 *
 */
@MyBatisRepository
public interface DutyItemsMapper {
	/**
	 * 根据id删除对象
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入新的报备明细数据
     * @param record
     * @return
     */
    int insert(DutyItems record);

    /**
     * 插入新的报备明细数据
     * @param record
     * @return
     */
    int insertSelective(DutyItems record);

    /**
     * 根据id获取报备明细对象
     * @param id
     * @return
     */
    DutyItems selectByPrimaryKey(Integer id);

    /**
     * 更新报备明细对象
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DutyItems record);

    /**
     * 更新报备明细对象
     * @param record
     * @return
     */
    int updateByPrimaryKey(DutyItems record);
   
    /**
     * 根据id删除报备
     * @param dutyId
     */
    void deleteByDutyId(Integer dutyId);
    /**
     * 根据id删除报备
     * @param dutyId
     */
	void deleteByDutyId(int dutyId);

	/**
	 * 根据id获取报备明细列表
	 * @param id
	 * @return
	 */
	List<DutyItems> loadlistByDutyId(Integer id);

	/**
	 * 根据id数据集，批量删除报备
	 * @param map
	 */
	void deleteByDutyIdlist(Map<String, Object> map);
}