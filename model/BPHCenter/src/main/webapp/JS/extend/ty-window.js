/*
 * ty-window 1.0 
 * http://hi.baidu.com/lpf801/home
 *
 * Copyright (c) 2015 lai Pengfei (laipengfeide@163.com)
 *
 * Date: 2015-3-18
 * please prepare jQuery.js file
 *
 * 参数对照
 * title：标题1；title2：标题2；no：是否显示取消按钮；noValue：取消按钮文字；ok：是否显示确定按钮;okValue：确定按钮文字；content：内容；position：重新定位（默认屏幕中间显示）；icon：图标（目前支持参数icon）；iframe：是否显示网页；okCallback：确定按钮回调函数；noCallback：取消按钮回调函数；closeCallback：关闭按钮回调函数；
 */
(function($) {
	$.fn.tyWindow = function (opt){
		var title,title2,no=false,noValue,ok=false,okValue,content,width,height,position='',icon='',center=false,iframe=false,okCallback,noCallback,closeCallback;
		if(opt!=null){
			title= opt.title;
			title2 = opt.title2;
			content = opt.content;
			width = opt.width;
			height = opt.height;
			no = opt.no;
			noValue = opt.noValue;
			ok = opt.ok;
			okValue = opt.okValue;
			position = opt.position;
			icon = opt.icon;
			center = opt.center;
			iframe = opt.iframe;
			okCallback = opt.okCallback;
			noCallback = opt.noCallback;
			closeCallback = opt.closeCallback;
			
			if(title==undefined)title='提示';
			if(title2==undefined)title2 = '';
			if(width==undefined)width = '400px';
			if(height==undefined)height='250px';
			if(content==undefined)content='';
			if(noValue==undefined)noValue='取 消';
			if(okValue==undefined)okValue='确 定';
		}else{
			width='400px';
			height='250px';
			title = '提示';
			title2 = '';
			no = false;
			ok = false;
			content = '操作成功！';
			okValue='确 定';
			noValue='取 消';
		}
		
		var str='<div id="fullbg"></div><div class="ty-tcc" id="tyTcc" style="width:'+width+';height:'+height+';">'+
            	'<table class="ty-tcc-table">'+
                	'<tr>'+
                    	'<td width="30"><i class="ty-tcc-bg1"></i></td>'+
                        '<td><i class="ty-tcc-bg2"></i></td>'+
                        '<td width="30"><i class="ty-tcc-bg3"></i><div class="temp"><i class="ty-tcc-close" id="tccClose"></i></div></td>'+
                    '</tr>'+
                    '<tr>'+
                    	'<td><i class="ty-tcc-bg4"></i></td><td><div class="ty-tcc-top"></div></td><td><i class="ty-tcc-bg5"></i></td>'+
                    '</tr>'+
                    '<tr>'+
                    	'<td></td>'+
                    	'<td>'+
                        	'<div class="ty-tcc-main" id="tyTccMain">'+
                            	'<div class="ty-tcc-mh">'+
                                    '<table class="ty-tcc-table">'+
                                    	'<tr>'+
                                        '<td><div id="tyTccTitle" class="fl mr10"><i class="ty-tcc-mh-icon"></i><span class="ty-tcc-title1"><p>'+title+'</p><em></em></span>'+
											'<span class="ty-tcc-title2">'+title2+'</span></div></td>'+
                                        '<td><span class="ty-tcc-title3"><div class="temp"><em></em></div></span></td>'+
                                        '</tr>'+
                                    '</table>'+
                                '</div>'+
                                '<div class="ty-tcc-info"><table id="tyTccTable" class="ty-tcc-table"><tr>';
								if(icon!=undefined){
									str+='<td width="110px"><i class="ty-tcc-'+icon+'"></i></td>';
								}
                                	str+='<td '+((center)?('align=center'):'')+'>';
                                	if (iframe) {
                                		str+='<iframe frameborder="0" src="'+content+'" class="ty-tcc-frame" title="'+title+'"></iframe>';
                                	}else{
                                		str+=content;
                                	}
                                	str+='</td></tr></table></div>';
                            	if(no || ok){	
                                	str +='<div class="ty-tcc-btn">';
									if(no){
										str +='<input type="button" class="ty-tcc-btn-no" value="'+noValue+'" id="tyTccNo" />';
									}
									if(ok){
										str +='<input type="button" class="ty-tcc-btn-ok" value="'+okValue+'" id="tyTccOk" />';
									}
                                	str +='</div>';
								}
                            str+='</div>'+
                        '</td>'+
                        '<td></td>'+
                    '</tr>'+
                    '<tr>'+
                    	'<td><i class="ty-tcc-bg6"></i></td><td><div class="ty-tcc-bottom"></div></td><td><i class="ty-tcc-bg7"></i></td>'+
                    '</tr>'+
                    '<tr>'+
                    	'<td><i class="ty-tcc-bg8"></i></td><td><i class="ty-tcc-bg9"></i></td><td><i class="ty-tcc-bg10"></i></td>'+
                    '</tr>'+
                '</table>'+
        '</div>';
		
		if($("#tyTcc").length == 0){
			var obj = $("body").get(0);
			$(obj).append(str);
			
			openTcc();
		}
		
		function openTcc(){
			showBg();
			var ow = $("#tyTcc").width()/2;
			var oh = $("#tyTcc").height()/2;

			var tv = $(window).width()/2-ow;
			var lv = $(window).height()/2-oh;
			if(position!=undefined){
				if(position.top!=undefined)lv=position.top;
				if(position.left!=undefined)tv=position.left;
			}
			$("#tyTcc").css({"display":"block","position":"absolute","top":lv,"left":tv});
			var w = $("#tyTccTitle").width();
			$("#tyTccTitle").parent().css("width",w+10);
			var hei = height.substring(0,height.indexOf("p"));
			
			$("#tyTccTable .ty-tcc-frame").css("height",hei-200);
			
			$("#tyTccNo").bind("click",function(){
				if(typeof(noCallback)=="function"){
					noCallback();
				}
				closeTcc();
			});
			
			$("#tccClose").bind("click",function(){
				if(typeof(closeCallback)=="function"){
					closeCallback();
				}
				closeTcc();
			});
			
			$("#tyTccOk").bind("click",function(){
				if(typeof(okCallback)=="function"){
					okCallback();
				}
				closeTcc();
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
		//浏览器大小改变
		function resetBg(){
			var fullbg=$("#fullbg").css("display");
			if(fullbg=="block"){
				var bH2=$(window).height();
				var bW2=$(window).width();
				var ow = $("#tyTcc").width()/2;
				var oh = $("#tyTcc").height()/2;
				var tv = bW2/2-ow;
				var lv = bH2/2-oh;
				$("#fullbg").css({width:bW2,height:bH2});
				if(position!=undefined){
					if(position.top!=undefined)lv=position.top;
					if(position.left!=undefined)tv=position.left;
				}
				$("#tyTcc").css({top:lv,left:tv});
			}
		}
		
	}
	//追加方法
	var f = $.fn.tyWindow;
	f.open = function(o){f(o);}
	
	f.close = function(){closeTcc();}
	
})(jQuery);

//关闭弹出层
function closeTcc(){
	$("#fullbg").remove();
	$("#tyTcc").remove();
}