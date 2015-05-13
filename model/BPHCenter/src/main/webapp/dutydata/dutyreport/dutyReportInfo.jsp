<%@ page language="java" pageEncoding="UTF-8"%>

<script>
	var sessionId = $("#token").val(); 
	
	$(function() {
		//$("#dutyTypeTreeList").empty();
		reportManage.initCtl();
		reportManage.loadBaseData();
	});
	
	function loadData(){
		reportManage.loadReport();
		
	}
	
	var reportManage={
		initCtl:function(){
			$("#dteBeginDate").kendoDatePicker({
    			value: new Date()
			});
			
			$("#spnBeginTime").kendoTimePicker();
			var spnBeginTime = $("#spnBeginTime").data("kendoTimePicker");
			spnBeginTime.value("0:00");
			
			$("#spnEndTime").kendoTimePicker();
			var spnEndTime = $("#spnEndTime").data("kendoTimePicker");
			spnEndTime.value("24:00");
			
			
			$('#tlReport').kendoTreeList({
				columns:[
					{title : '机构树',	field : 'orgShortName',align : 'left',width : 120,expandable:true},
					{title : '值班领导',	field : 'leaderNames',align : 'left',width : 80},
					{title : '值班主任',	field : 'directorName',align : 'left',width : 80},
					{title : '警力',	field : 'policeCount',align : 'right',width : 80},
					{title : '警车',	field : 'vehicleCount',align : 'right',width : 80},
					{title : '枪支',	field : 'weaponCount',align : 'right',width : 80},
					{title : '社区',	field : 'communityCount',align : 'right',width : 80},
					{title : '巡区',	field : 'patrolAreaCount',align : 'right',width : 80},
					{title : '卡点',	field : 'bayonetCount',align : 'right',width : 80}
				]
			});
			
		},
		loadBaseData :function(){
			//var dutyProperty=$("#dutyProperty").data("kendoComboBox");
			$.ajax({
				url : "<%=basePath%>dutyWeb/getdutyProperty.do?sessionId="+sessionId,
				type : "POST",
				dataType : "json",
				// async : false,
				success : function(req) {
					var ds=new  kendo.data.DataSource({
						data:req
					});
					
					$("#dutyProperty").kendoComboBox({
						dataTextField: "name",
		  				dataValueField: "id",
		  				dataSource : ds
		             });
				}
			});
		
			$.ajax({
				url : "<%=basePath%>policeWeb/getPoliceType.do?sessionId="+sessionId,
				type : "POST",
				dataType : "json",
				// async : false,
				success : function(req) {
					var ds=new  kendo.data.DataSource({
						data:req
					});
					
					$("#cmbpoliceType").kendoComboBox({
						dataTextField: "name",
		  				dataValueField: "id",
		  				dataSource : ds
		             });
				}
			});
			$.ajax({
				url : "<%=basePath%>dutyTypeWeb/getDutyTypelist.do?sessionId="+sessionId,
				type : "POST",
				dataType : "json",
				// async : false,
				success : function(req) {
					var ds=new  kendo.data.DataSource({
						data:req.data
					});
					
					$("#cmbdutytype").kendoComboBox({
						dataTextField: "name",
		  				dataValueField: "id",
		  				dataSource : ds
		             });
				}
			});
		},
		
		packCriteria :function (){
			var criteria = {};
			var beginDate = $("#dteBeginDate").data("kendoDatePicker").value();
			var endDate = $("#dteBeginDate").data("kendoDatePicker").value();
			
			var t1=$('#spnBeginTime').data("kendoTimePicker").value();
			var t2=$('#spnEndTime').data("kendoTimePicker").value();
			
			
			//beginDate.setTime(t1.getTime());
			//endDate.setTime(t2.getTime());
		
			criteria.beginTime=beginDate.getFullYear()+ "-"
								+ ((beginDate.getMonth() + 1) > 10 ? (beginDate.getMonth() + 1) : "0" + (beginDate.getMonth() + 1))+ "-" 
								+ (beginDate.getDate() < 10 ? "0" + beginDate.getDate() : beginDate.getDate()) + " "
								+ (t1.getHours() < 10 ? "0" + t1.getHours() : t1.getHours())+":"
								+ (t1.getMinutes() < 10 ? "0" + t1.getMinutes() : t1.getMinutes())+":00";
			criteria.endTime=endDate.getFullYear()+ "-"
								+ ((endDate.getMonth() + 1) > 10 ? (endDate.getMonth() + 1) : "0" + (endDate.getMonth() + 1))+ "-" 
								+ (endDate.getDate() < 10 ? "0" + endDate.getDate() : endDate.getDate()) + " "
								+ (t2.getHours() < 10 ? "0" + t2.getHours() : t2.getHours())+":"
								+ (t2.getMinutes() < 10 ? "0" + t2.getMinutes() : t2.getMinutes())+":00";
		
			criteria.taskPropertyIds = [];
			criteria.taskPropertyIds.push($("#dutyProperty").data("kendoComboBox").value());
			
			criteria.policeTypeIds = [];
			criteria.policeTypeIds.push($("#cmbpoliceType").data("kendoComboBox").value());
			
			criteria.dutyTypeIds = [];
			criteria.dutyTypeIds.push($("#cmbdutytype").data("kendoComboBox").value());
			
			criteria.attireTypeIds = [];
			if ($("#ckAttireType1").prop('checked')) {
				criteria.attireTypeIds.push(0);
			}
			if ($("#ckAttireType2").prop('checked')) {
				criteria.attireTypeIds.push(1);
			}
			
			
			criteria.armamentTypeIds = [];
			if ($("#ckArmamentType1").prop('checked')) {
				criteria.armamentTypeIds.push(0);
			}
			if ($("#ckArmamentType2").prop('checked')) {
				criteria.armamentTypeIds.push(1);
			}
			
			criteria.orgIds=[];
			criteria.orgIds.push($("#organId").val());

			return criteria;

		},
		/*
		查询
		*/
		search:function(){
			this.loadReport();
		},
		loadReport : function(){
			var criteria = this.packCriteria();

			var query = JSON.stringify(criteria);

			$.ajax({
				url : "<%=basePath%>dutyReportWeb/loadDutyReport.do?sessionId="+sessionId,
				type : "POST",
				dataType : "json",
				data : {
					criteria : query
				},
				// async : false,
				success : function(req) {
					if (req.code == 200) {// 成功填充数据
						 var ds = new kendo.data.TreeListDataSource({
						 	data:req.data
						 });
						
						//var ss = buildReportTree(data);
						var tlRepport=$('#tlReport').data("kendoTreeList");
						tlRepport.setDataSource(ds);

					} else {
						alert("获取数据失败");
					}
				}
			});
		}
	};
</script>

<div id="tlReport"></div>