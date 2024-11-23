package com.frasato.rpgannotation;

import com.frasato.rpgannotation.models.PostModel;
import com.frasato.rpgannotation.models.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostModelTest {

    @Test
    void testCreatePostModel(){
        UserModel user = new UserModel();
        user.setUserId("1");
        user.setUsername("Tester");
        user.setEmail("test@test.com");
        user.setPassword("123");

        PostModel post = new PostModel();
        post.setPostId("post1");
        post.setTitle("Post 1");
        post.setContent("Post Test 1");
        post.setLike(1);
        post.setUser(user);

        assertEquals("post1", post.getPostId());
        assertEquals("Post 1", post.getTitle());
        assertEquals("Post Test 1", post.getContent());
        assertEquals(1, post.getLike());
        assertEquals(user, post.getUser());
    }

}
