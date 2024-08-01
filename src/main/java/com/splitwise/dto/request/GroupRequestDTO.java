package com.splitwise.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupRequestDTO {

    @NotEmpty(message = "Name is missing")
    private String name;

    @NotNull(message = "Created By ID is missing")
    private String createdBy;

    private String description;
}
