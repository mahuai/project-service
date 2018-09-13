package com.message.service.thread;

import com.message.service.wrapper.QueueWrapper;
import com.message.service.queue.SystemQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


/**
 * @author ms
 * @Description: class description
 * @Package com.message.service.thread
 * @date: Created in 2018/8/7  17:04
 */
public class SendSmsThread implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(SendSmsThread.class);

    private Object object = new Object();

    @Override
    public void run() {
        logger.info("start---------------->:{}", Thread.currentThread().getName());
        synchronized (object) {
            while (true) {
                try {
                    if (SystemQueue.QUEUE_ARRAY.size() > 0) {
                        logger.info("--------------------->dequeue");
                        QueueWrapper wrapper = SystemQueue.QUEUE_ARRAY.poll(10, TimeUnit.SECONDS);
                        logger.info("phone----->:{}", wrapper.getPhone());
                        SystemQueue.EXECUTOR.execute(new RecordThread(wrapper));
                    } else {
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    logger.error("queue poll error:", e);
                }
            }
        }
    }


    class RecordThread extends Thread {

        public RecordThread(QueueWrapper wrapper) {
            this.phone = wrapper.getPhone();
            this.subject = wrapper.getSubject();
            this.content = wrapper.getContent();
        }


        private String phone;

        private String subject;

        private String content;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }


        @Override
        public void run() {
            logger.info("------------> add record");
        }
    }
}


