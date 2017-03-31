/*
 * ${info.tableInfo.className}.java
 * ${info.corporateName}
 * All rights reserved.
 * -----------------------------------------------
 * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
 * <b>Copyright (c) ${info.time?string("yyyy")} ASPire Tech.</b>  
 */
package ${info.entityPackage};

<#if info.isPackgeType.isByte == "1">
import java.util.Arrays;
</#if>
<#if info.isPackgeType.isDate == "1">
import java.util.Date;
</#if>
<#if info.isPackgeType.isBigDecimal == "1">
import java.math.BigDecimal;
</#if>

<#if info.tableInfo.entityForeignKeyList?exists>
<#list info.tableInfo.entityForeignKeyList as var>
import ${info.entityPackage}.${var.tersName};
</#list>	
</#if>

/**
 * ${info.tableInfo.tableComment}
 * <pre>
 * <b>Title：</b>${info.tableInfo.className}.java<br/>
 * <b>@author： </b>${info.author}<br/>
 * <b>@version：</b>@version V1.0<br/>
 * <b>@date：</b>${info.time?string("yyyy-MM-dd HH:mm:ss")} Created<br/>  
 * <b>Copyright (c) ${info.time?string("yyyy")} ASPire Tech.</b>   
 * </pre>
 */
public class ${info.tableInfo.className} {
	<#list info.tableInfo.list as var>
	
	/**
	 * ${var.remark}
	 */
	private ${var.entityType} ${var.className};
	</#list>
	
	<#if info.tableInfo.foreignKeyList?exists>
	<#list info.tableInfo.foreignKeyList as var>
	/**
	 * 一对一关系隐射
	 */
	private ${var.tersName} ${var.entityName};
	
	</#list>
	</#if>
	<#list info.tableInfo.list as var>
	
	/**
     * 设置：${var.remark}
     * @author ${info.author}
     * @version V1.0 
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}
     * @param id the value for ${info.tableInfo.tableName}.${var.name}
     */
	public void set${var.tersName}(${var.entityType} ${var.className}) {
		<#if var.entityType == "String">
		this.${var.className} = ${var.className} == null ? null : ${var.className}.trim();
		</#if>
		<#if var.entityType != "String">
		this.${var.className} = ${var.className};
		</#if>
	}
	
	/**
     * 获取：${var.remark}
     * @author ${info.author}
     * @version V1.0 
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}
     * @return the value of ${info.tableInfo.tableName}.${var.name}
     */
	public ${var.entityType} get${var.tersName}() {
		return ${var.className};
	}
	</#list>
	
	<#if info.tableInfo.foreignKeyList?exists>
	<#list info.tableInfo.foreignKeyList as var>
	/**
     * 设置：${var.property}
     * @author ${info.author}
     * @version V1.0 
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}
     */
	public void set${var.entityName}(${var.tersName} ${var.entityName}) {
		this.${var.entityName} = ${var.entityName};
	}
	
	/**
     * 获取：${var.entityName}
     * @author ${info.author}
     * @version V1.0 
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}
     */
	public ${var.tersName} get${var.entityName}() {
		return ${var.entityName};
	}
	</#list>
	</#if>
	
	@Override
    public String toString() {
    	return "${info.tableInfo.className} [<#list info.tableInfo.list as var><#if (var_index == 0)>${var.className}=" + <#if var.entityType == "byte[]"> Arrays.toString(${var.className}) </#if><#if var.entityType != "byte[]"> ${var.className} </#if><#else>+ ", ${var.className}=" + <#if var.entityType == "byte[]"> Arrays.toString(${var.className}) </#if><#if var.entityType != "byte[]"> ${var.className} </#if></#if><#if (var_index != 0 && var_index % 3 == 0)>
		</#if></#list>+ "]";
    }
    
}