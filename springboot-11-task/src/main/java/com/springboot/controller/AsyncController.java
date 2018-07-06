package com.springboot.controller;

import com.springboot.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.controller
 * @Description: TODO
 * @date 2018/5/21 15:07
 */
@RestController
public class AsyncController {


    @Autowired
    AsyncService asyncService;

    @GetMapping("/hello")
    public String hello() throws InterruptedException {
        asyncService.hello();
        return "success";
    }
}
