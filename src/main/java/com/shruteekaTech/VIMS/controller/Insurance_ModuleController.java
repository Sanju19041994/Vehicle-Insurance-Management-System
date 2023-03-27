package com.shruteekaTech.VIMS.controller;

import com.shruteekaTech.VIMS.dto.InsuranceDto;
import com.shruteekaTech.VIMS.service.InsuranceService;
import com.shruteekaTech.VIMS.utils.ApiResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class Insurance_ModuleController {

    Logger logger = LoggerFactory.getLogger(Insurance_ModuleController.class);

    @Autowired
    private InsuranceService insuranceService;

    @PostMapping("/userId/{userId}")
    public ResponseEntity<InsuranceDto> createNewInsurance(@Valid @RequestBody InsuranceDto insuranceDto,
                                                           @PathVariable Integer userId)
    {
        logger.info("Started : createNewInsurance() started from Insurance_ModuleController");
        InsuranceDto saved = insuranceService.saveInsurance(insuranceDto, userId);
        logger.info("Completed : createNewInsurance() completed from Insurance_ModuleController");
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<InsuranceDto> updateInsurance(@Valid @RequestBody InsuranceDto insuranceDto,
                                                        @PathVariable Integer id)
    {
        logger.info("Started : updateInsurance() started from Insurance_ModuleController");
        InsuranceDto updated = insuranceService.updateInsurance(insuranceDto, id);
        logger.info("Completed : updateInsurance() completed from Insurance_ModuleController");
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }


    @GetMapping("/byId/{id}")
    public ResponseEntity<InsuranceDto> getInsuranceById(@PathVariable Integer id){
        logger.info("Started : getInsuranceById() started from Insurance_ModuleController");
        InsuranceDto insurance = insuranceService.getInsurance(id);
        logger.info("Completed : getInsuranceById() completed from Insurance_ModuleController");
        return new ResponseEntity<>(insurance, HttpStatus.FOUND);
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<List<InsuranceDto>> getInsuranceByName(@PathVariable String name){
        logger.info("Started : getInsuranceByName() started from Insurance_ModuleController");
        List<InsuranceDto> insuranceByName = insuranceService.getInsuranceByName(name);
        logger.info("Completed : getInsuranceByName() completed from Insurance_ModuleController");
        return new ResponseEntity<>(insuranceByName, HttpStatus.FOUND);
    }

    @GetMapping("/allInsurance")
    public ResponseEntity<List<InsuranceDto>> getInsuranceList(){
        logger.info("Started : getInsuranceList() started from Insurance_ModuleController");
        List<InsuranceDto> allInsurance = insuranceService.getAllInsurance();
        logger.info("Completed : getInsuranceList() completed from Insurance_ModuleController");
        return new ResponseEntity<>(allInsurance,HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteInsurance(@PathVariable Integer id){
        logger.info("Started : deleteInsurance() started from Insurance_ModuleController");
        insuranceService.deleteInsurance(id);
        logger.info("Completed : deleteInsurance() completed from Insurance_ModuleController");
        return new ResponseEntity<>(new ApiResponse("Deleted Successfully",true),HttpStatus.OK);
    }



}
