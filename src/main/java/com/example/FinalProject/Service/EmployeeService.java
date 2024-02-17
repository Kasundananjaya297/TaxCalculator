package com.example.FinalProject.Service;


import com.example.FinalProject.DTO.EmployeeDTO;
import com.example.FinalProject.DTO.ResponseDTO;
import com.example.FinalProject.Entity.Employee;
import com.example.FinalProject.Repo.EmployeeRepo;
import com.example.FinalProject.utility.IDGenerator;
import com.example.FinalProject.utility.handlerVal;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.DynamicInsert;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Transactional
@DynamicInsert
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IDGenerator idGenerator;

    private ResponseDTO responseDTO = new ResponseDTO();



    public ResponseDTO SaveEMP(EmployeeDTO employeeDTO){
        try {
            Employee employee = employeeRepo.existsEmployeeByNIC(employeeDTO.getNIC());
            if (employee != null) {
                responseDTO.setResponseCode(handlerVal.RSP_DUPLICATED);
                responseDTO.setResponseMessage("Employee already exists");
                responseDTO.setData(employee);
                return responseDTO;
            } else {
                employeeDTO.setEmpID(idGenerator.getMaxEmployeeId());
                responseDTO.setResponseCode(handlerVal.RSP_SUCCES);
                responseDTO.setResponseMessage("Successfully saved");
                responseDTO.setData(employeeDTO);
                employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
                return responseDTO;

            }
        }catch (Exception e){
            responseDTO.setResponseCode(handlerVal.RSP_FAIL);
            responseDTO.setResponseMessage("Failed to save");
            responseDTO.setData(null);
            return responseDTO;
        }
    }
    public ResponseDTO getAllEmployees(){
        try {
            responseDTO.setResponseCode(handlerVal.RSP_SUCCES);
            responseDTO.setResponseMessage("Successfully fetched");
            responseDTO.setData(employeeRepo.findAll());
            return responseDTO;
        }catch (Exception e){
            responseDTO.setResponseCode(handlerVal.RSP_FAIL);
            responseDTO.setResponseMessage("Failed to fetch");
            responseDTO.setData(null);
            return responseDTO;
        }
    }


}
