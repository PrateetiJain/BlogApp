package com.app.Blog.Controller;

import com.app.Blog.Model.Post;
import com.app.Blog.Model.Tags;
import com.app.Blog.Model.Users;
import com.app.Blog.Service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @GetMapping("/viewRegisterPage")
    public String viewRegisterPage(Model model){
        Users users = new Users();
        model.addAttribute("users",users);
        return "register";
    }
    @GetMapping("/viewSignInPage")
    public String viewSignInPage(Model model){
        Users users = new Users();
        model.addAttribute("users",users);
        return "sign_in";
    }
    @PostMapping ("/registerUser")
    public String registerUser(@ModelAttribute("users")Users users){
        userDetailsServiceImpl.saveUserDetails(users);
        return "sign_in";
    }
    @PostMapping("/verifyUser")
    public String verifyUser(Model model){
        Users users = new Users();
        model.addAttribute("users",users);
        return "/register";
    }



}
