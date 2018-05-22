package com.springboot.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.example.controller
 * @Description: TODO
 * @date 2018/5/22 15:11
 */
@Controller
public class HelloController {


    @GetMapping("/")
    public String hello(){

        return "hello";
    }

}
