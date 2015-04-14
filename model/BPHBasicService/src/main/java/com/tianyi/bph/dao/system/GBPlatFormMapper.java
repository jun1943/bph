package com.tianyi.bph.dao.system;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.GBPlatForm;
import com.tianyi.bph.query.system.GBPlatFormExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface GBPlatFormMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(GBPlatForm record);

	int insertSelective(GBPlatForm record);

	List<GBPlatForm> selectByExample(GBPlatFormExample example);

	GBPlatForm selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") GBPlatForm record,
			@Param("example") GBPlatFormExample example);

	int updateByExample(@Param("record") GBPlatForm record,
			@Param("example") GBPlatFormExample example);

	int updateByPrimaryKeySelective(GBPlatForm record);

	int updateByPrimaryKey(GBPlatForm record);
}