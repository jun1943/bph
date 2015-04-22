<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加角色</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<script type="text/javascript">
  	
  	var moduleNodes;
	$(document).ready(function(){
		$.ajax({
			url:"<%=basePath%>role/getModuleTree.do",
			type:"post",
			data:{
				name:"",
				random:Math.random()
			},
			dataType:"json",
			success:function(msg){
				moduleNodes=msg.description;
				$.fn.zTree.init($("#moduleTree"), moduleSetting, eval('(' + moduleNodes + ')'));
				//自动展开全部节点 
				var treeObj = $.fn.zTree.getZTreeObj("moduleTree");
                treeObj.expandAll(true);
               	// AssignCheck();
			}
		});
		
	});  
	
	 var moduleSetting = {  
			 	check: {
			 		//autoCheckTrigger: true,
					enable: true
					//chkStyle:"checkbox"
					//chkboxType: { "Y": "p", "N": "s" },
					//nocheckInherit: true,
					//chkDisabledInherit: true,
					//radioType: "all"
				},
	           view: {  
	        	   dblClickExpand: true,
	               selectedMulti: false,      //禁止多点选中  
	               //chkStyle: "checkbox"   		//表示的前面显示复选框
	               //expandSpeed: "slow"        //设置节点展开速度
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
	                   
	               }
	           }
	       };
  	
	 /* 添加角色 */
	 function addRole(){
		 
	   var treeObj = $.fn.zTree.getZTreeObj("moduleTree");
       var nodes = treeObj.getCheckedNodes(true);
       var s_parent="";
       var modulesId = "";
       for (var i = 0; i < nodes.length; i++) {
    	    if(nodes[i].isParent){
   	       		 s_parent+=nodes[i].id+",";//父节点
	   	    }else{
	   	    	modulesId+=nodes[i].id+",";//子节点
	   	    }
       }
		var roleName=$("#roleName").val();
		var roleNote=$("#roleNote").val();
		$.ajax({
			url:"<%=basePath%>role/insertRole.do",
			type:"post",
			dataType:"json",
			data:{
				roleName:roleName,
				roleNote:roleNote,
				modulesId:modulesId
			},
			success:function(msg){
				if(msg.code==200){
					alert(msg.description);
					window.location.href="<%=basePath%>role/gotoRoleList.action";
				}else{
					alert(msg.description);
				}
			}
		});
		 
	 }
	 /* 获取所有选中的值  */
	 function getCheckAll(){
		 var treeObj = $.fn.zTree.getZTreeObj("moduleTree");
	        var nodes = treeObj.getCheckedNodes(true);
	        var s_parent="";
	        var s_child="";
	        var modulesId = "";
	        for (var i = 0; i < nodes.length; i++) {
	        	//modulesId += nodes[i].id+",";
	        	if(nodes[i].isParent){
        	        s_parent+=nodes[i].id+",";//父节点
        	    }else{
        	    	modulesId+=nodes[i].id+",";//子节点
        	    }
	        }
	        alert(modulesId);
	        //alert("父节点:"+s_parent+"\n"+"子节点:"+s_child);
	 }
	 
	 //选中指定的节点
    function AssignCheck() {
        var treeObj = $.fn.zTree.getZTreeObj("moduleTree");
        //var nodes = treeObj.getNodes();
        //treeObj.checkNode(treeObj.getNodeByParam("id", "000100010002", null), true, true);
        treeObj.checkNode(treeObj.getNodeByParam("id", "9", null), true, true);
        treeObj.checkNode(treeObj.getNodeByParam("id", "8", null), true, true);

    }
	 
  	</script>
   
   
   <div class="mid"><!----中部---->
    <div class="mid-tree mt10 mr20"><!----中部管理树---->
      <div class="line1-mid">
        <div class="t1-start fl"></div>
        <div class="end fr"></div>
      </div>
      
      <div class="fl w172">
        <div class="mr10 mt8 fl"><img src="<%=path %>/Skin/Default/images/guanli-search.png"></div>
        <div class="search-result fl">1500</div>
        <div class="fr mt8"><a href="#"><img src="<%=path %>/Skin/Default/images/button3.png"></a></div>
        
        <div class="clear"></div>
        <div>
          <input type="text" id="organName" class="search-input mr5 fl">
          <a href="javascript:void(0)" onclick="searchOrgan()" class="search-button dis-cell"></a>
        </div>
      </div>
      
      <div class="fr mt8">
        <div><a href="#"><img src="<%=path %>/Skin/Default/images/button4.png"></a></div>
        <div><img src="<%=path %>/Skin/Default/images/guanli-53.png"></div>
      </div>
      
      <div class="clear"></div>
       <div class="tree-box mt10"><!----机构树---->
        <ul id="moduleTree" class="ztree">  
        </ul>  
      </div> <!----机构树结束---->
      <div><img src="<%=path %>/Skin/Default/images/line3.png"></div>
      <div class="mt16"><img src="<%=path %>/Skin/Default/images/line2.png"></div>
    </div><!----中部管理树结束---->
    
    
    <div id="using" class="fl"><!----应用界面---->
       
       <div class="mt5">
        <div class="fl mt5 mr5"><img src="<%=path %>/Skin/Default/images/mark3.png"></div>
        <h2>添加角色</h2>
      </div>
      <hr class="hr mt8">
      <div class="mid-form auto mt10"><!----表单---->
        <table class="form-table">
           <tr>
            <td>角色名称：</td>
            <td>
              <table class="text-table">
                <tr>
                  <td><img src="<%=path %>/Skin/Default/images/text-left.png"></td>
                  <td><input id="roleName" type="text" class="form-control w258 text" placeholder="等待输入..."></td>
                  <td><img src="<%=path %>/Skin/Default/images/text-right.png"></td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>角色备注：</td>
            <td>
               <textarea id="roleNote" class=" textarea w640 h260 mt12" ></textarea>
            </td>
          </tr>
        </table>
        <hr class="hr mt20">
        <div>
          <a href="#" onclick="addRole()" class="button-red auto mt40">确认添加</a>
          <!-- <a href="#" onclick="getCheckAll()" class="button-red auto mt40">确认添加</a> -->
        </div>
      </div><!----表单结束---->
      <hr class="hr mt10">
</div> 
  </body>
</html>
