package com.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.service
 * @Description: TODO
 * @date 2018/5/21 15:13
 */
@Service
public class ScheduledService {


    @Scheduled(cron = "* * * * * *")
    public void hello(){
        System.out.println("hello...");
    }



}
