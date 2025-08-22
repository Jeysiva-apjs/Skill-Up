package com.jey.skillup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jey.skillup.controller.InstructorController;
import com.jey.skillup.entity.Course;
import com.jey.skillup.exception.ApplicationExceptionHandler;
import com.jey.skillup.exception.CourseNotFoundException;
import com.jey.skillup.request.CourseRequest;
import com.jey.skillup.service.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.MediaType;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class InstructorControllerTest {

    @Mock
    private CourseService courseService;

    @InjectMocks
    private InstructorController instructorController;


    @Test
    void testCreateCourse() {
        CourseRequest request = new CourseRequest("Java", "Learn Java", 499.0, true);

        ResponseEntity<String> response = instructorController.createCourse(request);

        Mockito.verify(courseService).createCourse(request);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals("Course created successfully", response.getBody());
    }

    @Test
    void testUpdateCourse() {
        Long courseId = 1L;
        CourseRequest request = new CourseRequest("Python", "Advanced Python", 599.0, true);
        String expectedMessage = "Course updated successfully";

        Mockito.when(courseService.updateCourse(courseId, request)).thenReturn(expectedMessage);

        ResponseEntity<String> response = instructorController.updateCourse(courseId, request);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(expectedMessage, response.getBody());
    }

    @Test
    void testDeleteCourse() {
        Long courseId = 2L;
        String expectedMessage = "Course deleted successfully";

        Mockito.when(courseService.deleteCourse(courseId)).thenReturn(expectedMessage);

        ResponseEntity<String> response = instructorController.deleteCourse(courseId);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(expectedMessage, response.getBody());
    }

    @Test
    void testGetAllCourses() {
        List<Course> mockCourses = List.of(new Course(), new Course());

        Mockito.when(courseService.getAllCourses()).thenReturn(mockCourses);

        ResponseEntity<List<Course>> response = instructorController.getAllCourses();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(mockCourses, response.getBody());
    }

}
