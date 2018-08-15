package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
/**
 * 开启异步注解功能
 */
//@EnableAsync
/**
 * 基于注解的定时任务
 */
@EnableScheduling
public class Springboot11TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot11TaskApplication.class, args);
	}
}
