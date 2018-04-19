package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.springboot.mapper")
public class Srpingboot07DataMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Srpingboot07DataMybatisApplication.class, args);
	}
}
