package com.frasato.rpgannotation;

import com.frasato.rpgannotation.models.PostModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostModelTest {

    @Test
    void testCreatePostModel(){
        PostModel post = new PostModel();

        post.setPostId("post1");
        post.setTitle("Post 1");
        post.setContent("Post Test 1");


    }

}
