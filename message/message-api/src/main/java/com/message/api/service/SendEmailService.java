package com.message.api.service;

import com.message.api.entity.request.SendEmailRequest;
import com.message.api.entity.response.MessageResponse;

/**
 * @author ms
 * @Description: class description
 * @Package com.message.api.service
 * @date: Created in 2018/8/7  11:58
 */
public interface SendEmailService {

    /**
     * 发送邮箱
     *
     * @param sendEmailRequest
     * @return
     */
    MessageResponse sendMail(SendEmailRequest sendEmailRequest);
}
