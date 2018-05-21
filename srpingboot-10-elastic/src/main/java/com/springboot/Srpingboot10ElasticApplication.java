package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * SpringBoot默认支持两种技术来和ES交互；
 * 1、jest(默认不生效的)
 * 		需要导入jest的工具包（io.searchbox.client.JestClient;）
 * 2、SpringDate ElasticSearch
 * 		版本适配说明：https://github.com/spring-projects/spring-data-elasticsearch
 *		如果版本不适配：
 *			1）、升级springboot版本
 *			2）、安装对应的版本ES
 *
 * 		1）、Client 节点信息clusterNodes  clusterName
 * 		2）、ElasticsearchTemplate  操作es
 * 		3）、编写一个ElasticsearchRepository的子接口来操作ES
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.springboot.bean")
public class Srpingboot10ElasticApplication {

	public static void main(String[] args) {
		SpringApplication.run(Srpingboot10ElasticApplication.class, args);
	}
}
