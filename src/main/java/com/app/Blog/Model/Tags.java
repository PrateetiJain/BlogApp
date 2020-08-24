package com.app.Blog.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tagId;

    @Column(name = "tag_name")
    private String tagName;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date tagCreatedAt;

    @ManyToMany
    private List<Post> post = new ArrayList<>();

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }


    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getTagCreatedAt() {
        return tagCreatedAt;
    }

    public void setTagCreatedAt(Date tagCreatedAt) {
        this.tagCreatedAt = tagCreatedAt;
    }
}
