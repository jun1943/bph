<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
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
	<%-- <script src="<%=basePath %>resources/js/json2.js" type='text/javascript'></script> --%>
		
	</head>
	<body>
	  	<div id="example">

    <div class="demo-section k-header">
        <div class="box-col">
            <h4>Check nodes</h4>
            <div id="treeview"></div>
        </div>
        <div class="box-col">
            <h4>Status</h4>
            <p id="result">No nodes checked.</p>
        </div>
    </div>

    <script>
        $("#treeview").kendoTreeView({
            checkboxes: {
                checkChildren: true
            },

            check: onCheck,

            dataSource: [{
                id: 1, text: "My Documents", expanded: true, spriteCssClass: "rootfolder", items: [
                    {
                        id: 2, text: "Kendo UI Project", expanded: true, spriteCssClass: "folder", items: [
                            { id: 3, text: "about.html", spriteCssClass: "html" },
                            { id: 4, text: "index.html", spriteCssClass: "html" },
                            { id: 5, text: "logo.png", spriteCssClass: "image" }
                        ]
                    },
                    {
                        id: 6, text: "New Web Site", expanded: true, spriteCssClass: "folder", items: [
                            { id: 7, text: "mockup.jpg", spriteCssClass: "image" },
                            { id: 8, text: "Research.pdf", spriteCssClass: "pdf" },
                        ]
                    },
                    {
                        id: 9, text: "Reports", expanded: true, spriteCssClass: "folder", items: [
                            { id: 10, text: "February.pdf", spriteCssClass: "pdf" },
                            { id: 11, text: "March.pdf", spriteCssClass: "pdf" },
                            { id: 12, text: "April.pdf", spriteCssClass: "pdf" }
                        ]
                    }
                ]
            }]
        });

        // function that gathers IDs of checked nodes
        function checkedNodeIds(nodes, checkedNodes) {
            for (var i = 0; i < nodes.length; i++) {
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
                treeView = $("#treeview").data("kendoTreeView"),
                message;

            checkedNodeIds(treeView.dataSource.view(), checkedNodes);

            if (checkedNodes.length > 0) {
                message = "IDs of checked nodes: " + checkedNodes.join(",");
            } else {
                message = "No nodes checked.";
            }

            $("#result").html(message);
        }
    </script>

    <style scoped>
        #treeview .k-sprite {
            background-image: url("../content/web/treeview/coloricons-sprite.png");
        }

        .rootfolder { background-position: 0 0; }
        .folder     { background-position: 0 -16px; }
        .pdf        { background-position: 0 -32px; }
        .html       { background-position: 0 -48px; }
        .image      { background-position: 0 -64px; }
        
        .box-col { min-width: 300px;}

    </style>
    
 	</body>
</html>
