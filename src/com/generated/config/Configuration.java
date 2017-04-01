package com.generated.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * XML全局配置
 * <pre>
 * <b>Title：</b>Configuration.java<br/>
 * <b>@author： </b>WML<br/>
 * <b>@date：</b>2016年10月18日 下午2:03:23<br/>  
 * <b>Copyright (c) 2016 ASPire Tech.</b>   
 *  </pre>
 */
@XStreamAlias("generatorConfiguration")
public class Configuration {
    
    /**
     * 公司信息
     */
    @XStreamAlias("operator")
    private Operator operator;
    
    /**
     * 身份标识
     */
    @XStreamAlias("type")
    private Type type;
    
    /**
     * XML配置主要元素 
     */
    @XStreamAlias("context")
    private Context context;
    
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
    public String toString() {
        return "Configuration [operator=" + operator + ", type=" + type + ", context=" + context + "]";
    }
    
}
