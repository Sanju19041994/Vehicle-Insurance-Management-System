package com.shruteekaTech.VIMS.service;

import com.shruteekaTech.VIMS.dto.InsuranceDto;

import java.util.List;

public interface InsuranceService {


    public InsuranceDto saveInsurance(InsuranceDto insuranceDto, Integer userId);

    public InsuranceDto updateInsurance(InsuranceDto insuranceDto, Integer id);

    public InsuranceDto getInsurance(Integer id);

    public List<InsuranceDto> getInsuranceByName(String name);

    public List<InsuranceDto> getAllInsurance();

    public void deleteInsurance(Integer id);


}
