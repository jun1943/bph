<%@ page language="java" pageEncoding="UTF-8"%>

<div id="template">
                <table style="width: 400px"><tr>
                   <td>
                                                         用户名:<input type="search" id="userName" name="userName" style="width: 150px"/>
                   <input type="hidden" id="organId" name="organId" value="${query.organId}">
                   <button id="textButton" onclick="search()">查询</button></td>
                   <td>
                   <span id="undo" class="k-button">新增用户</span></td>
                  </tr></table>
            </div>
            <div id="grid"></div>
                

            <script>	
                	function loadData() {
                	var	userName = $("#userName").val();
                	var organId = $("#organId").val();
                	$.ajax({
               			url:"<%=path %>/admin/getUserList.do",
               			type:"post",
               			dataType:"json",
               			data:{
               				organId:organId,
               				userName:userName
               			},
               			success:function(msg){
               				if(msg.code==200){
               					if(msg.data != null){
               						var udata = msg.data;
               						$("#grid").kendoGrid({
               	                        dataSource: {
               	                            data:udata,
               	                            pageSize: 20
               	                        },
               	                     height: 550,
                                     sortable: true,
                                     pageable: {
                                         refresh: true,
                                         pageSizes: true,
                                         buttonCount: 5
                                     },
               	                        columns: [{
               	                            field: "loginName",
               	                            title: "登录名"
               	                        }, {
               	                            field: "userName",
               	                            title: "用户名"
               	                        }, {
               	                            field: "createTime",
               	                            title: "创建时间"
               	                        }, {
               	                            field: "updateTime",
               	                            title: "修改时间"
               	                        }, {
            	                            field: "stateView",
            	                            title: "用户状态"
               	                        }]
               	                    });
               					}
               				}
               			}
               		});
                }
                loadData();
                function search(){
                	loadData();
        		}
            </script>
