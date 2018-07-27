package com.admin.service.implement;

import com.admin.api.service.AmqpService;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ms
 * @Description:
 * @Package com.admin.service.implement
 * @date: Created in 2018/7/23 15:58
 */
@Service(interfaceClass = AmqpService.class)
public class AmqpServiceImpl implements AmqpService {

    private static final Logger logger = LoggerFactory.getLogger(AmqpServiceImpl.class);

    @Autowired
    private RabbitTemplate amqpTemplate;

    /**
     * convertAndSend
     *
     * @param queue
     * @param obj
     * @return
     */
    @Override
    public String convertAndSend(String queue, Object obj) {
        amqpTemplate.convertAndSend(queue, obj);
        String result = (String) amqpTemplate.receiveAndConvert(queue);
        logger.info("result---------------->:{}", result);
        return result;
    }
}
