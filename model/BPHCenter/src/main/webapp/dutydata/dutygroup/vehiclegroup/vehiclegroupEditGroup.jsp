<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'gpsgroupEditGroup.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
var opteType = ""
$(function() {
	
	opteType = optType;
	//	var row = $("#dtVehicleGroup").datagrid("getSelected");
	var kGrid = $("#dtVehicleGroup").data("kendoGrid");
	var row = kGrid.dataItem(kGrid.select());
	if (row !== null) {
		var id = row.id;
		VehicleGroupManage.loadVehicleGroup(id,
				VehicleGroupManage.displayVehicleGroup);

		//VehicleGroupManage.showVehicleGroupDlg();
	}
	
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
		//查询需要修改选项的信息
		loadVehicleGroup : function(id, callback) {
			$.ajax({
				url : "vehicleGroup/loadVehicleGroup.do",
				type : "POST",
				dataType : "json",
				data : {
					'vehicleGroupId' : id
				},
				// async : false,
				success : function(req) {
					callback(req);
				}
			});
		},
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
    <div id="winPG" class="easyui-window" title="车辆分组管理"
		style="width:330px;height:320px;"
		data-options="iconCls:'icon-tianyi-save',modal:true" closed="true"
		collapsible="false" minimizable="false" maximizable="false"
		resizable="false" shadow="false">

		<input type="hidden" id="txtVehicleGroupId"></input>
		<table class="groupwindowtable">
			<tr>
				<td style="text-align:right"><lable>组名称:</lable></td>
				<td><input id="txtVehicleGroupName" type="text"
					class="easyui-validatebox"
					data-options="required:true,validType:['length[1,20]']"></input></td>
			</tr>
			<tr>
				<td style="text-align:right"><lable>共享类型:</lable></td>
				<td><label><input id="radioShare1" name="shareType"
						type="radio" value="0" onclick="VehicleGroupManage.changeShareType()"></input>不共享</label> <label><input
						id="radioShare2" name="shareType" type="radio" value="1"
						onclick="VehicleGroupManage.changeShareType()"></input>共享到下级</label></td>
			</tr>

			<tr>
				<td colspan="2">
					<div class="groupwindowdiv">
						<div id="divOrg">
							<ul id="treeOrg" class="easyui-tree" style="overflow:auto"></ul>
						</div>

					</div>
				</td>
			</tr>
		</table>
		<div id="tbGroup" class="btn-toolbar groupwindowtoolbar">
			<div class="btn-group" style="width:100%">
				<a id="btnSaveVehicleGroup" href="javascript:void(0);"
					class="easyui-linkbutton groupwindowbtn"
					onclick="VehicleGroupManage.saveVehicleGroup()"> 保 存 </a>
			</div>
		</div>
	</div>
  </body>
</html>
