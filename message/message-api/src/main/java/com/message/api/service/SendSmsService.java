package com.message.api.service;

import com.message.api.entity.request.SendSmsRequest;
import com.message.api.entity.response.MessageResponse;

/**
 * @author ms
 * @Description: class description
 * @Package com.message.api.service
 * @date: Created in 2018/8/7  17:02
 */
public interface SendSmsService {


    /**
     * 发送短信
     *
     * @param sendSmsRequest
     * @return
     */
    MessageResponse sendSms(SendSmsRequest sendSmsRequest);
}
