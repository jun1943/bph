
		function ToOrganDetail(Id){
			window.location.href="<%=basePath %>web/organx/queryOrganDetail.action?organId="+Id;
		}
		function addOrgan(){
			window.location.href="<%=basePath %>web/organx/gotoAddOrgan.action";
		}
		function queryOrgan(){
			var queryName=$("#queryName").val();
			window.location.href="<%=basePath %>web/organx/gotoOrganList.action?name="+queryName;
			
		}
		function deleteOrgan(Id){
			$.ajax({
				url:"<%=basePath%>web/organx/deleteOrgan.action",
				type:"post",
				data:{
					organId:Id
				},
				complete:function(rsp){
					window.location.href="<%=basePath %>web/organx/gotoOrganList.action";
				}
			});
		}
		function addOrgan(){
  			$.ajax({
  				url:"<%=basePath%>web/organx/addOrgan.action",
  				type:"post",
  				data:{
  					name:$("#name").val(),
  					shortName:$("#shortName").val(),
  					code:$("#code").val(),
  					parentId:$("#parentId").val(),
  					orgPcCgyCode:$("#orgPcCgyCode").val(),
  					orgTypeCode:$("#orgTypeCode").val()
  				},
  				complete:function(rsp){
  					window.location.href="<%=basePath%>web/organx/gotoOrganList.action";
  				}
  			});
  		}
		
		function editOrgan(){
	  		 $.ajax({
	  			url:"<%=basePath%>web/organx/modifyOrgan.action",
	  			type:"post",
	  			data:{
	  				organId:$("#id").val(),
	  				name:$("#name").val(),
	  				shortName:$("#shortName").val(),
	  				code:$("#code").val(),
	  				parentId:$("#parentId").val(),
	  				orgTypeCode:$("#orgTypeCode").val(),
	  				orgPcCgyCode:$("#orgPcCgyCode").val()
	  			},
		  		 complete:function(rsp){
		  			//var rst=$.parseJSON(rsp.responseText);
		  		/* 	if(rsp.code==200){
		  				alert("修改成功");
		  			}else{
		  				alert("修改失败");
		  			} */
		  			window.location.href="<%=basePath%>web/organx/gotoOrganList.action";
		  		}
	  		});
	  	}
