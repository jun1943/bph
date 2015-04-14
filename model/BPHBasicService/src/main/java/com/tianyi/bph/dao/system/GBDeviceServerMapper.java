package com.tianyi.bph.dao.system;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.GBDeviceServer;
import com.tianyi.bph.query.system.GBDeviceServerExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface GBDeviceServerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GBDeviceServer record);

    int insertSelective(GBDeviceServer record);

    List<GBDeviceServer> selectByExample(GBDeviceServerExample example);

    GBDeviceServer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GBDeviceServer record, @Param("example") GBDeviceServerExample example);

    int updateByExample(@Param("record") GBDeviceServer record, @Param("example") GBDeviceServerExample example);

    int updateByPrimaryKeySelective(GBDeviceServer record);

    int updateByPrimaryKey(GBDeviceServer record);
}