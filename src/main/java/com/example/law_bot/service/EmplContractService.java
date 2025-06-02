package com.example.law_bot.service;

import com.example.law_bot.DTO.CreateEmpContractDTO;
import com.example.law_bot.DTO.EmplContractResponseDTO;

public interface EmplContractService {
    void createContract(CreateEmpContractDTO createEmpContractDTO);

    EmplContractResponseDTO getContractByUserId(Long userId);
}
