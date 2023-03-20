package com.shruteekaTech.VIMS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User_Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;

    private String mobile;

    private String email;

    private String password;

    private String gender;

    private String address;

    private String nationality;

    private String licence;

}
