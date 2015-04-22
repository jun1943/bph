<%@ page language="java" pageEncoding="UTF-8"%>

<div id="grid"></div>
<div id="page"></div>
<script type="text/javascript">
	var organId;
	var organPath;
	var organOrNext;
	var cardPointTotal = 0;
	var zNodes;
	var v="";
	var cardPointData;	//修改卡点时，数据对象
	
	function loadData(pageNo){
		/* var	organName = $("#organName").val(); */
		organId = $("#organId").val();
    	organPath=$("#organPath").val();
    	organLevel=$("#organLevel").val();
		searchCardPoint(pageNo);
	}
	
	$(document).ready(function(){
		organTree();			/* 机构树 */
		loadData(1);
	});  
	
	function organTree(){
		$.ajax({
			url:"<%=basePath%>web/organx/tree.do",
			type:"post",
			data:{
				name:$("#orgName").val(),
				sessionId:$("#token").val(),
				expandeds:$("#expandeds").val(),
				random:Math.random()
			},
			dataType:"json",
			success:function(msg){
				/* zNodes=msg.description;
				$.fn.zTree.init($("#treeDemo"), setting, eval('(' + zNodes + ')')); */
			}
		});
	}
	
	// 总卡点数量
	//function queryCardPointTotal(){
		//$.ajax({
			//url:/web/cardPoint/queryCardPointTotal.do,
			//type:"post",
			//dataType:"json",
			//data:{
				//sessionId:$("#token").val()
			//},
			///success:function(msg){
				// if(msg.code==200){
				//	cardPointTotal = msg.data;
					//var h1 = document.getElementById("cardPointTotal");
					//h1.innerHTML = cardPointTotal + "个";
			//	}else{
				//	alert(msg.description);
			//	}
			//}
		//});
	//}

	function searchOrgan(){
		$.ajax({
			url:"<%=basePath%>web/organx/tree.do",
			type:"post",
			dataType:"json",
			data:{
				name:$("#organName").val(),
				sessionId:$("#token").val()
			},
			success:function(msg){
				zNodes=msg.description;
				$.fn.zTree.init($("#treeDemo"), setting, eval('(' + zNodes + ')'));
			}
		});
	}
	
	/* 卡点查询 */
	function searchCardPoint(pageNo){
		$.ajax({
			url:"<%=path %>/web/cardPoint/queryCardPointList.do",
			type:"post",
			dataType:"json",
			data:{
				path: $("#organPath").val(),
				name:$("#cardPointName").val(),
				sessionId:$("#token").val(),
				organOrNext:$("#organOrNext").val(),
				pageNo:pageNo,
				pageSize:10
			},
			success:function(msg){
				if(msg.code==200){
					if(msg.data != null){
						var udata = msg.data;
						var total = msg.totalRows;
						document.getElementById("gridListTotal").innerHTML=total+"个";
						$("#grid").kendoGrid({
	                        dataSource: {
	                            data: udata
	                        },
	                     	height: 550,
                      		/* groupable: true, */
                          	sortable: true,
                          /* toolbar: ["create"], */
	                        columns: [
  	                        	{field: "操作", template: 
                        			"<button class='ty-edit-btn' title='编辑' id='openCardPoint' type='button' onclick='editCardPoint(#: cardPointId #)'>编辑</button>"+
                        			"<button class='ty-delete-btn' title='删除' id='deleteCardPoint' type='button' onclick='deleteCardPoint(#: cardPointId #)'>删除</button>",
                        		},
	                            {field: "name", title: "卡点名称"}, 
	                        	{field: "intercomGroupId", title: "通讯组号"}, 
	                        	{field: "circleLayerName", title: "所属圈层"},
	                        	{field: "camera", title: "关联天网"},
	                        	{field: "assignment", title: "职责"}],
	                        /* editable: "popup" */
	                    });
						var pg = pagination(pageNo,total,'loadData',10);
   	                	$("#page").html(pg);
					}
				}
			}
		});
	}

	function openCardPoint(id){
		$.ajax({
			url:"<%=path %>/web/cardPoint/queryCardPointDetailById.do",
			type:"post",
			dataType:"json",
			data:{
				sessionId:$("#token").val(),
				id: id
			},
			success:function(msg){
				if(msg.code==200){
					if(msg.data != null){
						cardPointData = msg.data;
						document.getElementById("mCardPointId").value = cardPointData.cardPointId;
						document.getElementById("mName").value = cardPointData.name;
						document.getElementById("mCommGroupId").value = cardPointData.intercomGroupId;
						document.getElementById("mPeoplePoliceCount").value = cardPointData.peoplePoliceCount;
						document.getElementById("mTrafficPoliceCount").value = cardPointData.trafficPoliceCount;
						document.getElementById("mArmsPoliceCount").value = cardPointData.armsPoliceCount;
						document.getElementById("mCircleLayer").value = cardPointData.circleLayer;
						document.getElementById("mAssignment").value = cardPointData.assignment;
					}
				}
			}
		});
		
		var windows = $("#windows"),
        openCardPoint = $(".openCardPoint")
                    .bind("click", function() {
                        //windows.data("kendoWindow").open();
                    	window.parent.$("#dialog").tyWindow.close();
                    });
        var onClose = function() {
        	openCardPoint.show();
        }
	}
	
    var setting = {  
           view: {  
        	   dblClickExpand: true,
               selectedMulti: false       //禁止多点选中  
           },  
           data: {  
               simpleData: {  
                   enable:true,  
                   idKey: "id",  
                   pIdKey: "parentId",  
                   rootPId: ""  
               }  
           },  
           callback: {  
               onClick: function(treeId, treeNode) {  
            	   var treeObj=$.fn.zTree.getZTreeObj("treeDemo");
                   var nodes=treeObj.transformToArray(treeObj.getNodes());
                   
                   var selectedNode = treeObj.getSelectedNodes()[0];
                   organPath = selectedNode.path;

                    $("#table1 tbody").remove();
               		$.ajax({
               			url:"<%=basePath%>web/cardPoint/queryCardPointPageList2.do",
               			type:"post",
               			dataType:"json",
               			data:{
               				path:selectedNode.path,
               				sessionId:$("#token").val(),
               				code:selectedNode.code
               			},
               			success:function(msg){
               				 if(msg.code==200){
               					if(msg.data != null){
               					 	$(msg.data.data).each(function(){
               							 $("#table1").append("<tbody><tr>"+
               	   			              "<td class='pl20'><div class='checkbox'>"+
               	   			  		          "<input type='checkbox' id='checkboxInput' name=''/><label for='checkboxInput'></label></div></td>"+
               	   			              "<td>"+this.name+"</td><td><div class='auto w100b'>"+
               	   			                  "<a href='javascript:void(0)' onclick='modifyCardPoint("+this.cardPointId+")' class='table-change fl'></a>"+
               	   			                  "<a href='javascript:void(0)' onclick='deleteCardPoint("+this.cardPointId+")' class='table-delete fr'></a>"+
               	   			                "</div></td><td>"+this.intercomGroupId+"</td>"+
               	   						  "<td>"+this.policeTotal+
               	   						  "</td><td>"+this.circleLayer+"</td><td></td><td></td><td>"+this.assignment
               	   									
               	   							+"</td></tr></tbody>");
               	           				});
               					}
               				}
               			}
               		});
               }
           }
       };

    function saveCardPoint(){
    	alert("save");
    	$.ajax({
			url:"<%=basePath %>/web/cardPoint/deleteCardPoint.do",
			type:"post",
			dataType:"json",
			data:{
				id: Id
			},
			success:function(msg){
				 if(msg.code==200){
					searchCardPoint(1);					
				}else{
					alert(msg.description);
				}
			}
		});
		return true; 
    }
    
	/* 修改卡点 */
    function modifyCardPoint(Id){
		var sessionId=$("#token").val()
		window.location.href="<%=basePath %>web/cardPoint/queryCardPointDetail.action?id="+Id+"&sessionId="+sessionId;
	}
    
    function addCardPoints(){
    	var sessionId=$("#token").val()
    	window.location.href="<%=basePath %>web/cardPoint/addCardPoints.action?sessionId="+sessionId;
	}
    
 	/* 删除卡点 */
    function deleteCardPoint(Id){
    	var sessionId = $("#token").val();
    	$("body").tyWindow({"content":"确定是否删除该卡点?","center":true,"ok":true,"no":true,"okCallback":function(){
    		$("#table1 tbody").remove();
    		$.ajax({
    			url:"<%=basePath %>/web/cardPoint/deleteCardPoint.do?sessionId="+sessionId,
    			type:"post",
    			dataType:"json",
    			data:{
    				id: Id
    			},
    			success:function(msg){
    				 if(msg.code==200){
    					searchCardPoint(1);					
    				}else{
    					$("body").popjs({"title":"提示","content":msg.description});
    				}
    			}
    		});
    		//queryCardPointTotal();
    	}});
	}
    
	function ToOrganDetail(Id){
		var sessionId = $("#token").val();
		window.location.href="<%=basePath %>web/organx/queryOrganDetail.action?organId="+Id+"&sessionId="+sessionId;
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
			url:"<%=basePath %>web/organx/deleteOrgan.do",
			type:"get",
			dataType:"json",
			data:{
				organId:Id
			},
			success:function(msg){
				 if(msg.code==200){
					 $("body").popjs({"title":"提示","content":msg.description});
					window.location.href="<%=basePath %>web/organx/gotoOrganList.action";
				}else{
					$("body").popjs({"title":"提示","content":msg.description});
				}
			}
		});
	}
	</script>
	
	
<div id="dialog"></div>

<script>
/* 卡点标绘 */
function drawCardPoint(cardPointId){
    window.external.MarkCartPoint(cardPointId);
}

/* 圈层设置 */
function openCircleLayer(){
	var sessionId = $("#token").val();
	$("#dialog").tyWindow({
		width: "680px",
		height: "480px",
	    title: "圈层设置",
	    position: {
	        top: "100px"
	      },
		content: "<%=path%>/web/cardPoint/gotoCircleLayer.do?sessionId="+sessionId,
		iframe : true,
		closeCallback: onClose
	});
	//$("#dialog").data("kendoWindow").open();
}
	
function addCardPoint(){
	if(organId == null || organId == ""){
		alert("请选择机构");
	}else{
		var sessionId = $("#token").val();
		$("#dialog").tyWindow({
			width: "680px",
			height: "480px",
		    title: "卡点管理",
		    position: {
		        top: "100px"
		      },
			content: "<%=path%>/web/cardPoint/gotoCardPointAdd.do?organId="+organId+"&sessionId="+sessionId,
			iframe : true,
			closeCallback: onClose,
		});
		//$("#dialog").data("kendoWindow").open();
	}
}
	
function editCardPoint(cardPointId){
	/* var organId = $("#organId").val(); */
	var sessionId = $("#token").val();
	$("#dialog").tyWindow({
		width: "680px",
		height: "500px",
	    title: "卡点管理",
	    position: {
	        top: "100px"
	      },
		content: "<%=path %>/web/cardPoint/gotoCardPointEdit.do?cardPointId="+cardPointId+"&sessionId="+sessionId,
		iframe : true,
		closeCallback: onClose
	});
	//$("#dialog").data("kendoWindow").open();
}

function onClose(e) {
	searchCardPoint(1);
}
</script>
