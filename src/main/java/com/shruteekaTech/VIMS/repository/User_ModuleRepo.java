package com.shruteekaTech.VIMS.repository;

import com.shruteekaTech.VIMS.dto.UserDtoModule;
import com.shruteekaTech.VIMS.model.User_Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface User_ModuleRepo extends JpaRepository<User_Module,Integer> {

    Optional<List<User_Module>> findByNameContaining(String name);

    Optional<User_Module> findByEmail(String email);

    Optional<User_Module> findByEmailAndPassword(String email,String password);

}
