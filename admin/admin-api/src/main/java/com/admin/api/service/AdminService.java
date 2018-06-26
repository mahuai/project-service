package com.admin.api.service;

import com.admin.api.entity.request.AdminLoginRequestBean;
import com.admin.api.entity.response.AdminResponseBean;
import com.admin.api.exception.LoginException;

/**
 * admin service
 * @author ms
 */
public interface AdminService {

    /**
     * 登录
     * @param adminLoginRequestBean
     * @return
     * @throws LoginException
     */
    AdminResponseBean login(AdminLoginRequestBean adminLoginRequestBean) throws LoginException;
}
