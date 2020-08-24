package com.app.Blog.Service;

import com.app.Blog.Model.MyUserDetails;
import com.app.Blog.Model.Users;
import com.app.Blog.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    public void saveUserDetails(Users users){
        this.usersRepository.save(users);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.getUserByUsername(username);
        if(users == null){
            throw new UsernameNotFoundException("Wrong username");
        }
        return new MyUserDetails(users);
    }
}
