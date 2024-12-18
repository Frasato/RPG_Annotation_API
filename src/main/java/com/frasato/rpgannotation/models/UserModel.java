package com.frasato.rpgannotation.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    @Column(nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "user")
    private List<PostModel> posts = new ArrayList<>();
    @ManyToMany(mappedBy = "user")
    private List<LikeModel> like = new ArrayList<>();

    public UserModel() {
    }

    public UserModel(String userId, String username, String email, String password, List<PostModel> posts, List<LikeModel> like) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
        this.like = like;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public List<PostModel> getPosts() {
        return posts;
    }

    public void setPosts(List<PostModel> posts) {
        this.posts = posts;
    }

    public List<LikeModel> getLike() {
        return like;
    }

    public void setLike(List<LikeModel> like) {
        this.like = like;
    }
}
