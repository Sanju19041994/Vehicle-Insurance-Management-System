package com.shruteekaTech.VIMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDto {

    private Integer id;

    private String provider;

    private String insuranceName;

    private LocalDate insuranceValidity;

    private UserDtoModule userModule;

}
