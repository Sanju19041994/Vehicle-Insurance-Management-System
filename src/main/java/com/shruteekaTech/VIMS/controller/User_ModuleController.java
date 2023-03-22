package com.shruteekaTech.VIMS.controller;

import com.shruteekaTech.VIMS.dto.UserDtoModule;
import com.shruteekaTech.VIMS.service.User_ModuleService;
import com.shruteekaTech.VIMS.utils.ApiResponse;
import com.shruteekaTech.VIMS.utils.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class User_ModuleController {

    @Autowired
    private User_ModuleService userModuleService;


    @PostMapping("/save")
    ResponseEntity<ApiResponse> saveNewUser(@RequestBody UserDtoModule userDtoModule){
        boolean saveUser = userModuleService.saveUser(userDtoModule);
        if(saveUser){
            return new ResponseEntity<>(new ApiResponse("User Saved successfully",true), HttpStatus.CREATED);
        }else {
            throw new RuntimeException("User Not Saved To DB");
        }
    }

    @PutMapping("/updateID/{userId}")
    ResponseEntity<ApiResponse> updateUsers(@RequestBody UserDtoModule userDtoModule, @PathVariable Integer userId){
        boolean updateUser = userModuleService.updateUser(userId, userDtoModule);
        if(updateUser){
            return new ResponseEntity<>(new ApiResponse("User Updated successfully",true), HttpStatus.OK);
        }else {
            throw new RuntimeException("User Not Updated");
        }
    }

    @GetMapping("/userId/{userId}")
    ResponseEntity<UserDtoModule> getSingleUserById(@PathVariable Integer userId){
        UserDtoModule userById = userModuleService.getUserById(userId);
        return new ResponseEntity<>(userById,HttpStatus.FOUND);
    }

    @GetMapping("/email/{email}")
    ResponseEntity<UserDtoModule> getSingleUserByEmail(@PathVariable String email){
        UserDtoModule userByEmail = userModuleService.getUserByEmail(email);
        return new ResponseEntity<>(userByEmail,HttpStatus.FOUND);
    }

    @GetMapping("/name/{name}")
    ResponseEntity<List<UserDtoModule>> getUsersByName(@PathVariable String name){
        List<UserDtoModule> userByName = userModuleService.getUserByName(name);
        return new ResponseEntity<>(userByName,HttpStatus.FOUND);
    }

    @GetMapping("/allUsers")
    ResponseEntity<List<UserDtoModule>> getUsersList(){
        List<UserDtoModule> allUsers = userModuleService.getAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.FOUND);
    }

    @DeleteMapping("/{userId}")
    ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
        userModuleService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody UserLogin userLogin){
        boolean loginCheck = userModuleService.loginCheck(userLogin);
        if(loginCheck){
            return new ResponseEntity<>(new ApiResponse("Login successfully",true),HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(new ApiResponse("Login fail..Please check your email or password",false),HttpStatus.NOT_FOUND);
        }
    }

}
