package com.spring_AI.ToolCallingExample.controller;

import com.spring_AI.ToolCallingExample.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping
    public String chat(@RequestParam(required = true)String q){
        return chatService.chat(q);
    }
}
