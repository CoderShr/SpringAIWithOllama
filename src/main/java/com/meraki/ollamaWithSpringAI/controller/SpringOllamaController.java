package com.meraki.ollamaWithSpringAI.controller;


import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringOllamaController {

    private final ChatModel chatModel;

    public SpringOllamaController(@Qualifier("ollamaChatModel") ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/prompt")
    public String getOpenAIResponse(@RequestParam String message) {
        return chatModel.call(message);

    }

    @GetMapping("/ping")
    public String getOpenAIResponse() {
        return "200 OK";

    }
}

