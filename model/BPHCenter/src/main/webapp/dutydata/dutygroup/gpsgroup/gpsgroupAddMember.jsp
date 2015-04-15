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
