package com.admin.api.entity.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 登录请求bean
 *
 * @author ms
 */
public class AdminLoginRequestBean implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 用户登录名
     **/
    @NotNull(message = "账号不能为空")
    private java.lang.String account;
    /**
     * 登录用密码
     **/
    @NotNull(message = "密码不能为空")
    private java.lang.String password;

    private String code;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
