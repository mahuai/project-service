package com.message.service.queue;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.message.service.bean.QueueWrapper;

import java.util.concurrent.*;


/**
 * @author ms
 * @Description: class description
 * @Package com.message.service.queue
 * @date: Created in 2018/8/7  16:54
 */
public class SystemQueue {

    /**
     * 阻塞队列
     */
    public volatile static BlockingQueue<QueueWrapper> QUEUE_ARRAY = new LinkedBlockingQueue<>(5000);
    /**
     * 线程池
     */
    protected static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("project-pool").build();
    public volatile static ExecutorService EXECUTOR = new ThreadPoolExecutor(10, 50,
            6000, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());


}
