<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Map"%>
<%@ page import="com.tianyi.bph.common.Pager"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<META NAME="Generator" CONTENT="EditPlus">
  <META NAME="Author" CONTENT="">
  <META NAME="Keywords" CONTENT="">
  <META NAME="Description" CONTENT="">
  
<link rel="stylesheet" type="text/css" href="<%=basePath %>Skin/Default/css/global.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>Skin/Default/css/base.css"/>
<script type="text/javascript" src="<%=basePath %>JS/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%=basePath %>JS/jquery-1.11.1.min.js"></script>
<link href="<%=basePath%>JS/ztree/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="<%=basePath%>JS/ztree/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>JS/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=basePath%>JS/My97DatePicker/WdatePicker.js"></script>

<title>帐号管理</title>
</head>

<body>
<script type="text/javascript">
	var zNodes;
	var v="";
	$(document).ready(function(){
		$.ajax({
			url:"<%=path %>/web/organx/tree.do",
			type:"post",
			data:{
				name:$("#orgName").val(),
				random:Math.random()
			},
			dataType:"json",
			success:function(msg){
				zNodes=msg.description;
				$.fn.zTree.init($("#treeDemo"), setting, eval('(' + zNodes + ')'));
			}
		});
		 
	});  

	function searchOrgan(){
		$.ajax({
			url:"<%=path %>/web/organx/tree.do",
			type:"post",
			dataType:"json",
			data:{
				name:$("#organName").val()
			},
			success:function(msg){
				zNodes=msg.description;
				$.fn.zTree.init($("#treeDemo"), setting, eval('(' + zNodes + ')'));
			}
		});
	}
	    var setting = {  
	           view: {  
	        	   dblClickExpand: true,
	               selectedMulti: false       //禁止多点选中  
	           },  
	           data: {  
	               simpleData: {  
	                   enable:true,  
	                   idKey: "id",  
	                   pIdKey: "parentId",  
	                   rootPId: ""  
	               }  
	           },  
	           callback: {  
	               onClick: function(treeId, treeNode) {  
	            	   var treeObj=$.fn.zTree.getZTreeObj("treeDemo");
	                   var nodes=treeObj.transformToArray(treeObj.getNodes());
	                   var selectedNode = treeObj.getSelectedNodes()[0];
	                   $("#organId").val(selectedNode.id);
	                   $("#table1 tbody").remove();
	               		$.ajax({
	               			url:"<%=path %>/admin/getUserList.do",
	               			type:"post",
	               			dataType:"json",
	               			data:{
	               				organId:selectedNode.id
	               			},
	               			success:function(msg){
	               				if(msg.code==200){
	               					document.getElementById("totalRows").innerHTML=msg.totalRows;
	               					if(msg.data != null){
	               						$(msg.data).each(function(){
	               							$("#table1").append("<tbody><tr>"
	               							+"<td></td><td>"
	               							+"<div class='auto w100b'>"
	               						    +"<a href='javascript:void(0)' onclick='ToUserDetail("+this.userId+")' class='table-change fl'></a>"
	               		                    +"<a href='javascript:void(0)' onclick='deleteUser("+this.userId+")' class='table-delete fr'></a>"
	               		                    +"</div>"+"</td><td>"+this.loginName+"</td><td>"+this.userName+"</td><td>"+this.createTime
	               		                    +"</td><td>"+this.updateTime+"</td><td>"+this.stateView+"</td></tr></tbody>");
			               				});
	               					}
	               				}
	               			}
	               		});
	               }
	           }
	       };
	
		function ToUserDetail(userId){
			var organId = $("#organId").val();
			window.location.href="<%=path %>/admin/gotoUserEdit.action?userId="+userId+"&organId="+organId;
		}
		function addUser(){
			var organId = $("#organId").val();
			window.location.href="<%=path %>/admin/gotoUserAdd.do?organId="+organId;
		}		
		function queryUser(){
			var organId = $("#organId").val();
			var userName = $("#userName").val();
			var searchType = $("#searchType").val();
			$("#table1 tbody").remove();
       		$.ajax({
       			url:"<%=path %>/admin/getUserList.do",
       			type:"post",
       			dataType:"json",
       			data:{
       				organId:organId,
       				userName:userName,
       				searchType:searchType
       			},
       			success:function(msg){
       				if(msg.code==200){
       					document.getElementById("totalRows").innerHTML=msg.totalRows;
       					if(msg.data != null){
       						$(msg.data).each(function(){
       							$("#table1").append("<tbody><tr>"
       							+"<td></td><td>"
       							+"<div class='auto w100b'>"
       						    +"<a href='javascript:void(0)' onclick='ToUserDetail("+this.userId+")' class='table-change fl'></a>"
       		                    +"<a href='javascript:void(0)' onclick='deleteUser("+this.userId+")' class='table-delete fr'></a>"
       		                    +"</div>"+"</td><td>"+this.loginName+"</td><td>"+this.userName+"</td><td>"+this.createTime
       		                    +"</td><td>"+this.updateTime+"</td><td>"+this.stateView+"</td></tr></tbody>");
               				});
       					}
       				}
       			}
       		});
			
		}
		function deleteUser(userId){
			var organId = $("#organId").val();
			$.ajax({
				url:"<%=basePath %>admin/userDelete.do",
				type:"get",
				dataType:"json",
				data:{
					userId:userId
				},
				success:function(msg){
					 if(msg.code==200){
						alert(msg.description);
						window.location.href="<%=basePath %>admin/gotoUserList.action?organId="+organId;
					}else{
						alert(msg.description);
					}
				}
			});
		}
		
		
		
	</script>
<div class="mid"><!----中部---->
    <div class="mid-tree mt10 mr20"><!----中部管理树---->
      <div class="line1-mid">
        <div class="t1-start fl"></div>
        <div class="end fr"></div>
      </div>
      
      <div class="fl w172">
        <div class="mr10 mt8 fl"><img src="<%=path %>/Skin/Default/images/guanli-search.png"></div>
        <div class="search-result fl">1500</div>
        <div class="fr mt8"><a href="#"><img src="<%=path %>/Skin/Default/images/button3.png"></a></div>
        <div class="clear"></div>
        <div>
          <input type="text" id="organName" class="search-input mr5 fl">
          <a href="javascript:void(0)" onclick="searchOrgan()" class="search-button dis-cell"></a>
        </div>
      </div>
      
      <div class="fr mt8">
        <div><a href="#"><img src="<%=path %>/Skin/Default/images/button4.png"></a></div>
        <div><img src="<%=path %>/Skin/Default/images/guanli-53.png"></div>
      </div>
      
      <div class="clear"></div>
      <div class="tree-box mt10"><!----机构树---->
        <ul id="treeDemo" class="ztree">  
        </ul>
      </div><!----机构树结束---->
      <div><img src="<%=path %>/Skin/Default/images/line3.png"></div>
      <div class="mt16"><img src="<%=path %>/Skin/Default/images/line2.png"></div>
    </div><!----中部管理树结束---->
    
    <div id="using" class="fl"><!----应用界面---->    
      <form action="<%=path %>/admin/gotoUserList.action" method="post">
        <div class="set"><!----功能模块---->
          <div class="w785">
            <div class="title-1"><!----功能模块标题与搜索输入---->
            <h1>帐号管理</h1>
            <h2 class="staff" id="totalRows">${pager.totalRows}</h2>
              <div class="fr w640"><!----功能模块查询输入---->
                <p>选择查询范围：</p>
                <select class="w176" id="searchType">
                <option value="1">本级机构</option>
                <option value="2">本级机构与下级机构</option>
                </select>
                <p>姓名：</p>
                <input type="text" class="set_input" placeholder="等待输入..." id="userName" name="userName" value="${query.userName}">
                <input type="hidden" id="organId" name="organId" value="${query.organId}"">
                <p>日期示例：</p>
                <input type="text" class="set_input" id="startTime" name="startTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
              </div><!----功能模块查询输入结束---->
            </div> <!----功能模块标题与搜索输入结束---->
            <div class="search_button"><input name="" type="button" onclick="queryUser()"></div><!----搜索按钮样式---->
          </div>
          <div class="fl line2 op4 mt16"></div><!----功能模块分割带---->
          <div class="fl mt16 ml10 operation"><input name="" type="button" onclick="addUser()"></div><!----操作按钮---->
        </div><!----功能模块结束---->
      </form>
      
      <div class="clear"></div>
      
      <div class="mt16"><!----表格---->
        <table class="table" id="table1">
          <thead>
            <tr><th></th>
              <th class="orange">操作</th>
              <th>登录名</th>
			  <th>用户名</th>
			  <th>创建时间</th>
			  <th>修改时间</th>
			  <th>用户状态</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach var="item" items="${pager.data}">
            <tr>
            <td></td>
              <td>
                <div class="auto w100b">
                  <a href="<%=path %>/admin/gotoUserEdit.action?userId=${item.userId}&organId=${query.organId}" class="table-change fl"></a>
                  <a href="javascript:void(0)" onclick="deleteUser(${item.userId})" class="table-delete fr"></a>
                </div>
              </td>
              <td>${item.loginName}</td>
			  <td>${item.userName}</td>
			  <td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			  <td><fmt:formatDate value="${item.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			  <td>${item.stateView}</td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
        <div id="pager">
        <table id="tablePager">
        <tbody></tbody>
        </table>
      </div><!----表格结束---->
      <!----表格结束---->
    </div><!----应用界面结束----> 
    </div><!----中部结束---->
    <%@ include file="../../message.jsp" %>
    
    <script type="text/javascript">           
              function pager(url,organId,currentPage,totalPages){
            	  var previousUrl=null;
            	  var nextUrl=null;
            	  if((currentPage-1)>0){
            		  previousUrl = url+"?pageNo="+(currentPage-1);
            	  }else{
            		  previousUrl = "#";
            	  }
            	  
            	  if(currentPage<(totalPages-1)){
            		  nextUrl = url+"?pageNo="+(currentPage+1);
            	  }else{
            		  nextUrl ="#";
            	  }
            	  $("#tablePager tbody").remove();         	  
            	  $("#tablePager").append("<tbody><tr><td></td><td>"
            	  +"<a href='"+previousUrl+"' class='table-previous-page'></a></td><td>"
            	  +"<a href='"+nextUrl+"' class='table-next-page'></a></td><td>"
            	  +"</td></tr></tbody>"); 
              }
              var url = "<%=basePath %>admin/gotoUserList.action?organId="+organId;
              pager(url,${query.organId},${pager.currentPage},${pager.totalPages});
              </script> 
</body>
</html>


