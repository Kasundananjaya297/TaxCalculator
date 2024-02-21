package com.example.FinalProject.Controller;

import com.example.FinalProject.DTO.ResponseDTO;
import com.example.FinalProject.DTO.salCalculateEmployee;
import com.example.FinalProject.Entity.SalarayProcess;
import com.example.FinalProject.Service.salaryCalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/calculate")

public class salaryController {

    @Autowired
    private salaryCalculateService salaryCalculatorService;
    @PostMapping("/salary")
    public ResponseEntity claculateTakeHomeSal(@RequestBody salCalculateEmployee sal){

        ResponseDTO response = salaryCalculatorService.saveSalaryDetails(sal.getGrossSalary(),sal.getMonth(),sal.getEmpID());
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }

}
