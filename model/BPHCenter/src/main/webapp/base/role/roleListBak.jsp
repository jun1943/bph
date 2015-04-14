<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
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

<title>角色管理</title>

</head>

<body> 
<script type="text/javascript">
	var zNodes;
	var v="";
	var url = "<%=basePath %>role/gotoRoleList.action";
	$(document).ready(function(){
		pager(url,${roleList.currentPage},${roleList.totalPages});
		/* 页面加载时自动去加载树 */
		$.ajax({
			url:"<%=basePath%>web/organx/tree.do",
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

	/* 查询功能 */
	function queryRole(){
		window.location.href="<%=basePath%>role/gotoRoleList.action?name="+$("#queryName").val();
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
	               }
	           }
	       };
	    
	    /* 跳转到添加角色界面  */
	    function gotoRole(){
	    	window.location.href="<%=basePath%>role/gotoAddRole.action";
	    }
		/* 跳转到role详情界面 */	    
	    function ToRoleDetail(roleId){
	    	window.location.href="<%=basePath%>role/gotoRoleDetail.action?roleId="+roleId;
	    }
		/* 删除角色信息 */
		function deleteRole(roleId){
			$.ajax({
				url:"<%=basePath%>role/delete.do",
				type:"post",
				dataType:"json",
				data:{
					roleId:roleId
				},
				success:function(msg){
					if(msg.code==200){
						alert(msg.description);
						window.location.href="<%=basePath%>role/gotoRoleList.action";
					}else{
						alert(msg.description);
					}
				}
			});
		}
		
		 function pager(url,currentPage,totalPages){
	       	  var previousUrl=null;
	       	  var nextUrl=null;
	       	  if((currentPage-1)>0){
	       		  previousUrl = url+"?pageNo="+(currentPage-1);
	       	  }else{
	       		  previousUrl = "#";
	       	  }
	       	  
	       	  if(currentPage<=(totalPages-1)){
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
		 /* 名称排序  */
		 function sortByName(){
			 var nameSort=$("#nameSort").val();
			 window.location.href="<%= basePath%>role/gotoRoleList.action?nameSort="+nameSort;
		 }
		 /* 时间排序 */
		 function sortByTime(){
			 var timeSort=$("#timeSort").val();
			 window.location.href="<%= basePath%>role/gotoRoleList.action?timeSort="+timeSort;
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
      </div> <!----机构树结束---->
      <div><img src="<%=path %>/Skin/Default/images/line3.png"></div>
      <div class="mt16"><img src="<%=path %>/Skin/Default/images/line2.png"></div>
    </div><!----中部管理树结束---->
    
    <div id="using" class="fl"><!----应用界面---->
       
       <%-- <div>
       <form action="<%=path %>/admin/gotoUserList.action" method="get">
        <div class="w640 fl">
          <div>
            <div class="fl mt16 mr10"><img src="<%=path %>/Skin/Default/images/mark2.png"></div>
            <h1 class="fl">角色管理</h1>
            <div class="fr"><img src="<%=path %>/Skin/Default/images/walking.png"></div>
            <div class="fr mt5 mr40"><img src="<%=path %>/Skin/Default/images/guanli-15.png"></div>
            <div class="fr mr10"><h1>600</h1></div>
          </div>
          <div>
           
           <div class="fl mt16 ml40 blue font-size12">
              <label>角色名称：</label>
              <td><input type="text" class="form-control" id="queryName" name="queryName" value="" placeholder="等待输入...">
            </div>
          </div>
        </div>
        <div class="search_button"><input name="" type="button" onclick="queryRole()"></div>
        <!-- <div class="fl ml20"><a class="search_button" onclick="queryRole()"></a></div> -->
        <!-- <div class="fl mt5 ml20"><a href="#" onclick="gotoRole()" class=" operation"></a></div> -->
       <div class="fl line2 op4 mt16"></div><!----功能模块分割带---->
          <div class="fl mt16 ml10 operation"><input name="" type="button" onclick="gotoRole()"></div><!----操作按钮---->
        </form>
      </div> --%>
      <form action="" method="post">
        <div class="set" ><!----功能模块---->
          <div class="w785">
            <div class="title-1"><!----功能模块标题与搜索输入---->
            <h1>角色管理</h1>
            <h2 class="staff" id="totalRows">600</h2>
              <div class="fr w640"><!----功能模块查询输入---->
                <p>角色名称：</p>
                <input type="text" class="set_input" placeholder="等待输入..." id="queryName" name="queryName" value="">
              </div><!----功能模块查询输入结束---->
            </div> <!----功能模块标题与搜索输入结束---->
            <div class="search_button"><input name="" type="button" onclick="queryRole()"></div><!----搜索按钮样式---->
          </div>
          
          <!-- <div class="fl line2 op4 mt16"></div> --><!----功能模块分割带---->
          <div class="fl mt16 ml10 operation"><input name="" type="button" onclick="gotoRole()"></div><!----操作按钮---->
        </div><!----功能模块结束---->
      </form>
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      <div class="clear"></div>
      
       <div class="mt16"><!----表格---->
        <table class="table" id="table1">
          <thead>
            <tr>
              <th class="pl20">
                <div class="checkbox">
  		          <!-- <input type="checkbox" id="checkboxInput" name=""/>
                  <label for="checkboxInput"></label> -->
                </div>
              </th>
              <th class="orange">操作</th>
              <c:if test="${query.nameSort==0 || query.nameSort==2}">
              	<input type="hidden" id="nameSort" value="1">
              	<th onclick="sortByName()">角色名称</th>
              </c:if>
               <c:if test="${query.nameSort==1}">
              	<input type="hidden" id="nameSort" value="2">
              	<th onclick="sortByName()">角色名称</th>
              </c:if>
			  <th>描述</th>
			  <c:if test="${query.timeSort==0 || query.timeSort==2}">
              	<input type="hidden" id="timeSort" value="1">
              	<th onclick="sortByTime()">创建时间</th>
              </c:if>
              <c:if test="${query.timeSort==1}">
              	<input type="hidden" id="timeSort" value="2">
              	<th onclick="sortByTime()">创建时间</th>
              </c:if>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="item" items="${roleList.data}">
            <tr>
              <td class="pl20">
                <!-- <div class="checkbox">
  		          <input type="checkbox" id="checkboxInput" name=""/>
                  <label for="checkboxInput"></label>
                </div> -->
              </td>
              <td>
                <div class="auto w100b">
                  <a href="javascript:void(0)" onclick="ToRoleDetail('${item.id}')" class="table-change fl"></a>
                  <a href="javascript:void(0)" onclick="deleteRole('${item.id}')" class="table-delete fr"></a>
                </div>
              </td>
              <td>${item.name}</td>
			  <td>${item.note}</td>
			  <td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
        <!-- 分页 -->
        <div id="pager">
	        <table id="tablePager">
	        <tbody></tbody>
	        </table>
      	</div>
      	
      </div><!----表格结束---->
    </div><!----应用界面结束---->
</div> 
<%@ include file="../../message.jsp" %>
</body>

</html>
