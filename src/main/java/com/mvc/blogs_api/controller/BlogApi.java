package com.mvc.blogs_api.controller;

import com.mvc.blogs_api.model.Blog;
import com.mvc.blogs_api.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin("*")
@RequestMapping("api/blogs")
public class BlogApi {
    @Autowired
    BlogService blogService;
    @GetMapping
    public ResponseEntity findAll( String status, String content,String tittle){

        return new ResponseEntity<>(blogService.search(status,content,tittle), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Blog blog){
        return new ResponseEntity<>(blogService.save(blog),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity save(@RequestBody Blog blog,@PathVariable Long id){
        blog.setId(id);
        return new ResponseEntity<>(blogService.save(blog),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        blogService.remove(id);
        return new ResponseEntity<>("Delete Done",HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        return new ResponseEntity<>(blogService.findById(id),HttpStatus.OK);
    }
    @GetMapping("/status/{id}")
    public ResponseEntity findBlogStatusOnlyMe(@PathVariable Long id){
        return new ResponseEntity<>(blogService.findBlogByUserAndStatusOnlyMe(id),HttpStatus.OK);
    }
    @GetMapping("/like")
    public ResponseEntity findBlogByOrderByLikesDesc(){
        return new ResponseEntity<>(blogService.findBlogByOrderByLikesDesc(),HttpStatus.OK);
    }@GetMapping("/public")
    public ResponseEntity blogStatusPublic(){
        return new ResponseEntity<>(blogService.blogStatusPublic(),HttpStatus.OK);
    }
    @GetMapping("/likeMax")
    public ResponseEntity findAllBlogLikeMax(){
        return new ResponseEntity<>(blogService.findAllBlogLikeMax(),HttpStatus.OK);
    }



}
