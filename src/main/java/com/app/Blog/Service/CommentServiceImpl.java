package com.app.Blog.Service;

import com.app.Blog.Model.Comments;
import com.app.Blog.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void saveComment(Comments comments) {
         this.commentRepository.save(comments);
    }
}
