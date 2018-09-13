package com.admin.service.config;


import com.admin.service.thread.ConsumerThread;
import com.admin.service.thread.ProducerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * @author future
 * @Description:
 * @Package com.admin.service.config project-service
 * @date: Created in 2018/7/1214:32
 */
@Configuration
public class KafKaConfig {

    private static final Logger logger = LoggerFactory.getLogger(KafKaConfig.class);

    public KafKaConfig() {
        logger.info("kafka------------>{}", KafKaConfig.class);
    }

    @Bean
    @Order(1)
    public String producerThread() {
        ProducerThread producerThread = new ProducerThread();
        producerThread.start();
        return null;
    }


    @Bean
    @Order(2)
    public String consumerThread() {
        ConsumerThread consumerThread = new ConsumerThread(Arrays.asList("project-topic"));
        consumerThread.start();
        return null;
    }


}
