package com.generated.dto;

/**
 * 外键操作DTO
 * <pre>
 * <b>Title：</b>ForeigignKeyDto.java<br/>
 * <b>@author： </b>WML<br/>
 * <b>@date：</b>2016年10月17日 下午2:42:07<br/>  
 * <b>Copyright (c) 2016 ASPire Tech.</b>   
 *  </pre>
 */
public class ForeignKeyDto {
    /**
     * 外键id
     */
    private String fkColumnName;
    
    /**
     * 外键对应表
     */
    private String pkTablenName;
    
    /**
     * 外键返回类型
     */
    private String property;
    
    /**
     * 实体表名
     */
    private String tersName;
    
    /**
     * 实体类名
     */
    private String entityName;
    
    public String getFkColumnName() {
        return fkColumnName;
    }

    public void setFkColumnName(String fkColumnName) {
        this.fkColumnName = fkColumnName;
    }

    public String getPkTablenName() {
        return pkTablenName;
    }

    public void setPkTablenName(String pkTablenName) {
        this.pkTablenName = pkTablenName;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getTersName() {
        return tersName;
    }

    public void setTersName(String tersName) {
        this.tersName = tersName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

	@Override
    public String toString() {
        return "ForeignKeyDto [fkColumnName=" + fkColumnName + ", pkTablenName=" + pkTablenName
               + ", property=" + property + ", tersName=" + tersName + ", entityName="
               + entityName + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((entityName == null) ? 0 : entityName.hashCode());
        result = prime * result + ((fkColumnName == null) ? 0 : fkColumnName.hashCode());
        result = prime * result + ((pkTablenName == null) ? 0 : pkTablenName.hashCode());
        result = prime * result + ((property == null) ? 0 : property.hashCode());
        result = prime * result + ((tersName == null) ? 0 : tersName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ForeignKeyDto other = (ForeignKeyDto)obj;
        if (tersName == null) {
            if (other.tersName != null) 
                return false;
        } else if (!tersName.equals(other.tersName)) 
            return false;
        return true;
    }
    
}
