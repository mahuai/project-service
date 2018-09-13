package com.resource.service.enmu;

/**
 * @author ms
 * @Description: class description
 * @Package com.resource.service.enmu
 * @date: Created in 2018/8/29  10:03
 */
public enum ImageType {

    /**
     * 文件类型
     */
    CASE_TYPE(1, "案例");


    ImageType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    private Integer type;

    private String desc;

    public Integer getType() {
        return type;
    }


    public static void main(String[] args) {
        System.out.println(ImageType.CASE_TYPE);
    }

}
