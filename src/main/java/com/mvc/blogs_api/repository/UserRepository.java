package com.mvc.blogs_api.repository;

import com.mvc.blogs_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT s from User s where s.username like :username and s.password like :password")
    User findUserCheckLogin(String username, String password);
}
