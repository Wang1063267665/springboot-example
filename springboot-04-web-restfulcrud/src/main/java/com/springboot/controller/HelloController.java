package com.springboot.controller;

import com.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {



    @RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("user")String user){
        if (user.equals("aaa")){ throw new UserNotExistException();}
        return "Hello World!!!";

    }

    //查出一些数据,在页面显示
    @RequestMapping("/success")
    public String success(Map<String,Object> maps){
        maps.put("hello", "<h1>你好</h1>");
        maps.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
