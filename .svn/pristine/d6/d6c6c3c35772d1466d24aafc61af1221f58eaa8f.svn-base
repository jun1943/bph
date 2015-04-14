<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test4.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>Skin/Default/css/global.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Skin/Default/css/base.css"/>
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath %>JS/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="<%=basePath %>JS/jquery-1.11.1.min.js"></script>
	<link href='<%=basePath %>Skin/assets/stylesheets/bootstrap/bootstrap.css' media='all' rel='stylesheet' type='text/css' />
	<!-- / flatty theme -->
	<link href='<%=basePath %>Skin/assets/stylesheets/light-theme.css' id='color-settings-body-color' media='all' rel='stylesheet' type='text/css' />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!-- / kendo -->
	<link href="<%=basePath %>resources/css/web/kendo.common.min.css" media='all' rel='stylesheet' type='text/css' />
	<link href="<%=basePath %>resources/css/web/kendo.default.min.css" media='all' rel='stylesheet' type='text/css' />
	<link href="<%=basePath %>resources/css/dataviz/kendo.dataviz.min.css" media='all' rel='stylesheet' type='text/css' />
	<link href="<%=basePath %>resources/css/dataviz/kendo.dataviz.default.min.css" media='all' rel='stylesheet' type='text/css' />		
	<script src="<%=basePath %>resources/js/jquery.min.js" type='text/javascript'></script>
	<script src="<%=basePath %>resources/js/kendo.all.min.js" type='text/javascript'></script>
	<script src="<%=basePath %>JS/json2.js" type='text/javascript'></script>
		
	</head>
	<body>
		
		<!-- <div id="example">
		
		    <div class="demo-section k-header">
		        <div class="box-col" id="box">
		            <h4>Check nodes</h4>
		            <div id="treeview"></div>
		        </div>
		        <div class="box-col">
		            <h4>Status</h4>
		            <p id="result">No nodes checked.</p>
		        </div>
		    </div>
	    </div>
	    <input id="organId"/><br>
	    <input id="organName" /><input value="查询" type="button" onClick="queryOrgan()"/> -->
		<div class="box-col" id="box">
            <div id="treeview"></div>
		</div>
		<script>
			 var zNodes;
			 var json_data;
			 var currentText;//当前选中的文本
			 $(document).ready(function () {
				 $.ajax({
						url:"<%=basePath%>web/organx/tree.do",
						type:"post",
						data:{
							name:"",
							random:Math.random()
						},
						dataType:"json",
						success:function(rsp){
							json_data =JSON.stringify(rsp.data);
							
							$("#treeview").kendoTreeView({
								select: onSelect,//点击触发事件
							   /*  checkboxes: {
							        checkChildren: true//允许复选框多选
							    }, */
							    //check: onCheck,//check复选框
							    dataSource: [eval('(' + json_data + ')')]
							}).data("kendoTreeView");
						}
					});
			 });
			 
			 //查询通过name模糊查询
		        function queryOrgan(){
		        	$.ajax({
						url:"<%=basePath%>web/organx/tree.do",
						type:"post",
						data:{
							name:$("#organName").val(),
							random:Math.random()
						},
						dataType:"json",
						success:function(rsp){
							json_data =JSON.stringify(rsp.data);
							
							$("#treeview").remove();
							$("#box").append("<div id='treeview'></div>");
							$("#treeview").kendoTreeView({
								select: onSelect,
							    checkboxes: {
							        checkChildren: true
							    },
							    check: onCheck,
							    dataSource: [eval('(' + json_data + ')')]
							}).data("kendoTreeView");
						}
		        	});
		        }
			 //单击触发事件
		 	 function onSelect(e) {
		 		 treeView = $("#treeview").data("kendoTreeView")
		 		 currentText=this.text(e.node);
		 		var json = treeToJson(treeView.dataSource.view());
			 }
		 	 
		 	function treeToJson(nodes) {
		 	    return $.map(nodes, function(n, i) {
		 	    	if(currentText == n.text){
		 	    		$("#organId").val(n.id);
		 	    	}
		 	        var result = { text: n.text, id: n.id, expanded: n.expanded, checked: n.checked };

		 	        if (n.hasChildren){
		 	        	 result.items = treeToJson(n.children.view());
		 	        }
		 	        return result;
		 	    });
		 	}
		 // function that gathers IDs of checked nodes
	        function checkedNodeIds(nodes, checkedNodes) {
	            for (var i = 0; i < nodes.length; i++) {
	                if (nodes[i].checked) {
	                    checkedNodes.push(nodes[i].id);
	                }

	                if (nodes[i].hasChildren) {
	                    checkedNodeIds(nodes[i].children.view(), checkedNodes);
	                }
	            }
	        }
	        // show checked node IDs on datasource change
	        function onCheck() {
	            var checkedNodes = [],
	                treeView = $("#treeview").data("kendoTreeView"),message;

	            checkedNodeIds(treeView.dataSource.view(), checkedNodes);

	            if (checkedNodes.length > 0) {
	                message = "IDs of checked nodes: " + checkedNodes.join(",");
	            } else {
	                message = "No nodes checked.";
	            }
	            $("#result").html(message);
	        }
		</script>
	
 	</body>
</html>
