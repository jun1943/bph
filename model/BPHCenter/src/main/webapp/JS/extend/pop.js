/*
 * popjs 1.0 
 * http://hi.baidu.com/lpf801/home
 *
 * Copyright (c) 2015 lai Pengfei (laipengfeide@163.com)
 *
 * Date: 2015-3-18
 * please prepare jQuery.js file
 *
 */
(function($) {
	$.fn.popjs = function (opt){
		var title,content,callback;
		if(opt!=null){
			title= opt.title;
			content = opt.content;
			callback = opt.callback;
		}else{
			title = '提示';
			content = '操作成功！';
		}
		
		var str='<div id="fullbg"></div>'+
				'<div class="pop" id="pop">'+
					'<div class="pop-main">'+
						'<div class="pop-title">'+
							'<p>'+title+'</p><em></em>'+
						'</div>'+
						'<div class="pop-txt">'+content+'</div>'+
						'<div class="pop-btn">'+
							'<input type="button" class="pop-ok" id="popOk" value="确 认" />'+
						'</div>'+
					'</div>'+
				'</div>';
		if($("#pop").length == 0){
			var obj = $("body").get(0);
			$(obj).append(str);
			
			showpop();
		}
		
		function showpop(){
			showBg();
			var ow = $("#pop").width()/2;
			var oh = $("#pop").height()/2;
			var tv = $(window).width()/2-ow;
			var lv = $(window).height()/2-oh;
			$("#pop").css({"display":"block","position":"absolute","top":lv,"left":tv});
			$("#popOk").bind("click",function(){
				if(typeof(callback)=="function"){
					callback();
				}
				closePop();
			});
		}
		//显示灰色JS遮罩层
		function showBg(){
			var bH = $(window).height();
			var bW = $(window).width();
			$("#fullbg").css({width:bW,height:bH,display:"block"});
			$(window).scroll(function(){resetBg();});
			$(window).resize(function(){resetBg();});
		}
		
		function resetBg(){
			var fullbg=$("#fullbg").css("display");
			if(fullbg=="block"){
				var bH2=$(window).height();
				var bW2=$(window).width();
				var ow = $("#pop").width()/2;
				var oh = $("#pop").height()/2;
				var tv = bW2/2-ow;
				var lv = bH2/2-oh;
				$("#fullbg").css({width:bW2,height:bH2});
				$("#pop").css({top:lv,left:tv});
			}
		}
	}
})(jQuery);

function closePop(){
	$("#fullbg").remove();
	$("#pop").remove();
}