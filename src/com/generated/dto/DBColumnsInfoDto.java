package com.generated.dto;

/**
 * 数据表字段信息
 * @author WML
 */
public class DBColumnsInfoDto {
	/**
	 * 字段名
	 */
	private String columnsName;
	
	/**
	 * 数据类型
	 */
	private String typeName;
	
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
	 * 注释信息
	 */
	private String remarks;

	public String getColumnsName() {
		return columnsName;
	}

	public void setColumnsName(String columnsName) {
		this.columnsName = columnsName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
		return "DBColumnsInfoDto [columnsName=" + columnsName + ", typeName=" + typeName + ", isNull=" + isNull + ", charMaxLength=" + charMaxLength + ", numericPrecisionRadix="
				+ numericPrecisionRadix + ", numericScale=" + numericScale + ", remarks=" + remarks + "]";
	}

}
