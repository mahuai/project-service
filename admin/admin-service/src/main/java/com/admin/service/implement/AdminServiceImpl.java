package com.admin.service.implement;

import com.admin.api.entity.request.AdminLoginRequestBean;
import com.admin.api.entity.response.AdminResponseBean;
import com.admin.api.exception.LoginException;
import com.admin.api.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * impl admin service
 *
 * @author ms
 */
public class AdminServiceImpl implements AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    /**
     * 登录
     *
     * @param adminLoginRequestBean
     * @return
     * @throws LoginException
     */
    public AdminResponseBean login(AdminLoginRequestBean adminLoginRequestBean) throws LoginException {
        return null;
    }
}
