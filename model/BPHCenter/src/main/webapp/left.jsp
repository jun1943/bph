<%@ page language="java" pageEncoding="UTF-8"%>
<div id="navigationLeft">
        <div class="line1-mid box">
          <div class="t1-start"></div>
          <div class="end"></div>
        </div>
        <div class="pull-left box">
          <div>
            <div class="title box">搜索</div>
            <div class="hide" onclick="arrowZoom();"></div>
            <div class="clear">
            <div class="ty-input">
            	<input id="searchOrganName" value="${requestScope.searchOrganName}" placeholder="等待输入..." class="k-textbox ty-left-search"/>
            </div>
            <button class="k-button" onClick="queryOrgan()">搜索</button><br><br>
          </div>
        </div>
        <div class="pull-right box">
          <div class="line7"></div>
        </div>
        <div class="tree-box clear"><!----机构树---->
        <div id="box">
            <div id="treeview"></div>
            <div id="treeview2"></div>
		</div>
        </div><!----机构树结束---->
        <div class="line8 box"></div>
        <div class="line2"></div>
</div>        
		<script>
			 var zNodes;
			 var json_data;
			 var currentText;//当前选中的文本
			 var treeview;
			 var expandeds="";
			 $(document).ready(function () {
				 $.ajax({
						url:"<%=basePath%>web/organx/tree.do",
						type:"post",
						data:{
							searchName:$("#searchOrganName").val(),
							sessionId:$("#token").val(),
							expandeds:$("#expandeds").val(),
							random:Math.random()
						},
						dataType:"json",
						success:function(rsp){
							json_data =JSON.stringify(rsp.data);
							
							 treeview=$("#treeview").kendoTreeView({
								select: onSelect,//点击触发事件
							    dataSource: [eval('(' + json_data + ')')]
							}).data("kendoTreeView");
	        		  		<%-- $.ajax({
	        		  			url:"<%=basePath%>web/organx/addOrganTreeElement.do",
	    						type:"post",
	    						data:{
	    							sessionId:$("#token").val(),
	    							expandeds:$("#expandeds").val(),
	    							random:Math.random()
	    						},
	    						dataType:"json",
	    						success:function(rsp){
	    							$(rsp.data).each(function(){
	    								treeview.append(eval('(' + JSON.stringify(this) + ')'), selectedNode);
	                   				});
	    						}
	        		  		}); --%>
	        		  		test();
						}
					});
			 });
			
			function test(){
				 var expandedNodes = [],treeView = $("#treeview").data("kendoTreeView");
		            getExpanded(treeView.dataSource.view(),expandedNodes);
		            expandeds=expandedNodes.join(",");
			 }
			 
			 function getExpanded(nodes,expandedNodes) {
		            for (var i = 0; i < nodes.length; i++) {
		                if(nodes[i].expanded){
		                	expandedNodes.push(nodes[i].id);
		                }
		                if (nodes[i].hasChildren) {
		                	getExpanded(nodes[i].children.view(),expandedNodes);
		                }
		            }
		        }
			 
			 //查询通过name模糊查询
		        function queryOrgan(){
		        	$.ajax({
						url:"<%=basePath%>web/organx/tree.do",
						type:"post",
						data:{
							searchName:$("#searchOrganName").val(),
							expandeds:expandeds,
							sessionId:$("#token").val(),
							random:Math.random()
						},
						dataType:"json",
						success:function(rsp){
							json_data =JSON.stringify(rsp.data);
							
							$("#treeview").remove();
							$("#box").append("<div id='treeview'></div>");
							treeview=$("#treeview").kendoTreeView({
								select: onSelect,
							    dataSource: [eval('(' + json_data + ')')]
							}).data("kendoTreeView");
							
							 /* var selectedNode = treeview.select();

		                        if (selectedNode.length == 0) {
		                            selectedNode = null;
		                        } */
		        		  		<%-- $.ajax({
		        		  			url:"<%=basePath%>web/organx/addOrganTreeElement.do",
		    						type:"post",
		    						data:{
		    							name:$("#searchOrganName").val(),
		    							random:Math.random()
		    						},
		    						dataType:"json",
		    						success:function(rsp){
		    							$(rsp.data).each(function(){
		    								treeview.append(eval('(' + JSON.stringify(this) + ')'), selectedNode);
		                   				});
		    						}
		        		  		}); --%>
						}
		        	});
		        }
			 //单击触发事件
		 	 function onSelect(e) {
		 	/* 	 treeView1 = $("#treeview").data("kendoTreeView")
		 		 currentText=this.text(e.node);
		 		var json = treeToJson(treeView1.dataSource.view()); */
		 		//选择节点事件
		 		var treeview=$('#treeview').data('kendoTreeView');
		 		//获取选中节点的数据
		 		var data = treeview.dataItem(e.node);
		 		$("#organId").val(data.id);
 	    		$("#organPath").val(data.path);
 	    		test();
 	    		$("#expandeds").val(expandeds);
 	    		//alert(expandeds);
 	    		loadData(1);
			 }
		 	 
		 /* 	function treeToJson(nodes) {
		 	    return $.map(nodes, function(n, i) {
		 	    	if(currentText == n.text){
		 	    		$("#organId").val(n.id);
		 	    		$("#organPath").val(n.path);
		 	    		loadData();
		 	    	}
		 	        var result = { text: n.text, id: n.id, expanded: n.expanded, checked: n.checked };

		 	        if (n.hasChildren){
		 	        	 result.items = treeToJson(n.children.view());
		 	        }
		 	        return result;
		 	    });
		 	} */
		 // function that gathers IDs of checked nodes
	        function checkedNodeIds(nodes, checkedNodes) {
	            for (var i = 0; i < nodes.length; i++) {
	            	alert("id:"+nodes[i].id+" 展开状态 :"+nodes[i].expanded);
	                if (nodes[i].checked) {
	                    checkedNodes.push(nodes[i].id);
	                }

	                if (nodes[i].hasChildren) {
	                    checkedNodeIds(nodes[i].children.view(), checkedNodes);
	                }
	            }
	        }
	        // show checked node IDs on datasource change
	        function onCheck() {
	            var checkedNodes = [],
	                treeView = $("#treeview").data("kendoTreeView"),message;

	            checkedNodeIds(treeView.dataSource.view(), checkedNodes);

	            if (checkedNodes.length > 0) {
	                message = "IDs of checked nodes: " + checkedNodes.join(",");
	            } else {
	                message = "No nodes checked.";
	            }
	            //alert(message);
	        }
	        var cf = true;
	        function arrowZoom(){
    		//箭头点击收放效果
    			if(cf){
    				$("#navigationLeft").hide('fast',function(){
    					if($("#arrowXg1").length ==0){
    						$("#main-nav").append('<div class="temp"><div class="show" id="arrowXg1"></div></div>');
    					}
    					$("#arrowXg1").css({"position":"absolute","top":11,"left":0}).bind("click",function(){
    						$("#arrowXg1").parent().remove();
    						$("#content").animate({"margin-left":"240px"},'slow',function(){
    							$("#navigationLeft").show('fast');
    						});
    						cf=true;
    					});
    					$("#content").animate({"margin-left":"0"},'slow');
    				});
    				cf=false;
    			}
	        }
		</script>

