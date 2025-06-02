package com.example.law_bot.repository;

import com.example.law_bot.DTO.UserRegisterDTO;

public interface UserRepository {
    void userRegister(UserRegisterDTO userRegisterDTO);
}
