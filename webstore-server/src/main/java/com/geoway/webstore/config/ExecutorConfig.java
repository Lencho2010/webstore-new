package com.geoway.webstore.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/5 11:58
 * @Description:
 */
//@Slf4j
@EnableAsync
@Configuration
public class ExecutorConfig {
    private static final Logger logger = LoggerFactory.getLogger(ExecutorConfig.class);

    @Value("${threadPool.core-pool-size:10}")
    private int corePoolSize;

    @Value("${threadPool.max-pool-size:300}")
    private int maxPoolSize;

    @Value("${threadPool.queue-capacity:1000}")
    private int queueCapacity;

    @Value("${threadPool.threadNamePrefix:async-service-}")
    private String threadNamePrefix;

    @Value("${threadPool.keep-alive-seconds:600}")
    private int keepAliveSeconds;

    /**
     如果当前运行的线程数小于corePoolSize，那么就创建线程来执行任务（执行时需要获取全局锁）。
     如果运行的线程大于或等于corePoolSize，那么就把task加入BlockQueue。
     如果创建的任务数量大于BlockQueue的最大容量，那么创建新线程来执行该任务。
     如果创建线程导致当前运行的线程数超过maximumPoolSize，就根据饱和策略来拒绝该任务。
     */
    @Bean
    public ThreadPoolTaskExecutor asyncServiceExecutor() {
        logger.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(threadNamePrefix);
        // 非核心线程空闲存活时间
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setWaitForTasksToCompleteOnShutdown(true);

//        rejection-policy：当pool已经达到max size的时候，如何处理新任务
//        AbortPolicy，用于被拒绝任务的处理程序，它将抛出RejectedExecutionException。
//        CallerRunsPolicy，用于被拒绝任务的处理程序，它直接在execute方法的调用线程中运行被拒绝的任务。
//        DiscardOldestPolicy，用于被拒绝任务的处理程序，它放弃最旧的未处理请求，然后重试execute。
//        DiscardPolicy，用于被拒绝任务的处理程序，默认情况下它将丢弃被拒绝的任务。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
