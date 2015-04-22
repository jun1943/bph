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
	<div id="wrapper">
	    <div id='main-nav-bg'></div><!--机构树 -->
	    <nav class="" id="main-nav">
	      <div class='navigation'> 
	        <%@ include file="../../left.jsp" %>
	      </div>
	    </nav><!--机构树 结束-->
	    
	    <section id='content'>
	       <div class="container-fluid">
	         <div id="content-wrapper" class="row-fluid">
	           <div class='span12'>
	           
	             <div class="row-fluid"><!----功能模块---->
	               <div class="set">
	                 <h1>卡点管理</h1>
	                 <div class="clear box">
	                  <%@ include file="cardPointSearch.jsp" %>
	                 </div>
	               </div>
	             </div><!----功能模块结束---->
	           
	             <div class="row-fluid"><!----信息显示区---->
	             	<%@ include file="cardPointListInfo.jsp" %> 
	             </div><!----信息显示区结束---->
	           </div>
	         </div>
	       </div>
     	</section>
    </div>
    
</body>
</html>
