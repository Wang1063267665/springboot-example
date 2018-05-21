package com.springboot.repository;

import com.springboot.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.repository
 * @Description: TODO
 * @date 2018/5/21 11:14
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}
