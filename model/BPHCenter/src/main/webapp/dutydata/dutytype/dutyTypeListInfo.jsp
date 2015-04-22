<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript"> 
var sessionId = $("#token").val(); 
$(function() {
	$("#dutyTypeTreeList").empty();
	loadData();
});
function loadData(){  
	DutyTyepManage.loadData(); 
}
var m_dutyTypeObj = {};
var DutyTyepManage = { 
	loadData : function() {
		$.ajax({
			url : "<%=basePath%>dutyTypeWeb/getDutyTypelist.do",
			type : "POST",
			dataType : "json",
			success : function(req) {
				if(req.code == 200){
					if(req.data != null){
						for(var i = 0; i<req.data.length;i++)
						{
							var obj = req.data[i];
							if(obj.parentId ==0)
							{
								obj.parentId = null;
							} 
						}
						var dtdatatemp = JSON.stringify(req.data);
						 
					 	
    $("#dutyTypeTreeList").kendoTreeList({
						 dataSource: {
             				data:dtdatatemp
             			},
						 
							columns : [{
								field : "id",
								title : "id",
								hidden: true
							} ,{
								field : "name",
								expandable: true,
								title : "名称",
								width : 150
							} , {
								title : "人数上限",
								field : "maxPolice",
								align : 'left',
								width : 80,
								template: '#= maxPolice == null || maxPolice == 0 ? "不限" : maxPolice #'
							}, {
								field : "isShowname",
								title : "统计显示方式",
								width : 120,
								template: '#= isShowname == false ? "人数" : "名称" #'

							}, {
								field : "properties",
								title : "属性",
								width : 160,
								template: '#= getProperty(properties) #'
							}, {
								field : "assoTaskType",
								title : "关联任务",
								width : 80,
								template: '#= contactName(assoTaskType) #'
							}, {
								field : "attireType",
								title : "着装",
								width : 60,
								template: '#= attireType == 0 ? "制服" : "便衣" #'
							}, {
								field : "armamentType",
								title : "武器",
								width : 60,
								template: '#= armamentType == 0 ? "非武装" : "武装" #'
							}, {
								field : "isUsed",
								title : "停用",
								width : 60,
								template: '#= isUsed == true ? "启用" : "停用" #'
							}],
							selectable: "row" 
						});
					} 
				}
			}
		});
	},
	changeDutyTypeStates:function(dId,status){
		alert(dId);
	},
	getProperty:function(data) {
	
		if (data == null || data.length == 0)
			return "";
		var rs = "";
		for (var item in data) 
			if (data[item].name != null){
				rs += data[item].name + ";"
			}
		return rs;
	},
	contactName:function (k) {
		var showValue = "";
		switch (parseInt(k)) {
			case 1:
				showValue = '社区';break;
			case 2:
				showValue = '巡区';break;
			case 3:
				showValue = '卡点';break;
			default:
				showValue = '';
		}
		return showValue;
	},
	editDutyType:function(dId){
		 var treelist = $("#dutyTypeTreeList").data("kendoTreeList");
		 var row = treelist.dataItem(treelist.select());	
		 if (row != null) {
		 	m_dutyTypeObj.isLeaf = row.isLeaf; 
		 	m_dutyTypeObj.id= row.id;
		 	m_dutyTypeObj.parentId = row.parentId;
		 	m_dutyTypeObj.parentName = row.parentName;
		 	m_dutyTypeObj.parentFullPath = row.parentFullPath;
		 	m_dutyTypeObj.name = row.name;
		 	m_dutyTypeObj.maxPolice = row.maxPolice;
		 	m_dutyTypeObj.isShowname = row.isShowname;
		 	var count = row.properties.length;
			var properties = [];
			for ( var i = 0; i < count; i++) {
				var p = row.properties[i];
				properties.push(p.id);
			}
			m_dutyTypeObj.properties = properties;
			m_dutyTypeObj.attireType = row.attireType;
			m_dutyTypeObj.armamentType = row.armamentType;
			m_dutyTypeObj.isUsed = row.isUsed;
			m_dutyTypeObj.assoTaskType = row.assoTaskType; 
		 	DutyTyepManage.onOpen("gotoDutyTypeEdit","编辑勤务类型信息");
		 }else{
		 	$("body").popjs({"title":"提示","content":"获取勤务类型数据失败！"});
		 }
	},
	deleteDutyType:function(dId){
		alert(dId);
	},
	addParentNode:function(){
		alert(1);
		DutyTyepManage.onOpen("gotoDutyTypeAdd","新增根节点");
	},
	addChildNode:function(){
		alert(2); 
		var treelist = $("#dutyTypeTreeList").data("kendoTreeList"); 
		var row = treelist.dataItem(treelist.select());
		DutyTyepManage.onOpen("gotoDutyTypeAdd","新增子节点");
	},
	deleteNode:function(){
	},
	unLockNode:function(){
	},
	lockNode:function(){
	},
	onOpen:function(urlModel,title){
		$("#dialog").tyWindow({
			width : "680px",
			height : "500px",
			title : title,
			position : {
				top : "100px"
			},
		content: "<%=basePath%>dutyTypeWeb/"+urlModel+".do?sessionId="+sessionId,
					iframe : true,
					closeCallback : DutyTyepManage.onClose,
					okCallback : DutyTyepManage.onClose
				});
		//$("#dialog").data("kendoWindow").open();
	},
	onClose:function(e){
		DutyTyepManage.loadData();  
	}
};

</script>
<div id="dutyTypeTreeList" style="width:150%"></div>   
<div id="dialog"></div> 

