package com.springboot.example.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.example.health
 * @Description: TODO
 * @date 2018/5/22 16:17
 */
@Component
public class MyAppHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        //自定义检查方法
//        return Health.up().build();代表健康
        return Health.down().withDetail("msg", "服务异常").build();
    }

}
