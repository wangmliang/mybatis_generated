/*
 * ${info.tableInfo.className}.java
 * ${info.corporateName}
 * All rights reserved.
 * -----------------------------------------------
 * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
 * <b>Copyright (c) ${info.time?string("yyyy")} ASPire Tech.</b>  
 */
package ${info.servicePackage};

import ${info.entityPackage}.${info.tableInfo.className};
import ${info.mapperPackage}.${info.tableInfo.className}Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aspire.webbas.core.pagination.mybatis.pager.Page;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${info.tableInfo.tableComment}Service
 * <pre>
 * <b>Title：</b>${info.tableInfo.className}Service.java<br/>
 * <b>@author： </b>${info.author}<br/>
 * <b>@version：</b>@version V1.0<br/>
 * <b>@date：</b>${info.time?string("yyyy-MM-dd HH:mm:ss")} Created<br/>  
 * <b>Copyright (c) ${info.time?string("yyyy")} ASPire Tech.</b>   
 * </pre>
 */
@Service("${info.tableInfo.methodName}Service")
@Transactional
public class ${info.tableInfo.className}Service {
	
	/** ${info.tableInfo.tableComment}Mapper */
	@Autowired
	private ${info.tableInfo.className}Mapper ${info.tableInfo.methodName}Mapper;
	
	/**
	 * 数据列表
	 * @param page 		${info.tableInfo.className}分页对象
	 * @param request
	 * @author WML
	 * 2016年11月17日 - 下午5:34:34
	 */
	public Page<${info.tableInfo.className}> pageQuery(Page<${info.tableInfo.className}> page) {
		List<${info.tableInfo.className}> list = ${info.tableInfo.methodName}Mapper.pageQuery(page);
		page.setDatas(list);
		return page;
	}
	
	/**
     * 根据主键id查询数据
     * @param  ${info.tableInfo.primaryKeyEntity} 	主键id
     * @return ${info.tableInfo.className}对象
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	public ${info.tableInfo.className} selectByPrimaryKey(${info.tableInfo.primaryKeyEntityType} ${info.tableInfo.primaryKeyEntity}) {
		return ${info.tableInfo.methodName}Mapper.selectByPrimaryKey(${info.tableInfo.primaryKeyEntity});
	}
	
	/**
     * 新增
     * @param  data	${info.tableInfo.className}对象
     * @return 影响行数
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	public int insert(${info.tableInfo.className} data) {
		return ${info.tableInfo.methodName}Mapper.insert(data);
	}
	
	/**
     * 新增(排除空值)
     * @param  data	${info.tableInfo.className}对象
     * @return 影响行数
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	public int insertSelective(${info.tableInfo.className} data) {
		return ${info.tableInfo.methodName}Mapper.insertSelective(data);
	}
	
	/**
     * 保存操作（add or update）
     * @param  data	${info.tableInfo.className}对象
     * @return 影响行数
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	public int saveAndUpdate(${info.tableInfo.className} data) {
		if (null != data.get${info.tableInfo.primaryKeyCapital}()) {// 判断有没有传主键，如果传了为更新，否则为新增
			return this.updateByPrimaryKey(data);
		} else {
			return this.insert(data);
		}
	}

	/**
     * 修改
     * @param  data
     * @return 影响行数
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	public int updateByPrimaryKey(${info.tableInfo.className} data) {
		return ${info.tableInfo.methodName}Mapper.updateByPrimaryKey(data);
	}
	
	/**
     * 修改(排除空值)
     * @param  data
     * @return 影响行数
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	public int updateByPrimaryKeySelective(${info.tableInfo.className} data) {
		return ${info.tableInfo.methodName}Mapper.updateByPrimaryKeySelective(data);
	}
	
	/**
     * 根据主键id删除数据
     * @param  ${info.tableInfo.primaryKeyEntity}	主键id	
     * @return 影响行数
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	public int deleteByPrimaryKey(${info.tableInfo.primaryKeyEntityType} ${info.tableInfo.primaryKeyEntity}) {
		return ${info.tableInfo.methodName}Mapper.deleteByPrimaryKey(${info.tableInfo.primaryKeyEntity});
	}
	
	/**
     * 批量删除
     * @param  list	待操作集合数据
     * @return 影响行数
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	public int batchDelete(List<${info.tableInfo.primaryKeyEntityType}> list) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return ${info.tableInfo.methodName}Mapper.batchDelete(map);
	}
	
	/**
     * 批量删除
     * @param  id	待操作数据
     * @param  flag true:单个删除	false:批量删除
     * @return 影响行数
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	public int delete(String id, boolean flag) {
		// 批量删除
		if(flag) {
			return this.deleteByPrimaryKey(${info.tableInfo.primaryKeyEntityType}.valueOf(id));
		} else {
			List<${info.tableInfo.primaryKeyEntityType}> list = this.splitReturnList(id);
			if(!list.isEmpty()) {
				return this.batchDelete(list);
			}
		}
		return 0;	
	}
	
	/**
     * 拆分字符串返回String List
     * @param  id	待操作数据
     * @param  flag true:单个删除  false:批量删除
     * @return 待删除id集合
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	public List<${info.tableInfo.primaryKeyEntityType}> splitReturnList(String id) {
		List<${info.tableInfo.primaryKeyEntityType}> list = new ArrayList<${info.tableInfo.primaryKeyEntityType}>();
		// 拆分字符串
		String[] strArray = id.split(",");
		if(null != strArray && strArray.length > 0) {
			for(String str : strArray) {
				if(StringUtils.isNotBlank(str)){
					list.add(${info.tableInfo.primaryKeyEntityType}.valueOf(str));
				}
			}
		}
		return list;
	}
}
