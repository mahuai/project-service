package com.admin.api.entity.request;

/**
 * 登录请求bean
 *
 * @author ms
 */
public class AdminLoginRequestBean {

    /**
     * 登录账号
     */
    private String loginAccount;


    /**
     * 登录密码
     */
    private String loginPwd;

    /**
     * 验证码
     */
    private String verificationCode;

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
