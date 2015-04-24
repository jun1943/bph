 package com.tianyi.bph.dao.basicdata;

import java.util.List;
import java.util.Map;

import com.tianyi.bph.common.Pager;
import com.tianyi.bph.domain.basicdata.Gps;
import com.tianyi.bph.domain.basicdata.GpsType; 
import com.tianyi.bph.domain.basicdata.Icons;
import com.tianyi.bph.query.basicdata.GpsVM;
/*
 * 定位设备映射文件
 */
@com.tianyi.bph.dao.MyBatisRepository
public interface GpsMapper {
	/*
	 * 根据主键删除对象
	 * return：int
	 */
    int deleteByPrimaryKey(Integer id);
    /*
	 * 插入新对象
	 * return record_id
	 */
    int insert(Gps record);
    /*
	 * 插入查询结果对象
	 */
    int insertSelective(Gps record);
    /*
	 * 根据对象id获取对象详细信息
	 */
    Gps selectByPrimaryKey(Integer id);
    /*
	 * 根据主键更新对象集信息
	 */
    int updateByPrimaryKeySelective(Gps record);
    /*
	 * 更新对象信息
	 */
    int updateByPrimaryKey(Gps record);
    /*
	 * 查询对象的个数
	 */
	int findCount(Gps gps);
	/*
	 * 查询对象列表
	 */
	List<Gps> findPageList(Gps query, Pager page);
	/*
	 * 查询符合条件的对象总数
	 */
	int loadVMCount(Map<String, Object> map);
	/*
	 * 查询符合条件的所有数据集
	 */
	List<GpsVM> loadVMList(Map<String, Object> map);
	/*
	 * 查询类型列表
	 */
	List<GpsType> selectGpsType();
	/*
	 * 根据条件查询分组对象
	 */
	List<GpsVM> loadVMListWithGroup(Map<String, Object> map);
	/*
	 * 根据id集，批量删除对象
	 */
	void deleteByIds(Map<String, Object> map);
	/**
	 * 根据编号，判断是否存在武器
	 * @param param
	 * @return
	 */
	List<GpsVM> findByNumber(String param);
	
	/**
	 * 判斷是否存在定位设备关联数据
	 * @param param
	 * @return
	 */
	List<Gps> findByIdAndDtyId(String param);
	/**
	 * 根据组织机构id，获取所有成员列表
	 * @param map
	 * @return
	 */
	List<Gps> getGPSInfo(Map<String, Object> map);
	List<Icons> selectIconsList();
	List<GpsVM> findByNumberAndId(Map<String, Object> map); 
}


