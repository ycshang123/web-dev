package com.soft2176.bookonline.entity;

/**
 * @program: java-web-dev
 * @description: 图书实体类
 * @author: ycshang
 * @create: 2022-02-24 13:29
 **/
public class Book {
    private Integer id;
    private String name;
    private String cover;
    private String author;
    private String describe;

    public Book() {
    }

    public Book(Integer id, String name, String cover, String author, String describe) {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.author = author;
        this.describe = describe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", author='" + author + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}