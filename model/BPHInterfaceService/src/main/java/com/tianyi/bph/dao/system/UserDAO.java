package com.tianyi.bph.dao.system;

import java.util.List;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.User;
import com.tianyi.bph.query.system.UserQuery;

@MyBatisRepository
public interface UserDAO{
	
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //根据条件查询总数
    int getUniqueCountByQuery(UserQuery userQuery);
    
	//根据用户名查询
	public User getUserByName(String username);
	
	//修改密码
	public void updateUserPassword(Long id, String password);

	//分页查询
    List<User> findByPage(UserQuery userQuery);
    //分页总条数
    int findCount(UserQuery userQuery);
    
    //条件查询
    List<User> findByQuery(UserQuery userQuery);
    
    //修改指定字段
    int updateByMySelective(User record);
    
    
}
