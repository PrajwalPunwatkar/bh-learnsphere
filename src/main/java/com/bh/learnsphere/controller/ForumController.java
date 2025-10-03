package com.bh.learnsphere.controller;

import com.bh.learnsphere.model.ForumPost;
import com.bh.learnsphere.service.ForumService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forum")
public class ForumController {

    private final ForumService forumService;

    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @PostMapping("/post")
    public ForumPost createPost(@RequestBody ForumPost post) {
        return forumService.createPost(post);
    }

    @GetMapping("/course/{courseId}")
    public List<ForumPost> getPostsByCourse(@PathVariable Long courseId) {
        return forumService.getCoursePosts(courseId);
    }

    @GetMapping("/replies/{parentId}")
    public List<ForumPost> getReplies(@PathVariable Long parentId) {
        return forumService.getReplies(parentId);
    }
}

