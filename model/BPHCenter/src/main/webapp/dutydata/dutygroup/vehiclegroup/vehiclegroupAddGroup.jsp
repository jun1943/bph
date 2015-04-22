<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'gpsgroupAddGroup.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
	$(function() {
		//获取树的信息
		$.ajax({
			url : "orgTest/treelist.do",
			type : "POST",
			dataType : "json",
			data : {
				orgId : m_vehicleGroup_Org.id,
				orgCode : m_vehicleGroup_Org.code,
				orgPath : m_vehicleGroup_Org.path
			},
			// async : false,
			success : function(req) {
				if (req.code == 200) {

					var json_data = JSON.stringify(req.data);

					$("#treeOrg").kendoTreeView({
						checkboxes : true,
						dataTextField : "shortName",
						check : VehicleGroupManage.onCheck,//check复选框
						dataSource : [ eval('(' + json_data + ')') ]
					}).data("kendoTreeView");
				} else {
					alert("提示, " + req.msg + ", warning");
				}
			}
		});
		
	});
	
	var VehicleGroupManage = {
			//单选是否共享事件
			changeShareType : function() {
				var val = $('input:radio[name="shareType"]:checked').val();

				if (val == 0) {
					$("#divOrg").css("visibility", "hidden");
					//cleanShareOrgs();
				} else {
					$("#divOrg").css("visibility", "visible");
				}
			},
			onCheck : function(e) {
				var checkedNodes = [], treeView = $("#treeOrg").data(
						"kendoTreeView"), message;

				//treeToJson(treeView.dataSource.view());

				VehicleGroupManage.checkedNodeIds(treeView.dataSource.view(),
						checkedNodes);

				if (checkedNodes.length > 0) {
					message = checkedNodes.join(",");
					m_checkedNodes_id = message;
				} else {
					message = "";
				}
			},
			checkedNodeIds : function(nodes, checkedNodes) {
				for ( var i = 0; i < nodes.length; i++) {
					if (nodes[i].checked) {
						checkedNodes.push(nodes[i].id);
					}
					if (nodes[i].hasChildren) {
						VehicleGroupManage.checkedNodeIds(nodes[i].children.view(),
								checkedNodes);
					}
				}
			},
			//保存
			saveVehicleGroup : function() {
				var pg = {};
				pg.shareOrgIds = [];

				pg.orgId = m_vehicleGroup_Org.id;
				pg.id = $("#txtVehicleGroupId").val();
				if (pg.id == undefined || pg.id == "") {
					pg.id = 0;
				}
				// pg.name = $('#txtVehicleGroupName').val();
				var groupName = $.trim($("#txtVehicleGroupName").val());
				if (groupName == "" && groupName == undefined) {
					alert("操作提示, 请填写分组名称", "error");
					$("#txtVehicleGroupName").focus();
					return;
				}

				if (groupName.length > 20) {
					alert("错误提示, 分组名称长度过长，限制长度1-20！", "error");
					$("#txtVehicleGroupName").focus();
					return;
				}
				var myReg = /^[^|"'<>]*$/;
				if (!myReg.test(groupName)) {
					alert("错误提示, 分组名称含有非法字符！", "error");
					$("#txtVehicleGroupName").focus();
					return;
				}
				if (opteType == "add") {
					VehicleGroupManage.isExistGroup(groupName,
							m_vehicleGroup_Org.id);
					if (!isExist) {
						alert("错误提示, 该分组名称已存在，请重新填写分组名称", "error");
						$("#txtVehicleGroupName").focus();
						return;
					}
				}
				pg.name = groupName;

				pg.shareType = $('input:radio[name="shareType"]:checked').val();

				var s = m_checkedNodes_id;

				if (m_checkedNodes_id.length > 0) {
					pg.shareOrgIds = m_checkedNodes_id.split(",");
				}

				/**
				 * 强制选择根节点！
				 */
				/* var node = $('#treeOrg').tree('find', m_vehicleGroup_Org.id);
				$('#treeOrg').tree('check', node.target);

				var nodes = $('#treeOrg').tree('getChecked');
				var count = nodes.length;

				for ( var i = 0; i < count; i++) {
					var n = nodes[i];
					pg.shareOrgIds.push(n.id);
				} */

				$.ajax({
					url : "vehicleGroupTest/saveVehicleGroup.do",
					type : "POST",
					dataType : "json",
					data : {
						'vehicleGroup' : JSON.stringify(pg)
					},
					async : false,
					success : function(req) {
						if (req.isSuccess) {
							/* $('#dtVehicleGroup').datagrid('reload');
							$('#txtVehicleGroupId').val(req.id);// 回写保存后的id
							$('#winPG').window('close'); */
							/* VehicleGroupManage
									.bindDtGroup("vehicleGroupTest/list.do"); */
							alert("提示, 保存成功!");
							$("#winPG").data("kendoWindow").close();
						} else {
							alert("提示, " + req.msg + ", warning");
						}
					}
				});
			},
			//判断车辆组名是否存在（重复）
			isExistGroup : function(name, orgId) {
				isExist = false;
				$.ajax({
					url : "vehicleGroup/isExistGroup.do",
					type : "POST",
					dataType : "json",
					async : false,
					data : {
						"name" : name,
						"orgId" : orgId
					},
					success : function(req) {
						if (req.isSuccess && req.Message == "UnExits") {
							isExist = true;
						}
					}
				});
			},
	};
</script>
  </head>
  
  <body>
	<!-- <div id="vertical" style="overflow-x:hidden;"> -->
		<div id="winPG" style="width:330px;height:320px;" title="车辆分组管理">
			<div class="pane-content">
				<!-- 左开始 -->
				<div class="demo-section k-header"> 
					<input type="hidden" id="txtVehicleGroupId"></input>
					<ul>
						<li class="ty-input"><label class="ty-input-label" for="txtVehicleGroupName">组名称:</label><input
							type="text" class="k-textbox" name="txtVehicleGroupName"
							id="txtVehicleGroupName" /></li>
						<li class="ty-input"><label class="ty-input-label" for="shareType">共享类型:</label>
							<label><input type="radio" class="k-textbox" name="shareType" value="0"
							onclick="VehicleGroupManage.changeShareType()" id="radioShare1" />不共享</label>
							<label><input type="radio" class="k-textbox" name="shareType" value="1"
							onclick="VehicleGroupManage.changeShareType()" id="radioShare2" />共享到下级</label>
							</li>
						<li class="ty-input">
							<div class="groupwindowdiv">
								<div id="divOrg">
									<ul id="treeOrg" style="overflow:auto"></ul>
								</div>
							</div>
						</li>
						
					</ul>
					<p style="float:left;width:100%;margin-top:10px;">
						<span class="k-button"  onclick="VehicleGroupManage.saveVehicleGroup()">保存</span>
					</p>
				</div>
			</div>
		<!-- </div> -->
	</div>
  </body>
</html>
