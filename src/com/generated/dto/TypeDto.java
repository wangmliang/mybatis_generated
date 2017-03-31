package com.generated.dto;

/**
 * 是否导包
 * <pre>
 * <b>Title：</b>TypeDto.java<br/>
 * <b>Description：</b><br/>
 * <b>@author： </b>ynt<br/>
 * <b>@date：</b>2016年7月13日 下午2:02:46<br/>  
 * <b>Copyright (c) 2016 ASPire Tech.</b>   
 *  </pre>
 */
public class TypeDto {
    /**
     * 是否  0：不导入  1:导入 
     * import java.util.Date;
     */
    private String isDate = "0";
    
    /**
     * 是否 0：不导入  1:导入 
     * import java.util.Arrays;
     */
    private String isByte = "0";

    /**
     * 是否0:不导入  1：导入
     * import java.math.BigDecimal;
     */
    private String isBigDecimal = "0";

    public String getIsDate() {
        return isDate;
    }

    public void setIsDate(String isDate) {
        this.isDate = isDate;
    }

    public String getIsByte() {
        return isByte;
    }

    public void setIsByte(String isByte) {
        this.isByte = isByte;
    }

    public String getIsBigDecimal() {
        return isBigDecimal;
    }

    public void setIsBigDecimal(String isBigDecimal) {
        this.isBigDecimal = isBigDecimal;
    }

    @Override
    public String toString() {
        return "TypeDto [isDate=" + isDate + ", isByte=" + isByte + ", isBigDecimal="
               + isBigDecimal + "]";
    }
    
}
