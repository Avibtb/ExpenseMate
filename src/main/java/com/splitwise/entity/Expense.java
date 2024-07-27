package com.splitwise.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "expense")
@Builder
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String description;

    @NotNull(message = "Amount is missing")
    @DecimalMin(value = "0.01",message = "Amount must be greater than or equal to 0.01")
    private Double amount;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "fk_payer_id")
    private Users payer;

    @JoinTable(
            name = "expense_group_association",
            joinColumns = @JoinColumn(name ="fk_expense_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_group_id")
    )
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    @ToString.Exclude
    private List<Group> groups;

    @OneToMany(
            mappedBy = "expense",
            cascade = CascadeType.PERSIST
    )
    @ToString.Exclude
    private List<Split> splits;

    public void setCreatedAt(){
        this.createdAt = LocalDateTime.now();
    }

}
