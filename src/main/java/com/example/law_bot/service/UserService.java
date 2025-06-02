package com.example.law_bot.service;

import com.example.law_bot.DTO.UserRegisterDTO;
import com.example.law_bot.controller.UserPayDTO;

public interface UserService {
    void userRegister(UserRegisterDTO dto);

    void userPay(UserPayDTO userPayDTO);
}

