package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 一、搭建基本环境
 * 1、导入数据库文件 创建出数据库表
 * 2、创建javaBean封装数据
 * 3、整合MyBatis操作数据库
 * 			1.配置数据源信息
 * 			2.使用注解版的Mybatis；
 * 				1）、@MapperScan指定需要扫描的mapper接口所在的包
 *
 * 	二、快速体验缓存
 * 		步骤：
 * 			1、开启基于注解的缓存
 * 			2、标注缓存注解即可
 * 				@Cacheable
 * 				@CacheEvict
 * 				@CachePut
 * 	默认使用的是ConcurrentMapCacheManager == ConcurrentMapCache;将数据保存在ConcurrentMap<Object,Object>
 * 	开发中使用缓存中间件：redis、memcached、ehcache
 * 	三、整合redis
 * 	1、安装redis：使用docker
 * 	2、引入redis的starter
 * 	3、配置redis
 * 	4、测试缓存
 * 		原理：CacheManager==cache 缓存组件来实际给缓存中存储数据
 * 		1）、引入redis的starter，容器中保存的是RedisCacheManager
 * 		2）、RedisCacheManager帮我们创建RedisCache来缓存组件；RedisCache通过操作redis缓存数据
 *		3）、默认保存数据k-v都是object；利用序列化保存；如何保存json
 */
@SpringBootApplication
@MapperScan(value = "com.springboot.mapper")
@EnableCaching
public class Springboot08CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot08CacheApplication.class, args);
	}
}
