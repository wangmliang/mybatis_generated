package com.generated.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.generated.config.Table;
import com.generated.dto.Columns;
import com.generated.dto.DBColumnsInfoDto;
import com.generated.dto.DBTableInfoDto;
import com.generated.dto.ForeignKeyDto;
import com.generated.dto.GenerateInfo;
import com.generated.dto.TableInfo;
import com.generated.dto.TypeDto;

/**
 * 代码自动生成入口 
 * <pre>
 * <b>Title：</b>DatabaseMetaDateApplication.java<br/>
 * <b>@author： </b>WML<br/>
 * <b>@date：</b>2016年10月18日 上午10:14:11<br/>  
 * <b>Copyright (c) 2016 ASPire Tech.</b>   
 *  </pre>
 */
public class DatabaseMetaDateApplication {
    
    /**
     * 生成代码入口
     * @param info      生成代码基础信息
     * @param conn      数据连接对象
     * @param db        数据库信息
     * @param tableList 数据表集合
     * @author WML
     * 2016年10月25日-下午2:49:17
     */
    public static void generateMain(GenerateInfo info, Connection conn, String db, List<Table> tableList) {
        try {
            /**
             * 配置文件自带数据表
             */
            if(null != tableList && !tableList.isEmpty()) {
                for (Table table : tableList) {
                    List<DBTableInfoDto> dbTableInfoDtos = getTableAll(conn, db, table.getTableName());
                    if(dbTableInfoDtos.isEmpty()) {
                        System.out.println(">>> 从[" + db + "]中获取数据表[" + table.getTableName() + "]信息异常...");
                        System.exit(-1);
                    }
                    generate(dbTableInfoDtos.get(0), info, conn, db);
                }
                System.exit(-1);
            }
            
            /**
             * 查询对应数据库连接下的所有的数据表
             */
            List<DBTableInfoDto> list = getTableAll(conn, db, null);
            if(list.isEmpty()) {
               System.out.println(">>> 从[" + db + "]中获取数据表信息异常...");
               System.exit(-1);
            } 
            for (DBTableInfoDto dbTableInfo : list) {
                generate(dbTableInfo, info, conn, db);
            }
        } catch (Exception e) {
            System.out.println("代码自动生成处理异常：" + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * 自动生成代码
     * @param dbTableInfo   
     * @param info
     * @param conn
     * @param db
     * @throws Exception
     * @author WML
     * 2016年10月25日-下午2:59:57
     */
    public static void generate(DBTableInfoDto dbTableInfo, GenerateInfo info, Connection conn, String db) throws Exception {
        /**
         * 根据表信息查询对应字段信息（字段名+类型+注释）
         */
        List<DBColumnsInfoDto> columnList = getColumnByTable(conn, db, dbTableInfo.getTableName());
        if(columnList.isEmpty()) {
            System.out.println("[" + db + "]中对应数据表[" + dbTableInfo.getTableName() + "]获取字段信息异常...");
            return;
        }
        TableInfo tableInfo = new TableInfo();
        tableInfo.setTableName(dbTableInfo.getTableName());
        tableInfo.setClassName(JavaBeansUtil.getCamelCaseString(dbTableInfo.getTableName(), true));
        tableInfo.setMethodName(JavaBeansUtil.getCamelCaseString(dbTableInfo.getTableName(), false));
        tableInfo.setTableComment(dbTableInfo.getTableComment());
        List<Columns> columnsList = new ArrayList<Columns>();
        TypeDto type = new TypeDto();
        for (DBColumnsInfoDto dbColumnsInfo : columnList) {
            Columns columns = new Columns();
            /**
             *  字段名
             */
            columns.setName(dbColumnsInfo.getColumnsName());
            columns.setClassName(JavaBeansUtil.getCamelCaseString(dbColumnsInfo.getColumnsName(), false));
            columns.setTersName(JavaBeansUtil.getCamelCaseString(dbColumnsInfo.getColumnsName(), true));
            /**
             *  字段类型
             */
            columns.setEntityType(Type.getTypeByEntity(dbColumnsInfo.getTypeName())); 
            columns.setDbType(Type.getTypeBySql(dbColumnsInfo.getTypeName()));  
            /**
             *  字段注释
             */
            columns.setRemark(dbColumnsInfo.getRemarks());    
            columnsList.add(columns);
            /**
             *  存主键信息
             */
            if(StringUtils.isBlank(tableInfo.getPrimaryKey())) {
                tableInfo.setPrimaryKey(columns.getName());
                tableInfo.setPrimaryKeyCapital(JavaBeansUtil.getCamelCaseString(dbColumnsInfo.getColumnsName(), true));
                tableInfo.setPrimaryKeyEntity(columns.getClassName());
                tableInfo.setPrimaryKeyDBType(columns.getDbType());
                tableInfo.setPrimaryKeyEntityType(columns.getEntityType());
            }
            type = Type.isTypeByEntity(dbColumnsInfo.getTypeName(), type);
        }
        
        /**
         *  字段List
         */
        tableInfo.setList(columnsList);
        
        /**
         *  根据数据表查询对应的外键信息
         */
        List<ForeignKeyDto> foreignKeyList = getForeignKeyByTable(conn, db, dbTableInfo.getTableName());
        
        /**
         *  外键List
         */
        tableInfo.setForeigignKeyList(foreignKeyList); 
        
        /**
         *  去除外键集合重复数据
         */
        for(int i = 0; i < foreignKeyList.size(); i++)   { 
            for(int j = foreignKeyList.size() - 1 ; j > i; j--)   { 
                if(foreignKeyList.get(j).equals(foreignKeyList.get(i)))   { 
                    foreignKeyList.remove(j); 
                } 
            } 
        } 
        
        /**
         *  实体类导包外键集合
         */
        tableInfo.setEntityForeignKeyList(foreignKeyList);
        
        /**
         *  设置是否需要导Arrays和Date包
         */
        info.setIsPackgeType(type);
        
        /**
         *  生成时间
         */
        info.setTime(new Date());
        
        /**
         *  生成信息
         */
        info.setTableInfo(tableInfo);
        
        /**
         * Freemarker 生成对象信息
         */
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("info", info);
        
        System.out.println("开始生成【" + tableInfo.getTableName() + "】表数据...");
        
        /**
         *  java 实体
         */
        Freemarker.printFile("entity.ftl", root, tableInfo.getClassName() + ".java", info.getEntityFilePath(), info.getFtlPath());
        
        /**
         *  mapper 接口
         */
        Freemarker.printFile("mapper.ftl", root, tableInfo.getClassName() + "Mapper.java", info.getMapperFilePath(), info.getFtlPath());
        
        /**
         *  xml文件
         */
        Freemarker.printFile("mapperXml.ftl", root, tableInfo.getClassName() + "Mapper.xml", info.getXmlFilePath(), info.getFtlPath());
        
        /**
         *  Service
         */
        Freemarker.printFile("service.ftl", root, tableInfo.getClassName() + "Service.java", info.getServicePath(), info.getFtlPath());
        
        /**
         *  Controller
         */
        Freemarker.printFile("controller.ftl", root, tableInfo.getClassName() + "Controller.java", info.getControllerPath(), info.getFtlPath());
        
        //jsp
        
        System.out.println("    【" + tableInfo.getTableName() + "】表数据已生成...");
    }
    
    /**
     * 查询对应数据库连接下的所有的数据表(表名+注释+时间)
     * @param conn	                           连接对象
     * @param db	                           数据库对象
     * @param tableName     数据表名
     * @throws SQLException 
     */
    public static List<DBTableInfoDto> getTableAll(Connection conn, String db, String tableName) throws SQLException {
    	String sql = "select TABLE_NAME, TABLE_COMMENT, CREATE_TIME from information_schema.tables where table_schema = ?"; 
    	if(StringUtils.isNotBlank(tableName)) {
    	    sql = "select TABLE_NAME, TABLE_COMMENT, CREATE_TIME from information_schema.tables where table_schema = ? and table_name = ?";
    	}
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        List<DBTableInfoDto> list = new ArrayList<DBTableInfoDto>();
        try { 
        	ps = conn.prepareStatement(sql); 
        	ps.setString(1, db);
        	if(StringUtils.isNotBlank(tableName)) {
        	    ps.setString(2, tableName);
            }
        	rs = ps.executeQuery(); 
        	while(rs.next()){ 
    			DBTableInfoDto tableInfo = new DBTableInfoDto();
        		tableInfo.setTableName(rs.getString("TABLE_NAME"));
        		tableInfo.setTableComment(rs.getString("TABLE_COMMENT"));
        		tableInfo.setCreateTime(rs.getDate("CREATE_TIME"));
        		list.add(tableInfo);
        	} 
        } catch (Exception e) { 
            System.out.println("查询对应数据库连接下的所有的数据表异常：" + e.getMessage());
            e.printStackTrace(); 
        } finally {
        	if(null != rs) {
        		rs.close();
        	}
        	if(null != ps) {
        		ps.close();
        	}
        }
        return list;
    }
    
    /**
     * 根据表信息查询对应字段信息（字段名+类型+注释）
     * @param conn	连接对象
     * @param db	数据库信息
     * @param tableName 表名
     * @throws SQLException
     */
    public static List<DBColumnsInfoDto> getColumnByTable(Connection conn, String db, String tableName) throws SQLException {
    	String sql = "select COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT from information_schema.columns "
    			+ "where table_schema = ? and table_name = ?"; 
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        List<DBColumnsInfoDto> list = new ArrayList<DBColumnsInfoDto>();
        try { 
        	ps = conn.prepareStatement(sql); 
        	ps.setString(1, db); 
        	ps.setString(2, tableName); 
        	rs = ps.executeQuery(); 
        	while(rs.next()){ 
        		DBColumnsInfoDto columns = new DBColumnsInfoDto();
        		columns.setColumnsName(rs.getString("COLUMN_NAME"));
        		columns.setTypeName(rs.getString("DATA_TYPE"));
        		columns.setRemarks(rs.getString("COLUMN_COMMENT"));
        		list.add(columns);
        	} 
        } catch (Exception e) { 
            System.out.println("根据表信息查询对应字段信息（字段名+类型+注释）异常：" + e.getMessage());
            e.printStackTrace(); 
        } finally {
        	if(null != rs) {
        		rs.close();
        	}
        	if(null != ps) {
        		ps.close();
        	}
        }
        return list;
    }
    
    /**
     * 根据数据表查询对应的外键信息(子表字段 + 父表表名 + 父表字段)
     * @param conn
     * @param db
     * @param tableName
     * @return
     */
    public static List<ForeignKeyDto> getForeignKeyByTable(Connection conn, String db, String tableName) {
    	List<ForeignKeyDto> list = new ArrayList<ForeignKeyDto>();
    	try {
    	        
			String sql = "select C.COLUMN_NAME as COLUMN_NAME, C.REFERENCED_TABLE_NAME as REFERENCED_TABLE_NAME, C.REFERENCED_COLUMN_NAME as REFERENCED_COLUMN_NAME"	
					+ " from INFORMATION_SCHEMA.KEY_COLUMN_USAGE C"
					+ " JOIN INFORMATION_SCHEMA. TABLES T ON T.TABLE_NAME = C.TABLE_NAME "
					+ " where C.REFERENCED_TABLE_NAME IS NOT NULL and C.TABLE_NAME = ?"
					+ " GROUP BY C.CONSTRAINT_NAME";
			
			PreparedStatement ps = null; 
	        ResultSet rs = null; 
        	ps = conn.prepareStatement(sql); 
        	ps.setString(1, tableName); 
        	rs = ps.executeQuery(); 
        	while(rs.next()){ 
        		ForeignKeyDto foreignKey = new ForeignKeyDto();
        		/**
        		 *  子表字段
        		 */
        		foreignKey.setFkColumnName(rs.getString("COLUMN_NAME"));  
        		/**
        		 *  父表表名
        		 */
        		foreignKey.setPkTablenName(rs.getString("REFERENCED_TABLE_NAME"));
        		foreignKey.setProperty(JavaBeansUtil.getCamelCaseString(rs.getString("REFERENCED_TABLE_NAME"), false));
        		foreignKey.setTersName(JavaBeansUtil.getCamelCaseString(rs.getString("REFERENCED_TABLE_NAME"), true));
        		/**
        		 *  父表字段
        		 */
        		foreignKey.setEntityName(!rs.getString("COLUMN_NAME").equals(rs.getString("REFERENCED_COLUMN_NAME")) ? 
                    JavaBeansUtil.getCamelCaseString(rs.getString("REFERENCED_TABLE_NAME") + "_" + rs.getString("COLUMN_NAME"), false) 
                    : JavaBeansUtil.getCamelCaseString(rs.getString("REFERENCED_TABLE_NAME"), false));
        		list.add(foreignKey);
        	}
		} catch (Exception e) {
		    System.out.println("根据数据表查询对应的外键信息异常：" + e.getMessage());
			e.printStackTrace();
		}
    	return list;
    }
}

