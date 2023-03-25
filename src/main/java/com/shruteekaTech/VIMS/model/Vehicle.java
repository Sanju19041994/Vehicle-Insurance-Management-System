package com.shruteekaTech.VIMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Vehicle_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Vehicle {

    private Integer vehicleId;

    private String category;

    private String manufacturedBy;

    private String model;

    private String vehicleNumber;

    private String color;

    private LocalDate registrationDate;




}
