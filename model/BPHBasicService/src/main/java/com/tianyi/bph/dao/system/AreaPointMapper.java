package com.tianyi.bph.dao.system;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.AreaPoint;
import com.tianyi.bph.query.system.AreaPointExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface AreaPointMapper {
	int deleteByExample(AreaPointExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(AreaPoint record);

	int insertSelective(AreaPoint record);

	List<AreaPoint> selectByExample(AreaPointExample example);

	AreaPoint selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") AreaPoint record,
			@Param("example") AreaPointExample example);

	int updateByExample(@Param("record") AreaPoint record,
			@Param("example") AreaPointExample example);

	int updateByPrimaryKeySelective(AreaPoint record);

	int updateByPrimaryKey(AreaPoint record);

	int checkAreaPointName(@Param("areaId") Integer areaId,
			@Param("pointName") String pointName);
}