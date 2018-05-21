package com.springboot;

import com.springboot.bean.Article;
import com.springboot.bean.Book;
import com.springboot.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Srpingboot10ElasticApplicationTests {

	@Autowired
	JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void test02(){

        Book book = new Book();
        bookRepository.index(book);

    }

	@Test
	public void contextLoads() throws IOException {
		//1、给Es中索引（保存）一个文档
        Article article = new Article();
        article.setId(1);
        article.setAutor("zhangsan");
        article.setTitle("好消息");
        article.setContent("HelloWorld");
        Index index = new Index.Builder(article).index("atguigu").type("news").build();
        jestClient.execute(index);


    }

    //测试搜索
    @Test
    public void search(){
	    //查询表达式
        String json = "查询条件";
        //构建搜索功能
        Search build = new Search.Builder(json).addIndex("atguigu").addType("news").build();
        //执行
        try {
            SearchResult execute = jestClient.execute(build);
            String jsonString = execute.getJsonString();
            System.out.println(jsonString);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
