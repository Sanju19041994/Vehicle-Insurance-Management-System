package com.shruteekaTech.VIMS.repository;

import com.shruteekaTech.VIMS.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,Integer> {


}
