package com.example.law_bot.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class CreateEmpContractDTO {

    private Long userId;

    private String companyName;
    private String companyAddress;

    private String employeeName;
    private String employeeAddress;


    private LocalDate contractStartDate;
    private LocalDate contractEndDate;

    private String workLocation;
    private String jobDescription;

    private LocalTime workStartTime;
    private LocalTime workEndTime;
    private String breakTime;
    private String workingDays;
    private String weeklyHoliday;

    private String wageType;
    private Long wageAmount;
    private String wagePayDate;
    private String paymentMethod;

    private String annualLeavePolicy;
    private String socialInsurance;

    private LocalDate contractSignedDate;
}
