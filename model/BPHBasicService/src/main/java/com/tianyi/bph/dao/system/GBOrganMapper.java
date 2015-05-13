package com.tianyi.bph.dao.system;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.GBOrgan;
import com.tianyi.bph.query.system.GBOrganExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface GBOrganMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(GBOrgan record);

	int insertSelective(GBOrgan record);

	List<GBOrgan> selectByExample(GBOrganExample example);

	GBOrgan selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") GBOrgan record,
			@Param("example") GBOrganExample example);

	int updateByExample(@Param("record") GBOrgan record,
			@Param("example") GBOrganExample example);

	int updateByPrimaryKeySelective(GBOrgan record);

	int updateByPrimaryKey(GBOrgan record);
	
	List<GBOrgan> selectByGBOrganId(@Param("gbId")Integer gbId);

}