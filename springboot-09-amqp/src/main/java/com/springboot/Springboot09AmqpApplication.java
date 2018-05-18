package com.springboot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 *	1、RabbitAutoConfiguration
 *	2、有自动配置了连接工厂ConnectionFactory；
 *	3、RabbitProperties 封装了 RabbitMQ的配置
 *	4、RabbitTemplate：给RabbitMQ发送和接受消息的
 *	5、AmqpAdmin ：RabbitMQ系统的管理功能组|件
 *	   AmqpAdmin: 创建和删除 Queue，Exhange，Binding
 *	6、@EnableRabbit + @RabbitListener 监听消息队列的内容
 */
@SpringBootApplication
/**
 *	开启基于注解的RabbitMq模式
 */
@EnableRabbit
public class Springboot09AmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot09AmqpApplication.class, args);
	}
}
