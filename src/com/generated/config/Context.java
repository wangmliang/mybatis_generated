package com.generated.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * XML配置主要元素
 * <pre>
 * <b>Title：</b>Context.java<br/>
 * <b>@author： </b>WML<br/>
 * <b>@date：</b>2016年10月18日 下午2:03:57<br/>  
 * <b>Copyright (c) 2016 ASPire Tech.</b>   
 *  </pre>
 */
@XStreamAlias("context")
public class Context {
    
    /**
     * 数据库链接配置项 
     */
    @XStreamAlias("jdbcConnection")
    private JdbcConnection jdbcConnection;
    
    /**
     * Java Bean 配置项 
     */
    @XStreamAlias("javaModelGenerator")
    private JavaModelGenerator javaModelGenerator;
    
    
    /**
     * java 接口文件配置项 
     */
    @XStreamAlias("javaClientGenerator")
    private JavaClientGenerator javaClientGenerator;
    
    /**
     * XML文件配置项 
     */
    @XStreamAlias("sqlMapGenerator")
    private SqlMapGenerator sqlMapGenerator;
    
    /**
     * XML继承文件配置项 
     */
    @XStreamAlias("sqlMapExtendGenerator")
    private SqlMapExtendGenerator sqlMapExtendGenerator;
    
    /**
     * Service文件参数 
     */
    @XStreamAlias("javaServiceGenerator")
    private JavaServiceGenerator javaServiceGenerator;
    
    /**
     * Controller文件配置参数 
     */
    @XStreamAlias("javaControllerGenerator")
    private JavaControllerGenerator javaControllerGenerator;
    
    /**
     * 页面文件配置参数 
     */
    @XStreamAlias("javaPageGenerator")
    private JavaPageGenerator javaPagerGenerator;
    
    /**
     * 数据表信息集合
     */
    @XStreamAlias("list")
    private TableList tableList;
    
    public JdbcConnection getJdbcConnection() {
		return jdbcConnection;
	}

	public void setJdbcConnection(JdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

	public JavaModelGenerator getJavaModelGenerator() {
		return javaModelGenerator;
	}

	public void setJavaModelGenerator(JavaModelGenerator javaModelGenerator) {
		this.javaModelGenerator = javaModelGenerator;
	}

	public JavaClientGenerator getJavaClientGenerator() {
		return javaClientGenerator;
	}

	public void setJavaClientGenerator(JavaClientGenerator javaClientGenerator) {
		this.javaClientGenerator = javaClientGenerator;
	}

	public SqlMapGenerator getSqlMapGenerator() {
		return sqlMapGenerator;
	}

	public void setSqlMapGenerator(SqlMapGenerator sqlMapGenerator) {
		this.sqlMapGenerator = sqlMapGenerator;
	}

	public JavaServiceGenerator getJavaServiceGenerator() {
		return javaServiceGenerator;
	}

	public void setJavaServiceGenerator(JavaServiceGenerator javaServiceGenerator) {
		this.javaServiceGenerator = javaServiceGenerator;
	}

	public JavaControllerGenerator getJavaControllerGenerator() {
		return javaControllerGenerator;
	}

	public void setJavaControllerGenerator(
			JavaControllerGenerator javaControllerGenerator) {
		this.javaControllerGenerator = javaControllerGenerator;
	}

	public JavaPageGenerator getJavaPagerGenerator() {
		return javaPagerGenerator;
	}

	public void setJavaPagerGenerator(JavaPageGenerator javaPagerGenerator) {
		this.javaPagerGenerator = javaPagerGenerator;
	}

	public TableList getTableList() {
		return tableList;
	}

	public void setTableList(TableList tableList) {
		this.tableList = tableList;
	}

	public SqlMapExtendGenerator getSqlMapExtendGenerator() {
		return sqlMapExtendGenerator;
	}

	public void setSqlMapExtendGenerator(SqlMapExtendGenerator sqlMapExtendGenerator) {
		this.sqlMapExtendGenerator = sqlMapExtendGenerator;
	}

	@Override
    public String toString() {
        return "Context [jdbcConnection=" + jdbcConnection + ", javaModelGenerator="
               + javaModelGenerator + ", javaClientGenerator=" + javaClientGenerator
               + ", sqlMapGenerator=" + sqlMapGenerator + ", sqlMapExtendGenerator="
               + sqlMapExtendGenerator + "javaServiceGenerator=" + javaServiceGenerator +
               ", javaControllerGenerator=" + javaControllerGenerator + ", javaPagerGenerator="
               + javaPagerGenerator + ", tableList=" + tableList + "]";
    }

}
