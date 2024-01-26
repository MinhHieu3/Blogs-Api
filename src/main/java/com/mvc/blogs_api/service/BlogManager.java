package com.mvc.blogs_api.service;

import com.mvc.blogs_api.model.Blog;

import java.util.List;

public interface BlogManager extends IManager<Blog>{
    List<Blog> search(String status, String content, String title);

}
