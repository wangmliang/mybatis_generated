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
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springside.modules.web.Servlets;

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
@Controller
@RequestMapping(value ="/${info.tableInfo.methodName}")
public class ${info.tableInfo.className}Controller {

	protected static Logger logger = LoggerFactory.getLogger(${info.tableInfo.className}Controller.class);
	
	/** ${info.tableInfo.tableComment}Service */
	@Autowired
	private ${info.tableInfo.className}Service ${info.tableInfo.methodName}Service;
	
	/**
     * 数据列表
     * @param  model
     * @param  request
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String list(Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try{
			Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
			
			// 分页查询
			PageInfo<${info.tableInfo.className}> pageList = ${info.tableInfo.methodName}Service.getPageList(searchParams, 10);
			model.addAttribute("pageList", pageList);
			
			// 将搜索条件编码成字符串，用于排序，分页的URL
			model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
		} catch (Exception e) {
			logger.error("${info.tableInfo.className}类查询列表异常：" + e.getMessage(), e);
			redirectAttributes.addFlashAttribute("error_message", "操作失败！");
		}
		return "/list";
	}
	
	/**
     * 跳转添加页面
     * @param  model
     * @param  request
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try{
			
		} catch (Exception e) {
			logger.error("${info.tableInfo.className}类跳转add页面异常：" + e.getMessage(), e);
			redirectAttributes.addFlashAttribute("error_message", "删除失败！");
		}
		return "/add";
	}
	
	/**
     * 保存数据
     * @param  data	${info.tableInfo.className}对象
     * @param  model
     * @param  request
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid ${info.tableInfo.className} data, Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try{
			${info.tableInfo.methodName}Service.saveAndUpdate(data);
			redirectAttributes.addFlashAttribute("info_message", "保存成功！");
		} catch (Exception e) {
			logger.error("${info.tableInfo.className}类保存数据异常：" + e.getMessage(), e);
			redirectAttributes.addFlashAttribute("error_message", "保存失败！");
		}
		return "redirect:/list";
	}
	
	/**
     * 删除数据
     * @param  ${info.tableInfo.primaryKeyEntity} id（包括字符串数组, ","号分隔）
     * @param  flag	true:单个删除	false:批量删除
     * @param  model
     * @param  request
     * @author ${info.author}
     * ${info.time?string("yyyy-MM-dd HH:mm:ss")}  Created
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(String ${info.tableInfo.primaryKeyEntity}, boolean flag, Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try{
			${info.tableInfo.methodName}Service.delete(${info.tableInfo.primaryKeyEntity}, flag);
			redirectAttributes.addFlashAttribute("info_message", "删除成功！");
		} catch (Exception e) {
			logger.error("${info.tableInfo.className}类删除数据异常：" + e.getMessage(), e);
			redirectAttributes.addFlashAttribute("error_message", "删除失败！");
		}
		return "redirect:/${info.tableInfo.methodName}/list";
	}
}