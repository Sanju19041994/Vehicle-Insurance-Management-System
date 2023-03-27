package com.shruteekaTech.VIMS.repository;

import com.shruteekaTech.VIMS.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsuranceRepo extends JpaRepository<Insurance,Integer> {

    Optional<List<Insurance>> findByInsuranceNameContaining(String name);

}
