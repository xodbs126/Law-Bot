package com.example.law_bot.controller;


import com.example.law_bot.DTO.ConsultResponseDTO;
import com.example.law_bot.DTO.CreateConsultDTO;
import com.example.law_bot.service.PlanService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping("/consult")
    public HttpEntity<Void> createConsult(
            @RequestBody CreateConsultDTO createConsultDTO
    ){
        planService.createConsult(createConsultDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/consult")
    public ResponseEntity<List<ConsultResponseDTO>> viewAllConsults() {
        List<ConsultResponseDTO> list = planService.getAllConsults();
        return ResponseEntity.ok(list);
    }
}
