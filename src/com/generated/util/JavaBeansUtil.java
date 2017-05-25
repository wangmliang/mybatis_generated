/*
 *  Copyright 2005 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.generated.util;

import java.util.Locale;

/**
 * javaBean 操作类
 * @author WML
 */
public class JavaBeansUtil {

    /**
     * 返回 java 实体getter 方法名 
     * user_id --> getUserId
     * @param property
     * @return the getter method name
     */
    public static String getGetterMethodName(String property) {
        StringBuilder sb = new StringBuilder();
        sb.append(property);
        if (Character.isLowerCase(sb.charAt(0))) {
            if (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1))) {
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            }
        }
        sb.insert(0, "get"); //$NON-NLS-1$
        return sb.toString();
    }

    /**
     * 返回 java 实体setter 方法名 
     * user_id --> setUserId
     * @param property
     * @return the setter method name
     */
    public static String getSetterMethodName(String property) {
        StringBuilder sb = new StringBuilder();
        sb.append(property);
        if (Character.isLowerCase(sb.charAt(0))) {
            if (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1))) {
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            }
        }
        sb.insert(0, "set"); //$NON-NLS-1$
        return sb.toString();
    }

    /**
     * 属性大写</br>
     * true: 	user_id --> UserId  </br>
     * false:	user_id --> userId
     * @param inputString	待操作字符串
     * @param firstCharacterUppercase	true / false
     * @return 转化后的字符串
     */
    public static String getCamelCaseString(String inputString, boolean firstCharacterUppercase) {
        StringBuilder sb = new StringBuilder();
        boolean nextUpperCase = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            switch (c) {
            case '_':
            case '-':
            case '@':
            case '$':
            case '#':
            case ' ':
            case '/':
            case '&':
                if (sb.length() > 0) {
                    nextUpperCase = true;
                }
                break;
            default:
                if (nextUpperCase) {
                    sb.append(Character.toUpperCase(c));
                    nextUpperCase = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                break;
            }
        }
        if (firstCharacterUppercase) {
        	char[] c = inputString.toCharArray();
        	if(c.length < 2 || c[1] != '_')
        		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }
        return sb.toString();
    }

    /**
     * 返回字段的getter()
     * @param inputString
     * @return the valid property name
     */
    public static String getValidPropertyName(String inputString) {
        String answer;
        if (inputString == null) {
            answer = null;
        } else if (inputString.length() < 2) {
            answer = inputString.toLowerCase(Locale.US);
        } else {
            if (Character.isUpperCase(inputString.charAt(0)) && !Character.isUpperCase(inputString.charAt(1))) {
                answer = inputString.substring(0, 1).toLowerCase(Locale.US) + inputString.substring(1);
            } else {
                answer = inputString;
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
        /*System.out.println(JavaBeansUtil.getGetterMethodName("user_id"));
        System.out.println(JavaBeansUtil.getSetterMethodName("user_id"));
        System.out.println(JavaBeansUtil.getValidPropertyName("user_id"));
        System.out.println(JavaBeansUtil.getCamelCaseString("user_id", true));
        System.out.println(JavaBeansUtil.getCamelCaseString("user_id", false));
        
        System.out.println(JavaBeansUtil.getGetterMethodName(JavaBeansUtil.getCamelCaseString("user_id", true)));
        System.out.println(JavaBeansUtil.getSetterMethodName(JavaBeansUtil.getCamelCaseString("user_id", false)));
        System.out.println(JavaBeansUtil.getSetterMethodName(JavaBeansUtil.getCamelCaseString("city_id", false)));*/
    	System.out.println(getCamelCaseString("user_id", true));
    	System.out.println(getCamelCaseString("x_coord_id", true));
    	
    	System.out.println(getCamelCaseString("user_id", false));
    	System.out.println(getCamelCaseString("x_coord", false));
    }
}
