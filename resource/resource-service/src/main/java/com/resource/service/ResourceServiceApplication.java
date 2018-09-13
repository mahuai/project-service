package com.resource.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ms
 */
@SpringBootApplication
@ImportResource("classpath:spring/*.xml")
public class ResourceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceServiceApplication.class, args);
    }
}
