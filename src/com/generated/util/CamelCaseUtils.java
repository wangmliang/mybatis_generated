package com.generated.util;

public class CamelCaseUtils {
	
	private static final char SEPARATOR = '_';

	/**
	 * UserInfo --> user_info
	 * @param s
	 * @return
	 */
    public static String toUnderlineName(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i >= 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    if (i > 0) sb.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * user_id --> UserId;
     * @param s
     * @return
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));   
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    /**
     * user_info --> UserInfo
     * @param s
     * @return
     */
    public static String toUpperCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        int a = 1;
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == SEPARATOR) {
                upperCase = true;
                a++;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));   
                upperCase = false;
                a = 0;
            } else {
                if(a != 0) {
                    if(!Character.isLowerCase(c)) {
                        sb.append(Character.toLowerCase(c)); 
                    }else{
                        sb.append(Character.toUpperCase(c));   
                    } 
                    a = 0;
                }else{
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    
    public static String initcap(String str) {
        char[] ch = str.toCharArray();
        if(ch[0] >= 'a' && ch[0] <= 'z'){
         ch[0] = (char)(ch[0] - 32);
        }
        return new String(ch);
    }
    
    public static void main(String[] args) {
        System.out.println(CamelCaseUtils.toUnderlineName("ISOCertifiedStaff"));
        System.out.println(CamelCaseUtils.toUnderlineName("CertifiedStaff"));
        System.out.println(CamelCaseUtils.toUnderlineName("UserID"));
        System.out.println(CamelCaseUtils.toCamelCase("iso_certified_staff"));
        System.out.println(CamelCaseUtils.toCamelCase("certified_staff"));
        System.out.println(CamelCaseUtils.toCamelCase("user_id"));
        System.out.println(CamelCaseUtils.toCamelCase("user"));
        System.out.println(CamelCaseUtils.toUpperCase("user_info"));
        System.out.println(CamelCaseUtils.toUpperCase("id"));
    }
}

