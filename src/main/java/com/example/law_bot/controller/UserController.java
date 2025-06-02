package com.example.law_bot.controller;

import com.example.law_bot.DTO.UserPayDTO;
import com.example.law_bot.DTO.UserRegisterDTO;
import com.example.law_bot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        userService.userRegister(userRegisterDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/pay")
    public ResponseEntity<Void> pay(@RequestBody UserPayDTO userPayDTO) {
        userService.userPay(userPayDTO);
        return ResponseEntity.ok().build();
    }

}
