package com.springboot.config;

import com.springboot.Springboot04WebRestfulcrudApplication;
import com.springboot.commponent.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//使用WebMvcConfigurer来扩展springmvc的功能
@Configuration
public class MyConfig implements WebMvcConfigurer {




    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /a请求 也来到success
//        registry.addViewController("/a").setViewName("success");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html", "/", "/user/login");

    }


    //自定义视图解析
    @Bean
    public ViewResolver myViewResolver(){

        return new Springboot04WebRestfulcrudApplication.MyViewResolver();

    }


    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
