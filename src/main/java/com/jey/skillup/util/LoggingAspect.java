package com.jey.skillup.util;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {


    @Before("execution(* com.jey.skillup.service.CourseService.createCourse(..))")
    public void logBeforeCreate(JoinPoint joinPoint) {
        log.info("Creating course with request: {}", joinPoint.getArgs()[0]);
    }

    @AfterReturning(pointcut = "execution(* com.jey.skillup.service.CourseService.createCourse(..))",
            returning = "result")
    public void logAfterCreate(Object result) {
        log.info("Course creation result: {}", result);
    }

    @Before("execution(* com.jey.skillup.service.CourseService.updateCourse(..))")
    public void logBeforeUpdate(JoinPoint joinPoint) {
        log.info("Updating course ID: {}, New data: {}", joinPoint.getArgs()[0], joinPoint.getArgs()[1]);
    }

    @AfterReturning(pointcut = "execution(* com.jey.skillup.service.CourseService.updateCourse(..))",
            returning = "result")
    public void logAfterUpdate(Object result) {
        log.info("Course update result: {}", result);
    }


    @Before("execution(* com.jey.skillup.service.CourseService.deleteCourse(..))")
    public void logBeforeDelete(JoinPoint joinPoint) {
        log.info("Deleting course with ID: {}", joinPoint.getArgs()[0]);
    }

    @AfterReturning(pointcut = "execution(* com.jey.skillup.service.CourseService.deleteCourse(..))",
            returning = "result")
    public void logAfterDelete(Object result) {
        log.info("Course deletion result: {}", result);
    }
}
