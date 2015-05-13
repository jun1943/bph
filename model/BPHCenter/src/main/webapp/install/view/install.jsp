<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<title>公众平台安装向导</title>
		<!DOCTYPE html>
		<link rel="stylesheet" href="<%=basePath%>css/install.css" type="text/css">
		<link rel="stylesheet" href="<%=basePath%>css/buttons.css" type="text/css">
		
		<script type="text/javascript" charset="utf-8" src="<%=basePath%>js/get.js"></script>
		<script type="text/javascript" charset="utf-8" src="<%=basePath%>js/jquery-1.10.1.min.js"></script>
	</head>
	<body class="wp-core-ui">
		<h1 id="logo"><a href="javascript:void()">公众平台LOGO</a></h1>
			<input type="hidden" name="step" value="finished"/>
			<p id="msg">欢迎使用扁平化指挥系统，中心服务正在启动，请稍后。。。。。。</p>
			<p id="iocn" class='loading'></p>
			<p class="step">
				<input id="gotoService" disabled="disabled" type="submit" value="开始使用" class="button button-large">
				<input id="returnBack" type="button" value="返回配置页面" class="button button-large">
			</p>
		
		<script  type="text/javascript">
			$(document).ready(function(){
				$("#returnBack").click(function(){
					history.back();
				});
				$("#gotoService").click(function(){
					window.location.href="/"
				});
				
				var loop=setInterval(function checkStarted(){
					$.ajax({
						 url: "/<%=request.getParameter("startApp")%>",
		               	complete :function(rsp,status){
		               		if("success"==status){
		               			$("#gotoService").attr("disabled",false);
		               			
		               			clearInterval(loop);
		               			$("#iocn").removeClass("loading").addClass("success");
		               			$("#msg").text("中心服务启动成功。欢迎使用扁平化指挥系统！");
		               		}
		               	}
					});
					
				},1000);
				
			});
		</script>
	</body>
</html>
