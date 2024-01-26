package com.mvc.blogs_api.repository;

import com.mvc.blogs_api.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    @Query("SELECT s FROM Blog s WHERE s.user.id = :id and s.status like 'Only Me'")
    List<Blog>findBlogStatusOnlyMe(Long id);
    @Query("SELECT s FROM Blog s WHERE s.status like 'Public'")
    List<Blog>findBlogStatusPublic();
    @Query("SELECT s FROM Blog s WHERE s.status like 'Public' order by s.likes desc ")
    List<Blog>findAllByOrderByLikesDesc();
    @Query("SELECT s from Blog s where s.status like 'Public' order by s.likes desc limit 4")
    List<Blog>findAllBlogLikeMax();
    List<Blog> findAllByStatus(String status);

    List<Blog> findAllByContentContainingOrTittleContaining(String content, String tittle);


    List<Blog> findBlogByTittleContaining(String tittle);

    List<Blog> findBlogByContentContaining(String content);

}