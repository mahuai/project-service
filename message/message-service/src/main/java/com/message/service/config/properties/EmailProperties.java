package com.message.service.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ms
 * @Description: class description
 * @Package com.message.service.config.properties
 * @date: Created in 2018/8/7  13:29
 */
@Component
@ConfigurationProperties(prefix = "spring.mail")
public class EmailProperties {


    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
