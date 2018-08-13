package com.admin.api.entity.request;

import io.swagger.annotations.ApiModelProperty;

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
    @ApiModelProperty(value = "账号", name = "account")
    @NotNull(message = "账号不能为空")
    private java.lang.String account;
    /**
     * 登录用密码
     **/
    @ApiModelProperty(value = "密码", name = "password")
    @NotNull(message = "密码不能为空")
    private java.lang.String password;
    /**
     * 验证码
     */
    @ApiModelProperty(value = "验证码", name = "code")
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
