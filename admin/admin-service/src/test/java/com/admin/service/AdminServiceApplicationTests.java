package com.admin.service;

import com.admin.api.entity.request.AdminLoginRequestBean;
import com.admin.api.entity.response.AdminResponseBean;
import com.admin.api.service.AdminService;
import com.pro.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminServiceApplication.class)*/
public class AdminServiceApplicationTests {

    private static final String REDIS_KEY = "REDIS:TEST:";
    @Autowired
    private AdminService adminService;

    @Autowired
    private RedisUtils redisUtils;

    public void redisTest() {

    }

    //    @Test
    public void loginTest() {
        AdminLoginRequestBean requestBean = new AdminLoginRequestBean();
        requestBean.setAccount("admin");
        requestBean.setPassword("admin");
        AdminResponseBean responseBean = adminService.login(requestBean);
        if (responseBean != null) {
            System.out.println("查询成功");
        }
    }


    /*@Test
    public void pageListTest() {
        AdminPageListRequestBean adminPageListRequestBean = new AdminPageListRequestBean();
        adminPageListRequestBean.setPageNum(1);
        adminPageListRequestBean.setPageSize(10);
        PageBean<AdminResponseBean> responseList = adminService.getPageList(adminPageListRequestBean);
        if (responseList.getItems().size() > 0) {
            System.out.println("查询成功");
        }
    }

    @Test
    public void contextLoadsTest() {
        AdminRegisterRequestBean adminRegisterRequestBean = new AdminRegisterRequestBean();
        adminRegisterRequestBean.setLoginName("admin");
        adminRegisterRequestBean.setLoginPwd("admin");
        adminRegisterRequestBean.setNickname("差不多先生");
        adminRegisterRequestBean.setCellphone("18888888888");
        adminRegisterRequestBean.setEmail("18888888888@163.com");
        adminRegisterRequestBean.setRoleId("d20e7324e8e043fa910957a9b4842a6d");
        adminRegisterRequestBean.setRoleName("管理员");
        adminRegisterRequestBean.setLevel(1);
        adminRegisterRequestBean.setEffect(1);
        adminRegisterRequestBean.setSalt("a8f67e82");
        AdminResponseBean adminResponseBean = adminService.register(adminRegisterRequestBean);
        if (adminResponseBean.getAffectedRows() > 0) {
            System.out.println("插入成功");
        }
    }

    public static void main(String[] args) {
        System.out.println(UUIDUtils.getUUID());
    }*/

}
