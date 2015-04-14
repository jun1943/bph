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

<title>机构管理</title>

<style type="text/css">
	 #box{
	 	display: none;
	 }
	 #dialog{
	 	cursor: pointer;
	 }
</style>

</head>

<body> 
<script type="text/javascript">
	var zNodes;
	var v="";
	var url = "<%=basePath %>web/organx/gotoOrganList.action";
    
	$(document).ready(function(){
		pager(url,${pager.currentPage},${pager.totalPages});
		
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
		
        /* 提示框拖拽 */
        $('#box').mousedown(function(event) {
             var isMove = true;
             var abs_x = event.pageX - $('div#box').offset().left;
             var abs_y = event.pageY - $('div#box').offset().top;
             $(document).mousemove(function(event) {
                 if (isMove) {
                     var obj = $('div#box');
                     obj.css({'left':event.pageX - abs_x, 'top':event.pageY - abs_y});
                 };
             }).mouseup(function(event) {
                 isMove = false;
            });
	     }); 
        
        /* 添加机构拖拽 */
        $('#addOrgan').mousedown(function(event) {
            var isMove = true;
            var abs_x = event.pageX - $('div#addOrgan').offset().left;
            var abs_y = event.pageY - $('div#addOrgan').offset().top;
            $(document).mousemove(function(event) {
                if (isMove) {
                    var obj = $('div#addOrgan');
                    obj.css({'left':event.pageX - abs_x, 'top':event.pageY - abs_y});
                };
            }).mouseup(function(event) {
                isMove = false;
           });
	     }); 
        
        /* 修改机构拖拽 */
        $('#editOrgan').mousedown(function(event) {
            var isMove = true;
            var abs_x = event.pageX - $('div#editOrgan').offset().left;
            var abs_y = event.pageY - $('div#editOrgan').offset().top;
            $(document).mousemove(function(event) {
                if (isMove) {
                    var obj = $('div#editOrgan');
                    obj.css({'left':event.pageX - abs_x, 'top':event.pageY - abs_y});
                };
            }).mouseup(function(event) {
                isMove = false;
           });
	     }); 
	}); 
	/* 关闭提示框 */
	function clolseMsgInfo(){
		$('#box').hide();
		$("#using").css("opacity","");
	}
	/* 关闭编辑弹出框 */
	function editMsgInfo(){
		$('#editOrgan').hide();
		$("#using").css("opacity","");
	}
	/* 关闭添加弹出框  */
	function addMsgInfo(){
		$('#addOrgan').hide();
		$("#using").css("opacity","");
	}
	
	function searchOrgan(){
		$.ajax({
			url:"<%=basePath%>web/organx/tree.do",
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
	                   $("#organPath").val(selectedNode.path);
	               		queryOrgan();
	               }
	           }
	       };
		
	    /* 添加机构信息 */
	    function addOrgan(){
  			$.ajax({
  				url:"<%=basePath%>web/organx/addOrgan.do",
  				type:"get",
  				dataType:"json",
  				data:{
  					name:$("#aName").val(),
  					code:$("#aCode").val(),
  					shortName:$("#aShortName").val(),
  					parentId:$("#aParentId").val(),
  					orgTypeCode:$("#aOrgTypeCode").val(),
  					note:$("#aArea").val()
  				},
  				success:function(msg){
  					$("#addOrgan").css("z-index","0");
  					 if(msg.code==200){
  						window.location.href="<%=basePath%>web/organx/gotoOrganList.action";					
					 }else{
						$("#box").css("display", "");
  						$("#message").text(msg.description);
  					}
  				}
  			});
  		}
	    
	    /* 弹出修改机构信息界面 */
		function ToOrganDetail(Id){
			$.ajax({
				url:"<%=basePath%>web/organx/queryOrganDetail.do",
				type:"post",
				dataType:"json",
				data:{
					organId:Id
				},
				success:function(msg){
					 if(msg.code==200){
						 
						$("#editOrgan").css("display", "");
						$("#using").css("opacity","0");
						
						$("#eId").val(msg.data.id);
						$("#eName").val(msg.data.name);
						$("#eShortName").val(msg.data.shortName);
						$("#eArea").val(msg.data.note);
						$("#eTypeCode").val(msg.data.orgTypeCode);
						$("#eCode").val(msg.data.code);
						$("#eParentId").val(msg.data.parentId);
						$("#eParentName").val(msg.data.parentName);
						$("#eOrgTypeCode").val(msg.data.orgTypeCode);
					}
				}
			});
	    }
		/* 修改机构信息 */
		 function editOrgan(){
	  		 $.ajax({
	  			url:"<%=basePath%>web/organx/modifyOrgan.do",
	  			type:"post",
	  			dataType:"json",
	  			data:{
	  				organId:$("#eId").val(),
	  				code:$("#eCode").val(),
	  				name:$("#eName").val(),
	  				shortName:$("#eShortName").val(),
	  				parentId:$("#eParentId").val(),
	  				orgTypeCode:$("#eOrgTypeCode").val(),
	  				note:$("#eArea").val()
	  			},
		  		 success:function(msg){
		  			$("#box").css("display", "");
  					$("#editOrgan").css("z-index","0");
		  			if(msg.code==200){
		  				//$("#message").text(msg.description);
		  				 window.location.href="<%=basePath%>web/organx/gotoOrganList.action";
		  			}else{
		  				$("#message").text(msg.description);
		  			}
		  		}
	  		});
	  	}
		
		/* 弹出添加机构界面 */
		 function showAddOrgan(){
			var oId=$("#organId").val();
			if(oId==""){
				$("#box").css("display", "");
				$("#message").text("请选择机构！");
				return false;
			}
			 $.ajax({
				url:"<%=basePath%>web/organx/gotoAddOrgan.do",
				type:"post",
				dataType:"json",
				data:{
					organId:oId
				},
				success:function(msg){
					 if(msg.code==200){
						$("#addOrgan").css("display", "");
						$("#using").css("opacity","0");
						
						$("#aParentId").val(msg.data.id);
						$("#aParentName").val(msg.data.name);
					}
				}
			});
		}
		 /* 查询机构信息 */
		function queryOrgan(){
			var organId=$("#organId").val();
			var organPath=$("#organPath").val();
			var queryName=$("#queryName").val();
			$.ajax({
				url:"<%=basePath%>web/organx/getOrganList.do",
				type:"post",
       			dataType:"json",
       			data:{
       				organPath:organPath,
       				name:queryName,
       				organLevel:$("#organLevel").val()
       			},
       			success:function(msg){
       				if(msg.code==200){
       					if(msg.data != null){
       						$("#table1 tbody").remove();
       						$(msg.data).each(function(){
       							$("#table1").append("<tbody><tr>"+
       							"<td></td><td>"+
       						 "<div class='auto w100b'>"+
       		                  "<a href='javascript:void(0)' onclick='ToOrganDetail("+this.id+")' class='table-change fl'></a>"+
       		                  "<a href='javascript:void(0)' onclick='deleteOrgan("+this.id+")' class='table-delete fr'></a>"+
       		                "</div>"+
       							"</td><td>"+this.name+"</td><td>"+this.code+"</td><td>"+this.orgTypeName+"</td><td>"+this.shortName+"</td></tr></tbody>");
               				});
       					}
       				}
       			}
			});
		}
		 /* 删除机构信息 */
		function deleteOrgan(Id){
			$.ajax({
				url:"<%=basePath %>web/organx/deleteOrgan.do",
				type:"post",
				dataType:"json",
				data:{
					organId:Id
				},
				success:function(msg){
					$("#box").css("display", "");
					 if(msg.code==200){
						window.location.href="<%=basePath %>web/organx/gotoOrganList.action";
					}else{
						$("#using").css("opacity","0.3");
						$("#message").text(msg.description);
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
        	<input type="text" id="organName" class="search-input mr5 fl">
          <div class="search-button1" style="float:left;">
         	 <input type="button" onclick="searchOrgan()" >
          </div>
          <!-- <a href="javascript:void(0)" onclick="searchOrgan()" class="search-button1"></a> -->
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
       
     <%--   <div>
       <form action="<%=path %>/admin/gotoUserList.action" method="get">
        <div class="w640 fl">
          <div>
            <div class="fl mt16 mr10"><img src="<%=path %>/Skin/Default/images/mark2.png"></div>
            <h1 class="fl">机构管理</h1>
            <div class="fr"><img src="<%=path %>/Skin/Default/images/walking.png"></div>
            <div class="fr mt5 mr40"><img src="<%=path %>/Skin/Default/images/guanli-15.png"></div>
            <div class="fr mr10"><h1>600</h1></div>
          </div>
          <div>
            <div class="fl mt16 ml40 blue font-size12">
              <label>查询范围选择：</label>
              <input type="hidden" id="organId">
              <input type="hidden" id="organPath">
              <select id="organLevel" class="form-control orange">
                <option value="1">本级机构</option>
                <option value="2">本级机构与下级机构</option>
              </select>
            </div>
            <div class="fr mt16 blue font-size12">
              <label>机构名称：</label>
              <td><input type="text" class="form-control" id="queryName" name="queryName" value="" placeholder="等待输入...">
            </div>
          </div>
        </div>
        <div class="search_button"><input name="" type="button" onclick="queryOrgan()"></div><!----搜索按钮样式---->
        <!-- <div class="fl ml20"><a class="search_button" onclick="queryOrgan()"></a></div> -->
         <div class="fl line2 op4 mt16"></div><!----功能模块分割带---->
          <div class="fl mt16 ml10 operation"><input name="" type="button" onclick="showAddOrgan()"></div><!----操作按钮---->
        <!-- <div class="fl mt5 ml20"><a href="#" onclick="showAddOrgan()" class="operation"></a></div> -->
        </form>
      </div> --%>
      <form action="" method="post">
        <div class="set" ><!----功能模块---->
          <div class="w785">
            <div class="title-1"><!----功能模块标题与搜索输入---->
            <h1>机构管理</h1>
            <h2 class="staff" id="totalRows">600</h2>
              <div class="fr w640"><!----功能模块查询输入---->
                <p>选择查询范围：</p>
                <input type="hidden" id="organId">
              	<input type="hidden" id="organPath">
                <select class="w176" id="organLevel">
                <option value="1">本级机构</option>
                <option value="2">本级机构与下级机构</option>
                </select>
                <p>名称：</p>
                <input type="text" class="set_input" placeholder="等待输入..." id="queryName" name="queryName" value="">
              </div><!----功能模块查询输入结束---->
            </div> <!----功能模块标题与搜索输入结束---->
            <div class="search_button"><input name="" type="button" onclick="queryOrgan()"></div><!----搜索按钮样式---->
          </div>
          
          <!-- <div class="fl line2 op4 mt16"></div> --><!----功能模块分割带---->
          <div class="fl mt16 ml10 operation"><input name="" type="button" onclick="showAddOrgan()"></div><!----操作按钮---->
        </div><!----功能模块结束---->
      </form>
      <div class="clear"></div>
      
       <div class="mt16"><!----表格---->
        <table class="table" id="table1">
          <thead>
            <tr>
              <th class="pl20">
              <!--   <div class="checkbox">
  		          <input type="checkbox" id="checkboxInput" name=""/>
                  <label for="checkboxInput"></label>
                </div> -->
              </th>
              <th class="orange">操作</th>
              <th>机构名称</th>
			  <th>机构编码</th>
			  <th>机构类型</th>
			  <!-- <th>机构警种</th> -->
			  <th>机构简称</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach var="item" items="${pager.data}">
            <tr>
              <td class="pl20">
               <!--  <div class="checkbox">
  		          <input type="checkbox" id="checkboxInput" name=""/>
                  <label for="checkboxInput"></label>
                </div> -->
              </td>
              <td>
                <div class="auto w100b">
                  <a href="javascript:void(0)" onclick="ToOrganDetail('${item.id}')" class="table-change fl"></a>
                  <a href="javascript:void(0)" onclick="deleteOrgan('${item.id}')" class="table-delete fr"></a>
                </div>
              </td>
              <td>${item.name}</td>
			  <td>${item.code}</td>
			  <td>${item.orgTypeName}</td>
			  <%-- <td>${item.orgPcCgyName}</td> --%>
			  <td>${item.shortName}</td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
       
        <div id="pager">
	        <table id="tablePager">
	        <tbody></tbody>
	        </table>
      	</div>
      
      </div><!----表格结束---->
      
      
      
    </div><!----应用界面结束---->
</div> 

<%@ include file="../../message.jsp" %>
<%@ include file="addOrganBak.jsp" %>
<%@ include file="editOrgan.jsp" %>

</body>

  <%-- <script type="text/javascript">           
              function pager(url,currentPage,totalPages){
            	  alert("11");
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
              var url = "<%=basePath %>web/organx/gotoOrganList.action";
              pager(url,${pager.currentPage},${pager.totalPages});
              </script>  --%>

</html>
