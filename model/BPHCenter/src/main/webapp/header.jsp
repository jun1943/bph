<%@ page language="java" pageEncoding="utf-8"%>

<script type="text/javascript">
var conductFlag= false;
var baseFlag =false;
var dutyFlag=false;
var reportGroupFlag=false;
var num=${num};

var funList=<%=session.getAttribute("funList")%>;
 var baseList=<%=session.getAttribute("baseArray")%>;
var conductList=<%=session.getAttribute("conductArray")%>;
var dutyList=<%=session.getAttribute("dutyArray")%>;
var reportGroupList=<%=session.getAttribute("dutyReportGroup")%>;

$(document).ready(function(){
	/* 解决ie js 数组不支持indexOf 方法 */
	if (!conductList.indexOf)
	{
		conductList.indexOf = function(elt /*, from*/)
	  {
	    var len = this.length >>> 0;
	    var from = Number(arguments[1]) || 0;
	    from = (from < 0)
	         ? Math.ceil(from)
	         : Math.floor(from);
	    if (from < 0)
	      from += len;
	    for (; from < len; from++)
	    {
	      if (from in this &&
	          this[from] === elt)
	        return from;
	    }
	    return -1;
	  };
	}
	if (!reportGroupList.indexOf)
	{
		reportGroupList.indexOf = function(elt /*, from*/)
	  {
	    var len = this.length >>> 0;
	    var from = Number(arguments[1]) || 0;
	    from = (from < 0)
	         ? Math.ceil(from)
	         : Math.floor(from);
	    if (from < 0)
	      from += len;
	    for (; from < len; from++)
	    {
	      if (from in this &&
	          this[from] === elt)
	        return from;
	    }
	    return -1;
	  };
	}
	if (!dutyList.indexOf)
	{
		dutyList.indexOf = function(elt /*, from*/)
	  {
	    var len = this.length >>> 0;
	    var from = Number(arguments[1]) || 0;
	    from = (from < 0)
	         ? Math.ceil(from)
	         : Math.floor(from);
	    if (from < 0)
	      from += len;
	    for (; from < len; from++)
	    {
	      if (from in this &&
	          this[from] === elt)
	        return from;
	    }
	    return -1;
	  };
	}
	if (!baseList.indexOf)
	{
		baseList.indexOf = function(elt /*, from*/)
	  {
	    var len = this.length >>> 0;
	    var from = Number(arguments[1]) || 0;
	    from = (from < 0)
	         ? Math.ceil(from)
	         : Math.floor(from);
	    if (from < 0)
	      from += len;
	    for (; from < len; from++)
	    {
	      if (from in this &&
	          this[from] === elt)
	        return from;
	    }
	    return -1;
	  };
	}
	
	for (var i = 0; i < funList.length; i++) {
		if(conductList.indexOf(funList[i]) != -1){//系统管理
			conductFlag=true;
		}else if(baseList.indexOf(funList[i]) != -1){//基础数据
			baseFlag=true;
		}else if(dutyList.indexOf(funList[i]) != -1){//勤务报备
			dutyFlag=true;
		}else if(reportGroupList.indexOf(funList[i]) != -1){
			reportGroupFlag=true;
		}
	}
	if(conductFlag){
		$("#navMenu").append("<li><a href='javaScript:void(0)' onclick='show_hide(100)'>系统管理</a></li>");
	}
	if(baseFlag){
		$("#navMenu").append("<li><a href='javaScript:void(0)' onclick='show_hide(200)'>基础数据</a></li>");
	}
	if(dutyFlag){
		$("#navMenu").append("<li><a href='javaScript:void(0)' onclick='show_hide(300)'>勤务报备</a></li>");
	}
	if(reportGroupFlag){
		$("#navMenu").append("<li><a href='javaScript:void(0)' onclick='show_hide(600)'>报备分组</a></li>");
	}
	show_hide(num);//初始加载基础数据
});

function show_hide(type){
	if(type=='200'){
		num=200;
		$("#subMenu_5 li").remove();
		for (var i = 0; i < funList.length; i++) {
			if(funList[i]=='200001'){
				$("#subMenu_5").append("<li><a href='<%=path %>/policeWeb/gotoPoliceList.action'>警员管理</a></li>");
			}else if(funList[i]=='200002'){
				$("#subMenu_5").append("<li><a href='<%=path %>/vehicleWeb/gotoVehicleList.action'>警车管理</a></li>");
			}else if(funList[i]=='200003'){
				$("#subMenu_5").append("<li><a href='<%=path %>/weaponWeb/gotoWeaponList.action'>武器管理</a></li>");
			}else if(funList[i]=='200004'){
				$("#subMenu_5").append("<li><a href='<%=path %>/gpsWeb/gotoGpsList.action'>设备管理</a></li>");
			}else if(funList[i]=='200011'){
				$("#subMenu_5").append("<li><a href='<%=path %>/iconsWeb/gotoIconsList.action'>图标管理</a></li>");
			}else if(funList[i]=='200005'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/web/cardPoint/queryCardPointPageList.action'>卡点管理</a></li>");
			}else if(funList[i]=='200010'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/web/GBPlatForm/toGBPlatForm.action'>视频点位</a></li>");
			}
		}
	}else if(type=='100'){
		num=100;
		$("#subMenu_5 li").remove();
		 for (var i = 0; i < funList.length; i++) {
			if(funList[i]=='100001'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/web/organx/gotoOrganList.action'>机构管理</a></li>");
			}else if(funList[i]=='100002'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/admin/gotoUserList.action'>用户管理</a></li>");
			}else if(funList[i]=='100003'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/role/gotoRoleList.action'>角色管理</a></li>");
			}
		}
	}else if(type=='500'){
		num=500;
		$("#subMenu_5 li").remove();
		$("#subMenu_5").append("<li>"+
		"<a href='<%=path %>/serviceSet/gotoServiceSetList.action'>配置管理</a></li>");
		$("#subMenu_5").append("<li>"+
		"<a href='<%=path %>/log/gotoLogList.action'>日志管理</a></li>");
	}else if(type=='300'){
		num=300;
		$("#subMenu_5 li").remove();		
		 for (var i = 0; i < funList.length; i++) {
			if(funList[i]=='300001'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/dutyTypeWeb/gotoDutyTypeList.action'>勤务类型管理</a></li>");
			}else if(funList[i]=='300002'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/dutyReportWeb/gotoDutyReport.action'>勤务综合统计</a></li>");
			}else if(funList[i]=='300003'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/dutyRouteWeb/gotoDutyCalendar.action'>勤务报备日程</a></li>");
			}
		}
	}else if(type=='600'){
		num=600;
		$("#subMenu_5 li").remove();		
		 for (var i = 0; i < funList.length; i++) {
			if(funList[i]=='600001'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/dutyGroupRouteWeb/gotoPoliceGroup.action'>警员分组</a></li>");
			}else if(funList[i]=='600002'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/dutyGroupRouteWeb/gotoVehicleGroup.action'>警车分组</a></li>");
			}else if(funList[i]=='600003'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/dutyGroupRouteWeb/gotoGpsGroup.action'>GPS分组</a></li>");
			}else if(funList[i]=='600004'){
				$("#subMenu_5").append("<li>"+
				"<a href='<%=path %>/dutyGroupRouteWeb/gotoWeaponGroup.action'>武器分组</a></li>");
			}
		}
	}
}

/**
 * 修改密码界面 跳转
 */
function gotoUpdatePassword(){
	var organId = $.trim($("#organId").val());
	var sessionId = $.trim($("#token").val());
	$("#mydialog").tyWindow({
		width: "660px",
		height: "590px",
	    title: "帐号管理",
	    position: {
	        top: "100px"
	      },
		content: "<%=path %>/admin/gotoUpdatePassword.do?userId="+${User.userId}+"&random="+Math.random(),
		iframe : true
		});
	}
</script>
<div id="mydialog"></div>
<div class="navbar">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class='brand head-logo' href='#'></a>
          <div class="line1-mid">
            <div class="t1-start"></div>
            <div class="end"></div>
          </div>
          <div>
            <div class="lv1"></div>
            <ul class="nav pull-left" id="navMenu"><!----一级菜单---->
            	<li><a href='javaScript:void(0)' onclick="show_hide(500)">配置管理</a></li>
            </ul><!----一级菜单结束---->
            <ul class='nav pull-right'><!----用户信息---->
              <li><div class="box">${sessionScope.SESSIN_USERNAME }</div></li>
              <li><div class="box">授权登录</div></li>
              <li><a href="javascript: gotoUpdatePassword();">修改密码</a></li>
              <li><a href="<%=path %>/admin/logout.do">退出</a></li>
            </ul><!----用户信息结束---->
          </div>
          <div class="line1-mid clear">
            <div class="line6"></div>
            <div class="b1-end"></div>
          </div>
          <div class="line2 brand"></div>
          
          <ul class="lv2 nav pull-left" id="subMenu_5">
         	<!-- 二级菜单集合 -->
          </ul>
          
          <ul class="nav pull-right">帮助按钮</ul>
        </div>
        <div class="b2-mid">
          <div class="b2-left"></div>
          <div class="end"></div>
        </div>
      </div>
    </div>
    
