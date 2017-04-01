<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${info.mapperPackage}.${info.tableInfo.className}Mapper">
	<!-- 实体映射 -->
	<resultMap type="${info.entityPackage}.${info.tableInfo.className}" id="BaseResultMap">
		<#list info.tableInfo.list as var>
		<#if (var_index = 0)>
		<!-- ${var.remark} -->
		<id column="${var.name}" property="${var.className}" jdbcType="${var.dbType}"/>	
		</#if>
		<#if (var_index > 0)>
		<!-- ${var.remark} -->
		<result column="${var.name}" property="${var.className}" jdbcType="${var.dbType}"/>	
		</#if>
		</#list>
		
		<#if info.tableInfo.foreignKeyList?exists>
		<#list info.tableInfo.foreignKeyList as var>
		<association property="${var.entityName}" 
    		javaType="${info.entityPackage}.${var.tersName}" 
    		column="${var.fkColumnName}"
			select="${info.mapperPackage}.${var.tersName}Mapper.selectByPrimaryKey">
		</association>
		</#list>
		</#if>
	</resultMap>
	
	<!-- 字段属性 -->
	<sql id="Base_Column_List">
        <#list info.tableInfo.list as var><#if (info.tableInfo.list?size -1 == var_index)>${var.name}<#else>${var.name}, </#if><#if (var_index != 0 && var_index % 5 == 0)>
		</#if> </#list>
    </sql>
    
    <!-- 分页列表查询  -->
	<select id="pageQuery" parameterType="com.aspire.webbas.core.pagination.mybatis.pager.Page" resultMap="BaseResultMap">
		select * from ${info.tableInfo.tableName} 
		where 1 = 1 
	</select>
    
    <!-- 根据主键${info.tableInfo.primaryKey}查询对应数据  -->
    <select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="${info.tableInfo.primaryKeyEntityType}">
        select 
        <include refid="Base_Column_List" />
        from ${info.tableInfo.tableName}
        where ${info.tableInfo.primaryKey} = ${r"#{"}${info.tableInfo.primaryKeyEntity}, jdbcType=${info.tableInfo.primaryKeyDBType}${r"}"}
    </select>
    
    <!-- 查询${info.tableInfo.tableName}对象的数据集合 -->
    <select id="selectAll" resultMap="BaseResultMap">
        select 
        <include refid="Base_Column_List" />
        from ${info.tableInfo.tableName}
    </select>
    
    <!-- 根据主键 ${info.tableInfo.primaryKey}删除对应数据 -->
    <delete id="deleteByPrimaryKey" parameterType="${info.tableInfo.primaryKeyEntityType}">
		delete from ${info.tableInfo.tableName}
		where ${info.tableInfo.primaryKey} = ${r"#{"}${info.tableInfo.primaryKeyEntity}, jdbcType=${info.tableInfo.primaryKeyDBType}${r"}"}
	</delete>
	
	<!-- 批量删除 -->
	<delete id="batchDelete" parameterType="java.util.Map">
		delete from ${info.tableInfo.tableName} where 1 = 1
		<if test="list != null">
			and ${info.tableInfo.primaryKey} in
			<foreach item="tag" index="index" collection="list" open="(" separator="," close=")">
	        	${r"#{tag}"}
			</foreach>
		</if>
	</delete>
	
	<!-- 新增 -->
	<insert id="insert" parameterType="${info.entityPackage}.${info.tableInfo.className}">
		insert into ${info.tableInfo.tableName}(<#list info.tableInfo.list as var><#if (info.tableInfo.list?size -1 == var_index)>${var.name}<#else>${var.name}, </#if><#if (var_index != 0 && var_index % 3 == 0)>
		</#if></#list> ) 
		values (<#list info.tableInfo.list as var><#if (info.tableInfo.list?size -1 == var_index)>${r"#{"}${var.className}, jdbcType=${var.dbType}${r"}"}<#else>${r"#{"}${var.className}, jdbcType=${var.dbType}${r"}"}, </#if><#if (var_index != 0 && var_index % 3 == 0)>
		</#if></#list> )
	</insert>
	
	<!-- 新增 -->
	<insert id="insertSelective" parameterType="${info.entityPackage}.${info.tableInfo.className}">
    	insert into ${info.tableInfo.tableName}
	    <trim prefix="(" suffix=")" suffixOverrides="," >
	    	<#list info.tableInfo.list as var>
		    <if test="${var.className} != null" >
		    	${var.name},
		    </if>
		    </#list>
	    </trim>
	    <trim prefix="values (" suffix=")" suffixOverrides="," >
	    	<#list info.tableInfo.list as var>
		    <if test="${var.className} != null" >
		        ${r"#{"}${var.className}, jdbcType=${var.dbType}${r"}"},
		    </if>
		    </#list>
	    </trim>
  	</insert>
  	
  	<!-- 修改 -->
  	<update id="updateByPrimaryKey" parameterType="${info.entityPackage}.${info.tableInfo.className}">
    	update ${info.tableInfo.tableName} set 
	    	<#list info.tableInfo.list as var>
	    	${var.name} = ${r"#{"}${var.className}, jdbcType=${var.dbType}${r"}"}<#if (info.tableInfo.list?size - 1 != var_index)>, </#if>
			</#list>
		where ${info.tableInfo.primaryKey} = ${r"#{"}${info.tableInfo.primaryKeyEntity}, jdbcType=${info.tableInfo.primaryKeyDBType}${r"}"}
  	</update>
  
  	<!-- 修改 -->
  	<update id="updateByPrimaryKeySelective" parameterType="${info.entityPackage}.${info.tableInfo.className}">
    	update ${info.tableInfo.tableName}
	    <set>
	    	<#list info.tableInfo.list as var>
		    <if test="${var.className} != null" >
		    	${var.name} = ${r"#{"}${var.className}, jdbcType=${var.dbType}${r"}"},
		    </if>
		    </#list>
	    </set>
    	where ${info.tableInfo.primaryKey} = ${r"#{"}${info.tableInfo.primaryKeyEntity}, jdbcType=${info.tableInfo.primaryKeyDBType}${r"}"}
  	</update>
  
</mapper>