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
    <!-- <div id="vertical" style="overflow-x:hidden;"> -->
		<div id="winPGMember" title="组成员选择" style="width:450px;height:400px;">
			<div class="pane-content">
				<!-- 左开始 -->
				<div class="demo-section k-header"> 
					<input id="txtGpsGroupId"  type="hidden"></input>
					<ul>
						<li class="ty-input">
							<div class="groupmemberwindowdiv">
								<label id="treetitle" class="treetitle"></label>
								<ul id="treeOrgWithGps" style="overflow:auto"></ul>
							</div>
						</li>
						<li class="ty-input">
							<button onclick="GpsGroupManage.selectMember()">&gt&gt</button>
							<button onclick="GpsGroupManage.unselectMember()">&lt&lt</button>
						</li>
						<li class="ty-input">
							<div id="dtSelGroupMember" fit="true"></div>
						</li>
						
					</ul>
					<p style="float:left;width:100%;margin-top:10px;">
						<span class="k-button"  onclick="GpsGroupManage.appendMember()">保存</span>
					</p>
				</div>
			</div>
		<!-- </div> -->
	</div>
  </body>
</html>
