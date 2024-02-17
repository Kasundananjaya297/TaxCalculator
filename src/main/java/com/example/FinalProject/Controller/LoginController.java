package com.example.FinalProject.Controller;

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
    @PostMapping(value = "/changePassword/{UserName}/{CurrentPassword}/{newPassword}")
    public ResponseEntity changePassword(@PathVariable String UserName, @PathVariable String CurrentPassword, @PathVariable String newPassword){
        return new ResponseEntity(loginService.changePassword(UserName, CurrentPassword,newPassword), HttpStatus.ACCEPTED);
    }
}
