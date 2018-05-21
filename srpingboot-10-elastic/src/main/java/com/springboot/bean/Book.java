package com.springboot.bean;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author WangLu
 * @Title: springboot-example
 * @Package com.springboot.bean
 * @Description: TODO
 * @date 2018/5/21 11:12
 */
@Document(indexName = "atguigu",type = "book")
public class Book {

    private Integer id;
    private String bookName;
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
