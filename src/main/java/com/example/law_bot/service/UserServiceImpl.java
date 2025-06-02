package com.example.law_bot.service;

import com.example.law_bot.DTO.UserRegisterDTO;
import com.example.law_bot.controller.UserPayDTO;
import com.example.law_bot.entity.User;
import com.example.law_bot.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void userRegister(UserRegisterDTO dto) {
        if (userRepository.existsByUserName(dto.getUserName())) {
            throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
        }

        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        user.setCoins(0L);

        userRepository.save(user);
    }

    @Override
    @Transactional
    public void userPay(UserPayDTO userPayDTO) {
        User user = userRepository.findById(userPayDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));

        Long originalCoins = user.getCoins();
        user.setCoins(originalCoins + userPayDTO.getCoins());

        userRepository.save(user);
    }
}