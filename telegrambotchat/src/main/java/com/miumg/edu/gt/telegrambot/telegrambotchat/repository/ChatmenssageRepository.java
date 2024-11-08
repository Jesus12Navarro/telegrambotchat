package com.miumg.edu.gt.telegrambot.telegrambotchat.repository;

import com.miumg.edu.gt.telegrambot.telegrambotchat.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatmenssageRepository extends JpaRepository<ChatMessage, Long> {
    
}
