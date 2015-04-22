<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript"> 

var m_weapongroup_Id = "";
var m_weaponGroup_Org = {};
var m_weaponGroup_Query = {};
var opteType = "";
var m_checkedNodes_id="";
var isExist = false;

var sessionId = $("#token").val(); 
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
			url: url,
			dataType: "json",
			data: {
				"weaponGroup_Query": JSON.stringify(m_weaponGroup_Query),
				page: 0,
				rows: 500 //最大500条（必须是最大值）
			},
			success: function(req) {
				if (req.code == 200) { 
					var rows =req.data; 
					var dataSource = new kendo.data.DataSource({
						data: rows,
						batch: true,
						pageSize: 20
					});
					
					$("#dtWeaponGroup").kendoGrid({
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
							m_weapongroup_Id = groupId;
							WeaponGroupManage.getMemberBygroupId(groupId);
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
			title : "武器信息",
			position : {
				top : "100px"
			},
		content: "<%=basePath%>weaponGroupWeb/gotoWeapongroupCreate.do?gpsId="
							+ gpsId + "&organId=" + organId+"&sessionId="+sessionId,
					iframe : true,
					closeCallback :WeapongroupManage.onClose,
					okCallback:WeapongroupManage.onClose
				});
	},
	editGroup:function(){
		var organId = $("#organId").val();
		$("#dialog").kendoWindow({
			width : "680px",
			height : "500px",
			title : "武器信息",
			position : {
				top : "100px"
			},
		content: "<%=basePath%>weaponGroupWeb/gotoWeapongroupEdit.do?gpsId="
							+ gpsId + "&organId=" + organId+"&sessionId="+sessionId,
					iframe : true,
					closeCallback :WeapongroupManage.onClose,
					okCallback:WeapongroupManage.onClose
				});
	},
	deleteGroup:function(){
		
			var kGrid = $("#dtWeaponGroup").data("kendoGrid");
		var row = kGrid.dataItem(kGrid.select());
		if (row != null) {
					$.ajax({
						url : "weaponGroupTest/deleteWeaponGroup.do",
						type : "POST",
						dataType : "json",
						data : {
							"weaponGroupId" : row.id
						},
						async : false,
						success : function(req) {
							if (req.isSuccess) {
								alert('提示, 删除成功!');
								WeaponGroupManage.bindDtGroup("weaponGroupTest/list.do");
								WeaponGroupManage.getMemberBygroupId(m_weapongroup_Id);
								//$('#dtWeaponGroup').datagrid('reload');
							} else {
								alert("提示, "+req.msg+", warning");
							}
						}
					});
		}
	},
	getMemberBygroupId:function(groupId){
		$.ajax({
			type: "post",
			url: "weaponGroupTest/loadMemberByGroupId.do?groupId="+groupId,
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
										title : '武器类型',
										field : 'typeName'
									}, {
										title : '武器编号',
										field : 'number'
									}, {
										title : '子弹发数',
										field : 'standard'
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
			title : "武器信息",
			position : {
				top : "100px"
			},
		content: "<%=basePath%>weaponGroupWeb/gotoWeapongroupAdd.do?gpsId="
							+ gpsId + "&organId=" + organId+"&sessionId="+sessionId,
					iframe : true,
					closeCallback :WeapongroupManage.onClose,
					okCallback:WeapongroupManage.onClose
				});
	},
	deleteMember:function(){
		var kGrid = $("#dtGroupMember").data("kendoGrid");
		var row = kGrid.dataItem(kGrid.select());	
		if (row != null) {
			$.ajax({
				url : "weaponGroupTest/delMemberById.do",
				type : "POST",
				dataType : "json",
				data : {
					'memberId' : row.id
				},
				async : false,
				success : function(req) {
					if (req.isSuccess) {
						alert("删除成功！");
						WeaponGroupManage.getMemberBygroupId(m_weapongroup_Id);
						//$('#dtGroupMember').datagrid('reload');
					}
				}
			});
		} else {
			alert('提示, 请先选择武器类型!!');
		}
	},
	clearUpMember:function(){
		var kGrid = $("#dtWeaponGroup").data("kendoGrid");
		var row = kGrid.dataItem(kGrid.select());

		if (row != null) {
							$.ajax({
								url : "weaponGroup/cleanMemberByGroupId.do",
								type : "POST",
								dataType : "json",
								data : {
									"weaponGroupId" : row.id
								},
								async : false,
								success : function(req) {
									if (req.isSuccess) {
										alert("清空完成！");
										WeaponGroupManage.getMemberBygroupId(m_weapongroup_Id);
										//$('#dtGroupMember').datagrid('reload');
									}
								}
							});
		} else {
			alert('提示, 请先选择武器组!!');
		}
	},
	
	onCloseMember:function(e){
		WeapongroupManage.loadMemberData(WeapongroupManage.pageNo);  
	},
	onCloseGorup:function(e){
		WeapongroupManage.loadGroupData(WeapongroupManage.pageNo);  
	}
};

</script>
<div id="dtWeaponGroup" style="width:70%"></div>   
<div id="dtGroupMember" style="width:60%"></div> 
<div id="dialog"></div> 

