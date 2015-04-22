<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<title>用户信息编辑</title>

</head>

<body> 
    <div id="using" class="fl ml20 mt8"><!----应用界面---->
	
      <div class="mt5">
        <div class="fl mt5 mr5"><img src="Skin/Default/images/mark3.png"></div>
        <h2>添加用户</h2>
      </div>
      <hr class="hr mt8">
      <div class="mid-form auto mt10"><!----表单---->
		<form id="userAddForm" action="<%=path %>/admin/userAdd.action?operType=1" method="post">
        <table class="form-table">
        <tr>
            <td>所属机构：</td>
            <td>${organ.name}</td>
          </tr>
          <tr>
            <td>登录名：</td>
            <td>
              <table class="text-table">
                <tr>
                  <td class=" text-left"></td>
                  <td><input type="text" class="form-control w258 text" placeholder="等待输入..." value="${user.loginName}" id="loginName" name="loginName"></td>
                  <td class="text-right"></td>
                </tr>
              </table>
            </td>
          </tr>
           <tr>
            <td>用户名：</td>
            <td>
              <table class="text-table">
                <tr>
                  <td class=" text-left"></td>
                  <td><input type="text" class="form-control w258 text" placeholder="等待输入..." value="${user.userName}" id="userName" name="userName"></td>
                  <td class="text-right"></td>
                </tr>
              </table>
            </td>
          </tr>
          <c:if test="${user.userId==null}">
            <td>密码：</td>
            <td>
              <table class="text-table">
                <tr>
                  <td class=" text-left"></td>
                  <td>
                  <input type="hidden"value="${organId}" id="orgId" name="orgId">
                  <input type="text" class="form-control w258 text" placeholder="等待输入..." value="${user.password}" id="password" name="password"></td>
                  <td class="text-right"></td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>跨机构选择：</td>
            <td><a href="#" onclick="queryOrgan()">选择</a></td>
          </tr>
		</c:if>
		<tr>
            <td>角色选择：</td>
            <td>
               <table class="text-table">
               <c:forEach var="item" items="${roleList}">
                <tr>
                  <td>
                  <input type="checkbox" id="rolesId" name="rolesId" value="${item.id}"/>
                ${item.name}
                  </td>
                </tr>
                </c:forEach>
              </table>
            </td>
          </tr>
          <tr>
            <td>机构备注：</td>
            <td>
               <textarea class=" textarea w640 h260 mt12" id="note" name="note"></textarea>
            </td>
          </tr>
        </table>
        <hr class="hr mt20">
        <div>
          <a href="#" onclick="save()" class="button-red auto mt40">确认添加</a>
        </div>
      </div>
      </form>
      <!----表单结束---->
      <hr class="hr mt10">
    </div>
    
	</div><!----应用界面结束---->
	
	<script type="text/javascript">
	function save(){		
		var organId = $("#orgId").val();
		if($("#userName").val()==""){
			alert("请输入用户名");
			return false;
		}  
		if($("#loginName").val()==""){
			alert("请输入登录名");
			return false;
		}
		if($("#password").val()==""){
			alert("请输入密码");
			return false;
		}
		var r = document.getElementsByName("rolesId");
		var rolesId = "";
		   for (i= 0 ;i < r.length; i++){
		      if(r[i].checked == true){
				 if(rolesId == ""){
					 rolesId = r[i].value;
				 }else{
					 rolesId = rolesId + "," + r[i].value;
				 }
			  }
		  }
		$.ajax({
  			url:"<%=basePath%>admin/userAdd.do",
  			type:"post",
  			dataType:"json",
  			data:{
  				orgId:$("#orgId").val(),
  				userName:$("#userName").val(),	
  				loginName:$("#loginName").val(),
  				password:$("#password").val(),
  				rolesId:rolesId,
  				note:$("#note").val()
  			},
	  		 success:function(msg){
	  			if(msg.code==200){
	  				alert(msg.description);
	  				window.location.href="<%=basePath%>admin/gotoUserList.action?organId="+organId;
	  			}else{
	  				alert(msg.description);
	  			}
	  		}
  		});
  	}
	</script>
</body>

</html>
