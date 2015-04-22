<jsp:directive.page language="java" pageEncoding="UTF-8"/>

<script>
	var sessionId = $("#token").val();	
	function loadData(pageNo){
	
} 
	$(function() {
		
		var testData = new kendo.data.HierarchicalDataSource({
	        transport: {
				read: {
					url: "<%=basePath%>testWeb/listWithPolice.do?sessionId="+sessionId +"&rootId=" + 1,
					dataType: "json"
				}
			},
			schema: {
	 			model: {
					id: "id",
					hasChildren: "isOrg"
	           	}
			}
		});
	
		$("#gdTest").kendoTreeView({
			dataSource: testData,
			dataTextField: "name"
		});
		
		var bph_vehicle_query={};

		bph_vehicle_query.isSubOrg = 1;
		bph_vehicle_query.number = '';
		bph_vehicle_query.orgId = $("#organId").val();
		bph_vehicle_query.orgPath = $("#organPath").val();
		bph_vehicle_query.pageSize = 10
		bph_vehicle_query.pageStart = 1;

		//vehicle_Query	

		var vehicleData= new kendo.data.DataSource({
			transport:{
				read:{
					type: "post",
					url:"<%=basePath%>testWeb/getVehicleList.do",
					dataType: "json",
					data:{'vehicle_Query':JSON.stringify(bph_vehicle_query)}
				}
			},
			schema:{
				data:function(response){
					
					//console.log('response:'+JSON.stringify(response));
					return response.data;
				},
				total:function(response){
					console.log('total:'+JSON.stringify(response.totalRows));
					return response.totalRows;
				}
			},
			serverPaging : true,
			pageSize:10
		});

		$("#grid").kendoGrid({
			columns:[
				{field:"id",title:"id"},
				{field:"number",title:"编号"}
			],
			
			groupable: false,
			dataSource:vehicleData,
			
			pageable:{
				refresh:true,
				pageSizes:true,
				buttonCount:5,
				page:1,
				pageSize:10,
				pageSizes:[10,20,30],
				messages:{
					display: "显示 {0}-{1} 共 {2} 项",
					empty: "没有数据",
					itemsPerPage: "每面显示数量",
					first: "第一页",
					last: "最后一页",
					next: "下一页",
					previous: "上一页"
				}
			}
		});
		
		vehicleData.fetch(function(){
  			var data = this.data();
  			console.log(data.length);
		});
	});

	var TestMgr={
		
		loadTreeData:function(){
			$.ajax({
				url : "<%=basePath%>testWeb/listWithPolice.do?sessionId="+sessionId +"&rootId=" + 1,
					type : "post",
					dataType : "json",
					success : function(req) {
						var  ls =req.data;
					}
			});
		}
	
	};

</script>

<div id="gdTest" style="width:150%"></div>
<div id="grid" style="width: 150%"></div>