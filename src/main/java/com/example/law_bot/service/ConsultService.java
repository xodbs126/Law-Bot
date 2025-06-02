package com.example.law_bot.service;

import com.example.law_bot.DTO.ConsultResponseDTO;
import com.example.law_bot.DTO.CreateConsultDTO;

import java.util.List;

public interface ConsultService {
    void createConsult(CreateConsultDTO createConsultDTO);

    List<ConsultResponseDTO> getAllConsults();

}
