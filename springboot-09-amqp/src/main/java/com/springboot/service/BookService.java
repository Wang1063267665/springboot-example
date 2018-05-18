package com.springboot.service;

import com.springboot.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.service
 * @Description: TODO
 * @date 2018/5/18 13:36
 */
@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){

        System.out.println("收到消息" + book);

    }


    @RabbitListener(queues = "atguigu")
    public void receive02(Message message){
        System.out.println(message.getMessageProperties());
        System.out.println(message.getBody());
    }
}
