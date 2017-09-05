<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<!--#include virtual="/root.jsp"  -->
<title>${info.tableInfo.tableComment}</title>
<!--#include virtual="/include.html"  -->
<style type="text/css">
	.label_text { height: 35px; line-height: 35px; } 
	.bs_btn { float: right; padding-right: 25px; padding-bottom: 10px; } 
	.col-xs-4 { padding-top: 10px; } 
	table tbody tr td { text-align: center !important; } 
    .ui-jqgrid .ui-jqgrid-labels th { text-align: center !important; } 
</style>
</head>
<body>
	<div class="page-content">
		<div class="table-responsive">
			<form id="queryForm" onsubmit="return false;">
				<div class="widget-box">
					<div class="widget-header widget-header-flat search_tj_bar_tit">
						<h5 class="widget-title">查询条件</h5>
					</div>
					<div class="row search_tj_bar">
						<div class="col-xs-12">
							<div class="center">
								<div style="height: 10px;"></div>
								<div class="row">
									<div class="col-xs-6">
										<span> 
											<label class="col-xs-12 col-sm-4 label_text">国家名称:</label>
											<div class="input-group col-xs-6 col-sm-6">
												<input placeholder="请输入国家名称" maxlength="32" name="params['']" class="form-control search-query">
											</div>
										</span>
									</div>
									<div class="col-xs-6">
										<span> 
											<label class="col-xs-12 col-sm-4 label_text">所属大洲：</label>
											<div class="input-group col-xs-6 col-sm-6">
												<select name="params['']" id="type" class="form-control input-sm">
													<option value=>全部</option>
												</select>
											</div>
										</span>
									</div>
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
			</form>
			<div class="space-6"></div>
			<table id="grid-table"></table>
			<div id="grid-pager"></div>
		</div>
	</div>
	<script>
		var list_url = ctxPaths + '/${info.tableInfo.methodName}/list';
		var delete_url = ctxPaths + "/${info.tableInfo.methodName}/delete";
		var save_url = ctxPaths + "/${info.tableInfo.methodName}/save";
		var grid_selector = "#grid-table";
		var pager_selector = "#grid-pager";
	
		$(function() {
			/** 表格数据初始化 **/
			jqGrid_init($(grid_selector), pager_selector, {
				url : list_url,
				sortable : true,
				sortname : '${info.tableInfo.primaryKey}',
				sortorder : 'desc',
				colNames : [ <#list info.tableInfo.list as var><#if (info.tableInfo.list?size -1 == var_index)>'${var.remark}', '操作'<#else>'${var.remark}', </#if></#list> ],
				colModel : [ 
				<#list info.tableInfo.list as var>
					{
						name : '${var.className}',
						index : '${var.className}',								
						<#if (var_index == 0)>
						sortable : false,
						hidden : true,
						</#if>
						<#if (var_index != 0)>
						sortable : true,
						sortname : '${var.name}',
						</#if>
						width : 50
					},
				</#list> {
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
					deleteEvent(id, '?flag=false');
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
				idStr += row.${info.tableInfo.primaryKey} + ",";
			});
			return idStr;
		}
		
		/** 删除操作 **/
		function deleteEvent(id, url) {
			if(null == url) 
				url = "?type=true";
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
			window.location.href = save_url + '?${info.tableInfo.primaryKey}=' + id;
		};
		
		/** 操作项 **/
		function actionButtons(cellvalue, options, rowObject) {
			return '<div >'
			+ '<button onclick=\"editEvent(' + rowObject["${info.tableInfo.primaryKey}"] + ')\" class=\"btn btn-xs btn-info\" data-rel=\"tooltip\" title=\"编辑\" >'
			+ '<i class=\"ace-icon fa fa-pencil bigger-120\"></i></button>&nbsp;'
			+ '<button onclick=\"deleteEvent(' + rowObject["${info.tableInfo.primaryKey}"]+ ', null)\" class=\"btn btn-xs btn-danger\" data-rel=\"tooltip\" title=\"删除\" >'
			+ '<i class=\"ace-icon fa fa-trash-o bigger-120\"></i></button>'
			+ '</div>';
		}
	</script>
</body>
</html>