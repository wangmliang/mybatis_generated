/*
 * Type.java.java
 * 深圳市因纳特科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017年4月1日 上午10:27:57  Created
 * <b>Copyright (c) 2017 ASPire Tech.</b>  
 */
package com.generated.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**  
 * 
 * <pre>
 * <b>Title：</b>Type.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2017年4月1日 - 上午10:27:57<br/>  
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2017 ASPire Tech.</b>   
 * </pre>
 */
@XStreamAlias("type")
public class Type {
	
	/**
	 * 身份标识
	 */
	@XStreamAlias("value")
    @XStreamAsAttribute
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Type [value=" + value + "]";
	}
	
}
