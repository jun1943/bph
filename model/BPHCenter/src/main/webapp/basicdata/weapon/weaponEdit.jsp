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
	$("#weaponType").kendoComboBox({
		dataTextField : "name",
		dataValueField : "id",
		dataSource : {
			serverFiltering : true,
			transport : {
				read : {
					url : "<%=basePath%>weaponWeb/getWeaponType.do?sessionId="+sessionId,
					dataType : "json"
				}
			}
		},
		filter : "contains",
		suggest : true,
		index : 3
	}).prev().find(".k-input").attr("readonly",true);
});

var bph_weaponEdit_pkg={};
var isExist = false;
var WeaponEditManage= { 
		isComplete:false,
		saveWeaponWithOut:function(){ 
			WeaponEditManage.packageWeapon(); 
			if(!WeaponEditManage.isComplete)
			{
				return;
			}
			$.ajax({
				url : "<%=basePath%>weaponWeb/saveWeapon.do?sessionId="+sessionId,
				type : "post",
				data : bph_weaponEdit_pkg,
				dataType : "json",
				success : function(req) {
							
						$("body").popjs({"title":"提示","content":"修改武器信息成功！","callback":function(){
							window.parent.window.parent.WeaponManage.onClose();
							window.parent.$("#dialog").tyWindow.close();
						}}); 
				}
			}); 
		},
		packageWeapon:function(){
			var wId = $("#weaponId").val()
			bph_weaponEdit_pkg.id=wId;
			bph_weaponEdit_pkg.orgId=$("#orgId").val();
			var pType= $("#weaponType").val();
			if(pType>0){
				bph_weaponEdit_pkg.typeId = pType;
			}else{
							$("body").popjs({"title":"提示","content":"请选择武器类型!"}); 
				return;
			}
			 
			var pnumber = $.trim($("#weaponNumber").val()); 
			if(pnumber.length>0){
				if (pnumber.length > 20) {
							$("body").popjs({"title":"提示","content":"武器编号长度出错，限制长度为0--20！"}); 
					return;
				}
				WeaponEditManage.isExistWeapon(pnumber,wId, 1);
				if (!isExist) {
							$("body").popjs({"title":"提示","content":"武器编号重复，请检查"});
					return;
				}
			}else{
							$("body").popjs({"title":"提示","content":"请录入武器编号"});
				return;
			}
			bph_weaponEdit_pkg.number= pnumber;
			var wstandard= $.trim($("#weaponStandard").val());
			
			if (wstandard.length > 20) {
							$("body").popjs({"title":"提示","content":"子弹数目长度过长，限制长度为20！"});
				return;
			}
			bph_weaponEdit_pkg.standard = wstandard; 
			WeaponEditManage.isComplete = true;
		},

		// 判断警员是否存在
		isExistWeapon:function(param,wid,type) {
			isExist = false;
			$.ajax({
				url : "<%=basePath%>weaponWeb/isExistWeapon.do?sessionId="+sessionId,
				type : "POST",
				dataType : "json",
				async : false,
				data : {
					"param" : param,
					"type"  : type,
					"id"    : wid
				},
				success : function(req) {
					if (req.code==200) {
						isExist = true;
					}
				}
			});
		}
};
</script>
</head>

<body>
	<div id="vertical">
		<div id="horizontal" style="height: 450px; width: 590px;">
			<div class="pane-content">
				<!-- 左开始 -->
				<div class="demo-section k-header"> 
					<ul>
						<li><label for="weaponType">武器类型:</label><input id="weaponType"
							placeholder="请选择车辆类型..."   value="${weapon.typeId}"  /><input type="hidden"
							id="weaponId"  value="${weapon.id}" ><input type="hidden"
							id="orgId"  value="${organ.id}" ></li>
						<li><label for="weaponNumber">武器编号:</label><input type="text"
							class="k-textbox" name="weaponNumber" id="weaponNumber"  value="${weapon.number}" /></li>
						<li><label for="weaponStandard">子弹数目:</label><input type="text"
							class="k-textbox" name="weaponStandard" id="weaponStandard" value="${weapon.standard }" /></li>
					</ul>
					<p>
						<span class="k-button"  onclick="WeaponEditManage.saveWeaponWithOut()">保存</span>
					</p>


				</div>
			</div>
		</div>
	</div>
</body>
</style>
</html>
