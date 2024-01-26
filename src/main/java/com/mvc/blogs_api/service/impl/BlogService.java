package com.mvc.blogs_api.service.impl;


import com.mvc.blogs_api.model.Blog;
import com.mvc.blogs_api.model.User;
import com.mvc.blogs_api.repository.BlogRepository;
import com.mvc.blogs_api.repository.UserRepository;
import com.mvc.blogs_api.service.BlogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements BlogManager {
    @Autowired
    BlogRepository repository;
    @Autowired
    UserRepository userRepository;


    public List<Blog> search(String status, String content, String tittle) {
        if (content != null && tittle != null) {
           return repository.findAllByContentContainingOrTittleContaining(content, tittle);
        } else if (status!=null) {
            return repository.findAllByStatus(status);
        } else if (content!=null) {
            return repository.findBlogByContentContaining(content);
        } else if (tittle!=null) {
            return repository.findBlogByTittleContaining(tittle);
        } else return findAll();
    }

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public Blog save(Blog blog) {
        return repository.save(blog);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    public  List<Blog> findBlogByUserAndStatusOnlyMe(Long id){
        return repository.findBlogStatusOnlyMe(id);
    }
    public List<Blog>findBlogByOrderByLikesDesc(){
        return repository.findAllByOrderByLikesDesc();
    }
    public List<Blog>blogStatusPublic(){
        return repository.findBlogStatusPublic();
    }
    public List<Blog>findAllBlogLikeMax(){
        return repository.findAllBlogLikeMax();
    }
}
