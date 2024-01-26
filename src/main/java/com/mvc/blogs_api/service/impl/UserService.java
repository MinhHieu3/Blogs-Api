package com.mvc.blogs_api.service.impl;

import com.mvc.blogs_api.model.Blog;
import com.mvc.blogs_api.model.User;
import com.mvc.blogs_api.repository.UserRepository;
import com.mvc.blogs_api.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserManager {
    @Autowired
    UserRepository userRepository;
    public User checkLogin(String username, String password){
      return userRepository.findUserCheckLogin(username,password);
    }
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
}
