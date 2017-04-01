/**
 * ${info.tableInfo.className}Mapper.java
 * ${info.corporateName}
 * All rights reserved.
 * -----------------------------------------------
 * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
 * <b>Copyright (c) ${info.time?string("yyyy")} ASPire Tech.</b>  
 */
package ${info.mapperPackage};

import java.util.List;
import java.util.Map;

import ${info.entityPackage}.${info.tableInfo.className};
import com.aspire.webbas.core.pagination.mybatis.pager.Page;

/**
 * ${info.tableInfo.tableComment}Mapper
 * <pre>
 * <b>Title：</b>${info.tableInfo.className}Mapper.java<br/>
 * <b>@author： </b>${info.author}<br/>
 * <b>@version：</b>V1.0<br/>
 * <b>@date：</b>${info.time?string("yyyy-MM-dd HH:mm:ss")} Created<br/>  
 * <b>Copyright (c) ${info.time?string("yyyy")} ASPire Tech.</b>   
 * </pre>
 */
public interface ${info.tableInfo.className}Mapper {

	/**
	 * 数据列表
	 * @param  page		${info.tableInfo.className}分页对象
	 * @return 数据列表
	 * @author ${info.author}
	 * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
	 */
	List<${info.tableInfo.className}> pageQuery(Page<${info.tableInfo.className}> page);

	/**
     * 根据主键id删除对应数据
     * @param  id		主键id
     * @return 删除影响行数
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	int deleteByPrimaryKey(${info.tableInfo.primaryKeyEntityType} id);

	/**
     * 新增
     * @param record	${info.tableInfo.className}对象
     * @return 新增影响行数
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
    int insert(${info.tableInfo.className} record);

	/**
     * 新增（属性通过非空验证，为空属性不参与操作）
     * @param  record	${info.tableInfo.className}对象
     * @return 新增影响行数
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
    int insertSelective(${info.tableInfo.className} record);

	/**
     * 根据主键id查询对应数据
     * @param  id	主键id
     * @return ${info.tableInfo.className}对象
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
    ${info.tableInfo.className} selectByPrimaryKey(${info.tableInfo.primaryKeyEntityType} id);

	/**
     * 查询${info.tableInfo.className}对象的数据集合
     * @return ${info.tableInfo.className}对象集合
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	List<${info.tableInfo.className}> selectAll();
	
	/**
     * 根据${info.tableInfo.className}对象更新对应数据
     * @param  record	${info.tableInfo.className}对象
     * @return 更新影响行数
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
    int updateByPrimaryKeySelective(${info.tableInfo.className} record);

	/**
     * 根据${info.tableInfo.className}对象更新对应数据（属性通过非空验证，为空属性不参与操作）
     * @param  record	${info.tableInfo.className}对象
     * @return 更新影响行数
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
    int updateByPrimaryKey(${info.tableInfo.className} record);
    
    /**
     * 根据Map对象批量删除
     * @param  map	map对象  [ list:主键id集合 ]
     * @return 批量删除影响行数
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
    int batchDelete(Map<String, Object> map);
    
}