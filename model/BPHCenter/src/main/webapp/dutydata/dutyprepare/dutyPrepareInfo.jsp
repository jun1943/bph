<jsp:directive.page language="java" pageEncoding="UTF-8"/>


<script> 

      
</script>

<script type="text/x-kendo-template" id="dutyItemtemplate">
                <div class="dutyItemtoolbar">
                	<span id="undo" class="k-button" onclick="policeAddManage.savePoliceWithOut()">添加班次</span>
                	<span id="undo" class="k-button" onclick="policeAddManage.savePoliceWithOut()">设置班次</span>
                	<span id="undo" class="k-button" onclick="policeAddManage.savePoliceWithOut()">添加编组</span>
                	<span id="undo" class="k-button" onclick="policeAddManage.savePoliceWithOut()">设置编组</span>
                	<span id="undo" class="k-button" onclick="policeAddManage.savePoliceWithOut()">关联任务</span> 
                	<span id="undo" class="k-button" onclick="policeAddManage.savePoliceWithOut()">删除节点</span> 
                </div>
</script>

<script type="text/x-kendo-template" id="polContemplate">
                <div class="policeresourcetoolbar"> 
                	<span id="undo" class="k-button" onclick="DutyPraperManage.selectPolResCondition();">过滤条件</span> 
                	<input type="search" class="k-textbox" id="policeresName" name="policeresName" style="width:100px"  placeholder="等待输入..." />
                	<span id="undo" class="k-button" onclick="DutyPraperManage.searchPoliceRescource();">查询</span>  
                </div>
</script>

<script type="text/x-kendo-template" id="vehContemplate">
                <div class="vehicleresourcetoolbar">
                	<span id="undo" class="k-button" onclick="DutyPraperManage.selectVehResCondition();">过滤条件</span> 
                	<input type="search" class="k-textbox" id="vehicleresName" name="vehicleresName" style="width:100px"  placeholder="等待输入..." />
                	<span id="undo" class="k-button" onclick="DutyPraperManage.searchVehicleRescource();">查询</span> 
                </div>
</script>

<script type="text/x-kendo-template" id="wepContemplate">
                <div class="weaponresourcetoolbar">
                	<span id="undo" class="k-button" onclick="DutyPraperManage.selectWepResCondition();">过滤条件</span> 
                	<input type="search" class="k-textbox" id="weaponresName" name="weaponresName" style="width:100px"  placeholder="等待输入..." />
                	<span id="undo" class="k-button" onclick="DutyPraperManage.searchWeaponRescource();">查询</span> 
                </div>
</script>

<script type="text/x-kendo-template" id="gpsContemplate">
                <div class="gpsresourcetoolbar">
                	<span id="undo" class="k-button" onclick="DutyPraperManage.selectGpsResCondition();">过滤条件</span> 
                	<input type="search" class="k-textbox" id="gpsresName" name="gpsresName" style="width:100px"  placeholder="等待输入..." />
                	<span id="undo" class="k-button" onclick="DutyPraperManage.searchGpsRescource();">查询</span> 
                </div>
</script>

<script type="text/x-kendo-template" id="dutytemplatetb">
                <div class="dutytempletetoolbar"> 
                	<span id="undo" class="k-button" onclick="DutyPraperManage.sureSelectdutyTemp();">确定</span> 
                </div>
</script>

<div id="dutyResource" style="width:40%; float:left">
	<div class="demo-section k-header"> 
        <h4>报备资源</h4> 
        <div id="tabstrip-sprites"></div>
     </div>
</div> 	
<div id="dutyItems"  style="width:40%; float:left">
	<div> 
        <h4>报备明细</h4> 
        <div id="dutyItemList"></div>
     </div>
</div> 
<div id="dialog">
</div>


<div id="dutyCopyWindow" style="display:none">
	<div id="windowCpDate">
		<div class="demo-section k-header" style="width: 300px; text-align: center;">
      	    <div id="calendar"></div>
    	</div>
    </div> 
</div>

<div id="dutyTempleteWindow" style="display:none">
	<div id="windowTemplete">
		<div id="Templetegrid"></div>
    </div> 
</div>

<div id="dutyTypeSelectWindow" style="display:none">
	<div id="windowDutyType" >
		<div id="DutyTypetreeList"></div>
    </div> 
</div>


<div id="policeResConWindow" style="display:none">
	<div id="polResConWindow">
		<div><span id="undo" class="k-button" onclick="DutyPraperManage.searchPoliceRescource();">查询</span></div>
		<div id="polGroupgrid" style="width:45%; float:left"></div>
		<div id="polTypegrid" style="width:45%; float:left"></div>
    </div> 
</div>
<div id="vehicleResConWindow" style="display:none">
	<div id="vehResConWindow">
		<div><span id="undo" class="k-button" onclick="DutyPraperManage.searchVehicleRescource();">查询</span></div>
		<div id="vehGroupgrid" style="width:45%; float:left"></div>
		<div id="vehTypegrid" style="width:45%; float:left"></div>
    </div> 
</div>
<div id="gpsResConditionWindow" style="display:none">
	<div id="gpsResConWindow">
		<div><span id="undo" class="k-button" onclick="DutyPraperManage.searchGpsRescource();">查询</span></div>
		<div id="gpsGroupgrid" style="width:45%; float:left"></div>
		<div id="gpsTypegrid" style="width:45%; float:left"></div>
    </div> 
</div>
<div id="weaponResConWindow" style="display:none">
	<div id="wepResConWindow">
		<div><span id="undo" class="k-button" onclick="DutyPraperManage.searchWeaponRescource();">查询</span></div>
		<div id="wepGroupgrid" style="width:45%; float:left"></div>
		<div id="wepTypegrid" style="width:45%; float:left"></div>
    </div> 
</div>