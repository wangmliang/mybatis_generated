<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
	<meta charset="utf-8" />
</head>
<body>
	<div class="page-content">
		<div class="table-responsive">
			<div class="page-header">
			<h1>
				${info.tableInfo.tableComment}
				<small> <i class="ace-icon fa fa-angle-double-right"></i>
					详情
				</small>
			</h1>
		</div>
		<form class="form-horizontal" role="form" id="add-form" onsubmit="return false;">
			<div class="row">
				<div class="col-xs-6">
					<#list info.tableInfo.list as var>
					<#if (var_index != 0 && var_index % 2 == 0)>
					<div class="form-group">
						<label class="col-sm-5 control-label no-padding-right text-right" for="${var.className}"> 
							${var.remark}:
						</label>
						<div class="col-sm-7">
							<p name="${var.className}" class="form-control-static"></p>
						</div>
					</div>
					</#if>
					</#list>
				</div>
				<div class="col-xs-6">
					<#list info.tableInfo.list as var>
					<#if (var_index != 0 && var_index % 2 == 1)>
					<div class="form-group">
						<label class="col-sm-5 control-label no-padding-right text-right" for="${var.className}"> 
							${var.remark}:
						</label>
						<div class="col-sm-7">
							<p name="${var.className}" class="form-control-static"></p>
						</div>
					</div>
					</#if>
					</#list>
				</div>
			</div>
			<div class="clearfix form-actions">
				<div class="col-md-offset-3 col-md-9">
					<button class="btn" type="button" onclick="javascript:history.back();">
						<i class="ace-icon fa fa-undo bigger-110"></i>
						返 回
					</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		var view_url = ctxPaths+ '/${info.tableInfo.methodName}/get.ajax';
		var pkId = getP('${info.tableInfo.primaryKey}');
		$(function(){
			if (pkId){
				$.ajaxSubmit(view_url, {'${info.tableInfo.primaryKey}': pkId}, function(rtn) {
					if (rtn.success) {
						$.dataInput($('.form-control-static'), rtn.data);
					} else {
						Q_Alert_Fail(data.message); 
					}
				});
			}else{
				Q_Alert_Fail('参数错误'); 
			}
		});
	</script>
</body>
</html>