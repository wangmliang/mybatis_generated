package com.generated.dto;

import java.util.Date;

/**
 * db 查询所有的数据表信息
 * @author wml
 */
public class DBTableInfoDto {

	/**
	 * 表名
	 */
	private String tableName;

	/**
	 * 表注释信息
	 */
	private String tableComment;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "TableInfo [tableName=" + tableName + ", tableComment="
				+ tableComment + ", createTime=" + createTime + "]";
	}

}
