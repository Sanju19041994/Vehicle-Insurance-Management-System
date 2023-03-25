package com.shruteekaTech.VIMS.dto;

import com.shruteekaTech.VIMS.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoModule {

    private Integer userId;

    private String name;

    private String mobile;

    private String email;

    private String password;

    private String gender;

    private String address;

    private String nationality;

    private String licence;

    private VehicleDto vehicle;
}
