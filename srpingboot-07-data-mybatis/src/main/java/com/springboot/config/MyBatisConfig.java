package com.springboot.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

//@org.springframework.context.annotation.Configuration
public class MyBatisConfig {


//    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return i->i.setMapUnderscoreToCamelCase(true);
    }
}
