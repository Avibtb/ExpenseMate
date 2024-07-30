package com.splitwise.repository;

import com.splitwise.entity.Users;
import com.splitwise.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,String> {
    boolean existsByUser(Users users);
    Wallet findByUserId(String userId);

}
