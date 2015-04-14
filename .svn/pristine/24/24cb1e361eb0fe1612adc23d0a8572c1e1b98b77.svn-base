<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
<head>
<title>扁平化指挥系统</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport' />


<%@ include file="../../emulateIE.jsp" %>
<script type="text/javascript">
var sessionId = $("#token").val();

var weaponImportManage = {
		downLoadModel:function(){
			var urlStr = "<%=basePath %>excelModel/WeaponInfo.xls"; 
			window.location.href = urlStr;
		} 
};

</script>
</head>
<body>
	<form id="weaponimportForm" method="post" enctype="multipart/form-data"
		action="<%=basePath %>servlet/ExcelImportServlet">
		<div id="vertical">
			<div id="horizontal" style="height: 300px; width: 400px;">
				<div class="pane-content">
					<!-- 左开始 -->
					<div class="demo-section k-header">
						<p>
							<input id="orgId" name="orgId" type="hidden" value="${organ.id}" />
							<input id="dataType" name="dataType" value="weaponData" type="hidden"/>
							<input type="file" name="fileName" style="width:180px" text="选择文件上传" /> <a
								href="<%=basePath %>excelModel/WeaponInfo.xls" style="font-size:12px;color:#819f0;"
								onclick="">[点击下载excel模板]</a>
						</p> <label style="font-size:12px;color:#819f0;">上传文件时，请先下载模板文件填写
							；</label><br /> <label style="font-size:12px;color:#819f0;">文件对象为：97—03版本的excel文件，后缀格式为xls；</label>
					 <p>  	
						<input type="submit" name="submit" style="width:80px" onClick="$('#weaponimportForm').submit()" value="开始导入" />
					</p> 
					 <p style="color: red">${requestScope.uploadError}</p> 
					 
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
