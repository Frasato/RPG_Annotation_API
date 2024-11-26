package com.frasato.rpgannotation.services;

import com.frasato.rpgannotation.models.UserModel;
import com.frasato.rpgannotation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserModel userModel = this.userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("ERROR: User not found!"));
        return new org.springframework.security.core.userdetails.User(userModel.getEmail(), userModel.getPassword(), new ArrayList<>());
    }

}
