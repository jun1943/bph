<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<title>公众平台安装向导</title>
		<!DOCTYPE html>
		<link rel="stylesheet" href="<%=basePath%>/install/css/install.css" type="text/css">
		<link rel="stylesheet" href="<%=basePath%>/install/css/buttons.css" type="text/css">
		
		<script type="text/javascript" charset="utf-8" src="<%=basePath%>/install/js/get.js"></script>
		<script type="text/javascript" charset="utf-8" src="<%=basePath%>/install/js/jquery-1.10.1.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="<%=basePath%>/install/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" charset="utf-8" src="<%=basePath%>/install/js/mask.js"></script>
	</head>
	<body class="wp-core-ui">
		<h1 id="logo"><a href="javascript:void()">公众平台LOGO</a></h1>
		<form method="post" action="step.do">
			<input type="hidden" name="step" value="setting"/>
			<p>欢迎使用扁平化指挥系统，在你使用之前，请写成中心服务基础信息未配置！</p>
			<p class="step"><input id="set" type="submit" value="开始配置" class="button button-large"></p>
		</form>
	</body>
</html>