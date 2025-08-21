package com.jey.skillup.service;

import com.jey.skillup.entity.Course;
import com.jey.skillup.request.CourseRequest;

import java.util.List;
import java.util.Set;

public interface CourseService {

    String createCourse(CourseRequest courseRequest);
    Course getCourse(long courseId);
    String updateCourse(long courseId, CourseRequest courseRequest);
    String deleteCourse(long courseId);
    List<Course> getAllCourses();
    List<Course> getPublishedCourses();
    String purchaseCourse(long courseId);
    Set<Course> getPurchasedCourses();

}