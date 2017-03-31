package com.generated.dto;


import java.util.List;


/**
 * 数据表 Dto
 * 
 * @author wml
 */
public class TableInfo {
    /**
     * 数据表名
     */
    private String tableName;

    /**
     * java类名
     */
    private String className;
    
    /**
     * 方法名（首字母小写）
     */
    private String methodName;

    /**
     * 主键类型 java.lang.Integer ...
     */
    private String idType;
    
    /**
     * 主键
     */
    private String primaryKey;
    
    /**
     * 主键大写(参数)
     */
    private String primaryKeyCapital;

    /**
     * 实体主键名称
     */
    private String primaryKeyEntity;

    /**
     * 主键entity类型
     */
    private String primaryKeyEntityType;

    /**
     * 主键DB类型
     */
    private String primaryKeyDBType;
    
    /**
     * 表注释
     */
    private String tableComment;

    /**
     * 表字段集合
     */
    private List<Columns> list;

    /**
     * 外键集合（一对一）
     */
    private List<ForeignKeyDto> foreignKeyList;

    /**
     * 实体类导包外键集合
     */
    private List<ForeignKeyDto> entityForeignKeyList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getPrimaryKeyEntity() {
        return primaryKeyEntity;
    }

    public void setPrimaryKeyEntity(String primaryKeyEntity) {
        this.primaryKeyEntity = primaryKeyEntity;
    }

    public String getPrimaryKeyEntityType() {
        return primaryKeyEntityType;
    }

    public void setPrimaryKeyEntityType(String primaryKeyEntityType) {
        this.primaryKeyEntityType = primaryKeyEntityType;
    }

    public String getPrimaryKeyDBType() {
        return primaryKeyDBType;
    }

    public void setPrimaryKeyDBType(String primaryKeyDBType) {
        this.primaryKeyDBType = primaryKeyDBType;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public List<Columns> getList() {
        return list;
    }

    public void setList(List<Columns> list) {
        this.list = list;
    }

    public List<ForeignKeyDto> getForeignKeyList() {
        return foreignKeyList;
    }

    public void setForeigignKeyList(List<ForeignKeyDto> foreignKeyList) {
        this.foreignKeyList = foreignKeyList;
    }

    public void setForeignKeyList(List<ForeignKeyDto> foreignKeyList) {
        this.foreignKeyList = foreignKeyList;
    }

    public List<ForeignKeyDto> getEntityForeignKeyList() {
        return entityForeignKeyList;
    }

    public void setEntityForeignKeyList(List<ForeignKeyDto> entityForeignKeyList) {
        this.entityForeignKeyList = entityForeignKeyList;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getPrimaryKeyCapital() {
        return primaryKeyCapital;
    }

    public void setPrimaryKeyCapital(String primaryKeyCapital) {
        this.primaryKeyCapital = primaryKeyCapital;
    }

    @Override
    public String toString() {
        return "TableInfo [tableName=" + tableName + ", className=" + className + ", methodName="
               + methodName + ", idType=" + idType + ", primaryKey=" + primaryKey
               + ", primaryKeyCapital=" + primaryKeyCapital + ", primaryKeyEntity="
               + primaryKeyEntity + ", primaryKeyEntityType=" + primaryKeyEntityType
               + ", primaryKeyDBType=" + primaryKeyDBType + ", tableComment=" + tableComment
               + ", list=" + list + ", foreignKeyList=" + foreignKeyList
               + ", entityForeignKeyList=" + entityForeignKeyList + "]";
    }

}
