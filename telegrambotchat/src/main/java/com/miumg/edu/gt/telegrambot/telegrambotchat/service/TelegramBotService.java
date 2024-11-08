package com.miumg.edu.gt.telegrambot.telegrambotchat.service;

import com.miumg.edu.gt.telegrambot.telegrambotchat.model.ChatMessage;
import com.miumg.edu.gt.telegrambot.telegrambotchat.repository.ChatmenssageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TelegramBotService {

    @Value("${telegram.bot.token}")
    private String botToken;

    private final ChatmenssageRepository chatMessageRepository;
    private final RestTemplate restTemplate;

    public TelegramBotService(ChatmenssageRepository chatMessageRepository, RestTemplate restTemplate) {
        this.chatMessageRepository = chatMessageRepository;
        this.restTemplate = restTemplate;
    }

    // Lógica para enviar el mensaje a Telegram
    public void sendMessage(String chatId, String text) {
        String url = "https://api.telegram.org/bot" + botToken + "/sendMessage?chat_id=" + chatId + "&text=" + text;
        restTemplate.getForObject(url, String.class);
    }

    // Lógica para interactuar con OpenAI (ejemplo básico)
    public String getChatGptResponse(String userMessage) {
        // Integrar la lógica para llamar a OpenAI y obtener la respuesta
        return "Esta es la respuesta de ChatGPT para: " + userMessage;
    }

    public ChatMessage saveMessage(ChatMessage message) {
        return chatMessageRepository.save(message);
    }
}
