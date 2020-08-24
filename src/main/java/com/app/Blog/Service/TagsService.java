package com.app.Blog.Service;

import com.app.Blog.Model.Post;
import com.app.Blog.Model.Tags;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TagsService {

    void saveTags(Tags tags);
    List<Tags> findAll();
    List<Post> findAllByTagsName(String search);

}
