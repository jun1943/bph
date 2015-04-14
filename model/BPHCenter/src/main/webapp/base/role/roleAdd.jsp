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
								<h4>角色信息</h4>
								<ul>
									<li class="ty-input"><label for="aRoleName">角色名称:</label>
									<input type="text" class="k-textbox" name="addRoleName" id="addRoleName" style="width:60%" /><em class="ty-input-end"></em>
									<li class="ty-input"><label for="aRoleNote">角色描述:</label> 
									<textarea rows="3" cols="20" class="ty-textarea" id="addRoleNote" style="width:55%;"></textarea></li>
									<li class="ty-input actions">
										<button type="button" data-role="button" data-sprite-css-class="k-icon k-i-tick" data-click='save'>提交</button></li>
								</ul>
							</form>
						</div>
						<!-- 左结束-->
					</div>
				</div>
				
				<div id="right-pane">
					<div class="pane-content">
						<!-- 右开始 -->
						<!-- 跨机构授权开始 -->
						<div class="box-col" id="addRoleBox">
							<h4>功能选择</h4>
							<div id="addRoleTreeview"></div>
						</div>
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
	padding-right: 3px;
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
	padding-left: 106px;
	padding-top: 10px;
}
</style>

<script>
		var amodulesId="";
                $(document).ready(function() {
   				 $.ajax({
   						url:"<%=basePath%>role/getModuleTree.do",
   						type:"post",
   						data:{
   							roleId:"",
   							sessionId:$("#token").val(),
   							random:Math.random()
   						},
   						dataType:"json",
   						success:function(rsp){
   							var addRoleData =JSON.stringify(rsp.data);
   							
   							$("#addRoleTreeview").kendoTreeView({
   								//select: onSelect,//点击触发事件
   							    checkboxes: {
   							        checkChildren: true//允许复选框多选
   							    },
   							    check: addOnCheck,//check复选框
   							    dataSource: [eval('(' + addRoleData + ')')]
   							}).data("kendoTreeView");
   						}
   					});
                	
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
            	   if($("#addRoleName").val()==""){
                   		$("body").popjs({"title":"提示","content":"角色名称不能为空"});
            		    return false;
                   }
            	   if($("#addRoleNote").val()==""){
                   		$("body").popjs({"title":"提示","content":"角色备注不能为空"});
            		    return false;
                   }
            	   addRole(); 
                } 
                
                /* 添加角色 */
       	   	 function addRole(){
       	   		var roleName=$("#addRoleName").val();
       	   		var roleNote=$("#addRoleNote").val();
       	   		$.ajax({
       	   			url:"<%=basePath%>role/insertRole.do",
       	   			type:"post",
       	   			dataType:"json",
       	   			data:{
       	   				roleName:roleName,
       	   				roleNote:roleNote,
       	   				sessionId:$("#token").val(),
       	   				modulesId:amodulesId
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
	            //$("#result").html(message);
	        }
		 
		 
	 // function that gathers IDs of checked nodes
      function addCheckedNodeIds(nodes, checkedNodes) {
          for (var i = 0; i < nodes.length; i++) {
              if (nodes[i].checked) {
                  checkedNodes.push(nodes[i].id);
              } 
              if (nodes[i].hasChildren) {
            	  addCheckedNodeIds(nodes[i].children.view(), checkedNodes);
              }
          }
      }
            </script>
        </body>
        </html>   

