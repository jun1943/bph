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
	
	$(function() {
		var opteType = "";
//		var row = $("#dtPoliceGroup").datagrid("getSelected");
		var kGrid = $("#dtPoliceGroup").data("kendoGrid");
		var row = kGrid.dataItem(kGrid.select());
		if (row !== null) {
			var id = row.id;
			m_police_GroupId = id;
			PoliceGroupManage.loadPoliceGroup(id, PoliceGroupManage.displayPoliceGroup);

			///PoliceGroupManage.showPoliceGroupDlg();
		}
		
		$.ajax({
			url : "orgTest/treelist.do",
			type : "POST",
			dataType : "json",
			data : {
				orgId : m_policeGroup_Org.id,
				orgCode : m_policeGroup_Org.code,
				orgPath : m_policeGroup_Org.path
			},
			// async : false,
			success : function(req) {
				if (req.code==200) {

					var json_data = JSON.stringify(req.data);
					
					$("#treeOrg").kendoTreeView({ 
					    checkboxes: true,
					    dataTextField: "shortName",
					    check : PoliceGroupManage.onCheck,//check复选框
					    dataSource: [eval('(' + json_data + ')')]
					}).data("kendoTreeView");
				} else {
					alert("提示, "+req.msg+"", "warning");
				}
			}
		});
		
		
	});
	
	var PoliceGroupManage ={
			loadPoliceGroup:function(id, callback) {
				$.ajax({
					url : "policeGroup/loadPoliceGroup.do",
					type : "POST",
					dataType : "json",
					data : {
						'policeGroupId' : id
					},
					// async : false,
					success : function(req) {
						callback(req);
					}
				});
			},
		//显示警员组信息
		displayPoliceGroup:function(pg) {
			$("#txtPoliceGroupId").val(pg.id);
			$("#txtPoliceGroupName").val(pg.name);

			if (pg.shareType == 0) {
				$("#radioShare1").prop("checked", true);

				$("#divOrg").css("visibility", "hidden");
			} else {
				$("#radioShare2").prop("checked", true);
				$("#divOrg").css("visibility", "visible");
				PoliceGroupManage.loadOrgs();
			}
//			cleanShareOrgs();
			var count = pg.shareOrgs.length;
			
			
			//for ( var i = 0; i < count; i++) {
				//var pgo = pg.shareOrgs[i];
				//var treeview = $("#treeOrg").data("kendoTreeView");
				//treeview.bind("check", tree_check);
				/* var node = $("#treeOrg").tree("find", pgo.orgId);
				$("#treeOrg").tree("check", node.target); */
			//}
		},
		//是否共享（单选）事件
			changeShareType:function() {
				var val = $('input:radio[name="shareType"]:checked').val();

				if (val == 0) {
					$("#divOrg").css("visibility", "hidden");
//					cleanShareOrgs();
				} else {
					$("#divOrg").css("visibility", "visible");
					//PoliceGroupManage.loadOrgs();
				}
			},
			onCheck : function(e) {
				var checkedNodes = [], treeView = $("#treeOrg").data(
						"kendoTreeView"), message;

				//treeToJson(treeView.dataSource.view());

				PoliceGroupManage.checkedNodeIds(treeView.dataSource.view(),
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
						PoliceGroupManage.checkedNodeIds(nodes[i].children.view(),
								checkedNodes);
					}
				}
			},
		//组保存
		savePoliceGroup : function() {
			var pg = {};
			pg.shareOrgIds = [];

			pg.orgId = m_policeGroup_Org.id;
			pg.id = $("#txtPoliceGroupId").val();
			if (pg.id == undefined || pg.id == "") {
				pg.id = 0;
			}
			// pg.name = $('#txtPoliceGroupName').val();
			var groupName = $.trim($("#txtPoliceGroupName").val());
			if (groupName == "" && groupName == undefined) {
				alert("操作提示，请填写分组名称", "error");
				$("#txtPoliceGroupName").focus();
				return;
			}

			if (groupName.length > 20) {
				alert("错误提示, 分组名称长度过长，限制长度1-20！", "error");
				$("#txtPoliceGroupName").focus();
				return;
			}
			var myReg = /^[^|"'<>]*$/;
			if (!myReg.test(groupName)) {
				alert("错误提示, 分组名称含有非法字符！", "error");
				$("#txtPoliceGroupName").focus();
				return;
			}
			if (opteType == "add") {
				PoliceGroupManage.isExistGroup(groupName, m_policeGroup_Org.id);
				if (!isExist) {
					alert("错误提示, 该分组名称已存在，请重新填写分组名称", "error");
					$("#txtPoliceGroupName").focus();
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
			/* var node = $('#treeOrg').tree('find', m_policeGroup_Org.id);
			$('#treeOrg').tree('check', node.target); */

			//var treeview = $("#treeOrg").data("kendoTreeView");
			//var nodes = treeview.bind("check", tree_check);
			//var nodes = $('#treeOrg').tree('getChecked');
			/* var count = nodes.length;

			for ( var i = 0; i < count; i++) {
				var n = nodes[i];
				pg.shareOrgIds.push(n.id);
			} */

			$.ajax({
				url : "policeGroup/savePoliceGroup.do",
				type : "POST",
				dataType : "json",
				data : {
					'policeGroup' : JSON.stringify(pg)
				},
				async : false,
				success : function(req) {
					if (req.isSuccess) {
						/* $("#dtPoliceGroup").datagrid('reload');
						$('#txtPoliceGroupId').val(req.id);// 回写保存后的id

						$('#winPG').window('close'); */
						alert('提示, 保存成功!');
						$("#winPG").data("kendoWindow").close();
						PoliceGroupManage
								.bindDtGroup("policeGroupTest/list.do");
					} else {
						alert("提示, " + req.msg + ", warning");
					}
				}
			});
		},
		//查询组名（验证组名是否存在）
		isExistGroup:function(name, orgId) {
			isExist = false;
			$.ajax({
				url : "policeGroup/isExistGroup.do",
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
		}
	};
		
	};
	</script>

  </head>
  
  <body>
	<!-- <div id="vertical" style="overflow-x:hidden;"> -->
		<div id="winPG" style="width:330px;height:320px;" title="武器分组管理">
			<div class="pane-content">
				<!-- 左开始 -->
				<div class="demo-section k-header"> 
					<input type="hidden" id="txtWeaponGroupId"></input>
					<ul>
						<li class="ty-input"><label class="ty-input-label" for="txtWeaponGroupName">组名称:</label><input
							type="text" class="k-textbox" name="txtWeaponGroupName"
							id="txtWeaponGroupName" /></li>
						<li class="ty-input"><label class="ty-input-label" for="shareType">共享类型:</label>
							<label><input type="radio" class="k-textbox" name="shareType" value="0"
							onclick="WeaponGroupManage.changeShareType()" id="radioShare1" />不共享</label>
							<label><input type="radio" class="k-textbox" name="shareType" value="1"
							onclick="WeaponGroupManage.changeShareType()" id="radioShare2" />共享到下级</label>
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
						<span class="k-button"  onclick="WeaponGroupManage.saveWeaponGroup()">保存</span>
					</p>
				</div>
			</div>
		<!-- </div> -->
	</div>
  </body>
</html>
