package com.example.law_bot.DTO;


import com.example.law_bot.entity.Consult.ConsultArea;
import com.example.law_bot.entity.Consult.ConsultRange;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateConsultDTO {
    private Long userId;
    private String content;
    private ConsultArea consultArea;
    private ConsultRange consultRange;
    private LocalDateTime consultTime;
}