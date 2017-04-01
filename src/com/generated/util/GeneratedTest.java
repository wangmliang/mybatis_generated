package com.generated.util;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import com.generated.config.Configuration;
import com.generated.config.Context;
import com.generated.config.DBInfo;
import com.generated.config.Operator;
import com.generated.config.TableList;
import com.generated.config.Type;
import com.generated.dto.GenerateInfo;

/**
 * 自动生成代码
 * <pre>
 * <b>Title：</b>GeneratedTest.java<br/>
 * <b>@author： </b>WML<br/>
 * <b>@date：</b>2016年10月25日 上午9:37:45<br/>  
 * <b>Copyright (c) 2016 ASPire Tech.</b>   
 *  </pre>
 */
public class GeneratedTest {
    
    private static final String CONFIG_FILE = "-configfile"; //$NON-NLS-1$
    private static final String OVERWRITE = "-overwrite"; //$NON-NLS-1$
    private static final String FILEURL = "/com/generated/ftl/";
    
    /**
     * 获取启动参数
     * @param args
     * @return
     * @author WML
     * 2016年10月25日-上午9:36:58
     */
    private static Map<String, String> parseCommandLine(String[] args) {
        Map<String, String> arguments = new HashMap<String, String>();
        
        for (int i = 0; i < args.length; i++) {
            if (CONFIG_FILE.equalsIgnoreCase(args[i])) {
                if ((i + 1) < args.length) {
                    arguments.put(CONFIG_FILE, args[i + 1]);
                } else {
                    System.out.println("Value missing after " + CONFIG_FILE);
                    System.exit(-1);
                }
                i++;
            } else if (OVERWRITE.equalsIgnoreCase(args[i])) {
                arguments.put(OVERWRITE, "Y"); //$NON-NLS-1$
            }
        }
        return arguments;
    }
    
    /**
     * 程序入口
     * @param args
     * @author WML
     * 2016年10月25日-上午9:36:49
     */
	public static void main(String[] args) {
	    System.out.println("......start......");
	    Map<String, String> arguments = parseCommandLine(args);

        String configfile = arguments.get(CONFIG_FILE);
        File configurationFile = new File(configfile);
        if (!configurationFile.exists()) {
            System.out.println("XML配置文件不存在...");
            return;
        }

        Configuration config = null;
        try {
            /**
             * 解析XML配置，获取配置参数
             */
            config = XmlUtil.toBeanFromFile(configurationFile.getPath(), null, Configuration.class, "UTF-8");
            if(null == config) {
                System.out.println("[" + configurationFile.getName() + "]解析失败,请确认配置是否正确...");
                System.exit(-1);
            }
            Operator operator = config.getOperator();
            Type type = config.getType();
            Context context = config.getContext();
            TableList tableList = config.getContext().getTableList();
            
            if(null == operator || null == type || null == context || null == tableList) {
                System.out.println("[" + configurationFile.getName() + "]必要参数错误,请确认配置是否正确...");
                System.exit(-1);
            }
            
            /**
             * 自动生成配置信息
             */
            GenerateInfo info = new GenerateInfo();
            info.setAuthor(operator.getAuthor());
            info.setCorporateName(operator.getCorporateName());
            info.setEntityPackage(context.getJavaModelGenerator().getTargetPackage());
            info.setMapperPackage(context.getJavaClientGenerator().getTargetPackage());
            info.setXmlPackage(context.getSqlMapGenerator().getTargetPackage());
            info.setXmlExtendPackage(context.getSqlMapExtendGenerator().getTargetPackage());
            info.setServicePackage(context.getJavaServiceGenerator().getTargetPackage());
            info.setControllerPackage(context.getJavaControllerGenerator().getTargetPackage());
            info.setPagePackage(context.getJavaPagerGenerator().getTargetPackage());
            info.setEntityFilePath("/" + context.getJavaModelGenerator().getTargetProject() + "/" + info.getEntityPackage().replaceAll("\\.", "/") + "/");
            info.setMapperFilePath("/" + context.getJavaClientGenerator().getTargetProject() + "/" + info.getMapperPackage().replaceAll("\\.", "/") + "/");
            info.setXmlFilePath("/" + context.getSqlMapGenerator().getTargetProject() + "/" + info.getXmlPackage().replaceAll("\\.", "/") + "/");
            info.setXmlExtendFilePath("/" + context.getSqlMapExtendGenerator().getTargetProject() + "/" + info.getXmlExtendPackage().replaceAll("\\.", "/") + "/");
            info.setServicePath("/" + context.getJavaServiceGenerator().getTargetProject() + "/" + info.getServicePackage().replaceAll("\\.", "/") + "/");
            info.setControllerPath("/" + context.getJavaControllerGenerator().getTargetProject() + "/" + info.getControllerPackage().replaceAll("\\.", "/") + "/");
            info.setPagePath("/" + context.getJavaPagerGenerator().getTargetProject() + "/" + info.getPagePackage().replaceAll("\\.", "/") + "/");
            info.setFtlPath(FILEURL);
            
            DBInfo dbInfo = new DBInfo();
            dbInfo.setDriver(context.getJdbcConnection().getDriverClass());
            dbInfo.setUrl(context.getJdbcConnection().getConnectionURL());
            dbInfo.setUser(context.getJdbcConnection().getUserName());
            dbInfo.setPassword(context.getJdbcConnection().getPassWord());
            /**
             * 代码自动生成
             */
            generated(info, dbInfo, tableList, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("......end......");
	}
	
	/**
	 * 代码自动生成
	 * @param generateInfo 生成配置项
	 * @param dbInfo       数据库连接配置项
	 * @param tableList    数据表集合
	 * @param type			 身份标识
	 * @author WML
	 * 2016年10月25日-上午9:25:42
	 */
	public static void generated(GenerateInfo generateInfo, DBInfo dbInfo, TableList tableList, Type type) {
	  // 生成代码入口
      Connection con = JdbcConnectionUtil.getDatabaseMetaData(dbInfo.getDriver(), dbInfo.getUrl(), dbInfo.getUser(), dbInfo.getPassword());
      
      // 截取数据库名称
      String db = "";
      String[] urlStr = dbInfo.getUrl().split("/");
      if(urlStr.length == 1) {
          urlStr = dbInfo.getUrl().split("\\:");
      } 
      db = urlStr[urlStr.length - 1];
      // 剔除编码等非数据库信息
      db = db.split("\\?")[0];
      DatabaseMetaDateApplication.generateMain(generateInfo, con, db, tableList.getTable(), type.getValue());
	}
}

