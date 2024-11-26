package com.frasato.rpgannotation.controllers;

import com.frasato.rpgannotation.dtos.LoginRequestDTO;
import com.frasato.rpgannotation.dtos.RegisterRequestDTO;
import com.frasato.rpgannotation.dtos.ResponseAuthDTO;
import com.frasato.rpgannotation.models.UserModel;
import com.frasato.rpgannotation.repositories.UserRepository;
import com.frasato.rpgannotation.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDTO){
        UserModel user = userRepository.findByEmail(loginRequestDTO.email()).orElseThrow(() -> new RuntimeException("ERROR: User not found"));

        if(passwordEncoder.matches(loginRequestDTO.password(), user.getPassword())){
            String token = tokenService.generateToken(user);
            ResponseAuthDTO responseAuthDTO = new ResponseAuthDTO(token, user.getUserId(), user.getUsername(), user.getEmail());
            return ResponseEntity.ok().body(responseAuthDTO);
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequestDTO){
        Optional<UserModel> user = userRepository.findByEmail(registerRequestDTO.email());

        if(user.isEmpty()){
            UserModel userModel = new UserModel();

            userModel.setUsername(registerRequestDTO.username());
            userModel.setEmail(registerRequestDTO.email());
            userModel.setPassword(passwordEncoder.encode(registerRequestDTO.password()));

            userRepository.save(userModel);
            String token = tokenService.generateToken(userModel);

            ResponseAuthDTO responseAuthDTO = new ResponseAuthDTO(token, userModel.getUserId(), userModel.getUsername(), userModel.getEmail());
            return ResponseEntity.ok().body(responseAuthDTO);
        }

        return ResponseEntity.badRequest().build();
    }

}
