package com.student.student.service;

import com.student.student.model.Student;
import com.student.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String insertStudent(Student student) {
        return studentRepository.insertStudent(student);
    }

//    @Override
//    public String insertStudent(Student student) {
//        return studentRepository.insertStudent(student);
//    }
//
//    @Override
//    public String insertMultipleStudent(List<Student> students) {
//        return studentRepository.insertMultipleStudent(students);
//    }
//
//    @Override
//    public List<Student> getAllStudent() {
//        return studentRepository.getAllStudent();
//    }
//
//    @Override
//    public Student getStudentById(int id) {
//        return studentRepository.getStudentById(id);
//    }
//
//    @Override
//    public Student updateStudent(Student student, int id) {
//        return studentRepository.updateStudent(student, id);
//    }
//
//    @Override
//    public String deleteStudent(int id) {
//        return studentRepository.deleteStudent(id);
//    }
}
