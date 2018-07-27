package com.admin.api.service;

/**
 * @author ms
 * @Description:
 * @Package com.admin.api.service
 * @date: Created in 2018/7/23 15:56
 */
public interface AmqpService {

    /**
     * convertAndSend
     * @param queue
     * @param obj
     * @return
     */
    String convertAndSend(String queue, Object obj);
}
