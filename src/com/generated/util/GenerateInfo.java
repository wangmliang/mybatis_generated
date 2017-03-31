package com.generated.util;

import java.util.Date;

import com.generated.dto.TableInfo;
import com.generated.dto.TypeDto;

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
     * java类是否导入 Date、Array包
     * 0： 不导入  1：导入
     */
    private TypeDto isPackgeType;
    
    /**
     * 数据库字段信息
     */
    private TableInfo tableInfo;

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
    
}
