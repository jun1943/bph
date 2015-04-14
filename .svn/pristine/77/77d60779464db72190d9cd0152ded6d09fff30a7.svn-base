<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test4.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>Skin/Default/css/global.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Skin/Default/css/base.css"/>
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath %>JS/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="<%=basePath %>JS/jquery-1.11.1.min.js"></script>
	<link href='<%=basePath %>Skin/assets/stylesheets/bootstrap/bootstrap.css' media='all' rel='stylesheet' type='text/css' />
	<!-- / flatty theme -->
	<link href='<%=basePath %>Skin/assets/stylesheets/light-theme.css' id='color-settings-body-color' media='all' rel='stylesheet' type='text/css' />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!-- / kendo -->
	<link href="<%=basePath %>resources/css/web/kendo.common.min.css" media='all' rel='stylesheet' type='text/css' />
	<link href="<%=basePath %>resources/css/web/kendo.default.min.css" media='all' rel='stylesheet' type='text/css' />
	<link href="<%=basePath %>resources/css/dataviz/kendo.dataviz.min.css" media='all' rel='stylesheet' type='text/css' />
	<link href="<%=basePath %>resources/css/dataviz/kendo.dataviz.default.min.css" media='all' rel='stylesheet' type='text/css' />		
	<script src="<%=basePath %>resources/js/jquery.min.js" type='text/javascript'></script>
	<script src="<%=basePath %>resources/js/kendo.all.min.js" type='text/javascript'></script>
		
	</head>
	<body>
	 <div id="example">

            <div class="box">
                <div class="box-col">
                    <h4>Expand / Collapse</h4>
                    <ul class="options">
                        <li>
                            <button class="k-button" id="expandAllNodes">Expand all nodes</button>
                        </li>
                        <li>
                            <button class="k-button" id="collapseAllNodes">Collapse all nodes</button>
                        </li>
                    </ul>
                </div>
                <div class="box-col">
                    <h4>Enable / Disable</h4>
                    <ul class="options">
                        <li>
                        <button class="k-button" id="disableNode">Disable node</button>
                        </li>
                        <li>
                            <button class="k-button" id="enableAllNodes">Enable all nodes</button>
                        </li>
                    </ul>
                </div>
                <div class="box-col">
                    <h4>Add / Remove</h4>
                    <ul class="options">
                        <li>
                            <input id="appendNodeText" value="Node" class="k-textbox"/>
                            <button class="k-button" id="appendNodeToSelected">Append node</button>
                        </li>
                        <li>
                            <button class="k-button" id="removeNode">Remove node</button>
                        </li>

                    </ul>
                </div>

                <div class="box-col">
                    <h4>DataSource interaction</h4>
                    <ul class="options">
                        <li>
                            <button class="k-button" id="sortDataSource">Sort</button>
                        </li>
                        <li>
                            <input id="filterText" value="Item 1" class="k-textbox"/>
                            <button class="k-button" id="filterDataSource">Filter by text</button>
                        </li>
                    </ul>
                </div>
            </div>
            
            <div class="demo-section k-header">
                <div id="treeview"></div>
            </div>

            <script>
                $(document).ready(function() {
                    var treeview = $("#treeview").kendoTreeView({
                            dataSource: {
                                data: [
                                    { text: "Item 1", expanded: true, items: [
                                        { text: "Item 1.1" },
                                        { text: "Item 1.2" },
                                        { text: "Item 1.3" }
                                    ] },
                                    { text: "Item 2", items: [
                                        { text: "Item 2.1" },
                                        { text: "Item 2.2" },
                                        { text: "Item 2.3" }
                                    ] },
                                    { text: "Item 3" }
                                ]
                            },
                            loadOnDemand: false
                        }).data("kendoTreeView"),

                        handleTextBox = function(callback) {
                            return function(e) {
                                if (e.type != "keypress" || kendo.keys.ENTER == e.keyCode) {
                                    callback(e);
                                }
                            };
                        };


                    $("#disableNode").click(function() {
                        var selectedNode = treeview.select();

                        treeview.enable(selectedNode, false);
                    });

                    $("#enableAllNodes").click(function() {
                        var selectedNode = treeview.select();

                        treeview.enable(".k-item");
                    });

                    $("#removeNode").click(function() {
                        var selectedNode = treeview.select();

                        treeview.remove(selectedNode);
                    });

                    $("#expandAllNodes").click(function() {
                        treeview.expand(".k-item");
                    });

                    $("#collapseAllNodes").click(function() {
                        treeview.collapse(".k-item");
                    });

                    var append = handleTextBox(function(e) {
                            var selectedNode = treeview.select();
                            //var json = treeToJson(treeView.dataSource.view());
                            // passing a falsy value as the second append() parameter
                            // will append the new node to the root group
                            if (selectedNode.length == 0) {
                                selectedNode = null;
                            }
                             treeview.append({
                                text: "1",
                            }, selectedNode);
                            treeview.append({
                                text: "2",
                            }, selectedNode);
                        });
                    
                    function treeToJson(nodes) {
        		 	    return $.map(nodes, function(n, i) {
        		 	    	if("Item 2.2" == n.text){
        		 	    		alert(n.text);
        		 	    	}
        		 	        var result = { text: n.text, id: n.id, expanded: n.expanded, checked: n.checked };

        		 	        if (n.hasChildren){
        		 	        	 result.items = treeToJson(n.children.view());
        		 	        }
        		 	        return result;
        		 	    });
        		 	}

                    $("#appendNodeToSelected").click(append);
                    $("#appendNodeText").keypress(append);

                    // datasource actions

                    var ascending = false;

                    $("#sortDataSource")
                        .text(ascending ? "Sort ascending" : "Sort descending")
                        .click(function() {
                            treeview.dataSource.sort({
                                field: "text",
                                dir: ascending ? "asc" : "desc"
                            });

                            ascending = !ascending;

                            $(this).text(ascending ? "Sort ascending" : "Sort descending")
                        });

                    var filter = handleTextBox(function(e) {
                        var filterText = $("#filterText").val();

                        if (filterText !== "") {
                            treeview.dataSource.filter({
                                field: "text",
                                operator: "contains",
                                value: filterText
                            });
                        } else {
                            treeview.dataSource.filter({});
                        }
                    });

                    $("#filterDataSource").click(filter);
                    $("#filterText").keypress(filter);
                });
            </script>
            <style scoped>
                .box .k-textbox {
                    width: 50px;
                }

                .demo-section{
                    width: 200px;
                }
            </style>
        </div>
    
 	</body>
</html>
