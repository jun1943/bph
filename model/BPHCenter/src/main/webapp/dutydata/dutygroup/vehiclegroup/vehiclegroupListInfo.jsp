<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript"> 
var sessionId = $("#token").val(); 
$(function() {
	$("#dtVehicleGroup").empty();
	loadData(1);
});
function loadData(pageNo){  
	VehicleGroupManage.pageNo = pageNo;
	VehicleGroupManage.loadGroupData(pageNo); 
	
}
var m_gpsGroup_Query = {};

var VehicleGroupManage = { 
	pageNo:1,
	loadGroupData : function(pageNo) {
		$.ajax({
						type : "post",
						url : url,
						dataType : "json",
						data : {
							"vehicleGroup_Query" : JSON
									.stringify(m_vehicleGroup_Query),
							page : 0,
							rows : 500
						//最大500条（必须是最大值）
						},
						success : function(req) {
							if (req.code == 200) {
								var rows = req.data;
								var dataSource = new kendo.data.DataSource({
									data : rows,
									batch : true,
									pageSize : 20
								});

								$("#dtVehicleGroup")
										.kendoGrid(
												{
													dataSource : dataSource,
													pageable : true,
													columns : [
															{
																title : 'Id',
																field : 'id',
																align : 'left',
																width : 10,
																hidden : true
															},
															{
																title : '组名称',
																field : 'name',
																align : 'left',
																width : 150
															},
															{
																title : '共享类型',
																field : 'shareTypeDesc',
																align : 'left',
																width : 200
															} ],
													selectable : "row",
													change : function(e) {
														var groupId = e.sender.selectable.userEvents.currentTarget.cells[0].innerHTML;
														m_vehiclegroup_Id = groupId;
														VehicleGroupManage.getMemberBygroupId(groupId);
													}
												});
							}
						}
					});
	},  
	createGroup:function(){
		var organId = $("#organId").val();
		$("#dialog").kendoWindow({
			width : "680px",
			height : "500px",
			title : "车辆信息",
			position : {
				top : "100px"
			},
		content: "<%=basePath%>VehicleGroupWeb/gotoVehiclegroupCreate.do?gpsId="
							+ gpsId + "&organId=" + organId+"&sessionId="+sessionId,
					iframe : true,
					closeCallback :VehiclegroupManage.onClose,
					okCallback:VehiclegroupManage.onClose
				});
	},
	editGroup:function(){
		var organId = $("#organId").val();
		$("#dialog").kendoWindow({
			width : "680px",
			height : "500px",
			title : "车辆信息",
			position : {
				top : "100px"
			},
		content: "<%=basePath%>VehicleGroupWeb/gotoVehiclegroupEdit.do?gpsId="
							+ gpsId + "&organId=" + organId+"&sessionId="+sessionId,
					iframe : true,
					closeCallback :VehiclegroupManage.onClose,
					okCallback:VehiclegroupManage.onClose
				});
	},
	deleteGroup:function(){
		
			var kGrid = $("#dtVehicleGroup").data("kendoGrid");
			var row = kGrid.dataItem(kGrid.select());
			if (row != null) {
				$.ajax({
					url : "vehicleGroupTest/deleteVehicleGroup.do",
					type : "POST",
					dataType : "json",
					data : {
						"vehicleGroupId" : row.id
					},
					async : false,
					success : function(req) {
						if (req.isSuccess) {
							alert('提示, 删除成功!');
							VehicleGroupManage.bindDtGroup("vehicleGroupTest/list.do");
							VehicleGroupManage.getMemberBygroupId(m_vehiclegroup_Id);
							//$('#dtVehicleGroup').datagrid('reload');
						} else {
							alert("提示, " + req.msg + ", warning");
						}
					}
				});
			}
	},
	loadMemberData:function(groupId){
		$.ajax({
				type : "post",
				url : "vehicleGroupTest/loadMemberByGroupId.do?groupId="
						+ groupId,
				dataType : "json",
				success : function(req) {
					if (req.code == 200) {
						var pdata = req.data;

						var dataSo = new kendo.data.DataSource({
							data : pdata
						});
						$("#dtGroupMember").kendoGrid({
							dataSource : dataSo,
							columns : [ {
								title : 'id',
								field : 'id',
								hidden : true
							}, {
								title : '所属单位',
								field : 'orgShortName'
							}, {
								title : '车辆类型',
								field : 'typeName'
							}, {
								title : '车牌号码',
								field : 'number'
							}, {
								title : '车辆用途',
								field : 'purpose'
							}, ],
							selectable : "row"
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
			title : "车辆信息",
			position : {
				top : "100px"
			},
		content: "<%=basePath%>VehicleGroupWeb/gotoVehiclegroupAdd.do?gpsId="
							+ gpsId + "&organId=" + organId+"&sessionId="+sessionId,
					iframe : true,
					closeCallback :VehiclegroupManage.onClose,
					okCallback:VehiclegroupManage.onClose
				});
	},
	deleteMember:function(){
		var kGrid = $("#dtGroupMember").data("kendoGrid");
			var row = kGrid.dataItem(kGrid.select());
			if (row != null) {
				$.ajax({
					url : "vehicleGroupTest/delMemberById.do",
					type : "POST",
					dataType : "json",
					data : {
						'memberId' : row.id
					},
					async : false,
					success : function(req) {
						if (req.isSuccess) {
							alert("删除成功！");
							VehicleGroupManage.getMemberBygroupId(m_vehiclegroup_Id);
							//$('#dtGroupMember').datagrid('reload');
						}
					}
				});
			} else {
				alert('提示, 请先选择车辆!!');
			}
	},
	clearUpMember:function(){
	var kGrid = $("#dtVehicleGroup").data("kendoGrid");
			var row = kGrid.dataItem(kGrid.select());

			if (row != null) {
				$.ajax({
					url : "vehicleGroupTest/cleanMemberByGroupId.do",
					type : "POST",
					dataType : "json",
					data : {
						"vehicleGroupId" : row.id
					},
					async : false,
					success : function(req) {
						if (req.isSuccess) {
							alert("清空完成！");
							VehicleGroupManage.getMemberBygroupId(m_vehiclegroup_Id);
							//$('#dtGroupMember').datagrid('reload');
						}
					}
				});
			} else {
				alert('提示, 请先选择车辆组!!');
			}
	},
	
	onCloseMember:function(e){
		VehiclegroupManage.loadMemberData(VehiclegroupManage.pageNo);  
	},
	onCloseGorup:function(e){
		VehiclegroupManage.loadGroupData(VehiclegroupManage.pageNo);  
	}
};

</script>
<div id="dtVehicleGroup" style="width:70%"></div>   
<div id="dtGroupMember" style="width:60%"></div> 
<div id="dialog"></div> 

