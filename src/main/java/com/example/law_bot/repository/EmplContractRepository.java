package com.example.law_bot.repository;

import com.example.law_bot.entity.EmploymentContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmplContractRepository extends JpaRepository<EmploymentContract, Long> {
    List<EmploymentContract> findAllByUserId(Long userId);
}