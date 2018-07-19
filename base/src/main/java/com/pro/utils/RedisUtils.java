package com.pro.utils;

import java.util.List;

/**
 * @author future
 * @Description:
 * @Package com.pro.utils project-service
 * @date: Created in 2018/7/415:30
 */
public interface RedisUtils {

    /**
     * 删除
     *
     * @param key
     */
    void remove(String key);

    /**
     * 是否存在
     *
     * @param key
     * @return
     */
    boolean exists(String key);

    /**
     * set
     *
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, String value);

    /**
     * 过期时间
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    boolean set(String key, String value, Long expireTime);

    /**
     * 获取
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * expire
     *
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * @param key
     * @param list
     * @param <T>
     * @return
     */
    <T> boolean setList(String key, List<T> list);

    /**
     * @param key
     * @param list
     * @param expireTime
     * @param <T>
     * @return
     */
    <T> boolean setList(String key, List<T> list, Long expireTime);

    /**
     * @param key
     * @param clz
     * @param <T>
     * @return
     */
    <T> List<T> getList(String key, Class<T> clz);

    /**
     * @param key
     * @param obj
     * @return
     */
    long lPush(String key, Object obj);

    /**
     * @param key
     * @param obj
     * @return
     */
    long rPush(String key, Object obj);

    /**
     * @param key
     * @return
     */
    String lPop(String key);

    /**
     * @param key
     * @return
     */
    Long TTL(String key);

    /**
     * @param key
     * @param obj
     * @return
     */
    boolean saveObject(String key, Object obj);

    /**
     * @param key
     * @param obj
     * @param expireTime
     * @return
     */
    boolean saveObject(String key, Object obj, Long expireTime);

    /**
     * @param key
     * @param clz
     * @param <T>
     * @return
     */
    <T> T getObject(String key, Class<T> clz);
}
