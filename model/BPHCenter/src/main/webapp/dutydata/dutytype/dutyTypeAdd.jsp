<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
<head>
<title>扁平化指挥系统</title> 

<%@ include file="../../emulateIE.jsp" %>
<script type="text/javascript">
var sessionId = $("#token").val();

$(function() {

	DutyTypeAddManage.loadProperties();
	$("#cmbTaskType").kendoComboBox({
			dataValueField : "id",
			dataTextField : "text",
			panelHeight : "auto",
			dataSource : [ {
				id : 2,
				text : "社区"
			}, {
				id : 1,
				text : "巡区"
			}, {
				id : 3,
				text : "卡点"
			} ]
	});
	$("#txtDutyTypeParentName").val(window.parent.m_parentNode_pkg.parentName);
	$("#txtDutyTypeParentFullPath").val(window.parent.m_parentNode_pkg.parentFullPath);
	$("#txtDutyTypeParentId").val(window.parent.m_parentNode_pkg.parentId); 
	$("#chkUnMax").attr("checked","checked"); 
	$("#radioDisplayType1").attr("checked","checked");  
	$("#radioAttireType1").attr("checked","checked"); 
	$("#radioArmamentType1").attr("checked","checked");  
});

var bph_dutyTypeAdd_pkg={}; 
var DutyTypeAddManage= {
	isCompleted : false,
	loadProperties:function(){
		// 加载勤务类型相关属性，以下拉列表的形式呈现；
		$.ajax({
			url : "<%=basePath%>dutyTypeWeb/loadProperties.do",
			type : "POST",
			dataType : "json",
			// async:false,
			success : function(req) {
				if (req.success) {// 成功填充数据
					// var a = JSON.parse(req.rows);
					var dataSource = new kendo.data.TreeListDataSource({
					    data: req.rows
				    });
					$("#cmbProperty").kendoMultiSelect({
						dataSource: dataSource,
						dataTextField: "name",
						dataValueField: "id"
					});
				}else{
					$("body").popjs({"title":"提示","content":"获取勤务类型属性失败！"});
				}
			}
		});
	}, 
	saveDutyType:function(){ 
		DutyTypeAddManage.packageDutyType(); 
		if(!DutyTypeAddManage.isCompleted||DutyTypeAddManage.isCompleted==undefined)
		{
			return;
		}
		$.ajax({
			url : "<%=basePath%>dutyTypeWeb/saveDutyType.do?sessionId="+sessionId,
			type : "post",
			data : {"dutyType" : JSON.stringify(bph_dutyTypeAdd_pkg)},
			dataType : "json",
			success : function(req) { 
				if(req.code==200){ 
					$("body").popjs({"title":"提示","content":"新增勤务类型成功！","callback":function(){ 
							window.parent.window.parent.DutyTyepManage.onClose();
							window.parent.$("#dialog").tyWindow.close();
					}});  
				}else{
					$("body").popjs({"title":"提示","content":"新增勤务类型失败！"});
				} 
			}
		}); 
	},
	packageDutyType:function(){
		bph_dutyTypeAdd_pkg.id=0;  
		bph_dutyTypeAdd_pkg.properties = [];
		bph_dutyTypeAdd_pkg.parentId = $("#txtDutyTypeParentId").val();
		var dname = $("#txtDutyTypeName").val();
		if ($.trim(dname).length > 20) {
			$("body").popjs({"title":"提示","content":"勤务类型名称长度过长，限制长度为1-20！","callback":function(){
								$("#txtDutyTypeName").focus();
								return;
							}});    
					
				return;
		}
		var myReg = /^[^|"'<>]*$/;
		if (!myReg.test($.trim(dname))) {
			$("body").popjs({"title":"提示","content":"勤务类型名称含有非法字符！","callback":function(){
								$("#txtDutyTypeName").focus();
								return;
							}});    
					
				return;
		}
		bph_dutyTypeAdd_pkg.name = $.trim(dname);
		
		var personcount = $("#txtMaxPolice").val();
		if (!personcount || personcount == undefined) {
			bph_dutyTypeAdd_pkg.maxPolice = 0;
		} else {
			var r = /^[0-9]*[1-9][0-9]*$/;
			var value = $.trim(personcount);
			if (!r.test(value)) {
				$("body").popjs({"title":"提示","content":"人数必须为正整数！","callback":function(){
								$("#txtMaxPolice").focus();
								return;
							}});    
					
				return;
			} else {
				bph_dutyTypeAdd_pkg.maxPolice = value;
			}
		}
		bph_dutyTypeAdd_pkg.isShowname = $('input:radio[name="displayType"]:checked').val();
		var properties = $("#cmbProperty").data("kendoMultiSelect");
		var items = properties.dataItems();
		for ( var i = 0; i < items.length; i++) {
			var p = {};
			var pId = items[i].id;
			p.id = pId;
			bph_dutyTypeAdd_pkg.properties.push(p);
		}
		bph_dutyTypeAdd_pkg.assoTaskType = $("#cmbTaskType").val();
	
		bph_dutyTypeAdd_pkg.attireType = $('input:radio[name="attireType"]:checked').val();
		bph_dutyTypeAdd_pkg.armamentType = $('input:radio[name="armamentType"]:checked').val();
		bph_dutyTypeAdd_pkg.isLeaf = true;
		bph_dutyTypeAdd_pkg.isUsed = true;
		 
		DutyTypeAddManage.isCompleted = true;
	},
	changeUnMax:function () {
		if ($("#chkUnMax").prop("checked")) {
			$("#chkUnMax").attr("checked", true);
			$("#txtMaxPolice").val("");
			$("#txtMaxPolice").attr("disabled", "disabled");
		} else {
			$("#chkUnMax").attr("checked", false);
			$("#txtMaxPolice").val("");
			$("#txtMaxPolice").removeAttr("disabled");
		} 
	}
};
</script>
</head>
<body>
	<div id="vertical" style="overflow-x:hidden;">
		<div id="horizontal" style="height: 300px; width: 590px;">
			<div class="pane-content">
				<!-- 左开始 -->
				<div class="demo-section k-header">
					<h4>勤务类型基础资料</h4>
					<ul>
						<li class="ty-input">
							<label class="ty-input-label" for="txtDutyTypeParentName">上级名称:</label>
							<input type="text"  class="k-textbox" name="txtDutyTypeParentName"  disabled="disabled" required="required" id="txtDutyTypeParentName" />
						 	<input type="hidden" id="txtDutyTypeParentId"></input>  
						</li>
						<li class="ty-input">
							<label class="ty-input-label" for="txtDutyTypeParentFullPath">上级全路径:</label><input type="text" class="k-textbox" name="txtDutyTypeParentFullPath"  disabled="disabled" id="txtDutyTypeParentFullPath" required="required" />
						</li>
						<li class="ty-input">
							<label class="ty-input-label" for="txtDutyTypeName">类型名称:</label><input type="text" class="k-textbox" name="txtDutyTypeName" id="txtDutyTypeName" />
						</li>
						<li class="ty-input">
							<label class="ty-input-label" for="txtMaxPolice">人数上限:</label><input type="text" class="k-textbox" name="txtMaxPolice" id="txtMaxPolice"  disabled="disabled" />
							<input id="chkUnMax" 	type="checkbox"  onclick="DutyTypeAddManage.changeUnMax()" ></input>不限</label> 
						</li>
						<li class="ty-input">
							<label class="ty-input-label" for="cmbProperty">类型属性:</label>
						</li>
						<li class="ty-input">
							<select id="cmbProperty" style="width:400px;height:30px;"  datmultiple="multiple" a-options="editable:false"></select>
						</li>
						<li class="ty-input">
							<label class="ty-input-label" for="cmbTaskType">关联任务:</label><input  id="cmbTaskType" data-options="editable:false"  />
						</li>
						<li class="ty-input">
							<label class="ty-input-label">统计显示:</label>
							<label><input id="radioDisplayType1" name="displayType"  type="radio" value="0" ></input>人数 </label>
						    <label><input id="radioDisplayType2" name="displayType"  type="radio" value="1"	></input>名称 </label>
						</li>
						<li class="ty-input">
							<label class="ty-input-label">着装方式:</label>
							<label><input id="radioAttireType1" name="attireType"  type="radio" value="0" ></input>制服</label> 
							<label><input id="radioAttireType2" name="attireType"  type="radio" value="1" ></input>便衣</label>
						</li>
						<li class="ty-input">
							<label class="ty-input-label">着装方式:</label>
							<label><input id="radioArmamentType1" name="armamentType"  type="radio" value="0" ></input>非武装</label> 
							<label><input id="radioArmamentType2" name="armamentType"  type="radio" value="1" ></input>武装</label>
						</li> 
					</ul>
					<p style="float:left;width:100%;margin-top:10px;">
						<span id="undo" class="k-button" onclick="DutyTypeAddManage.saveDutyType()">保存</span> 
					</p>


				</div>
			</div>
		</div>
	</div>
</body> 
</html>