<%@ page language="java" pageEncoding="UTF-8"%>
           <%@ include file="../../emulateIE.jsp" %>
            <div id="grid"></div>
            <div id="page"></div>
            <div id="dialog">
            	 
            </div>
            <script>	
                	function loadData(pageNo) {
                	var	roleName = $("#roleName").val();
                	$.ajax({
               			url:"<%=basePath%>role/getRoleList.do",
               			type:"post",
               			dataType:"json",
               			data:{
               				name:roleName,
               				sessionId:$("#token").val(),
               			},
               			success:function(msg){
               				if(msg.code==200){
               					if(msg.data.data != null){
               						var udata = msg.data.data;
               						var total = msg.totalRows;
               						$("#gridListTotal").text(total+"个");
               						$("#grid").kendoGrid({
               	                        dataSource: {
               	                            data:udata,
               	                        },
               	                     height: 550,
                                     sortable: true,
                                     selectable: "multiple",
               	                        columns: [{
               	                        	field: "id",
               	                            title: "角色ID",
               	                            hidden:true
               	                        }, {
               							field: "操作",
               							template: "<button id='#: id#' class='ty-edit-btn' title='修改' onclick='editAction(#: id#)'>修改</button> "
               							+"<button id='#: id#' class='ty-delete-btn' title='删除' onclick='delteAction(#: id #)'>删除</button> "
               							}, {
               	                            field: "name",
               	                            title: "角色名称"
               	                        }, {
               	                            field: "note",
               	                            title: "角色备注"
               	                        }, {
               	                            field: "createTime",
               	                            title: "创建时间"
               	                        }],
               	                         change: function (e) {
                                         var roleId = e.sender.selectable.userEvents.currentTarget.cells[0].innerHTML;
                                         loadTree(roleId);//根据角色id 加载右边的功能权限
                                     }
               	                    });

               						$("#grid .k-grid-content").mCustomScrollbar( {scrollButtons:{enable:true},advanced:{ updateOnContentResize: true } });
               						var pg = pagination(pageNo,total,'loadData',10);
               	                	$("#page").html(pg);
               					}
               				}
               			}
               		});
                }
                loadData(1);
                function search(){
                	loadData(1);
        		}
                
                function showAddRole(){
                	var sessionId=$("#token").val();
                	$("#dialog").tyWindow({
                		width: "680px",
                		height: "480px",
                	    title: "角色新增",
                	    position: {
                	        top: "100px"
                	      },
                		 content: "<%=basePath%>role/gotoAddRole.do?sessionId="+sessionId,
                		iframe : true,
                		closeCallback: onClose
                		});
                	//$("#dialog").data("kendoWindow").open();
                }
                
                function onClose(e){
                	loadData();
                }
                function delteAction(roleId){
                	var sessionId=$("#token").val();
                	
                    $("body").tyWindow({"content":"确定要删除?","center":true,"ok":true,"no":true,"okCallback":function(){
           			$.ajax({
           				url:"<%=basePath%>role/delete.do",
           				type:"post",
           				dataType:"json",
           				data:{
           					roleId:roleId,
           					sessionId:sessionId
           				},
           				success:function(msg){
           					if(msg.code==200){
           						//alert(msg.description);
           						$("body").popjs({"title":"提示","content":msg.description});
           						loadData();
           					}else{
           						//alert(msg.description);
           						$("body").popjs({"title":"提示","content":msg.description});
           					}
           				}
           			});
                    }});
                }
                //单击修改按钮弹出对话框
                function editAction(roleId){
                	var sessionId = $("#token").val();
                	$("#dialog").tyWindow({
                		width: "680px",
                		height: "480px",
                	    title: "角色编辑",
                	    position: {
                	        top: "100px"
                	      },
                		 content: "<%=basePath%>role/gotoRoleDetail.do?roleId="+roleId+"&sessionId="+sessionId,
                		iframe : true,
                		closeCallback: onClose
                		});
                	//$("#dialog").data("kendoWindow").open();
                	<%-- $("#editRoleName").val(name);
                	$("#editRoleNote").val(note);
                	$("#eRoleId").val(roleId);
                	 $.ajax({
 						url:"<%=basePath%>role/getModuleTree.do",
 						type:"post",
 						data:{
 							roleId:roleId,
 							random:Math.random()
 						},
 						dataType:"json",
 						success:function(rsp){
 							var editRoleData =JSON.stringify(rsp.data);
 							$("#editRoleTreeview").remove();
							$("#editRoleBox").append("<div id='editRoleTreeview'></div>");
							
 							$("#editRoleTreeview").kendoTreeView({
 								//select: onSelect,//点击触发事件
 							    checkboxes: {
 							        checkChildren: true//允许复选框多选
 							    },
 							    check: editOnCheck,//check复选框
 							    dataSource: [eval('(' + editRoleData + ')')]
 							}).data("kendoTreeView");
 						}
 					}); --%>
				}
                //点击每行单元格在右边显示功能信息
                function loadTree(roleId){
	               	 $.ajax({
							url:"<%=basePath%>role/getModuleTree.do",
							type:"post",
							data:{
								roleId:roleId,
								sessionId:$("#token").val(),
								random:Math.random()
							},
							dataType:"json",
							success:function(rsp){
								var roleData=JSON.stringify(rsp.data);
								$("#moduletreeview").remove();
								$("#roleBox").append("<div id='moduletreeview'></div>");
								$("#moduletreeview").kendoTreeView({
									//select: onSelect,
								     checkboxes: {
								        checkChildren: true
								    }, 
								    check: onCheck,
								    dataSource: [eval('(' + roleData + ')')]
								}).data("kendoTreeView");
							}
						});
                }
            </script>
