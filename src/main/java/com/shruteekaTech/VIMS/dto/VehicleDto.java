package com.shruteekaTech.VIMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {

    private Integer vehicleId;

    private String category;

    private String manufacturedBy;

    private String model;

    private String vehicleNumber;

    private String color;

    private LocalDate registrationDate;

}
