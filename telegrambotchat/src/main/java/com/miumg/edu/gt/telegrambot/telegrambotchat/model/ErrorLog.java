package com.miumg.edu.gt.telegrambot.telegrambotchat.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;


@Data
@Entity
public class ErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private String stackTrace;
    private LocalDateTime timestamp = LocalDateTime.now();

    @OneToMany(mappedBy = "errorLog")
    private Set<ChatMessage> chatMessages;
}