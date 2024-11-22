package com.frasato.rpgannotation;

import com.frasato.rpgannotation.models.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

}
