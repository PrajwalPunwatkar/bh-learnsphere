package com.bh.learnsphere.repository;

import com.bh.learnsphere.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByCourseId(Long courseId);
    List<ChatMessage> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}

