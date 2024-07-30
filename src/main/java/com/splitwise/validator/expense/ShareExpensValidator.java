package com.splitwise.validator.expense;

import com.splitwise.dto.request.expense.ExpenseRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class ShareExpensValidator implements ExpenseValidator{

    @Override
    public boolean validate(ExpenseRequestDTO expenseRequestDTO) {
        return (expenseRequestDTO.getParticipants().getIds().size() == expenseRequestDTO.getParticipants().getShares().size());
    }
}
