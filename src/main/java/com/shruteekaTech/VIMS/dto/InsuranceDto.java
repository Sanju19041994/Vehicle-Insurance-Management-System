package com.shruteekaTech.VIMS.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDto {

    private Integer id;

    @NotNull @NotEmpty @Size(min = 2, max = 50)
    private String provider;

    @NotNull @NotEmpty @Size(min = 2, max = 100)
    private String insuranceName;

    @NotNull @NotEmpty
    private LocalDate insuranceValidity;

    private UserDtoModule userModule;

}
