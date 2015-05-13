<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<title>扁平化指挥系统安装向导</title>
		<!DOCTYPE html>
		<link rel="stylesheet" href="<%=basePath%>/install/css/install.css" type="text/css">
		<link rel="stylesheet" href="<%=basePath%>/install/css/buttons.css" type="text/css">
		
		<script type="text/javascript" charset="utf-8" src="<%=basePath%>/install/js/get.js"></script>
		<script type="text/javascript" charset="utf-8" src="<%=basePath%>/install/js/jquery-1.10.1.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="<%=basePath%>/install/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" charset="utf-8" src="<%=basePath%>/install/js/mask.js"></script>
	</head>
	<body class="wp-core-ui">
		<h1 id="logo"><a href="javascript:void()">扁平化LOGO</a></h1>
		<form method="post" action="step.do">
			<input type="hidden" name="step" value="install"/>
			<p>请认真填写配置信息！</p>
			<table class="form-table">
				<tbody>
				<tr>
				    <td>
				        <select id="selectId" onchange="select();">
						  <option value ="">请选择数据库</option>
						  <option id="Oracle" value ="Oracle">Oracle</option>
						  <option id="MySQL" value="MySQL">MySQL</option>
						</select>
				    </td>
				</tr>
				</tbody>
			</table>

			<table class="form-table" style="display: none;" id="tableId2">
				<tbody>	
				<input type="hidden" name="mysqlId" id="mysqlId" value="" />
				<tr>
					<th scope="row"><label for="dbhost">MYSQL数据库地址:</label></th>
					<td><input name="dbhost1" id="dbhost1" type="text" size="25" value="25.30.9.182"></td>
					<td>数据库地址，如果是当前程序所在服务器，请填写：<code>127.0.0.1</code>。</td>
				</tr>
				<tr>
					<th scope="row"><label for="prefix">数据库端口:</label></th>
					<td><input name="dbport1" id="dbport1" type="text" value="3306" size="25"></td>
					<td>数据库端口, 默认3306</td>
				</tr>
				<tr>
					<th scope="row"><label for="dbname">数据库名称:</label></th>
					<td><input name="dbname1" id="dbname1" type="text" size="25" value="bph"></td>
					<td>数据库名称</td>
				</tr>
				<tr>
					<th scope="row"><label for="uname">数据库登录用户:</label></th>
					<td><input name="uname1" id="uname1" type="text" size="25" value="root"></td>
					<td>数据库登录用户，请填写：<code>root</code>。</td>
				</tr>
				<tr>
					<th scope="row"><label for="pwd">数据库登录密码:</label></th>
					<td><input name="pwd1" id="pwd1" type="password" size="25" value="123456"></td>
					<td>数据库登录密码</td>
				</tr>
				
				<tr>
					<th scope="row"><label for="routeServerIP">系统管理模块:</label></th>
					<td><input name=systemManager id="systemManager" type="text"
						size="25" value="200"></td>
					<td>系统管理模块</td>
				</tr>
				<tr>
					<th scope="row"><label for="runModel">服务部署模式:</label></th>
					<td colspan="2">
						<input id='runModel1' name='runModel1' type="checkBox" value="run" />建议在实际的生产环境开启，测试或开发环境不要选择；
					</td>
					<td></td>
				</tr>
				
			</tbody></table>
			
			
			
				<p class="step">
					<input id="bt_install" type="button" value="安装" class="button button-large">
				</p>
		</form>
		<script  type="text/javascript">
			$(document).ready(function(){
				
				$("select[name='startApp']").change(function(event){
					var sel=$(event.target).val();
					if("pubPlatformRest"==sel){
						$("tr[for='center']").show();
						$("tr[for='route']").hide();
					}else{
						$("tr[for='center']").hide();
						$("tr[for='route']").show();
					}
				})
				
				 $("tr[for='route']").hide();
				
				
				
				/** 启动安装配置 */
				$("#bt_install").click(function() {
					var selectId = $.trim($("#selectId").val());
					if (selectId==null || selectId.length == 0) {
						alert("请选择数据库！");
						return;
					}
					
					$(document).mask("<p id='msg'>欢迎使用天翼监控系统，中心服务正在启动，请稍后。。。。。。</p><p id='iocn' class='loading'></p>");
					
					var setting={};
					$("input").each(function(i,el){
               			setting[$(el).attr('name')]=$(el).val();
               		});
					
					$.ajax({
		                url: "<%=basePath%>step.do?step=install",//要访问的后台地址
		                data:setting,		
		               	complete :function(rsp){
		               		$(document).unmask();
		               		rsp.responseText.replace(/&quot;/ig,'"')
		               		var rst=$.parseJSON(rsp.responseText);
		               		 if(rst.success){
		               			window.location="<%=basePath%>index.jsp";
		               		}else{
		               			alert("系统启动失败");
		               		}
			 	       	}
		            });
					
				});
			});
			
			
			function select() {
				var param = $("#selectId").val();
				if (param=="Oracle") {
					var selectId = $.trim($("#Oracle").val());
					$("#oracleId").val(selectId);
					$("#mysqlId").val('');
					$("#tableId").show();
					$("#tableId2").hide();
				} 
				if (param=="MySQL") {
					var selectId = $.trim($("#MySQL").val());
					$("#oracleId").val('');
					$("#mysqlId").val(selectId);
					$("#tableId2").show();
					$("#tableId").hide();
				}
				
			}
		
		</script>
	</body>
</html>
