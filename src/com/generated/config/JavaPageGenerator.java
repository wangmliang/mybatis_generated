package com.generated.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 页面文件配置参数
 * <pre>
 * <b>Title：</b>JavaPageGenerator.java<br/>
 * <b>@author： </b>WML<br/>
 * <b>@date：</b>2016年10月25日 下午4:33:38<br/>  
 * <b>Copyright (c) 2016 ASPire Tech.</b>   
 *  </pre>
 */
@XStreamAlias("javaPageGenerator")
public class JavaPageGenerator {
    
    /**
     * 包名
     */
    @XStreamAlias("targetPackage")
    @XStreamAsAttribute
    private String targetPackage;
    
    /**
     * 项目名
     */
    @XStreamAlias("targetProject")
    @XStreamAsAttribute
    private String targetProject;

    public String getTargetPackage() {
        return targetPackage;
    }

    public void setTargetPackage(String targetPackage) {
        this.targetPackage = targetPackage;
    }

    public String getTargetProject() {
        return targetProject;
    }

    public void setTargetProject(String targetProject) {
        this.targetProject = targetProject;
    }

    @Override
    public String toString() {
        return "JavaPageGenerator [targetPackage=" + targetPackage + ", targetProject="
               + targetProject + "]";
    }
}
