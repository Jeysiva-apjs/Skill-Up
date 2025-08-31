package com.jey.skillup;

import com.jey.skillup.controller.InstructorController;
import com.jey.skillup.entity.Course;
import com.jey.skillup.request.CourseRequest;
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




@ExtendWith(MockitoExtension.class)
class InstructorControllerTest {

    @Mock
    private CourseService courseService;

    @InjectMocks
    private InstructorController instructorController;


    @Test
    void testCreateCourse() {
        CourseRequest course = new CourseRequest("Java", "Learn Java", 499.0, true);
        String expectedMessage = "Course created successfully";

        Mockito.when(courseService.createCourse(course)).thenReturn(expectedMessage);

        ResponseEntity<String> response = instructorController.createCourse(course);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(expectedMessage, response.getBody());
    }

    @Test
    void testUpdateCourse() {
        long courseId = 1L;
        CourseRequest course = new CourseRequest("Python", "Advanced Python", 599.0, true);
        String expectedMessage = "Course updated successfully";

        Mockito.when(courseService.updateCourse(courseId, course)).thenReturn(expectedMessage);

        ResponseEntity<String> response = instructorController.updateCourse(courseId, course);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(expectedMessage, response.getBody());
    }

    @Test
    void testDeleteCourse() {
        long courseId = 2L;
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
