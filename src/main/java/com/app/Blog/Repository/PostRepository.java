package com.app.Blog.Repository;

import com.app.Blog.Model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Locale;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findAllById(Long postId);

    @Query("SELECT p FROM Post p WHERE p.title LIKE %?1%" + "OR p.excerpt LIKE %?1%"+"OR p.author LIKE %?1%" + "OR p.content LIKE %?1%" )
    public Page<Post> findAllByKeyword(String keyword, Pageable pageable);

    @Query("SELECT p FROM Post p WHERE p.createdAt = :date")
    public List<Post> getAllByDate(Date date);
}
