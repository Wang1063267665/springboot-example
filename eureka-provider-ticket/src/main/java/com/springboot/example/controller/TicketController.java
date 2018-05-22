package com.springboot.example.controller;

import com.springboot.example.service.TicktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.example.controller
 * @Description: TODO
 * @date 2018/5/22 14:42
 */
@RestController
public class TicketController {

    @Autowired
    TicktService ticktService;

    @GetMapping("/ticket")
    public String getTicket(){

        return ticktService.getTicket();
    }

}
