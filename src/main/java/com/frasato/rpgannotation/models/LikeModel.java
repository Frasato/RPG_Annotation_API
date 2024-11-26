package com.frasato.rpgannotation.models;

import jakarta.persistence.*;

@Entity
@Table(name = "likes")
public class LikeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String likeId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "post_id")
    private PostModel post;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private UserModel user;

    private Integer likeNumber;

    public LikeModel() {
    }

    public LikeModel(String likeId, PostModel post, UserModel user, Integer likeNumber) {
        this.likeId = likeId;
        this.post = post;
        this.user = user;
        this.likeNumber = likeNumber;
    }

    public String getLikeId() {
        return likeId;
    }

    public void setLikeId(String likeId) {
        this.likeId = likeId;
    }

    public PostModel getPost() {
        return post;
    }

    public void setPost(PostModel post) {
        this.post = post;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }
}
