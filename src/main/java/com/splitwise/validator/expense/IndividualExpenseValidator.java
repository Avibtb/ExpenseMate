package com.splitwise.validator.expense;

import com.splitwise.dto.request.expense.ExpenseRequestDTO;

public class IndividualExpenseValidator  implements ExpenseValidator{
    @Override
    public boolean validate(ExpenseRequestDTO expenseRequestDTO) {
        return true;
    }
}
