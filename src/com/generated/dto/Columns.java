package com.generated.dto;

/**
 * 数据表字段集合
 * @author wml
 */
public class Columns {
	/**
	 * 字段名
	 */
	private String name;
	
	/**
	 * 实体属性名
	 */
	private String className;
	
	/**
	 * getter && setter 方法 名
	 */
	private String tersName;
	
	/**
	 * DB字段类型 int varchar ...
	 */
	private String dbType;
	
	/**
	 * 实体类类型
	 */
	private String entityType;
	
	/**
	 * 字段注释
	 */
	private String remark;

	public String getTersName() {
		return tersName;
	}

	public void setTersName(String tersName) {
		this.tersName = tersName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

    @Override
    public String toString() {
        return "Columns [name=" + name + ", className=" + className + ", tersName=" + tersName
               + ", dbType=" + dbType + ", entityType=" + entityType + ", remark=" + remark + "]";
    }

}
