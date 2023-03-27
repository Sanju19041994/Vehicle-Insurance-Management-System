package com.shruteekaTech.VIMS.controller;

import com.shruteekaTech.VIMS.dto.VehicleDto;
import com.shruteekaTech.VIMS.service.VehicleService;
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
@RequestMapping("/vehicle")
public class Vehicle_ModuleController {


    Logger logger = LoggerFactory.getLogger(Vehicle_ModuleController.class);

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/saveUId/{userId}")
    public ResponseEntity<VehicleDto> saveVehicle(@Valid @RequestBody VehicleDto vehicleDto, @PathVariable Integer userId){
        logger.info("Started : saveVehicle() started from Vehicle_ModuleController");
        VehicleDto savedDto = vehicleService.addVehicle(vehicleDto, userId);
        logger.info("Completed : saveVehicle() completed from Vehicle_ModuleController");
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    @PutMapping("/updateVId/{vehicleId}")
    public ResponseEntity<VehicleDto> updateVehicle(@Valid @RequestBody VehicleDto vehicleDto, @PathVariable Integer vehicleId){
        logger.info("Started : updateVehicle() started from Vehicle_ModuleController");
        VehicleDto updatedDto = vehicleService.updateVehicle(vehicleDto, vehicleId);
        logger.info("Completed : updateVehicle() completed from Vehicle_ModuleController");
        return new ResponseEntity<>(updatedDto,HttpStatus.OK);
    }

    @GetMapping("/vehicleId/{vehicleId}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable Integer vehicleId){
        logger.info("Started : getVehicleById() started from Vehicle_ModuleController");
        VehicleDto vehicleById = vehicleService.getVehicleById(vehicleId);
        logger.info("Completed : getVehicleById() completed from Vehicle_ModuleController");
        return new ResponseEntity<>(vehicleById,HttpStatus.FOUND);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<VehicleDto> getVehicleByUserId(@PathVariable Integer userId){
        logger.info("Started : getVehicleByUserId() started from Vehicle_ModuleController");
        VehicleDto vehicleByUserId = vehicleService.getVehicleByUserId(userId);
        logger.info("Completed : getVehicleByUserId() completed from Vehicle_ModuleController");
        return new ResponseEntity<>(vehicleByUserId,HttpStatus.FOUND);
    }

    @GetMapping("/allVehicles")
    public ResponseEntity<List<VehicleDto>> listOfVehicle(){
        logger.info("Started : listOfVehicle() started from Vehicle_ModuleController");
        List<VehicleDto> vehicles = vehicleService.getVehicles();
        logger.info("Completed : listOfVehicle() completed from Vehicle_ModuleController");
        return new ResponseEntity<>(vehicles,HttpStatus.FOUND);
    }


    @DeleteMapping("/vehicleId/{vehicleId}")
    public ResponseEntity<ApiResponse> deleteVehicle(@PathVariable Integer vehicleId){
        logger.info("Started : deleteVehicle() started from Vehicle_ModuleController");
        vehicleService.deleteVehicle(vehicleId);
        logger.info("Completed : deleteVehicle() completed from Vehicle_ModuleController");
        return new ResponseEntity<>(new ApiResponse("Vehicle Deleted Successfully",true),HttpStatus.OK);
    }


}
