package com.example.law_bot.DTO;

import com.example.law_bot.entity.EmploymentContract;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class EmplContractResponseDTO {

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

    public EmplContractResponseDTO(EmploymentContract e) {
        this.companyName = e.getCompanyName();
        this.companyAddress = e.getCompanyAddress();
        this.employeeName = e.getEmployeeName();
        this.employeeAddress = e.getEmployeeAddress();
        this.contractStartDate = e.getContractStartDate();
        this.contractEndDate = e.getContractEndDate();
        this.workLocation = e.getWorkLocation();
        this.jobDescription = e.getJobDescription();
        this.workStartTime = e.getWorkStartTime();
        this.workEndTime = e.getWorkEndTime();
        this.breakTime = e.getBreakTime();
        this.workingDays = e.getWorkingDays();
        this.weeklyHoliday = e.getWeeklyHoliday();
        this.wageType = e.getWageType();
        this.wageAmount = e.getWageAmount();
        this.wagePayDate = e.getWagePayDate();
        this.paymentMethod = e.getPaymentMethod();
        this.annualLeavePolicy = e.getAnnualLeavePolicy();
        this.socialInsurance = e.getSocialInsurance();
        this.contractSignedDate = e.getContractSignedDate();
    }
}
