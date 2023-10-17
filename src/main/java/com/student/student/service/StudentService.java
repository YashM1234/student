package com.student.student.service;

import com.student.student.model.Student;

import java.util.List;

public interface StudentService {
    String insertStudent(Student student);

    String insertMultipleStudent(List<Student> students);

    List<Student> getAllStudent();

    Student getStudentById(int id);

    Student updateStudent(Student student, int id);

    String deleteStudent(int id);
}




