package com.example.law_bot.DTO;

import com.example.law_bot.entity.Consult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultResponseDTO {
    private Long id;
    private String content;
    private String consultArea;
    private String consultRange;
    private String status;
    private LocalDateTime consultTime;
    private Long userId;

    public ConsultResponseDTO(Consult consult) {
        this.id = consult.getId();
        this.content = consult.getContent();
        this.consultArea = consult.getConsultArea().name();
        this.consultRange = consult.getConsultRange().name();
        this.status = consult.getStatus().name();
        this.consultTime = consult.getConsultTime();
        this.userId = consult.getUser().getId();
    }
}