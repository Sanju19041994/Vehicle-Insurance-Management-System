package com.shruteekaTech.VIMS.service.Impl;

import com.shruteekaTech.VIMS.dto.VehicleDto;
import com.shruteekaTech.VIMS.exception.ResourceNotFoundException;
import com.shruteekaTech.VIMS.model.User_Module;
import com.shruteekaTech.VIMS.model.Vehicle;
import com.shruteekaTech.VIMS.repository.User_ModuleRepo;
import com.shruteekaTech.VIMS.repository.VehicleRepo;
import com.shruteekaTech.VIMS.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private User_ModuleRepo userModuleRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public VehicleDto addVehicle(VehicleDto vehicleDto, Integer userId) {
        logger.info("Started : addVehicle() started from VehicleServiceImpl");
        User_Module user = userModuleRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId"));
        Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
        vehicle.setUserModule(user);
        Vehicle savedVehicle = vehicleRepo.save(vehicle);
        logger.info("Completed : addVehicle() completed from VehicleServiceImpl");
        return this.modelMapper.map(savedVehicle, VehicleDto.class);
    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto, Integer vehicleId) {
        logger.info("Started : updateVehicle() started from VehicleServiceImpl");
        Vehicle vehicle = vehicleRepo.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "vehicleId"));

        vehicle.setCategory(vehicleDto.getCategory());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setColor(vehicleDto.getColor());
        vehicle.setManufacturedBy(vehicleDto.getManufacturedBy());
        vehicle.setVehicleNumber(vehicleDto.getVehicleNumber());
        vehicle.setRegistrationDate(vehicleDto.getRegistrationDate());

        Vehicle updatedVehicle = vehicleRepo.save(vehicle);
        logger.info("Completed : updateVehicle() completed from VehicleServiceImpl");
        return this.modelMapper.map(updatedVehicle, VehicleDto.class);
    }

    @Override
    public VehicleDto getVehicleById(Integer vehicleId) {
        logger.info("Started : getVehicleById() started from VehicleServiceImpl");
        Vehicle vehicle = vehicleRepo.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "vehicleId"));
        logger.info("Completed : getVehicleById() completed from VehicleServiceImpl");
        return this.modelMapper.map(vehicle, VehicleDto.class);
    }

    @Override
    public VehicleDto getVehicleByUserId(Integer userId) {
        logger.info("Started : getVehicleByUserId() started from VehicleServiceImpl");
        User_Module userModule = userModuleRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId"));
        Vehicle vehicle = userModule.getVehicle();
        logger.info("Completed : getVehicleByUserId() completed from VehicleServiceImpl");
        return this.modelMapper.map(vehicle, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> getVehicles() {
        logger.info("Started : getVehicles() started from VehicleServiceImpl");
        List<Vehicle> list = vehicleRepo.findAll();
        List<VehicleDto> vehicles = list.stream().map((vehicle) ->
                this.modelMapper.map(vehicle, VehicleDto.class)).collect(Collectors.toList());
        logger.info("Completed : getVehicles() completed from VehicleServiceImpl");
        return vehicles;
    }

    @Override
    public void deleteVehicle(Integer vehicleId) {
        logger.info("Started : deleteVehicle() started from VehicleServiceImpl");
        Vehicle vehicle = vehicleRepo.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "vehicleId"));
        vehicleRepo.delete(vehicle);
        logger.info("Completed : deleteVehicle() completed from VehicleServiceImpl");
    }


}
