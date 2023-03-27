package com.shruteekaTech.VIMS.service.Impl;

import com.shruteekaTech.VIMS.dto.InsuranceDto;
import com.shruteekaTech.VIMS.exception.ResourceNotFoundException;
import com.shruteekaTech.VIMS.model.Insurance;
import com.shruteekaTech.VIMS.model.User_Module;
import com.shruteekaTech.VIMS.repository.InsuranceRepo;
import com.shruteekaTech.VIMS.repository.User_ModuleRepo;
import com.shruteekaTech.VIMS.service.InsuranceService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceServiceImp implements InsuranceService {

    Logger logger = LoggerFactory.getLogger(InsuranceService.class);

    @Autowired
    private InsuranceRepo insuranceRepo;

    @Autowired
    private User_ModuleRepo userModuleRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public InsuranceDto saveInsurance(InsuranceDto insuranceDto, Integer userId) {
        logger.info("Started : saveInsurance() started from InsuranceServiceImpl");
        User_Module user = userModuleRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId"));
        Insurance insurance = modelMapper.map(insuranceDto, Insurance.class);
        insurance.setUserModule(user);
        Insurance savedInsurance = insuranceRepo.save(insurance);
        logger.info("Completed : saveInsurance() completed from InsuranceServiceImpl");
        return this.modelMapper.map(savedInsurance, InsuranceDto.class);
    }

    @Override
    public InsuranceDto updateInsurance(InsuranceDto insuranceDto, Integer id) {
        logger.info("Started : updateInsurance() started from InsuranceServiceImpl");
        Insurance insurance = insuranceRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Insurance", "id"));

        insurance.setInsuranceName(insuranceDto.getInsuranceName());
        insurance.setProvider(insuranceDto.getProvider());
        insurance.setInsuranceValidity(insuranceDto.getInsuranceValidity());

        Insurance updatedInsurance = insuranceRepo.save(insurance);
        logger.info("Completed : updateInsurance() completed from InsuranceServiceImpl");
        return this.modelMapper.map(updatedInsurance, InsuranceDto.class);
    }

    @Override
    public InsuranceDto getInsurance(Integer id) {
        logger.info("Started : getInsurance() started from InsuranceServiceImpl");
        Insurance insurance = insuranceRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Insurance", "id"));
        logger.info("Completed : getInsurance() completed from InsuranceServiceImpl");
        return this.modelMapper.map(insurance, InsuranceDto.class);
    }

    @Override
    public List<InsuranceDto> getInsuranceByName(String name) {
        logger.info("Started : getInsuranceByName() started from InsuranceServiceImpl");
        List<Insurance> byName = insuranceRepo.findByInsuranceNameContaining(name).orElseThrow(() -> new ResourceNotFoundException("Insurance", "name"));
        List<InsuranceDto> dtoList = byName.stream().map((insurance) ->
                          this.modelMapper.map(insurance, InsuranceDto.class)).collect(Collectors.toList());
        logger.info("Completed : getInsuranceByName() completed from InsuranceServiceImpl");
        return dtoList;
    }

    @Override
    public List<InsuranceDto> getAllInsurance() {
        logger.info("Started : getAllInsurance() started from InsuranceServiceImpl");
        List<Insurance> all = insuranceRepo.findAll();
        List<InsuranceDto> dtoList = all.stream().map((insurance) ->
                      this.modelMapper.map(insurance, InsuranceDto.class)).collect(Collectors.toList());
        logger.info("Completed : getAllInsurance() completed from InsuranceServiceImpl");
        return dtoList;
    }

    @Override
    public void deleteInsurance(Integer id) {
        logger.info("Started : deleteInsurance() started from InsuranceServiceImpl");
        Insurance insurance = insuranceRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Insurance", "id"));
        insuranceRepo.delete(insurance);
        logger.info("Completed : deleteInsurance() completed from InsuranceServiceImpl");
    }
}
