package com.prada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prada.dto.SignupRequest;
import com.prada.services.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class SignupController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request) {
        return userService.signup(request);
    }
}
