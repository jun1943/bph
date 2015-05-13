<%@page import="com.tianyi.bph.MainServlet"%>
<%@ page language="java" pageEncoding="utf-8"%>

<%
	if (!MainServlet.contextInited()) {
%>

<%@ include file="install/view/index.jsp"%>

<%
	} else {
%>	
<%@ include file="index.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<title>路由服务安装向导</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="公众,全球眼,天翼，四川天翼，中国电信" />
		<meta http-equiv="description" content="公众平台管理系统" />
		<link href="<%=path%>/style/css.css" type="text/css" rel="stylesheet" />
	</head>

	<body>
		公众平台中心接口服务已完成启动，请通过客户端访问。
		<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----四川天翼网络服务有限公司
		<br />
	</body>
</html>
<%}%>