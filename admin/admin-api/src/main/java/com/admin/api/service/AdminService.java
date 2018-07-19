package com.admin.api.service;

import com.admin.api.entity.request.AdminLoginRequestBean;
import com.admin.api.entity.request.AdminPageListRequestBean;
import com.admin.api.entity.request.AdminRegisterRequestBean;
import com.admin.api.entity.response.AdminResponseBean;
import com.admin.api.exception.LoginException;
import com.pro.base.bean.PageBean;

/**
 * admin service
 *
 * @author ms
 */
public interface AdminService {

    /**
     * 获取分页列表
     *
     * @param adminPageListRequestBean
     * @return
     * @throws LoginException
     */
    PageBean<AdminResponseBean> getPageList(AdminPageListRequestBean adminPageListRequestBean) throws LoginException;

    /**
     * 登录
     *
     * @param adminLoginRequestBean
     * @return
     * @throws LoginException
     */
    AdminResponseBean login(AdminLoginRequestBean adminLoginRequestBean) throws LoginException;

    /**
     * 注册
     *
     * @param adminRegisterRequestBean
     * @return
     * @throws LoginException
     */
    AdminResponseBean register(AdminRegisterRequestBean adminRegisterRequestBean) throws LoginException;
}
