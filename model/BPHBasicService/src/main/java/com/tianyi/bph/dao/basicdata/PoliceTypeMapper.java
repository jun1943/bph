package com.tianyi.bph.dao.basicdata;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.basicdata.PoliceType;
 
/*
 * 警员类型映射文件类
 */
@MyBatisRepository
public interface PoliceTypeMapper {
	/*
	 * 根据主键值删除警员类型对象
	 */
    int deleteByPrimaryKey(Integer id);
	/*
	 * 插入新的 警员类型对象
	 */
    int insert(PoliceType record);
	/*
	 * 插入新的警员类型对象集
	 */
    int insertSelective(PoliceType record);
	/*
	 * 根据主键值查询警员类型对象
	 */
    PoliceType selectByPrimaryKey(Integer id);
	/*
	 * 根据主键值更新警员类型对象
	 */
    int updateByPrimaryKeySelective(PoliceType record);
	/*
	 * 更新警员对象
	 */
    int updateByPrimaryKey(PoliceType record);
    
    
}