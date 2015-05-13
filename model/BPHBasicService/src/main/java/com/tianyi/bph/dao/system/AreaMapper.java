package com.tianyi.bph.dao.system;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.Area;
import com.tianyi.bph.query.system.AreaExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface AreaMapper {
	int deleteByExample(AreaExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Area record);

	int insertSelective(Area record);

	List<Area> selectByExample(AreaExample example);

	Area selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Area record,
			@Param("example") AreaExample example);

	int updateByExample(@Param("record") Area record,
			@Param("example") AreaExample example);

	int updateByPrimaryKeySelective(Area record);

	int updateByPrimaryKey(Area record);

	List<Area> selectByOrganId(@Param("path") String path);

	int checkAreaName(@Param("areaName") String areaName,@Param("areaType")Integer areaType);
}