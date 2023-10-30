package com.student.student.repository;
import com.student.student.model.Course;
import com.student.student.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate){
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    //    <----------insert single student--------->
    @Override
    public String insertStudent(Student student) {
        try{
            String query = "insert into student(fname,lname,age,branch,year,semester,phone_no) values('"
                    + student.getFName() + "', '" + student.getLName() + "', "
                + student.getAge() + ", '" + student.getBranch() + "', " + student.getYear() + ", "
                + student.getSemester() + ", '" + student.getPhone_no() + "')";
            jdbcTemplate.update(query);

            int studentId = getIdByQuery(student);
            System.out.println(studentId);

            mapCourse(student, studentId);
            return "student data inserted successfully!";
        }catch(Exception ex){
            ex.printStackTrace();
            return "student data doesn't inserted!";
        }
    }

    //<----------insert student list--------->
    @Override
    public String insertMultipleStudent(List<Student> students) {
        try{
            for(Student student: students) {
                String query = "insert into student(fname,lname,age,branch,year,semester,phone_no) values('"
                        + student.getFName() + "', '" + student.getLName() + "', "
                        + student.getAge() + ", '" + student.getBranch() + "', " + student.getYear() + ", "
                        + student.getSemester() + ", '" + student.getPhone_no() + "')";
                jdbcTemplate.update(query);

                int studentId = getIdByQuery(student);
                System.out.println(studentId);

                mapCourse(student, studentId);
            }
            return "student data inserted successfully!";
        }catch(Exception ex){
            ex.printStackTrace();
            return "student data doesn't inserted!";
        }
    }

    //<----------get student list--------->
    @Override
    public List<Student> getAllStudent() {
        try{
            String query = "select * from student";
            return jdbcTemplate.query(query, new RowMapper<Student>() {
                @Override
                public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Student student = new Student();
                    student.setId(rs.getInt("student_id"));
                    student.setFName(rs.getString("fname"));
                    student.setLName(rs.getString("lname"));
                    student.setAge(rs.getInt("age"));
                    student.setBranch(rs.getString("branch"));
                    student.setYear(rs.getInt("year"));
                    student.setSemester(rs.getInt("semester"));
                    student.setPhone_no(rs.getString("phone_no"));
                    student.setCourses_name(getCourseList(student.getId()));
                    return student;
                }
            });
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

        //<----------get student by id--------->
    @Override
    public Student getStudentById(int id) {
        try{
            String query = "select * from student where student_id=?";
            return jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Student>() {
                @Override
                public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Student student = new Student();
                    student.setId(rs.getInt("student_id"));
                    student.setFName(rs.getString("fname"));
                    student.setLName(rs.getString("lname"));
                    student.setAge(rs.getInt("age"));
                    student.setBranch(rs.getString("branch"));
                    student.setYear(rs.getInt("year"));
                    student.setSemester(rs.getInt("semester"));
                    student.setPhone_no(rs.getString("phone_no"));
                    student.setCourses_name(getCourseList(student.getId()));
                    return student;
                }
            });
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    //<----------get list of student who enroll in particular course--------->
    @Override
    public List<Student> getStudentListByCourse(String courseName) {
        try{
            String query = "SELECT student.student_id, student.fname, student.lname, student.age, student.branch, " +
                    "student.year, student.semester, student.phone_no " +
                    "FROM student INNER JOIN course ON student.student_id = course.student_id " +
                    "WHERE course.course_name = ? ";

            return jdbcTemplate.query(query,new Object[]{courseName}, new RowMapper<Student>() {
                @Override
                public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Student student = new Student();
                    student.setId(rs.getInt("student_id"));
                    student.setFName(rs.getString("fname"));
                    student.setLName(rs.getString("lname"));
                    student.setAge(rs.getInt("age"));
                    student.setBranch(rs.getString("branch"));
                    student.setYear(rs.getInt("year"));
                    student.setSemester(rs.getInt("semester"));
                    student.setPhone_no(rs.getString("phone_no"));
                    student.setCourses_name(getCourseList(student.getId()));
                    return student;
                }
            });
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    //<----------update student detail--------->
    @Override
    public Student updateStudent(Student student, int id) {
        try{
            String query = "update student set fname=?, lname=?, age=?, branch=?, year=?, semester=?, phone_no=?" +
                    "where student_id=?";
            jdbcTemplate.update(query, student.getFName(), student.getLName(), student.getAge(), student.getBranch(),
                    student.getYear(), student.getSemester(), student.getPhone_no(), id);

            updateCourse(student, id);
            return student;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    //<----------delete student--------->
    @Override
    public String deleteStudent(int id) {
        try {
            String query = "delete from course where student_id = ?; delete from student where student_id = ?";
            jdbcTemplate.update(query, id, id);
            return "Student with id = " + id + " has been deleted!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "Student with id = " + id + " doesn't deleted!";
    }

    //<-------helping method------->
    private int getIdByQuery(Student student){
        String selectStudentIdQuery = "select student_id from student where fname = ? and lname = ?";
        int studentId = jdbcTemplate.queryForObject(selectStudentIdQuery, int.class, student.getFName(), student.getLName());
        return studentId;
    }

    private void mapCourse(Student student, int studentId){
        String query = "insert into course(course_name,student_id)" + " values(?,?)";
        for(Course course: student.getCourses_name()){
            jdbcTemplate.update(query, course.getCourseName(), studentId);
        }
    }

    private List<Course> getCourseList(int studentId){
        String query = "select course_id, course_name from course where student_id = ?";
        return jdbcTemplate.query(query, (rs, rowNum) ->
                new Course(rs.getInt("course_id"), rs.getString("course_name")), studentId);
    }

    private void updateCourse(Student student, int studentId){
        String query = "update course set course_name = ? where student_id = ? and course_id = ?";
        for(Course course: student.getCourses_name()){
            jdbcTemplate.update(query, course.getCourseName(), studentId, course.getCourseId());
        }
    }


}

