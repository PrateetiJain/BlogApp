package com.app.Blog.Service;

import com.app.Blog.Model.Post;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.Locale;

public interface PostService {

     void deletePost(Post post);
     List<Post> getAllPostByDate(Date date);
     List<Post> getAllPostById(List<Long> listPostId);
     void savePost(Post post);
     Post getPostById(Long postId);
     Page<Post> findPage(String keyword, int pageNo, int pageSize, String sortField, String sortDirection);
}
