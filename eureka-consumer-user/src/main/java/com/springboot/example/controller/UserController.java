package com.springboot.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.example.controller
 * @Description: TODO
 * @date 2018/5/22 14:50
 */
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/buy")
    public String buyTicket(String name){
        String s = restTemplate.getForObject("http://EUREKA-PROVIDER-TICKET/ticket", String.class);
        return name + "够买了" + s;
    }


}
