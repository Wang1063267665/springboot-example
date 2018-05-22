package com.springboot.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.service
 * @Description: TODO
 * @date 2018/5/22 13:24
 */
@Service
public class UserService {


    @Reference
    TicketService ticketService;


    public void hello(){

        String ticket = ticketService.getTicket();
        System.out.println("买到票了"+ticket);
    }

}
