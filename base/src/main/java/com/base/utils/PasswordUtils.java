package com.base.utils;

/**
 * @author future
 * @Description:
 * @Package com.third.utilsproject-service
 * @date: Created in 2018/7/511:29
 */
public class PasswordUtils {

    public static final String MIXED_STRING = "project";

    /**
     * 根据密码和盐进行加密
     *
     * @param pwd
     * @param salt
     * @return
     */
    public static String getPasswordByString(String pwd, String salt) {
        return getPwd(pwd, salt);
    }

    /**
     * 生成密码及盐值
     *
     * @return s[0] 密码
     * s[1] 盐值
     * s[2] 加密后密码
     */
    public static String[] getPassword() {
        String[] s = new String[3];
        s[0] = UUIDUtils.getUUID();
        s[1] = UUIDUtils.getStringRandom(8);
        s[2] = getPwd(s[0], s[1]);
        return s;
    }

    /**
     * 校验密码
     *
     * @param pwd  用户传入密码
     * @param sPwd 数据库密码
     * @param salt 数据库盐值
     * @return
     */
    public static boolean checkPassword(String pwd, String sPwd, String salt) {
        if (sPwd.equals(getPwd(pwd, salt))) {
            return true;
        }
        return false;
    }

    /**
     * 加密
     *
     * @param pwd
     * @param salt
     * @return
     */
    protected static String getPwd(String pwd, String salt) {
        pwd = MD5Utils.md5ToUpperCase(MIXED_STRING + pwd);
        return MD5Utils.md5ToUpperCase(pwd + salt);
    }

    public static void main(String[] args) {
        String salt=UUIDUtils.getStringRandom(8);
        System.out.println(salt);
        System.out.println(getPasswordByString("admin",salt));
    }
}
