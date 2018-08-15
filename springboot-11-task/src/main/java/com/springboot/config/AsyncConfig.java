package com.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.config
 * @date 2018/8/15 10:22
 */
@EnableAsync
@Configuration
public class AsyncConfig {

    @Value("${ansy.corePoolSize}")
    private int corePoolSize ;
    @Value("${ansy.maxPoolSize}")
    private int maxPoolSize;
    @Value("${ansy.queueCapacity}")
    private int queueCapacity;


    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        return executor;
    }
}
