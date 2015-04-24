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
	$("#dutyTypeTreeList").empty();
	DutyTypeManage.loadData();
});
var DutyTypeManage ={
	loadData:function(){
		$.ajax({
			url : "<%=basePath%>dutyTypeWeb/getDutyTypelist.do",
			type : "POST",
			dataType : "json",
			success : function(req) {
				if(req.code == 200){
					if(req.data != null){
						for(var i = 0; i<req.data.length;i++)
						{
							var obj = req.data[i];
							if(obj.parentId ==0)
							{
								obj.parentId = null;
							} 
						}
						var dtdatatemp = JSON.stringify(req.data);
						 
					 	
    $("#dutyTypeTreeList").kendoTreeList({
						 dataSource: {
             				data:dtdatatemp
             			},
						 
							columns : [{
								field : "id",
								title : "id",
								hidden: true
							} ,{
								field : "name",
								expandable: true,
								title : "名称",
								width : 150
							} , {
								title : "人数上限",
								field : "maxPolice",
								align : 'left',
								width : 80,
								template: '#= maxPolice == null || maxPolice == 0 ? "不限" : maxPolice #'
							}, {
								field : "isShowname",
								title : "统计显示方式",
								width : 120,
								template: '#= isShowname == false ? "人数" : "名称" #'

							}, {
								field : "properties",
								title : "属性",
								width : 160,
								template: '#= getProperty(properties) #'
							}, {
								field : "assoTaskType",
								title : "关联任务",
								width : 80,
								template: '#= contactName(assoTaskType) #'
							}, {
								field : "attireType",
								title : "着装",
								width : 60,
								template: '#= attireType == 0 ? "制服" : "便衣" #'
							}, {
								field : "armamentType",
								title : "武器",
								width : 60,
								template: '#= armamentType == 0 ? "非武装" : "武装" #'
							}, {
								field : "isUsed",
								title : "停用",
								width : 60,
								template: '#= isUsed == true ? "启用" : "停用" #'
							}],
							selectable: "row" 
						});
					} 
				}
			}
		});
	},
	selectDutyType:function(){
		alert("选择勤务类型成功");
	}
};
</script>
</head>
<body> 
	<div id="dutyTypeTreeList" style="width:150%"></div>  
	<p style="float:left;width:100%;margin-top:10px;"> 
		<span id="undo" class="k-button" onclick="DutyTypeManage.selectDutyType()">确定</span>
	</p>  
</body> 
</html>