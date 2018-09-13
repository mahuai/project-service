package com.admin.service.utils;

import com.alibaba.fastjson.JSONObject;
import com.base.utils.JsonUtils;
import com.base.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @author future
 * @Description:
 * @Package com.admin.service.utils
 * @date: Created in 2018/7/416:00
 */
@Service
public class RedisImpl implements RedisUtils {

    @Autowired
    private RedisTemplate<String, ?> redisTemplate;

    /**
     * 删除key
     *
     * @param key
     */
    @Override
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }


    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    @Override
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 保存key value
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean set(final String key, final String value) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
        return result;
    }


    /**
     * 保存key value 存活时间
     *
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    @Override
    public boolean set(final String key, final String value, final Long expireTime) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
        redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        return result;
    }

    /**
     * 根据key获取value
     *
     * @param key
     * @return
     */
    @Override
    public String get(final String key) {
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] value = connection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });
        return result;
    }

    /**
     * 给定key 存活时间
     *
     * @param key
     * @param expire
     * @return
     */
    @Override
    public boolean expire(final String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    /**
     * 保存key value(集合)
     *
     * @param key
     * @param list
     * @param <T>
     * @return
     */
    @Override
    public <T> boolean setList(String key, List<T> list) {
        String value = JsonUtils.objtoJson(list);
        return set(key, value);
    }

    /**
     * 保存key value(集合) 存活时间
     *
     * @param key
     * @param list
     * @param expireTime
     * @param <T>
     * @return
     */
    @Override
    public <T> boolean setList(final String key, final List<T> list, final Long expireTime) {
        String value = JsonUtils.objtoJson(list);
        return set(key, value, expireTime);
    }

    /**
     * 根据key 获取value
     *
     * @param key
     * @param clz
     * @param <T>
     * @return
     */
    @Override
    public <T> List<T> getList(final String key, final Class<T> clz) {
        String json = get(key);
        if (json != null) {
            List<T> list = null;
            try {
                list = JSONObject.parseArray(json, clz);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }
        return null;
    }

    /**
     * 将所有指定值插入密钥存储的列表的开头
     * @param key
     * @param obj
     * @return
     */
    @Override
    public long lPush(final String key, final Object obj) {
        final String value = JsonUtils.objtoJson(obj);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = connection.lPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });
        return result;
    }

    /**
     *将所有指定的值插入存储在key中的列表的尾部
     * @param key
     * @param obj
     * @return
     */
    @Override
    public long rPush(final String key, final Object obj) {
        final String value = JsonUtils.objtoJson(obj);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = connection.rPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });
        return result;
    }

    /**
     * 删除并返回key中存储的列表的第一个元素。
     * @param key
     * @return
     */
    @Override
    public String lPop(final String key) {
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] res = connection.lPop(serializer.serialize(key));
                return serializer.deserialize(res);
            }
        });
        return result;
    }


    /**
     * 获得key的剩余存活时间
     * @param key
     * @return
     */
    @Override
    public Long TTL(String key) {
        return redisTemplate.getExpire(key);
    }


    @Override
    public boolean saveObject(String key, Object obj) {
        String json = JsonUtils.objtoJson(obj);
        return set(key, json);
    }

    @Override
    public boolean saveObject(String key, Object obj, Long expireTime) {
        String json = JsonUtils.objtoJson(obj);
        return set(key, json, expireTime);
    }

    @Override
    public <T> T getObject(String key, Class<T> clz) {
        String json = get(key);
        if (json != null) {
            try {
                return JSONObject.parseObject(json, clz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
