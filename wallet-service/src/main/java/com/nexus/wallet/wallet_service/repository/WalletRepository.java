package com.nexus.wallet.wallet_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexus.wallet.wallet_service.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet,Long>{

}
