package com.example.law_bot.entity;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private Long id;
    private String userName;
    private String password;
    private Long coins;

}
