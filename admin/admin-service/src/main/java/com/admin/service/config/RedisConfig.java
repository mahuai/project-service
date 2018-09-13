package com.admin.service.config;

import com.admin.service.config.properties.RedisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.HashSet;
import java.util.LinkedList;


/**
 * @author future
 * @Description:
 * @Package com.admin.service.config project-service
 * @date: Created in 2018/7/415:36
 */
@Configuration
public class RedisConfig {

    private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Autowired
    private RedisProperties properties;

    public RedisConfig() {
        logger.info("init redis-------->{}", RedisConfig.class);
    }

    /**
     * redis单节点配置类
     *
     * @return
     */
    @Bean
    public RedisStandaloneConfiguration redisStandaloneConfiguration() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setDatabase(properties.getDatabase());
        redisStandaloneConfiguration.setHostName(properties.getHost());
        redisStandaloneConfiguration.setPort(properties.getPort());
        return redisStandaloneConfiguration;
    }



    @Bean
    public JedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory(redisStandaloneConfiguration());
    }

    @Bean
    public RedisSerializer stringRedisSerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory());
        redisTemplate.setKeySerializer(stringRedisSerializer());
        redisTemplate.setValueSerializer(stringRedisSerializer());
        redisTemplate.setHashKeySerializer(stringRedisSerializer());
        redisTemplate.setHashValueSerializer(stringRedisSerializer());
        return redisTemplate;
    }
}
