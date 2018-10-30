package com.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author ms
 * @Description: class description
 * @Package com.admin.service
 * @date: Created in 2018/9/27  11:17
 *
 *
 * 实现 CommandLineRunner 或者 ApplicationRunner
 * SpringApplication.run() 执行完成后 想你所想 干你想干
 * @see org.springframework.boot.CommandLineRunner
 * @see org.springframework.boot.ApplicationRunner
 */
@Component
public class AdminLineRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AdminLineRunner.class);

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) {
        logger.info("---------------> execute admin line runner ");
    }
}
