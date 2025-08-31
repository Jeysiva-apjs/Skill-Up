package com.jey.skillup.service;

import com.jey.skillup.entity.Course;
import com.jey.skillup.exception.CourseNotFoundException;
import com.jey.skillup.exception.UserNotFoundException;
import com.jey.skillup.repository.CourseRepository;
import com.jey.skillup.request.CourseRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    CourseRepository courseRepository;

    @InjectMocks
    CourseServiceImpl courseService;

    static long courseId;

    @BeforeAll
    static void init(){
        courseId = 1;
    }

    @Test
    void testDeleteCourseThrowsException() {

        Mockito.when(courseRepository.findById(courseId)).thenReturn(Optional.empty());

        Assertions.assertThrows(CourseNotFoundException.class, () -> courseService.deleteCourse(courseId));
    }

    @Test
    void testGetCourseThrowsException() {

        Mockito.when(courseRepository.findById(courseId)).thenReturn(Optional.empty());

        Assertions.assertThrows(CourseNotFoundException.class, () -> courseService.getCourse(courseId));
    }

    @Test
    void testUpdateCourseThrowsException() {
        CourseRequest course = new CourseRequest();

        Mockito.when(courseRepository.findById(courseId)).thenReturn(Optional.empty());

        CourseNotFoundException exception = Assertions.assertThrows(CourseNotFoundException.class, () -> courseService.updateCourse(courseId, course));
        Assertions.assertEquals("Could not find course with id 1.", exception.getMessage());
    }

}
