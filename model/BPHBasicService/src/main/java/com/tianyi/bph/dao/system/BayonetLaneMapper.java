package com.tianyi.bph.dao.system;

import com.tianyi.bph.domain.system.BayonetLane;
import com.tianyi.bph.query.system.BayonetLaneExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BayonetLaneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BayonetLane record);

    int insertSelective(BayonetLane record);

    List<BayonetLane> selectByExample(BayonetLaneExample example);

    BayonetLane selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BayonetLane record, @Param("example") BayonetLaneExample example);

    int updateByExample(@Param("record") BayonetLane record, @Param("example") BayonetLaneExample example);

    int updateByPrimaryKeySelective(BayonetLane record);

    int updateByPrimaryKey(BayonetLane record);
}