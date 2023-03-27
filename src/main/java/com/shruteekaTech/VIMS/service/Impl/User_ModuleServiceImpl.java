package com.shruteekaTech.VIMS.service.Impl;

import com.shruteekaTech.VIMS.dto.UserDtoModule;
import com.shruteekaTech.VIMS.exception.ResourceNotFoundException;
import com.shruteekaTech.VIMS.model.User_Module;
import com.shruteekaTech.VIMS.repository.User_ModuleRepo;
import com.shruteekaTech.VIMS.service.User_ModuleService;
import com.shruteekaTech.VIMS.utils.UserLogin;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class User_ModuleServiceImpl implements User_ModuleService {

    Logger logger = LoggerFactory.getLogger(User_ModuleServiceImpl.class);

    @Autowired
    private User_ModuleRepo userModuleRepo;

 //   private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean saveUser(UserDtoModule userDtoModule) {
        logger.info("Started : saveUser() started from User_ModuleServiceImpl");
        User_Module user = modelMapper.map(userDtoModule, User_Module.class);
      //  user.setPassword(passwordEncoder.encode(user.getPassword()));
        User_Module savedUser = userModuleRepo.save(user);
        if(savedUser != null){
            logger.info("Completed : saveUser() completed from User_ModuleServiceImpl");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(Integer userId, UserDtoModule userDtoModule) {
        logger.info("Started : updateUser() started from User_ModuleServiceImpl");
        User_Module user = userModuleRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","userId"));

        user.setName(userDtoModule.getName());
        user.setMobile(userDtoModule.getMobile());
        user.setGender(userDtoModule.getGender());
        user.setAddress(userDtoModule.getAddress());
        user.setNationality(userDtoModule.getNationality());
        user.setLicence(userDtoModule.getLicence());

        User_Module updatedUser = userModuleRepo.save(user);
        if(updatedUser != null){
            logger.info("Completed : updateUser() completed from User_ModuleServiceImpl");
            return true;
        }
        return false;
    }

    @Override
    public UserDtoModule getUserById(Integer userId) {
        logger.info("Started : getUserById() started from User_ModuleServiceImpl");
        User_Module user = userModuleRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","userId"));
        UserDtoModule dtoModule = modelMapper.map(user, UserDtoModule.class);
        logger.info("Completed : getUserById() completed from User_ModuleServiceImpl");
        return dtoModule;
    }

    @Override
    public UserDtoModule getUserByEmail(String email) {
        logger.info("Started : getUserByEmail() started from User_ModuleServiceImpl");
        User_Module user = userModuleRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User","email"));
        UserDtoModule dtoModule = modelMapper.map(user, UserDtoModule.class);
        logger.info("Completed : getUserByEmail() completed from User_ModuleServiceImpl");
        return dtoModule;
    }

    @Override
    public List<UserDtoModule> getUserByName(String name) {
        logger.info("Started : getUserByName() started from User_ModuleServiceImpl");
        List<User_Module> userList = userModuleRepo.findByNameContaining(name).orElseThrow(() -> new ResourceNotFoundException("User","name"));
        List<UserDtoModule> list = userList.stream().map((users) ->
                             this.modelMapper.map(users, UserDtoModule.class)).collect(Collectors.toList());
        logger.info("Completed : getUserByName() completed from User_ModuleServiceImpl");
        return list;
    }

    @Override
    public List<UserDtoModule> getAllUsers() {
        logger.info("Started : getAllUsers() started from User_ModuleServiceImpl");
        List<User_Module> all = userModuleRepo.findAll();
        List<UserDtoModule> userList = all.stream().map((users) ->
                           this.modelMapper.map(users, UserDtoModule.class)).collect(Collectors.toList());
        logger.info("Completed : getAllUsers() completed from User_ModuleServiceImpl");
        return userList;
    }

    @Override
    public void deleteUser(Integer userId) {
        logger.info("Started : deleteUser() started from User_ModuleServiceImpl");
        User_Module user = userModuleRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId"));
        userModuleRepo.delete(user);
        logger.info("Completed : deleteUser() completed from User_ModuleServiceImpl");
    }

    @Override
    public boolean loginCheck(UserLogin userLogin) {
        logger.info("Started : loginCheck() started from User_ModuleServiceImpl");
        String email = userLogin.getEmail();
        String password = userLogin.getPassword();

        User_Module user = userModuleRepo.findByEmailAndPassword(email, password).orElseThrow(() -> new ResourceNotFoundException("User", "email or password"));

        if(user.getEmail().equals(email) && user.getPassword().equals(password)){
            logger.info("Completed : loginCheck() completed from User_ModuleServiceImpl");
            return true;
        }
        return false;
    }
}
