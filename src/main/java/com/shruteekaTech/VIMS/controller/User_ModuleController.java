package com.shruteekaTech.VIMS.controller;

import com.shruteekaTech.VIMS.dto.UserDtoModule;
import com.shruteekaTech.VIMS.service.User_ModuleService;
import com.shruteekaTech.VIMS.utils.ApiResponse;
import com.shruteekaTech.VIMS.utils.UserLogin;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class User_ModuleController {

    Logger logger = LoggerFactory.getLogger(User_ModuleController.class);
    @Autowired
    private User_ModuleService userModuleService;


    @PostMapping("/save")
    ResponseEntity<ApiResponse> saveNewUser(@Valid  @RequestBody UserDtoModule userDtoModule){
        logger.info("Started : saveNewUser() started from User_ModuleController");
        boolean saveUser = userModuleService.saveUser(userDtoModule);
        if(saveUser){
            logger.info("Completed : saveNewUser() completed from User_ModuleController");
            return new ResponseEntity<>(new ApiResponse("User Saved successfully",true), HttpStatus.CREATED);
        }else {
            throw new RuntimeException("User Not Saved To DB");
        }
    }

    @PutMapping("/updateID/{userId}")
    ResponseEntity<ApiResponse> updateUsers(@Valid @RequestBody UserDtoModule userDtoModule, @PathVariable Integer userId){
        logger.info("Started : updateUsers() started from User_ModuleController");
        boolean updateUser = userModuleService.updateUser(userId, userDtoModule);
        if(updateUser){
            logger.info("Completed : updateUsers() completed from User_ModuleController");
            return new ResponseEntity<>(new ApiResponse("User Updated successfully",true), HttpStatus.OK);
        }else {
            throw new RuntimeException("User Not Updated");
        }
    }

    @GetMapping("/userId/{userId}")
    ResponseEntity<UserDtoModule> getSingleUserById(@PathVariable Integer userId){
        logger.info("Started : getSingleUserById() started from User_ModuleController");
        UserDtoModule userById = userModuleService.getUserById(userId);
        logger.info("Completed : getSingleUserById() completed from User_ModuleController");
        return new ResponseEntity<>(userById,HttpStatus.FOUND);
    }

    @GetMapping("/email/{email}")
    ResponseEntity<UserDtoModule> getSingleUserByEmail(@PathVariable String email){
        logger.info("Started : getSingleUserByEmail() started from User_ModuleController");
        UserDtoModule userByEmail = userModuleService.getUserByEmail(email);
        logger.info("Completed : getSingleUserByEmail() completed from User_ModuleController");
        return new ResponseEntity<>(userByEmail,HttpStatus.FOUND);
    }

    @GetMapping("/name/{name}")
    ResponseEntity<List<UserDtoModule>> getUsersByName(@PathVariable String name){
        logger.info("Started : getUsersByName() started from User_ModuleController");
        List<UserDtoModule> userByName = userModuleService.getUserByName(name);
        logger.info("Completed : getUsersByName() completed from User_ModuleController");
        return new ResponseEntity<>(userByName,HttpStatus.FOUND);
    }

    @GetMapping("/allUsers")
    ResponseEntity<List<UserDtoModule>> getUsersList(){
        logger.info("Started : getUsersList() started from User_ModuleController");
        List<UserDtoModule> allUsers = userModuleService.getAllUsers();
        logger.info("Completed : getUsersList() completed from User_ModuleController");
        return new ResponseEntity<>(allUsers,HttpStatus.FOUND);
    }

    @DeleteMapping("/{userId}")
    ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
        logger.info("Started : deleteUser() started from User_ModuleController");
        userModuleService.deleteUser(userId);
        logger.info("Completed : deleteUser() completed from User_ModuleController");
        return new ResponseEntity<>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody UserLogin userLogin){
        logger.info("Started : login() started from User_ModuleController");
        boolean loginCheck = userModuleService.loginCheck(userLogin);
        if(loginCheck){
            logger.info("Completed : login() completed from User_ModuleController");
            return new ResponseEntity<>(new ApiResponse("Login successfully",true),HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(new ApiResponse("Login fail..Please check your email or password",false),HttpStatus.NOT_FOUND);
        }
    }

}
