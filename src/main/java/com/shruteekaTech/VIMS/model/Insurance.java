package com.shruteekaTech.VIMS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Insurance_Tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String provider;

    private String insuranceName;

    private LocalDate insuranceValidity;

    @OneToOne
    @JoinColumn(name = "userId")
    private User_Module userModule;


}
