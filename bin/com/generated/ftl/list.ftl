<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
	<head>
	<meta charset="utf-8" />
	<!--#include virtual="/root.jsp"  -->
	<title>customerInfo</title>
	<!--#include virtual="/include.html"  -->
	</head>
	<body>
		<div class="page-content">
			<div class="table-responsive">
				<!-- PAGE CONTENT BEGINS -->
				<form id="queryForm" onsubmit="return false;">
					<div class="widget-box">
						<div class="widget-header widget-header-flat search_tj_bar_tit">
							<h5 class="widget-title">查询条件</h5>
						</div>
						<div class="row search_tj_bar">
							<div class="row search_tj_bar">
								<div class="col-xs-12">
									<div class="center">
										<div class="row">
											<div class="col-xs-4">
												<span> <label class="col-xs-12 col-sm-4 label_text">车辆编号:</label>
													<div class="input-group col-xs-6 col-sm-6">
														<input placeholder="请输入车辆编号" maxlength="32" name="params['vehicleNumber']" class="form-control search-query">
													</div>
												</span>
											</div>
											<div class="col-xs-4">
												<span> <label class="col-xs-12 col-sm-4 label_text">车辆类型：</label>
													<div class="input-group col-xs-6 col-sm-6">
														<select name="params['vehicleType']" id="type" class="form-control input-sm">
															<option value="">全部</option>
															<option value="0">运输</option>
															<option value="1">装卸</option>
														</select>
													</div>
												</span>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-6">
		                                       	<span> 
		                                        	<label class="col-xs-12 col-sm-3 ">报废时间：</label>
		                                            <div class="input-daterange input-group">
		                                            	<input class="form-control" name="params['scrapTime']" autocomplete="off" id="startTime" 
		                                            	onFocus="WdatePicker({startDate: '%y-%M-%d',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\')}'})" >
		                                              	<span class="input-group-addon">
		                                                	<i class="fa fa-exchange"></i>
		                                              	</span>
		                                              	<input class="form-control" name="params['endScrapTime']" autocomplete="off" id="endTime"
		                                              	onFocus="WdatePicker({startDate: '%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startTime\')}'})">
		                                            </div>
		                                        </span>
		                                   	</div>
		                                   	<div class="col-xs-6">
		                                   	</div>
										</div>
									</div>
									<div class="bs_btn">
										<button id="delete" class="btn btn-sm btn-danger">
											<i class="ace-icon fa fa-trash-o bigger-120"></i>删除
										</button>
										<button id="addBtn" class="btn btn-sm btn-success">
											<i class="ace-icon fa fa-hand-o-right bigger-120"></i>新增
										</button>
										<button class="btn btn-sm" type="button" id="resetBtn">
											<i class="ace-icon fa fa-undo bigger-110"></i> 重置
										</button>
										<button id="seachBtn" type="button" class="btn btn-purple btn-sm">
											<i class="ace-icon fa fa-search icon-on-right bigger-110"></i> 搜索
										</button>								
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
				<div class="space-6"></div>
				<table id="grid-table"></table>
				<div id="grid-pager" style="height: 200px;"></div>
			</div>
		</div>
		<script>
			var list_url = ctxPaths + '/admin/vehicleInfo/list';
			var delete_url = ctxPaths + "${ctx}/admin/vehicleInfo/delete";
			var save_url = ctxPaths + "${ctx}/admin/vehicleInfo/save";
			var grid_selector = "#grid-table";
			var pager_selector = "#grid-pager";
		
			$(function() {
				/** 表格数据初始化 **/
				jqGrid_init($(grid_selector), pager_selector, {
					url : list_url,
					sortable : true,
					sortname : 'vehicle_id',
					sortorder : 'desc',
					colNames : [ '主键id', '车辆编号', '最大存储体积(m3)', '载重吨位(T)', '价格(￥)', '类型', '报废时间', '维护费用', '剩余价值', '操作' ],
					colModel : [ {
						name : 'vehicleId',
						index : 'vehicleId',
						sortable : false,
						width : 50,
						hidden : true
					}, {
						name : 'vehicleNumber',
						index : 'vehicleNumber',
						sortable : true,
						sortname : 'vehicle_number',
						width : 80
					}, {
						name : 'storageVolume',
						index : 'storageVolume',
						sortable : true,
						sortname : 'storage_volume',
						width : 80
					}, {
						name : 'tonnage',
						index : 'tonnage',
						sortable : true,
						sortname : 'tonnage',
						width : 80
					}, {
						name : 'vehiclePrice',
						index : 'vehiclePrice',
						sortable : true,
						sortname : 'vehicle_price',
						width : 80
					}, {
						name : 'vehicleType',
						index : 'vehicleType',
						sortable : true,
						sortname : 'vehicle_type',
						width : 80
					}, {
						name : 'scrapTime',
						index : 'scrapTime',
						sortable : true,
						sortname : 'scrap_time',
						width : 80,
						formatter:"date",
						formatoptions: {
							srcformat:'Y-m-d H:i:s',
							newformat:'Y-m-d'
						}
					}, {
						name : 'maintenanceCosts',
						index : 'maintenanceCosts',
						sortable : true,
						sortname : 'maintenance_costs',
						width : 80
					}, {
						name : 'residualValue',
						index : 'residualValue',
						sortable : true,
						sortname : 'residual_value',
						width : 80
					}, {
						name : 'myac',
						index : '',
						width : 120,
						fixed : true,
						sortable : false,
						resize : false,
						formatter : actionButtons
					} ],
					autowidth : true
				});
				
				/** 搜索按钮 **/
				$('#seachBtn').on('click', function() {
					jQuery('#grid-table').jqGrid('setGridParam', {
						postData : $('#queryForm').serializeJson(),
						page : 1
					}).trigger("reloadGrid");
				});
				
				/** 重置 按钮 **/
				$('#resetBtn').on('click', function() {
					resetForm($('#queryForm'));
				});
				
				/** 添加 按钮 **/
				$('#addBtn').on('click', function() {
					window.location.href = save_url;
				});
				
				/** 删除  按钮 **/
				$("#delete").click(function() {
					var id = getSelecteds();
					if(id == "") {
						Q_Alert_Fail("请至少选择一行数据");
					} else {
						deleteEvent(id);
					}
				});
			});
			
			// 获取选中行数据并删除
			function getSelecteds(){  
				var idStr = "";
				//获取多选到的id集合  
				var ids = $("#grid-table").jqGrid("getGridParam", "selarrrow");  
				//遍历访问这个集合  
				$(ids).each(function (index, id){  
				     //由id获得对应数据行  
					var row = $("#grid-table").jqGrid('getRowData', id);  
					idStr += row.vehicleId + ",";
				});
				return idStr;
			}
			
			/** 删除操作 **/
			function deleteEvent(id) {
				Q_Confirm("是否要删除？", function(result) {
					if (result) {
						$.ajaxSubmit(delete_url, {
							'id' : id
						}, function(data) {
							if (data.success == true) {
								Q_Alert("删除成功");
								$(grid_selector).jqGrid('setGridParam', {
									page : 1
								}).trigger("reloadGrid");
							} else {
								Q_Alert_Fail(data.message);
							}
						});
					}
				});
			};
			
			/** 编辑页面 **/
			function editEvent(id) {
				window.location.href = save_url + '?id=' + id;
			};
			
			/** 操作项 **/
			function actionButtons(cellvalue, options, rowObject) {
				return '<div >'
				+ '<button onclick=\"editEvent(' + rowObject["vehicleId"] + ')\" class=\"btn btn-xs btn-info\" data-rel=\"tooltip\" title=\"编辑\" >'
				+ '<i class=\"ace-icon fa fa-pencil bigger-120\"></i></button>&nbsp;'
				+ '<button onclick=\"deleteEvent(' + rowObject["vehicleId"]+ ')\" class=\"btn btn-xs btn-danger\" data-rel=\"tooltip\" title=\"删除\" >'
				+ '<i class=\"ace-icon fa fa-trash-o bigger-120\"></i></button>'
				+ '</div>';
			}
		</script>
	</body>
</html>