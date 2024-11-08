package com.miumg.edu.gt.telegrambot.telegrambotchat;

import org.junit.jupiter.api.BeforeEach;

import com.miumg.edu.gt.telegrambot.telegrambotchat.model.ChatMessage;
import com.miumg.edu.gt.telegrambot.telegrambotchat.model.UserSession;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class UserSessionTest {

    private UserSession userSession;

    @BeforeEach
    void setUp() {
        // Inicializar un objeto UserSession antes de cada prueba
        userSession = new UserSession();
        userSession.setUserId("user123");
        userSession.setStartTime(LocalDateTime.now());
    }

    @Test
    void testUserSessionCreation() {
        // Verificar que los valores se asignen correctamente
        assertNotNull(userSession.getStartTime());
        assertEquals("user123", userSession.getUserId());
    }

    @Test
    void testUserSessionEndTime() {
        // Establecer el tiempo de finalización
        LocalDateTime endTime = LocalDateTime.now();
        userSession.setEndTime(endTime);

        // Verificar que el tiempo de finalización se haya asignado correctamente
        assertEquals(endTime, userSession.getEndTime());
    }

    @Test
    void testUserSessionRelationshipWithChatMessage() {
        // Crear un ChatMessage relacionado con esta sesión
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setMessage("Hola");
        chatMessage.setUserId("user123");

        // Relacionar el chatMessage con el UserSession
        userSession.getChatMessages().add(chatMessage);
        chatMessage.setUserSession(userSession);

        // Verificar que la relación sea bidireccional
        assertTrue(userSession.getChatMessages().contains(chatMessage));
        assertEquals(userSession, chatMessage.getUserSession());
    }
}