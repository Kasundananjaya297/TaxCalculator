package com.example.FinalProject.Controller;

import com.example.FinalProject.DTO.ChangePwDTO;
import com.example.FinalProject.DTO.ResponseDTO;
import com.example.FinalProject.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/validUser/{userName}/{Password}")
    public ResponseEntity validUser(@PathVariable String userName, @PathVariable String Password){
       return new ResponseEntity (loginService.validUser(userName, Password), HttpStatus.ACCEPTED);
    }
    @PutMapping(value = "/changePassword")
    public ResponseEntity changePassword(@RequestBody ChangePwDTO changePwDTO){
        System.out.println(changePwDTO);
        return new ResponseEntity(loginService.changePassword(changePwDTO.getUserName(), changePwDTO.getCurrentPassword(),changePwDTO.getNewPassword()), HttpStatus.ACCEPTED);
    }
}
