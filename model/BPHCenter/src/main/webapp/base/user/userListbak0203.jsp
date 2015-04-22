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
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport' />
	
<link rel="stylesheet" type="text/css" href="<%=basePath %>Skin/Default/css/light-theme.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>Skin/Default/css/bootstrap/bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>Skin/Default/css/bootstrap/bootstrap.css">
<!-- / kendo -->
<link href="<%=basePath %>resources/css/web/kendo.common.min.css" media='all' rel='stylesheet' type='text/css' />
<link href="<%=basePath %>resources/css/web/kendo.default.min.css" media='all' rel='stylesheet' type='text/css' />
<link href="<%=basePath %>resources/css/dataviz/kendo.dataviz.min.css" media='all' rel='stylesheet' type='text/css' />
<link href="<%=basePath %>resources/css/dataviz/kendo.dataviz.default.min.css" media='all' rel='stylesheet' type='text/css' />		
<script src="<%=basePath %>resources/js/jquery.min.js" type='text/javascript'></script>
<script src="<%=basePath %>resources/js/kendo.all.min.js" type='text/javascript'></script>

</head>

<body>
  <div id="wrapper">
    <div id='main-nav-bg'></div>
    <nav class="" id="main-nav">
      <div class='navigation'> 
        <%@ include file="../../left.jsp" %>
      </div>
    </nav>
    
     <section id='content'>
       <div class="container-fluid">
         <div id="content-wrapper" class="row-fluid">
           <div class='span12'>
           
             <div class="row-fluid"><!----功能模块---->
             <%@ include file="userListInfo.jsp" %> 
             <%@ include file="userAdd.jsp" %>            
             </div><!----功能模块结束---->
             
           </div>
         </div>
       </div>
     </section>
   
  </div>           

</body>
</html>

