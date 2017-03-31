package com.generated.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 操作人信息
 * <pre>
 * <b>Title：</b>Operator.java<br/>
 * <b>@author： </b>WML<br/>
 * <b>@date：</b>2016年10月25日 上午9:12:22<br/>  
 * <b>Copyright (c) 2016 ASPire Tech.</b>   
 *  </pre>
 */
@XStreamAlias("operator")
public class Operator {
    
    /**
     * 作者
     */
    @XStreamAlias("author")
    @XStreamAsAttribute
    private String author;
    
    /**
     * 公司名称
     */
    @XStreamAlias("corporateName")
    @XStreamAsAttribute
    private String corporateName;

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

    @Override
    public String toString() {
        return "Operator [author=" + author + ", corporateName=" + corporateName + "]";
    }
    
}
