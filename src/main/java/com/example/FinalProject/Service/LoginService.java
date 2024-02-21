package com.example.FinalProject.Service;


import com.example.FinalProject.DTO.ResponseDTO;
import com.example.FinalProject.Repo.LoginRepo;
import com.example.FinalProject.utility.handlerVal;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Transactional
@Service
@DynamicInsert
public class LoginService {
    @Autowired
    private LoginRepo loginRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private ResponseDTO responseDTO = new ResponseDTO();

    public ResponseDTO validUser(String userName, String Password){
        if(loginRepo.existsById(userName)) {
            String StoredPassword  = loginRepo.findById(userName).get().getPassword();
            if (loginRepo.existsById(userName) && passwordEncoder.matches(Password, StoredPassword)) {
                responseDTO.setResponseCode(handlerVal.RSP_SUCCES);
                responseDTO.setResponseMessage("Valid User");
                responseDTO.setData(true);
                return responseDTO;
            } else {
                responseDTO.setResponseCode(handlerVal.RSP_FAIL);
                responseDTO.setResponseMessage("Invalid User");
                responseDTO.setData(false);
                return responseDTO;
            }
        } else {
            responseDTO.setResponseCode(handlerVal.RSP_FAIL);
            responseDTO.setResponseMessage("Invalid User");
            responseDTO.setData(false);
            return responseDTO;
        }

    }

    public ResponseDTO changePassword(String userName, String currentPassword, String newPassword) {
        String StoredPassword = loginRepo.findById(userName).get().getPassword();
        if(loginRepo.existsById(userName) && passwordEncoder.matches(currentPassword, StoredPassword)){
       // if(loginRepo.existsById(userName) && StoredPassword.equals(currentPassword)){
            responseDTO.setResponseCode(handlerVal.RSP_SUCCES);
            newPassword = passwordEncoder.encode(newPassword);
            loginRepo.changePassword(userName, newPassword);
            responseDTO.setResponseMessage("Password Changed");
            responseDTO.setData(true);
            return responseDTO;
        }
        else{
            responseDTO.setResponseCode(handlerVal.RSP_FAIL);
            responseDTO.setResponseMessage("Invalid User");
            responseDTO.setData(false);
            return responseDTO;
    }
    }
}
