package com.splitwise.mapper;

import com.splitwise.dto.request.RegisterRequestDTO;
import com.splitwise.dto.request.expense.ExpenseRequestDTO;
import com.splitwise.dto.response.*;
import com.splitwise.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomMapper {

    UserResponseDTO map(Users users);

    Users map(UserResponseDTO userResponseDTO);

    List<ExpenseResponseDTO> map(List<Expense> expenses);

    List<UserResponseDTO> mapToUserDto(List<Users> users);

    Expense map(ExpenseResponseDTO expenseResponseDTO);

    ExpenseResponseDTO map(Expense expense);

    @Mapping(source = "expenseRequestDTO.desc",target = "description")
    Expense map(ExpenseRequestDTO expenseRequestDTO);

    SplitResponseDTO map(Split split);
    SplitResponseDTO map(SplitResponseDTO splitResponseDTO);

    Group map(GroupExpenseResponseDTO groupExpenseResponseDTO);
    GroupExpenseResponseDTO map(Group group);

    WalletResponseDTO map(Wallet wallet);

    Users map(RegisterRequestDTO registerRequestDTO);


}
