<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test4.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>Skin/Default/css/global.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Skin/Default/css/base.css"/>
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath %>JS/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="<%=basePath %>JS/jquery-1.11.1.min.js"></script>
	
	<!-- left = 当前鼠标位置.x - (鼠标点击时的.x值 - div的初始位置x值)  
    top = 当前鼠标位置.y - (鼠标点击时的.y值 - div的初始位置y值)   -->
	
	 <style type="text/css">
	 #hahah{
	 	display: none;
	 }
	 #dialog{
	 	cursor: pointer;
	 }
        /*   *{margin: 0;padding: 0;}
          #box{border: 5px solid #2e2e2e;width:1000px;height: 500px;background-color: #CC9900;
             -moz-border-radius: 15px;      
             -webkit-border-radius: 15px;   
                border-radius:15px;           
              display: none;
              margin-left: 30px;
              margin-top: 20px;
              position: absolute;
            }
        */
         /* #hd{background-color: #666666;font-size: 14px;padding: 4px;cursor: pointer;} */
         /* span{float: right;padding-right: 4px;cursor: pointer;} */
        /*  #cnt{padding: 5px;} */
     </style>
     
      <script>
          $(document).ready(function() {
				/* 点击弹出按钮显示出来 */             
        	  $('#btn a').click(function() {
                 $('#hahah').show();
             }); 
             
             /* 给右上角关闭加上事件 */
             $('span').click(function() {
        	      $('#hahah').hide();
        	 });
             
             /* 拖拽 */
             $('#hahah').mousedown(function(event) {
                  var isMove = true;
                  var abs_x = event.pageX - $('div#hahah').offset().left;
                  var abs_y = event.pageY - $('div#hahah').offset().top;
                  $(document).mousemove(function(event) {
                      if (isMove) {
                          var obj = $('div#hahah');
                          obj.css({'left':event.pageX - abs_x, 'top':event.pageY - abs_y});
                      };
                  }).mouseup(function(event) {
                      isMove = false;
	             });
  	            }); 
         });  
          /* 隐藏窗口  */
          function close12(){
        	  $('#hahah').hide();
          }
     </script>
  </head>
  
  <body>
     <div id="btn">
         <a href="javascript:void(0);">点我弹框</a>
     </div>
     
     
    <div class="window w925 relative" id="hahah">
    <div class="line1-mid" id="dialog">
      <div class=" t1-start fl"></div>
      <div class="t1-end fr"></div>
      <div><a href="#" class="window-close"></a></div>
    </div>
    <div class="fr mt8 mr5"><img src="Skin/Default/images/window-right.png"></div>
    
    <div class="mid"><!----中部---->
    
    
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
	                  <input id="parent" type="hidden" value=""/>
	                  <input type="text" id="parentId" value="" placeholder="单击左侧选择..."
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
    
     <div class="line1-mid mt8">
      <div class=" b1-start fl"></div>
      <div class=" b1-end fr"></div>
    </div>
  </div>
  </body>
</html>
