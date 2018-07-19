package com.admin.service.thread;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Properties;

/**
 * @author ms
 * @Description:
 * @Package com.admin.service.thread
 * @date: Created in 2018/7/16 15:36
 */
public class ConsumerThread extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerThread.class);

    private final KafkaConsumer consumer;

    public ConsumerThread(List<String> topics) {
        logger.info("appoint topic--->{}", ConsumerThread.class);
        this.consumer = new KafkaConsumer<>(assembleProperties());
        consumer.subscribe(topics);
    }

    @Override
    public void run() {
        logger.info("thread start--------->{}", System.currentTimeMillis());
        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
            consumerRecords.forEach(records -> {
                logger.info("\ntopic----->{}\npartition---->{}\ntimestamp----->{}\nkey---->{}\nvalue----->{}\noffset---->{}",
                        records.topic(), records.partition(), records.timestamp(), records.key(), records.value(), records.offset());
            });
        }
    }


    private static Properties assembleProperties() {
        Properties properties = new Properties();
        /**
         * 连接kafka
         */
        properties.put("bootstrap.servers", "localhost:9092");
        /**
         * consumer group
         */
        properties.put("group.id", "project");

        /**
         * 如果为true，则消费者的偏移量将在后台定期提交。
         */
        properties.put("enable.auto.commit", "true");
        /**
         *
         * 消费者偏移提交给zookeeper的频率（以毫秒为单位）。
         */
        properties.put("auto.commit.interval.ms", "1000");
        /**
         * 序列化
         */
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return properties;
    }
}
