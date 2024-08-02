package com.splitwise.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wallet")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    @JoinColumn(name = "fk_user_id")
    private Users user;

    @DecimalMin(value = "0.00" ,message = "Amount must be greater than or equal to 0.01")
    private Double payable;

    @DecimalMin(value = "0.00",message = "Amount must be greater than or equal to 0.01")
    private Double own;

    @NotNull(message = "Amount is missing")
    private Double amount;

    @PrePersist
    void setAmountBeforeSaving(){
        double amt = (own - payable);
        amt = Math.round(amt * 100.0)/100.0;
        this.amount = amt;
    }

}
