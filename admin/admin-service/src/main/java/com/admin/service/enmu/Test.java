package com.admin.service.enmu;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author ms
 * @Description:
 * @Package com.admin.service.enmu
 * @date: Created in 2018/7/27 11:54
 */
public enum Test {

    GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE;


    private static Map<String, Object> map = new Hashtable<>(8);

    static {
        for (Test test : values()) {
            map.put(test.name(), test);
        }
    }

    public static Test resolve(String method) {
        return (method != null ? (Test) map.get(method) : null);
    }

    public boolean matches(String method) {
        return (this == resolve(method));
    }

    public static void main(String[] args) {
        Test test = resolve("POST");
        System.out.println(test.matches("POST"));
        System.out.println(test);

    }


}
