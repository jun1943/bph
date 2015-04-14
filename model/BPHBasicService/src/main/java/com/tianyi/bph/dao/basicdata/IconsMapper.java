package com.tianyi.bph.dao.basicdata;

import java.util.List;
import java.util.Map;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.basicdata.Icons;
import com.tianyi.bph.domain.basicdata.IconsType;
import com.tianyi.bph.query.basicdata.IconsVM;
 
/*
 * 系统图标映射文件
 */
@MyBatisRepository
public interface IconsMapper {
	/*
	 * 根据追歼删除图标
	 */
    int deleteByPrimaryKey(Integer id);
    /*
	 * 插入新的数据
	 */
    int insert(Icons record);
    /*
	 * 插入查询图表集
	 */
    int insertSelective(Icons record);
    /*
	 * 根据id值查询图标对象
	 */
    Icons selectByPrimaryKey(Integer id);
    /*
	 * 更新图表对象
	 */
    int updateByPrimaryKeySelective(Icons record);
    /*
	 * 更新图表对象
	 */
    int updateByPrimaryKeyWithBLOBs(Icons record);
    /*
	 * 更新图表对象
	 */
    int updateByPrimaryKey(Icons record);
    /*
	 * 根据参数获取图标列表对象
	 */
	List<IconsVM> loadList(Map<String, Object> map);
	/*
	 * 根据参数获取图标总记录数
	 */
	int loadCount(Map<String, Object> map);
	/*
	 * 根据id获取图标对象
	 */
	Icons loadById(int id);
	/*
	 * 批量删除图标对象
	 */
	void deleteByIds(Map<String, Object> map);
	List<Icons> getIconsInfo();
	List<IconsType> selectIconType();
	List<Icons> findByIdAndGpsId(String iconId);
	void updateGpsById(int iconId);
}