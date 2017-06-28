<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>${info.tableInfo.tableComment}</title>
</head>
<body>
	<div class="page-content">
		<div class="table-responsive">
			<form class="form-horizontal" id="add-form" onsubmit="return false;">
				<div class="page-header">
					<h1>
						${info.tableInfo.tableComment}
						<small> 
							<i class="icon-double-angle-right"></i> &gt;&gt;
							新增/修改
						</small>
					</h1>
		 		</div>
		 		<input type="hidden" name="${info.tableInfo.primaryKey}" id="${info.tableInfo.primaryKey}"/>
				<div class="row">
					<!-- left -->
					<div class="col-xs-6">
						<#list info.tableInfo.list as var>
						<#if (var_index != 0 && var_index % 2 == 0)>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right text-right" for="${var.className}"> 
								<#if (!var.isNull)><span class="red">*</span></#if> ${var.remark}:
							</label>
							<div class="col-sm-6">
								<input type="text" name="${var.className}" id="${var.className}" class="form-control input-sm" />
							</div>
						</div>
						</#if>
						</#list>
					</div>
					<!-- right -->
					<div class="col-xs-6">
						<#list info.tableInfo.list as var>
						<#if (var_index != 0 && var_index % 2 == 1)>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right text-right" for="${var.className}"> 
								<#if (!var.isNull)><span class="red">*</span></#if> ${var.remark}:
							</label>
							<div class="col-sm-6">
								<input type="text" name="${var.className}" id="${var.className}" class="form-control input-sm" />
							</div>
						</div>
						</#if>
						</#list>
					</div>
				</div>
				<div class="clearfix form-actions">
					<div class="center">
						<button class="btn btn-info" type="submit" id="submitButton">
							<i class="ace-icon fa fa-check bigger-110"></i> 保 存
						</button>
						&nbsp; &nbsp; &nbsp;
						<button class="btn" type="button" id="resetBtn">
							<i class="ace-icon fa fa-undo bigger-110"></i> 重 置
						</button>
						&nbsp; &nbsp; &nbsp;
						<button class="btn" type="button" onclick="javascript:history.back();">
							<i class="ace-icon fa fa-arrow-left"></i> 返 回
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		var list_url = ctxPaths + '/${info.tableInfo.methodName}/list';
		var save_url = ctxPaths + '/${info.tableInfo.methodName}/save';
		var view_url = ctxPaths + '/${info.tableInfo.methodName}/get';
		
		$(function() {
			var pkId = getP('${info.tableInfo.primaryKey}');
			var add_validator = $('#add-form').validate({ rules : {
						<#list info.tableInfo.list as var>
						<#if (var_index != 0)>
						'${var.className}' : {
							<#if (!var.isNull)>
							required : true,
							</#if>
							<#if (var.entityType == 'Integer' || var.entityType == 'Double' || var.entityType == 'Float' || var.entityType == 'BigDecimal')>
							min : 0,
							maxlength : ${var.numericPrecisionRadix},
							number_2: true
							</#if>
							<#if (var.entityType == 'String' || var.entityType == 'char')>
							maxlength : ${var.charMaxLength}
							</#if>
						}<#if (info.tableInfo.list?size -1 != var_index)>, </#if>
						</#if>
						</#list>
					},
					submitHandler : function(form) {
						$.ajaxSubmit(save_url, $(form).serializeJson(), function(data) {
								if (data.success == true) {
								    Q_Alert("操作成功", function() {
								    	location.href = list_url;
			                        });
								} else {
									Q_Alert_Fail(data.message);
								}
							}, $("#submitButton")
						);
					return false;
				}
			});
			
			$('#resetBtn').on('click', function() {
				resetForm($('#add-form'), add_validator);
			});
			
			// 编辑则根据id获取对应数据
			if (pkId) {
				$.ajaxSubmit(view_url, {
					'${info.tableInfo.primaryKey}' : pkId
				}, function(rtn) {
					if (rtn.success) {
						$('#add-form').json2Form2(rtn.data);
					} else {
						Q_Alert_Fail(rtn.message);
					}
				});
			}
		});
	</script>
</body>
</html>