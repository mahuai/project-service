package com.message.service.implement;

import com.alibaba.dubbo.config.annotation.Service;
import com.message.api.entity.request.SendSmsRequest;
import com.message.api.entity.response.MessageResponse;
import com.message.api.service.SendSmsService;
import com.message.service.wrapper.QueueWrapper;
import com.message.service.queue.SystemQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author ms
 * @Description: class description
 * @Package com.message.service.implement
 * @date: Created in 2018/8/7  17:09
 */
@Service(interfaceClass = SendSmsService.class)
public class SendSmsServiceImpl implements SendSmsService {


    private static final Logger logger = LoggerFactory.getLogger(SendSmsServiceImpl.class);

    /**
     * 发送短信
     *
     * @param sendSmsRequest
     * @return
     */
    @Override
    public MessageResponse sendSms(SendSmsRequest sendSmsRequest) {
        QueueWrapper queueWrapper = new QueueWrapper().createWrapper(sendSmsRequest);
        logger.info("in queue phone------------>:{}", queueWrapper.getPhone());
        SystemQueue.QUEUE_ARRAY.add(queueWrapper);
        return MessageResponse.success();
    }
}
