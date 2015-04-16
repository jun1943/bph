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
					hasChildren: "dataType"
	           	}
			}
		});
	
		$("#gdTest").kendoTreeView({
			dataSource: testData,
			dataTextField: "name"
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
