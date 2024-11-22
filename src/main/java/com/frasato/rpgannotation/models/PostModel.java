package com.frasato.rpgannotation.models;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String postId;

    private String title;
    private String content;
    private Integer like;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_user_id")
    private UserModel userId;
}
