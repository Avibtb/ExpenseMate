package com.splitwise.repository;

import com.splitwise.entity.Debt;
import com.splitwise.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DebtRepository extends JpaRepository<Debt,String> {

    Optional<Debt> findByPayerAndPayee(Users payer,Users payee);
    boolean existsByPayerAndPayee(Users payer,Users payee);
    void deleteByPayerAndPayee(Users payer,Users payee);

    @Query("SELECT d from Debt d WHERE d.payer = :user OR d.payee = :user")
    List<Debt> findByPayerOrPayee(Users users);

    List<Debt> findByPayer(Users users);
    List<Debt> findByPayee(Users users);
}
