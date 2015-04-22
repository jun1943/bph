<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html>
<head>
<title>扁平化指挥系统</title>
<%@ include file="../../emulateIE.jsp" %>	
</head>

<body>
<div id="vertical">
			<div id="horizontal" style="height: 450px; width: 590px;">
				<div id="left-pane">
					<div class="pane-content">
						<!-- 左开始 -->
						<div class="demo-section k-header">
							<form id="employeeForm" data-role="validator" novalidate="novalidate">
								<h4>卡点信息</h4>
								<ul>
									<li>
										<input type="hidden" value="${organId}" id="orgId" name="orgId" />
										<input id="token" type="hidden" value="${requestScope.sessionId}"/></li></li>
									<li><label for="name">卡点名称:</label> 
										<input type="text" class="k-textbox" name="name" id="name" required="required" /></li>
									<li><label for="managerName">负责人:</label> 
										<input type="text" class="k-textbox" name="managerName" id="managerName" readOnly="true" />
										<button type="button" onclick="loadPolice();">选择警员</button></li>
									<li><input type="hidden" class="k-textbox" name="manager" id="manager" /></li>
									<li><label for="telephone">联系电话:</label> 
										<input type="text" class="k-textbox" name="telephone" id="telephone" 
										pattern="^[0-9]+$" validationMessage='联系电话只能输入数字' /></li>
									<li><label for="intercomGroupId">通讯组号:</label> 
										<input type="text" class="k-textbox" name="intercomGroupId" id="intercomGroupId" 
											   pattern="^[0-9]+$" validationMessage='通讯组号由一串数字组成'/>
									<li><label for="equipment">携带装备:</label> 
										<input type="text" class="k-textbox" name="equipment" id="equipment" /></li>
									<li><label for="policeNote">警力描述:</label> 
										<input type="text" class="k-textbox" name="policeNote" id="policeNote" /></li>
									<li><label for="assignment">职责描述:</label> 
										<input type="text" class="k-textbox" name="assignment" id="assignment" /></li>
									<li><label for="cameraName">关联天网:</label> 
										<input type="text" class="k-textbox" name="cameraName" id="cameraName" readOnly="true" />
										<button type="button" onclick="loadCamera();">选择天网</button></li></li>
									<li><input type="hidden" class="k-textbox" name="camera" id="camera" /></li>
									<li><label for="longitude">经度:</label> 
										<input type="text" class="k-textbox" name="longitude" id="longitude" 
										pattern="^[0-9]+$" validationMessage='经度只能输入数字' />
										<label for="latitude">纬度:</label> 
										<input type="text" class="k-textbox" name="latitude" id="latitude" 
										pattern="^[0-9]+$" validationMessage='纬度只能输入数字'/></li>
										
									<li><label for="circleLayer">圈层选择:</label> 
										<select id="circleLayer" class="" name="circleLayer" value="${cardPoint.circleLayer}">
								    		<!-- <option value="1">第一圈层</option>
								    		<option value="2">第二圈层</option>
								    		<option value="3">第三圈层</option> -->
							    		</select></li>
							    	<!-- <li><label for="iconId">图标选择:</label> 
										<input type="text" class="k-textbox" name="iconId" id="iconId" disabled="true"　readOnly="true" />
										<button type="button" onclick="loadIcon();">选择图标</button></li></li> -->
																		
									<li class="actions">
										<button type="button" data-role="button"
											data-sprite-css-class="k-icon k-i-tick" onclick='editCardPoint()'>提交</button>
									</li>
								</ul>
							</form>
						</div>

<script type="text/javascript">
	$(document).ready(function() {
		loadCircle();
	});
	
	/* 加载圈层 */
	function loadCircle(){
		$("#circleLayer").append(
				"<c:forEach var='item' items='${circleList}'>"
				+"<option value='${item.id}'>${item.name}</option>"
				+"</c:forEach>");
	}
	
	/* 添加卡点 */
	function editCardPoint(){
		if($("#name").val()==""){
			$("body").popjs({"title":"提示","content":"卡点名称不能为空！"});
			return false;
		} 
  	   
		$.ajax({
			url:"<%=basePath%>web/cardPoint/addCardPoint.do",
			type:"post",
			dataType:"json",
			data:{
				/* cardPointId:$("#cardPointId").val(), */
				organId: 		$("#orgId").val(),
				name:			$("#name").val(),
				manager:		$("#manager").val(),
				telephone:		$("#telephone").val(),
				intercomGroupId:$("#intercomGroupId").val(),
				equipment:		$("#equipment").val(),
				policeNote:		$("#policeNote").val(),
				assignment:		$("#assignment").val(),
				camera:			$("#camera").val(),
				longitude:		$("#longitude").val(),
				latitude:		$("#latitude").val(),
				circleLayer:	$("#circleLayer").val(),
				sessionId:$("#token").val(),
				/* iconId:			$("#iconId").val() */
			},
			 success:function(msg){
				if(msg.code==200){
					alert(msg.description);
					//window.parent.$("#dialog").data("kendoWindow").close();
					window.parent.$("#dialog").tyWindow.close();
					<%-- window.location.href="<%=basePath%>web/cardPoint/queryCardPointPageList.action"; --%>
				}else{
					alert(msg.description);
				}
			}
		});
	}
    $(function () {
        var container = $("#employeeForm");
        kendo.init(container);
        container.kendoValidator({
            rules: {
                validmask: function (input) {
                    if (input.is("[data-validmask-msg]") && input.val() != "") {
                        var maskedtextbox = input.data("kendoMaskedTextBox");
                        return maskedtextbox.value().indexOf(maskedtextbox.options.promptChar) == -1;
                    }

                    return true;
                }
            }
        });
    });

    var tempItem = new Array();
    var tempItem2 = new Array();
           /* 卡点负责人 */
           function loadPolice(){
        	   
       		$("#managerName").val("");
       		$("#manager").val("");
       		tempItem.splice(0,tempItem.length);//清空数组 
       		tempItem.splice(0,tempItem2.length);
       		
			$("#treeview").remove();
			$("#addRoleTreeview").remove();
			$("#policeview").remove();
			$("#organTitle").remove();
			$("#cameraTitle").remove();
			$("#policeTitle").remove();
			$("#cameraview").remove();
			$("#policeBox").append("<h4 id='policeTitle'>警员绑定</h4><div id='policeview'>"
					+"<c:forEach var='item' items='${policeList}'>"
					+"<input name='policeName' class='policeName' id='policeName' type='checkbox' value='${item.id}' onclick='selectPolice(this,\"${item.id}\",\"${item.name}\")'/>${item.name}</br>"
					+"</c:forEach>"
					+"</div>");
           }
           function selectPolice(o,id,name){
           	if($(o).prop("checked")){
           		if(tempItem.length>0){
           			var size = tempItem.length;
            		for(var i = 0; i<size; i++){
            			if(tempItem[i] != name){
            				tempItem.push(name);
            				break;
            			}
            		}
           		}else{
           			tempItem.push(name);
           		}
           		if(tempItem2.length>0){
            		for(var i = 0;i<tempItem2.length;i++){
            			if(tempItem2[i] != id){
            				tempItem2.push(id);
            				break;
            			}
            		}
           		}else{
           			tempItem2.push(id);
           		}
           	}else{
           		for(var i = 0;i<tempItem.length;i++){
           			if(tempItem[i] == name){
           				tempItem.baoremove(i);
           			}
           		}
           		for(var i = 0;i<tempItem2.length;i++){
           			if(tempItem2[i] == id){
           				tempItem2.baoremove(i);
           			}
           		}
           	}
           	$("#managerName").val(tempItem);
           	$("#manager").val(tempItem2);
           }
           Array.prototype.baoremove = function(dx){
      if(isNaN(dx)||dx>this.length){
      	return false;
      }
             　　this.splice(dx,1);
        }
           
	/* 关联天网 */
	function loadCamera(){
		$("#treeview").remove();
		$("#addRoleTreeview").remove();
		$("#policeview").remove();
		$("#policeTitle").remove();
		$("#organTitle").remove();
		$("#roleTitle").remove();
		$("#cameraTitle").remove();
		$("#cameraview").remove();
		$("#policeBox").append("<h4 id='cameraTitle'>关联天网</h4><div id='cameraview'>"
				+"<c:forEach var='item' items='${cameraList}'>"
				+"<input name='cameraNames' id='cameraNames' type='checkbox' value='${item.id}' onclick='selectCamera(this,\"${item.id}\",\"${item.name}\")'/>${item.name}</br>"
				+"</c:forEach>"
				+"</div>");
	}
	var tempItem3 = new Array();
	var tempItem4 = new Array();
	function selectCamera(o,id,name){
         	if($(o).prop("checked")){
         		if(tempItem3.length>0){
          		for(var i = 0;i<tempItem3.length;i++){
          			if(tempItem3[i] != name){
          				tempItem3.push(name);
          				break;
          			}
          		}
         		}else{
         			tempItem3.push(name);
         		}
         		if(tempItem4.length>0){
          		for(var i = 0;i<tempItem4.length;i++){
          			if(tempItem4[i] != id){
          				tempItem4.push(id);
          				break;
          			}
          		}
         		}else{
         			tempItem4.push(id);
         		}
         	}else{
         		for(var i = 0;i<tempItem3.length;i++){
         			if(tempItem3[i] == name){
         				tempItem3.baoremove(i);
         			}
         		}
         		for(var i = 0;i<tempItem4.length;i++){
         			if(tempItem4[i] == id){
         				tempItem4.baoremove(i);
         			}
         		}
         	}
         	$("#cameraName").val(tempItem3);
         	$("#camera").val(tempItem4);
	}
</script>

<style scoped>
#employeeForm ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

#employeeForm li {
	margin-top: 10px;
}

label {
	display: inline-block;
	padding-right: 3px;
	width: 60px;
}

span.k-tooltip {
	margin-left: 6px;
}

.demo-section {
	width: 290px;
}

.actions {
	padding-left: 106px;
	padding-top: 10px;
}
</style>

		<!-- 左结束-->
	</div>
</div>

<div id="right-pane">
	<div class="pane-content">
		<!-- 右开始 -->
		<!-- 跨机构授权开始 -->

		<!-- <div class="box-col" id="addRoleBox">
			<h4 id="policeTitle">警员选择</h4>
			<div id="addPoliceTreeview"></div>
		</div> -->
		<div id="box">
		     <h4 id="organTitle"></h4>
             <div id="treeview"></div>
        </div>
        <div id="policeBox">
		     <h4 id="policeTitle"></h4>
             <div id="policeview"></div>
        </div>
		<!-- 跨机构授权结束 -->
		<!-- 右结束-->
	</div>
</div>
</div>
</div>

<script>
$(document).ready(function() {
	/* 警员选择 */
	loadPolice();
	
	function addOnCheck(e) {
		text=this.text(e.node);
		var checkedNodes = [],
		treeView = $("#addRoleTreeview").data("kendoTreeView"),message;
		//treeToJson(treeView.dataSource.view());
		addCheckedNodeIds(treeView.dataSource.view(), checkedNodes);

		if (checkedNodes.length > 0) {
			message = checkedNodes.join(",");
		} else {
			message = "";
		}
		amodulesId=message;
	}
      	
    $("#horizontal").kendoSplitter({
        panes: [
            { collapsible: true, size: "320px" },
            { collapsible: true, size: "320px" }
        ]
    });
});
</script>

<style scoped>
#vertical {
	height: 490px;
	width: 640px;
	margin: 0 auto;
}

.pane-content {
	padding: 0 10px;
}
</style>

</body>
</html>