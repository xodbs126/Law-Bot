package com.example.law_bot.service;


import com.example.law_bot.DTO.CreateEmpContractDTO;
import com.example.law_bot.DTO.EmplContractResponseDTO;
import com.example.law_bot.entity.EmploymentContract;
import com.example.law_bot.entity.User;
import com.example.law_bot.repository.EmplContractRepository;
import com.example.law_bot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmplServiceImpl implements EmplContractService {

    private final UserRepository userRepository;
    private final EmplContractRepository emplContractRepository;

    @Override
    public void createContract(CreateEmpContractDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));

        EmploymentContract contract = new EmploymentContract();
        contract.setUser(user);
        contract.setCompanyName(dto.getCompanyName());
        contract.setCompanyAddress(dto.getCompanyAddress());
        contract.setEmployeeName(dto.getEmployeeName());
        contract.setEmployeeAddress(dto.getEmployeeAddress());
        contract.setContractStartDate(dto.getContractStartDate());
        contract.setContractEndDate(dto.getContractEndDate());
        contract.setWorkLocation(dto.getWorkLocation());
        contract.setJobDescription(dto.getJobDescription());
        contract.setWorkStartTime(dto.getWorkStartTime());
        contract.setWorkEndTime(dto.getWorkEndTime());
        contract.setBreakTime(dto.getBreakTime());
        contract.setWorkingDays(dto.getWorkingDays());
        contract.setWeeklyHoliday(dto.getWeeklyHoliday());
        contract.setWageType(dto.getWageType());
        contract.setWageAmount(dto.getWageAmount());
        contract.setWagePayDate(dto.getWagePayDate());
        contract.setPaymentMethod(dto.getPaymentMethod());
        contract.setAnnualLeavePolicy(dto.getAnnualLeavePolicy());
        contract.setSocialInsurance(dto.getSocialInsurance());
        contract.setContractSignedDate(dto.getContractSignedDate());

        emplContractRepository.save(contract);
    }

    @Override
    public List<EmplContractResponseDTO> getContractsByUserId(Long userId) {
        List<EmploymentContract> contracts = emplContractRepository.findAllByUserId(userId);
        return contracts.stream()
                .map(EmplContractResponseDTO::new)
                .toList();
    }
}