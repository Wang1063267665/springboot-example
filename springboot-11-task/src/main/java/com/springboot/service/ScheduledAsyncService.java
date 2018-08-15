package com.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.service
 * @date 2018/8/15 10:26
 */
@Component
@Slf4j
@Async
public class ScheduledAsyncService {

    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled(){
        log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
    }
    @Scheduled(fixedRate = 5000)
    public void scheduled1() {
        log.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
    }
    @Scheduled(fixedDelay = 5000)
    public void scheduled2() {
        log.info("=====>>>>>fixedDelay{}",System.currentTimeMillis());
    }
}
