package com.student.student.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String fName;
    private String lName;
    private int age;
    private String branch;
    private int year;
    private int semester;
    private String phone_no;
    private List<Course> courses_name;

}
