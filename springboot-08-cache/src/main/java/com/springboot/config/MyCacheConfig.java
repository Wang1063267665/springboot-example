package com.springboot.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.config
 * @Description: TODO
 * @date 2018/5/16 14:16
 */
@Configuration
public class MyCacheConfig {

    @Bean("mykeyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName()+"["+ Arrays.asList(objects).toString()+"]";
            }
        };
    }

}
