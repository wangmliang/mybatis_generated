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

	@Override
	public String toString() {
		return "DBColumnsInfo [columnsName=" + columnsName + ", typeName="
				+ typeName + ", remarks=" + remarks + "]";
	}
	
}
