<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
<head>
<title>扁平化指挥系统</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport' />
	
<%@ include file="../../emulateIE.jsp" %>
<script type="text/javascript">
var sessionId = $("#token").val();
$(function() {
	$("#dutyTempletegrid").empty();
	DutyTempManage.loadData();
});
var DutyTempManage ={
	loadData:function(){
		alert("加载报备列表");
	},
	selectDutyTemplete:function(){
		alert("选择报备模板成功");
	}
};
</script>
</head>
<body> 
	<div id="resourceTypegrid" style="width:70%"></div>  
	<div id="resourceGroupgrid" style="width:70%"></div>  
	<p style="float:left;width:100%;margin-top:10px;"> 
		<span id="undo" class="k-button" onclick="DutyTempManage.selectDutyTemplete()">确定</span>
	</p>  
</body> 
</html>