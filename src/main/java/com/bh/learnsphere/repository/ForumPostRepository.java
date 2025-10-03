package com.bh.learnsphere.repository;

import com.bh.learnsphere.model.ForumPost;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ForumPostRepository extends JpaRepository<ForumPost, Long> {
    List<ForumPost> findByCourseId(Long courseId);
    List<ForumPost> findByParentPostId(Long parentPostId);
}
