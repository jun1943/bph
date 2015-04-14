<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
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
  
<link rel="stylesheet" type="text/css" href="<%=path %>/Skin/Default/css/global.css"/>
<link rel="stylesheet" type="text/css" href="<%=path %>/Skin/Default/css/base.css"/>

<title>警员管理</title>



</head>

<body>
  <div class="head"><!----头部---->
    <div class="head_logo"><!----logo---->
      <div class="t1_start dis_cell"></div>
      <div class="w118 line1_mid dis_cell"></div>
      <div class="end dis_cell"></div>
      <div class="m4"><a href="#"><img src="<%=path %>/Skin/Default/images/logo_01.png" /></a></div>
      <div class="b1_start dis_cell"></div>
      <div class="w98 line1_mid dis_cell"></div>
      <div class="dis_cell"><a href="#"><img src="<%=path %>/Skin/Default/images/b1_button1.png" /></a></div>
      
      <div class="clear"></div>
      <div class="mt10"><img src="<%=path %>/Skin/Default/images/line2.png"></div>
    </div><!----logo结束---->
    
    <div id="menu" class="h68 fr"><!----菜单---->
      <div class="line1_mid"><!----一级菜单---->
        <div class="t1_start fl"></div>
        <div class="end fr"></div>
      </div>
      
      <div>
        <div class="mt16 fl"><img src="<%=path %>/Skin/Default/images/guanli_14.png"></div>
        <ul>
          <li><a href="#">信息摘要</a></li>
          <li><a href="#">接警处管理</a></li>
          <li><a href="#">巡逻防控</a></li>
          <li><a href="#">预案管理</a></li>
          <li><a href="#">视频防控</a></li>
          <li><a href="#">警令系统</a></li>
          <li><a href="#">勤务报备</a></li>
          <li><a href="#">基础管理</a></li>
          <li><a href="#">运维管理</a></li>
          <li><a href="#">系统设置</a></li>
        </ul>
        <div class="h26 fr">
          <div class="dis_cell">
             <span class="mr5">授权登录</span>
             <span>锁定倒计时：</span>
          </div>
          <a class="button1 dis_cell" href="#">锁定</a>
          <a class="button1 dis_cell" href="#">退出</a>
        </div>
      </div><!----一级菜单结束---->
      
      <div class="clear"></div><!----二级菜单---->
      <div class="line1_mid">
        <div class="b1_end fr"></div>
      </div>
      
      <div class="clear"></div>
      
      <div class="mt16 fl"><img src="<%=path %>/Skin/Default/images/mark1.png"></div>
      <div class="h30">
        <ul class="mt5">
          <li><a href="#">警员管理</a></li>
          <li><a href="#">警车管理</a></li>
          <li><a href="#">武器管理</a></li>
          <li><a href="#">GPS设备管理</a></li>
          <li><a href="#">卡点管理</a></li>
        </ul>
        
        <div class="fr"><a href="#"><img src="<%=path %>/Skin/Default/images/help.png"></a></div>
      </div>

      <div class="b2_mid">
        <div class="fl"><img src="<%=path %>/Skin/Default/images/b2_left.png"></div>
        <div class="fr end"></div>
      </div><!----二级菜单结束---->
      
    </div> <!----菜单结束---->
  </div><!----头部结束---->
  
  <div class="clear"></div>
  
  <div class="mid"><!----中部---->
    <div class="mid_tree mt10 mr20"><!----中部管理树---->
      <div class="line1_mid">
        <div class="t1_start fl"></div>
        <div class="end fr"></div>
      </div>
      
      <div class="fl w172">
        <div class="mr10 mt8 fl"><img src="<%=path %>/Skin/Default/images/guanli_search.png"></div>
        <div class="search_result fl">1500</div>
        <div class="fr mt8"><a href="#"><img src="<%=path %>/Skin/Default/images/button3.png"></a></div>
        <div class="clear"></div>
        <div>
          <input type="text" class="search_input mr5 fl">
          <a href="#" class="search_button dis_cell"></a>
        </div>
      </div>
      
      <div class="fr mt8">
        <div><a href="#"><img src="<%=path %>/Skin/Default/images/button4.png"></a></div>
        <div><img src="<%=path %>/Skin/Default/images/guanli_53.png"></div>
      </div>
      
      <div class="clear"></div>
      <div class="tree_box mt10"><!----机构树---->
        <img src="<%=path %>/Skin/Default/images/guanli_62.png">
      </div><!----机构树结束---->
      <div><img src="<%=path %>/Skin/Default/images/line3.png"></div>
      <div class="mt16"><img src="<%=path %>/Skin/Default/images/line2.png"></div>
    </div><!----中部管理树结束---->
    
    <sitemesh:write property='body'/>
    
  </div><!----中部结束---->
  <script type="text/javascript">
    var i=document.getElementById("using");
    var j=document.getElementById("menu");

    var k=function(){
      j.style.width=document.body.clientWidth-220;
	  i.style.width=document.body.clientWidth-230;
    }
    k();
    window.onresize=k;
  </script>
</body>

</html>
