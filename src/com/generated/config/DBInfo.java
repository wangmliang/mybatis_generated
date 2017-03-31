package com.generated.config;

/**
 * 数据库连接操作类
 * @author wml
 */
public class DBInfo {
	/**
	 * 连接驱动
	 */
	private String driver;
	
	/**
	 * 数据库地址
	 */
	private String url;
	
	/**
	 * 用户名
	 */
	private String user;
	
	/**
	 * 密码
	 */
	private String password;
	
	public String getDriver() {
		return driver;
	}
	
	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "DbUtils [driver=" + driver + ", url=" + url + ", user=" + user
				+ ", password=" + password + "]";
	}
	
}
