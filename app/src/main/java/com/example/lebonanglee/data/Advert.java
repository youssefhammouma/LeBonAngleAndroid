package com.example.lebonanglee.data;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class Advert {
    public Integer id;
    @SerializedName("title")
    public String title;
    @SerializedName("content")
    public String content;
    @SerializedName("author")
    public String author;
    @SerializedName("email")
    public String email;
    @SerializedName("category")
    public String category;
    @SerializedName("createdAt")
    public Date createdAt;

    public Advert(String title, String content, String author, String email, String category, Date createdAt, Date publishedAt, int price, String state) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.email = email;
        this.category = category;
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.price = price;
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    @SerializedName("publishedAt")
    public Date publishedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @SerializedName("price")
    public int price;
    public String formattedPrice;
    public String state;
    public String displayCreatedAt;
}
