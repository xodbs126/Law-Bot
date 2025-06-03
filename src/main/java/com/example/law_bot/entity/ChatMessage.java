package com.example.law_bot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class ChatMessage {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private ChatSession session;

    private String sender; // "USER" or "AI"

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime timestamp;

    private String adviceResult;  // NEED_ADVICE, NO_ADVICE, UNKNOWN
    private String adviceReason;

    @PrePersist
    public void prePersist() {
        this.timestamp = LocalDateTime.now();
    }
}
