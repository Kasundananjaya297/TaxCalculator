package com.example.FinalProject.Service;

import com.example.FinalProject.DTO.ResponseDTO;
import com.example.FinalProject.DTO.salaryDTO;
import com.example.FinalProject.Repo.EmployeeRepo;
import com.example.FinalProject.Repo.salaryRepo;
import com.example.FinalProject.utility.Calculations;
import com.example.FinalProject.utility.handlerVal;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.DynamicInsert;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@DynamicInsert
@Service
public class salaryCalculateService {
   @Autowired
   salaryRepo salaryRepo;
   @Autowired
   EmployeeRepo employeeRepo;

   @Autowired
   private Calculations Calculation;
   private ResponseDTO  responseDTO= new ResponseDTO();


   private salaryDTO salaryDTO =  new salaryDTO();

   public ResponseDTO saveSalaryDetails(double grossSal,String Month,String empID){

      int exist = salaryRepo.existsAllByMonthAndId(Month,empID);
      if(exist>0){
         responseDTO.setResponseCode(handlerVal.RSP_DUPLICATED);
         responseDTO.setResponseMessage("Duplicated");
         responseDTO.setData(null);
         return responseDTO;
      }
      else if(grossSal<0){
         responseDTO.setResponseCode(handlerVal.RSP_FAIL);
         responseDTO.setResponseMessage("Invalid Input");
         responseDTO.setData(null);
         return responseDTO;
      }else if(grossSal>0 && employeeRepo.existsById(empID)){
         salaryDTO.setEmpID(empID);
         salaryDTO.setMonth(Month);
         salaryDTO.setGrossSalary(grossSal);
         salaryDTO.setDeductedTax(Calculation.TexCalculate(grossSal));
         salaryDTO.setEmployerContribution(Calculation.getEmployerContribution(grossSal));
         salaryDTO.setEmployeeContribution(Calculation.getEmployeeContribution(grossSal));
         salaryDTO.setTakeHomeSal(Calculation.TakeHomeSal(grossSal));
         salaryDTO.setTotalEpf(Calculation.getTotalEpf(grossSal));
         salaryDTO.setETF(Calculation.getETF(grossSal));
         try {
            salaryRepo.saveSalary(salaryDTO.getEmpID(),salaryDTO.getMonth(),salaryDTO.getGrossSalary(),salaryDTO.getDeductedTax(),salaryDTO.getEmployeeContribution(),salaryDTO.getEmployerContribution(),salaryDTO.getETF(),salaryDTO.getTotalEpf(),salaryDTO.getTakeHomeSal());
            responseDTO.setResponseCode(handlerVal.RSP_SUCCES);
            responseDTO.setData(salaryDTO);
            responseDTO.setResponseMessage("Succeed!!");
            return responseDTO;
         }catch (Exception ex){
            responseDTO.setResponseMessage("Internal Error");
            responseDTO.setResponseCode(handlerVal.RSP_FAIL);
            responseDTO.setData(null);
            return responseDTO;
         }

      }
      else{
         responseDTO.setResponseCode(handlerVal.RSP_NO_DATA_FOUND);
         responseDTO.setResponseMessage("No Employee Founded");
         responseDTO.setData(null);
         return responseDTO;
      }


   }


}
