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
    private UserModel userId;
}
