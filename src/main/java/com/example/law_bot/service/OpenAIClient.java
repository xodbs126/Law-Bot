package com.example.law_bot.service;

import com.example.law_bot.AI.OpenAIResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class OpenAIClient {

    private final RestTemplate restTemplate;
    private final String OPENAI_API_KEY = "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";
    private final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";

    public OpenAIClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public OpenAIResponse ask(String prompt) {
        // MOCK 응답
        return new OpenAIResponse(
                "법률 상담이 필요합니다. 이유: 상대방과의 물리적 충돌 가능성이 있습니다.",
                "NEED_ADVICE",
                "물리적 충돌이 발생한 경우 형사 처벌 대상일 수 있음"
        );
    }

//    public OpenAIResponse ask(String prompt) {
//        // 1. 요청 헤더 설정
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(OPENAI_API_KEY);
//
//        // 2. 요청 본문 구성
//        Map<String, Object> requestBody = Map.of(
//                "model", "gpt-3.5-turbo",
//                "messages", List.of(
//                        Map.of("role", "system", "content", "너는 법률상담이 필요한지 판단하는 AI야. 결과와 이유를 명확히 말해줘."),
//                        Map.of("role", "user", "content", prompt)
//                ),
//                "temperature", 0.7
//        );
//
//        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
//
//        // 3. 요청 전송
//        ResponseEntity<Map> response = restTemplate.postForEntity(OPENAI_API_URL, entity, Map.class);
//
//        // 4. 응답 안전하게 파싱
//        Map<String, Object> responseBody = response.getBody();
//        if (responseBody == null || !responseBody.containsKey("choices")) {
//            throw new IllegalStateException("OpenAI 응답이 비어 있거나 형식이 잘못됨");
//        }
//
//        List<Map<String, Object>> choices = (List<Map<String, Object>>) responseBody.get("choices");
//        if (choices == null || choices.isEmpty()) {
//            throw new IllegalStateException("OpenAI 응답에 choices가 없음");
//        }
//
//        Map<String, Object> firstChoice = choices.get(0);
//        Map<String, Object> message = (Map<String, Object>) firstChoice.get("message");
//
//        if (message == null || !message.containsKey("content")) {
//            throw new IllegalStateException("OpenAI 응답에서 content를 찾을 수 없음");
//        }
//
//        String content = (String) message.get("content");
//
//        // 5. 판단 결과 파싱
//        String result = extractResult(content);
//        String reason = extractReason(content);
//
//        return new OpenAIResponse(content, result, reason);
//    }

    private String extractResult(String content) {
        if (content.contains("상담이 필요")) return "NEED_ADVICE";
        else if (content.contains("필요하지 않")) return "NO_ADVICE";
        else return "UNKNOWN";
    }

    private String extractReason(String content) {
        return content;
    }
}
