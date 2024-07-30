package com.splitwise.splitter;

import com.splitwise.dto.request.expense.ExpenseRequestDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExactAmountSplitter implements AmountSplitter {
    @Override
    public List<OwedDetails> split(ExpenseRequestDTO expenseRequestDTO) {
        List<String> userIds = expenseRequestDTO.getParticipants().getIds().stream().toList();
        List<Double> shares = expenseRequestDTO.getParticipants().getShares();

        List<OwedDetails> owedDetails = new ArrayList<>();

        for(int i = 0;i<shares.size();i++){
            OwedDetails owedDetails1 = OwedDetails.builder()
                    .id(userIds.get(i))
                    .share(shares.get(i))
                    .build();
            owedDetails.add(owedDetails1);
        }
        return owedDetails;
    }
}
