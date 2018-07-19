package com.pro.utils;

import java.util.Random;

/**
 * @author future
 * @Description:
 * @Package com.pro.utilsproject-service
 * @date: Created in 2018/7/1017:40
 */
public class StringUtils extends org.apache.commons.codec.binary.StringUtils {

    /**
     * 生成指定长度的随机字符串
     *
     * @param pwd_len
     *            生成的密码的总长度
     * @return 随机字符串
     */
    public static String genRandomString(int pwd_len) {
        // 35是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = 62;
        int i; // 生成的随机数
        int count = 0; // 生成的密码的长度
        char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
                '7', '8', '9' };

        StringBuilder pwd = new StringBuilder();
        Random r = new Random();
        while (count < pwd_len) {
            // 生成随机数，取绝对值，防止生成负数，

            i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }

        return pwd.toString();
    }

    /**
     * 调用对象toString防止NullPointer
     * <pre>
     * StringUtils.valueOf(null)      = ""
     * StringUtils.valueOf("")        = ""
     * StringUtils.valueOf(obj)        = obj.toString()
     * </pre>
     * @author LiuZhaoning
     * @param value
     * @return String
     */
    public static String valueOf(final Object value) {
        return value == null ? "" : value.toString();
    }

    /**
     * 如果为空显示0.00
     * @author sunweipan
     * @param value
     * @return
     */
    public static String decValueOf(final Object value) {
        return value == null ? "0.00" : value.toString();
    }

    /**
     * 转换为下划线
     *
     * @param camelCaseName
     * @return
     */
    public static String underscoreName(String camelCaseName) {
        StringBuilder result = new StringBuilder();
        if (camelCaseName != null && camelCaseName.length() > 0) {
            result.append(camelCaseName.substring(0, 1).toLowerCase());
            for (int i = 1; i < camelCaseName.length(); i++) {
                char ch = camelCaseName.charAt(i);
                if (Character.isUpperCase(ch)) {
                    result.append("_");
                    result.append(Character.toLowerCase(ch));
                } else {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
    public static boolean isNullOrEmpty(String str) {
        return str == null?true:str.isEmpty();
    }

    public static String replaceStar(String str) {
        return isNullOrEmpty(str)?"":(str.indexOf("@") == -1?str.replaceAll("(?<=\\d{3})\\d(?=\\d{4})", "*"):replaceStar(str.substring(0, str.indexOf("@"))) + str.substring(str.indexOf("@")));
    }

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0 || "null".equals(cs);
    }
}
