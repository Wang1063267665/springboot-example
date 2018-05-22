package com.springboot.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.service
 * @Description: TODO
 * @date 2018/5/22 13:22
 */
@Component
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {


        return "《厉害了，我的国》";
    }
}
