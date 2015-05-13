package com.tianyi.bph.service.system;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianyi.bph.common.Md5Encrypt;
import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.Pager;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.common.SystemConfig;
import com.tianyi.bph.dao.system.UserDAO;
import com.tianyi.bph.domain.system.User;
import com.tianyi.bph.query.system.UserQuery;

/**
 * 用户管理业务层接口
 * @author fantedan@tieserv.com
 * @date 2015-1-13 上午10:44:50
 */

public interface UserService {
	
	/**
	 * 添加用户信息
	 * @param user 用户信息
	 * @param rolesId 角色ID
	 * @param modulesId 模块ID
	 * @return
	 */
	@Transactional
	public ReturnResult addUser(User user, Integer[] rolesId, Integer[] userOrganIds);
	
	/**
	 * 删除用户
	 * @param 用户id
	 * @return
	 */
	@Transactional
	public ReturnResult deleteUser(Long userId);
	/**
	 * 批量删除多个用户,此方法需要修改,for循环效率太低
	 * @param userIds 用户ID号
	 * @return
	 */
	@Transactional
	public ReturnResult deleteUsers(Long[] ids);
	
	/**
	 * 修改用户信息
	 * @param user 用户信息
	 * @param rolesId 角色ID
	 * @param modulesId 模块ID
	 */
	@Transactional
	public ReturnResult updateUser(User user, Integer[] rolesId, Integer[] userOrganIds);
	
	/**
	 * 修改用户信息
	 * @param user 用户信息
	 */
	@Transactional
	public void updateUserBySelect(User user);
	
	/**
	 * 根据ID获取用户信息
	 * @param id 用户ID
	 */	
	public User getUserById(Long id);
	
	/**
	 * 判断用户关键信息是否重复
	 * @param userQuery 用户信息
	 */	
	public boolean isUnique(UserQuery userQuery);
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 用户密码
	 * @return
	 */
	public ReturnResult userLogin(String username,String password);
	
	/**
	 * 修改用户密码
	 * @param id 用户ID
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
	 * @param cfmPwd 确认密码
	 * @return
	 */
	@Transactional
	public ReturnResult updateUserPassword(Long id, String oldPwd, String newPwd, String cfmPwd);
	
	/**
	 * 分页查询,返回page对象
	 * @param query 用户信息
	 * @return
	 */
	public Pager<User> getPageList(UserQuery query);
	
	/**
	 * 分页查询,返回List
	 * @param query 用户信息
	 * @return
	 */
	public List<User> getUserPageList(UserQuery query);
	/**
	 * 条件查询返回记录总数
	 * @param query 用户信息
	 * @return
	 */
	public Integer getUserCount(UserQuery query);
		
	/**
	 * 不分页条件查询
	 * @param query 用户信息
	 * @return
	 */
	public List<User> getQueryList(UserQuery query);
	/**
	 * 获取单个用户详细信息
	 * @param query 用户信息
	 * @return
	 */
	public void updateUserByMySelect(User user);
	
	/**
	 * 不分页条件查询
	 * @param query 用户信息
	 * @return
	 */
	public List<User> getListForPoliceId(Integer policeId);
	
	/**
	 * 修改用户密码
	 * 2015-5-6
	 * @param id 用户ID
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
	 * @param cfmPwd 确认密码
	 * @return
	 */
	public ReturnResult updatePassword(Long id, String oldPwd, String newPwd, String cfmPwd);
	
	/**
	 *  重置密码<br>
	 *  2015-5-8
	 * @param id
	 * @return
	 */
	public ReturnResult resetPassword(Long id);

}
