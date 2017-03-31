package com.generated.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 * JDBC 连接驱动帮助类
 * @author WML
 */
public class JdbcConnectionUtil {
	
	private static DatabaseMetaData dbMetaData = null;   
    
    private static Connection conn = null;   
  
    /**
     * 配置驱动
     */
    public static Connection getDatabaseMetaData(String driver, String url, String user, String password)   
    {   
        try  
        {   
            if (dbMetaData == null)   
            {   
                Class.forName(driver);   
                conn = DriverManager.getConnection(url, user, password);   
                dbMetaData = conn.getMetaData();   
            }   
        } catch (Exception e)   
        {   
            e.printStackTrace();   
        }   
        return conn;
    }
    
    /**
     * 关闭连接
     */
    public void colseCon() {   
        try {   
            if (conn != null)   
            {   
                conn.close();   
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
    }
}
