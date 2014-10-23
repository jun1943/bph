<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'gpsgroupAddMember.jsp' starting page</title>
    
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
		$("#winPGMember").kendoWindow({});
		var kGrid = $("#dtPoliceGroup").data("kendoGrid");
//		var row = treelist.select();
		var row = kGrid.dataItem(kGrid.select());
		var groupId = row.id;

		PoliceGroupManage.getloadorgTree();
		$.ajax({
			type: "post",
			url: "policeGroupTest/loadMemberByGroupId.do?groupId="+groupId,
			dataType: "json", 
			success: function(req) {
				if (req.code==200) {
					var pdata = req.data;

					var dataSo = new kendo.data.DataSource({
						data: pdata
					});
					$("#dtSelGroupMember").kendoGrid({
						dataSource: dataSo,
						columns : [ {
							title : 'id',
							field : 'id',
							align : 'left',
							width : 10,
							hidden : true
						}, {
							title : '姓名',
							field : 'name',
							align : 'left',
							width : 100
						}, {
							title : '警号',
							field : 'number',
							align : 'left',
							width : 100
						}, {
							title : '上级节点',
							field : 'parentId',
							align : 'left',
							width : 100,
							hidden : true
						} ],
						selectable: "row"
					});
					//PoliceGroupManage.showGroupMemberDlg();
				}
			}
		});
		
		
	});
	var PoliceGroupManage ={
			// >>
			selectMember:function() {
				var rows = $("#treeOrgWithPolice").data("kendoTreeView");
				var node = rows.dataItem(rows.select());
				//alert(node.name);
				PoliceGroupManage.selectMemberModel(node);
			},
			// <<
			unselectMember:function() {
				
			},
			selectMemberModel:function(node) {
				 if (node != null && node.dataType == 2) {

					var datas = $("#dtSelGroupMember").data("kendoGrid");

					var count = datas.rows.length;

					var exists = false;

					for ( var i = 0; i < count; i++) {
						var row = datas.rows[i];
						if (row.id == node.rid) {
							exists = true;
							break;
						}
					}

					if (!exists) {
						var treeview = $("#dtSelGroupMember").data("kendoGrid");
						treeview.append({});
						$('#dtSelGroupMember').datagrid('appendRow', {
							id : node.rid,
							name : node.name,
							code : node.code
						});
					}
					var targets = node.target;
					$('#treeOrgWithPolice').tree('remove', targets);
				} 
			},
			//组员保存
			appendMember:function() {
				var members = [];
				var groupid = $("#txtPoliceGroupId").val();

				var rows = $("#dtSelGroupMember").data("kendoGrid");
				var count = rows.length;

				for ( var i = 0; i < count; i++) {
					var row = rows[i];
					var member = {};
					member.id = 0;
					member.groupId = groupid;
					member.policeId = row.id;
					members.push(member);
				}

				$.ajax({
					url : "policeGroup/appendMember.do",
					type : "POST",
					dataType : "json",
					data : {
						"members" : JSON.stringify(members)
					},
					async : false,
					success : function(req) {
						if (req.isSuccess) {
							alert("提示, 保存成功!");
						//	$('#dtGroupMember').datagrid('reload');
							PoliceGroupManage.getMemberBygroupId(m_policegroup_Id);
							$("#winPGMember").data("kendoWindow").close();
						} else {
							alert("提示, "+req.msg+", warning");
						}
					}
				});
			},
	};
	</script>
  </head>
  
  <body>
	<!-- <div id="vertical" style="overflow-x:hidden;"> -->
		<div id="winPGMember" title="组成员选择" style="width:450px;height:400px;">
			<div class="pane-content">
				<!-- 左开始 -->
				<div class="demo-section k-header"> 
					<input id="txtPoliceGroupId"  type="hidden"></input>
					<ul>
						<li class="ty-input">
							<div class="groupmemberwindowdiv">
								<label id="treetitle" class="treetitle"></label>
								<ul id="treeOrgWithPolice" style="overflow:auto"></ul>
							</div>
						</li>
						<li class="ty-input">
							<button onclick="PoliceGroupManage.selectMember()">&gt&gt</button>
							<button onclick="PoliceGroupManage.unselectMember()">&lt&lt</button>
						</li>
						<li class="ty-input">
							<div id="dtSelGroupMember" fit="true"></div>
						</li>
						
					</ul>
					<p style="float:left;width:100%;margin-top:10px;">
						<span class="k-button"  onclick="PoliceGroupManage.appendMember()">保存</span>
					</p>
				</div>
			</div>
		<!-- </div> -->
	</div>
  </body>
</html>
