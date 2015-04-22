package com.tianyi.bph.dao.system;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.AreaRelationUserKey;
import com.tianyi.bph.query.system.AreaRelationUserExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface AreaRelationUserMapper {
	int deleteByExample(AreaRelationUserExample example);

	int deleteByPrimaryKey(AreaRelationUserKey key);

	int insert(AreaRelationUserKey record);

	int insertSelective(AreaRelationUserKey record);

	List<AreaRelationUserKey> selectByExample(AreaRelationUserExample example);

	int updateByExampleSelective(@Param("record") AreaRelationUserKey record,
			@Param("example") AreaRelationUserExample example);

	int updateByExample(@Param("record") AreaRelationUserKey record,
			@Param("example") AreaRelationUserExample example);

	List<Integer> selectByAreaId(Integer areaId);
}