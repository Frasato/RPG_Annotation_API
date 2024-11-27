package com.frasato.rpgannotation.services;

import com.frasato.rpgannotation.models.PostModel;
import com.frasato.rpgannotation.models.UserModel;
import com.frasato.rpgannotation.repositories.PostRepository;
import com.frasato.rpgannotation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public List<PostModel> allPosts(){
        return postRepository.findAll();
    }

    public void createPost(String userId, String title, String content){
        UserModel user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("ERROR: User do not exist! " + userId));
        PostModel postModel = new PostModel();

        postModel.setUser(user);
        postModel.setTitle(title);
        postModel.setContent(content);

        postRepository.save(postModel);

    }

}
