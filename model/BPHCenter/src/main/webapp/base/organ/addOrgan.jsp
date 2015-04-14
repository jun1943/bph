<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加机构</title>
    
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
  	var zNodes;
	$(document).ready(function(){
		$.ajax({
			url:"<%=basePath%>web/organx/tree.do",
			type:"post",
			data:{
				name:$("#orgName").val(),
				random:Math.random()
			},
			dataType:"json",
			success:function(msg){
				zNodes=msg.description;
				$.fn.zTree.init($("#treeDemo"), setting, eval('(' + zNodes + ')'));
			}
		});
		 
	});  
	
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
	                   //$("#parent").val(selectedNode.id);
	                   //$("#parentId").val(selectedNode.name);
	               }
	           }
	       };
	
  		function addOrgan(){
  			$.ajax({
  				url:"<%=basePath%>web/organx/addOrgan.do",
  				type:"get",
  				dataType:"json",
  				data:{
  					name:$("#name").val(),
  					code:$("#code").val(),
  					shortName:$("#shortName").val(),
  					parentId:$("#parent").val(),
  					orgTypeCode:$("#orgTypeCode").val(),
  					note:$("#area").val()
  				},
  				success:function(msg){
  					 if(msg.code==200){
  						alert(msg.description);
  						window.location.href="<%=basePath%>web/organx/gotoOrganList.action";
  					}else{
  						alert(msg.description);
  					}
  				}
  			});
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
        <ul id="treeDemo" class="ztree">  
        </ul>  
      </div> <!----机构树结束---->
      <div><img src="<%=path %>/Skin/Default/images/line3.png"></div>
      <div class="mt16"><img src="<%=path %>/Skin/Default/images/line2.png"></div>
    </div><!----中部管理树结束---->
    
    
    <div id="using" class="fl"><!----应用界面---->
       
       <div class="mt5">
        <div class="fl mt5 mr5"><img src="<%=path %>/Skin/Default/images/mark3.png"></div>
        <h2>添加机构</h2>
      </div>
      <hr class="hr mt8">
      <div class="mid-form auto mt10"><!----表单---->
        <table class="form-table">
          <tr>
            <td>机构名称：</td>
            <td>
              <table class="text-table">
                <tr>
                  <td class=" text-left"></td>
                  <td><input id="name" type="text" class="form-control w258 text" placeholder="等待输入..."></td>
                  <td class="text-right"></td>
                </tr>
              </table>
            </td>
          </tr>
            <tr>
            <td>机构编码：</td>
            <td>
              <table class="text-table">
                <tr>
                  <td class=" text-left"></td>
                  <td><input id="code" type="text" class="form-control w258 text" placeholder="等待输入..."></td>
                  <td class="text-right"></td>
                </tr>
              </table>
            </td>
          </tr>
           <tr>
            <td>机构简称：</td>
            <td>
              <table class="text-table">
                <tr>
                  <td><img src="<%=path %>/Skin/Default/images/text-left.png"></td>
                  <td><input id="shortName" type="text" class="form-control w258 text" placeholder="等待输入..."></td>
                  <td><img src="<%=path %>/Skin/Default/images/text-right.png"></td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>机构类型：</td>
            <td>
               <select id="orgTypeCode" class="form-control w258">
		    		<option value="">---请选择类型---</option>
		    		<option value="1">市局</option>
		    		<option value="2">分局</option>
		    		<option value="3">市局直属</option>
		    		<option value="4">分局机关</option>
		    		<option value="5">派出所</option>
	    		</select>
            </td>
          </tr>
          <tr>
            <td>上级机构：</td>
            <td>
            	<table class="text-table">
                <tr>
                  <td class=" text-left"></td>
                  <td>
	                  <input id="parent" type="hidden" value="${organ.id}"/>
	                  <input type="text" id="parentId" value="${organ.name}" placeholder="单击左侧选择..."
	                  class="form-control w258 text" readonly>
                  </td>
                  <td class="text-right"></td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>机构备注：</td>
            <td>
               <textarea id="area" class=" textarea w640 h260 mt12" ></textarea>
            </td>
          </tr>
        </table>
        <hr class="hr mt20">
        <div>
          <a href="#" onclick="addOrgan()" class="button-red auto mt40">确认添加</a>
        </div>
      </div><!----表单结束---->
      <hr class="hr mt10">
</div> 
  </body>
</html>
