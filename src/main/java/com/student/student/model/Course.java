package com.student.student.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int courseId;
    private String courseName;

    public Course(String course_name) {
        this.setCourseName(course_name);
    }
}
