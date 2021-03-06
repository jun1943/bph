<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=basePath %>JS/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="<%=basePath %>JS/jquery-1.11.1.min.js"></script>
  
  <style type="text/css">
        .pop-box {   
            z-index: 9999; /*这个数值要足够大，才能够显示在最上层*/  
            margin-bottom: 3px;   
            display: none;   
            position: absolute;   
            background: #FFF;   
            border:solid 1px #6e8bde;   
        }   
          
        .pop-box h4 {   
            color: #FFF;   
            cursor:default;   
            height: 18px;   
            font-size: 14px;   
            font-weight:bold;   
            text-align: left;   
            padding-left: 8px;   
            padding-top: 4px;   
            padding-bottom: 2px;   
            background: url("../images/header_bg.gif") repeat-x 0 0;   
        }   
          
        .pop-box-body {   
            clear: both;   
            margin: 4px;   
            padding: 2px;   
        } 
        
        /* 弹出框的样式 */
        .mask {   
            color:#C7EDCC;
            background-color:#C7EDCC;
            position:absolute;
            top:0px;
            left:0px;
            filter: Alpha(Opacity=60);
        } 
    </style>
    
    <script language=javascript type="text/javascript">
    function popupDiv(div_id) {   
        var div_obj = $("#"+div_id);  
        var windowWidth = document.body.clientWidth;       
        var windowHeight = document.body.clientHeight;  
        var popupHeight = div_obj.height();       
        var popupWidth = div_obj.width();    
        //添加并显示遮罩层   
        $("<div id='mask'></div>").addClass("mask")   
                                  .width(windowWidth + document.body.scrollWidth)   
                                  .height(windowHeight + document.body.scrollHeight)   
                                  /* .click(function() {hideDiv(div_id); })  */  
                                  .appendTo("body")   
                                  .fadeIn(200);   
        div_obj.css({"position": "absolute"})   
               .animate({left: windowWidth/2-popupWidth/2,    
                         top: windowHeight/2-popupHeight/2, opacity: "show" }, "slow");   
                        
    }   
      
    function hideDiv(div_id) {   
        $("#mask").remove();   
        $("#" + div_id).animate({left: 0, top: 0, opacity: "hide" }, "slow");   
    }  
   </script>
  </head>
  
  <body>
     <form id="form1" runat="server">
        <div id='pop-div' style="width: 500px;height:300px;" class="pop-box">  
            <h4>标题位置</h4>  
            <div class="pop-box-body" >  
                <p>  
                    	正文内容   
                </p>  
                <input id=btnClose type=button onclick="hideDiv('pop-div');" value="关闭"/>
            </div>  
        </div>
    <input type=button id=btnTest  value='test' onclick="popupDiv('pop-div');"/>
    </form>
  </body>
</html>
