package com.tianyi.bph.service.impl.system;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlecode.ehcache.annotations.Cacheable;
import com.tianyi.bph.common.ehcache.CacheUtils;
import com.tianyi.bph.dao.system.ModuleDAO;
import com.tianyi.bph.dao.system.RoleDAO;
import com.tianyi.bph.dao.system.RoleModuleFuctionDAO;
import com.tianyi.bph.dao.system.UserRoleDAO;
import com.tianyi.bph.domain.FunctionModule;
import com.tianyi.bph.domain.system.Module;
import com.tianyi.bph.domain.system.RoleModuleFuctionKey;
import com.tianyi.bph.query.system.ModuleQuery;
import com.tianyi.bph.service.system.ModuleService;


@Service
public class ModuleServiceImpl implements ModuleService{

	@Autowired ModuleDAO moduleDao;
	@Autowired RoleModuleFuctionDAO roleFunDao;
	@Autowired RoleDAO roleDao;
	@Autowired UserRoleDAO userRole;
	
	//增
	public void addModule(Module module){
		moduleDao.insert(module);
	}
	//删
	public void deleteModule(Integer id){
		moduleDao.deleteByPrimaryKey(id);
	}
	//改
	public void updateModule(Module module){
		moduleDao.updateByPrimaryKeySelective(module);
	}
	
	//根据用户查询用户模块权限
	public List<Module> getModulesByUserId(Integer userId){
		return moduleDao.getModulesByUserId(userId);
	}
	
	//根据条件查询模块信息
	public List<Module> getQueryList(ModuleQuery moduleQuery){
		return moduleDao.findByQuery(moduleQuery);
	}
	@Override
	public List<String> findModuleByParentId(Integer parentId) {
		// TODO Auto-generated method stub
		List<String> strList=null;
		String[] parentIdArray=new String[1];
		parentIdArray[0]=parentId+"";
		
		strList=moduleDao.findModuleByParentId(parentIdArray);//这里查询的是二级菜单
		
		if(strList !=null && strList.size()>0){//这里是功能的3级菜单
			String[] strArray=strList.toArray(new String[strList.size()]);
			List<String> strrList=moduleDao.findModuleByParentId(strArray);
			if(strrList !=null && strrList.size()>0){
				for (String string : strrList) {
					strList.add(string);
				}
			}
		}
		return strList;
	}
	@Override
	public FunctionModule findModuleList() {
		// TODO Auto-generated method stub
		FunctionModule funModule =new FunctionModule();
		
		return null;
	}
	@Override
	public List<String> findModuleSecondLevel(Integer parentId) {
		// TODO Auto-generated method stub
		return moduleDao.findModuleSecondLevel(parentId);
	}
	@Override
	public Module getTree(ModuleQuery moduleQuery) {
		// TODO Auto-generated method stub
		List<String> strList=null;
		if(!StringUtils.isEmpty(moduleQuery.getRoleId()+"")){
			strList=new ArrayList<String>();
			List<RoleModuleFuctionKey> roleModuleList=roleFunDao.getModuleFunListByRoleId(moduleQuery.getRoleId());
			if(roleModuleList !=null && roleModuleList.size()>0){
				for(RoleModuleFuctionKey rmf:roleModuleList){
					strList.add(rmf.getModFunId()+"");
				}
			}
		}
		Module module=moduleDao.selectByPrimaryKey(1);//当前暂时为默认根节点;
		module.setExpanded(true);
		List<Module> moduleList=moduleDao.findByQuery(moduleQuery);
		if(strList != null && strList.size()>0){
			for(Module m:moduleList){
				if(strList.contains(m.getId()+"")){
					m.setChecked(true);
				}
			}
		}
		initializeModule(module,moduleList);
		return module;
	}
	
	
	/**
	 * 递归查询功能信息
	 * @param parentOrgan
	 * @param childOrgans
	 * @param list
	 */
	public void initializeModule(Module parentModule, List<Module> childModules){
		List<Module> children = new ArrayList<Module>();
		for (Module child : childModules) {
			child.setExpanded(true);
			if (child.getParentId() != null && 
					child.getParentId().intValue()==parentModule.getId().intValue()) {
				children.add(child);
				initializeModule(child, childModules);
			}
		}
		parentModule.setItems(children);
	}
	@Override
	public List<RoleModuleFuctionKey> getModulesByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return roleFunDao.getModuleFunListByRoleId(roleId);
	}
	@Override
	public Module getTreeByUserIdOrRolesId(ModuleQuery moduleQuery) {
		// TODO Auto-generated method stub
		List<String> strList=new ArrayList<String>();
		if(!StringUtils.isEmpty(moduleQuery.getRoleIds())){
			String[] roleIdsArray=moduleQuery.getRoleIds().split(",");
			strList=roleDao.getModuleIdsByRoleIds(roleIdsArray);
		}else if(!StringUtils.isEmpty(moduleQuery.getUserId()+"")&&
				moduleQuery.getUserId() != null){
			strList=userRole.getFunctionsByUserId(moduleQuery.getUserId());
		}
		Module module=moduleDao.selectByPrimaryKey(1);//当前暂时为默认根节点;
		module.setExpanded(true);
		List<Module> moduleList=new ArrayList<Module>();
		moduleList=moduleDao.findByQuery(moduleQuery);
		if(strList != null && strList.size()>0){
			for(Module m:moduleList){
				if(strList.contains(m.getId()+"")){
					m.setChecked(true);
				}
			}
		}
		initializeModule(module,moduleList);
		return module;
	}
	@Override
	public Module getModuleByPrimaryKey(Integer Id) {
		// TODO Auto-generated method stub
		return moduleDao.selectByPrimaryKey(Id);
	}
	@Override
	public List<String> getFirstByParentId(Integer Id) {
		// TODO Auto-generated method stub
		return moduleDao.getFirstByParentId(Id);
	}

}
