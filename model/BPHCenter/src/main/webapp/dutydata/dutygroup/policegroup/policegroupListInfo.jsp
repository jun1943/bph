<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript"> 
var sessionId = $("#token").val(); 
$(function() {
	$("#dtPoliceGroup").empty();
	loadData(1);
});
function loadData(pageNo){  
	PolicegroupManage.pageNo = pageNo;
	PolicegroupManage.loadGroupData(pageNo); 
	
}
var m_policeGroup_Query = {};

var PolicegroupManage = { 
	pageNo:1,
	loadGroupData : function(pageNo) {
		$.ajax({
		type: "post",
		url: "",
		dataType: "json",
		data: {
			"policeGroup_Query": JSON.stringify(m_policeGroup_Query),
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
				
				$("#dtPoliceGroup").kendoGrid({
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
						m_policegroup_Id = groupId;
						PolicegroupManage.loadMemberData(groupId);
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
			title : "警员信息",
			position : {
				top : "100px"
			},
		content: "<%=basePath%>policeGroupWeb/gotoPolicegroupCreate.do?gpsId="
							+ gpsId + "&organId=" + organId+"&sessionId="+sessionId,
					iframe : true,
					closeCallback :PolicegroupManage.onClose,
					okCallback:PolicegroupManage.onClose
				});
	},
	editGroup:function(){
		var organId = $("#organId").val();
		$("#dialog").kendoWindow({
			width : "680px",
			height : "500px",
			title : "警员信息",
			position : {
				top : "100px"
			},
		content: "<%=basePath%>policeGroupWeb/gotoPolicegroupEdit.do?gpsId="
							+ gpsId + "&organId=" + organId+"&sessionId="+sessionId,
					iframe : true,
					closeCallback :PolicegroupManage.onClose,
					okCallback:PolicegroupManage.onClose
				});
	},
	deleteGroup:function(){
		
			var kGrid = $("#dtPoliceGroup").data("kendoGrid");
			var row = kGrid.dataItem(kGrid.select());
			if (row != null) {
				$.ajax({
					url : "policeGroupTest/deletePoliceGroup.do",
					type : "POST",
					dataType : "json",
					data : {
						"policeGroupId" : row.id
					},
					async : false,
					success : function(req) {
						if (req.isSuccess) {
							alert('提示, 删除成功!');
							//$('#dtPoliceGroup').datagrid('reload');
							bindDtGroup("policeGroupTest/list.do");
							GpsGroupManage.getMemberBygroupId(m_gpsgroup_Id);
						} else {
							$.messager.alert("提示,"+req.msg+", "+warning+"");
						}
					}
				});
	}
	},
	loadMemberData:function(gId){
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
			title : "警员信息",
			position : {
				top : "100px"
			},
		content: "<%=basePath%>policeGroupWeb/gotoPolicegroupAdd.do?gpsId="
							+ gpsId + "&organId=" + organId+"&sessionId="+sessionId,
					iframe : true,
					closeCallback :PolicegroupManage.onClose,
					okCallback:PolicegroupManage.onClose
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

