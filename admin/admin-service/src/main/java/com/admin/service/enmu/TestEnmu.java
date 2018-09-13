package com.admin.service.enmu;

/**
 * @author ms
 * @Description: class description
 * @Package com.admin.service.enmu
 * @date: Created in 2018/9/11  13:47
 */
public enum TestEnmu {


    TEST_ENUMERATE("test:%s", 360, "测试");


    private String key;


    private Integer expire;


    private String desc;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    TestEnmu(String key, Integer expire, String desc) {
        this.key = key;
        this.expire = expire;
        this.desc = desc;
    }

    public String join(String... args) {
        return String.format(this.getKey(), args);
    }


    public static void main(String[] args) {
        String key = TestEnmu.TEST_ENUMERATE.join("18881888188");
        System.out.println(key);
    }
}
