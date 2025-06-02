package com.example.law_bot.repository;

import com.example.law_bot.entity.EmploymentContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmplContractRepository extends JpaRepository<EmploymentContract, Long> {
    Optional<EmploymentContract> findByUserId(Long userId);
}