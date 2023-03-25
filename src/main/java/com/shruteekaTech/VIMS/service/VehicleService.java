package com.shruteekaTech.VIMS.service;

import com.shruteekaTech.VIMS.dto.VehicleDto;

import java.util.List;

public interface VehicleService {

    public VehicleDto addVehicle(VehicleDto vehicleDto,Integer userId);

    public VehicleDto updateVehicle(VehicleDto vehicleDto,Integer vehicleId);

    public VehicleDto getVehicleById(Integer vehicleId);

    public VehicleDto getVehicleByUserId(Integer userId);

    public List<VehicleDto> getVehicles();

    public void deleteVehicle(Integer vehicleId);



}
