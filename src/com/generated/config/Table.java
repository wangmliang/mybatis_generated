package com.generated.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 
 * <pre>
 * <b>Title：</b>Table.java<br/>
 * <b>@author： </b>WML<br/>
 * <b>@date：</b>2016年10月25日 上午9:16:18<br/>  
 * <b>Copyright (c) 2016 ASPire Tech.</b>   
 *  </pre>
 */
@XStreamAlias("list")
public class Table {
    
    /**
     * 是否生成注释  
     * true：需要
     * false：不需要
     */
    @XStreamAlias("isContent")
    @XStreamAsAttribute
    private String isContent;
    
    /**
     * 数据表名
     */
    @XStreamAlias("tableName")
    @XStreamAsAttribute
    private String tableName;

    public String getIsContent() {
        return isContent;
    }

    public void setIsContent(String isContent) {
        this.isContent = isContent;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "Table [isContent=" + isContent + ", tableName=" + tableName + "]";
    }
    
}
