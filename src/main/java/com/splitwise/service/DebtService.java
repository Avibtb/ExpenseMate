package com.splitwise.service;

import com.splitwise.dto.response.ApiResponse;
import com.splitwise.entity.Debt;
import com.splitwise.entity.Expense;
import com.splitwise.entity.Users;

public interface DebtService {
    void addDebts(Expense expense);
    ApiResponse<Object> getDebtById(String userId);
    boolean existsByPayerAndPayee(Users payer,Users payee);
    Debt findByPayerAndPayee(Users payer,Users payee);
}
