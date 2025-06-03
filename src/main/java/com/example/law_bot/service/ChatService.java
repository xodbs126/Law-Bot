package com.example.law_bot.service;

import com.example.law_bot.AI.OpenAIResponse;
import com.example.law_bot.DTO.ChatRequestDTO;
import com.example.law_bot.DTO.ChatResponseDTO;
import com.example.law_bot.entity.ChatMessage;
import com.example.law_bot.entity.ChatSession;
import com.example.law_bot.repository.ChatMessageRepository;
import com.example.law_bot.repository.ChatSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatSessionRepository sessionRepo;
    private final ChatMessageRepository messageRepo;
    private final OpenAIClient openAIClient;

    public ChatResponseDTO handleUserMessage(ChatRequestDTO dto) {

        ChatSession session = sessionRepo.findById(dto.getSessionId())
                .orElseGet(() -> sessionRepo.save(new ChatSession(dto.getSessionId(), LocalDateTime.now())));


        ChatMessage msg = new ChatMessage();
        msg.setSession(session);
        msg.setSender(dto.getSender());
        msg.setContent(dto.getContent());
        messageRepo.save(msg);


        if (!"USER".equals(dto.getSender())) return null;

        List<ChatMessage> messages = messageRepo.findBySessionIdOrderByTimestampAsc(dto.getSessionId());
        String combinedUserContent = messages.stream()
                .filter(m -> "USER".equals(m.getSender()))
                .map(ChatMessage::getContent)
                .collect(Collectors.joining("\n"));


        String prompt = buildPrompt(combinedUserContent);
        OpenAIResponse aiResult = openAIClient.ask(prompt);


        ChatMessage aiMsg = new ChatMessage();
        aiMsg.setSession(session);
        aiMsg.setSender("AI");
        aiMsg.setContent(aiResult.content());
        aiMsg.setAdviceResult(aiResult.result());
        aiMsg.setAdviceReason(aiResult.reason());
        messageRepo.save(aiMsg);

        return new ChatResponseDTO(aiResult.content(), aiResult.result(), aiResult.reason());
    }

    private String buildPrompt(String userContent) {
        return """
        사용자의 대화 내용:
        %s

        이 대화에 대해 법률상담이 필요한지 판단해줘.
        필요하다면 이유도 간결하게 설명해줘.
        """.formatted(userContent);
    }
}
