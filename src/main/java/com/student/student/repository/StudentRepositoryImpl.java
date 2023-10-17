package com.student.student.repository;
import com.student.student.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate){
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }
    
    //<----------insert student--------->
    @Override
    public String insertStudent(Student student) {
        try{
            String query = "insert into student(fname, lname, age, branch, year, semester, phone_no) values('" + student.getFName() + "', '" + student.getLName() + "', "
                + student.getAge() + ", '" + student.getBranch() + "', " + student.getYear() + ", " 
                + student.getSemester() + ", '" + student.getPhone_no() + "')";
        
            jdbcTemplate.update(query);
            return "student data inserted successfully!";
        }catch(Exception ex){
            ex.printStackTrace();
            return "student data doesn't inserted!";
        }
    }
    
    //<----------insert multiple student--------->
    @Override
    public String insertMultipleStudent(List<Student> students) {
        for(Student student: students){
            insertStudent(student);
        }
        return "All student inserted successfully!";
    }

    //<----------get all student--------->
    @Override
    public List<Student> getAllStudent() {
        try{
            String query = "select * from student";
            return jdbcTemplate.query(query, new RowMapper<Student>() {
                @Override
                public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setFName(rs.getString("fname"));
                    student.setLName(rs.getString("lname"));
                    student.setAge(rs.getInt("age"));
                    student.setBranch(rs.getString("branch"));
                    student.setYear(rs.getInt("year"));
                    student.setSemester(rs.getInt("semester"));
                    student.setPhone_no(rs.getString("phone_no"));
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
            String query = "select * from student where id=?";
            return jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Student>() {
                @Override
                public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setFName(rs.getString("fname"));
                    student.setLName(rs.getString("lname"));
                    student.setAge(rs.getInt("age"));
                    student.setBranch(rs.getString("branch"));
                    student.setYear(rs.getInt("year"));
                    student.setSemester(rs.getInt("semester"));
                    student.setPhone_no(rs.getString("phone_no"));
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
            String query = "update student set fname=?, lname=?, age=?, branch=?, year=?, semester=?, phone_no=? " +
                    "where id=?";
            jdbcTemplate.update(query, student.getFName(), student.getLName(), student.getAge(), student.getBranch(),
                    student.getYear(), student.getSemester(), student.getPhone_no(), id);
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
            String query = "delete from student where id = ?";
            jdbcTemplate.update(query, id);
            return "Student with id = " + id + " has been deleted!";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "Student with id = " + id + " doesn't deleted!";
    }

}
