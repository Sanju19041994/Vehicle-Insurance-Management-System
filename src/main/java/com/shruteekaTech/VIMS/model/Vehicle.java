package com.shruteekaTech.VIMS.model;

import jakarta.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehicleId;

    private String category;

    private String manufacturedBy;

    private String model;

    private String vehicleNumber;

    private String color;

    private LocalDate registrationDate;


    @OneToOne
    @JoinColumn(name = "userId")
    private User_Module userModule;


}
