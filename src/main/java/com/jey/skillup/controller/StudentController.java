package com.jey.skillup.controller;


import java.util.List;
import java.util.Set;

import com.jey.skillup.entity.Course;
import com.jey.skillup.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(name = "Student API Endpoints")
@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private CourseService courseService;

    @Operation(summary = "View All Available Courses")
    @GetMapping("/courses/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @Operation(summary = "Purchase a Course")
    @PostMapping("/purchaseCourses/{courseId}")
    public ResponseEntity<String> purchaseCourse(@PathVariable Long courseId) {
        return new ResponseEntity<>(courseService.purchaseCourse(courseId), HttpStatus.OK);
    }

    @Operation(summary = "Get All Purchased Courses")
    @GetMapping("/purchasedCourses")
    public ResponseEntity<Set<Course>> getPurchasedCourse() {
        return new ResponseEntity<>(courseService.getPurchasedCourses(), HttpStatus.OK);
    }

}