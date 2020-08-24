package com.app.Blog.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "user_name")
        private String username;

        @Column(name = "email")
        private String email;

        @Column(name = "password")
        private String password;

        @ManyToMany(cascade = CascadeType.MERGE)
        @JoinTable(
                name = "users_role",
                joinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "roleId", referencedColumnName = "role_id")}
        )
        private List<Role> roles = new ArrayList<>();

        @OneToMany(mappedBy = "users")
        private List<Post> post = new ArrayList<>();

        @OneToMany(mappedBy = "users")
        private List<Comments> comments = new ArrayList<>();

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public List<Post> getPost() {
            return post;
        }

        public void setPost(List<Post> post) {
            this.post = post;
        }

        public List<Comments> getComments() {
            return comments;
        }

        public void setComments(List<Comments> comments) {
            this.comments = comments;
        }

        public List<Role> getRoles() {
            return roles;
        }

        public void setRoles(List<Role> roles) {
            this.roles = roles;
        }
}
