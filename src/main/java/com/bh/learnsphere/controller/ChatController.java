package com.bh.learnsphere.controller;

import com.bh.learnsphere.model.ChatMessage;
import com.bh.learnsphere.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/save")
    public ChatMessage saveMessage(@RequestBody ChatMessage message) {
        return chatService.saveMessage(message);
    }

    @GetMapping("/course/{courseId}")
    public List<ChatMessage> getCourseMessages(@PathVariable Long courseId) {
        return chatService.getMessagesForCourse(courseId);
    }

    @GetMapping("/dm/{senderId}/{receiverId}")
    public List<ChatMessage> getDirectMessages(@PathVariable Long senderId, @PathVariable Long receiverId) {
        return chatService.getDirectMessages(senderId, receiverId);
    }

    // --- WebSocket endpoint ---
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage broadcastMessage(ChatMessage message) {
        return chatService.saveMessage(message);
    }
}
