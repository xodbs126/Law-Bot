package com.example.law_bot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "employment_contracts")
@Getter
@Setter
public class EmploymentContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


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
