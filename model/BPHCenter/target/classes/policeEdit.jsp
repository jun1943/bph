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
$(function() {
	$("#policetype").kendoComboBox({
		dataTextField : "name",
		dataValueField : "id",
		dataSource : {
			serverFiltering : true,
			transport : {
				read : {
					url : "<%=basePath%>policeWeb/getPoliceType.do?sessionId="+sessionId,
					dataType : "json"
				}
			}
		},
		filter : "contains",
		suggest : true 
	}).prev().find(".k-input").attr("readonly",true);
	$("#policegroupno").kendoComboBox({
		dataTextField : "name",
		dataValueField : "id",
		dataSource : {
			serverFiltering : true,
			transport : {
				read : {
					url : "<%=basePath%>policeWeb/getintercomGroup.do?sessionId="+sessionId,
					dataType : "json"
				}
			}
		},
		filter : "contains",
		suggest : true  
	}).prev().find(".k-input").attr("readonly",true);
	$("#policegpsname").kendoComboBox({
		dataTextField : "name",
		dataValueField : "id",
		height:150,
		dataSource : {
			serverFiltering : true,
			transport : {
				read : {
					url : "<%=basePath%>policeWeb/getGpsId.do?orgId="+$("#orgId").val()+"&sessionId="+sessionId,
					dataType : "json"
				}
			}
		},
		filter : "contains",
		suggest : true, 
        select: policeEditManage.onSelectGps 
	}).prev().find(".k-input").attr("readonly",true);
	bph_policeEdit_pkg.gpsId = $("#policegpsname").val();
	bph_policeEdit_pkg.gpsName = $("#txtpolicegpsname").val();
});
var bph_policeEdit_pkg={};
var isExist = false;
var policeEditManage= { 
		onSelectGps:function(e){
			 var dataItem = this.dataItem(e.item.index()); 
			 bph_policeEdit_pkg.gpsId = dataItem.id;
			 bph_policeEdit_pkg.gpsName = dataItem.name; 
		},
		savePoliceWithOut:function(){ 
			policeEditManage.packagePolice(); 
			if(!bph_policeEdit_pkg.isused||bph_policeEdit_pkg.isused==undefined)
			{
				return;
			}
			$.ajax({
				url : "<%=basePath%>policeWeb/savePolice.do?sessionId="+sessionId,
				type : "post",
				data : bph_policeEdit_pkg,
				dataType : "json",
				success : function(req) { 
				$("body").popjs({"title":"提示","content":"修改警员信息成功！","callback":function(){
							window.parent.window.parent.PoliceManage.onClose();
							window.parent.$("#dialog").tyWindow.close();
						}});   
				}
			}); 
		},
		packagePolice:function(){
			var pId = $("#policeId").val();
			bph_policeEdit_pkg.id=$("#policeId").val();
			bph_policeEdit_pkg.orgId=$("#orgId").val();
			var pType= $("#policetype").val();
			if(pType>0){
				bph_policeEdit_pkg.typeId = pType;
			}else{ 
				$("body").popjs({"title":"提示","content":"请选择警员类型!"});  
				return;
			}
			var pName = $.trim($("#policename").val());
			if (pName == ""||pName==undefined) { 
				$("body").popjs({"title":"提示","content":"请输入警员名称"});  
				return;
			}
			if (pName.length > 20) {
				$("body").popjs({"title":"提示","content":"警员姓名长度过长，限制长度为20！"});  
				return;
			}
			bph_policeEdit_pkg.name = pName; 

			var pattern = /\D/ig;
			var idcardno = $.trim($("#policeidcardno").val());
			if (idcardno.length > 0) {
				if (idcardno.length != 18 && idcardno.length != 15) {
				$("body").popjs({"title":"提示","content":"警员身份证号码长度出错，限制长度为15位或者18位！"}); 
					return;
				}

				var Regx = /^[A-Za-z0-9]+$/;
				if (!Regx.test(idcardno)) { 
				$("body").popjs({"title":"提示","content":"警员身份证号码格式出错，只能是全部数字或者最后一位是字母！"});   
					return;
				}
				var subIdCard = idcardno.substring(0, idcardno.length - 1);
				if (pattern.test(subIdCard)) { 
				$("body").popjs({"title":"提示","content":"警员身份证号码格式出错  ！"});   
					return;
				}
				policeEditManage.isExistPolice(idcardno, "idCard",pId,1);
				if (!isExist) {
					isExist = false; 
				$("body").popjs({"title":"提示","content":"警员身份证号码重复，请检查"});   
					return;
				}
			}
			bph_policeEdit_pkg.idcardno =idcardno;
			var pnumber = $.trim($("#policecode").val());
			
			if(pnumber.length>0){
				if (pnumber.length > 20 || pnumber.length < 6) {
				$("body").popjs({"title":"提示","content":"警员警号长度出错，限制长度为6--20！"});  
					return;
				}
				policeEditManage.isExistPolice(pnumber, "number",pId,1);
				if (!isExist) { 
				$("body").popjs({"title":"提示","content":"警员警号重复，请检查"}); 
					return;
				}
			}
			bph_policeEdit_pkg.number= pnumber;
			 var ptitle= $.trim($("#policetitle").val());
			if (ptitle.length > 0 && ptitle.length > 20) { 
				$("body").popjs({"title":"提示","content":"警员职位长度过长，限制长度为20！"}); 
				return;
			}
			bph_policeEdit_pkg.title = ptitle;
			var phone = $.trim($("#policephone").val());
			if (phone.length > 0 && phone.length > 20) { 
				$("body").popjs({"title":"提示","content":"警员电话号码长度过长，限制长度为20！"}); 
			}
			bph_policeEdit_pkg.mobile=phone;
			var mobileShorts = $.trim($("#policeshortno").val());
			if (mobileShorts.length > 0 && mobileShorts.length > 20) { 
				$("body").popjs({"title":"提示","content":"警员公安短号长度过长，限制长度为1--20！"}); 
				return;
			}
			bph_policeEdit_pkg.mobileShort = mobileShorts;
			bph_policeEdit_pkg.intercomGroup = $("#policegroupno").val();
			var intercomPerson = $("#policepersonno").val();
			if(intercomPerson.length>0){
				policeEditManage.isExistPolice(intercomPerson, "intercomPerson",pId,1);
				if (!isExist) { 
				$("body").popjs({"title":"提示","content":"个呼号为  " + intercomPerson + " 的警员已存在，请检查！"}); 
					return;
				}
			}
			if(intercomPerson.length>30){ 
				$("body").popjs({"title":"提示","content":"警员对讲机个呼号长度过长，限制长度为0-30"}); 
				return;
			}
			bph_policeEdit_pkg.intercomPerson = intercomPerson;  
			bph_policeEdit_pkg.isused = true;
		},

		// 判断警员是否存在
		isExistPolice:function(param, pType,pid,optType) {
			isExist = false;
			$.ajax({
				url : "<%=basePath%>policeWeb/isExistPolice.do?sessionId="+sessionId,
				type : "POST",
				dataType : "json",
				async : false,
				data : {
					"param" : param,
					"paramType" : pType,
					"optType"   : optType,
					"id"     :   pid
				},
				success : function(req) {
					if (req.code=200) {
						isExist = true;
					}
				}
			});
		}
};

</script>

<body>
	<div id="vertical" style="overflow-x:hidden;">
		<div id="horizontal" style="height: 300px; width: 590px;">
			<div class="pane-content">
				<!-- 左开始 -->
				<div class="demo-section k-header"> 
					<ul>
						<li class="ty-input"><label class="ty-input-label" for="policetype">警员类型:</label><input id="policetype"
							placeholder="请选择警员类别..." value="${police.typeId}"  /><input type="hidden"
							id="policeId"  value="${police.id}" ><input type="hidden"
							id="orgId" value="${organ.id}" /></li>
						<li class="ty-input"><label class="ty-input-label" for="policename">警员姓名:</label><input type="text"
							class="k-textbox" name="policename"  value="${police.name}" id="policename"
							required="required" /></li>
						<li class="ty-input"><label class="ty-input-label" for="policeidcardno">身份证号:</label><input
							type="text" class="k-textbox" value="${police.idcardno}" name="policeidcardno"
							id="policeidcardno" /></li>
						<li class="ty-input"><label class="ty-input-label" for="policecode">警员警号:</label><input type="text"
							class="k-textbox" name="policecode" id="policecode"  value="${police.number}" /></li>
						<li class="ty-input"><label class="ty-input-label" for="policetitle">警员职务:</label><input type="text"
							class="k-textbox" name="policetitle" id="policetitle" value="${police.title}" /></li>
						<li class="ty-input"><label class="ty-input-label" for="policephone">手机号码:</label><input type="text"
							class="k-textbox" name="policephone" id="policephone" value="${police.mobile}" /></li>
						<li class="ty-input"><label class="ty-input-label" for="policeshortno">公安短号:</label><input
							type="text" class="k-textbox" name="policeshortno"
							id="policeshortno"  value="${police.mobileShort}"/></li>
						<li class="ty-input"><label class="ty-input-label" for="policegroupno">对讲机组呼号:</label><input
							id="policegroupno" placeholder="请选择对讲机组呼号..." value="${police.intercomGroup}"  /></li>
						<li class="ty-input"><label class="ty-input-label" for="policepersonno">对讲机个呼号:</label><input
							type="text" class="k-textbox" name="policepersonno"
							id="policepersonno"  value="${police.intercomPerson}" /></li>
						<li class="ty-input"><label class="ty-input-label" for="policegpsname">GPS显示名称: </label><input
							id="policegpsname" placeholder="请选择gps名称..." value="${police.gpsId}" />
							<input type="hidden"
							id="txtpolicegpsname" value="${police.gpsName}" />
							</li>
					</ul>
					<p style="float:left;width:100%;margin-top:10px;">
						
						<span class="k-button"  onclick="policeEditManage.savePoliceWithOut()">保存</span>
					</p>


				</div>
			</div>
		</div>
	</div>
</body>
</style>
</html>
