package com.jey.skillup;

import com.jey.skillup.controller.StudentController;
import com.jey.skillup.entity.Course;
import com.jey.skillup.service.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private CourseService courseService;

    @InjectMocks
    private StudentController studentController;

    @Test
    void testGetAllCourses() {
        List<Course> mockCourses = List.of(new Course(), new Course());
        Mockito.when(courseService.getAllCourses()).thenReturn(mockCourses);

        ResponseEntity<List<Course>> response = studentController.getAllCourses();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(mockCourses, response.getBody());
    }

    @Test
    void testPurchaseCourse() {
        long courseId = 1L;
        String successMessage = "Course purchased successfully";
        Mockito.when(courseService.purchaseCourse(courseId)).thenReturn(successMessage);

        ResponseEntity<String> response = studentController.purchaseCourse(courseId);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(successMessage, response.getBody());
    }

    @Test
    void testGetPurchasedCourses() {
        Set<Course> purchasedCourses = Set.of(new Course(), new Course());
        Mockito.when(courseService.getPurchasedCourses()).thenReturn(purchasedCourses);

        ResponseEntity<Set<Course>> response = studentController.getPurchasedCourse();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(purchasedCourses, response.getBody());
    }
}
