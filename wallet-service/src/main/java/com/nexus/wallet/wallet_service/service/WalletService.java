package com.nexus.wallet.wallet_service.service;


import java.math.BigDecimal;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.nexus.wallet.wallet_service.model.Wallet;
import com.nexus.wallet.wallet_service.repository.WalletRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class WalletService {

    private final WalletRepository walletRepository;

    @KafkaListener(topics = "user-created-topic", groupId = "wallet-group")
    public void createWallet(Long userId) {
        log.info("Received user-created event for userId: {}", userId);
        
        Wallet wallet = Wallet.builder()
                .userId(userId)
                .balance(BigDecimal.ZERO)
                .build();
        
        walletRepository.save(wallet);
        log.info("Wallet created successfully for user: {}", userId);
    }

    @KafkaListener(topics = "user-created-topic", groupId = "wallet-group")
    public void handleUserCreated(Long userId) {
        log.info("from kafka", userId);
        
        Wallet wallet = Wallet.builder()
                .userId(userId)
                .balance(BigDecimal.ZERO)
                .build();
        
        walletRepository.save(wallet);
        log.info("wallet is opened", userId);
    }
}