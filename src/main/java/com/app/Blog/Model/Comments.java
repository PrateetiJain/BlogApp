package com.app.Blog.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "comment")
    private String comment;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date commentCreatedAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date commentUpdatedAt;

    @ManyToOne
    private Users users;

    @ManyToOne
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentCreatedAt() {
        return commentCreatedAt;
    }

    public void setCommentCreatedAt(Date commentCreatedAt) {
        this.commentCreatedAt = commentCreatedAt;
    }

    public Date getCommentUpdatedAt() {
        return commentUpdatedAt;
    }

    public void setCommentUpdatedAt(Date commentUpdatedAt) {
        this.commentUpdatedAt = commentUpdatedAt;
    }
}
