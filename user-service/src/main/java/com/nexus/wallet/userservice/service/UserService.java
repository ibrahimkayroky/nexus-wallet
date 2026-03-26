package com.nexus.wallet.userservice.service;

import org.springframework.stereotype.Service;

import com.nexus.wallet.userservice.Dto.UserResponse;
import com.nexus.wallet.userservice.model.User;
import com.nexus.wallet.userservice.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j // Logger for the class instead of using System.out.println
@RequiredArgsConstructor // Constructor for the class with all the final fields "constructor injection"
public class UserService {
    private final UserRepository userRepository;

    public UserResponse CreateUser(User user) {
        log.info("Creating user {}", user.getUsername());

        User savedUser = userRepository.save(user);

        return UserResponse.builder()
            .id(savedUser.getId())
            .username(savedUser.getUsername())
            .email(savedUser.getEmail())
            .build();
    }


    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
