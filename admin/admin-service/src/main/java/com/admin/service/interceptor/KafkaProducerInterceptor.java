package com.admin.service.interceptor;

import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author ms
 * @Description:
 * @Package com.admin.service.interceptor
 * @date: Created in 2018/7/16 11:26
 */
public class KafkaProducerInterceptor implements ProducerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerInterceptor.class);


    @Override
    public ProducerRecord onSend(ProducerRecord record) {
        logger.info("\ntopic-------->{}\npartition--------->{}\nvalue------->{}\nkey-------->{}\ntimestamp-------->{}",
                record.topic(), record.partition(), record.key(), record.value(), record.timestamp());
        return record;
    }


    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        if (exception != null) {
            logger.error("send error:{}", exception);
        }
        logger.info("\ntopic----->{}\npartition----->{}\noffset---->{}\ntimestamp------>{}",
                metadata.topic(), metadata.partition(), metadata.offset(), metadata.timestamp());
    }

    /**
     * 关闭拦截器
     */
    @Override
    public void close() {
        logger.info("interceptor close.......");
    }

    /**
     * 使用给定的键值对配置该类
     */
    @Override
    public void configure(Map<String, ?> configs) {

    }
}
