package com.splitwise.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "debt")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Debt {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "fk_payer_id")
    private Users payer;

    @ManyToOne
    @JoinColumn(name = "fk_payee_id")
    private Users payee;

    @NotNull
    @DecimalMin(value = "0.01",message = "Amount must be greater than or equal to 0.01")
    private Double amount;
}
