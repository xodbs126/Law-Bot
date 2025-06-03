package com.example.law_bot.controller;

import com.example.law_bot.DTO.ChatRequestDTO;
import com.example.law_bot.DTO.ChatResponseDTO;
import com.example.law_bot.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/message")
    public ResponseEntity<ChatResponseDTO> handleMessage(@RequestBody ChatRequestDTO dto) {
        ChatResponseDTO response = chatService.handleUserMessage(dto);
        return ResponseEntity.ok(response);
    }
}
