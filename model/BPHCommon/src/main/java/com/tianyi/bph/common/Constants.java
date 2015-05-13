package com.tianyi.bph.common;

/**
 * @author fantedan@tieserv.com
 * 
 * @date 2015-1-13 上午10:44:50
 */

public class Constants {

	/** ActionLogger */
	public static final String SYS_LOGGER_ACTION = "actionLogger";
	/** ServiceLogger */
	public static final String SYS_LOGGER_SERVICE = "serviceLogger";

	public static final String ERROR_FORWARD = "sysErrPath";
	// session timeout
	public static final String TIMEOUT = "timeout";

	/** 配置系统路径 */
	public final static String APPCONFIG_PATH = "config.properties.resource";

	/** 登录用户session */
	public static final String SESSION_KEY_USER_INFO = "userInfo";
	public static final String CURRENT_ACCOUNTID = "currentAccountId";
	/** 接口返回识别码 */
	public static final Integer RESULT_STATUS_SUCCESS = 0;// 操作成功
	public static final Integer RESULT_STATUS_FAIL = 1;// 操作失败

	/** 是否本机构查询类型 */
	public static final int SEARCH_TYPE_NO_CHILD = 1;// 当前机构查询
	public static final int SEARCH_TYPE_CHILD = 2;// 当前机构与子机构查询

	public static final String MQ_TYPE_POLICE = "A"; // 警员
	public static final String MQ_TYPE_VEHICLE = "B"; // 警车
	public static final String MQ_TYPE_ORGAN = "C"; // 机构
	public static final String MQ_TYPE_ICON = "D"; // 图标 占时不用
	public static final String MQ_TYPE_VIDEO = "E"; // 视频点位
	public static final String MQ_TYPE_REPORT = "F"; // 报备信息
	public static final String MQ_TYPE_USER = "G"; // 用户
	public static final String MQ_TYPE_ALARM = "H"; // 警情 数据
	public static final String MQ_TYPE_CARDKOU = "I"; // 卡口
	public static final String MQ_TYPE_CARDPOINT = "J"; // 卡点
	public static final String MQ_TYPE_AREA = "K"; // 区域
	public static final String MQ_TYPE_WEAPON = "L"; // 武器

	public static final String MQ_TYPE_GPS = "M";// GPS 基础数据

	public static final int MQ_OPERATE_ADD = 1; // 新增
	public static final int MQ_OPERATE_UPDATE = 2; // 修改
	public static final int MQ_OPERATE_DELETE = 3; // 删除

	public static final String MQ_ROUTING_KEY = "routeData";

}
