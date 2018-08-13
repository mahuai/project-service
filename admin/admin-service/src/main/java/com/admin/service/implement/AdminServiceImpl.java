package com.admin.service.implement;

import com.admin.api.entity.request.AdminLoginRequestBean;
import com.admin.api.entity.request.AdminPageListRequestBean;
import com.admin.api.entity.request.AdminRegisterRequestBean;
import com.admin.api.entity.response.AdminResponseBean;
import com.admin.api.exception.LoginException;
import com.admin.api.service.AdminService;
import com.admin.service.dao.AdminDao;
import com.admin.service.entity.AdminBean;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.pro.base.bean.PageBean;
import com.pro.utils.PasswordUtils;
import com.pro.utils.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * implement admin service
 *
 * @author ms
 */
@Service(interfaceClass = AdminService.class)
public class AdminServiceImpl implements AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminDao<AdminBean> adminDao;


    /**
     * 获取分页列表
     *
     * @param adminPageListRequestBean
     * @return
     * @throws LoginException
     */
    @Override
    public PageBean<AdminResponseBean> getPageList(AdminPageListRequestBean adminPageListRequestBean) throws LoginException {
        try {
            PageHelper.startPage(adminPageListRequestBean.getPageNum(), adminPageListRequestBean.getPageSize());
            List<AdminBean> adminList = adminDao.getPageList(adminPageListRequestBean);
            Integer count = adminDao.queryCount(adminPageListRequestBean);
            return new PageBean<>(adminPageListRequestBean.getPageNum(), adminPageListRequestBean.getPageSize(), count, formatPageList(adminList));
        } catch (Exception e) {
            logger.error("get admin page list error:", e);
        }
        return null;
    }

    public List<AdminResponseBean> formatPageList(List<AdminBean> adminList) {
        List<AdminResponseBean> responseList = new ArrayList<>();
        if (adminList != null) {
            adminList.forEach(admin -> {
                responseList.add(formatBean(admin));
            });
        }
        return responseList;
    }

    public AdminResponseBean formatBean(AdminBean adminBean) {
        AdminResponseBean adminResponseBean = new AdminResponseBean();
        adminResponseBean.setAccount(adminBean.getLoginName());
        adminResponseBean.setEmail(adminBean.getEmail());
        adminResponseBean.setNickName(adminBean.getNickname());
        adminResponseBean.setRoleId(adminBean.getRoleId());
        adminResponseBean.setRoleName(adminBean.getRoleName());
        adminResponseBean.setEffect(adminBean.getEffect());
        return adminResponseBean;
    }

    /**
     * 登录
     *
     * @param adminLoginRequestBean
     * @return
     * @throws LoginException
     */
    @Override
    public AdminResponseBean login(AdminLoginRequestBean adminLoginRequestBean) throws LoginException {
        AdminBean admin = null;
        try {
            logger.info("账号：{}，密码：{}", adminLoginRequestBean.getAccount(), adminLoginRequestBean.getPassword());
            admin = (AdminBean) adminDao.getConditionsByInfo(new AdminBean(adminLoginRequestBean.getAccount(), null));
            if (admin == null) {
                throw new LoginException("账号未注册");
            }
            boolean flag = PasswordUtils.checkPassword(adminLoginRequestBean.getAccount(), admin.getLoginPwd(), admin.getSalt());
            if (flag) {
                logger.info("login success-------------->{}", admin.getLoginName());
                return formatBean(admin);
            }
        } catch (Exception e) {
            logger.error("login error: ", e);
        }
        return null;
    }

    /**
     * 注册
     *
     * @param adminRegisterRequestBean
     * @return
     * @throws LoginException
     */
    @Override
    public AdminResponseBean register(AdminRegisterRequestBean adminRegisterRequestBean) throws LoginException {
        return new AdminResponseBean(adminDao.add(conversion(adminRegisterRequestBean)));
    }


    protected AdminBean conversion(AdminRegisterRequestBean adminRegisterRequestBean) {
        AdminBean adminBean = new AdminBean();
        adminBean.setId(UUIDUtils.getUUID());
        adminBean.setLoginName(adminRegisterRequestBean.getAccount());
        adminBean.setCellphone(adminRegisterRequestBean.getPhone());
        adminBean.setNickname(adminRegisterRequestBean.getNickName());
        adminBean.setEffect(adminRegisterRequestBean.getEffect());
        adminBean.setSalt(UUIDUtils.getStringRandom(8));
        adminBean.setLoginPwd(PasswordUtils.getPasswordByString(adminRegisterRequestBean.getAccount(), adminBean.getSalt()));
        adminBean.setLevel(adminRegisterRequestBean.getLevel());
        adminBean.setRoleId(adminRegisterRequestBean.getRoleId());
        adminBean.setRoleName(adminRegisterRequestBean.getRoleName());
        adminBean.setEmail(adminRegisterRequestBean.getEmail());
        return adminBean;
    }
}
