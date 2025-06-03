package com.example.law_bot.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponseDTO {
    private String content;
    private String adviceResult;   // NEED_ADVICE 등
    private String adviceReason;   // 이유 설명
}
