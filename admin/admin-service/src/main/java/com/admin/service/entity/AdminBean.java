package com.admin.service.entity;

/**
 * 管理员实体Bean
 * @author ms
 */
public class AdminBean {

    /**
     * 登录账号
     */
    private String loginAccount;


    /**
     * 登录密码
     */
    private String loginPwd;

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
}
