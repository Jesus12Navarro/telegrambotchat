package com.miumg.edu.gt.telegrambot.telegrambotchat.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Data
@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String message;
    private String response;
    private LocalDateTime timestamp = LocalDateTime.now();
       // Getters y setters
       public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserMessage() {
        return message;
    }

    public void setUserMessage(String userMessage) {
        this.message = userMessage;
    }

    public String getBotResponse() {
        return response;
    }

    public void setBotResponse(String botResponse) {
        this.response = botResponse;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    @ManyToOne
    @JoinColumn(name = "error_log_id")
    private ErrorLog errorLog;

    public void setUserSession(UserSession userSession) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUserSession'");
    }

    public Object getUserSession() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserSession'");
    }


}
