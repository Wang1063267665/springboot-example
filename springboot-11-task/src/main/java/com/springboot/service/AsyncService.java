package com.springboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.service
 * @Description: TODO
 * @date 2018/5/21 15:06
 */
@Service
public class AsyncService {

    /**
     *告诉spring这是一个一步的
     */
    @Async
    public void hello() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("处理等待中。。");
    }
}
