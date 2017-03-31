package com.generated.config;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 
 * <pre>
 * <b>Title：</b>TableList.java<br/>
 * <b>@author： </b>WML<br/>
 * <b>@date：</b>2016年10月25日 上午9:15:47<br/>  
 * <b>Copyright (c) 2016 ASPire Tech.</b>   
 *  </pre>
 */
@XStreamAlias("list")
public class TableList {
    
    /**
     * 数据表集合
     */
    @XStreamImplicit(itemFieldName="table")
    private List<Table> table;

    public List<Table> getTable() {
        return table;
    }

    public void setTable(List<Table> table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "TableList [table=" + table + "]";
    }
    
}
