/**
 * @author fantedan@tieserv.com
 *
 * @date  2015-1-13 下午3:13:45
 */
package com.tianyi.bph.common;

/**
 *
 * @author fantedan@tieserv.com
 * @date  2015-1-13 下午3:13:45
 */
public class MessageCode {
	/**
	 *返回状态代码注释
	 *成功 200
	 *失败300
	 *失败细分以3开头
	 */
	public final static int STATUS_SUCESS = 200;
	public final static int STATUS_FAIL = 300;
	
	//参数缺失
	public final static int STATUS_NOTPRESENT = 301;
	//参数类型错误
	public final static int STATUS_TYPEMISMATCH = 302;
	//添加修改有不能重复字段
	public final static int STATUS_NOTUNIQUE = 303;
	//机构有子节点不能删除
	public final static int STATUS_HASCHILD = 304;
	
	//系统内部异常
	public final static int STATUS_EXCEPTION = 399;
	
	public static final String SELECT_SUCCESS="获取信息成功";
	
	public static final String ADD_ORGAN_SUCCESS="添加机构成功";
	public static final String UPDATE_ORGAN_SUCCESS="修改机构信息成功";
	public static final String DELETE_ORGAN_SUCCESS="删除机构成功";
	public static final String SELECT_ORGAN_SUCCESS="查询机构信息成功";
	public static final String SELECT_ORGAN_FAIL="查询机构信息失败";
	public static final String ADD_ORGAN_FAIL="添加机构失败";
	public static final String ADD_ORGAN_FAIL_BYCODENAME="添加机构失败,机构编码或者机构名称已存在";
	public static final String UPDATE_ORGAN_FAIL="修改机构信息失败";
	public static final String DELETE_ORGAN_FAIL="删除机构失败，该机构下面有用户或者子机构";
	public static final String GET_TREE_FAIL="获取机构树失败";
	
	public static final String ADD_BAYONET_FAIL_BYCODENAME="添加卡口失败,卡口编码或者卡口名称已存在";
	public static final String GET_BAYONET_LIST_FAIL="获取卡口列表成功";
	
	
	public static final String UPDATE_CARDPOINT_SUCCESS="修改卡点信息成功";
	public static final String UPDATE_CARDPOINT_FAIL="修改卡点信息失败";
}
