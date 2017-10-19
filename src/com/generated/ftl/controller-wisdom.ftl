/**
 * ${info.tableInfo.className}.java
 * ${info.corporateName}
 * All rights reserved.
 * -----------------------------------------------
 * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
 * <b>Copyright (c) ${info.time?string("yyyy")} ASPire Tech.</b>  
 */
package ${info.controllerPackage};

import ${info.entityPackage}.${info.tableInfo.className};
import ${info.servicePackage}.${info.tableInfo.className}Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aspire.webbas.core.pagination.mybatis.pager.Page;
import com.aspire.webbas.core.web.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ${info.tableInfo.tableComment}Controller
 * <pre>
 * <b>Title：</b>${info.tableInfo.className}Controller.java<br/>
 * <b>@author： </b>${info.author}<br/>
 * <b>@version：</b>V1.0<br/>
 * <b>@date：</b>${info.time?string("yyyy-MM-dd HH:mm:ss")} Created<br/>  
 * <b>Copyright (c) ${info.time?string("yyyy")} ASPire Tech.</b>   
 * </pre>
 */
@Controller("${info.tableInfo.className}Controller")
@RequestMapping(value ="/${info.tableInfo.methodName}")
public class ${info.tableInfo.className}Controller extends BaseController {

	protected static Logger LOG = LoggerFactory.getLogger(${info.tableInfo.className}Controller.class);
	
	/** ${info.tableInfo.tableComment}Service */
	@Autowired
	private ${info.tableInfo.className}Service ${info.tableInfo.methodName}Service;
	
	/**
     * 跳转数据列表Url
     * @param  model
     * @param  request
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request) {
		return "/${info.tableInfo.methodName}_list";
	}
	
	/**
	 * 数据列表
	 * @param page		${info.tableInfo.className}分页对象
	 * @param request
	 * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
	 */
	@RequestMapping(value = "/query")
	@ResponseBody
	public Map<String, Object> query(Page<${info.tableInfo.className}> page, HttpServletRequest request) {
		Page<${info.tableInfo.className}> list = ${info.tableInfo.methodName}Service.pageQuery(page);
		return this.page(list);
	}
	
	/**
	 * 根据id获取数据
	 * @param id
	 * @param request
	 * @return
	 * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
	 */
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> get(${info.tableInfo.primaryKeyEntityType} id, HttpServletRequest request) {
		${info.tableInfo.className} data = ${info.tableInfo.methodName}Service.selectByPrimaryKey(id);
		return super.success(data);
	}
	
	/**
     * 跳转添加页面或编辑页面
     * @param  model
     * @param  request
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String save(${info.tableInfo.primaryKeyEntityType} id, Model model, HttpServletRequest request) {
		model.addAttribute("id", id);
		return "/${info.tableInfo.methodName}_save";
	}
	
	/**
     * 保存数据（add or update）
     * @param  data	${info.tableInfo.methodName}对象
     * @param  model
     * @param  request
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> save(@Valid ${info.tableInfo.className} data, Model model, HttpServletRequest request) {
		try{
			${info.tableInfo.methodName}Service.saveAndUpdate(data);
		} catch (Exception e) {
			LOG.error("${info.tableInfo.className}类保存数据异常：" + e.getMessage(), e);
			return super.fail("操作失败");
		}
		return super.success(data);
	}
	
	/**
     * 删除数据
     * @param id 删除数据组","分隔
     * @return 
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
    @RequestMapping(value = "/delete")
	@ResponseBody
	public Map<String, Object> delete(String id) {
    	try {
    		int row = ${info.tableInfo.methodName}Service.delete(id, false);
    		if(row == 0)
    			return super.fail("删除失败");
		} catch (Exception e) {
			LOG.error("${info.tableInfo.className}类delete数据异常：" + e.getMessage(), e);
			return super.fail("删除失败");
		}
		return super.success("删除成功");
	}
}