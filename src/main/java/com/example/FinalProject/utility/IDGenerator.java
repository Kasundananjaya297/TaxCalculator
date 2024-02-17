package com.example.FinalProject.utility;

import com.example.FinalProject.Repo.EmployeeRepo;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.Integer.parseInt;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Service
public class IDGenerator {

    @Autowired
    private EmployeeRepo employeeRepo;
    private String DefaultID = "EMP-1000";
    private String getSeparateStringPart(String ID){
        return ID.replaceAll("[\\d]","");

    }
    private String getSeperateNumbericPart(String ID){
        return ID.replaceAll("[^\\d]","");
    }

    public String NextUserID(String ID){
        String NewID =getSeparateStringPart(ID) + (parseInt(getSeperateNumbericPart(ID))+1);
        return NewID;
    }
    public String getMaxEmployeeId() {
        String maxEmployeeId = employeeRepo.maxID();
        if(!(maxEmployeeId == null)){
            System.out.println(maxEmployeeId);
            return NextUserID(maxEmployeeId.toString());
        }
        else{
            return NextUserID(DefaultID);
        }
    }
}
