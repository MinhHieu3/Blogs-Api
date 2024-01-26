package com.mvc.blogs_api.model;

import jakarta.persistence.*;

import java.time.LocalTime;


@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2000)
    private String content;
    private Long likes;
    private String status;
    private String tittle;
    @ManyToOne
    private User user;

    public Blog() {
    }

    public Blog(Long id, String content, Long likes, String status, String tittle, User user) {
        this.id = id;
        this.content = content;
        this.likes = likes;
        this.status = status;
        this.tittle = tittle;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
