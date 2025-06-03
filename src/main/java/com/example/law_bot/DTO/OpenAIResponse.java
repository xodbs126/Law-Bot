package com.example.law_bot.DTO;


public record OpenAIResponse(
        String content,
        String result,
        String reason
) {}