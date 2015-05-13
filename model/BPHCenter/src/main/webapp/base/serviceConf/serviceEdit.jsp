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
			<div id="horizontal" style="height: 100%; width: 100%;">
				<div id="left-pane">
					<div class="pane-content">
						<!-- 左开始 -->
						<div class="demo-section k-header">
							<form id="employeeForm" data-role="validator"
								novalidate="novalidate">
								<h4>服务信息</h4>
								<ul>
									<input id="serviceId" value="${service.serviceId}" type="hidden"/>
									<li class="ty-input"><label for="aServiceName">服务名称:</label>
									<input type="text" class="k-textbox" value="${service.serviceName}" name="editServiceName" id="editServiceName" style="width:60%" /><em class="ty-input-end"></em>
									<li class="ty-input"><label for="aServiceIp">服务IP:</label> 
									<input type="text" class="k-textbox" value="${service.serviceIp}" name="editServiceIp" id="editServiceIp" style="width:60%" /><em class="ty-input-end"></em>
									<input id="editServiceType" value="${service.serviceType}" type="hidden"/>
									<li class="ty-input"><label for="aServiceType">服务类型:</label> 
										<select id="editType" name="editType" width=200px disabled="disabled">
											<option value="">---请选择服务类型---</option>
											<option value="1">mq</option>
											<option value="2">ftp</option>
											<option value="3">gps</option>
										</select>
									<li class="ty-input"><label for="aServicePort">服务端口:</label> 
									<input type="text" class="k-textbox" name="editServicePort" value="${service.servicePort}" id="editServicePort" style="width:60%" /><em class="ty-input-end"></em>
									<li class="ty-input"><label for="aServiceAccount">用户名:</label> 
									<input type="text" class="k-textbox" name="editServiceAccount" value="${service.serviceAccount}" id="editServiceAccount" style="width:60%" /><em class="ty-input-end"></em>
									<li class="ty-input"><label for="aServicePwd">用户密码:</label> 
									<input type="password" class="k-textbox" name="editServicePwd" id="editServicePwd" value="${service.servicePwd}" style="width:60%" /><em class="ty-input-end"></em>
									<li class="ty-input"><label for="aServiceVersion">服务版本:</label> 
									<input type="text" class="k-textbox" name="editServiceVersion" id="editServiceVersion" value="${service.serviceVersion}" style="width:60%" /><em class="ty-input-end"></em>
									<li class="ty-input"><label for="aServiceExchange">交换机名:</label> 
									<input type="text" class="k-textbox" name="editServiceExchange" id="editServiceExchange" value="${service.exchangeName}" style="width:60%" /><em class="ty-input-end"></em>
									<li class="ty-input actions">
										<button type="button" data-role="button" data-sprite-css-class="k-icon k-i-tick" data-click='save'>提交</button></li>
								</ul>
							</form>
						</div>
						<!-- 左结束-->
					</div>
				</div>
			</div>
	</div>

<style scoped>
#vertical {
	height: 450px;
	width: 640px;
	margin: 0 auto;
}

.pane-content {
	pediting: 0 10px;
}

#employeeForm ul {
	list-style-type: none;
	margin: 0;
	pediting: 0;
}

#employeeForm li {
	margin-top: 10px;
}

label {
	display: inline-block;
	pediting-right: 3px;
	width: 80px;
}

span.k-tooltip {
	margin-left: 6px;
}

.demo-section {
	height:420px;
	width: 300px;
}

.actions {
	pediting-left: 106px;
	pediting-top: 10px;
}
</style>

<script>

$(document).ready(function() {
	$("#editType").val($("#editServiceType").val());
    var window = $("#window"),
        undo = $("#undo")
                .bind("click", function() {
                    $("body").tyWindow.open();
                });
    
    $("#horizontal").kendoSplitter({
        panes: [
            { collapsible: true, size: "320px" },
            { collapsible: true, size: "320px" }
        ]
    });	
    
    var container = $("#employeeForm");
    kendo.init(container);
    container.kendoValidator({
        rules: {
            validmask: function (input) {
                if (input.is("[data-validmask-msg]") && input.val() != "") {
                    var maskedtextbox = input.data("kendoMaskedTextBox");
                    return maskedtextbox.value().indexOf(maskedtextbox.options.promptChar) === -1;
                }
                return true;
            }
        }
    });
});
               function save(e) {
            	   if($("#editServiceName").val().trim()==""){
                   		$("body").popjs({"title":"提示","content":"请输入服务名称"});
            		    return false;
                   }
            	   if($("#editServiceIp").val().trim()==""){
                  		$("body").popjs({"title":"提示","content":"请输入服务IP"});
           		     return false;
                   }
            	   if($("#editType").val().trim()==""){
                 		$("body").popjs({"title":"提示","content":"请选择服务类型"});
          		     return false;
                   }
            	   if($("#editServicePort").val().trim()==""){
                		$("body").popjs({"title":"提示","content":"服务端口不能为空"});
         		    return false;
                   }
            	   if($("#editServiceAccount").val().trim()==""){
               		$("body").popjs({"title":"提示","content":"请输入用户名"});
        		    return false;
                   }
            	   if($("#editServicePwd").val().trim()==""){
                  		$("body").popjs({"title":"提示","content":"请输入用户密码"});
           		    return false;
                   }
            	   if($("#editServiceVersion").val().trim()==""){
                  		$("body").popjs({"title":"提示","content":"请输入服务版本"});
           		    	return false;
                   }
                   if($("#editServiceExchange").val().trim()==""){
                 		$("body").popjs({"title":"提示","content":"请输入交换机名称"});
          		    	return false;
                  }
            	   editService(); 
                } 
                
                /* 修改服务 */
       	   	 function editService(){
       	   		var serviceName=$("#editServiceName").val();
       	   		var editServiceIp=$("#editServiceIp").val();
       	   		var editType=$("#editType").val();
       	   		var editServicePort=$("#editServicePort").val();
       	   		var editServiceAccount=$("#editServiceAccount").val();
       	   		var editServicePwd=$("#editServicePwd").val();
       	   		var editServiceVersion=$("#editServiceVersion").val();
       	   		var editServiceExchange=$("#editServiceExchange").val();
       	   		$.ajax({
       	   			url:"<%=basePath%>serviceSet/update.do",
       	   			type:"post",
       	   			dataType:"json",
       	   			data:{
       	   				serviceId:$("#serviceId").val(),
       	   				serviceName:serviceName,
       	   				serviceIp:editServiceIp,
       	   				serviceType:editType,
       	   				servicePort:editServicePort,
       	   				serviceAccount:editServiceAccount,
       	   				servicePwd:editServicePwd,
       	   				serviceVersion:editServiceVersion,
       	   				exchangeName:editServiceExchange,
       	   				sessionId:$("#token").val()
       	   			},
       	   			success:function(msg){
       	   				if(msg.code==200){
       	   					$("body").popjs({"title":"提示","content":msg.description,"callback":function(){
       	   						window.parent.window.parent.onClose();
       	   						window.parent.$("#dialog").tyWindow.close();
       	   					}});
       	   				}else{
       	   					$("body").popjs({"title":"提示","content":msg.description});
       	   				}
       	   			}
       	   		});
       	   	 }
            </script>
        </body>
        </html>   

