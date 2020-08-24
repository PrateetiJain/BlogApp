package com.app.Blog.Repository;

import com.app.Blog.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query("select u from Users u where u.username = :username")
    public Users getUserByUsername(@Param("username")String username);
}
