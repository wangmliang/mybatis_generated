package com.generated.util;

import com.generated.dto.TypeDto;

public class Type {
    
    /**
     * 【db】字段类型  转化成 【sql】字段类型
     * @param value db字段类型
     * @return
     */
    public static String getTypeBySql(String value) {
        if(value.equalsIgnoreCase("int")) {
            return "INTEGER";
        } else if(value.equalsIgnoreCase("binary")) {
            return "BINARY";
        } else if(value.equalsIgnoreCase("varbinary")) {
            return "VARBINARY";
        } else if(value.equalsIgnoreCase("point")) {
            return "OTHER";
        } else if(value.equalsIgnoreCase("linestring")) {
            return "OTHER";
        } else if(value.equalsIgnoreCase("polygon")) {
            return "OTHER";
        } else if(value.equalsIgnoreCase("geometry")) {
            return "BINARY";
        } else if(value.equalsIgnoreCase("multipoint")) {
            return "OTHER";
        } else if(value.equalsIgnoreCase("multilinestring")) {
            return "OTHER";
        } else if(value.equalsIgnoreCase("multipolygon")) {
            return "OTHER";
        } else if(value.equalsIgnoreCase("geometrycollection")) {
            return "OTHER";
        } else if(value.equalsIgnoreCase("set")) {
            return "CHAR";
        } else if(value.equalsIgnoreCase("enum")) {
            return "CHAR";
        } else if(value.equalsIgnoreCase("longtext")) {
            return "LONGVARCHAR";
        } else if(value.equalsIgnoreCase("mediumtext")) {
            return "LONGVARCHAR";
        } else if(value.equalsIgnoreCase("text")) {
            return "LONGVARCHAR";
        } else if(value.equalsIgnoreCase("tinytext")) {
            return "VARCHAR";
        } else if(value.equalsIgnoreCase("longblob")) {
            return "LONGVARCHAR";
        } else if(value.equalsIgnoreCase("mediumblob")) {
            return "LONGVARCHAR";
        } else if(value.equalsIgnoreCase("blob")) {
            return "LONGVARCHAR";
        } else if(value.equalsIgnoreCase("tinyblob")) {
            return "BINARY";
        } else if(value.equalsIgnoreCase("datetime")) {
            return "TIMESTAMP";
        } else if(value.equalsIgnoreCase("timestamp")) {
            return "TIMESTAMP";
        } else if(value.equalsIgnoreCase("year")) {
            return "Date";
        } else if(value.equalsIgnoreCase("date")) {
            return "Date";
        } else if(value.equalsIgnoreCase("time")) {
            return "TIME";
        } else if(value.equalsIgnoreCase("varchar")) {
            return "VARCHAR";
        } else if(value.equalsIgnoreCase("char")) {
            return "CHAR";
        } else if(value.equalsIgnoreCase("decimal")) {
            return "DECIMAL";
        } else if(value.equalsIgnoreCase("float")) {
            return "REAL";
        } else if(value.equalsIgnoreCase("double")) {
            return "DOUBLE";
        } else if(value.equalsIgnoreCase("bit")) {
            return "BIT";
        } else if(value.equalsIgnoreCase("bigint")) {
            return "BIGINT";
        } else if(value.equalsIgnoreCase("mediumint")) {
            return "INTEGER";
        } else if(value.equalsIgnoreCase("smallint")) {
            return "SMALLINT";
        } else if(value.equalsIgnoreCase("tinyint")) {
            return "TINYINT";
        } else if(value.equalsIgnoreCase("Integer")) {
            return "INTEGER";
        }
        return "";
    }
    
    /**
     * 【db】字段类型   转化成   【entity】属性类型
     * @param value
     * @return
     */
    public static String getTypeByEntity(String value) {
        if(value.equalsIgnoreCase("int")) {
            return "Integer";
        } else if(value.equalsIgnoreCase("binary")) {
            return "byte[]";
        } else if(value.equalsIgnoreCase("varbinary")) {
            return "byte[]";
        } else if(value.equalsIgnoreCase("point")) {
            return "Object";
        } else if(value.equalsIgnoreCase("linestring")) {
            return "Object";
        } else if(value.equalsIgnoreCase("polygon")) {
            return "Object";
        } else if(value.equalsIgnoreCase("geometry")) {
            return "byte[]";
        } else if(value.equalsIgnoreCase("multipoint")) {
            return "Object";
        } else if(value.equalsIgnoreCase("multilinestring")) {
            return "Object";
        } else if(value.equalsIgnoreCase("multipolygon")) {
            return "Object";
        } else if(value.equalsIgnoreCase("geometrycollection")) {
            return "Object";
        } else if(value.equalsIgnoreCase("set")) {
            return "String";
        } else if(value.equalsIgnoreCase("enum")) {
            return "String";
        } else if(value.equalsIgnoreCase("longtext")) {
            return "String";
        } else if(value.equalsIgnoreCase("mediumtext")) {
            return "String";
        } else if(value.equalsIgnoreCase("text")) {
            return "String";
        } else if(value.equalsIgnoreCase("tinytext")) {
            return "String";
        } else if(value.equalsIgnoreCase("longblob")) {
            return "byte[]";
        } else if(value.equalsIgnoreCase("mediumblob")) {
            return "byte[]";
        } else if(value.equalsIgnoreCase("blob")) {
            return "byte[]";
        } else if(value.equalsIgnoreCase("tinyblob")) {
            return "byte[]";
        } else if(value.equalsIgnoreCase("datetime")) {
            return "Date";
        } else if(value.equalsIgnoreCase("timestamp")) {
            return "Date";
        } else if(value.equalsIgnoreCase("year")) {
            return "Date";
        } else if(value.equalsIgnoreCase("date")) {
            return "Date";
        } else if(value.equalsIgnoreCase("time")) {
            return "Date";
        } else if(value.equalsIgnoreCase("varchar")) {
            return "String";
        } else if(value.equalsIgnoreCase("char")) {
            return "String";
        } else if(value.equalsIgnoreCase("decimal")) {
            return "BigDecimal";
        } else if(value.equalsIgnoreCase("float")) {
            return "Float";
        } else if(value.equalsIgnoreCase("double")) {
            return "Double";
        } else if(value.equalsIgnoreCase("bit")) {
            return "Boolean";
        } else if(value.equalsIgnoreCase("bigint")) {
            return "Long";
        } else if(value.equalsIgnoreCase("mediumint")) {
            return "Integer";
        } else if(value.equalsIgnoreCase("smallint")) {
            return "Short";
        } else if(value.equalsIgnoreCase("tinyint")) {
            return "Byte";
        } else if(value.equalsIgnoreCase("Integer")) {
            return "Integer";
        }
        return "";
    }
    
    /**
     * 存在 返回byte 或是array 模板导包
     * import java.util.Arrays;
     * import java.util.Date;
     * @param value
     * @return
     */
    public static TypeDto isTypeByEntity(String value, TypeDto dto) {
        if(value.equalsIgnoreCase("binary")) {
            dto.setIsByte("1");
        } else if(value.equalsIgnoreCase("varbinary")) {
            dto.setIsByte("1");
        } else if(value.equalsIgnoreCase("geometry")) {
            dto.setIsByte("1");
        } else if(value.equalsIgnoreCase("longblob")) {
            dto.setIsByte("1");
        } else if(value.equalsIgnoreCase("mediumblob")) {
            dto.setIsByte("1");
        } else if(value.equalsIgnoreCase("blob")) {
            dto.setIsByte("1");
        } else if(value.equalsIgnoreCase("tinyblob")) {
            dto.setIsByte("1");
        } else if(value.equalsIgnoreCase("tinyint")) {
            dto.setIsByte("1");
        } else if(value.equalsIgnoreCase("datetime")) {
            dto.setIsDate("1");
        } else if(value.equalsIgnoreCase("timestamp")) {
            dto.setIsDate("1");
        } else if(value.equalsIgnoreCase("year")) {
            dto.setIsDate("1");
        } else if(value.equalsIgnoreCase("date")) {
            dto.setIsDate("1");
        } else if(value.equalsIgnoreCase("decimal")) {
            dto.setIsBigDecimal("1");
        }
        return dto;
    }
}
