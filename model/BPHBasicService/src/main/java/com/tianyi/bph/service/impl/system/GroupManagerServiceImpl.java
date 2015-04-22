package com.tianyi.bph.service.impl.system;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.dao.system.GroupManagerMapper;
import com.tianyi.bph.dao.system.GroupOtherMapper;
import com.tianyi.bph.domain.system.GroupManager;
import com.tianyi.bph.domain.system.GroupOther;
import com.tianyi.bph.exception.RestException;
import com.tianyi.bph.query.system.GroupManagerExample;
import com.tianyi.bph.service.system.GroupManagerService;

@Service
public class GroupManagerServiceImpl implements GroupManagerService {

	@Autowired
	GroupManagerMapper groupDao;
	@Autowired
	GroupOtherMapper groupOtherDao;

	@Override
	public int deleteByPrimaryKey(Integer groupId) {
		// TODO Auto-generated method stub
		if (groupId == null) {
			throw new RestException("对象不能为空");
		}

		groupOtherDao.deleteByPrimaryKey(groupId);

		int i = groupDao.deleteByPrimaryKey(groupId);

		return i;
	}

	@Override
	public int insert(GroupManager record) {
		// TODO Auto-generated method stub
		if (record == null) {
			throw new RestException("对象不能为空");
		}
		groupDao.insert(record);
		if (!StringUtils.isEmpty(record.getJsonData())) {
			JSONArray array = JSONArray.fromObject(record.getJsonData());
			for (int i = 0; i < array.size(); i++) {
				JSONObject o = (JSONObject) array.get(i);
				int type = o.getInt("groupType");
				int id = o.getInt("listId");
				GroupOther other = new GroupOther();
				other.setGroupId(record.getGroupId());
				other.setGroupType(type);
				other.setListId(id);
				groupOtherDao.insert(other);
			}
		}
		return record.getGroupId();
	}

	@Override
	public int insertSelective(GroupManager record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GroupManager> selectByExample(GroupManagerExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupManager selectByPrimaryKey(Integer groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(GroupManager record,
			GroupManagerExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(GroupManager record, GroupManagerExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(GroupManager record) {
		// TODO Auto-generated method stub
		if (record == null) {
			throw new RestException("对象不能为空");
		}
		int id = 0;
		GroupManager group = groupDao.selectByPrimaryKey(record.getGroupId());
		if (group != null) {
			id = groupDao.updateByPrimaryKeySelective(record);
			
			if (!StringUtils.isEmpty(record.getJsonData())) {
				groupOtherDao.deleteByPrimaryKey(record.getGroupId());

				JSONArray array = JSONArray.fromObject(record.getJsonData());
				for (int i = 0; i < array.size(); i++) {
					JSONObject o = (JSONObject) array.get(i);
					int type = o.getInt("groupType");
					int listId = o.getInt("listId");
					GroupOther other = new GroupOther();
					other.setGroupId(group.getGroupId());
					other.setGroupType(type);
					other.setListId(listId);
					groupOtherDao.insert(other);
				}
			}
		}
		return id;
	}

	@Override
	public int updateByPrimaryKey(GroupManager record) {
		// TODO Auto-generated method stub
		return groupDao.updateByPrimaryKey(record);
	}

	@Override
	public List<GroupManager> getListByUserId(Integer userId) {
		if (userId == null) {
			throw new RestException("userId 不能为空");
		}
		List<GroupManager> groupList = groupDao.getListByUserId(userId);
		return groupList;
	}

	@Override
	public int saveByJsonData(GroupManager record) {
		// TODO Auto-generated method stub
		if (record == null) {
			throw new RestException("对象不能为空");
		}
		int id=0;
		GroupManager group = groupDao.selectByPrimaryKey(record.getGroupId());
		if (group != null) {
			if (!StringUtils.isEmpty(record.getJsonData())) {
				JSONArray array = JSONArray.fromObject(record.getJsonData());
				for (int i = 0; i < array.size(); i++) {
					JSONObject o = (JSONObject) array.get(i);
					int type = o.getInt("groupType");
					int listId = o.getInt("listId");
					GroupOther other = new GroupOther();
					other.setGroupId(group.getGroupId());
					other.setGroupType(type);
					other.setListId(listId);
					groupOtherDao.insert(other);
				}
			}
			id=1;
		}
		return id;
	}

	@Override
	public int deleteSource(GroupManager record) {
		// TODO Auto-generated method stub
		if(record==null){
			throw new RestException("对象不能为空");
		}
		GroupOther orther=new GroupOther();
		orther.setGroupId(record.getGroupId());
		orther.setListId(record.getListId());
		int i=groupOtherDao.deleteSource(orther);
		return i;
	}

}
