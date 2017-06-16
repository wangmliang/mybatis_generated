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
	 * 是否非空
	 */
	private Boolean isNull;
	
	/**
	 * 字符串最大长度
	 */
	private Integer charMaxLength;;
	
	/**
	 * 近似数字数据、精确数字数据、整型数据或货币数据的精度基数。否则，返回 NULL
	 * 金额类型长度
	 */
	private Integer numericPrecisionRadix;
	
	/**
	 * 近似数字数据、精确数字数据、整数数据或货币数据的小数位数。否则，返回 NULL。
	 * 金额类型保留位数
	 */
	private Integer numericScale;
	
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

    public Boolean getIsNull() {
		return isNull;
	}

	public void setIsNull(Boolean isNull) {
		this.isNull = isNull;
	}

	public Integer getCharMaxLength() {
		return charMaxLength;
	}

	public void setCharMaxLength(Integer charMaxLength) {
		this.charMaxLength = charMaxLength;
	}

	public Integer getNumericPrecisionRadix() {
		return numericPrecisionRadix;
	}

	public void setNumericPrecisionRadix(Integer numericPrecisionRadix) {
		this.numericPrecisionRadix = numericPrecisionRadix;
	}

	public Integer getNumericScale() {
		return numericScale;
	}

	public void setNumericScale(Integer numericScale) {
		this.numericScale = numericScale;
	}

	@Override
	public String toString() {
		return "Columns [name=" + name + ", className=" + className + ", tersName=" + tersName + ", dbType=" + dbType + ", entityType=" + entityType + ", isNull=" + isNull + ", charMaxLength="
				+ charMaxLength + ", numericPrecisionRadix=" + numericPrecisionRadix + ", numericScale=" + numericScale + ", remark=" + remark + "]";
	}

}
