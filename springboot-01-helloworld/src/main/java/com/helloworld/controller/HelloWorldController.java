package com.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello World的Controller类
 */
@RestController
public class HelloWorldController {



    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}
