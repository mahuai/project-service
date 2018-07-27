package com.admin.api.entity.response;

import java.io.Serializable;
import java.util.Date;

/**
 * return properties
 *
 * @author ms
 */
public class AdminResponseBean  implements Serializable {

    private static final long serialVersionUID = 1L;

    public AdminResponseBean() {
    }

    public AdminResponseBean(Integer affectedRows) {
        this.affectedRows = affectedRows;
    }

    private Integer affectedRows;

    public Integer getAffectedRows() {
        return affectedRows;
    }

    public void setAffectedRows(Integer affectedRows) {
        this.affectedRows = affectedRows;
    }



    /**
     * 主键id 32位UUID
     **/
    private java.lang.String id;
    /**
     * 用户登录名
     **/
    private java.lang.String account;
    /**
     * 登录用密码
     **/
    private java.lang.String password;
    /**
     * 用户昵称
     **/
    private java.lang.String nickName;
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
    private java.lang.String phone;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
