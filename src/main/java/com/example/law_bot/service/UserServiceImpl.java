package com.example.law_bot.service;


import com.example.law_bot.DTO.UserRegisterDTO;
import com.example.law_bot.repository.UserRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    static final UserRepositoryImpl userRepository;
    public UserServiceImpl(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Void userRegister(UserRegisterDTO userRegisterDTO) {
        userRepository.userRegister(userRegisterDTO);
    }
}
