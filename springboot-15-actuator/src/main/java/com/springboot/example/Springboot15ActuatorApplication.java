package com.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自定义健康状态指示器
 * 	1、编写一个指示器 实现 HealthIndicator 接口
 * 	2、指示器的名字 xxxxHealthIndicator
 * 	3、加入容器
 */
@SpringBootApplication
public class Springboot15ActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot15ActuatorApplication.class, args);
	}
}
