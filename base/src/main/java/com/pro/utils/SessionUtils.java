package com.pro.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ms
 * @Description:
 * @Package com.pro.utils
 * @date: Created in 2018/7/18 11:22
 */
public class SessionUtils {

    private SessionUtils() {

    }

    /**
     * session().setAttribute
     *
     * @param request
     * @param key
     * @param value
     */
    public static void set(HttpServletRequest request, String key, Object value) {
        request.getSession().setAttribute(key, value);
    }

    /**
     * @param request
     * @param key
     * @return
     */
    public static Object get(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }

    /**
     * @param request
     * @param key
     */
    public static void remove(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);
    }

    /**
     * @param request
     */
    public static void clear(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

    }
}
