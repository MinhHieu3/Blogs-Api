package com.mvc.blogs_api.controller;

import com.mvc.blogs_api.model.User;
import com.mvc.blogs_api.service.impl.BlogService;
import com.mvc.blogs_api.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/users")
public class UserApi {
    @Autowired
    UserService userService;
    @Autowired
    BlogService blogService;
    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity save(@PathVariable Long id,@RequestBody User user){
        user.setId(id);
        return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userService.remove(id);
        return new ResponseEntity<>("Done",HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity checkLogin(String username, String password){
       User user= userService.checkLogin(username,password);
       return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
