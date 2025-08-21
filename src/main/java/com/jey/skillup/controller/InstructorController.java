package com.jey.skillup.controller;

import java.util.List;

import com.jey.skillup.entity.Course;
import com.jey.skillup.request.CourseRequest;
import com.jey.skillup.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(name = "Instructor API Endpoints")
@RestController
@RequestMapping("/instructor/courses")
@AllArgsConstructor
public class InstructorController {

    private CourseService courseService;

    @Operation(summary = "Create A New Course")
    @PostMapping("/create")
    public ResponseEntity<String> createCourse(@Valid @RequestBody CourseRequest courseRequest) {
        courseService.createCourse(courseRequest);
        return new ResponseEntity<>("Course created successfully", HttpStatus.CREATED);
    }

    @Operation(summary = "Update Existing Course")
    @PutMapping("/update/{courseId}")
    public ResponseEntity<String> updateCourse(@PathVariable Long courseId, @Valid @RequestBody CourseRequest courseRequest) {
        return new ResponseEntity<>(courseService.updateCourse(courseId, courseRequest), HttpStatus.OK);
    }

    @Operation(summary = "Delete Existing Course")
    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId) {
        return new ResponseEntity<>(courseService.deleteCourse(courseId), HttpStatus.OK);
    }

    @Operation(summary = "Get All Courses")
    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

}
