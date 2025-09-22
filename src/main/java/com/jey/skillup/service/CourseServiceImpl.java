package com.jey.skillup.service;

import com.jey.skillup.entity.Course;
import com.jey.skillup.entity.User;
import com.jey.skillup.exception.CourseNotFoundException;
import com.jey.skillup.repository.CourseRepository;
import com.jey.skillup.repository.UserRepository;
import com.jey.skillup.request.CourseRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    @Transactional
    public String createCourse(CourseRequest courseRequest) {

        Course course = convertToCourse(courseRequest);
        courseRepository.save(course);
        return "Course created successfully";
    }

    public Course convertToCourse(CourseRequest courseRequest){
        Course course = new Course();
        course.setDescription(courseRequest.getDescription());
        course.setTitle(courseRequest.getTitle());
        course.setPrice(courseRequest.getPrice());
        course.setPublished(courseRequest.getIsPublished());

        return course;
    }

    @Override
    @Transactional(readOnly = true)
    public Course getCourse(long id) {
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> getPublishedCourses() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        return courses.stream().filter(course -> course.isPublished() == true).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String purchaseCourse(long courseId) {
        User user = userService.getCurrentUser();
        Course course = courseRepository.findById(courseId).orElseThrow(()-> new CourseNotFoundException(courseId));
        course.getUsers().add(user);
        courseRepository.save(course);
        return "Course purchased successfully";
    }

    @Override
    @Transactional
    public Set<Course> getPurchasedCourses() {
        String email = userService.getCurrentUsername();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
//        user.getCourses().size();
        return user.getCourses();
    }


    @Override
    @Transactional
    public String updateCourse(long courseId, CourseRequest course) {
        Course updateCourse = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        updateCourse.setTitle(course.getTitle());
        updateCourse.setDescription(course.getDescription());
        updateCourse.setPrice(course.getPrice());
        updateCourse.setPublished(course.getIsPublished());
        courseRepository.save(updateCourse);
        return "Course updated successfully";
    }

    @Override
    @Transactional
    public String deleteCourse(long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        courseRepository.delete(course);
        return "Course deleted successfully";
    }

}
