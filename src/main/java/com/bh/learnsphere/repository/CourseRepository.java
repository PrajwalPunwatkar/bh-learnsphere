package com.bh.learnsphere.repository;

import com.bh.learnsphere.model.Course;
import com.bh.learnsphere.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByInstructor(User instructor);
    List<Course> findByCategory(String category);
    List<Course> findByPublishedTrue();
}
