package com.example.law_bot.controller;


import com.example.law_bot.DTO.UserRegisterDTO;
import com.example.law_bot.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public HttpEntity<Void> register(
            @PathVariable UserRegisterDTO userRegisterDTO
    ) {
        return new HttpEntity<Void>(userService.userRegister(userRegisterDTO),HttpStatus.CREATED);
    }
}
