package com.miumg.edu.gt.telegrambot.telegrambotchat;

import org.junit.jupiter.api.BeforeEach;

import com.miumg.edu.gt.telegrambot.telegrambotchat.model.ChatMessage;
import com.miumg.edu.gt.telegrambot.telegrambotchat.model.ErrorLog;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class ErrorLogTest {

    private ErrorLog errorLog;

    @BeforeEach
    void setUp() {
        // Inicializa el objeto ErrorLog antes de cada prueba
        errorLog = new ErrorLog();
        errorLog.setMessage("Error al procesar el mensaje");
        errorLog.setStackTrace("Stack trace aquí...");
        errorLog.setTimestamp(LocalDateTime.now());
    }

    @Test
    void testErrorLogCreation() {
        // Verificar que los valores se asignen correctamente
        assertNotNull(errorLog.getTimestamp());
        assertEquals("Error al procesar el mensaje", errorLog.getMessage());
        assertEquals("Stack trace aquí...", errorLog.getStackTrace());
    }

    @Test
    void testErrorLogRelationshipWithChatMessage() {
        // Crear un ChatMessage relacionado con este error
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setMessage("Mensaje de prueba");
        chatMessage.setUserId("user123");

        // Relacionar el chatMessage con el ErrorLog
        errorLog.getChatMessages().add(chatMessage);
        chatMessage.setErrorLog(errorLog);

        // Verificar que la relación entre ErrorLog y ChatMessage sea correcta
        assertTrue(errorLog.getChatMessages().contains(chatMessage));
        assertEquals(errorLog, chatMessage.getErrorLog());
    }
}
