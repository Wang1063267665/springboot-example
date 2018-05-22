package com.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
/**
 * 开启发现服务功能
 */
@EnableDiscoveryClient
public class EurekaConsumerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerUserApplication.class, args);
	}

	@LoadBalanced  //使用负载均衡机制
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
