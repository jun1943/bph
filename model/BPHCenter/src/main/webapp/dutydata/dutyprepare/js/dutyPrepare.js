var sessionId = $("#token").val();
var ymd = 20150103;
var bph_dutyPrepare_OrgId = $("#organId").val();

function loadData(pageNo){ 
	
} 

$(function() {
	 DutyPraperManage.initCtl();
	 $("#calendar").kendoCalendar({
         change: DutyPraperManage.onSelectDateToCopy
     });
	 
});

var DutyPraperManage = {
	initCtl:function(){
		this.initDutyTypeWindow();
		this.initResourceTabStrip();
		this.initDutyItemList();
	},
	initDutyTypeWindow:function(){
		$("#DutyTypetreeList").kendoTreeList({
			columns : [{
			field : "id",
			title : "id",
			hidden: true
		} ,{
			field : "name",
			expandable: true,
			title : "名称",
			width : 150
		} , {
			title : "人数上限",
			field : "maxPolice",
			align : 'left',
			width : 80
		}],
		selectable: "row",
		height:300
		});
		$("#DutyTypetreeList").delegate("tbody>tr", "dblclick", this.dutyTypeTreeListDblClick);
		
	},
	dutyTypeTreeListDblClick:function(){
		
	},
	initResourceTabStrip:function(){
		$("#tabstrip-sprites").kendoTabStrip({
        	   animation: { open: { effects: "fadeIn"} },
               dataTextField: "text",
               dataSpriteCssClass: "spriteCssClass",
               dataContentField: "content",
               dataSource: [{
                       text: "警员",
                       spriteCssClass: "brazilFlag",
                       content: "<div id='policeSourceTreeList'></div>"
                   },{
                       text: "警车",
                       spriteCssClass: "indiaFlag",
                       content: "<div id='vehicleSourceTreeList'></div>"
                   },{
                       text: "武器",
                       spriteCssClass: "netherlandsFlag",
                       content: "<div id='weaponSourceTreeList'></div>"
                   },{
                       text: "定位设备",
                       spriteCssClass: "netherlandsFlag",
                       content: "<div id='gpsSourceTreeList'></div>"
                   }]
           }).data("kendoTabStrip").select(0);
                
           DutyPraperManage.initPoliceResource();
           DutyPraperManage.initVehicleResource();
           DutyPraperManage.initWeaponResource();
           DutyPraperManage.initGpsResource();
           
	},
	bph_police_query:{},
	packagePolQuery:function(){
		DutyPraperManage.bph_police_query.orgId = $("#organId").val();
		DutyPraperManage.bph_police_query.orgCode = $("#organCode").val();
		DutyPraperManage.bph_police_query.orgPath = $("#organPath").val();
		DutyPraperManage.bph_police_query.name = "";//$("#policeresName").val();
		DutyPraperManage.bph_police_query.typeId = "";
		DutyPraperManage.bph_police_query.groupId = "";  
	},
	initPoliceResource:function(){
		DutyPraperManage.packagePolQuery();
		
		$("#policeSourceTreeList").kendoTreeList({
			toolbar: kendo.template($("#polContemplate").html()),
				columns : [{
					field : "id",
					title : "id",
					hidden: true
				} ,{
					field : "name", 
					title : "名称" 
				} , {
					title : "所属机构",
					field : "orgName"
					} ],
                selectable: "multiple row"
			});
		
		$.ajax({
			url : "/BPHCenter/dutyResourceWeb/getPoliceSource.do?sessionId="+sessionId,
			type : "POST",
			dataType : "json",
			data : {
						"police_Query" : JSON.stringify(DutyPraperManage.bph_police_query)
					},
			success : function(req) {
				if(req.code == 200){
					if(req.data != null){
						$("#policeSourceTreeList").data("kendoTreeList").setDataSource(req.data);
					} 
				}
			}
		}); 
	},
	polGroupResData:null,
	polTypeResData:null,
	selectPolResCondition:function(){
		$.ajax({
			url : "/BPHCenter/dutyResourceWeb/getPoliceGrouplist.do?sessionId="+sessionId,
					type : "post",
					data : {
						"orgId" : bph_dutyPrepare_OrgId
					},
					dataType : "json",
					success:function(req){
						if(req.code==200){
							if(req.data!=null){
								DutyPraperManage.polGroupResData = req.data;
							}
						}else{
							$("body").popjs({"title":"提示","content":"获取警员分组查询条件失败"}); 
						}
					} 
		});
		$.ajax({
			url : "/BPHCenter/dutyResourceWeb/getPoliceTypeList.do?sessionId="+sessionId,
					type : "post", 
					dataType : "json",
					success:function(req){
						if(req.code==200){
							if(req.data!=null){
								DutyPraperManage.polTypeResData = req.data;
							}
						}else{
							$("body").popjs({"title":"提示","content":"获取警员类型查询条件失败"}); 
						}
					} 
		});
				 $("#polGroupgrid").kendoGrid({
                         dataSource: {
                            data: DutyPraperManage.polGroupResData
                        }, 
						sortable : true,
                        selectable: "multiple row", 
                        columns: [{
									title : 'id',
									field : 'id',
									hidden: true
								},{
									title : '组名称',
									field : 'name'
								}] 
                    });
                     $("#polTypegrid").kendoGrid({
                         dataSource: {
                            data: DutyPraperManage.polTypeResData
                        }, 
						sortable : true,
                        selectable: "multiple row", 
                        columns: [{
									title : 'id',
									field : 'id',
									hidden: true
								},{
									title : '类型名称',
									field : 'name'
								}]
                    });
		  var polResConWindow = $("#polResConWindow");
		  if (!polResConWindow.data("kendoWindow")) {
                        polResConWindow.kendoWindow({
                            width: "400px",
                            title: "警员资源过滤条件",
                            actions: [ 
                                "Close"
                            ]
                        });
                    }  
	},
	searchPoliceRescource:function(){ 
		DutyPraperManage.bph_police_query.orgId = $("#organId").val();
		DutyPraperManage.bph_police_query.orgCode = $("#organCode").val();
		DutyPraperManage.bph_police_query.orgPath = $("#organPath").val();
		DutyPraperManage.bph_police_query.name = $("#policeresName").val();
		
		
		
		DutyPraperManage.bph_police_query.typeId = "";
		DutyPraperManage.bph_police_query.groupId = ""; 
	},
	bph_vehicle_query:{},
	packageVelQuery:function(){
		DutyPraperManage.bph_vehicle_query.orgId = $("#organId").val();
		DutyPraperManage.bph_vehicle_query.orgCode = $("#organCode").val();
		DutyPraperManage.bph_vehicle_query.orgPath = $("#organPath").val();
		DutyPraperManage.bph_vehicle_query.number = "";//$("#vehicleresName").val();
		DutyPraperManage.bph_vehicle_query.typeId = "";
		DutyPraperManage.bph_vehicle_query.groupId = ""; 
	 
	},
	initVehicleResource:function(){
		DutyPraperManage.packageVelQuery();
		$.ajax({
			url : "/BPHCenter/dutyResourceWeb/getVehicleSource.do?sessionId="+sessionId,
			type : "POST",
			dataType : "json",
			data : {
						"vehicle_Query" : JSON.stringify(DutyPraperManage.bph_vehicle_query)
					},
			success : function(req) {
				if(req.code == 200){
					if(req.data != null){
						for(var i = 0; i<req.data.length;i++)
						{
							var obj = req.data[i]; 
							obj.parentId = null; 
						}
						var dtdatatemp = JSON.stringify(req.data);
                $("#vehicleSourceTreeList").kendoTreeList({
						 dataSource: {
             				data:req.data
             			},
						 
						  toolbar: kendo.template($("#vehContemplate").html()),
							columns : [{
								field : "id",
								title : "id",
								hidden: true
							} , {
								field : "number", 
								title : "车牌号码" 
							} , {
								title : "所属机构",
								field : "orgName"
							} ],
                        selectable: "multiple row"
						});
					} 
				}
			}
		}); 
	}, 
	vehGroupResData:null,
	vehTypeResData:null,
	selectVelResCondition:function(){
		$.ajax({
			url : "/BPHCenter/dutyResourceWeb/getVehicleGrouplist.do?sessionId="+sessionId,
					type : "post",
					data : {
						"orgId" : bph_dutyPrepare_OrgId
					},
					dataType : "json",
					success:function(req){
						if(req.code==200){
							if(req.data!=null){
								DutyPraperManage.vehGroupResData = req.data;
							}
						}else{
							$("body").popjs({"title":"提示","content":"获取警员分组查询条件失败"}); 
						}
					} 
		});
		$.ajax({
			url : "/BPHCenter/dutyResourceWeb/getvehicleTypelist.do?sessionId="+sessionId,
					type : "post", 
					dataType : "json",
					success:function(req){
						if(req.code==200){
							if(req.data!=null){
								DutyPraperManage.vehTypeResData = req.data;
							}
						}else{
							$("body").popjs({"title":"提示","content":"获取警员类型查询条件失败"}); 
						}
					} 
		}); 
		 			 $("#vehGroupgrid").kendoGrid({
                 		 dataSource: {
                            data: DutyPraperManage.vehGroupResData
                        }, 
						sortable : true,
                        selectable: "multiple row", 
                        columns: [{
									title : 'id',
									field : 'id',
									hidden: true
								},{
									title : '组名称',
									field : 'name'
								}] 
                    });
                     $("#vehTypegrid").kendoGrid({
                        dataSource: {
                            data: DutyPraperManage.vehTypeResData
                        }, 
						sortable : true,
                        selectable: "multiple row",
                        columns: [{
									title : 'id',
									field : 'id',
									hidden: true
								},{
									title : '类型名称',
									field : 'name'
								}]
                    });
		  var vehResConWindow = $("#vehResConWindow");
		  if (!vehResConWindow.data("kendoWindow")) {
                        vehResConWindow.kendoWindow({
                            width: "400px",
                            title: "车辆资源过滤条件",
                            actions: [ 
                                "Close"
                            ]
                        });
                    }  
	},
	searchVehicleRescource:function(){
		DutyPraperManage.bph_vehicle_query.orgId = $("#organId").val();
		DutyPraperManage.bph_vehicle_query.orgCode = $("#organCode").val();
		DutyPraperManage.bph_vehicle_query.orgPath = $("#organPath").val();
		DutyPraperManage.bph_vehicle_query.number = $("#vehicleresName").val();
		DutyPraperManage.bph_vehicle_query.typeId = "";
		DutyPraperManage.bph_vehicle_query.groupId = ""; 
	},
	bph_weapon_query:{},
	packageWepQuery:function(){
		DutyPraperManage.bph_weapon_query.orgId = $("#organId").val();
		DutyPraperManage.bph_weapon_query.orgCode = $("#organCode").val();
		DutyPraperManage.bph_weapon_query.orgPath = $("#organPath").val();
		DutyPraperManage.bph_weapon_query.number = "";//$("#weaponresName").val();
		DutyPraperManage.bph_weapon_query.typeId = "";
		DutyPraperManage.bph_weapon_query.groupId = "";  
	},
	initWeaponResource:function(){
		DutyPraperManage.packageWepQuery();
		$.ajax({
			url : "/BPHCenter/dutyResourceWeb/getWeaponSource.do?sessionId="+sessionId,
			type : "POST",
			dataType : "json",
			dataType : "json",
			data : {
						"weapon_Query" : JSON.stringify(DutyPraperManage.bph_weapon_query)
					},
			success : function(req) {
				if(req.code == 200){
					if(req.data != null){
						for(var i = 0; i<req.data.length;i++)
						{
							var obj = req.data[i]; 
							obj.parentId = null; 
						}
						var dtdatatemp = JSON.stringify(req.data);
                $("#weaponSourceTreeList").kendoTreeList({
						 dataSource: {
             				data:req.data
             			},
						 
						  toolbar: kendo.template($("#wepContemplate").html()),
							columns : [{
								field : "id",
								title : "id",
								hidden: true
							} ,{
								field : "typeName", 
								title : "武器类型" 
							} , {
								title : '武器编号',
								field : 'number' 
							}, {
								title : '所属机构',
								field : 'orgName' 
							} ],
                        selectable: "multiple row"
						});
					} 
				}
			}
		}); 
	},
	wepGroupResData:null,
	wepTypeResData:null,
	selectWepResCondition:function(){
		$.ajax({
			url : "/BPHCenter/dutyResourceWeb/getWeaponGrouplist.do?sessionId="+sessionId,
					type : "post",
					data : {
						"orgId" : bph_dutyPrepare_OrgId
					},
					dataType : "json",
					success:function(req){
						if(req.code==200){
							if(req.data!=null){
								DutyPraperManage.wepGroupResData = req.data;
							}
						}else{
							$("body").popjs({"title":"提示","content":"获取警员分组查询条件失败"}); 
						}
					} 
		});
		$.ajax({
			url : "/BPHCenter/dutyResourceWeb/getWeaponTypelist.do?sessionId="+sessionId,
					type : "post", 
					dataType : "json",
					success:function(req){
						if(req.code==200){
							if(req.data!=null){
								DutyPraperManage.wepTypeResData = req.data;
							}
						}else{
							$("body").popjs({"title":"提示","content":"获取警员类型查询条件失败"}); 
						}
					} 
		}); 
		 $("#wepGroupgrid").kendoGrid({ 
                        dataSource: {
                            data: DutyPraperManage.wepGroupResData
                        }, 
						sortable : true,
                        selectable: "multiple row",
                        columns: [{
									title : 'id',
									field : 'id',
									hidden: true
								},{
									title : '组名称',
									field : 'name'
								}] 
                    });
                     $("#wepTypegrid").kendoGrid({
                          dataSource: {
                            data: DutyPraperManage.wepTypeResData
                        }, 
						sortable : true,
                        selectable: "multiple row",
                        columns: [{
									title : 'id',
									field : 'id',
									hidden: true
								},{
									title : '类型名称',
									field : 'name'
								}]
                    });
		  var wepResConWindow = $("#wepResConWindow");
		  if (!wepResConWindow.data("kendoWindow")) {
                        wepResConWindow.kendoWindow({
                            width: "400px",
                            title: "车辆资源过滤条件",
                            actions: [ 
                                "Close"
                            ]
                        });
                    }  
	},
	searchWeaponRescource:function(){
		DutyPraperManage.bph_weapon_query.orgId = $("#organId").val();
		DutyPraperManage.bph_weapon_query.orgCode = $("#organCode").val();
		DutyPraperManage.bph_weapon_query.orgPath = $("#organPath").val();
		DutyPraperManage.bph_weapon_query.number = $("#weaponresName").val();
		DutyPraperManage.bph_weapon_query.typeId = "";
		DutyPraperManage.bph_weapon_query.groupId = "";  
	},
	bph_gps_query:{},
	packageGpsQuery:function(){
		DutyPraperManage.bph_gps_query.orgId = $("#organId").val();
		DutyPraperManage.bph_gps_query.orgCode = $("#organCode").val();
		DutyPraperManage.bph_gps_query.orgPath = $("#organPath").val();
		DutyPraperManage.bph_gps_query.gpsname = "";//$("#gpsresName").val();
		DutyPraperManage.bph_gps_query.typeId = "";
		DutyPraperManage.bph_gps_query.groupId = "";  
	},
	initGpsResource:function(){
		DutyPraperManage.packageGpsQuery();
		$.ajax({
			url : "/BPHCenter/dutyResourceWeb/getGpsSource.do?sessionId="+sessionId,
			type : "POST",
			dataType : "json",
			data : {
						"gps_Query" : JSON.stringify(DutyPraperManage.bph_gps_query)
					},
			success : function(req) {
				if(req.code == 200){
					if(req.data != null){
						for(var i = 0; i<req.data.length;i++)
						{
							var obj = req.data[i]; 
							obj.parentId = null; 
						}
						var dtdatatemp = JSON.stringify(req.data);
                $("#gpsSourceTreeList").kendoTreeList({
						 dataSource: {
             				data:req.data
             			},
						 
						  toolbar: kendo.template($("#gpsContemplate").html()),
							columns : [{
								field : "id",
								title : "id",
								hidden: true
							} ,{
								field : "typeName", 
								title : "类型" 
							} ,{
								title : '显示名称',
								field : 'gpsName' 
							} , {
								title : '设备编号',
								field : 'number' 
							},{
								title : "所属单位",
								field : "orgName"
							} ],
                        selectable: "multiple row"
						});
					} 
				}
			}
		}); 
	},
	gpsGroupResData:null,
	gpsTypeResData:null,
	selectGpsResCondition:function(){
		$.ajax({
			url : "/BPHCenter/dutyResourceWeb/getGpsGrouplist.do?sessionId="+sessionId,
					type : "post",
					data : {
						"orgId" : bph_dutyPrepare_OrgId
					},
					dataType : "json",
					success:function(req){
						if(req.code==200){
							if(req.data!=null){
								DutyPraperManage.gpsGroupResData = req.data;
							}
						}else{
							$("body").popjs({"title":"提示","content":"获取警员分组查询条件失败"}); 
						}
					} 
		});
		$.ajax({
			url : "/BPHCenter/dutyResourceWeb/getGpsTypelist.do?sessionId="+sessionId,
					type : "post", 
					dataType : "json",
					success:function(req){
						if(req.code==200){
							if(req.data!=null){
								DutyPraperManage.gpsTypeResData = req.data;
							}
						}else{
							$("body").popjs({"title":"提示","content":"获取警员类型查询条件失败"}); 
						}
					} 
		}); 
		  $("#gpsGroupgrid").kendoGrid({
                        dataSource: {
                            data: DutyPraperManage.gpsGroupResData
                        }, 
						sortable : true,
                        selectable: "multiple row",
                        columns: [{
									title : 'id',
									field : 'id',
									hidden: true
								},{
									title : '组名称',
									field : 'name'
								}] 
                    });
                     $("#gpsTypegrid").kendoGrid({
                        dataSource: {
                            data: DutyPraperManage.gpsTypeResData
                        }, 
						sortable : true,
                        selectable: "multiple row",
                        columns: [{
									title : 'id',
									field : 'id',
									hidden: true
								},{
									title : '类型名称',
									field : 'name'
								}]
                    });
		  var gpsResConWindow = $("#gpsResConWindow");
		  if (!gpsResConWindow.data("kendoWindow")) {
                        gpsResConWindow.kendoWindow({
                            width: "400px",
                            title: "定位设备资源过滤条件",
                            actions: [ 
                                "Close"
                            ]
                        });
                    }
	},
	searchGpsRescource:function(){ 
		DutyPraperManage.bph_gps_query.orgId = $("#organId").val();
		DutyPraperManage.bph_gps_query.orgCode = $("#organCode").val();
		DutyPraperManage.bph_gps_query.orgPath = $("#organPath").val();
		DutyPraperManage.bph_gps_query.gpsname = $("#gpsresName").val();
		DutyPraperManage.bph_gps_query.typeId = "";
		DutyPraperManage.bph_gps_query.groupId = "";  
	},
	initDutyItemList:function(){
		$("#dutyItemList").kendoTreeList({
			 toolbar: kendo.template($("#dutyItemtemplate").html()),
			columns : [{
				title : 'xid',
				field : 'xid',
				width : 0,
				hidden : true
			},{
				field : "id",
				title : "id",
				hidden: true
			} ,{
				title : '人数限制',
				field : 'maxpolice',
				hidden : true
			} ,{
				title : '名称',
				field : 'displayName' 
			} , {
				title : '类型',
				field : 'itemInnerTypeName' 
			} ,  {
				title : '时间区间', 
				template: '<label>DutyPraperManage.formatShiftTime(#: beginTime #)</label>'
			} ,  {
				title : '类型',
				field : 'velicleCount' 
			} ,  {
				title : '警员',
				field : 'policeCount'
			} ,  {
				title : '武器',
				field : 'weaponCount'
			} ,  {
				title : '定位',
				field : 'gpsCount'
			} ,  {
				title : '操作',
				template : "<button type='button' class='ty-delete-btn' id='#: id #' title='删除' onclick='DutyPraperManage.deleteThisNode(#: xid #,#: name #,#: itemTypeId #)'>删除</button> ",
				width : 120
			} ],
			selectable: "row" 
		});
		
//		$.ajax({
//			url : "/BPHCenter/dutyWeb/getDutylist.do?sessionId="+sessionId,
//			type : "POST",
//			dataType : "json",
//			success : function(req) {
//				if(req.code == 200){
//					if(req.data != null){
//						for(var i = 0; i<req.data.length;i++)
//						{
//							var obj = req.data[i];
//							if(obj.parentId ==0)
//							{
//								obj.parentId = null;
//							} 
//						}
//						var dtdatatemp = JSON.stringify(req.data);
                
	},
	deleteThisNode:function(objId,objname,objtypeId){
		
	},
	selectDutyType : function(){
		
	 	$.ajax({
			url : "/BPHCenter/dutyTypeWeb/getDutyTypelist.do",
			type : "POST",
			dataType : "json",
			async : false,
			success : function(req) {
				if(req.code == 200){
					if(req.data != null){
						//[{id:1,name:'a1',parentId:null},{id:2,name:"a2",parentId:1}]
						$.each(req.data, function(index, value) {
							if(value.parentId==0)
								value.parentId=null;
							});
						var ds = new kendo.data.TreeListDataSource({
							data:req.data,
							schema: {
	                            model: {
	                                id: "id",
	                                expanded: true
	                            }
	                        }
						});
						var dutyTypeTreeList=$("#DutyTypetreeList").data("kendoTreeList");
						
						dutyTypeTreeList.setDataSource(ds);
					} 
				}
			}
		});
		

				
		
		
		var win =$('#windowDutyType');
		win.kendoWindow({
                        width: "450px",
                        title: "123"
                    });
		win.data("kendoWindow").open();


	},
	getProperty:function(data){
		if (data == null || data.length == 0)
			return "";
		var rs = "";
		for (var item in data) 
			if (data[item].name != null){
				rs += data[item].name + ";"
			}
		return rs;
	},
	contactName:function(value){
		var showValue = "";
		switch (parseInt(value)) {
			case 1:
				showValue = '社区';break;
			case 2:
				showValue = '巡区';break;
			case 3:
				showValue = '卡点';break;
			default:
				showValue = '';
		}
		return showValue;
	},
	ondTypeWindowClose:function(){
		alert("勤务类型选择");
	},
	selectDutyTemplete:function(){
		 $("#Templetegrid").kendoGrid({
                        dataSource: {
                            data: null,
                            schema: {
                                model: {
                                    fields: {
                                        ProductName: { type: "string" },
                                        UnitPrice: { type: "number" },
                                        UnitsInStock: { type: "number" },
                                        Discontinued: { type: "boolean" }
                                    }
                                }
                            },
                            pageSize: 20
                        },
                        toolbar: kendo.template($("#dutytemplatetb").html()),
                        height: 250,
                        scrollable: true,
                        sortable: true,
                        filterable: true,
                        pageable: {
                            input: true,
                            numeric: false
                        },
                        columns: [
                            "ProductName", 
                            "UnitPrice",
                            "UnitsInStock",
                            "Discontinued"
                        ] 
                    });
		  var windowTemplete = $("#windowTemplete");
		  if (!windowTemplete.data("kendoWindow")) {
                        windowTemplete.kendoWindow({
                            width: "400px",
                            title: "报备模板选择",
                            actions: [ 
                                "Close"
                            ]
                        });
                    } 
	},
	sureSelectdutyTemp:function(){
		alert("选择报备模板成功，执行treelist追加列表");
	},
	copyOfDuty:function(){
		  var windowCpDate = $("#windowCpDate");
		  if (!windowCpDate.data("kendoWindow")) {
                        windowCpDate.kendoWindow({
                            width: "400px",
                            title: "报备复制",
                            actions: [ 
                                "Close"
                            ]
                        });
                    }
	},
	onSelectDateToCopy:function(){
		var s  = kendo.toString(this.value(), 'd');
		alert(s);
	},
	clearDuty:function(){
		$("body").tyWindow({"content":"确定要清空所有报备信息?","center":true,"ok":true,"no":true,"okCallback":function(){ 
				alert("清空所有报备信息");
			}
		});	
	},
	saveDutyAsTemplete:function(){
		
	},
	saveDuty:function(){
	
	},
	exportDuty:function(){
	
	}
};