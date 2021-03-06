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
<%@ include file="../../emulateIE.jsp" %>	
</head>
<body>
	<div id="wrapper">
		<div id='main-nav-bg'></div>
		<nav class="" id="main-nav">
			<div class='navigation'>
				<%@ include file="../../left.jsp"%>
			</div>
		</nav>

		<section id='content'>
			<div class="container-fluid">
				<div id="content-wrapper" class="row-fluid">
					<div class='span12'>

						<div class="row-fluid">
							<!----功能模块---->
							<div class="set">
								<h1>国标授权</h1>
								<div class="clear box">
									<div id="template">
										
										<form id="GBForm">
										<div class="fl set-hei48">
											国标机构名:<input type="search" class="k-textbox" id="gbOrganName" name="gbOrganName" placeholder="等待输入..."/>
												<input type="hidden" id="organId" name="organId" value="${organId}"/>
												<input type="hidden" id="gbOrganIds" name="gbOrganIds" value="${gbOrganIds}"/>
												<button id="textButton" class="ty-btn-search" onclick="searchGBOrgan()"></button>
										</div>
										<div class="fl set-hei48 ml30">
												<span id="undo" class="k-button" onclick="addGBPermission();">授权</span>
										</div>
										</form>
										
									</div>

								</div>
							</div>
						</div>
						<!----功能模块结束---->

						<div class="row-fluid">
							<!----信息显示区---->
							<div class="span8 box">


								<!----listInfo---->
								<div id="GBBOX" class="vertical">
									<div id="gbtreeview"></div>
								</div>

								<div id="dialog"></div>
								<!----listInfo_ENd---->

							</div>
							<!----表格结束---->
							<div class="span4 box">
								<!----权限显示-
								--->
							</div>
							<!----权限显示结束---->
						</div>
						<!----信息显示区结束---->

					</div>
				</div>
			</div>
		</section>
		<script type="text/javascript">
		
		/**
		*初始化加载GB机构信息
		*
		**/
		$(document).ready(function() {
				loadData();
			});
		
		
		/** **/
	   function	loadData(){
		   var  uri="<%=basePath%>web/GBPlatForm/getGBOrganList.do";
				$.ajax({
					url : uri,
					type : "post",
					data : {
						organId : $("#organId").val(),
						sessionId:$("#token").val(),
						random : Math.random()
					},
					dataType : "json",
					success : function(rsp) {
						$("#gbtreeview").remove();//
						$("#GBBOX").append("<div id='gbtreeview'></div>");
						//$("#gbtreeview").empty();
						$("#gbtreeview").kendoTreeView(
								{
									dataValueField : "id",
									dataTextField : "name",
									dragAndDrop : true,
									select : onSelectGB,//点击触发事件
									checkboxes : {
										checkChildren : false
									//允许复选框多选
									},
									check : onCheckGB,//check复选框
									dataSource : [ eval('('
											+ JSON.stringify(rsp.data) + ')') ]
								}).data("kendoTreeView");
					}
				});
			}

			// show checked node IDs on datasource change
			function onCheckGB(e) {
				var checkedNodes = [], treeView = $("#gbtreeview").data(
						"kendoTreeView"), message;

				//treeToJson(treeView.dataSource.view());

				checkedNodeIdsGB(treeView.dataSource.view(), checkedNodes);

				if (checkedNodes.length > 0) {
					message = checkedNodes.join(",");
				} else {
					message = "";
				}
				$("#gbOrganIds").val(message);
			}

			function checkedNodeIdsGB(nodes, checkedNodes) {
				for ( var i = 0; i < nodes.length; i++) {
					if (nodes[i].checked) {
						checkedNodes.push(nodes[i].id);
					}
					if (nodes[i].hasChildren) {
						checkedNodeIdsGB(nodes[i].children.view(), checkedNodes);
					}
				}
			}

			//单击触发事件
			function onSelectGB(e) {
				treeView = $("#gbtreeview").data("kendoTreeView");
				currentText = this.text(e.node);
				treeToJsonGB(treeView.dataSource.view());
			}

			function treeToJsonGB(nodes) {
				return $.map(nodes, function(n, i) {
					if (currentText == n.text) {
						//$("#organId").val(n.id);
						alert(n.spriteCssClass);
					}
					var result = {
						text : n.text,
						id : n.id,
						expanded : n.expanded,
						checked : n.checked
					};

					if (n.hasChildren) {
						result.items = treeToJsonGB(n.children.view());
					}
					return result;
				});
			}

			function onCloseGB(e) {

			}

			function searchGBOrgan() {
				var treeview = $("#gbtreeview").data("kendoTreeView");
				//根据文本查找节点
				treeview.findByText("德阳");
				treeview.read();

			}

			
			/*添加权限*/
			function addGBPermission() {
				
				
				$.ajax({
					url : "<%=basePath%>web/GBPlatForm/addGBPermission.do",
					type : "post",
					data : {
						organId : $("#organId").val(),
						sessionId:$("#token").val(),
						gbOrganIds : $("#gbOrganIds").val()
					},
					dataType : "json",
					success : function(rsp) {
						if (rsp.code == 200) {
							alert("授权成功！");
							loadData();
						}else{
							alert("授权失败:"+rsp.description);
						}
					}
				});
			}
		</script>
	</div>
	
</body>
</html>
