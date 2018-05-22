package com.springboot.example.service;

import org.springframework.stereotype.Service;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.example.service
 * @Description: TODO
 * @date 2018/5/22 14:41
 */
@Service
public class TicktService {

    public String getTicket(){
        System.out.println("8001");
        return "《厉害了，我的国》";
    }
}
