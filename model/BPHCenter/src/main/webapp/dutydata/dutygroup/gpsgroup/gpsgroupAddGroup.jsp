<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

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

<title>扁平化客户端</title>
<%@ include file="../../../emulateIE.jsp" %>
<script type="text/javascript">

var sessionId = $("#token").val(); 
var bph_Exist_OrgName; 
var m_checkedNodes_id ="" ;
var m_gpsGroup_Org = {
	id:$("#organId").val(),
	orgCode: "",
	orgPath :$("#organPath").val(),
	groupId : 0,
	sourceType:"Gps"
};
$(function() {
	//获取树的所有信息
		$.ajax({
			url : "<%=basePath%>organWeb/treelist.do?sessionId="+sessionId,
			type : "POST",
			dataType : "json",
			data : m_gpsGroup_Org,
			// async : false,
			success : function(req) {
				if (req.code==200) { 
					var json_data = JSON.stringify(req.data);
					
					$("#treeOrg").kendoTreeView({ 
					    checkboxes: true,
					    dataTextField: "shortName",
					    check : GpsGroupManage.onCheck,//check复选框
					    dataSource: [eval('(' + json_data + ')')]
					}).data("kendoTreeView");
				} else {
					alert("提示, "+req.msg+"", "warning");
				}
			}
		});
		$("#radio_unshared").attr("checked","checked");
		$("#divOrg").css("visibility", "hidden");
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
					$("body").popjs({"title":"提示","content":"请填写分组名称","callback":function(){
								$("#txtGpsGroupName").focus();
								return;
							}});     
					return;
				}

				if (groupName.length > 20) {
					$("body").popjs({"title":"提示","content":"分组名称长度过长","callback":function(){
								$("#txtGpsGroupName").focus();
								return;
							}});      
						return;  
				}   
		
		pg.name = groupName;

		pg.shareType = $('input:radio[name="shareType"]:checked').val();
		
				pg.shareType = $('input:radio[name="shareType"]:checked').val();
				if(pg.shareType==""||pg.shareType ==undefined){
					$("body").popjs({"title":"提示","content":"请选择共享类型"});
					return;
				}
				var s = m_checkedNodes_id;
				if(pg.shareType ==0||pg.shareType=="0"){
					var shOrgId =  m_gpsGroup_Org.id;
					pg.shareOrgIds.push(shOrgId);
				}else{
					if (m_checkedNodes_id.length > 0) {
						pg.shareOrgIds = m_checkedNodes_id.split(",");
					} 
				}

		$.ajax({ 
			url : "<%=basePath%>gpsGroupWeb/saveGpsGroup.do?sessionId="+sessionId,
			type : "POST",
			dataType : "json",
			data : {
				'gpsGroup' : JSON.stringify(pg)
			},
			async : false,
			success : function(req) {
				if (req.code == 200) { 
							 $("body").popjs({"title":"提示","content":"分组信息保存成功","callback":function(){ 
								window.parent.window.parent.GpsgroupManage.onCloseGorup();
								window.parent.$("#dialog").tyWindow.close();
							}}); 
						} else {
							$("body").popjs({"title":"提示","content":"分组信息保存失败"});
						}
			}
		});
	},
	
			isExistGroup : function() {
				isExist = false;
				var name =  $.trim($("#txtGpsGroupName").val());
				var myReg = /^[^|"'<>]*$/;
				if (!myReg.test(name)) {
					$("body").popjs({"title":"提示","content":"分组名称包含特殊字符，请重新输入"}); 
					$("#txtGpsGroupName").focus();
					return;
				}  
				if(name.length>0){
					$.ajax({
						url : "<%=basePath%>gpsGroupWeb/isExistGroup.do?sessionId="+sessionId,
						type : "POST",
						dataType : "json",
						async : false,
						data : {
							"name" : name,
							"orgId" : $("#organId").val(),
							"groupId" :0,
							"optType":0
						},
						success : function(req) {
							if (req.code!=200) {  
									bph_Exist_OrgName = req.description;
									$("body").popjs({"title":"提示","content":"该分组名称当前机构下已存在，请确认后添加","callback":function(){
									$("#txtGpsGroupName").focus(); 
									return;
							}});    
							return;
							
							}
						}
					});
				}
			}
	
};

</script>

</head>  
  <body>
		<!-- <div id="vertical" style="overflow-x:hidden;"> -->
		<div id="winPG" style="width:560px;height:320px;" title="定位设备分组管理">
			<div style="float:left;width:250px;margin-top:10px;">
				<!-- 左开始 -->
				<div class="demo-section k-header"> 
					<input type="hidden" id="txtGpsGroupId"></input>
					<ul>
						<li class="ty-input"><label class="ty-input-label" for="txtGpsGroupName">组名称:</label><input
							type="text" class="k-textbox" name="txtGpsGroupName"  onblur="GpsGroupManage.isExistGroup();"
							id="txtGpsGroupName" /></li>
						<li class="ty-input"><label>共享类型:</label>
							<label><input id="radio_unshared" type="radio" name="shareType" value="0"
							onclick="GpsGroupManage.changeShareType()" />不共享</label>
							<label><input id="radio_shared"  type="radio" name="shareType" value="1"
							onclick="GpsGroupManage.changeShareType()" />共享到下级</label>
							</li>  
						
					</ul>
					<p style="float:left;width:100%;margin-top:10px;">
						<span class="k-button"  onclick="GpsGroupManage.saveGpsGroup()">保存</span>
					</p>
				</div>
			</div> 
			
							<div  style="width:300px; float:left">
								<div id="divOrg" style="height:450px; overflow:auto" >
									<ul id="treeOrg" style="overflow:auto"></ul>
								</div>
							</div>
	</div>
  </body>
</html>
