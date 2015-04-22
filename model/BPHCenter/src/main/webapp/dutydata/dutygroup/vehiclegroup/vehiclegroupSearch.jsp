<%@ page language="java" pageEncoding="UTF-8"%>

<script>
$(document).ready(function() {    
	$("#organLevel").kendoComboBox();
	$("#vehicleNumber").kendoMaskedTextBox(); 
	//屏幕模式
	$("#tyScreenMode i").each(function(i){
		$(this).click(function(){
			var cls = $(this).attr("class");
			var lump = cls.substring(cls.length-1,cls.length);
			var icon = $("#tyScreenMode .ty-screen-mode-icon");
			var txt = $("#tyScreenMode .ty-screen-mode-txt");
			if(lump == 1){
				icon.animate({"left":"6px"},1000);
				txt.css("background-position","-17px -731px");
				$("#tyScreenMode").mouseover(function(){
					txt.css("background-position","-17px -731px");
				}).mouseout(function(){
					txt.css("background-position","-147px -757px");
				});
				
			}else if(lump == 2){
				icon.animate({"left":"43px"},1000);
				txt.css("background-position","-17px -767px");
				$("#tyScreenMode").mouseover(function(){
					txt.css("background-position","-17px -767px");
				}).mouseout(function(){
					txt.css("background-position","-147px -793px");
				});
				
			}else if(lump == 3){
				icon.animate({"left":"78px"},1000);
				txt.css("background-position","-18px -803px");
				$("#tyScreenMode").mouseover(function(){
					txt.css("background-position","-18px -803px");
				}).mouseout(function(){
					txt.css("background-position","-147px -828px");
				});
				
			}
		});
	});
});
</script>
<div id="template">
 
	<div class="fl ml30 set-hei48">   
                   <input type="hidden" id="organId" name="organId" value="${query.organId}">
                   <input type="hidden" id="organPath" name="organPath" value="${organ.path}">
                   <input type="hidden" id="pageSize" name="organId" value="${query.pageSize}">
                   <input type="hidden" id="pageStart" name="organPath" value="${query.pageNo}">
		<div class="temp">
			<div class="ty-total-decorate"><span id="gridListTotal"></span><i></i></div>
			<div class="ty-decorate2"></div>
		</div>
	</div>
	<div class="fl set-hei48">
		<div class="ty-decorate1"></div>
		<button id="undo" class="ty-btn-add ty-btn-offset" onclick="VehicleManage.addVehicle()"></button>
                    
                   <span id="btncreateGroup" class="k-button"  onclick="VehiclegroupManage.createGroup()">创建分组</span>
                   <span id="btneditGroup" class="k-button"  onclick="VehiclegroupManage.editGroup()">修改分组</span> 
                   <span id="btndeleteGroup" class="k-button"  onclick="VehiclegroupManage.deleteGroup)">删除分组</span>
                   <span id="btnaddMember" class="k-button"  onclick="VehiclegroupManage.addMember()">添加成员</span> 
                   <span id="btndeleteMember" class="k-button"  onclick="VehiclegroupManage.deleteMember()">删除成员</span> 
                   <span id="btnclearUpMember" class="k-button"  onclick="VehiclegroupManage.clearUpMember()">清空成员</span> 
	</div>
	<div class="fr set-hei48">
		<div class="ty-screen-mode" id="tyScreenMode">
			<i class="ty-screen-mode-btn1" title="标准模式"></i><i class="ty-screen-mode-btn2" title="模块全屏"></i><i class="ty-screen-mode-btn3" title="内容全屏"></i>
			<div class="ty-screen-mode-icon"></div>
			<span class="ty-screen-mode-txt"></span>
		</div>
	</div>
</div>
 