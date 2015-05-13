/*
 * 鎶ュ棣栭〉锛屾棩鍘嗛〉闈笟鍔￠�杈戞搷浣�
 * 
 * 鍖呮嫭锛氭棩鍘嗙殑灞曠ず锛�
 * 鎶ュ鎯呭喌缁熻
 * 鎶ュ鏄庣粏锛�
 * 
 */

var y;
var m_date = null; 
var m;
var m_xid_max = 0; // duty鐨則reegrid鐨刬d,蹇呴』纭繚
var m_ymd = null; /* 褰撳墠骞存湀鏃�*/
var m_dutyCalendar_Org = {};
var m_duty = {};
var sessionId ;
$(function() { 

	// 鑾峰彇鍦板潃鏍忓弬鏁帮紝鑾峰彇缁勭粐缁撴瀯淇℃伅锛� 
	m_dutyCalendar_Org.id = $("#organId").val();
	m_dutyCalendar_Org.code =$("#organCode").val();
	m_dutyCalendar_Org.path =$("#organPath").val(); 
	sessionId = $("#token").val();
	m_year = $("#dutyyears").val();
	m_month = $("#dutymonth").val();
 
	y = m_year;
	m = m_month;
	$("#sp_years").text(y+"年");
	$("#sp_month").text(m+"月");
	changeDivHeight(); // 琛ㄦ牸鑷姩楂樺害璁剧疆
	getDateData(y + "-" + m + "-" + 1);// 鍒濆鍖栭粯璁ゆ湀浠芥暟鎹� 
});
function loadData(pageNo){  
	m_dutyCalendar_Org.id = $("#organId").val();
	m_dutyCalendar_Org.code =$("#organCode").val();
	m_dutyCalendar_Org.path =$("#organPath").val(); 
	sessionId = $("#token").val();
	m_year = $("#dutyyears").val();
	m_month = $("#dutymonth").val();
 
	y = m_year;
	m = m_month;
	$("#sp_years").text(y+"年");
	$("#sp_month").text(m+"月");
	changeDivHeight(); // 琛ㄦ牸鑷姩楂樺害璁剧疆
	getDateData(y + "-" + m + "-" + 1);// 鍒濆鍖栭粯璁ゆ湀浠芥暟鎹� 
}

// 璁剧疆鏃ュ巻绐椾綋鐨勯珮搴�
function changeDivHeight() {

	var bodyHeight = document.body.clientHeight;
	var tableContentHeight = bodyHeight - 60;
	var tdHeight = parseInt(tableContentHeight / 6) - 3;
	var dateBoxMainDateTDBoxWidht = parseInt($("#dateTable").width() * 0.14 * 0.98);
	var tdContentHeight = tdHeight - 43;
	var trObj = $("#dateTable tbody tr");
	var tdObj = $("#dateTable tbody tr td");
	for ( var i = 0; i < tdObj.length; i++) {
		$(tdObj[i]).height(tdHeight);
		$(tdObj[i]).width(dateBoxMainDateTDBoxWidht);
		$(tdObj[i]).find(".dateBoxMainDateTDBox").height(tdContentHeight);
	}

	var dateBoxMainDateTDBoxS = $(".dateBoxMainDateTDBox"); 
	for ( var i = 0; i < dateBoxMainDateTDBoxS.length; i++) {
		$(dateBoxMainDateTDBoxS[i]).width(dateBoxMainDateTDBoxWidht);
	}
}
// 鐐瑰嚮鏃ユ湡涓婃湀涓嬫湀浜嬩欢
function getDateClick(action) {
	if (action == 'next') {
		m++;
		if (m > 12) {
			y++;
			m = 1;
		}

	} else {
		m--;
		if (m < 1) {
			m = 12;
			y--;
		}
	}
	var date = y + "-" + m + "-" + 1;
	$("#sp_years").text(y+"年");
	$("#sp_month").text(m+"月");
	getDateData(date);
}
// 鏍规嵁鏃ユ湡锛岃幏鍙栧悗鍙版暟鎹�
function getDateData(date) {
	$.ajax({
		url : '/BPHCenter/dutyCalendarWeb/getCalender.do?orgId=' + m_dutyCalendar_Org.id+"&sessionId="+sessionId
				+ '&date=' + date,
		type : "POST",
		dataType : "json",
		// async:false,
		success : function(req) {
			if (req) {
				changeDivHeight();
				setDateData(req);
			} else { 
				$("body").popjs({"title":"提示","content":"获取数据失败"});   
			}
		}
	});
}
// 鍒濆鍖栨棩鏈熸暟鎹樉绀�
function setDateData(result) {
	// 閺冦儱宸婚弫鐗堝祦缂佸嫯顥婇幋鎰殶缂侊拷
	var dateArray = new Array();
	// var json = eval("(" + result + ")");
	var json = result;
	for ( var i = 0; i < 6; i++) {// 閸掓繂顫愰崠锟�鐞涳拷7閸掓鈹栭弫鐗堝祦娴滃瞼娣弫鎵矋
		dateArray[i] = new Array();
		for ( var j = 0; j < 7; j++) {
			dateArray[i][j] = 0;
		}
	}
	var lineIndexOf = 0;// 閸掓繂顫愰崠鏍х秼閸撳秶绮嶇憗鍛邦攽娑撳鐖�
	for ( var i = 0; i < json.length; i++) {
		dateArray[lineIndexOf][parseInt(json[i]["week"])] = new Array();// 婢圭増妲憀ineIndexOf鐞涘奔绗�week(娴狅綀銆冮崨銊ュ殤閻ㄥ嫪绗呴弽锟�閸掓ぞ绗呴弰顖欑娑擃亝鏌婇弫鎵矋
		var today = new Array();// 閸掓稑缂撴稉锟芥稉顏呮煀閺佹壆绮嶉敍灞借嫙鐎瑰本鏆ｉ弫鐗堝祦闁插秶绮�
		today['y'] = json[i]["y"];
		today['m'] = json[i]["m"];
		today['d'] = json[i]["d"];
		today['totalpolice'] = json[i]["totalpolice"];
		today['dutyList'] = json[i]["dutyList"];
		dateArray[lineIndexOf][parseInt(json[i]["week"])] = today;
		if (parseInt(json[i]["week"]) == 6) {// 閸掋倖鏌囬弰顖氭儊鐠囥儲宕茬悰锟�閼汇儱缍嬮崜宥勭瑓閺嶅洤鍩岄崚鎷屾彧6閸楀啿褰查幑銏ｎ攽+1
			lineIndexOf++;

		}
	}
	PlanArray = dateArray;
	creatHtml(dateArray);// 鐏忓棝鍣哥紒鍕倵閻ㄥ嫭鏆熺紒鍕炊缂佹獘tml闁插秶绮嶉崝鐔诲厴閸戣姤鏆熼敍灞借嫙閹绘帒鍙嗛崚鐧廡ML娑擄拷
	// p(dateArray);
}

function creatHtml(arr) {
	// 閺冦儱宸婚弫鐗堝祦HTML缂佸嫯顥婇柈銊ュ瀻
	var html = "";
	for ( var i = 0; i < 6; i++) {// 瀵邦亞骞嗛弫鎵矋閿涘矂鍣哥紒鍒猼ml
		var trHtml = "<tr  style='vertical-align:top'>";
		for ( var j = 0; j < 7; j++) {

			var tdHtml = '';
			var isHaveData = arr[i][j]["d"] == null ? false : true;

			if (isHaveData == false) {

				tdHtml = '<td><div class="dateBoxMainDateTD"><div class="dateBoxMainDateTDLibOff"></div><div class="dateBoxMainDateTDBox"><ul><li>&nbsp;</li><li>&nbsp;</li><li>&nbsp;</li><li>&nbsp;</li></ul></div></div></td>';

				trHtml = trHtml + tdHtml;

				continue;
			}
			var d = "";
			if (arr[i][j]["d"] < 10) {
				d = "0" + arr[i][j]["d"];
			} else {
				d = arr[i][j]["d"];
			} 
			var nm = m;
			if (m < 10) {
				nm = "0" + m;
			} 
			tdHtml = '<td doc="td_'
					+ i
					+ '_'
					+ j
					+ '" id="date_'
					+ y
					+ '-'
					+ nm
					+ '-'
					+ d
					+ '"><div class="DateBoxbg" id="modeldiv_'
					+ i
					+ '_'
					+ j
					+ '"></div>'
					+ '<div class="pasteBtnBox" id="pasteBtn_'
					+ i
					+ "_"
					+ j
					+ '"  onclick=selectPasteBox("'
					+ y
					+ '-'
					+ nm
					+ '-'
					+ d
					+ '",'
					+ i
					+ ','
					+ j
					+ ') style="display: none;"><a href="javascript:void(0);">粘贴</a></div><div ';
			if (arr[i][j]["totalpolice"] != "<li class='nobaobei' style='display: list-item;'>无报备</li>") {
				tdHtml += ' onmouseover=mouseOverFunction("' + y + '-' + nm
						+ '-' + d + '") onmouseout=mouseOutFunction() ;';
			}
			tdHtml += '  onclick=onClickData("'
					+ y
					+ '-'
					+ nm
					+ '-'
					+ d
					+ '") class="dateBoxMainDateTD"><div class="dateBoxMainDateTDLib">'
					+ arr[i][j]["d"]
					+ '</div><div class="dateBoxMainDateTDBox"><ul id="ulcontent_'
					+ i + '_' + j + '">' + arr[i][j]["totalpolice"]
					+ '<li class="baoBeiBtn">' + '</li>' + '</div>'
					+ ' </ul></div></div>';
			if (arr[i][j]["totalpolice"] != "<li class='nobaobei' style='display: list-item;'>无报备</li>") {
				tdHtml += '<div id="calendarOpratdiv_'
						+ y
						+ '_'
						+ nm
						+ '_'
						+ d
						+ '" onmouseover=mouseOverOpratdiv("'
						+ y
						+ '_'
						+ nm
						+ '_'
						+ d
						+ '") onmouseout=mouseOutOpratdiv("'
						+ y
						+ '_'
						+ nm
						+ '_'
						+ d
						+ '") style="width:100% ;margin-bottom:3px; color:#0000ff; font-size:12px;cursor:pointer;">'
						+ '<a id="copylink_' + y + '_' + nm + '_' + d
						+ '"  onclick=copyDutyByDays("' + y + '-' + nm + '-' + d
						+ '",' + i + ',' + j
						+ ')  style="float:right;margin-right:8px;width:40px;height:15px;">　</a>'
						+ '<a id="dellink_' + y + '_' + nm + '_' + d
						+ '" onclick=deleteDutyConfirm("' + y + '-' + nm + '-'
						+ d + '",' + i + ',' + j
						+ ') style="float:right;width:40px;height:15px;">　</a>' + '</div>';
			}
			tdHtml += '</td>';

			trHtml = trHtml + tdHtml;
		}
		html = html + trHtml + "</tr>";
	}
	$("#dateBody").empty();// 濞撳懐鈹杊tml
	$("#dateBody").append(html);// 閹绘帒鍙唄tml
	changeDivHeight();// 閹绘帒鍙唄tml鐞涖劍鐗告妯哄娑撳秵妲搁懛顏勫З闁倸绨查惃鍕剁礉鐠嬪啰鏁ゆ妯哄鐠嬪啯鏆ｉ崙鑺ユ殶閿涘矁鍤滈柅鍌氱安妤傛ê瀹�
}

var dtime = null;
// 鐐瑰嚮鏃ュ巻鍙锋暟锛岃繘鍏ヨ缁嗘姤澶囬〉闈�
function onClickData(date) {
	dtime = null;
	var dt = date.replace(/-/gm, '');
	if (dt.length == 7) {
		dt = dt.substr(0, 4) + "0" + dt.substr(4, 7);
	}
	dtime = dt; 
	window.location.href="/BPHCenter/dutyRouteWeb/gotoDutyItem.action?sessionId="+sessionId+"&organId="+m_dutyCalendar_Org.id+"&ymd="+dtime;
};
var timeouts;
var timer = 1500;

// 榧犳爣鍦ㄨ繘鍏ユ湁鏁堟棩鍘嗗彿鏁拌〃鏍煎唴锛屼笖鍋滅暀鏃堕棿瓒呰繃1.5S鏃讹紝寮瑰嚭鎶ュ鏄庣粏锛�
function mouseOverFunction(date) {
	dtime = null;
	var dt = date.replace(/-/gm, '');
	if (dt.length == 7) {
		dt = dt.substr(0, 4) + "0" + dt.substr(4, 7);
	}
	dtime = dt;
	timeouts = setTimeout('getDateInfo("' + dt + '")', timer);
	// timeouts=setTimeout(function(){
	// getDateInfo(date);
	// clearTimeout(timeouts);
	// },2*1000);
}
// 榧犳爣绉诲紑浜嬩欢锛屾竻妤氬畾鏃跺櫒锛�
function mouseOutFunction() { 
	window.clearTimeout(timeouts);
}
// 鐐瑰嚮鍏蜂綋鏃ユ湡锛屽姞杞借缁嗕俊鎭璇濇
function getDateInfo(date) {
	$("#txttargetName").val("");
	m_dutyCalendar_Org.date = date;
	m_ymd = YMD.createNew(date);   
	var obj = {
	};
	obj.orgId = m_dutyCalendar_Org.id;
	obj.ymd = date
	InitDutyItemTList(obj);
	var win =$('#dutyItemTList');
	win.kendoWindow({
	        width: "450px",
	        title: "报备明细"
	   });
	win.data("kendoWindow").open();
	window.clearInterval(timeouts);
}

function InitDutyItemTList(pars){
	$.ajax({
				url : "/BPHCenter/dutyWeb/loadDutyByOrgIdAndYMD.do?sessionId="+sessionId,
				type : "POST",
				dataType : "json",
				data : pars,
				async : false,
				success : function(req) {
					if (req.code==200) {// 成功填充数据
						var duty = req.data;  
						reCalcDuty(duty.items);   
					} else {
					$("body").popjs({"title":"提示","content":"获取报备明细数据信息失败!"});  
					}
				}
			});
}
function reCalcDuty(data){
	var item_new=rebuildItems(data);
	reloadItems(item_new);
}
function reloadItems(items){
	var ds = new kendo.data.HierarchicalDataSource({
			    data:items,
			    schema: {
			        model: {
			          children: "items"
			        }
			      }
			});
			
			$("#dutyItemTV").remove();
			$("#dutyItemTVBox").append("<div id='dutyItemTV'></div>");
			
			var tv  = $("#dutyItemTV").kendoTreeView({
				template:kendo.template($("#dutyItem-template").html()),
				dataSource:ds, 
				dataTextField:["displayName"]
			}).data("kendoTreeView");
}
function rebuildItems(items){
var items2=[];
			
			$.each(items, function(i, v) {
				var item =rebuildItem(v,null);
				items2.push(item);
			});
			
			return items2;
			
			function rebuildItem(v,p){
				var v2={};
				v2.id=v.id;
				v2.xid =v.xid;
				v2.name = v.name;
				v2.itemTypeId = v.itemTypeId;
				v2.itemId =v.itemId;
				v2.itemInnerTypeId = v.itemInnerTypeId;
				v2.itemInnerTypeName =v.itemInnerTypeName;
				
				v2.itemTypeName =v.displayName;
				v2.beginTime2=v.beginTime2;
				v2.endTime2=v.endTime2;
				
				v2.beginTime=v.beginTime;
				v2.endTime=v.endTime;
				
				v2.maxPolice = v.maxPolice;
				v2.taskType = v.taskType;
				v2.targets = v.targets;

				v2.getParent = function() {
					return p;
				};
				
				v2.xid =genXId(v2.itemTypeId); //为什么要重新设置xid? 

				if (v2.itemTypeId == 101) {
					initDate(v2);
					if (v2.beginTime2.dateDiffOfDay(v2.endTime2) == 1) {
						v2.isOverDay=true;
					} else {
						v2.isOverDay=false;
					}
				}

				//itemiconCls = createIconStyle(item, item.itemTypeId, item.iconUrl);
				
				/* 初始化数量等于0 */
				v2.velicleCount = 0;
				v2.policeCount = 0;
				v2.weaponCount = 0;
				v2.gpsCount = 0;
				
				switch (v2.itemTypeId) {
				case 1:
					v2.velicleCount = 1;
					break;
				case 2:
					v2.policeCount = 1;
					break;
				case 3:
					v2.weaponCount = 1;
					break;
				case 4:
					v2.gpsCount = 1;
					break;
				}

				if(v.items != null && v.items.length>0){
					v2.items=[];
					$.each(v.items, function(i, val) {
						var nv=rebuildItem(val,v2);
						v2.velicleCount += nv.velicleCount;
						v2.policeCount += nv.policeCount;
						v2.weaponCount += nv.weaponCount;
						v2.gpsCount += nv.gpsCount;
						v2.items.push(nv);
						v2.expanded =true;
					});
				}
				
				v2.displayName =genDisplayName(v2);
				return v2;
			}
}
function genXId (itemTypeId, itemId) {
			m_xid_max++;
			return itemTypeId + "_AI_" + m_xid_max;
		}
function genDisplayName(row){
			//itemTypeId, iteminnerTypeName, name
			var rs = '';
			switch (row.itemTypeId) {
			case 1:
				rs = row.itemInnerTypeName + ":" + row.name;
				break;
			case 2:
				rs = row.itemInnerTypeName + ":" + row.name;
				break;
			case 3:
				rs = row.itemInnerTypeName + ":" + row.name;
				break;
			case 4:
				rs = row.itemInnerTypeName + ":" + row.name;
				break;
			case 100:
				rs =  row.name;
				break;
			case 101:
				var bts =row.beginTime2.getHours() + ":" +row.beginTime2.getMinutes();
				var ets=row.endTime2.getHours() + ":" +row.endTime2.getMinutes();
				rs =  row.name +"  [" + bts +"到" + (row.isOverDay?"第二天":"") + ets +"] ";
				
				break;
			case 999:
				rs = row.itemInnerTypeName + ":" + row.name;
				break;
			}
			var sts=getRowStatistics(row);
			return rs + sts;
		}
function getRowStatistics(row){
			var rs="";
			if( row.policeCount !=null && row.policeCount >0){
				rs += "  警员:"+row.policeCount;
			}
			if( row.velicleCount !=null && row.velicleCount >0){
				rs += "  车辆:"+row.velicleCount;
			}
			if( row.weaponCount !=null && row.weaponCount >0){
				rs += "  武器:"+row.weaponCount;
			}
			if( row.gpsCount !=null && row.gpsCount >0){
				rs += "  定位:"+row.gpsCount;
			}
			
			if(rs !=""){
				rs= "  < " +rs + " >";
			}
			
			return rs;
		}
// 榧犳爣绉诲姩鍒版棩鍘嗗簳閮紝鏄剧ず鍒犻櫎銆佸鍒舵寜閽�
function mouseOverOpratdiv(tags) {
	$("#calendarOpratdiv_" + tags + " a[id='dellink_" + tags + "']").html("删除");
	$("#calendarOpratdiv_" + tags + " a[id='copylink_" + tags + "']").html(
			"复制");
}
// 榧犳爣绉诲紑鏃ュ巻搴曢儴锛岄殣钘忓垹闄ゃ�澶嶅埗鎸夐挳
function mouseOutOpratdiv(tags) {
	$("#calendarOpratdiv_" + tags + " a[id='dellink_" + tags + "']")
			.html("　");
	$("#calendarOpratdiv_" + tags + " a[id='copylink_" + tags + "']").html(
			"　");
}
// 鍒犻櫎鎶ュ
function deleteDutyConfirm(date, i, j) {
	$("body").tyWindow({"content":  "确认删除    " + date + " 的报备数据吗？","center":true,"ok":true,"no":true,"okCallback":function(){ 
		 
	 
			dtime = null;
			var dt = date.replace(/-/gm, '');
			if (dt.length == 7) {
				dt = dt.substr(0, 4) + "0" + dt.substr(4, 7);
			}
			dtime = dt;
			deleteDutyAction(dtime, i, j);
		}
	});
}
function deleteDutyAction(dt, i, j) {
	$
			.ajax({
				url : "/BPHCenter/dutyCalendarWeb/deleteDutyByYMD.do?sessionId="+sessionId,
				type : "POST",
				dataType : "json",
				data : {
					"ymd" : dt,
					"orgId" : m_dutyCalendar_Org.id
				},
				async : false,
				success : function(req) {
					if (req.code==200) {// 鎴愬姛濉厖鏁版嵁
						var y = dt.substring(0, 4);
						var m = dt.substring(4, 6);
						var d = dt.substring(6, 9);
						var html = '<li class="nobaobei" style="display: list-item;">无报备</li>';
						// html += '<li class="baoBeiBtn">'
						// + '<div class="pasteBtnBox" id="pasteBtn_'
						// + i
						// + "_"
						// + j
						// + '" onclick=selectPasteBox("'
						// + y
						// + '-'
						// + m
						// + '-'
						// + d
						// + '",'
						// + i
						// + ','
						// + j
						// + ') style="display: none;"><a
						// href="javascript:void(0);">绮樿创</a></div>'
						// + '</div></li>';
						$("#ulcontent_" + i + "_" + j).html(html);

					} else {
						$("body").popjs({"title":"提示","content":"报备信息删除失败"});  
					}
				}
			});
}
var pasteDate = "";
var copyX = 0;// 瑕佸鍒舵暟缁勭殑X涓嬫爣
var copyY = 0;// 瑕佸鍒舵暟缁勭殑Y涓嬫爣
var PlanArray = new Array();// 鎶ュ鎯呭喌鏁扮粍锛岃褰曟瘡澶╃殑鎶ュ鎯呭喌
function copyDutyByDays(date, i, j) {
	pasteDate = "";
	copyX = i;
	copyY = j;
	var dt = date.replace(/-/gm, '');
	pasteDate = dt;

	for ( var i = 0; i < PlanArray.length; i++) {
		for ( var j = 0; j < PlanArray[i].length; j++) {

			var obj = $("td[doc='td_" + i + "_" + j + "']");
			var LT = getPasteBtnBoxWidthHeight();
			if (i == copyX) {// 鍚屼竴琛岋紝涔嬪垽鏂垪
				if (j > copyY) {
					$(obj).find('div[class=DateBoxbg]').each(function() { // 閬僵
						$(this).css('display', 'block');
					});
					$(obj).find('div[class=pasteBtnBox]').each(function() { // 閬僵
						$(this).css('left', LT[0]);
						$(this).css('top', LT[1]);
						$(this).show();
					});
					$("#pasteBtn_" + i + "_" + j).show();

				}
			} else if (i > copyX) {// 涓嬩竴琛岋紝鐩存帴杩藉姞div
				// var obj=$("#pasteBtn_" + i+"_"+j).parent().parent();
				// $(obj).find('li[class=nobaobei]').hide();
				$(obj).find('div[class=DateBoxbg]').each(function() { // 閬僵
					$(this).css('display', 'block');
				});
				$(obj).find('div[class=pasteBtnBox]').each(function() { // 閬僵
					$(this).css('left', LT[0]);
					$(this).css('top', LT[1]);
					$(this).show();
				});
				$("#pasteBtn_" + i + "_" + j).show();

			}

		}

	}

	// $('div[class=DateBoxbg]').each(function(){ //閬僵
	// $(this).css('display','block');
	// });
	// var LT=getPasteBtnBoxWidthHeight();
	// $('div[class=pasteBtnBox]').each(function(){
	// $(this).css('left',LT[0]);
	// $(this).css('top',LT[1]);
	// $(this).show();
	// });

}
// 璁＄畻娴忚鍣ㄩ珮搴︼紝璁＄畻琛岄珮
function getPasteBtnBoxWidthHeight() {

	var arr = new Array();
	$("#dateBody TD").each(function() {
		var h = parseInt($(this).height());
		var w = parseInt($(this).width());
		var top = (h - 25) / 2;
		var left = (w - 69) / 2;
		arr[0] = left;
		arr[1] = top;
		return arr;
		return false;
	});
	return arr;
}
// 绮樿创鎸夐挳浜嬩欢
function selectPasteBox(date, i, j) {
	var dt = date.replace(/-/gm, '');

	if (dt.length == 7) {
		dt = dt.substr(0, 4) + "0" + dt.substr(4, 7);
	}
	if (pasteDate.length == 7) {
		pasteDate = pasteDate.substr(0, 4) + "0" + pasteDate.substr(4, 7);
	}
	var pars = {
		orgId : m_dutyCalendar_Org.id,
		ymd : pasteDate,
		targetYmd : dt
	};
	$.ajax({
		url : "/BPHCenter/dutyCalendarWeb/copyDutyByOrgIdAndYMD.do?sessionId="+sessionId,
		type : "POST",
		dataType : "json",
		data : pars,
		// async : false,
		success : function(req) {
			if (req.code==200) {// 鎴愬姛濉厖鏁版嵁
				var html = $("#ulcontent_" + copyX + "_" + copyY).html();
				$("#ulcontent_" + i + "_" + j).html(html);
				$("#modeldiv_" + i + "_" + j).css('display', 'none');
				var obj = $("#ulcontent_" + i + "_" + j).find(
						"div[class='pasteBtnBox']");
				obj.attr("id", "pasteBtn_" + i + "_" + j);
				obj.attr("onclick", "selectPasteBox('" + date + "'," + i + ","
						+ j + ")");
				$("#pasteBtn_" + i + "_" + j).hide();
			} else { 
				$("body").popjs({"title":"提示","content":"报备信息复制失败"}); 
			}
		}
	});

} 
function fmtDigit(value, row, index) {
	if (value == 0)
		return "";
	else
		return value;
}

function fmtShiftPeriod(value, row, index) {
	var result = "";

	if (row.itemTypeId == 101 && row.beginTime2 != undefined
			&& row.beginTime2 != null) {
		result = row.beginTime2.getHours() + ":" + row.beginTime2.getMinutes()
				+ "至";
		var diff = row.beginTime2.dateDiffOfDay(row.endTime2);

		switch (diff) {
		case 0:
			result += row.endTime2.getHours() + ":" + row.endTime2.getMinutes();
			break;
		case 1:
			result += "明日" + row.endTime2.getHours() + ":"
					+ row.endTime2.getMinutes();
			break;
		default:
			result = "起止时间错误!";
		}

		return result;
	}
}

/**
 * 鍒濆鍖栨棩鏈�
 * 
 * @param ymd
 * @param item
 */
function initDate(item) {

	if (item.beginTime2 == undefined || item.endTime2 == undefined) {
		var b = gCreateDate(item.beginTime);
		var e = gCreateDate(item.endTime);

		var diffDay = b.dateDiffOfDay(e);

		if (diffDay > 1) { 
			$("body").popjs({"title":"提示","content":"date diff day is error !"}); 
		}

		b.setFullYear(m_ymd.getYear(), m_ymd.getMonth() - 1, m_ymd.getDay());
		e.setFullYear(m_ymd.getYear(), m_ymd.getMonth() - 1, m_ymd.getDay());
		e.add('d', diffDay);

		item.beginTime2 = b;
		item.endTime2 = e;
	}
}
var YMD = {
	createNew : function(ymd) {
		var _ymd = {};
		_ymd.ymd = ymd;

		var year = Number(ymd.substr(0, 4));
		var month = Number(ymd.substr(4, 2));
		var day = Number(ymd.substr(6, 2));

		_ymd.getYear = function() {
			return year;
		};
		_ymd.getMonth = function() {
			return month;
		};
		_ymd.getDay = function() {
			return day;
		};
		return _ymd;
	}
};

// function btnExportToExcelAction() {
// var obj = $('#tgddutydetailsforday').treegrid("getData");
// createExcelApplication(obj);
// };

// 瀵煎嚭鍏蜂綋鏃ユ湡鐨勬姤澶囨槑缁�
function btnExportAction() {
	$.ajax({
		url : "dutyCalendar/exportDataToExcle.do",
		type : "POST",
		dataType : "json",
		async : false,
		timeout : 60000,
		data : {
			orgId : m_dutyCalendar_Org.id,
			ymd : m_dutyCalendar_Org.date
		},
		success : function(req) {
			if (req.isSuccess) {
				var urlStr = req.Data.substring(1, req.Data.length);
				if (/msie/.test(navigator.userAgent.toLowerCase())) {
					var b_version = navigator.appVersion;
					if (b_version.length > 0) {
						var s = b_version.split(';');
						if (s.length > 1) {
							if ($.trim(s[1]) == "MSIE 8.0"
									|| $.trim(s[1]) == "MSIE 9.0"
									|| $.trim(s[1]) == "MSIE 10.0") {
								urlStr = "../../" + urlStr;
							}
						}
					}
				} else {
					var b_version = navigator.appVersion;
					if (b_version.length > 2) {
						var s = b_version.split(';');
						if (s.length > 2) {
							urlStr = "../../" + urlStr;
						}
					}

				}
				window.location.href = urlStr;
			}
		},
		failer : function(a, b) {
			$("body").popjs({"title":"提示","content":a});  
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			$("body").popjs({"title":"提示","content":errorThrown});   
		}
	});
};
// 娓呴櫎褰撴湀鎵�湁鎶ュ鏁版嵁
function clearAlldutyData() {
	$("body").tyWindow({"content": "确认删除    " + y + "年" + m + "月" + " 的所有报备数据吗？","center":true,"ok":true,"no":true,"okCallback":function(){ 
		
			 
					deleteAllDutyDataAction(y, m);
				}
			});
};
function deleteAllDutyDataAction(year, month) {
	$.ajax({
		url : "/BPHCenter/dutyCalendarWeb/deleteAllDutyData.do?sessionId="+sessionId,
		type : "POST",
		dataType : "json",
		data : {
			orgId : m_dutyCalendar_Org.id,
			year : year,
			month : month
		},
		success : function(req) {
			if(req.code==200){
				var date = year + "-" + month + "-" + 1;
				getDateData(date);
			}
			else{
				$("body").popjs({"title":"提示","content":"清空报备数据失败"});   
			}
		},
		failer : function(a, b) {
			$("body").popjs({"title":"提示","content":a});    
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			$("body").popjs({"title":"提示","content":errorThrown});    
		}
	});
};

// 娓呴櫎绮樿创妯℃澘锛屾竻绌哄壀鍒囨澘
function clearClipbord() {
	$('div[class=pasteBtnBox]').each(function() { // 寮�閬嶅巻
		$(this).hide();
	});
	$('div[class=DateBoxbg]').each(function() { // 閬僵
		$(this).css('display', 'none');
	});
};
function btnSearchAction() {
//	var name = $('#txttargetName').val();
//	if (name != "") {
//		getDateInfo(m_dutyCalendar_Org.date);
//		var a = findDutyPoint(name);
//		$('#tgddutydetailsforday').treegrid("loadData", a);
//	} else {
//		getDateInfo(m_dutyCalendar_Org.date);
//	}
};

function findDutyPoint(name) {
	var a = [];
	if (m_duty.items != null) {
		$.each(m_duty.items, function(index, value) {
			var o = findDutyTreeGrid(value, name);
			if (o != null) {
				a.push(o);
			}
		});
	}
	return a;
}

function findDutyTreeGrid(item, xname) {
	if (xname == "" || item.displayName.indexOf(xname) >= 0) {
		return item;
	} else {
		var ls = [];
		if (item.children != null && item.children.length > 0) {
			$.each(item.children, function(index, value) {
				var o = findDutyTreeGrid(value, xname);
				if (o != null) {
					ls.push(o);
				}
			});
			item.children = ls;
			if (ls.length > 0)
				return item;
			else
				return null;
		} else {
			return null;
		}
	}
}

function mouseOut() {
	$("body").popjs({"title":"提示","content":"1"});   
	//$("#dutyDetailsForDaywindow").window("close");
}
function mouseOver() {
	$("body").popjs({"title":"提示","content":"2"}); 
	//$("#dutyDetailsForDaywindow").window("open");
}