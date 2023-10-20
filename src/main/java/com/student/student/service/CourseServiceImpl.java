package com.student.student.service;

import com.student.student.model.Course;
import com.student.student.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public String createCourse(Course course) {
        return courseRepository.createCourse(course);
    }

//
//    @Override
//    public String addCourse(Course course) {
//        return courseRepository.addCourse(course);
//    }
//
//    @Override
//    public String addMultipleCourse(List<Course> courses) {
//        return courseRepository.addMultipleCourse(courses);
//    }
//
//    @Override
//    public List<Course> getAllCourse() {
//        return courseRepository.getAllCourse();
//    }
//
//    @Override
//    public Course getCourseById(int id) {
//        return courseRepository.getCourseById(id);
//    }
//
//    @Override
//    public Course updateCourse(Course course, int id) {
//        return courseRepository.updateCourse(course, id);
//    }
//
//    @Override
//    public String deleteCourse(int id) {
//        return courseRepository.deleteCourse(id);
//    }
}
