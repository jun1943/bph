<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Map"%>
<%@ page import="com.tianyi.bph.common.Pager"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<META NAME="Generator" CONTENT="EditPlus">
  <META NAME="Author" CONTENT="">
  <META NAME="Keywords" CONTENT="">
  <META NAME="Description" CONTENT="">
  
<link rel="stylesheet" type="text/css" href="<%=basePath %>Skin/Default/css/global.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>Skin/Default/css/base.css"/>
<script type="text/javascript" src="<%=basePath %>JS/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%=basePath %>JS/jquery-1.11.1.min.js"></script>
<link href="<%=basePath%>JS/ztree/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="<%=basePath%>JS/ztree/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>JS/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=basePath%>JS/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>JS/ztree/jquery.ztree.excheck-3.5.js"></script>
<title>用户管理</title>
<script type="text/javascript">
$(document).ready(function(){
	var conductFlag= false;
	var policeFlag =false;
	var baseFlag =false;
	
	var funList=<%=session.getAttribute("funList")%>;
	var baseList=<%=session.getAttribute("baseArray")%>;
	var conductList=<%=session.getAttribute("conductArray")%>;
	var policeList=<%=session.getAttribute("policeArray")%>;
	
	for (var i = 0; i < funList.length; i++) {
		if(conductList.indexOf(funList[i]) != -1){//指挥调度
			conductFlag=true;
		}
		if(policeList.indexOf(funList[i]) != -1){//警情处理
			policeFlag=true;
		}
		if(baseList.indexOf(funList[i]) != -1){//基础数据
			baseFlag=true;
		}
	}
	if(conductFlag){
		$("#navMenu").append("<li><a href=''#' onclick='Show_Hidden(1)'>指挥调度</a></li>");
	}
	if(policeFlag){
		$("#navMenu").append("<li><a href=''#' onclick='Show_Hidden(2)'>警情处置</a></li>");
	}
	if(baseFlag){
		$("#navMenu").append("<li><a href=''#' onclick='Show_Hidden(5)'>基础数据</a></li>");
		for (var i = 0; i < funList.length; i++) {
			if(funList[i]=='9'){
				$("#subMenu_5").append("<li><a href='#'>人员</a></li>");
			}
			if(funList[i]=='10'){
				$("#subMenu_5").append("<li><a href='#'>车辆</a></li>");
			}
			if(funList[i]=='13'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/web/cardPoint/queryCardPointPageList.action'>卡点</a></li>");
			}
			if(funList[i]=='14'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/web/organx/gotoOrganList.action'>机构</a></li>");
			}
			if(funList[i]=='15'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/admin/gotoUserList.action'>账号权限</a></li>");
			}
			if(funList[i]=='16'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/role/gotoRoleList.action'>角色权限</a></li>");
			}
		}
		
	}
	
	
	
});
</script>
</head>

<body>
  <div class="head"><!----头部---->
    <div class="head-logo"><!----logo---->
      <div class="line1-mid">
        <div class="t1-start fl"></div>
        <div class="end fr"></div>
      </div>
      <div class="m4 ml40"><a href="#"><img src="<%=path %>/Skin/Default/images/logo-01.png" /></a></div>
      <div class="line1-mid">
        <div class="b2-start fl"></div>
        <a href="#" class=" b2-end fr"></a>
      </div>
      
      <div class="clear"></div>
      <div class="mt10 line2"></div>
    </div><!----logo结束---->
    
    <div id="menu" class="h68"><!----菜单---->
      <div class="line1-mid"><!----一级菜单---->
        <div class="t1-start fl"></div>
        <div class="end fr"></div>
      </div>
      
      <div>
        <div class="mt16 fl"><img src="<%=path %>/Skin/Default/images/guanli-14.png"></div>
        <ul id="navMenu">
          <!-- <li><a href="#" onclick="Show_Hidden(1)">指挥调度</a></li>
          <li><a href="#" onclick="Show_Hidden(2)">警情处置</a></li> -->
          <li><a href="#" onclick="Show_Hidden(3)">研判分析</a></li>
          <li><a href="#" onclick="Show_Hidden(4)">勤务管理</a></li>
         <!--  <li><a href="#" onclick="Show_Hidden(5)">基础数据</a></li> -->
        </ul>
        <div class="h26 fr">
             <a class="button1" href="<%=path %>/admin/logout.do">退出</a>
             <a class="button1" href="#"></a>
             <div class="lh26 fr mr20 font-size12"></div>
             <div class="lh26 fr mr20 font-size12">${sessionScope.SESSIN_USERNAME }  授权登录</div>
        </div>
      </div><!----一级菜单结束---->
      
      <div class="clear"></div><!----二级菜单---->
      <div class="line1-mid">
        <div class="b1-end fr"></div>
      </div>
      
      <div class="clear"></div>
      
      <div class="mt16 fl"><img src="<%=path %>/Skin/Default/images/mark1.png"></div>
      <div class="h30" id="subNavMenu">
        <!-- <ul class="lv2 mt5 ml10" id="subMenu_1" style="display:none;">
          <li><a href="#">指挥调度</a></li>
        </ul>
        <ul class="lv2 mt5 ml10" id="subMenu_2" style="display:none;">
          <li><a href="#">警情处置</a></li>
        </ul>
        <ul class="lv2 mt5 ml10" id="subMenu_3" style="display:none;">
          <li><a href="#">研判分析</a></li>
        </ul>
        <ul class="lv2 mt5 ml10" id="subMenu_4" style="display:none;">
          <li><a href="#">勤务管理</a></li>
        </ul> -->
        <ul class="lv2 mt5 ml10" id="subMenu_5" style="display:block;">
          <%-- <li><a href="#">人员</a></li>
          <li><a href="#">车辆</a></li>
          <li><a href="#">武器</a></li>
          <li><a href="#">定位设备</a></li>
          <li><a href="#">图标</a></li>
          <li><a href="<%=path %>/web/cardPoint/queryCardPointPageList.action">卡点</a></li>
          <li><a href="#">视频</a></li>
          <li><a href="#">卡口</a></li>
          <li><a href="<%=path %>/web/organx/gotoOrganList.action">机构</a></li>
          <li><a href="<%=path %>/admin/gotoUserList.action">帐号权限</a></li>
          <li><a href="<%=path %>/role/gotoRoleList.action">角色权限</a></li> --%>
        </ul>
        
        <div class="fr"><a href="#"><img src="<%=path %>/Skin/Default/images/help.png"></a></div>
      </div>

      <div class="b2-mid">
        <div class="fl"><img src="<%=path %>/Skin/Default/images/b2-left.png"></div>
        <div class="fr end"></div>
      </div><!----二级菜单结束---->
      
    </div> <!----菜单结束---->
  </div><!----头部结束---->
  
  <div class="clear"></div>
  
  <sitemesh:write property='body'/>

<div class="clear"></div>
  
  <div class="footer"><!----下部---->
    <div class="line1-mid">
      <div class="t1-start fl"></div>
      <div class="end fr"></div>
    </div>
    <div id="footer" class="h26">
      <div class="lh26 fr font-size12">2014/7/19 23:23</div>
      <div class=" icon mr5" ><img src="<%=basePath %>Skin/Default/images/b-6.png"></div>
      <div class="icon mr20"><img src="<%=basePath %>Skin/Default/images/b-5.png"></div>
      <div class="icon mr20"><img src="<%=basePath %>Skin/Default/images/b-4.png"></div>
      <div class="icon mr20"><img src="<%=basePath %>Skin/Default/images/b-3.png"></div>
      <div class="icon mr20"><img src="<%=basePath %>Skin/Default/images/b-2.png"></div>
      <div class="icon mr20"><img src="<%=basePath %>Skin/Default/images/b-1.png"></div>
    </div>
    <div class="line1-mid">
      <div class=" b1-start fl"></div>
      <div class=" b1-end fr"></div>
    </div>
  </div><!----下部结束---->
  <script type="text/javascript">
    var i=document.getElementById("using");
    var j=document.getElementById("menu");

    var k=function(){
      j.style.width=document.body.clientWidth-290;
	  i.style.width=document.body.clientWidth-290;
	  
    }
    k();
    window.onresize=k;
    
    /**导航条，导航展示*/ 
	function Show_Hidden(num){
		for(var i=1;i<6;i++){
		document.getElementById('subMenu_'+i).style.display = 'none';
		}
		document.getElementById('subMenu_'+num).style.display = 'block';
		}
  </script>
</body>

</html>

