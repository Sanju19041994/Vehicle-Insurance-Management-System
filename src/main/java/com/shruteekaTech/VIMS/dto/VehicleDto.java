package com.shruteekaTech.VIMS.dto;

import com.shruteekaTech.VIMS.model.User_Module;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {

    private Integer vehicleId;

    @NotEmpty @NotNull @Size(min = 2, max = 50)
    private String category;

    @NotEmpty @NotNull @Size(min = 2, max = 50)
    private String manufacturedBy;

    @NotEmpty @NotNull @Size(min = 2, max = 50)
    private String model;

    @NotEmpty @NotNull @Size(min = 2, max = 20)
    private String vehicleNumber;

    @NotNull @NotEmpty @Size(min = 2, max = 50)
    private String color;


    private LocalDate registrationDate;

    private UserDtoModule userModule;

}
