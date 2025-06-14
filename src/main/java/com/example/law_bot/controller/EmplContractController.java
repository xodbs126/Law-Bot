package com.example.law_bot.controller;


import com.example.law_bot.DTO.CreateEmpContractDTO;
import com.example.law_bot.DTO.EmplContractResponseDTO;
import com.example.law_bot.service.EmplContractService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmplContractController {

    private final EmplContractService emplContractService;

    public EmplContractController(EmplContractService emplContractService) {
        this.emplContractService = emplContractService;
    }

    @PostMapping("/EmpContract")
    public HttpEntity<Void> createContract(@RequestBody CreateEmpContractDTO createEmpContractDTO){
        emplContractService.createContract(createEmpContractDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/EmpContract")
    public ResponseEntity<List<EmplContractResponseDTO>> viewContracts(@RequestParam Long userId) {
        List<EmplContractResponseDTO> contracts = emplContractService.getContractsByUserId(userId);
        return ResponseEntity.ok(contracts);
    }

}
