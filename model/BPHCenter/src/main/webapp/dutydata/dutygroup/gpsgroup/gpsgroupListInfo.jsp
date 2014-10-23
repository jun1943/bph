<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript"> 
var sessionId = $("#token").val(); 
var opteType = "";
$(function() {
	$("#dtGpsGroup").empty();
	loadData(1);
});
function loadData(pageNo){  
	GpsgroupManage.pageNo = pageNo;
	GpsgroupManage.loadGroupData(pageNo); 
	
}
var m_gpsGroup_Query = {};

var GpsgroupManage = { 
	pageNo:1,
	loadGroupData : function(pageNo) {
		$.ajax({
		type: "post",
		url: "",
		dataType: "json",
		data: {
			"gpsGroup_Query": JSON.stringify(m_gpsGroup_Query),
			page: 0,
			rows: 500 //最大500条（必须是最大值）
		},
		success: function(req) {
			if (req.code == 200) { 
				if(req.data != null){
				var rows =req.data; 
				var dataSource = new kendo.data.DataSource({
					data: rows,
					batch: true,
					pageSize: 20
				});
				
				$("#dtGpsGroup").kendoGrid({
					dataSource: dataSource,
					pageable: true,
					columns : [ {
						title : 'Id',
						field : 'id',
						align : 'left',
						width : 10,
						hidden : true
					}, {
						title : '组名称',
						field : 'name',
						align : 'left',
						width : 150
					}, {
						title : '共享类型',
						field : 'shareTypeDesc',
						align : 'left',
						width : 200
					} ],
					selectable: "row",
					change : function(e) {
						var groupId = e.sender.selectable.userEvents.currentTarget.cells[0].innerHTML; 
						m_gpsgroup_Id = groupId;
						GpsgroupManage.loadMemberData(groupId);
					}
				}); 
					} 
				}
			}
		});
	},  
	createGroup:function(){
		var organId = $("#organId").val();
		$("#dialog").kendoWindow({
			width : "680px",
			height : "500px",
			title : "GPS组创建",
			position : {
				top : "100px"
			},
		content: "<%=basePath%>gpsGroupWeb/gotoGpsgroupCreate.do?organId=" + organId+"&sessionId="+sessionId,
					iframe : true, 
					closeCallback :GpsgroupManage.onClose,
					okCallback:GpsgroupManage.onClose
				});
	//	GpsGroupManage.showGpsGroupDlg();
	},
	editGroup:function(){
		var organId = $("#organId").val();
		$("#dialog").kendoWindow({
			width : "680px",
			height : "500px",
			title : "编辑定位设备信息",
			position : {
				top : "100px"
			},
		content: "<%=basePath%>gpsGroupWeb/gotoGpsgroupEdit.do?gpsId="
							+ gpsId + "&organId=" + organId+"&sessionId="+sessionId,
					iframe : true,
					closeCallback :GpsgroupManage.onClose,
					okCallback:GpsgroupManage.onClose
				});
	},
	deleteGroup:function(){
		
			var kGrid = $("#dtGpsGroup").data("kendoGrid");
			var row = kGrid.dataItem(kGrid.select());
			if (row != null) {
				$.ajax({
					url : "gpsGroupTest/deleteGpsGroup.do",
					type : "POST",
					dataType : "json",
					data : {
						"gpsGroupId" : row.id
					},
					async : false,
					success : function(req) {
						if (req.isSuccess) {
							alert('提示, 删除成功!');
							//$('#dtGpsGroup').datagrid('reload');
							bindDtGroup("gpsGroupTest/list.do");
							GpsGroupManage.getMemberBygroupId(m_gpsgroup_Id);
						} else {
							$.messager.alert("提示,"+req.msg+", "+warning+"");
						}
					}
				});
	}
	},
	loadMemberData:function(groupId){
		$.ajax({
					type: "post",
					url: "gpsGroupTest/loadMemberByGroupId.do?groupId="+groupId,
					dataType: "json", 
					success: function(req) {
						if (req.code==200) {
							var pdata = req.data;
	 
										var dataSo = new kendo.data.DataSource({
											data: pdata
										});
										$("#dtGroupMember").kendoGrid({
											dataSource: dataSo,
											columns : [ {
												title : 'id',
												field : 'id',
												hidden : true
											}, {
												title : '所属单位',
												field : 'orgShortName'
											}, {
												title : '设备类型',
												field : 'typeName'
											}, {
												title : '设别编号',
												field : 'number'
											}, {
												title : '设备名称',
												field : 'gpsName'
											}, ],
											selectable: "row"
										});
									}
								}
							});
						} ,
	addMember:function(){
		var organId = $("#organId").val();
		$("#dialog").kendoWindow({
			width : "680px",
			height : "500px",
			title : "GPS组管理",
			position : {
				top : "100px"
			},
		content: "<%=basePath%>gpsGroupWeb/gotoGpsgroupAdd.do?gpsId="
							+ gpsId + "&organId=" + organId+"&sessionId="+sessionId,
					iframe : true,
					closeCallback :GpsgroupManage.onClose,
					okCallback:GpsgroupManage.onClose
				});
	},
	deleteMember:function(){
		var kGrid = $("#dtGroupMember").data("kendoGrid");
		var row = kGrid.dataItem(kGrid.select());
		if (row != null) {
			$.ajax({
				url : "gpsGroupTest/delMemberById.do",
				type : "POST",
				dataType : "json",
				data : {
					'memberId' : row.id
				},
				async : false,
				success : function(req) {
					if (req.isSuccess) {
						alert("删除成功！");
						GpsGroupManage.getMemberBygroupId(m_gpsgroup_Id);
						//$('#dtGroupMember').datagrid('reload');
					}
				}
			});
		} else {
			alert('提示, 请先选择警员!!');
		}
	},
	clearUpMember:function(){
	var kGrid = $("#dtGpsGroup").data("kendoGrid");
	var row = kGrid.dataItem(kGrid.select());

	if (row != null) {
						$.ajax({
							url : "gpsGroupTest/cleanMemberByGroupId.do",
							type : "POST",
							dataType : "json",
							data : {
								"gpsGroupId" : row.id
							},
							async : false,
							success : function(req) {
								if (req.isSuccess) {
									alert("清空完成！");
									GpsGroupManage.getMemberBygroupId(m_gpsgroup_Id);
									//$('#dtGroupMember').datagrid('reload');
								}
							}
						});
	} else {
		alert('提示, 请先选择车辆组!!');
	}
	},
	
	onCloseMember:function(e){
		GpsgroupManage.loadMemberData(GpsgroupManage.pageNo);  
	},
	onCloseGorup:function(e){
		GpsgroupManage.loadGroupData(GpsgroupManage.pageNo);  
	}
};

</script>
<div id="dtGpsGroup" style="width:70%"></div>   
<div id="dtGroupMember" style="width:60%"></div> 
<div id="dialog"></div> 

