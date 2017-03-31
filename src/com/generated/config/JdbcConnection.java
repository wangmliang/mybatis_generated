package com.generated.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 数据库链接配置项
 * <pre>
 * <b>Title：</b>JdbcConnection.java<br/>
 * <b>@author： </b>WML<br/>
 * <b>@date：</b>2016年10月18日 下午2:04:35<br/>  
 * <b>Copyright (c) 2016 ASPire Tech.</b>   
 *  </pre>
 */
@XStreamAlias("jdbcConnection")
public class JdbcConnection {
    
    /**
     * 连接驱动
     */
    @XStreamAlias("driverClass")
    @XStreamAsAttribute
    private String driverClass;

    /**
     * 数据库地址
     */
    @XStreamAlias("connectionURL")
    @XStreamAsAttribute
    private String connectionURL;

    /**
     * 用户名
     */
    @XStreamAlias("userName")
    @XStreamAsAttribute
    private String userName;

    /**
     * 密码
     */
    @XStreamAlias("passWord")
    @XStreamAsAttribute
    private String passWord;

    /**
     * 获取 连接驱动
     * @return
     * @author WML
     * 2016年10月18日-下午2:05:57
     */
    public String getDriverClass() {
        return driverClass;
    }

    /**
     * 设置连接驱动
     * @param password
     * @author WML
     * 2016年10月18日-下午2:05:42
     */
    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    /**
     * 获取 连接地址
     * @return
     * @author WML
     * 2016年10月18日-下午2:05:57
     */
    public String getConnectionURL() {
        return connectionURL;
    }

    /**
     * 设置 连接地址
     * @param password
     * @author WML
     * 2016年10月18日-下午2:05:42
     */
    public void setConnectionURL(String connectionURL) {
        this.connectionURL = connectionURL;
    }

    /**
     * 获取 用户名
     * @return
     * @author WML
     * 2016年10月18日-下午2:05:57
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置 用户名
     * @param password
     * @author WML
     * 2016年10月18日-下午2:05:42
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 密码
     * @return
     * @author WML
     * 2016年10月18日-下午2:05:57
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * 设置 密码
     * @param password
     * @author WML
     * 2016年10月18日-下午2:05:42
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "JdbcConnection [driverClass=" + driverClass + ", connectionURL=" + connectionURL
               + ", userName=" + userName + ", passWord=" + passWord + "]";
    }
    
}
