package com.geekster.UserApplications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authService;

    @PostMapping("/signup")
    public Patient signUp(@RequestBody SignUpInput signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }


    @GetMapping("/getUsers")
    public List<Patient> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody String key) throws LoginException {
        String msg=userService.logOutFromAccount(key);
        return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
    }

}