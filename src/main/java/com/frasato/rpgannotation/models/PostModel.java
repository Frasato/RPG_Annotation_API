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

    @ManyToOne
    private UserModel userId;
}
