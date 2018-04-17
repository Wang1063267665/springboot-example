package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


//springboot2.x版本  外置tomcat需要8.5以上版本  否则会报错
@SpringBootApplication
public class Springboot04WebJspApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Springboot04WebJspApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(Springboot04WebJspApplication.class, args);
	}
}
