package com.admin.api.entity.request;

import java.io.Serializable;
import java.util.Date;

/**
 * @author future
 * @Description:
 * @Package com.admin.api.entity.requestproject-service
 * @date: Created in 2018/7/317:36
 */
public class AdminPageListRequestBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户登录名
     **/
    private java.lang.String account;

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

    private Integer pageNum;

    private Integer pageSize;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
