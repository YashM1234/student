package com.student.student.repository;

import com.student.student.model.Student;

import java.util.List;

public interface StudentRepository {

    String insertStudent(Student student);

    String insertMultipleStudent(List<Student> students);

    List<Student> getAllStudent();

    Student getStudentById(int id);

    List<Student> getStudentListByCourse(String courseName);

    Student updateStudent(Student student, int id);

    String deleteStudent(int id);

}

