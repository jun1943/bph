<%@ page language="java" pageEncoding="UTF-8"%>

<script>
$(document).ready(function() {    
	$("#organLevel").kendoComboBox().prev().find(".k-input").attr("readonly",true);
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
				window.external.ChangeScreenModel("标准模式");
			}else if(lump == 2){
				icon.animate({"left":"43px"},1000);
				txt.css("background-position","-17px -767px");
				$("#tyScreenMode").mouseover(function(){
					txt.css("background-position","-17px -767px");
				}).mouseout(function(){
					txt.css("background-position","-147px -793px");
				});
				window.external.ChangeScreenModel("模块全屏");
			}else if(lump == 3){
				icon.animate({"left":"78px"},1000);
				txt.css("background-position","-18px -803px");
				$("#tyScreenMode").mouseover(function(){
					txt.css("background-position","-18px -803px");
				}).mouseout(function(){
					txt.css("background-position","-147px -828px");
				});
				window.external.ChangeScreenModel("内容全屏");
			}
		});
	});
});
</script>
<div id="template">

<div class="fl set-hei48">
		选择查询范围： <select class="w176" id="organLevel" placeholder="请选择查询范围">
			<option value="1">本级机构</option>
			<option value="2">本级机构与下级机构</option>
		</select>
	</div>
	<div class="fl ml30 set-hei48"> 
		 <span class="fl">  车牌号码:<input type="search" class="k-textbox" id="vehicleNumber" name="vehicleNumber" placeholder="等待输入..." /></span> 
                 	   
		<button id="textButton" class="fr ty-btn-search" onclick="VehicleManage.search()"></button>
		 
                   <input type="hidden" id="pageSize" name="pageSize" value="${query.pageSize}">
                   <input type="hidden" id="pageStart" name="pageStart" value="${query.pageNo}">
		<div class="temp">
			<div class="ty-total-decorate"><span id="gridListTotal"></span><i></i></div>
			<div class="ty-decorate2"></div>
		</div>
	</div>
	<div class="fl set-hei48">
		<div class="ty-decorate1"></div>
		<button id="undo" class="ty-btn-add ty-btn-offset" onclick="VehicleManage.addVehicle()"></button>
                    
                   <span id="btnImportVehicle" class="k-button"  onclick="VehicleManage.importVehicle()">导入</span>
                   <span id="btnOutPortVehicle" class="k-button"  onclick="VehicleManage.outPortVehicle()">导出</span> 
	</div>
	<div class="fr set-hei48">
		<div class="ty-screen-mode" id="tyScreenMode">
			<i class="ty-screen-mode-btn1" title="标准模式"></i><i class="ty-screen-mode-btn2" title="模块全屏"></i><i class="ty-screen-mode-btn3" title="内容全屏"></i>
			<div class="ty-screen-mode-icon"></div>
			<span class="ty-screen-mode-txt"></span>
		</div>
	</div>
</div>
 