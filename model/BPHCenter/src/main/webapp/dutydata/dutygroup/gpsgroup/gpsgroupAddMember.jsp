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
		var kGrid = $("#dtGpsGroup").data("kendoGrid");
		var row = kGrid.dataItem(kGrid.select());
		var groupId = row.id;
		
		//GpsGroupManage.getloadorgTree();
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
								$("#dtSelGroupMember").kendoGrid({
									dataSource: dataSo,
									columns : [ {
										title : 'id',
										field : 'id',
										hidden : true
									}, {
										title : '设备类型',
										field : 'typeName'
									}, {
										title : '设别编号',
										field : 'number'
									}, ],
									selectable: "row"
								});
								//GpsGroupManage.showGroupMemberDlg();
							}
						}
			});
			var = rootId = m_gpsGroup_Org.id
		 $.ajax({
			url : "orgTest/listWithGps.do?rootId=" + rootId,
			type : "POST",
			dataType : "json", 
			success:function(req){
				var count = req.length;
		//		alert(count);
				 for(var j=0; j<count;j++) {
					var r = req[j];  
					r.ReportsTo = r.reportsTo; 
					if(r.state=="colsed") {
						$.ajax({
							url : "orgTest/listWithGps.do?rootId=" + r.rid,
							type : "post",
							dataType : "json",
							success:function(req){
								var childOrg = req;
							}
							
						});
					}
				} 
				var s  = req;
				/* m_orgPolicepackage = req;
				 var inline = new kendo.data.HierarchicalDataSource({
					 data:s,
					 schema: {
						    model: {
						      id: "rid",
						      hasChildren: "state"
						    }
						  }

				 }); */ 
				$("#treeOrgWithGps").kendoTreeView({
					dataSource:s,
					dataTextField: "name",
					dataUrlField:"rid",
					selectable: "row"
					  /* expand: function(e) {
						  var baseurl  = e.node.baseURI;
						  var innertext = e.node.childNodes[0].childNodes[1].childNodes[0].data;
						  var subStr = e.node.childNodes[0].childNodes[1].href;
						  var rid = subStr.replace(baseurl,"");
						  //var rid =
						  getsubOrgTree(rid,innertext);
					}  */
				});
			}
		});	
				
	});
	
	</script>
	
  </head>
  
  <body>
    <div id="winPGMember" class="easyui-window groupmemberwindow" title="组成员选择"  
	style="width:450px;height:400px;"
        data-options="iconCls:'icon-save',modal:true" closed="true" 
        collapsible="false" minimizable="false" maximizable="false" resizable="false" shadow="false">    
   	 		
			<input id="txtGpsGroupId"  type="hidden"></input>
			<table>
				<tr>
					<td class="groupmemberwindowtdf">
						
						<div class="groupmemberwindowdiv" >
						<label id="treetitle" class="treetitle"></label>
							<ul id="treeOrgWithGps" class="easyui-tree"
								style="overflow:auto"></ul>
						</div>
					</td>
					<td class="groupmemberwindowtds">
						<button onclick="selectMember()">&gt&gt</button>
						<button onclick="unselectMember()">&lt&lt</button>
					</td>

					<td class="groupmemberwindowtdt">
						<div id="dtSelGroupMember" fit="true"></div>
					</td>
				</tr>
			</table>   
			<div id="tbGroup" class="btn-toolbar groupwindowtoolbar" >
				<div class="btn-group groupwindowtoolbar" >
					<a id="btnSaveGpsGroup" href="javascript:void(0);"
						class="easyui-linkbutton groupwindowbtn" 
						onclick="GpsGroupManage.appendMember()">保存</a> 
				</div>
			</div>
	</div> 
    
  </body>
</html>
