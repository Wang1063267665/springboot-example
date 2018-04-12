package com.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  @SpringBootApplication 来标注一个主程序类，说明这是个springboot应用
 */
@SpringBootApplication
//导入spring的配置文件,让配置文件里面的内容生效
//@ImportResource(value = {"classpath:beans.xml"})
public class HelloWorldMainApplication {


    public static void main(String[] args) {
        //spring应用启动起来
        SpringApplication.run(HelloWorldMainApplication.class,args);


    }

}
