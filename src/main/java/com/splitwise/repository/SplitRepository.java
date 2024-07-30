package com.splitwise.repository;

import com.splitwise.entity.Expense;
import com.splitwise.entity.Split;
import com.splitwise.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SplitRepository extends JpaRepository<Split,String> {
    boolean existByExpenseAndUser(Expense expense, Users users);
}
