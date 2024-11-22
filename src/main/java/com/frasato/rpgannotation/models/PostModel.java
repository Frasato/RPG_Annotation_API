package com.frasato.rpgannotation.models;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String postId;

    @Column(nullable = false, length = 25)
    private String title;
    @Column(nullable = false, length = 250)
    private String content;
    private Integer like;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_user_id")
    private UserModel user;

    public PostModel() {
    }

    public PostModel(String postId, String title, String content, Integer like, UserModel user) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.like = like;
        this.user = user;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel userId) {
        this.user = userId;
    }
}
