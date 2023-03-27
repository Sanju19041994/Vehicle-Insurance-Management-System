package com.shruteekaTech.VIMS.dto;

import com.shruteekaTech.VIMS.model.Vehicle;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoModule {

    private Integer userId;

    @NotEmpty @NotNull @Size(min = 2, max = 50)
    private String name;

    @NotEmpty @NotNull @Size(min = 2, max = 50)
    private String mobile;

    @NotEmpty @NotNull @Size(min = 2, max = 50)
    private String email;

    @NotEmpty @NotNull @Size(min = 2, max = 50)
    private String password;

    @NotEmpty @NotNull @Size(min = 1, max = 10)
    private String gender;

    @NotEmpty @NotNull @Size(min = 2, max = 200)
    private String address;

    @NotEmpty @NotNull @Size(min = 2, max = 50)
    private String nationality;

    @NotEmpty @NotNull @Size(min = 2, max = 50)
    private String licence;

    
}
