package com.student.student.controller;
import com.student.student.model.Student;
import com.student.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

        //<----------insert student--------->
    @PostMapping("/insert/single")
    public String insertStudent(@RequestBody Student student){
        return studentService.insertStudent(student);
    }

        //<----------insert student list--------->
    @PostMapping("/insert/multiple")
    public String insertMultipleStudent(@RequestBody List<Student> students){
        return studentService.insertMultipleStudent(students);
    }

        //<----------get student list--------->
    @GetMapping("/get/allStudent")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

        //<----------get student by id--------->
    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    //<----------get list of student who enroll in particular course--------->
    @GetMapping("get/courseName/{courseName}")
    public List<Student> getStudentListByCourse(@PathVariable String courseName){
        return studentService.getStudentListByCourse(courseName);
    }

        //<----------update student detail--------->
    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id){
        return studentService.updateStudent(student, id);
    }

        //<----------delete student--------->
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

}

