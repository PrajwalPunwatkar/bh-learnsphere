package com.bh.learnsphere.service;

import com.bh.learnsphere.model.ForumPost;
import com.bh.learnsphere.repository.ForumPostRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ForumService {

    private final ForumPostRepository forumRepo;

    public ForumService(ForumPostRepository forumRepo) {
        this.forumRepo = forumRepo;
    }

    public ForumPost createPost(ForumPost post) {
        post.setCreatedAt(LocalDateTime.now());
        return forumRepo.save(post);
    }

    public List<ForumPost> getCoursePosts(Long courseId) {
        return forumRepo.findByCourseId(courseId);
    }

    public List<ForumPost> getReplies(Long parentPostId) {
        return forumRepo.findByParentPostId(parentPostId);
    }
}
