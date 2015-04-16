<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	$(function() {
		var kGrid = $("#dtGpsGroup").data("kendoGrid");
		var row = kGrid.dataItem(kGrid.select());
		if (row !== null) {
			var id = row.id;
			GpsGroupManage.loadGpsGroup(id, GpsGroupManage.displayGpsGroup);

			GpsGroupManage.showGpsGroupDlg();
		}
		//显示创建共享单位树信息
		$.ajax({
				url : "orgTest/treelist.do",
				type : "POST",
				dataType : "json",
				data : {
					orgId : m_gpsGroup_Org.id,
					orgCode : m_gpsGroup_Org.code,
					orgPath : m_gpsGroup_Org.path
				},
				// async : false,
				success : function(req) {
					if (req.code == 200) {

						var json_data = JSON.stringify(req.data);

						$("#treeOrg").kendoTreeView({
							checkboxes : true,
							dataTextField : "shortName",
							check : GpsGroupManage.onCheck,//check复选框
							dataSource : [ eval('(' + json_data + ')') ]
						}).data("kendoTreeView");
					} else {
						alert("提示, " + req.msg + "", "warning");
					}
				}
			});
	});
	var GpsGroupManage = {
		
		onCheck : function(e) {
			var checkedNodes = [], treeView = $("#treeOrg").data(
					"kendoTreeView"), message;

			//treeToJson(treeView.dataSource.view());

			GpsGroupManage.checkedNodeIds(treeView.dataSource.view(),
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
					GpsGroupManage.checkedNodeIds(nodes[i].children.view(),
							checkedNodes);
				}
			}
		},
		//判断是否共享事件
		changeShareType : function() {
			var val = $('input:radio[name="shareType"]:checked').val();

			if (val == 0) {
				$("#divOrg").css("visibility", "hidden");
				//			cleanShareOrgs();
			} else {
				$("#divOrg").css("visibility", "visible");
				GpsGroupManage.loadOrgs();
			}
		},
		//显示gps组信息
		displayGpsGroup : function(pg) {
			$("#txtGpsGroupId").val(pg.id);
			$("#txtGpsGroupName").val(pg.name);

			if (pg.shareType == 0) {
				$("#radioShare1").prop("checked", true);

				$("#divOrg").css("visibility", "hidden");
			} else {
				$("#radioShare2").prop("checked", true);
				$("#divOrg").css("visibility", "visible");
				GpsGroupManage.loadOrgs();
			}
			//		cleanShareOrgs();
			var count = pg.shareOrgs.length;
			/* for ( var i = 0; i < count; i++) {
				var pgo = pg.shareOrgs[i];
				var node = $("#treeOrg").tree('find', pgo.orgId);
				$('#treeOrg').tree('check', node.target);
			} */
		},
		//查询需要修改的gps信息
		loadGpsGroup : function(id, callback) {
			$.ajax({
				url : "gpsGroup/loadGpsGroup.do",
				type : "POST",
				dataType : "json",
				data : {
					'gpsGroupId' : id
				},
				// async : false,
				success : function(req) {
					callback(req);
				}
			});
		},
		//保存
		saveGpsGroup : function() {
			var pg = {};
			pg.shareOrgIds = [];

			pg.orgId = m_gpsGroup_Org.id;
			pg.id = $("#txtGpsGroupId").val();
			if (pg.id == undefined || pg.id == "") {
				pg.id = 0;
			}
			// pg.name = $('#txtGpsGroupName').val();
			var groupName = $.trim($("#txtGpsGroupName").val());

			if (groupName == "" && groupName == undefined) {
				alert("操作提示, 请填写分组名称", "error");
				$("#txtGpsGroupName").focus();
				return;
			}

			if (groupName.length > 20) {
				alert("错误提示, 分组名称长度过长，限制长度1-20！", "error");
				$("#txtGpsGroupName").focus();
				return;
			}
			var myReg = /^[^|"'<>]*$/;
			if (!myReg.test(groupName)) {
				alert("错误提示, 分组名称含有非法字符！", "error");
				$("#txtGpsGroupName").focus();
				return;
			}
			if (opteType == "add") {
				GpsGroupManage.isExistGroup(groupName, m_gpsGroup_Org.id);
				if (!isExist) {
					alert("错误提示, 该分组名称已存在，请重新填写分组名称", "error");
					$("#txtGpsGroupName").focus();
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
			/* var node = $('#treeOrg').tree('find', m_gpsGroup_Org.id);
			$('#treeOrg').tree('check', node.target);

			var nodes = $('#treeOrg').tree('getChecked');
			var count = nodes.length;

			for ( var i = 0; i < count; i++) {
				var n = nodes[i];
				pg.shareOrgIds.push(n.id);
			} */

			$.ajax({
				url : "gpsGroupTest/saveGpsGroup.do",
				type : "POST",
				dataType : "json",
				data : {
					'gpsGroup' : JSON.stringify(pg)
				},
				async : false,
				success : function(req) {
					if (req.isSuccess) {
						//					$('#dtGpsGroup').datagrid('reload');
						$("#txtGpsGroupId").val(req.id);// 回写保存后的id
						//					$('#winPG').window('close');
						GpsGroupManage.bindDtGroup("gpsGroupTest/list.do");
						$("#winPG").data("kendoWindow").close();
						alert("提示, 保存成功!");
					} else {
						alert("提示, " + req.msg + ", warning");
					}
				}
			});
		},
	};
</script>
</head>

<body>
	<div id="winPG" class="easyui-window" title="GPS-分组管理"
		style="width:330px;height:320px;"
		data-options="iconCls:'icon-tianyi-save',modal:true" closed="true"
		collapsible="false" minimizable="false" maximizable="false"
		resizable="false" shadow="false">

		<input type="hidden" id="txtGpsGroupId"></input>
		<table class="groupwindowtable">
			<tr>
				<td style="text-align:right"><lable>组名称:</lable></td>
				<td><input id="txtGpsGroupName" type="text"
					class="easyui-validatebox"
					data-options="required:true,validType:['length[1,20]']"></input></td>
			</tr>
			<tr>
				<td style="text-align:right"><lable>共享类型:</lable></td>
				<td><label><input id="radioShare1" name="shareType"
						type="radio" value="0" onclick="GpsGroupManage.changeShareType()"></input>不共享</label>
					<label><input id="radioShare2" name="shareType"
						type="radio" value="1" onclick="GpsGroupManage.changeShareType()"></input>共享到下级</label></td>
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
			<div class="btn-group groupwindowtoolbar">
				<a id="btnSaveGpsGroup" href="javascript:void(0);"
					class="easyui-linkbutton groupwindowbtn"
					onclick="GpsGroupManage.saveGpsGroup()"> 保 存 </a>
			</div>
		</div>
	</div>

</body>
</html>
