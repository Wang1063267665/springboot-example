package com.springboot;

import com.springboot.bean.Book;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot09AmqpApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	/**
	 * 1、单播（点对点）
	 */
	@Test
	public void contextLoads() {

		//Message 需要自己构造；定义消息头和消息内容
		//rabbitTemplate.send(exchange,routeKey,message);


		//object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
		//rabbitTemplate.convertAndSend(exchange,routeKey,object);

		Map<String, Object> map = new HashMap<>();
		map.put("mag","这是第一个消息");
		map.put("data", Arrays.asList("helloworld",123,true));
		rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",
                new Book("西游记","吴承恩"));

	}

    /**
     * 接受数据,如何将数据自动转为json发送出去
     */
	@Test
	public void receive(){

        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o);
	}


    /**
     * 广播
     */
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout", "",
                new Book("红楼梦","曹雪芹"));
    }


    @Autowired
    AmqpAdmin amqpAdmin;



    @Test
    public void crreateExchange(){

//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
//        System.out.println("创建完成");


//        amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));

        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",
                Binding.DestinationType.QUEUE, "amqpadmin.exchange",
                "amqp.hah",null));
    }












}
