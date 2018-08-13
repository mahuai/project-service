package com.admin.api.entity.response;

import io.swagger.annotations.ApiModelProperty;

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
    @ApiModelProperty(value = "主键", name = "id")
    private java.lang.String id;
    /**
     * 用户登录名
     **/
    @ApiModelProperty(value = "账号", name = "account")
    private java.lang.String account;
    /**
     * 登录用密码
     **/
    @ApiModelProperty(value = "密码", name = "password")
    private java.lang.String password;
    /**
     * 用户昵称
     **/
    @ApiModelProperty(value = "昵称", name = "nickName")
    private java.lang.String nickName;
    /**
     * 邮箱
     **/
    @ApiModelProperty(value = "邮箱", name = "email")
    private java.lang.String email;
    /**
     * 角色表id
     **/
    @ApiModelProperty(value = "角色ID", name = "roleId")
    private java.lang.String roleId;
    /**
     * 角色名称
     **/
    @ApiModelProperty(value = "角色名称", name = "roleName")
    private java.lang.String roleName;
    /**
     * 管理员等级
     **/
    @ApiModelProperty(value = "等级", name = "level")
    private java.lang.Integer level;
    /**
     * 盐值
     **/
    @ApiModelProperty(value = "盐值", name = "salt")
    private java.lang.String salt;
    /**
     * 0：无效 1：有效 2：删除
     **/
    @ApiModelProperty(value = "是否有效", name = "effect")
    private java.lang.Integer effect;
    /**
     * 手机号
     **/
    @ApiModelProperty(value = "手机号", name = "phone")
    private java.lang.String phone;
    /**
     * 创建时间
     **/
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private java.util.Date createTime;
    /**
     * 最后修改时间
     **/
    @ApiModelProperty(value = "修改时间", name = "updateTime")
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
