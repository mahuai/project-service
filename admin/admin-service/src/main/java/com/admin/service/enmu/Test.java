package com.admin.service.enmu;

/**
 * @author ms
 * @Description:
 * @Package com.admin.service.enmu
 * @date: Created in 2018/7/27 11:54
 */
public enum Test {

    TEST_ENMU("test","测试");

    private String name;

    private String desc;

    public String getName() {
        return name;
    }

    Test(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
