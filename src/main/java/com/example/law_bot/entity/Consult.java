package com.example.law_bot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "consults")
@Getter
@Setter
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConsultArea consultArea;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConsultRange consultRange;

    @Column(nullable = false)
    private LocalDateTime consultTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConsultStatus status;

    public enum ConsultArea {
        SEOUL, GYEONGGI, GANGWON, CHUNGBUK, CHUNGNAM, GYEONGBUK, GYEONGNAM, JEONBUK, JEONNAM
    }

    public enum ConsultRange {
        CIVIL, CRIMINAL, REAL_ESTATE, INHERITANCE, DIVORCE, LABOR
    }

    public enum ConsultStatus {
        WAITING, IN_PROGRESS, COMPLETED
    }
}
