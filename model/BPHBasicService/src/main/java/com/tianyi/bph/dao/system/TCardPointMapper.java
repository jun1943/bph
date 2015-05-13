package com.tianyi.bph.dao.system;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.CardPointCamera;
import com.tianyi.bph.domain.system.CardPointUser;
import com.tianyi.bph.domain.system.TCardPoint;
import com.tianyi.bph.query.system.TCardPointExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface TCardPointMapper {
	int countByExample(TCardPointExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TCardPoint record);

	int insertSelective(TCardPoint record);

	List<TCardPoint> selectByExample(TCardPointExample example);

	TCardPoint selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TCardPoint record,
			@Param("example") TCardPointExample example);

	int updateByExample(@Param("record") TCardPoint record,
			@Param("example") TCardPointExample example);

	int updateByPrimaryKeySelective(TCardPoint record);

	int updateByPrimaryKey(TCardPoint record);

	void addCardPointCamera(CardPointCamera camera);

	void deleteCardPointCamera(@Param("cardPointId") Integer cardPointId);

	void addCardPointUser(CardPointUser user);

	void deleteCardPointUser(@Param("cardPointId") Integer cardPointId);

	List<Integer> getCardPointUser(@Param("cardPointId") Integer cardPointId);

	List<Integer> getCardPointCamera(@Param("cardPointId") Integer cardPointId);
	
	int countCardPointByCircleLayerId(@Param("layerId")Integer layerId);

}