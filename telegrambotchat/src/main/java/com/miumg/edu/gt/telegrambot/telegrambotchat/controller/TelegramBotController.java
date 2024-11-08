package com.miumg.edu.gt.telegrambot.telegrambotchat.controller;

import com.miumg.edu.gt.telegrambot.telegrambotchat.model.ChatMessage;
import com.miumg.edu.gt.telegrambot.telegrambotchat.service.TelegramBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class TelegramBotController {

    private final TelegramBotService telegramBotService;

    @Autowired
    public TelegramBotController(TelegramBotService telegramBotService) {
        this.telegramBotService = telegramBotService;
    }

    @PostMapping("/update")
    public void handleUpdate(@RequestBody String update) {
        // Lógica para manejar el mensaje recibido
        String chatId = "chatId";  // Obtén el ID del chat desde el cuerpo del mensaje.
        String userMessage = "userMessage";  // Obtén el mensaje del usuario.

        String response = telegramBotService.getChatGptResponse(userMessage);
        telegramBotService.sendMessage(chatId, response);

        // Guarda el mensaje de chat
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUserId(chatId);
        chatMessage.setMessage(userMessage);
        chatMessage.setResponse(response);
        telegramBotService.saveMessage(chatMessage);
    }
}
