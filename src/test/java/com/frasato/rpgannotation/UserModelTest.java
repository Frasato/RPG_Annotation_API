package com.frasato.rpgannotation;

import com.frasato.rpgannotation.models.PostModel;
import com.frasato.rpgannotation.models.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserModelTest {

    @Test
    void testUserModelCreation(){

        UserModel user = new UserModel();

        user.setUserId("123");
        user.setUsername("Tester");
        user.setEmail("tester@test.com");
        user.setPassword("000");

        assertEquals("123", user.getUserId());
        assertEquals("Tester", user.getUsername());
        assertEquals("tester@test.com", user.getEmail());
        assertEquals("000", user.getPassword());
    }

    @Test
    void testUserModelWithPosts(){
        UserModel user = new UserModel();
        user.setUserId("123");
        user.setUsername("Tester");

        PostModel post1 = new PostModel();
        post1.setPostId("post1");
        post1.setTitle("TestPost1");
        post1.setContent("Content 1");
        post1.setUser(user);

        PostModel post2 = new PostModel();
        post2.setPostId("post2");
        post2.setTitle("TestPost2");
        post2.setContent("Content 2");
        post2.setUser(user);

        List<PostModel> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        user.setPostModel(posts);

        assertEquals(2, user.getPostModel().size());
        assertEquals("TestPost1", user.getPostModel().get(0).getTitle());
        assertEquals("TestPost2", user.getPostModel().get(1).getTitle());

    }

}
