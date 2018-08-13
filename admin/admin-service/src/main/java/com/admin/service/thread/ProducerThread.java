package com.admin.service.thread;

import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author ms
 * @Description:
 * @Package com.admin.service.thread
 * @date: Created in 2018/7/16 9:52
 */
public class ProducerThread extends Thread {


    private static final Logger logger = LoggerFactory.getLogger(ProducerThread.class);

    private static final Integer SIZE = 5;


    @Override
    public void run() {
        logger.info("线程启动中------>{}", ProducerThread.class);
        Producer producer = new KafkaProducer(assembleProperties());
        for (int i = 0; i < SIZE; i++) {
            logger.info("send start------------------------>");

            /*try {
                RecordMetadata o = (RecordMetadata) producer.send(new ProducerRecord<>("project-topic", Integer.toString(i), Integer.toString(i))).get();
                logger.info("offset------------->:{}", o.offset());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }*/
            try {
                /**
                 * producer.send().get() 返回 RecordMetadata 可以获取消息的偏移量
                 */
                RecordMetadata o = (RecordMetadata) producer.send(new ProducerRecord<>("project-topic", Integer.toString(i), Integer.toString(i)), new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (exception != null) {
                            logger.error("send error-------->{}", exception);
                        } else {
                            logger.info("<------------------------------------------------------------->");
                            logger.info("The offset of the record we just sent is:{}", metadata.offset());
                            logger.info("<------------------------------------------------------------->");
                        }
                    }
                }).get();
                logger.info("offset------------->:{}", o.offset());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private static Properties assembleProperties() {
        Properties properties = new Properties();
        /**
         * 连接kafka
         */
        properties.put("bootstrap.servers", "localhost:9092");
        /**
         * acks=0如果设置为零，那么生产者将不会等待来自服务器的任何确认。
         * 该记录将立即添加到套接字缓冲区并视为已发送。在这种情况下，
         * 无法保证服务器已收到记录，并且retries配置将不会生效（因为客户端通常不会知道任何故障）。
         * 为每条记录返回的偏移量始终设置为-1。
         * acks=1这将意味着领导者将记录写入其本地日志，
         * 但无需等待所有关注者的完全确认即可做出回应。在这种情况下，
         * 如果领导者在确认记录后立即失败但在关注者复制之前，则记录将丢失。
         * acks=all这意味着领导者将等待整套同步副本以确认记录。这保证了只要至少一个同步副本仍然存活，
         * 记录就不会丢失。这是最强有力的保证。这相当于acks = -1设置。
         */
        properties.put("acks", "all");
        /**
         * 设置大于零的值将导致客户端重新发送任何发送失败且具有潜在瞬态错误的记录
         */
        properties.put("retries", 0);
        /**
         * 每当多个记录被发送到同一分区时，生产者将尝试将记录一起批量处理为更少的请求。
         * 这有助于客户端和服务器上的性能。此配置控制默认批量大小（以字节为单位）。
         */
        properties.put("batch.size", 16384);
        /**
         * 生产者将请求传输之间到达的任何记录组合到一个批处理请求中。
         * 通常情况下，只有在记录到达的速度超过发送速度时才会在负载下发生
         * 此设置通过添加少量人工延迟来实现此目的，即，不是立即发送记录，
         * 生产者将等待达到给定的延迟以允许发送其他记录，以便可以将发送一起批处理
         */
        properties.put("linger.ms", 1);
        /**
         * 生产者可用于缓冲等待发送到服务器的记录的内存总字节数。
         */
        properties.put("buffer.memory", 33554432);
        /**
         * 指定序列化
         */
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        /**
         * 拦截器
         */
        List<String> interceptors = new LinkedList<>();
        interceptors.add("com.admin.service.interceptor.KafkaProducerInterceptor");
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);
        return properties;
    }


}
