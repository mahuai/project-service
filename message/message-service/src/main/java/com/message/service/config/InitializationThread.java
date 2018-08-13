package com.message.service.config;

import com.message.service.queue.SystemQueue;
import com.message.service.thread.SendSmsThread;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ms
 * @Description: class description
 * @Package com.message.service.config
 * @date: Created in 2018/8/8  10:04
 */

@Configuration
public class InitializationThread {


    @Bean
    public String initThread() {
        SystemQueue.EXECUTOR.execute(new SendSmsThread());
        return null;
    }
}
