package com.springboot.config;

import com.springboot.commponent.filter.MyFilter;
import com.springboot.listener.MyListener;
import com.springboot.servlet.MyServlet;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.EventListener;

@Configuration
public class MyServerConfig {


    //注册三大组件
    @Bean
    public ServletRegistrationBean<MyServlet> myServlet(){
        ServletRegistrationBean<MyServlet> registrationBean = new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
        return registrationBean;
    }


    @Bean
    public FilterRegistrationBean<MyFilter> myFilter(){
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return registrationBean;
    }


    @Bean
    public ServletListenerRegistrationBean<MyListener> myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }



    //编程式配置  嵌入式的servlet容器
    @Bean
    public ConfigurableServletWebServerFactory customizer(){

        //springboot1.x中是使用embeddedServletContainerCustomizer  来配置嵌入式的servlet
        //从springboot2.x中 EmbeddedServletContainerCustomizer 这个类就没有了  变为ConfigurableServletWebServerFactory和WebServerFactoryCustomizer
        //详见springboot官方文档介绍
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setPort(8088);
        return tomcat;

    }




}
