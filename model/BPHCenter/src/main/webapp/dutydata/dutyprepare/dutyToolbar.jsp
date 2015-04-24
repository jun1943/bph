<%@ page language="java" pageEncoding="UTF-8"%>

<script>
$(document).ready(function() {     
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
		<div class="temp">
			<div class="ty-total-decorate"><span id="gridListTotal"></span><i></i></div>
			<div class="ty-decorate2"></div>
		</div>
	</div>
	<div class="fl set-hei48">
		<div class="ty-decorate1"></div> 
					<input type="hidden" id="organCode" name="organCode" value="${organ.code}">
                   <span id="btnaddParentNode" class="k-button"  onclick="DutyPraperManage.selectDutyType()">勤务类型选择</span>
                   <span id="btnaddChildNode" class="k-button"  onclick="DutyPraperManage.selectDutyTemplete()">报备模板选择</span> 
                   <span id="btndeleteNode" class="k-button"  onclick="DutyPraperManage.copyOfDuty()">报备复制</span> 
                   <span id="btnunLockNode" class="k-button"  onclick="DutyPraperManage.clearDuty()">清空报备</span> 
                   <span id="btnlockNode" class="k-button"  onclick="DutyPraperManage.saveDutyAsTemplete()">保存模板</span> 
                   <span id="btnlockNode" class="k-button"  onclick="DutyPraperManage.saveDuty()">保存</span> 
                   <span id="btnlockNode" class="k-button"  onclick="DutyPraperManage.exportDuty()">导出</span> 
	</div>
	<div class="fr set-hei48">
		<div class="ty-screen-mode" id="tyScreenMode">
			<i class="ty-screen-mode-btn1" title="标准模式"></i><i class="ty-screen-mode-btn2" title="模块全屏"></i><i class="ty-screen-mode-btn3" title="内容全屏"></i>
			<div class="ty-screen-mode-icon"></div>
			<span class="ty-screen-mode-txt"></span>
		</div>
	</div>
</div>

 
