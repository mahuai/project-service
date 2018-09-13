package com.base.utils;

/**
 * @author ms
 * @Description: class description
 * @Package com.base.utils
 * @date: Created in 2018/8/7  16:31
 */
public class AttachmentSuffixUtil {

    /**
     * 截取最后一个出现的字符后面的所有字符
     *
     * @param suffix
     * @return
     */
    public static String getSuffix(String suffix, String character) {
        return character + suffix.substring(suffix.lastIndexOf(character) + 1);
    }
}
