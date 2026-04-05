package com.nexus.wallet.userservice.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.nexus.wallet.userservice.dto.UserResponse;
import com.nexus.wallet.userservice.model.User;
import com.nexus.wallet.userservice.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j // Logger for the class instead of using System.out.println
@RequiredArgsConstructor // Constructor for the class with all the final fields "constructor injection"
public class UserService {
    private final UserRepository userRepository;

    private final KafkaTemplate<String, String> kafkaTemplate;
    public UserResponse CreateUser(User user) {

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        User savedUser = userRepository.save(user);


        log.info("Sending user to Kafka: {}", savedUser.getId());
        kafkaTemplate.send("user-created-topic", String.valueOf(savedUser.getId()));


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
