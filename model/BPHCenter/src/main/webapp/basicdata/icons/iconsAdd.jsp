<%@ page language="java"  import="java.util.*"  pageEncoding="UTF-8"%>
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
<base href="<%=basePath%>">  
<title>扁平化指挥系统</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport' />

<%@ include file="../../emulateIE.jsp" %>
<script type="text/javascript">
var sessionId = $("#token").val();

$(function() {
	var args = getUrlArgs();
	if (args.optType == 0 || args.optType == "0") { 
					$("body").popjs({"title":"提示","content":"请求数据的size超出了规定的大小,限制大小2M!"});  
	} else if (args.optType == 1 || args.optType == "1") {
					$("body").popjs({"title":"提示","content":"请求类型enctype != multipart/form-data"});  
	} else if (args.optType == 2 || args.optType == "2") {
					$("body").popjs({"title":"提示","content":"上传过程异常，导致其原因可能是磁盘已满或者其它原因"});   
	} else if (args.optType == 3 || args.optType == "3") {
					$("body").popjs({"title":"提示","content":"请选择图片类型"});   
	} else if (args.optType == 4 || args.optType == "4") {
					$("body").popjs({"title":"提示","content":"请输入图标名称"});   
	} else if (args.optType == 5 || args.optType == "5") {
					$("body").popjs({"title":"提示","content":"文件写入服务器磁盘错误"});    
	} else if (args.optType == 6 || args.optType == "6") {
					$("body").popjs({"title":"提示","content":"请选择要上传的图标！"});  
	} 
	$("#iconsType").kendoComboBox({
		dataTextField : "name",
		dataValueField : "id",
		dataSource : {
			serverFiltering : true,
			transport : {
				read : {
					url : "<%=basePath%>iconsWeb/getIconType.do?sessionId="+sessionId,
					dataType : "json"
				}
			}
		},
		filter : "contains",
		suggest : true,
		index : 0
	}).prev().find(".k-input").attr("readonly",true);
});
function getUrlArgs() {
	var url = decodeURI(location.search);
	// var url = location.search; //获取url中"?"符后的字串
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for ( var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);

		}
	}
	return theRequest;
}

function iconFormSubmit(){
	var iconTypeId=$("#").val();
	if(iconTypeId==0){
		$("body").popjs({"title":"提示","content":"请选择图片类型"}); 
		return;
	}
	var iconname = $("#iconsName").val();
	if(iconname==""||$.trim(iconname)==""){
		$("body").popjs({"title":"提示","content":"请输入图片名称"}); 
		return; 
	} else{
		$('#iconSubForm').submit();
	}
}
</script>
</head>

<body>
<form id="iconSubForm" method="post" enctype="multipart/form-data"  action="<%=basePath %>servlet/FileUploadServlet" >  
     <div id="horizontal" style="height: 220px; width: 450px;">
			<div class="pane-content">
				<!-- 左开始 -->
				<div class="demo-section k-header"> 
					<ul>
						<li><label for="iconsType">图片类型:</label><input id="iconsType"  name="iconsType"
							placeholder="请选择图片类型..." /><input id="iconsId" value="0"  name="iconsId" type="hidden" />
							<input id="sessionId" value="${requestScope.sessionId}"  name="sessionId" type="hidden" />
							</li>
						<li><label for="iconsName">图标名称:</label><input
							type="text" class="k-textbox" name="iconsName"
							id="iconsName" value="${requestScope.iconsName}" /></li>
						<li><label for="iconUrl">图标选择:</label><input type="file" style="width:180px" name="fileName" text="选择文件上传" /></li>
					</ul>
					<p>  	
						<input type="submit" name="submit" style="width:80px"  onClick="iconFormSubmit();" value="保存图标" />
					</p> 
					 <p style="color: red">${requestScope.uploadError}</p> 
				</div>
				
			</div>
		</div> 
 </form>   
</body>
</style>
</html>