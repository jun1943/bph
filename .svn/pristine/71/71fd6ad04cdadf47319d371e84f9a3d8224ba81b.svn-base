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
<title>扁平化指挥调度系统</title>
<%@ include file="../../emulateIE.jsp" %>
</head>

<body>
	<div id="vertical">
	<div id="horizontal" style="height:104%; width:100%;">
				<div id="left-pane">
			<div class="pane-content">
				<!-- 左开始 -->
				<div class="demo-section k-header">
					<form id="employeeForm" data-role="validator"
						novalidate="novalidate">
						<h4>机构信息</h4>
						<ul>
							<li><label for="aOrganName">机构名称:</label> <input type="text"
								class="k-textbox" name="addOrganName" id="addOrganName"
								 />
							<li><label for="aOrganCode">机构编码:</label> <input type="text"
								class="k-textbox" name="addOrganCode" id="addOrganCode"
								 /></li>
							<li><label for="aShortName">机构简称:</label> <input type="text"
								class="k-textbox" name="addShortName" id="addShortName"
								 /></li>
							<li><label for="aOrganType">机构类型:</label> <select
								 id="addOrganType" name="addOrganType" width=200px>
									<option value="">---请选择类型---</option>
									<option value="1">市局</option>
									<option value="2">分局</option>
									<option value="3">市局直属</option>
									<option value="4">分局机关</option>
									<option value="5">派出所</option>
							</select></li>
							<li><label for="aParentName">上级机构:</label> <input
								type="hidden" id="addParentId" value="${organ.id}" /> <input
								type="text" class="k-textbox" name="addParentName"
								id="addParentName"  value="${organ.name}" disabled="disabled"/></li>
							<li><label for="aOrganNote">机构备注:</label> <input type="text"
								class="k-textbox" name="addOrganNote" id="addOrganNote" /></li>
							<li class="actions">
								<button type="button" data-role="button"
									data-sprite-css-class="k-icon k-i-tick" data-click='save'>提交</button>
							</li>
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
	margin:0 auto;
}

.pane-content {
	padding: 0 10px;
}

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
	padding-right:3px;
	margin-left:160px;
	width:80px;
}

span.k-tooltip {
	margin-left: 6px;
}

.demo-section {
	width: 600px;
	height:440px;
}

.actions {
	padding-left: 256px;
	padding-top: 10px;
}
</style>

	<script>
                $(document).ready(function() {
                	$("#addOrganType").kendoComboBox().prev().find(".k-input").attr("readonly",true);
                	
                    /* var window = $("#window"),
                        undo = $("#undo")
                                .bind("click", function() {
                                    window.data("kendoWindow").open();
                                });

                    if (!window.data("kendoWindow")) {
                        window.kendoWindow({
                            width: "650px",
                            title: "机构管理",
                            actions: [
                                "Close"
                            ]
                        });
                    } */
                    
                   /*  $("#horizontal").kendoSplitter({
                        panes: [
                            { collapsible: true, size: "320px" },
                            { collapsible: true, size: "320px" }
                        ]
                    }); */
                    
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
                   /*  var validator = $("#employeeForm").data("kendoValidator");
                    if (validator.validate()) {
                    	//alert("验证成功");
                    	addOrgan();
                    } */
                    var code=$("#addOrganCode").val();
                    
                    if($("#addOrganName").val()==""){
                    	$("body").popjs({"title":"提示","content":"机构名不能为空！"});
             		    return false;
                    }
                    if(code==""){
                    	$("body").popjs({"title":"提示","content":"机构编码不能为空！"});
             		    return false;
                    }
                    if(isNaN(code)){
           		        $("body").popjs({"title":"提示","content":"机构编码只能为数字！"});
           		        return false;
             		 }
                    if($("#addShortName").val()==""){
                    	$("body").popjs({"title":"提示","content":"机构简称不能为空！"});
             		    return false;
                    }
                    if($("#addOrganType").val()==""){
                    	$("body").popjs({"title":"提示","content":"请选择机构类型！"});
             		    return false;
                    }
                    addOrgan();
                }
                
                function addOrgan(){
          			$.ajax({
          				url:"<%=basePath%>web/organx/addOrgan.do",
          				type:"post",
          				dataType:"json",
          				data:{
          					name:$("#addOrganName").val(),
          					code:$("#addOrganCode").val(),
          					shortName:$("#addShortName").val(),
          					parentId:$("#addParentId").val(),
          					orgTypeCode:$("#addOrganType").val(),
          					sessionId:$("#token").val(),
          					note:$("#addOrganNote").val()
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
