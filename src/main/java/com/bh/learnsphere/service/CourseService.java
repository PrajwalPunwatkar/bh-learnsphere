package com.bh.learnsphere.service;

import com.bh.learnsphere.model.Course;
import com.bh.learnsphere.entity.User;
import com.bh.learnsphere.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getPublishedCourses() {
        return courseRepository.findByPublishedTrue();
    }

    public List<Course> getInstructorCourses(User instructor) {
        return courseRepository.findByInstructor(instructor);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        return courseRepository.findById(id).map(course -> {
            course.setTitle(updatedCourse.getTitle());
            course.setDescription(updatedCourse.getDescription());
            course.setCategory(updatedCourse.getCategory());
            course.setLevel(updatedCourse.getLevel());
            course.setPublished(updatedCourse.isPublished());
            return courseRepository.save(course);
        }).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
