package com.admin.api.entity.request;

import java.io.Serializable;

/**
 * 登录请求bean
 *
 * @author ms
 */
public class AdminLoginRequestBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id 32位UUID
     **/
    private java.lang.String id;
    /**
     * 用户登录名
     **/
    private java.lang.String loginName;
    /**
     * 登录用密码
     **/
    private java.lang.String loginPwd;
    /**
     * 用户昵称
     **/
    private java.lang.String nickname;
    /**
     * 邮箱
     **/
    private java.lang.String email;
    /**
     * 角色表id
     **/
    private java.lang.String roleId;
    /**
     * 角色名称
     **/
    private java.lang.String roleName;
    /**
     * 管理员等级
     **/
    private java.lang.Integer level;
    /**
     * 盐值
     **/
    private java.lang.String salt;
    /**
     * 0：无效 1：有效 2：删除
     **/
    private java.lang.Integer effect;
    /**
     * 手机号
     **/
    private java.lang.String cellphone;
    /**
     * 创建时间
     **/
    private java.util.Date createTime;
    /**
     * 最后修改时间
     **/
    private java.util.Date updateTime;

    /**
     * 获取 主键id 32位UUID
     **/
    public java.lang.String getId() {
        return this.id;
    }

    /**
     * 设置 主键id 32位UUID
     **/
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * 获取 用户昵称
     **/
    public java.lang.String getNickname() {
        return this.nickname;
    }

    /**
     * 设置 用户昵称
     **/
    public void setNickname(java.lang.String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取 邮箱
     **/
    public java.lang.String getEmail() {
        return this.email;
    }

    /**
     * 设置 邮箱
     **/
    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    /**
     * 获取 角色表id
     **/
    public java.lang.String getRoleId() {
        return this.roleId;
    }

    /**
     * 设置 角色表id
     **/
    public void setRoleId(java.lang.String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取 角色名称
     **/
    public java.lang.String getRoleName() {
        return this.roleName;
    }

    /**
     * 设置 角色名称
     **/
    public void setRoleName(java.lang.String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取 管理员等级
     **/
    public java.lang.Integer getLevel() {
        return this.level;
    }

    /**
     * 设置 管理员等级
     **/
    public void setLevel(java.lang.Integer level) {
        this.level = level;
    }

    /**
     * 获取 盐值
     **/
    public java.lang.String getSalt() {
        return this.salt;
    }

    /**
     * 设置 盐值
     **/
    public void setSalt(java.lang.String salt) {
        this.salt = salt;
    }

    /**
     * 获取 0：无效 1：有效 2：删除
     **/
    public java.lang.Integer getEffect() {
        return this.effect;
    }

    /**
     * 设置 0：无效 1：有效 2：删除
     **/
    public void setEffect(java.lang.Integer effect) {
        this.effect = effect;
    }

    /**
     * 获取 手机号
     **/
    public java.lang.String getCellphone() {
        return this.cellphone;
    }

    /**
     * 设置 手机号
     **/
    public void setCellphone(java.lang.String cellphone) {
        this.cellphone = cellphone;
    }

    /**
     * 获取 创建时间
     **/
    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 创建时间
     **/
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 最后修改时间
     **/
    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 设置 最后修改时间
     **/
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 验证码
     */
    private String verificationCode;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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
