package com.example.law_bot.service;

import com.example.law_bot.DTO.CreateEmpContractDTO;
import com.example.law_bot.DTO.EmplContractResponseDTO;

import java.util.List;

public interface EmplContractService {
    void createContract(CreateEmpContractDTO createEmpContractDTO);

    List<EmplContractResponseDTO> getContractsByUserId(Long userId);
}
