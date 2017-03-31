package com.generated.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Java Bean 配置项
 * <pre>
 * <b>Title：</b>JavaModelGenerator.java<br/>
 * <b>@author： </b>WML<br/>
 * <b>@date：</b>2016年10月18日 下午2:07:53<br/>  
 * <b>Copyright (c) 2016 ASPire Tech.</b>   
 *  </pre>
 */
@XStreamAlias("javaModelGenerator")
public class JavaModelGenerator {
    
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
        return "JavaModelGenerator [targetPackage=" + targetPackage + ", targetProject="
               + targetProject + "]";
    }
    
}
