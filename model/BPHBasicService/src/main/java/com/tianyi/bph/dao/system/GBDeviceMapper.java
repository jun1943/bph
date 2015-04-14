package com.tianyi.bph.dao.system;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.GBDevice;
import com.tianyi.bph.query.system.GBDeviceExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface GBDeviceMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(GBDevice record);

	int insertSelective(GBDevice record);

	List<GBDevice> selectByExample(GBDeviceExample example);

	GBDevice selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") GBDevice record,
			@Param("example") GBDeviceExample example);

	int updateByExample(@Param("record") GBDevice record,
			@Param("example") GBDeviceExample example);

	int updateByPrimaryKeySelective(GBDevice record);

	int updateByPrimaryKey(GBDevice record);

	public List<GBDevice> queryAllGbDevice();
}