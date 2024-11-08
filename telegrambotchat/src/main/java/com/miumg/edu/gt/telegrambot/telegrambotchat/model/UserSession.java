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
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private LocalDateTime startTime = LocalDateTime.now();
    private LocalDateTime endTime;

    @OneToMany(mappedBy = "userSession")
    private Set<ChatMessage> chatMessages;
}
