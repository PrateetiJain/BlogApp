package com.app.Blog.Controller;

import com.app.Blog.Model.Comments;
import com.app.Blog.Model.Post;
import com.app.Blog.Model.Tags;
import com.app.Blog.Service.PostService;
import com.app.Blog.Service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private TagsService tagsService;

    @GetMapping("/")
    public String viewHomePage(Model model, @RequestParam(value = "keyword" ,required=false) String keyword){
        return findPage(keyword,1,"title","asc",model);
    }

    @GetMapping("/filterByDate")
    public String filterByDate(Model model, @RequestParam(value = "filterDate",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date filterDate){
        List<Post> listPost = postService.getAllPostByDate(filterDate);
        model.addAttribute("listPost",listPost);
        return "home_page";
    }
    @GetMapping("/addPost")
    public String addPost(Model model){
        Post post = new Post();
        Tags tags = new Tags();
        model.addAttribute("post",post);
        model.addAttribute("tags",tags);
        return "add_new_post";
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute("post") Post post, @ModelAttribute("tags") Tags tags){
        post.setCreatedAt(new Date());
        post.setPublished(true);
        postService.savePost(post);
        tags.setTagCreatedAt(new Date());
        tagsService.saveTags(tags);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPage(@RequestParam(value= "keyword" ,required=false) String keyword,@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,@RequestParam("sortDirection") String sortDirection, Model model){
        int pageSize = 9;
        Page<Post> page = postService.findPage(keyword,pageNo,pageSize,sortField,sortDirection);
        List<Post> listPost = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDirection",sortDirection);
        model.addAttribute("listPost",listPost);
        model.addAttribute("keyword",keyword);
        return "home_page";
    }

    @PostMapping ("/readBlog")
    public String readBlog(@RequestParam(name="id") long postId, Model model){
        Post post1 = postService.getPostById(postId);
        model.addAttribute("post",post1);
        Comments comments = new Comments();
        model.addAttribute("comments",comments);
        return "readBlog";
    }

    @GetMapping("/deleteBlog")
    public String deleteBlog(@ModelAttribute("post")Post post){
           postService.deletePost(post);
           return "readBlog";
    }
}

