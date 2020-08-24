package com.app.Blog.Controller;

import com.app.Blog.Model.Comments;
import com.app.Blog.Model.Post;
import com.app.Blog.Service.CommentService;
import com.app.Blog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @PostMapping("/saveComment")
    public String saveComment(@ModelAttribute("comments") Comments comments, @RequestParam(name="id") long postId, Model model,@ModelAttribute("post") Post post){
        comments.setCommentCreatedAt(new Date());
        comments.setPost(postService.getPostById(postId));
        commentService.saveComment(comments);
        model.addAttribute("comments",comments);
        model.addAttribute("post",post);
        return "/readBlog";
    }
}
