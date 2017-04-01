package com.generated.dto;

import java.util.Date;

/**
 * 自动生成信息详情
 * <pre>
 * <b>Title：</b>InfoDto.java<br/>
 * <b>Description：</b><br/>
 * <b>@author： </b>ynt<br/>
 * <b>@date：</b>2016年7月13日 下午5:19:57<br/>  
 * <b>Copyright (c) 2016 ASPire Tech.</b>   
 *  </pre>
 */
public class GenerateInfo {
    
    /**
     * 作者
     */
    private String author;
    
    /**
     * 公司名称
     */
    private String corporateName;
    
    /**
     * 创建时间
     */
    private Date time;
    
    /**
     * java类包名
     */
    private String entityPackage;
    
    /**
     * mapper接口类包名
     */
    private String mapperPackage;

    /**
     * mapperXml接口类包名
     */
    private String xmlPackage;
    
    /**
     * mapperExtendXml接口类包名
     */
    private String xmlExtendPackage;
    
    /**
     * java类是否导入 Date、Array包
     * 0： 不导入  1：导入
     */
    private TypeDto isPackgeType;
    
    /**
     * 数据库字段信息
     */
    private TableInfo tableInfo;

    /**
     * entity文件保存路径
     */
    private String entityFilePath;
    
    /**
     * mapper文件保存路径
     */
    private String mapperFilePath;
    
    /**
     * xml文件保存路径
     */
    private String xmlFilePath;
    
    /**
     * xml继承文件保存路径
     */
    private String xmlExtendFilePath;
    
    /**
     * service包名
     */
    private String servicePackage;
    
    /**
     * service保存文件路径
     */
    private String servicePath;
    
    /**
     * controller包名
     */
    private String controllerPackage;
    
    /**
     * controller包名
     */
    private String controllerPath;
    
    /**
     * page包名
     */
    private String pagePackage;
    
    /**
     * page包名
     */
    private String pagePath;
    
    /**
     * 模板文件读取路径
     */
    private String ftlPath;
    
    public String getEntityFilePath() {
		return entityFilePath;
	}

	public void setEntityFilePath(String entityFilePath) {
		this.entityFilePath = entityFilePath;
	}

	public String getMapperFilePath() {
		return mapperFilePath;
	}

	public void setMapperFilePath(String mapperFilePath) {
		this.mapperFilePath = mapperFilePath;
	}

	public String getXmlFilePath() {
		return xmlFilePath;
	}

	public void setXmlFilePath(String xmlFilePath) {
		this.xmlFilePath = xmlFilePath;
	}

	public String getFtlPath() {
		return ftlPath;
	}

	public void setFtlPath(String ftlPath) {
		this.ftlPath = ftlPath;
	}

	public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getXmlPackage() {
        return xmlPackage;
    }

    public void setXmlPackage(String xmlPackage) {
        this.xmlPackage = xmlPackage;
    }

    public TypeDto getIsPackgeType() {
        return isPackgeType;
    }

    public void setIsPackgeType(TypeDto isPackgeType) {
        this.isPackgeType = isPackgeType;
    }

    public TableInfo getTableInfo() {
        return tableInfo;
    }

    public void setTableInfo(TableInfo tableInfo) {
        this.tableInfo = tableInfo;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getServicePath() {
        return servicePath;
    }

    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    public String getControllerPath() {
        return controllerPath;
    }

    public void setControllerPath(String controllerPath) {
        this.controllerPath = controllerPath;
    }

    public String getPagePackage() {
        return pagePackage;
    }

    public void setPagePackage(String pagePackage) {
        this.pagePackage = pagePackage;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getXmlExtendPackage() {
		return xmlExtendPackage;
	}

	public void setXmlExtendPackage(String xmlExtendPackage) {
		this.xmlExtendPackage = xmlExtendPackage;
	}

	public String getXmlExtendFilePath() {
		return xmlExtendFilePath;
	}

	public void setXmlExtendFilePath(String xmlExtendFilePath) {
		this.xmlExtendFilePath = xmlExtendFilePath;
	}

	@Override
    public String toString() {
        return "GenerateInfo [author=" + author + ", corporateName=" + corporateName + ", time="
               + time + ", entityPackage=" + entityPackage + ", mapperPackage=" + mapperPackage
               + ", xmlPackage=" + xmlPackage + ", isPackgeType=" + isPackgeType + ", tableInfo="
               + tableInfo + ", entityFilePath=" + entityFilePath + ", mapperFilePath="
               + mapperFilePath + ",xmlExtendPackage=" + xmlExtendPackage + ", xmlFilePath="
               + xmlFilePath + ", servicePackage=" + servicePackage + ",xmlExtendFilePath=" 
               + xmlExtendFilePath + ", servicePath=" + servicePath + ", controllerPackage="
               + controllerPackage + ", controllerPath=" + controllerPath + ", pagePackage="
               + pagePackage + ", pagePath=" + pagePath + ", ftlPath=" + ftlPath + "]";
    }

}

