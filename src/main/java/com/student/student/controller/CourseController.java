package com.student.student.controller;

import com.student.student.model.Course;
import com.student.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public String createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }
//    //<----------add course--------->
//    @PostMapping("/add/single")
//    public String addCourse(@RequestBody Course course){
//        return courseService.addCourse(course);
//    }
//
//    //<----------add multiple course--------->
//    @PostMapping("/add/multiple")
//    public String addMultipleCourse(@RequestBody List<Course> courses){
//        return courseService.addMultipleCourse(courses);
//    }
//
//    //<----------get course list--------->
//    @GetMapping("/get/allCourse")
//    public List<Course> getAllCourse(){
//        return courseService.getAllCourse();
//    }
//
//    //<----------get course by id--------->
//    @GetMapping("/get/{id}")
//    public Course getCourseById(@PathVariable int id){
//        return courseService.getCourseById(id);
//    }
//
//    //<----------update course detail--------->
//    @PutMapping("/update/{id}")
//    public Course updateCourse(@RequestBody Course course, @PathVariable int id){
//        return courseService.updateCourse(course, id);
//    }
//
//    //<----------delete course--------->
//    @DeleteMapping("/delete/{id}")
//    public String deleteCourse(@PathVariable int id){
//        return courseService.deleteCourse(id);
//    }
}
