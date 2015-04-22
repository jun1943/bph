package com.tianyi.bph.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.dao.system.GroupOtherMapper;
import com.tianyi.bph.domain.system.GroupOther;
import com.tianyi.bph.query.system.GroupOtherExample;
import com.tianyi.bph.service.system.GroupOtherService;
@Service
public class GroupOtherServiceImpl implements GroupOtherService {

	@Autowired GroupOtherMapper groupOtherDao;
	
	@Override
	public int insert(GroupOther record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(GroupOther record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GroupOther> selectByExample(GroupOtherExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(GroupOther record,
			GroupOtherExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(GroupOther record, GroupOtherExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getListIdsByGroupId(Integer userId) {
		// TODO Auto-generated method stub
		if(userId ==null){
			throw new RuntimeException("分组编号不能为空");
		}
		return groupOtherDao.getListIdsByGroupId(userId);
	}

}
