package com.example.FinalProject.Controller;

import com.example.FinalProject.DTO.EmployeeDTO;
import com.example.FinalProject.DTO.ResponseDTO;
import com.example.FinalProject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/saveEmp")
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        ResponseDTO Response = employeeService.SaveEMP(employeeDTO);
        return new ResponseEntity(Response, HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/getEmployees")
    public ResponseEntity getEmployees(){
        ResponseDTO Response = employeeService.getAllEmployees();
        return new ResponseEntity(Response, HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/getEmployeeByName/{name}")
    public ResponseEntity getEmployeeByName(@PathVariable("name") String name){
        ResponseDTO responseDTO = employeeService.getEmployeeByName(name);
        return new ResponseEntity(responseDTO,HttpStatus.ACCEPTED);
    }

}
