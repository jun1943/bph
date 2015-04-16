<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/view/lib.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!--  
<link href='//cdn.datatables.net/plug-ins/a5734b29083/integration/jqueryui/dataTables.jqueryui.css' type='text/css' />
-->	<link rel="stylesheet" type="text/css" href="asset/css/images/dateStyle.css"/>
<%-- <script src='<%=basePath%>script/duty/gpsgroup.js'
	type='text/javascript'></script> --%>
<link href="kendoUI/examples-offline.css" rel="stylesheet">
<link href="kendoUI/kendo.common.min.css" rel="stylesheet">
<link href="kendoUI/kendo.rtl.min.css" rel="stylesheet">
<link href="kendoUI/kendo.default.min.css" rel="stylesheet">
<link href="kendoUI/kendo.dataviz.min.css" rel="stylesheet">
<link href="kendoUI/kendo.dataviz.default.min.css" rel="stylesheet">
<link href="kendoUI/kendo.mobile.all.min.css" rel="stylesheet">
<script src="kendoUI/jquery.min.js"></script>
<script src="kendoUI/angular.min.js"></script>
<script src="kendoUI/kendo.all.min.js"></script>
<script src="kendoUI/console.js"></script>

<title>定位设备分组</title>

<script type="text/javascript">

$(function() {
	var pg = {};
		pg.shareOrgs = [];
		pg.id = 0;
		pg.shareType = 0;
		var po = {};
		po.orgId = m_gpsGroup_Org.id;
		pg.shareOrgs.push(po);
		$("#txtGpsGroupId").val(pg.id);
		$("#txtGpsGroupName").val(pg.name);

		if (pg.shareType == 0) {
			$("#radioShare1").prop("checked", true);

			$("#divOrg").css("visibility", "hidden");
		} else {
			$("#radioShare2").prop("checked", true);
			$("#divOrg").css("visibility", "visible");
			//GpsGroupManage.loadOrgs();
		}
//		cleanShareOrgs();
		var count = pg.shareOrgs.length;
		/* for ( var i = 0; i < count; i++) {
			var pgo = pg.shareOrgs[i];
			var node = $("#treeOrg").tree('find', pgo.orgId);
			$('#treeOrg').tree('check', node.target);
		} */
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
				if (req.code==200) {

					var json_data = JSON.stringify(req.data);
					
					$("#treeOrg").kendoTreeView({ 
					    checkboxes: true,
					    dataTextField: "shortName",
					    check: GpsGroupManage.onCheck,//check复选框
					    dataSource: [eval('(' + json_data + ')')]
					}).data("kendoTreeView");
				} else {
					alert("提示, "+req.msg+"", "warning");
				}
			}
		});
});

var GpsGroupManage ={
	
	//判断是否共享事件
	changeShareType:function() {
		var val = $('input:radio[name="shareType"]:checked').val();

		if (val == 0) {
			$("#divOrg").css("visibility", "hidden");
//			cleanShareOrgs();
		} else {
			$("#divOrg").css("visibility", "visible");
			//GpsGroupManage.loadOrgs();
		}
	},
	
	onCheck:function(e) {
		var checkedNodes = [],treeView = $("#treeOrg").data("kendoTreeView"),message;

		   //treeToJson(treeView.dataSource.view());
		   
		   GpsGroupManage.checkedNodeIds(treeView.dataSource.view(), checkedNodes);

		   if (checkedNodes.length > 0) {
		       message = checkedNodes.join(",");
		       m_checkedNodes_id = message;
		   } else {
		       message = "";
		   }
	},
	checkedNodeIds:function(nodes, checkedNodes) {
		for (var i = 0; i < nodes.length; i++) {
	         if (nodes[i].checked) {
	             checkedNodes.push(nodes[i].id);
	         } 
	         if (nodes[i].hasChildren) {
	        	 GpsGroupManage.checkedNodeIds(nodes[i].children.view(), checkedNodes);
	         }
	     }
	},
	//保存
	saveGpsGroup:function() {
		var pg = {};
		pg.shareOrgIds = [];

		pg.orgId = m_gpsGroup_Org.id;
		pg.id = $("#txtGpsGroupId").val();
		if(pg.id==undefined||pg.id==""){
			pg.id=0;
		}
		// pg.name = $('#txtGpsGroupName').val();
		var groupName = $.trim($("#txtGpsGroupName").val());

		if (groupName == "" && groupName == undefined) {
			alert("操作提示, 请填写分组名称", "error");
			$("#txtGpsGroupName").focus();
			return;
		}

		if(groupName.length>20){
			alert("错误提示, 分组名称长度过长，限制长度1-20！", "error");
			$("#txtGpsGroupName").focus();
			return;
		}
		var myReg = /^[^|"'<>]*$/;
		if(!myReg.test(groupName)){
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
		 
		 if(m_checkedNodes_id.length>0){
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
					alert("提示, "+req.msg+", warning");
				}
			}
		});
	},
	
	//创建时，判断GPS组名是否存在
	isExistGroup:function(name, orgId) {
		isExist = false;
		$.ajax({
			url : "gpsGroup/isExistGroup.do",
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
		<div id="winPG" style="width:330px;height:320px;" title="组成员选择">
			<div class="pane-content">
				<!-- 左开始 -->
				<div class="demo-section k-header"> 
					<input type="hidden" id="txtGpsGroupId"></input>
					<ul>
						<li class="ty-input"><label class="ty-input-label" for="txtGpsGroupName">组名称:</label><input
							type="text" class="k-textbox" name="txtGpsGroupName"
							id="txtGpsGroupName" /></li>
						<li class="ty-input"><label class="ty-input-label" for="shareType">共享类型:</label>
							<label><input type="radio" class="k-textbox" name="shareType" value="0"
							onclick="GpsGroupManage.changeShareType()" id="radioShare1" />不共享</label>
							<label><input type="radio" class="k-textbox" name="shareType" value="1"
							onclick="GpsGroupManage.changeShareType()" id="radioShare2" />共享到下级</label>
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
						<span class="k-button"  onclick="GpsGroupManage.saveGpsGroup()">保存</span>
					</p>
				</div>
			</div>
		<!-- </div> -->
	</div>
  </body>
</html>
