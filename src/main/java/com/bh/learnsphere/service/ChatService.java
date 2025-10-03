package com.bh.learnsphere.service;

import com.bh.learnsphere.model.ChatMessage;
import com.bh.learnsphere.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {

    private final ChatMessageRepository chatRepo;

    public ChatService(ChatMessageRepository chatRepo) {
        this.chatRepo = chatRepo;
    }

    public ChatMessage saveMessage(ChatMessage message) {
        message.setSentAt(LocalDateTime.now());
        return chatRepo.save(message);
    }

    public List<ChatMessage> getMessagesForCourse(Long courseId) {
        return chatRepo.findByCourseId(courseId);
    }

    public List<ChatMessage> getDirectMessages(Long senderId, Long receiverId) {
        return chatRepo.findBySenderIdAndReceiverId(senderId, receiverId);
    }
}

