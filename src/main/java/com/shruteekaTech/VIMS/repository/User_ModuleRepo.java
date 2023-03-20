package com.shruteekaTech.VIMS.repository;

import com.shruteekaTech.VIMS.model.User_Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_ModuleRepo extends JpaRepository<User_Module,Integer> {
}
