package com.admin.service.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author future
 * @Description:
 * @Package com.admin.service.config.propertiesproject-service
 * @date: Created in 2018/7/415:46
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {


    /*****************JedisPoolConfig的参数*******************/
    /**
     * 最大连接数
     */
    private Integer maxTotal;
    /**
     * 最大空闲时间
     */
    private Integer maxIdle;
    /**
     * 每次最大连接数
     */
    private Integer numTestsPerEvictionRun;
    /**
     * 释放扫描的扫描间隔
     */
    private Integer timeBetweenEvictionRunsMillis;
    /**
     * 连接的最小空闲时间
     */
    private Integer minEvictableIdleTimeMillis;
    /**
     * 连接控歘按时间多久后释放，当空闲时间>该值且空闲连接>最大空闲连接数时直接释放
     */
    private Integer softMinEvictableIdleTimeMillis;
    /**
     * 获得链接时的最大等待毫秒数，小于0：阻塞不确定时间，默认-1
     */
    private Integer maxWaitMillis;
    /**
     * 在获得链接的时候检查有效性，默认false
     */
    private boolean testOnBorrow;
    /**
     * 在空闲时检查有效性，默认false
     */
    private boolean testWhileIdle;
    /**
     * 连接耗尽时是否阻塞，false报异常，true阻塞超时,默认true
     */
    private boolean blockWhenExhausted;

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getNumTestsPerEvictionRun() {
        return numTestsPerEvictionRun;
    }

    public void setNumTestsPerEvictionRun(Integer numTestsPerEvictionRun) {
        this.numTestsPerEvictionRun = numTestsPerEvictionRun;
    }

    public Integer getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(Integer timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public Integer getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(Integer minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public Integer getSoftMinEvictableIdleTimeMillis() {
        return softMinEvictableIdleTimeMillis;
    }

    public void setSoftMinEvictableIdleTimeMillis(Integer softMinEvictableIdleTimeMillis) {
        this.softMinEvictableIdleTimeMillis = softMinEvictableIdleTimeMillis;
    }

    public Integer getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(Integer maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public boolean isBlockWhenExhausted() {
        return blockWhenExhausted;
    }

    public void setBlockWhenExhausted(boolean blockWhenExhausted) {
        this.blockWhenExhausted = blockWhenExhausted;
    }

    private Integer port;

    private Integer database;

    private String password;

    private String host;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getDatabase() {
        return database;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
