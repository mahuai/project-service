package com.admin.api.entity.request;

import java.util.Date;

/**
 * @author future
 * @Description:
 * @Package com.admin.api.entity.requestproject-service
 * @date: Created in 2018/7/311:05
 */
public class AdminRegisterRequestBean {

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getEffect() {
        return effect;
    }

    public void setEffect(Integer effect) {
        this.effect = effect;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
