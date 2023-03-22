package com.shruteekaTech.VIMS.service;


import com.shruteekaTech.VIMS.dto.UserDtoModule;
import com.shruteekaTech.VIMS.utils.UserLogin;

import java.util.List;

public interface User_ModuleService {

    boolean saveUser(UserDtoModule userDtoModule);

    boolean updateUser(Integer userId, UserDtoModule userDtoModule);

    UserDtoModule getUserById(Integer userId);

    UserDtoModule getUserByEmail(String email);

    List<UserDtoModule> getUserByName(String name);

    List<UserDtoModule> getAllUsers();

    void deleteUser(Integer userId);

    boolean loginCheck(UserLogin userLogin);

}
