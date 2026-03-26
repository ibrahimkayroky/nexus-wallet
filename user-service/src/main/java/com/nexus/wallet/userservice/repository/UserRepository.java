package com.nexus.wallet.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.nexus.wallet.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
