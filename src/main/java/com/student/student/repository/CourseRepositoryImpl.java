package com.student.student.repository;

import com.student.student.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;

@Repository
public class CourseRepositoryImpl implements CourseRepository{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public CourseRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate){
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String createCourse(Course course) {
        try{
            String query = "insert into course(course_name)" + " value(?)";
            jdbcTemplate.update(query, course.getCourseName());
            return "Course inserted successfully!";
        }catch (Exception ex){
            ex.printStackTrace();
            return "Course not inserted!";
        }
    }


//    //<----------add courses--------->
//    @Override
//    public String addCourse(Course course) {
//        try{
//            String query = "insert into course(course_name) values('" + course.getCourseName() + "')";
//            jdbcTemplate.update(query);
//            return "course add successfully!";
//        }catch(Exception ex){
//            ex.printStackTrace();
//            return "course doesn't added!";
//        }
//    }
//
//    //<----------add multiple courses--------->
//    @Override
//    public String addMultipleCourse(List<Course> courses) {
//        for(Course course: courses){
//            addCourse(course);
//        }
//        return "All student inserted successfully!";
//    }
//
//    //<----------get course list--------->
//    @Override
//    public List<Course> getAllCourse() {
//        try{
//            String query = "select * from course";
//            return jdbcTemplate.query(query, new RowMapper<Course>() {
//                @Override
//                public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
//                    Course course = new Course();
//                    course.setCourseId(rs.getInt("course_id"));
//                    course.setCourseName(rs.getString("course_name"));
//                    return course;
//                }
//            });
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    //<----------get course by id--------->
//    @Override
//    public Course getCourseById(int id) {
//        try {
//            String query = "select * from course where course_id=?";
//            return jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Course>() {
//                @Override
//                public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
//                    Course course = new Course();
//                    course.setCourseId(rs.getInt("course_id"));
//                    course.setCourseName(rs.getString("course_name"));
//                    return course;
//                }
//            });
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    //<----------update course detail--------->
//    @Override
//    public Course updateCourse(Course course, int id) {
//        try{
//            String query = "update course set course_name=? " +
//                    "where course_id=?";
//            jdbcTemplate.update(query, course.getCourseName(), id);
//            return course;
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    //<----------delete course--------->
//    @Override
//    public String deleteCourse(int id) {
//        try {
//            String query = "delete from course where course_id = ?";
//            jdbcTemplate.update(query, id);
//            return "Course with id = " + id + " has been removed!";
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return "Course with id = " + id + " doesn't Removed!";
//    }

}
